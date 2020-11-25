package com.ly.traffic.middleplatform.domain.order.entity;


import com.google.common.collect.Lists;
import com.ly.traffic.middleplatform.apt.annotation.Aggregate;
import com.ly.traffic.middleplatform.domain.createorder.entity.UnionOrderEntity;
import com.ly.traffic.middleplatform.domain.createorder.entity.ResourceConsumerOrder;
import com.ly.traffic.middleplatform.domain.createorder.entity.RevenueOrderInfo;
import com.ly.traffic.middleplatform.domain.createorder.entity.TripPassengerOrderInfo;
import com.ly.traffic.middleplatform.domain.order.repository.IOrderRepository;
import com.ly.traffic.middleplatform.domain.order.repository.persistence.OrderRepository;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.order
 * @Description: 订单聚合-聚合根
 * @date 2020/7/6 15:00
 */
@Getter
@Setter
@Aggregate(forceRewriteSuperField = true)
public class OrderAggregate extends UnionOrderEntity {
    /**
     * 订单仓储
     */
    private OrderRepository orderRepository;

    /**
     * 微信代扣状态 0-微信支付 1，2-微信代扣 3-微信代扣转微信支付
     */
    private Integer withHoldStatus;
    /**
     * 代扣失败原因
     */
    private String withHoldFailReason;

    /**
     * 扩展信息
     */
    private String extendContent;

    /**
     * 订单出行信息
     */
    private UTripOrderInfo tripOrderInfo;

    /**
     * 订单支付信息列表
     */
    private List<PayOrderInfo> payOrderInfoList;

    public OrderAggregate(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }


    /**
     * 聚合创建 ： 聚合数据准备
     * @throws Exception 1
     */
    public void create() throws Exception {
        if (StringUtils.isEmpty(this.getOrderNo())) {
            throw new Exception("主订单号不能为空！");
        }

        tripOrderInfo.setMainOrderNo(this.getOrderNo());
        long sequenceNo = System.currentTimeMillis();
        tripOrderInfo.setTripOrderNo(StringUtils.isBlank(tripOrderInfo.getTripOrderNo()) ? "TD"+sequenceNo : tripOrderInfo.getTripOrderNo());
        tripOrderInfo.setTripSerial(StringUtils.isBlank(tripOrderInfo.getTripSerial()) ? "TRIP"+sequenceNo : tripOrderInfo.getTripSerial());

        List<TripPassengerOrderInfo> tripPassengerOrderInfoList = tripOrderInfo.getTripPassengerOrderInfoList();
        for (TripPassengerOrderInfo passengerOrderInfo : tripPassengerOrderInfoList) {
            if (passengerOrderInfo instanceof UTripPassengerOrderInfo) {
                UTripPassengerOrderInfo upo = (UTripPassengerOrderInfo) passengerOrderInfo;
                upo.setMainOrderNo(this.getOrderNo());
                upo.setTripOrderNo(tripOrderInfo.getTripOrderNo());
                upo.setPassengerOrderNo(StringUtils.isBlank(upo.getPassengerOrderNo()) ? "TPD" + sequenceNo : upo.getPassengerOrderNo());
            }
        }
        List<ResourceConsumerOrder> resourceConsumerOrderList = Optional.ofNullable(this.getResourceConsumerOrderList()).orElse(Lists.newArrayList());
        for (ResourceConsumerOrder resourceConsumerOrder : resourceConsumerOrderList) {
            resourceConsumerOrder.setMainorderno(this.getOrderNo());
            resourceConsumerOrder.setTriporderno(tripOrderInfo.getTripOrderNo());
        }

        List<RevenueOrderInfo> revenueOrderInfoList = Optional.ofNullable(this.getRevenueOrderInfoList()).orElse(Lists.newArrayList());
        for (RevenueOrderInfo revenueOrderInfo : revenueOrderInfoList) {
            revenueOrderInfo.setMainorderno(this.getOrderNo());
            revenueOrderInfo.setRevenueorderno(StringUtils.isBlank(revenueOrderInfo.getRevenueorderno()) ? "REVD"+sequenceNo : revenueOrderInfo.getRevenueorderno());
        }

        this.setCreateDate(Optional.ofNullable(this.getCreateDate()).orElse(new Date()));
        this.setCreateUser(ObjectUtils.allNotNull(getCreateUser()) ? getCreateUser() : "system");
    }

    /**
     * 持久化
     *
     * @return 1
     * @throws Exception 1
     */
    public int saveToDB() throws Exception {
        create();
        return orderRepository.save(this);
    }


    /**
     * 判断当前订单是否可以被立即取消
     * @return 1
     */
    public boolean canCancelImmediately() {
        // 当前订单尚未进行“票务处理” 或者 已经是取消
        if (this.getOrderStatus() < 20 || (getOrderStatus() >= 60 && getOrderStatus() <=63)) {
            return true;
        }

        return false;
    }

    public int cancel() {
        setOrderStatus(62);

        return orderRepository.cancelUpdate(this);
    }

    /**
     * 更新占座信息
     *
     * @return 1
     */
    public int updateSeatInfo() {
        // 占座成功
        setOrderStatus(22);

        return orderRepository.updateSeatInfo(this);
    }

    /**
     * 更新票信息
     *
     * @return 1
     */
    public int updateTicketInfo(IOrderRepository orderRepository) {
        return 0;
    }

    /**
     * 更支付信息
     *
     * @return 1
     */
    public int updatePayInfo() {
        this.setOrderStatus(12);
        // 模拟更新支付信息
        System.out.println("更新支付信息");
        return 1;
    }

    /**
     * 订单是否已取消
     * @return
     */
    public boolean isCanceled() {
        return getOrderStatus() == 62;
    }
}

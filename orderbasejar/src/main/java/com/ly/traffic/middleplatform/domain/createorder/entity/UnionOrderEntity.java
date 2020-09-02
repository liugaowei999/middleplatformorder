package com.ly.traffic.middleplatform.domain.createorder.entity;


import com.ly.traffic.middleplatform.apt.annotation.Aggregate;
import com.ly.traffic.middleplatform.domain.createorder.repository.IUnionOrderRepository;
import com.ly.traffic.middleplatform.utils.http.HttpFactory;
import com.ly.traffic.middleplatform.utils.http.config.RequestContext;
import com.ly.traffic.middleplatform.utils.object.ObjectValue;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import java.util.Date;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 * 主订单表(UnionOrderEntity)实体类
 * @author gaowei.liu
 * @since 2020-08-20
 */
@Getter
@Setter
@Aggregate
@Slf4j
public class UnionOrderEntity {
    /**
     * 订单自增id（主键）
     */
    private Integer id;
    /**
     * 主订单流水号
     */
    private String orderNo;
    /**
     * 渠道: 501--微信, 852--小程序, 433--app_ios, 434--app_android, 1048--艺龙app, 596--手Q
     */
    private Integer platId;
    /**
     * 订单来源类型
     */
    private Integer sourceType;
    /**
     * 会员id
     */
    private Integer memberId;
    /**
     * 供应商订单号
     */
    private String supplierOrderNo;
    /**
     * 身份核验状态 0-无需核验 1-核验中 2-核验通过 3-核验失败
     */
    private Integer checkStatus;
    /**
     * 订单用户状态:10-待支付,11-支付中| 20-待占座,21-占座中,22-占座成功,23-占座失败| 30-待出票,31-出票中,32-出票完成,33-出票失败| 40-待退票,41-退票中,42-退票完成,43-退票失败| 50-驳回订单| 60-申请取消,61-取消中,62-已取消,63-过期取消| 70-退款中,71-已退款| 80-改签中,81-改签成功,82-改签失败| 90-已出行,91-下单失败
     */
    private Integer orderStatus;
    /**
     * 邮寄状态 1. 未邮寄; 2.已邮寄; 3.无需邮寄;0， 未知
     */
    private Integer mailStatus;
    /**
     * 客人是否付款同程 0：未付款 1：已付款
     */
    private Integer payStatus;
    /**
     * 联系人名称
     */
    private String contactName;
    /**
     * 联系人手机号
     */
    private String contactPhone;
    /**
     * 联系人email
     */
    private String contactEmail;
    /**
     * 客人应付同程总额
     */
    private Double customerTotalAmount;
    /**
     * 客人实付同程总额
     */
    private Double customerTotalPaid;
    /**
     * 票价总额
     */
    private Double ticketTotalPrice;
    /**
     * 活动立减金额
     */
    private Double reduceAmount;
    /**
     * 优惠金额
     */
    private Double discountAmount;
    /**
     * 预订标识，1-正常，2-收单
     */
    private Integer bookFlag;
    /**
     * 出票模式：0-全部锁票/占座成功后出票，1-一程出票成功后再处理另一程
     */
    private Integer issueFlag;
    /**
     * 支付方式：0-普通，1-代扣
     */
    private Integer payMode;
    /**
     * 支付过期时间
     */
    private Date validPayTime;
    /**
     * 付款方式：0--先占座后支付(微信支付)，1--先支付后占座(微信支付)
     */
    private Integer paymentType;
    /**
     * 是否合单支付: 0--非合单支付, 1--合单支付
     */
    private Integer unionPay;
    /**
     * 支付方式：0-普通，1-直连支付，2-两程分开代扣，3-两程分开代扣转两程一起支付(第一程代扣失败的场景)
     */
    private Integer directPay;
    /**
     * 订单类型：0-普通 1-火火联运，2-火空联运，3-火汽联运，4-空火联运, 5-火车直达，7-飞机直达，10-国际火空,11-汽火联运，12-火空联运（合并下单），13-空火联运（合并下单）, 14-火汽联运（合并下单）, 15-汽火联运（合并下单）, 16-九龙联运，17-火车抢票(火车+抢票&上车补票), 18-空空联运, 19-机场大巴+飞机, 20-飞机+机场大巴 21-火车+抢票/预约（分销） 22-火车+抢票/预约（直销） 23-抢票+抢票 24-汽车+汽车 25-抢票+火车 26-配送票+配送票 27-火车+港铁 28-火车+城际（分开下单）29-12306分开下单 30-有票+抢票 31 抢票+抢票 32 新电子客票
     备注：以下类型当前库中已不存在（
     6-汽车直达， 8-用车直达，9-城际接驳直达）
     */
    private Integer productType;
//    /**
//     * 微信代扣状态 0-微信支付 1，2-微信代扣 3-微信代扣转微信支付
//     */
//    private Integer withHoldStatus;
//    /**
//     * 代扣失败原因
//     */
//    private String withHoldFailReason;
    /**
     * refid
     */
    private Integer refId;
    /**
     * 记录用户unionid
     */
    private String unionId;
    /**
     * openid，微信平台订票时有值
     */
    private String openId;

    /**
     * 点击预定按钮时间
     */
    private Date userCreateDate;
    /**
     * 创建日期
     */
    private Date createDate;
    /**
     * 创建人
     */
    private String createUser;
    /**
     * 更新日期
     */
    private Date updateDate;
    /**
     * 更新人
     */
    private String updateUser;

    /**
     * 订单出行信息
     */
    private TripOrderInfo tripOrderInfo;

    /**
     * 权益消费申请信息
     */
    private List<ResourceConsumerOrder> resourceConsumerOrderList;

    /**
     * 订单营收商品列表
     */
    private List<RevenueOrderInfo> revenueOrderInfoList;


    private String translate() {
        try {
            return ObjectValue.getJSONString(this.getClass(), this);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return super.toString();
    }
    @Override
    public String toString() {
        return translate();
    }

    public void save() {
        save(null);
    }

    public void save(IUnionOrderRepository orderRepository) {
        // 业务线内数据持久化
        if (orderRepository != null) {
            orderRepository.save(this);
        }

        // 异步持久化数据到中台
        log.info("开始异步持久化数据到中台 ......");
        ICreateOrderRepository.save(this);
    }

    interface ICreateOrderRepository {
        default void save() {
            save(this);
//        return null;
        }

        static void save(Object obj) {
            String data = obj.toString();
            System.out.println("create: " + data);

//        HttpUill.post(url, data)

            RequestContext requestContext = new RequestContext("http://localhost:8096/order/save");
            requestContext.setRequestBody(data);
            CompletableFuture<String> result = HttpFactory.httpAsyncClientFactory.post(requestContext);
            result.whenComplete((r,e) -> {
                System.out.println("结果：" + r);
                if (e != null) {
                    e.printStackTrace();
                }
            });
//        return null;
        }
    }
}

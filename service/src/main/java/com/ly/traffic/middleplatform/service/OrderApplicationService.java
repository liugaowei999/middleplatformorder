package com.ly.traffic.middleplatform.service;

import com.alibaba.fastjson.JSON;
import com.ly.traffic.middleplatform.domain.cancelorder.entity.CancelAggregate;
import com.ly.traffic.middleplatform.domain.cancelorder.repository.persistence.CancelRepository;
import com.ly.traffic.middleplatform.domain.cancelorder.service.CancelDomainService;
import com.ly.traffic.middleplatform.domain.order.entity.OrderAggregate;
import com.ly.traffic.middleplatform.domain.order.repository.persistence.OrderRepository;
import com.ly.traffic.middleplatform.domain.order.repository.po.MainOrderPO;
import com.ly.traffic.middleplatform.domain.order.service.OrderDomainService;
import com.ly.traffic.middleplatform.domain.paycallback.PayCallBackDomainService;
import com.ly.traffic.middleplatform.domain.paycallback.entity.PayWriteBackLog;
import com.ly.traffic.middleplatform.infrastructure.common.Result;
import com.ly.traffic.middleplatform.infrastructure.common.ResultCode;
import com.ly.traffic.middleplatform.interfaces.dto.PaidInfoDto;
import com.ly.traffic.middleplatform.service.assembler.OrderAssembler;
import com.ly.traffic.middleplatform.interfaces.dto.CancelOrderRequestDto;
import com.ly.traffic.middleplatform.interfaces.dto.CreateOrderRequestDto;
import com.ly.traffic.middleplatform.service.assembler.PayBackAssembler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.service
 * @Description: 订单应用服务
 * @date 2020/8/20 14:16
 */
@Slf4j
@Service
public class OrderApplicationService {
    @Resource
    private OrderRepository orderRepository;

    @Resource
    private CancelRepository cancelRepository;

    @Resource
    private OrderDomainService orderDomainService;

    @Resource
    private CancelDomainService cancelDomainService;

    @Resource
    private PayCallBackDomainService payCallBackDomainService;

    @Transactional(rollbackFor = Exception.class)
    public int createOrder(CreateOrderRequestDto order) throws Exception {
        OrderAggregate orderAggregate = new OrderAggregate(orderRepository);
        OrderAssembler.dtoToDo(order, orderAggregate);

        return orderDomainService.create(orderAggregate);
    }

    /**
     * 更新购买订单的支付状态
     * @param paidInfoDto 1
     * @return 1
     * @throws Exception 1
     */
    public Result updatePayInfo(PaidInfoDto paidInfoDto) throws Exception {
        Result result = new Result(ResultCode.OK);
        result.setMsg("更新支付信息成功");

        // 获取购买订单聚合根信息
        OrderAggregate orderAggregate = orderRepository.queryByMainOrderNo(paidInfoDto.getMainOrderNo());
        if (orderAggregate.isCanceled()) {
            // 订单已取消， 走退款
            result.setMsg("订单已取消，");
            return result;
        }
        // 更新支付信息 paidInfoDto
        orderDomainService.updatePayInfo(orderAggregate);
        return result;
    }

    /**
     * 支付回调处理
     * @param paidInfoDto 1
     * @return 1
     * @throws Exception 1
     */
    public Result payCallBack(PaidInfoDto paidInfoDto) throws Exception {
        Result result = new Result(ResultCode.OK);
        log.info("[支付回调聚合] - 记录支付记录日志完成");

        PayWriteBackLog payWriteBackLog = PayBackAssembler.dtoToDo(paidInfoDto);

        // 记录支付日志，发送支付信息更新通知
        payCallBackDomainService.payLog(payWriteBackLog);

        return result;
    }


    /**
     * 取消订单
     *
     * @return 1
     * @param cancelOrderRequestDto 1
     */
    @Transactional(rollbackFor = Exception.class)
    public Result cancelOrder(CancelOrderRequestDto cancelOrderRequestDto) {
        Result result = new Result(ResultCode.OK);
        result.setMsg("订单取消中 ...");
        CancelAggregate cancelAggregate = new CancelAggregate(cancelRepository);
        OrderAssembler.dtoToDo(cancelOrderRequestDto, cancelAggregate);
        result = cancelDomainService.doCancelOrder(cancelAggregate);
        return result;
    }


    public MainOrderPO queryById(String orderNo) {
        MainOrderPO mainOrderPO = orderRepository.queryById(orderNo);
        System.out.println(JSON.toJSONString(mainOrderPO));
        return mainOrderPO;
    }

}

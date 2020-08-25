package com.ly.traffic.middleplatform.service;

import com.alibaba.fastjson.JSON;
import com.ly.traffic.middleplatform.domain.cancelorder.entity.CancelAggregate;
import com.ly.traffic.middleplatform.domain.cancelorder.repository.persistence.CancelRepository;
import com.ly.traffic.middleplatform.domain.cancelorder.service.CancelDomainService;
import com.ly.traffic.middleplatform.domain.order.entity.OrderAggregate;
import com.ly.traffic.middleplatform.domain.order.repository.persistence.OrderRepository;
import com.ly.traffic.middleplatform.domain.order.repository.po.MainOrderPO;
import com.ly.traffic.middleplatform.domain.order.service.OrderDomainService;
import com.ly.traffic.middleplatform.infrastructure.common.Result;
import com.ly.traffic.middleplatform.infrastructure.common.ResultCode;
import com.ly.traffic.middleplatform.service.assembler.OrderAssembler;
import com.ly.traffic.middleplatform.interfaces.dto.CancelOrderRequestDto;
import com.ly.traffic.middleplatform.interfaces.dto.CreateOrderRequestDto;
import lombok.extern.slf4j.Slf4j;
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

    @Transactional(rollbackFor = Exception.class)
    public int createOrder(CreateOrderRequestDto order) throws Exception {
        OrderAggregate orderAggregate = OrderAssembler.dtoToDo(order);

        return orderDomainService.create(orderAggregate);
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
        CancelAggregate cancelAggregate = OrderAssembler.dtoToDo(cancelOrderRequestDto);
        // 申请取消
        cancelAggregate.setStatus(0);

        // 获取购买订单聚合根信息
        OrderAggregate orderAggregate = orderRepository.queryByMainOrderNo(cancelAggregate.getMainOrderNo());
        if (orderAggregate.canCancelImmediately()) {
            // 可以立即取消
            int count = orderDomainService.cancel(orderAggregate);
            if (count > 0) {
                // 取消成功
                cancelAggregate.setStatus(2);
                result.setMsg("取消成功");
            }
        } else {
            // 不能立即做取消操作， 异步处理状态：取消中
            cancelAggregate.setStatus(1);
            // 异步发起取消票务任务
            log.info("异步发起取消票务任务");
            cancelDomainService.cancelTicketTaskAsync(cancelAggregate);
        }
        cancelRepository.save(cancelAggregate);

        return result;
    }


    public MainOrderPO queryById(Integer id) {
        MainOrderPO mainOrderPO = orderRepository.queryById(id);
        System.out.println(JSON.toJSONString(mainOrderPO));
        return mainOrderPO;
    }

}

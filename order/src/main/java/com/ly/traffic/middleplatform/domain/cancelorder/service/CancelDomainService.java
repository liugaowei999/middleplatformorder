package com.ly.traffic.middleplatform.domain.cancelorder.service;

import com.ly.traffic.middleplatform.domain.cancelorder.entity.CancelAggregate;
import com.ly.traffic.middleplatform.domain.cancelorder.repository.persistence.CancelRepository;
import com.ly.traffic.middleplatform.domain.order.entity.OrderAggregate;
import com.ly.traffic.middleplatform.domain.order.repository.persistence.OrderRepository;
import com.ly.traffic.middleplatform.domain.order.service.OrderDomainService;
import com.ly.traffic.middleplatform.infrastructure.common.Result;
import com.ly.traffic.middleplatform.infrastructure.common.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.cancelorder.service
 * @Description: ${TODO}
 * @date 2020/8/25 15:11
 */
@Service
@Slf4j
public class CancelDomainService {
    @Resource
    private CancelTicketService cancelTicketService;

    @Resource
    private OrderDomainService orderDomainService;

    @Resource
    private OrderRepository orderRepository;

    @Resource
    private CancelRepository cancelRepository;

    /**
     * 异步发起取消"票务"任务
     * @param cancelAggregate
     */
    public void cancelTicketTaskAsync(CancelAggregate cancelAggregate) {
        cancelTicketService.sendTicketTaskCancelRequest(cancelAggregate);
    }

    public void cancelTicketCallBack(String mainOrderNo) {
        log.info("[取消订单任务聚合] - 开始取消...");


    }

    public Result doCancelOrder(CancelAggregate cancelAggregate) {
        Result result = new Result(ResultCode.OK);
        log.info("[取消订单任务聚合] - 开始取消...");
        // 获取购买订单聚合根信息
        OrderAggregate orderAggregate = orderRepository.queryByMainOrderNo(cancelAggregate.getMainOrderNo());
        log.info("[取消订单任务聚合] - 根据订单号获取订单聚合的聚合根实体...");
        log.info("[取消订单任务聚合] - 检查当前订单是否可以立即取消...");
        if (orderAggregate.isCanceled()) {
            result.setMsg("取消成功");
            return result;
        }

        if (orderAggregate.canCancelImmediately()) {
            // 可以立即取消
            log.info("[取消订单任务聚合] - 可以立即取消...");
            int count = orderDomainService.cancel(orderAggregate);
            if (count > 0) {
                // 取消成功
                cancelAggregate.setStatus(2);
                result.setMsg("取消成功");

            }
        } else {
            log.info("[取消订单任务聚合] - 订单已经进行票务处理，不能立即取消...");
            // 不能立即做取消操作， 异步处理状态：取消中
            cancelAggregate.setStatus(1);
            // 异步发起取消票务任务
            log.info("[取消订单任务聚合] -异步发起取消票务任务");
            cancelTicketTaskAsync(cancelAggregate);
        }
        // 持久化取消订单任务记录
        cancelAggregate.save();
        return result;
    }
}

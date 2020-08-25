package com.ly.traffic.middleplatform.domain.order.service;

import com.alibaba.fastjson.JSON;
import com.ly.traffic.middleplatform.domain.order.entity.OrderAggregate;
import com.ly.traffic.middleplatform.domain.order.event.OrderEvent;
import com.ly.traffic.middleplatform.domain.order.event.publish.OrderEventPublish;
import com.ly.traffic.middleplatform.domain.order.repository.persistence.OrderRepository;
import com.ly.traffic.middleplatform.event.EventType;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.domain.order.service
 * @Description: 订单领域服务
 * @date 2020/8/25 14:55
 */
@Slf4j
@Service
public class OrderDomainService {
    @Resource
    private OrderRepository orderRepository;

    @Resource
    private OrderEventPublish orderEventPublish;


    public int cancel(OrderAggregate orderAggregate) {
        int count = orderAggregate.cancel(orderRepository);
        if (count <= 0) {
            return count;
        }

        // 取消成功事件发布
        // 领域事件持久化
        OrderEvent orderEvent = OrderEvent.create("cancel")
                .setOrderNo(orderAggregate.getOrderNo())
                .setDataSnapshot(JSON.toJSONString(orderAggregate))
                .setEventType(EventType.CANCELED);
        orderRepository.saveOrderEvent(orderEvent);

        // 事件发布
        log.info("发布事件:类型：{}， 内容:{}", orderEvent.getEventType(), JSON.toJSONString(orderEvent));
        orderEventPublish.publish(orderEvent);
        return count;
    }

    /**
     * 创建订单
     * @param orderAggregate 1
     * @return 1
     * @throws Exception 1
     */
    public int create(OrderAggregate orderAggregate) throws Exception {
        // 持久化方式1：
        orderAggregate.create();
        int saveCount = orderRepository.save(orderAggregate);

        // 持久化方式2：不推荐
        // int saveCount = orderAggregate.saveToDB(orderRepository);

        if (saveCount <= 0) {
            return saveCount;
        }
        // 领域事件持久化
        OrderEvent orderEvent = OrderEvent.create("createOrder")
                .setOrderNo(orderAggregate.getOrderNo())
                .setDataSnapshot(JSON.toJSONString(orderAggregate))
                .setEventType(EventType.NEW_CREATED);
        orderRepository.saveOrderEvent(orderEvent);

        // 事件发布
        log.info("发布事件:类型：{}， 内容:{}", orderEvent.getEventType(), JSON.toJSONString(orderEvent));
        orderEventPublish.publish(orderEvent);
        return saveCount;
    }
}

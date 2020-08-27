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

    /**
     * 创建订单
     * @param orderAggregate 1
     * @return 1
     * @throws Exception 1
     */
    public int create(OrderAggregate orderAggregate) throws Exception {
        log.info("[订单聚合-创建订单] 创建订单聚合根实体...");
        // 持久化方式1：
        orderAggregate.create();
        int saveCount = orderRepository.save(orderAggregate);

        // 持久化方式2：不推荐
        // int saveCount = orderAggregate.saveToDB(orderRepository);

        if (saveCount <= 0) {
            return saveCount;
        }
        log.info("[订单聚合-创建订单] 持久化订单聚合根实体...");
        log.info("[订单聚合-创建订单] 持久化订单创建事件快照信息...");
        // 领域事件持久化
        OrderEvent orderEvent = OrderEvent.create("createOrder")
                .setOrderNo(orderAggregate.getOrderNo())
                .setBypassId(orderAggregate.getMemberId())
                .setDataSnapshot(JSON.toJSONString(orderAggregate))
                .setEventType(EventType.NEW_CREATED);
        orderRepository.saveOrderEvent(orderEvent);

        // 事件发布
        log.info("[订单聚合-创建订单] 发布创单成功事件:类型：{}， 内容:{}", orderEvent.getEventType(), JSON.toJSONString(orderEvent));
        orderEventPublish.publish(orderEvent);
        return saveCount;
    }

    /**
     * 更新购买订单占座信息
     * @param orderAggregate 1
     * @return 1
     * @throws Exception 1
     */
    public int updateSeatInfo(OrderAggregate orderAggregate) throws Exception {
        int saveCount = orderAggregate.updateSeatInfo(orderRepository);

        if (saveCount <= 0) {
            return saveCount;
        }
        // 领域事件持久化
        OrderEvent orderEvent = OrderEvent.create("createOrder")
                .setOrderNo(orderAggregate.getOrderNo())
                .setBypassId(orderAggregate.getMemberId())
                .setDataSnapshot(JSON.toJSONString(orderAggregate))
                .setEventType(EventType.LOCK_SUCCESS);
        orderRepository.saveOrderEvent(orderEvent);

        // 事件发布
        log.info("发布事件:类型：{}， 内容:{}", orderEvent.getEventType(), JSON.toJSONString(orderEvent));
        orderEventPublish.publish(orderEvent);
        return saveCount;
    }

    /**
     * 更新购买订单的支付状态
     * @param orderAggregate 1
     * @return 1
     * @throws Exception 1
     */
    public int updatePayInfo(OrderAggregate orderAggregate) throws Exception {
        int saveCount = orderAggregate.updatePayInfo(orderRepository);

        if (saveCount <= 0) {
            return saveCount;
        }
        log.info("[订单聚合-更新支付信息] 更新支付信息成功");
        // 领域事件持久化
        OrderEvent orderEvent = OrderEvent.create("updatePayInfo")
                .setOrderNo(orderAggregate.getOrderNo())
                .setBypassId(orderAggregate.getMemberId())
                .setDataSnapshot(JSON.toJSONString(orderAggregate))
                .setEventType(EventType.PAID_SUCCESS);
        orderRepository.saveOrderEvent(orderEvent);

        // 支付成功事件发布
        log.info("[订单聚合-更新支付信息] 发布支付成功事件:类型：{}， 内容:{}", orderEvent.getEventType(), JSON.toJSONString(orderEvent));
        orderEventPublish.publish(orderEvent);
        return saveCount;
    }

    /**
     * 更新购买订单为取消状态
     * @param orderAggregate   1
     * @return 1
     */
    public int cancel(OrderAggregate orderAggregate) {
        log.info("[订单聚合 - 取消更新] - 开始更新订单状态为取消...");
        int count = orderAggregate.cancel(orderRepository);
        if (count <= 0) {
            // 已发起占座或出票等票务操作时，状态无法更新为取消
            return count;
        }
        log.info("[订单聚合 - 取消更新] - 更新订单状态为取消成功...");

        // 取消成功事件发布
        // 领域事件持久化
        log.info("[订单聚合 - 取消更新] - 持久化订单取消事件快照...");
        OrderEvent orderEvent = OrderEvent.create("cancel")
                .setOrderNo(orderAggregate.getOrderNo())
                .setBypassId(orderAggregate.getMemberId())
                .setDataSnapshot(JSON.toJSONString(orderAggregate))
                .setEventType(EventType.CANCELED);
        orderRepository.saveOrderEvent(orderEvent);

        // 事件发布
        log.info("[订单聚合 - 取消更新] 发布订单成功取消事件:类型：{}， 内容:{}", orderEvent.getEventType(), JSON.toJSONString(orderEvent));
        orderEventPublish.publish(orderEvent);
        return count;
    }


}

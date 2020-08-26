package com.ly.traffic.middleplatform.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.eventbus.Subscribe;
import com.ly.traffic.middleplatform.domain.createorder.entity.MainOrder;
import com.ly.traffic.middleplatform.event.EventType;
import com.ly.traffic.middleplatform.strategy.handler.AbstractStrategyHandler;
import com.ly.traffic.middleplatform.strategy.StrategyManger;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liugw
 * @Package com.ly.intercity.motor.ddd.order.infrastructure.eventbus
 * @Description: 主流程示例
 * @date 2020/3/30 19:27
 */
@Slf4j
public class MainProcessorListenerExample {

    @Subscribe
    public void resourceService(String orderEvent) {
        OrderEvent event = JSONObject.parseObject(orderEvent, OrderEvent.class);
        log.info("[资源中心-营收商品订单购买] 收到订单事件，事件类型：{}, 内容:{}", event.getEventType(), JSON.toJSONString(event));

        MainOrder orderEntity = JSONObject.parseObject(event.getDataSnapshot(), MainOrder.class);

        // 收到事件消息后， 触发下面的操作
        AbstractStrategyHandler strategy = StrategyManger.getStrategy(orderEntity);

        strategy.process(event.getEventType(), orderEntity);
    }
}

package com.ly.traffic.middleplatform.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liugw
 * @Package com.ly.intercity.motor.ddd.order.infrastructure.eventbus
 * @Description: ${TODO}
 * @date 2020/3/30 19:27
 */
@Slf4j
public class OrderEventListenerExample {
    @Subscribe
    public void messageCenterService(String event) {
        OrderEvent orderEvent = JSONObject.parseObject(event, OrderEvent.class);
        log.info("[消息中心-为用户发送创单成功通知] 收到订单事件，事件类型：{}, 内容:{}", orderEvent.getEventType(), JSON.toJSONString(orderEvent));
    }

    @Subscribe
    public void resourceService(OrderEvent event) {
        log.info("[资源中心-营收商品订单购买] 收到订单事件，事件类型：{}, 内容:{}", event.getEventType(), JSON.toJSONString(event));
    }
}

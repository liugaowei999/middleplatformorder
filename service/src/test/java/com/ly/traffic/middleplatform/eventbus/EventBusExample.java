package com.ly.traffic.middleplatform.eventbus;

import com.google.common.eventbus.EventBus;

/**
 * @author liugw
 * @Package com.ly.intercity.motor.ddd.order.infrastructure.eventbus
 * @Description: ${TODO}
 * @date 2020/3/30 19:26
 */
public class EventBusExample {
    public static void main(String[] args) {
        EventBus eventBus = new EventBus();
        eventBus.register(new ListenerExample());

        eventBus.post("Test event content!");
    }
}

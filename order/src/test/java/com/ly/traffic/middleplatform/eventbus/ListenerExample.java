package com.ly.traffic.middleplatform.eventbus;

import com.google.common.eventbus.Subscribe;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liugw
 * @Package com.ly.intercity.motor.ddd.order.infrastructure.eventbus
 * @Description: ${TODO}
 * @date 2020/3/30 19:27
 */
@Slf4j
public class ListenerExample {
    @Subscribe
    public void doAction(String event) {
        log.info("收到event:{}", event);
    }
}

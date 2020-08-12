package com.ly.traffic.middleplatform.infrastructure.eventbus;

public interface LocalEventBus {
    void post(Event event);
}

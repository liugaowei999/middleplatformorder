package com.ly.traffic.middleplatform.infrastructure.eventbus;

public interface Event<T> {
    T getContent();
}

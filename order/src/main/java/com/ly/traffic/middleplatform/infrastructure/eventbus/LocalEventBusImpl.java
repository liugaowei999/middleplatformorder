package com.ly.traffic.middleplatform.infrastructure.eventbus;

import com.google.common.eventbus.AsyncEventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocalEventBusImpl implements LocalEventBus {

    @Autowired
    private AsyncEventBus eventBus;

    @Override
    public void post(Event event) {
        if (null != event) {
            eventBus.post(event);
        }
    }
}

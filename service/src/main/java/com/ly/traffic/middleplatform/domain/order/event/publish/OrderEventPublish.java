package com.ly.traffic.middleplatform.domain.order.event.publish;


import com.google.common.eventbus.EventBus;
import com.ly.traffic.middleplatform.domain.order.event.OrderEvent;
import com.ly.traffic.middleplatform.test.simulator.OrderEventListenerExample;
import com.ly.traffic.middleplatform.test.simulator.TicketServiceListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * 订单事件发送MQ
 *
 * @author liugw
 * @date 2020/08/21
 */
@Service
public class OrderEventPublish {
    private static final Logger logger = LoggerFactory.getLogger(OrderEventPublish.class);

    private EventBus eventBus;

    public OrderEventPublish() {
        eventBus = new EventBus();
        eventBus.register(new OrderEventListenerExample());
        eventBus.register(new TicketServiceListener());
    }

    public void publish(OrderEvent orderEvent) {
        eventBus.post(orderEvent);
    }

}

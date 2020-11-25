package com.ly.traffic.middleplatform.domain.cancelorder.service;


import com.google.common.eventbus.EventBus;
import com.ly.traffic.middleplatform.domain.cancelorder.entity.CancelAggregate;
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
public class CancelTicketService {
    private static final Logger logger = LoggerFactory.getLogger(CancelTicketService.class);

    private EventBus eventBus;

    public CancelTicketService() {
        eventBus = new EventBus();
        eventBus.register(new TicketServiceListener());
    }

    public void sendTicketTaskCancelRequest(CancelAggregate orderEvent) {
        eventBus.post(orderEvent);
    }

}

package com.ly.traffic.middleplatform.domain.paycallback.event.publish;


import com.alibaba.fastjson.JSON;
import com.google.common.eventbus.AsyncEventBus;
import com.ly.traffic.middleplatform.demo.MainProcessorListenerExample;
import com.ly.traffic.middleplatform.domain.order.event.publish.OrderEventPublish;
import com.ly.traffic.middleplatform.domain.order.event.subscribe.OrderProcessListener;
import com.ly.traffic.middleplatform.domain.paycallback.entity.PayWriteBackLog;
import com.ly.traffic.middleplatform.domain.paycallback.event.OrderEvent;
import com.ly.traffic.middleplatform.test.simulator.SecondProcessorListener;
import com.ly.traffic.middleplatform.test.simulator.TicketServiceListener;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.Executors;

/**
 * 订单事件发送MQ
 *
 * @author liugw
 * @date 2020/08/21
 */
@Slf4j
@Service
public class PaidSuccessPublish {
    private static final Logger logger = LoggerFactory.getLogger(OrderEventPublish.class);

    private AsyncEventBus eventBus = new AsyncEventBus(Executors.newFixedThreadPool(2));

    @Autowired
    public PaidSuccessPublish(OrderProcessListener orderProcessListener) {
        this.eventBus.register(orderProcessListener);
    }

    public void publish(PayWriteBackLog payWriteBackLog) {
        log.info("[支付回调处理] - 异步发布订单更新支付信息命令");
        eventBus.post(JSON.toJSONString(payWriteBackLog));
    }

}

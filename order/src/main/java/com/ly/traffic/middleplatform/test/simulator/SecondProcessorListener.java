package com.ly.traffic.middleplatform.test.simulator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.eventbus.Subscribe;
import com.ly.traffic.middleplatform.demo.OrderEvent;
import com.ly.traffic.middleplatform.event.EventType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.test.simulator
 * @Description: 副线业务处理模拟
 * @date 2020/8/26 11:39
 */
@Slf4j
public class SecondProcessorListener {
    @Subscribe
    public void messageCenterService(String event) throws InterruptedException {
        OrderEvent orderEvent = JSONObject.parseObject(event, OrderEvent.class);
        log.info("[消息中心微服务模拟] 收到订单事件，事件类型：{}, 内容:{}", orderEvent.getEventType(), JSON.toJSONString(orderEvent));
        Thread.sleep(RandomUtils.nextInt(1000,5000));
        log.info("[消息中心微服务模拟] 开始发送通知..., ThreadId:{}", Thread.currentThread().getId());
        Thread.sleep(RandomUtils.nextInt(1000,5000));
        log.info("[消息中心微服务模拟] 发送通知成功, ThreadId:{}", Thread.currentThread().getId());
    }

    @Subscribe
    public void FinanceService(String event) throws InterruptedException {
        OrderEvent orderEvent = JSONObject.parseObject(event, OrderEvent.class);
        if (orderEvent.getEventType() != EventType.PAID_SUCCESS && orderEvent.getEventType() != EventType.CANCELED) {
            return;
        }
        log.info("[财务中心微服务模拟] 收到订单事件，事件类型：{}, 内容:{}", orderEvent.getEventType(), JSON.toJSONString(orderEvent));
        Thread.sleep(RandomUtils.nextInt(1000,5000));
        log.info("[财务中心微服务模拟] 开始同步财务..., ThreadId:{}", Thread.currentThread().getId());
        Thread.sleep(RandomUtils.nextInt(1000,5000));
        log.info("[财务中心微服务模拟] 同步财务成功, ThreadId:{}", Thread.currentThread().getId());
    }

    public static void main(String[] args) {
        int i = RandomUtils.nextInt(1000, 5000);
        System.out.println(i);
    }
}

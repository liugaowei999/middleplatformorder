package com.ly.traffic.middleplatform.demo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.eventbus.Subscribe;
import com.ly.traffic.middleplatform.demo.streamcontrol.ByPassFlowControlTest;
import com.ly.traffic.middleplatform.domain.createorder.entity.UnionOrderEntity;
import com.ly.traffic.middleplatform.strategy.AbstractStrategy;
import com.ly.traffic.middleplatform.strategy.selector.StrategySelectorDemo;
import com.ly.traffic.middleplatform.test.TestSimulation;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;

/**
 * @author liugw
 * @Package com.ly.intercity.motor.ddd.order.infrastructure.eventbus
 * @Description: 流程引擎 - 【事件消费者实现模拟】主流程示例
 * @date 2020/3/30 19:27
 */
@Slf4j
public class MainProcessorListenerExample {

    @Subscribe
    public void resourceService(String orderEvent) throws UnsupportedEncodingException {
        OrderEvent event = JSONObject.parseObject(orderEvent, OrderEvent.class);
        log.info("[流程引擎-主流程] 收到订单事件，事件类型：{}, 内容:{}", event.getEventType(), JSON.toJSONString(event));
        String whoControl = ByPassFlowControlTest.whoControl(event);
        if (!"MIDDLE_PLATFORM".equalsIgnoreCase(whoControl)) {
            // 数据透传 中台
            log.info("[流程引擎-主流程] 数据透传 - 异步自动转发给中台，中台做数据更新，维护数据最终一致性。");
            TestSimulation.sendData(orderEvent);
        }

        UnionOrderEntity orderEntity = JSONObject.parseObject(event.getDataSnapshot(), UnionOrderEntity.class);

        // 收到事件消息后， 触发下面的操作
        AbstractStrategy strategy = StrategySelectorDemo.getInstance().getStrategy(orderEntity);

        strategy.process(event.getEventType(), orderEntity);
    }
}

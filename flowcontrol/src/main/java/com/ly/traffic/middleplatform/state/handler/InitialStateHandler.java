package com.ly.traffic.middleplatform.state.handler;


import com.ly.traffic.middleplatform.demo.condition.FlowConditionDemo;
import com.ly.traffic.middleplatform.domain.createorder.entity.UnionOrderEntity;
import com.ly.traffic.middleplatform.event.EventType;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.State
 * @Description: ${TODO}
 * @date 2020/7/22 16:33
 */
@Slf4j
public class InitialStateHandler extends AbstractStateHandler<UnionOrderEntity, EventType>  {

    @Override
    public void handler(UnionOrderEntity orderEntity) {
        // do nothing
        log.info("创建订单完成");
    }

}

package com.ly.traffic.middleplatform.state.handler;


import com.ly.traffic.middleplatform.demo.condition.FlowConditionDemo;
import com.ly.traffic.middleplatform.domain.createorder.entity.UnionOrderEntity;
import com.ly.traffic.middleplatform.event.EventType;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.State
 * @Description: ${TODO}
 * @date 2020/7/22 15:40
 */
public class LockFailedStateHandler extends AbstractStateHandler<UnionOrderEntity, EventType>  {

    @Override
    public void handler(UnionOrderEntity orderEntity) {

    }
}

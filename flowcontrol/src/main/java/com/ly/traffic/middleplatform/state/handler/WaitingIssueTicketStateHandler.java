package com.ly.traffic.middleplatform.state.handler;


import com.ly.traffic.middleplatform.demo.condition.FlowConditionDemo;
import com.ly.traffic.middleplatform.domain.createorder.entity.UnionOrderEntity;
import com.ly.traffic.middleplatform.event.EventType;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.State
 * @Description: ${TODO}
 * @date 2020/7/22 15:38
 */
public class WaitingIssueTicketStateHandler extends AbstractStateHandler<UnionOrderEntity, EventType>  {

    @Override
    public void handler(UnionOrderEntity orderEntity) {
        // 更新为 待出票状态

        // 发送票务中心 出票命令


    }
}

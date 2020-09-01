package com.ly.traffic.middleplatform.state.handler;


import com.ly.traffic.middleplatform.demo.condition.FlowConditionDemo;
import com.ly.traffic.middleplatform.domain.createorder.entity.UnionOrderEntity;
import com.ly.traffic.middleplatform.event.EventType;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.State
 * @Description: 未知（异常）状态处理
 * @date 2020/7/22 13:53
 */
@Slf4j
public class UnknownStateHandler extends AbstractStateHandler<UnionOrderEntity, EventType>  {
    private static UnknownStateHandler instance = new UnknownStateHandler();
    public static UnknownStateHandler getInstance() {
        return instance;
    }

    @Override
    public void handler(UnionOrderEntity orderEntity) {
        // 写入“死信队列” 记录异常日志
        log.error("【流程引擎-主流程】未知状态：写入“死信队列” 记录异常日志, orderNo:{}, status:{}", orderEntity.getOrderNo(), orderEntity.getOrderStatus());
    }
}

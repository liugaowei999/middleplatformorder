package com.ly.traffic.middleplatform.strategy;


import com.ly.traffic.middleplatform.event.EventType;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.strategy
 * @Description: ${TODO}
 * @date 2020/7/22 14:40
 */
public class StrategyManger {

    public static void main(String[] args) {
        StrategyManger strategyManger = new StrategyManger();
//        OrderAggregate orderEntity = new OrderAggregate();
//
//        // 收到事件消息后， 触发下面的操作
//        AbstractStrategyHandler strategy = strategyManger.getStrategy(orderEntity);
//        EventType event = EventType.LOCK_FAILED;
//
//        strategy.process(event, orderEntity);
    }

    private AbstractStrategyHandler getStrategy(Object orderEntity) {
        // 根据条件选择一个策略处理器
        AbstractStrategyHandler testStrategy = new SingleTripPayFirstStrategyHandler();
        return testStrategy;
    }
}

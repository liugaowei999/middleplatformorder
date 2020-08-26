package com.ly.traffic.middleplatform.strategy;


import com.ly.traffic.middleplatform.condition.ConditionDemo;
import com.ly.traffic.middleplatform.domain.createorder.entity.MainOrder;
import com.ly.traffic.middleplatform.strategy.handler.AbstractStrategyHandler;
import com.ly.traffic.middleplatform.strategy.handler.SingleTripPayFirstStrategyHandler;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.strategy
 * @Description: ${TODO}
 * @date 2020/7/22 14:40
 */
public class StrategyManger {
    private StrategyManger() {}

    public static AbstractStrategyHandler getStrategy(MainOrder orderEntity) {
        Boolean payFirst = ConditionDemo.judgeCondition(orderEntity);
        // 根据条件选择一个策略处理器
        AbstractStrategyHandler testStrategy = null;
        if (payFirst) {
            // 先支付后占座
            testStrategy = SingleTripPayFirstStrategyHandler.getInstance();
        } else {
            // 先占座后支付
            testStrategy = SingleTripPayFirstStrategyHandler.getInstance();
        }
        return testStrategy;
    }
}

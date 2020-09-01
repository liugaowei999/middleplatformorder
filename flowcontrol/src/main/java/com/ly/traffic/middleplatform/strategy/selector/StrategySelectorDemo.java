package com.ly.traffic.middleplatform.strategy.selector;


import com.ly.traffic.middleplatform.demo.condition.ConditionDemo;
import com.ly.traffic.middleplatform.domain.createorder.entity.UnionOrderEntity;
import com.ly.traffic.middleplatform.strategy.AbstractStrategy;
import com.ly.traffic.middleplatform.strategy.SingleTripPayFirstStrategyDemo;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.strategy
 * @Description: ${TODO}
 * @date 2020/7/22 14:40
 */
public class StrategySelectorDemo implements IStrategySeletor<ConditionDemo, UnionOrderEntity> {
    private static StrategySelectorDemo instace = new StrategySelectorDemo();
    private static ConditionDemo conditionContainer = new ConditionDemo();

    private StrategySelectorDemo() {
    }

    public static StrategySelectorDemo getInstance() {
        return instace;
    }

    @Override
    public AbstractStrategy getStrategy(UnionOrderEntity orderEntity) {
        Boolean payFirst = conditionContainer.valid("payFirstJudge", orderEntity);

        // 根据条件选择一个策略处理器
        AbstractStrategy testStrategy = null;
        if (payFirst) {
            // 先支付后占座
            testStrategy = SingleTripPayFirstStrategyDemo.getInstance();
        } else {
            // 先占座后支付
            testStrategy = SingleTripPayFirstStrategyDemo.getInstance();
        }
        return testStrategy;
    }
}

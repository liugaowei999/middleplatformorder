package com.ly.traffic.middleplatform.strategy.selector;

import com.ly.traffic.middleplatform.condition.IConditionEngine;
import com.ly.traffic.middleplatform.strategy.AbstractStrategy;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.strategy.selector
 * @Description: ${TODO}
 * @date 2020/8/28 17:19
 */
public interface IStrategySeletor <CONDITION extends IConditionEngine, CONTEXT> {

    AbstractStrategy getStrategy(CONTEXT orderEntity) ;
}

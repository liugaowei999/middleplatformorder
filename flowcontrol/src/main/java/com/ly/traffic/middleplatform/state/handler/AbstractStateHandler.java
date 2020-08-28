package com.ly.traffic.middleplatform.state.handler;

import com.google.common.collect.Lists;
import com.ly.traffic.middleplatform.condition.IConditionEngine;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.State
 * @Description: 泛型状态处理抽象类
 * @date 2020/8/22 15:06
 */
public abstract class AbstractStateHandler<ORDER, EVENT> {

    /**
     *  当前状态值
     */
    protected Integer currentStatusValue;
    /**
     *  处理器名称
     */
    protected String handlerName;

    /**
     * 下一个状态的处理器
     */
    private Map<EVENT, List<AbstractStateHandler>> nextHandlerMap = new HashMap<>();

    public void setNextHandler(EVENT eventType, AbstractStateHandler nextHandler) {
        if (nextHandlerMap.containsKey(eventType)) {
            nextHandlerMap.get(eventType).add(nextHandler);
        } else {
            List<AbstractStateHandler> handlerList = Lists.newArrayList(nextHandler);
            nextHandlerMap.put(eventType, handlerList);
        }
    }

    public List<AbstractStateHandler> getNextHandler(EVENT eventType) {
       return nextHandlerMap.get(eventType);
    }

    /**
     * 状态处理逻辑，子类实现
     * @param orderEntity 1
     */
    public abstract void handler(ORDER orderEntity);

}

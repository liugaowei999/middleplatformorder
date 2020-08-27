package com.ly.traffic.middleplatform.state.handler;

import java.util.HashMap;
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
    private Map<EVENT, AbstractStateHandler> nextHandlerMap = new HashMap<>();

    public void setNextHandler(EVENT eventType, AbstractStateHandler nextHandler) {
        nextHandlerMap.put(eventType, nextHandler);
    }

    public AbstractStateHandler getNextHandler(EVENT eventType) {
       return nextHandlerMap.get(eventType);
    }

    /**
     * 状态处理逻辑，子类实现
     * @param orderEntity 1
     */
    public abstract void handler(ORDER orderEntity);
}

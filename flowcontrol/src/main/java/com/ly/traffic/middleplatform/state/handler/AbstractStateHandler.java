package com.ly.traffic.middleplatform.state.handler;


import com.ly.traffic.middleplatform.domain.createorder.entity.UnionOrderEntity;
import com.ly.traffic.middleplatform.event.EventType;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.State
 * @Description: ${TODO}
 * @date 2020/7/22 15:06
 */
public abstract class AbstractStateHandler {
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
    private Map<EventType, AbstractStateHandler> nextHandlerMap = new HashMap<>();

    public void setNextHandler(EventType eventType, AbstractStateHandler nextHandler) {
        nextHandlerMap.put(eventType, nextHandler);
    }

    public AbstractStateHandler getNextHandler(EventType eventType) {
       return nextHandlerMap.get(eventType);
    }

    /**
     * 状态处理逻辑，子类实现
     * @param orderEntity 1
     */
    public abstract void handler(UnionOrderEntity orderEntity);
}

package com.ly.traffic.middleplatform.state;

import com.ly.traffic.middleplatform.state.handler.AbstractStateHandler;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.State
 * @Description: ${TODO}
 * @date 2020/7/22 15:15
 */
public class StateHandlerManager {
    private Map<Integer, AbstractStateHandler> handlerMap = new HashMap<>();

    public void registerHandler(Integer status, AbstractStateHandler handler) {
        handlerMap.put(status, handler);
    }

    public AbstractStateHandler getHandlerByStateValue(int status) {
        return handlerMap.get(status);
    }
}

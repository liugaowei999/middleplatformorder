package com.ly.traffic.middleplatform.strategy;


import com.ly.traffic.middleplatform.domain.createorder.entity.UnionOrderEntity;
import com.ly.traffic.middleplatform.event.EventType;
import com.ly.traffic.middleplatform.state.handler.AbstractStateHandler;
import com.ly.traffic.middleplatform.state.StateHandlerManager;
import com.ly.traffic.middleplatform.state.handler.UnknownStateHandler;
import org.apache.commons.collections4.CollectionUtils;

import java.util.Collections;
import java.util.List;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.strategy
 * @Description: ${TODO}
 * @date 2020/7/22 16:54
 */
public class AbstractStrategy {
    private StateHandlerManager stateHandlerManager = new StateHandlerManager();

    public void process(EventType event, UnionOrderEntity orderEntity) {
        AbstractStateHandler nextHandler = getNextHandler(event, orderEntity);
        nextHandler.handler(orderEntity);
    }

    private AbstractStateHandler getNextHandler(EventType event, UnionOrderEntity orderEntity) {
        AbstractStateHandler currentStateHandler = stateHandlerManager.getHandlerByStateValue(orderEntity.getOrderStatus());
        if (currentStateHandler == null) {
            return UnknownStateHandler.getInstance();
        }
        List<AbstractStateHandler> handlerList = currentStateHandler.getNextHandler(event);
        if (CollectionUtils.isEmpty(handlerList)) {
            return UnknownStateHandler.getInstance();
        }
        return handlerList.get(0);
    }

    protected void registerHandler(int status, AbstractStateHandler waitingPayStateHandler) {
        stateHandlerManager.registerHandler(status, waitingPayStateHandler);
    }
}

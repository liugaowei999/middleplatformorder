package com.ly.traffic.middleplatform.strategy.handler;


import com.ly.traffic.middleplatform.domain.createorder.entity.MainOrder;
import com.ly.traffic.middleplatform.event.EventType;
import com.ly.traffic.middleplatform.state.handler.AbstractStateHandler;
import com.ly.traffic.middleplatform.state.StateHandlerManager;
import com.ly.traffic.middleplatform.state.handler.UnknownStateHandler;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.strategy
 * @Description: ${TODO}
 * @date 2020/7/22 16:54
 */
public class AbstractStrategyHandler {
    private StateHandlerManager stateHandlerManager = new StateHandlerManager();

    public void process(EventType event, MainOrder orderEntity) {
        AbstractStateHandler nextHandler = getNextHandler(event, orderEntity);
        nextHandler.handler(orderEntity);
    }

    private AbstractStateHandler getNextHandler(EventType event, MainOrder orderEntity) {
        AbstractStateHandler currentStateHandler = stateHandlerManager.getHandlerByStateValue(orderEntity.getOrderStatus());
        if (currentStateHandler == null) {
            return UnknownStateHandler.getInstance();
        }
        AbstractStateHandler nextHandler = currentStateHandler.getNextHandler(event);
        if (nextHandler == null) {
            return UnknownStateHandler.getInstance();
        }
        return nextHandler;
    }

    protected void registerHandler(int status, AbstractStateHandler waitingPayStateHandler) {
        stateHandlerManager.registerHandler(status, waitingPayStateHandler);
    }
}

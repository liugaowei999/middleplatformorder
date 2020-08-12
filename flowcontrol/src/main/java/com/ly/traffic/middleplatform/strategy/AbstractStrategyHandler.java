package com.ly.traffic.middleplatform.strategy;


import com.ly.traffic.middleplatform.event.EventType;
import com.ly.traffic.middleplatform.state.AbstractStateHandler;
import com.ly.traffic.middleplatform.state.StateHandlerManager;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.strategy
 * @Description: ${TODO}
 * @date 2020/7/22 16:54
 */
public class AbstractStrategyHandler {
    private StateHandlerManager stateHandlerManager = new StateHandlerManager();

    public void process(EventType event, Object orderEntity) {
//        AbstractStateHandler currentStateHandler = stateHandlerManager.getHandlerByStateValue(orderEntity.getOrderBaseInfo().getOrderStatus());
//        AbstractStateHandler nextHandler = currentStateHandler.getNextHandler(event);
//        nextHandler.handler(orderEntity);
    }

    protected void registerHandler(int status, AbstractStateHandler waitingPayStateHandler) {
        stateHandlerManager.registerHandler(status, waitingPayStateHandler);
    }
}

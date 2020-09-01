package com.ly.traffic.middleplatform.strategy;


import com.ly.traffic.middleplatform.demo.condition.FlowConditionDemo;
import com.ly.traffic.middleplatform.event.EventType;
import com.ly.traffic.middleplatform.state.handler.*;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.strategy
 * @Description: 单一行程先支付再占座策略
 * @date 2020/7/22 14:47
 */
public class SingleTripPayFirstStrategyDemo extends AbstractStrategy {

    private static SingleTripPayFirstStrategyDemo instance = new SingleTripPayFirstStrategyDemo();

    public static SingleTripPayFirstStrategyDemo getInstance() {
        return instance;
    }

    private void init() {
        FlowConditionDemo flowConditionDemo = new FlowConditionDemo();
        // 待出票处理
        WaitingIssueTicketStateHandler waitingIssueTicketStateHandler = new WaitingIssueTicketStateHandler();
        // 占座失败处理器
        LockFailedStateHandler lockFailedStateHandler = new LockFailedStateHandler();
        // 待支付处理器
        WaitingPayStateHandler waitingPayStateHandler = new WaitingPayStateHandler();
        // 待占座处理器
        WaitingLockSeatStateHandler waitingLockSeatStateHandler = new WaitingLockSeatStateHandler();

        // 支付成功事件 触发 转移到 待占座处理器
        waitingPayStateHandler.setNextHandler(EventType.PAID_SUCCESS, waitingLockSeatStateHandler);

        // 占座成功事件 触发 转移到 待出票处理器
        waitingLockSeatStateHandler.setNextHandler(EventType.LOCK_SUCCESS, waitingIssueTicketStateHandler);
        // 占座失败事件 触发 转移到 占座失败处理器
        waitingLockSeatStateHandler.setNextHandler(EventType.LOCK_FAILED, lockFailedStateHandler);

        InitialStateHandler initialStateHandler = new InitialStateHandler();
        initialStateHandler.setNextHandler(EventType.NEW_CREATED, waitingPayStateHandler);
        super.registerHandler(0, initialStateHandler);
        super.registerHandler(11, waitingPayStateHandler);
        super.registerHandler(12, waitingPayStateHandler);

        // 待占座， 占座中 可以使用同一个处理器
        super.registerHandler(20, waitingLockSeatStateHandler);
        registerHandler(21, waitingLockSeatStateHandler);
    }

    private SingleTripPayFirstStrategyDemo() {
        init();
    }


}

package com.ly.traffic.middleplatform.state;


/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.State
 * @Description: ${TODO}
 * @date 2020/7/22 13:55
 */
public class WaitingLockSeatStateHandler extends AbstractStateHandler {

    @Override
    public void handler(Object orderEntity) {
        // 1. 更新订单状态为待占座

        // 2. 发送票务中心占座命令

        // 3. 更新订单状态为占座中
    }
}

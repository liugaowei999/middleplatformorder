package com.ly.traffic.middleplatform.state.handler;


import com.ly.traffic.middleplatform.domain.createorder.entity.MainOrder;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.State
 * @Description: ${TODO}
 * @date 2020/7/22 16:33
 */
@Slf4j
public class InitialStateHandler extends AbstractStateHandler {

    @Override
    public void handler(MainOrder orderEntity) {
        log.info("创建订单完成");
    }
}

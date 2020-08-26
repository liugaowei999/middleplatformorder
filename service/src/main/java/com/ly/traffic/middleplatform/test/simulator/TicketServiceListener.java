package com.ly.traffic.middleplatform.test.simulator;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.eventbus.Subscribe;
import com.ly.traffic.middleplatform.demo.OrderEvent;
import com.ly.traffic.middleplatform.domain.cancelorder.entity.CancelAggregate;
import lombok.extern.slf4j.Slf4j;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.test.simulator
 * @Description: ${TODO}
 * @date 2020/8/25 15:17
 */
@Slf4j
public class TicketServiceListener {

    @Subscribe
    public void cancelTicketTask(CancelAggregate event) {
        log.info("[票务中心-取消占座或出票任务] 收到取消票务任务请求，内容:{}", JSON.toJSONString(event));
    }


}

package com.ly.traffic.middleplatform.demo.streamcontrol;

import com.ly.traffic.middleplatform.demo.OrderEvent;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.condition.streamcontrol
 * @Description: 流程引擎 - 分流控制
 * @date 2020/8/27 15:41
 */
public class ByPassFlowControlTest {
    /**
     * 获取分流目的地 【模拟】
     * @param event
     */
    public static String whoControl(OrderEvent event) {
        // 与运算模拟 分流策略配置； [&1 等价于 %2]
        int flag = event.getBypassId() & 1;
        if (flag == 1) {
            return "MIDDLE_PLATFORM";
        }

        return "FRONT";
    }
}

package com.ly.traffic.middleplatform.state;


/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.State
 * @Description: ${TODO}
 * @date 2020/7/22 15:38
 */
public class WaitingIssueTicketStateHandler extends AbstractStateHandler {

    @Override
    public void handler(Object orderEntity) {
        // 更新为 待出票状态

        // 发送票务中心 出票命令


    }
}

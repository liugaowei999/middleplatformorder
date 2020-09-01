package com.ly.traffic.middleplatform.state.handler;


import com.ly.traffic.middleplatform.demo.condition.FlowConditionDemo;
import com.ly.traffic.middleplatform.domain.createorder.entity.UnionOrderEntity;
import com.ly.traffic.middleplatform.event.EventType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.RandomUtils;

import java.util.Map;

/**
 * @author liugw
 * @Package com.ly.traffic.train.domain.order.State
 * @Description: ${TODO}
 * @date 2020/7/22 13:55
 */
@Slf4j
public class WaitingLockSeatStateHandler extends AbstractStateHandler<UnionOrderEntity, EventType> {
    private FlowConditionDemo conditionEngine = new FlowConditionDemo();


    @Override
    public void handler(UnionOrderEntity orderEntity) {
        String conditionName = "CanLockSeatConditon";
        Map<String, Object> paramMap = buildConditionParam(orderEntity);
        boolean valid = conditionEngine.valid(conditionName, paramMap);
        if (!valid) {
            return;
        }

        // 需要做的操作
        // 1. 发送票务中心占座命令
        log.info("【流程引擎-主流程】 orderNo:{} 开始发送票务中心占座命令..., ThreadId:{}", orderEntity.getOrderNo(),Thread.currentThread().getId());
        try {
            Thread.sleep(RandomUtils.nextInt(1000,5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("[流程引擎-主流程] orderNo:{} 发送票务中心占座命令成功, ThreadId:{}", orderEntity.getOrderNo(), Thread.currentThread().getId());

        // 不应该做的操作：
        // NOT更新订单状态为待占座&占座中（不在此处更新，应由票务中心决定是否更新 - 票务状态应由票务中心控制）
    }

    private Map<String, Object> buildConditionParam(UnionOrderEntity orderEntity) {
        return null;
    }
}

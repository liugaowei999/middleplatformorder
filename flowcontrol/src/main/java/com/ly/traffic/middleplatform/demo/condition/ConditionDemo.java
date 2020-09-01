package com.ly.traffic.middleplatform.demo.condition;

import com.ly.traffic.middleplatform.condition.IConditionEngine;
import com.ly.traffic.middleplatform.domain.createorder.entity.UnionOrderEntity;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.condition
 * @Description: ${TODO}
 * @date 2020/8/26 11:29
 */
public class ConditionDemo implements IConditionEngine<String, UnionOrderEntity> {

    @Override
    public boolean valid(String conditionName, UnionOrderEntity o) {
        return true;
    }
}

package com.ly.traffic.middleplatform.condition;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.condition
 * @Description: 条件引擎接口定义
 * @date 2020/8/28 15:17
 */
public interface IConditionEngine<C, P> {

    boolean valid(C t, P o);

    default boolean notValid(C t, P o) {
        return !valid(t, o);
    }
}

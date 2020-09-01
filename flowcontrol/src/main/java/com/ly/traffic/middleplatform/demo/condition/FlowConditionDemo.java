package com.ly.traffic.middleplatform.demo.condition;

import com.google.common.collect.Maps;
import com.googlecode.aviator.AviatorEvaluator;
import com.googlecode.aviator.Expression;
import com.ly.traffic.middleplatform.condition.IConditionEngine;

import java.util.HashMap;
import java.util.Map;


/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.condition.demo
 * @Description: ${TODO}
 * @date 2020/8/28 15:30
 */
public class FlowConditionDemo implements IConditionEngine<String, Map> {
    private static FlowConditionDemo instance = new FlowConditionDemo();
    private Map<String, Expression> expressionMap = Maps.newHashMap();

    public static FlowConditionDemo getInstance() {
        return instance;
    }

    public void installConditionCfg(String conditonName, String expressStr) {
        Expression ex = AviatorEvaluator.compile(expressStr);
        expressionMap.put(conditonName, ex);
    }


    @Override
    public boolean valid(String conditionName, Map paramValueMap) {
        if (expressionMap.containsKey(conditionName)) {
            return (boolean) expressionMap.get(conditionName).execute(paramValueMap);
        }
        return true;
    }


    public static void main(String[] args) {
        FlowConditionDemo instance = FlowConditionDemo.getInstance();
        instance.installConditionCfg("XY_CONDITION", "x>1 && y<10");

        String xy_condition = "XY_CONDITION";
        HashMap<String, Object> paramMap = Maps.newHashMap();
        paramMap.put("x", 5);
        paramMap.put("y", 9);
        boolean valid = instance.valid(xy_condition, paramMap);
        System.out.println(valid);

        paramMap.put("x", 5);
        paramMap.put("y", 20);
        valid = instance.valid(xy_condition, paramMap);
        System.out.println(valid);

        paramMap.put("x", 99999);
        paramMap.put("y", 1);
        valid = instance.valid(xy_condition, paramMap);
        System.out.println(valid);

        long nanoTime = System.nanoTime();
        for (int i=0; i < 10000; i++) {
            for (int y = 0; y<10000; y++) {
                paramMap.put("x", i);
                paramMap.put("y", y);
                valid = instance.valid(xy_condition, paramMap);
            }
        }
        long end = System.nanoTime();
        System.out.println(paramMap);
        System.out.println(valid);
        System.out.println((end-nanoTime)/1000000 + "ms");

        nanoTime = System.nanoTime();
        for (int i=0; i < 10000; i++) {
            for (int y = 0; y<10000; y++) {
                if (i > 1 && y < 10) {
                    valid = true;
                } else {
                    valid = false;
                }

            }
        }
        end = System.nanoTime();
        System.out.println(valid);
        System.out.println((end-nanoTime)/1000000 + "ms");
    }
}

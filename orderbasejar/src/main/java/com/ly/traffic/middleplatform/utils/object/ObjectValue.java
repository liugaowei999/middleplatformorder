package com.ly.traffic.middleplatform.utils.object;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Maps;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.utils.object
 * @Description: ${TODO}
 * @date 2020/8/10 21:52
 */
public class ObjectValue {
    public static String getJSONString(Class clazz, Object obj) throws IllegalAccessException {
        Map<String,Object> sonMapValues = getMapValues(clazz, obj);
        Map<String,Object> parentMapValues = getMapValues(clazz.getSuperclass(), obj);

        parentMapValues.put("extendcontent", JSON.toJSONString(sonMapValues));
        return JSON.toJSONString(parentMapValues);
    }

    public static JSONObject getJSONValue(Class clazz, Object obj) throws IllegalAccessException {
        Map<String,Object> sonMapValues = getMapValues(clazz, obj);
        Map<String,Object> parentMapValues = getMapValues(clazz.getSuperclass(), obj);

        JSONObject body = new JSONObject();
        body.put("parent", JSON.toJSONString(parentMapValues));
        body.put("child", JSON.toJSONString(sonMapValues));
        JSONObject result = new JSONObject();
        result.put(clazz.getSuperclass().getName(), JSON.toJSONString(body));
        return result;
    }

    public static Map<String, Object> getMapValues(Class clazz, Object obj) throws IllegalAccessException {
        Map<String, Field> classFields = getClassFields(clazz);
        return getMapValues(classFields, obj);
    }

    private static Map<String, Object> getMapValues(Map<String,Field> map, Object obj) throws IllegalAccessException {
        Map<String,Object> sonMapValues = Maps.newHashMap();
        for ( Map.Entry<String, Field> entry : map.entrySet ( ) ){
//            System.out.println ( "<field=" + entry.getKey().toString ( ) + "> <Type=" + map.get ( entry.getKey() ) + ">" );
            if (entry.getValue().get(obj) == null) {
//                System.out.println("未设置");
            } else {
                sonMapValues.put(entry.getKey().toString (), entry.getValue().get(obj));
//                System.out.println("value:" + entry.getValue().get(obj));
            }
        }

        return sonMapValues;
    }

    /**
     * 获取类实例的父类的属性值
     * @param clazz
     *            类名
     * @return 类名.属性名=属性类型
     */
    public static Map<String,Field> getClassFields( Class clazz){
        Map<String,Field> map = new HashMap<String,Field>();
        //返回Class 对象所表示的类或接口的指定已声明字段
        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields){
            //将字段名作为key，field作为value
            field.setAccessible(true);
            map.put(field.getName(),field);
        }
        return map;
    }
}

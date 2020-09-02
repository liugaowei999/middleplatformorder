package com.ly.traffic.middleplatform.utils.object;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.ly.traffic.middleplatform.apt.annotation.ExcludeField;
import com.ly.traffic.middleplatform.domain.createorder.entity.TripOrderInfo;
import com.ly.traffic.middleplatform.domain.createorder.entity.TripPassengerOrderInfo;
import com.ly.traffic.middleplatform.domain.createorder.vo.BusTripInfoVO;
import com.ly.traffic.middleplatform.domain.createorder.vo.TrainTripInfoVO;
import com.ly.traffic.middleplatform.domain.createorder.vo.TripInfoVO;
import org.apache.commons.collections4.CollectionUtils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
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

        parentMapValues.put("extendContent", JSON.toJSONString(sonMapValues));
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

    private static Map<String, Object> getMapValues(Class clazz, Object obj) throws IllegalAccessException {
        Map<String, Field> classFields = getClassFields(clazz);
        return getMapValues(classFields, obj);
    }

    private static Map<String, Object> getMapValues(Map<String,Field> map, Object obj) throws IllegalAccessException {
        Map<String,Object> sonMapValues = Maps.newHashMap();
        for ( Map.Entry<String, Field> entry : map.entrySet ( ) ){
//            System.out.println ( "<field=" + entry.getKey().toString ( ) + "> <Type=" + map.get ( entry.getKey() ) + ">" );
            if (entry.getValue().get(obj) != null) {
                Object o = entry.getValue().get(obj);
                if (o instanceof TripOrderInfo && o != obj) {
                    TripOrderInfo tripOrderInfo = (TripOrderInfo)o;
                    sonMapValues.put(entry.getKey().toString (), tripOrderInfo.toString());
                } else if (o instanceof List && o != obj) {
                    List<Object> objectList = (List)o;
                    if (CollectionUtils.isNotEmpty(objectList)) {
                        List<String> strList = Lists.newArrayList();
                        for (Object o1 : objectList) {
                            if (o1 instanceof TripPassengerOrderInfo && o1 != obj) {
                                TripPassengerOrderInfo passengerOrderInfo = (TripPassengerOrderInfo)o1;
//                                System.out.println("passengerOrder.toStr:" +passengerOrderInfo.toString());
                                strList.add(passengerOrderInfo.toString());
                            }
                        }
                        if (CollectionUtils.isNotEmpty(strList)) {
                            sonMapValues.put(entry.getKey().toString(), strList);
                        } else {
                            sonMapValues.put(entry.getKey().toString(), o);
                        }
                    }
                } else {
                    if (o instanceof TripInfoVO) {
                        sonMapValues.put(o.getClass().getCanonicalName(), o);
                    } else {
                        sonMapValues.put(entry.getKey().toString(), o);
                    }
                }
//                System.out.println("value:" + entry.getValue().get(obj));
            } //else {
                //System.out.println("未设置");
            //}
        }

        return sonMapValues;
    }

    /**
     * 获取类实例的父类的属性值
     * @param clazz
     *            类名
     * @return 类名.属性名=属性类型
     */
    private static Map<String,Field> getClassFields(Class clazz){
        Map<String,Field> map = new HashMap<String,Field>();
        //返回Class 对象所表示的类或接口的指定已声明字段
        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields){
            ExcludeField annotation = field.getAnnotation(ExcludeField.class);
            if ((annotation == null) || !annotation.exclude()) {
                //将字段名作为key，field作为value
                field.setAccessible(true);
                map.put(field.getName(), field);
            }
        }
        return map;
    }
}

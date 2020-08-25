package com.ly.traffic.middleplatform.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.infrastructure
 * @Description: 当前被标注的属性不会被序列化和传输
 * @date 2020/7/6 17:12
 */
@Retention(RetentionPolicy.SOURCE)
@Target(ElementType.TYPE)
public @interface ValueObject {
    //String value();
}

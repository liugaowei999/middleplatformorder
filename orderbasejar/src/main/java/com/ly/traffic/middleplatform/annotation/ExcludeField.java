package com.ly.traffic.middleplatform.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author liugw
 * @Package com.ly.traffic.middleplatform.infrastructure
 * @Description: 普通实体
 * @date 2020/7/6 17:12
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface ExcludeField {
    boolean exclude() default true;
}

package com.dragon.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by CymbidiumSky on 2017/6/29.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface AliYunField {

    ALiYunFieldEnum value();//字段名称

    String defaultValue() default "";//默认值

    String methodName() default "";//值方法调用名称

    String invokeName() default "";//值调用工具名称

    String gt() default "";

    String lt() default "";

    String ge() default "";

    String le() default "";
}

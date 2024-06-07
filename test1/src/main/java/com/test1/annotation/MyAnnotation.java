package com.test1.annotation;

import java.lang.annotation.*;

/**
 * @author XT
 * @Title: MyAnnotation
 * @Date: 2024/5/20 18:04
 * @description: 自定义注解
 */
//注解是否将包含在JavaDoc中
@Documented
//注解的生命周期（RetentionPolicy.RUNTIME : 始终不会丢弃，可以使用反射获得该注解的信息）
@Retention(RetentionPolicy.RUNTIME)
//注解作用的目标（ElementType.TYPE: 类、接口、注解、enum）
@Target(ElementType.TYPE)
public @interface MyAnnotation {

    /**
     * 最小值
     */
    int min() default 18;

    /**
     * 最大值
     */
    int max() default 60;

    /**
     * 平均值
     */
    int average() default 35;

    /**
     * 性别
     */
    enum SEX_TYPE {MAN, WOMAN}

    SEX_TYPE sex() default SEX_TYPE.MAN;
}

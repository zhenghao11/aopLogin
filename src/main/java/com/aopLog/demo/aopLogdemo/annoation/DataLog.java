package com.aopLog.demo.aopLogdemo.annoation;

import java.lang.annotation.*;

/**
 * 日志注解
 *
 * @Author hzheng
 * @Date 2017/11/8
 */
@Documented
@Target({ElementType.FIELD, ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DataLog {
    String name();
}

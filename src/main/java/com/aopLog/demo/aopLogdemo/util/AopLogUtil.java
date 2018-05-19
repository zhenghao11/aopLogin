package com.aopLog.demo.aopLogdemo.util;

import com.aopLog.demo.aopLogdemo.annoation.DataLog;
import org.springframework.util.StringUtils;

import java.lang.reflect.Field;

/**
 * @Author hzheng
 * @Date 2017/11/8
 */
public class AopLogUtil {
    /**
     * 比较两个model更新前后的字段值
     *
     * @param obj1
     * @param obj2
     * @return
     * @throws Exception
     */
    public static String compareObj(Object obj1, Object obj2) throws Exception {
        Class<?> aClass = obj1.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        StringBuilder stringBuilder = new StringBuilder();
        for (Field field : declaredFields) {
            field.setAccessible(true);
            // 字段名称
            // String fieldName = field.getName();
            // 每个字段的值
            Object o1 = field.get(obj1);
            Object o2 = field.get(obj2);
            boolean equals = equals(o1, o2);
            if (!equals) {
                DataLog annotation = field.getAnnotation(DataLog.class);
                if (!StringUtils.isEmpty(annotation)) {
                    stringBuilder.append(annotation.name() + "的旧值:" + o1 + ",新值:" + o2);
                    stringBuilder.append(";");
                }
            }
        }
        return stringBuilder.substring(0, stringBuilder.length() - 1).toString();
    }

    /**
     * 比较两个字段是否相同
     *
     * @param obj1
     * @param obj2
     * @return
     */
    private static boolean equals(Object obj1, Object obj2) {
        if (obj1 == obj2) {
            return true;
        }
        if (obj1 == null || obj2 == null) {
            return false;
        }
        return obj1.equals(obj2);
    }


}

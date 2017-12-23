package com.aopLog.demo.aopLogdemo.aspect;

import com.aopLog.demo.aopLogdemo.annoation.DataLog;
import com.aopLog.demo.aopLogdemo.dataobject.Operate;
import com.aopLog.demo.aopLogdemo.service.OperateService;
import com.aopLog.demo.aopLogdemo.util.AopLogUtil;
import org.apache.commons.beanutils.PropertyUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @Author hzheng
 * @Date 2017/11/7
 */
@Component
@Aspect
public class LogAspect {

    @Autowired
    OperateService operateService;

    @Pointcut("execution(public * com.aopLog.demo.aopLogdemo.service.*.add*(..))")
    public void addLog(){
    }

    @Pointcut("execution(public * com.aopLog.demo.aopLogdemo.service.*.delete*(..))")
    public void deleteLog(){
    }

    @Pointcut("execution(public * com.aopLog.demo.aopLogdemo.service.*.update*(..))")
    public void updateLog(){
    }

    @Around("addLog() || deleteLog() || updateLog()")
    public Object doVerify(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取执行的方法名称
        String methodName = joinPoint.getSignature().getName();
        // 获取第一个参数 key:value
        Object arg = joinPoint.getArgs()[0];
        System.out.println("AOP Start");
        // 第一个参数类类型
        Class<?> clazz = arg.getClass();
    //    Field[] fields = clazz.getDeclaredFields();
        // 获取注解
        DataLog dataLog = clazz.getAnnotation(DataLog.class);
        // 注解名称
        String annotationName = dataLog.name();
        System.out.println("第一个参数的注解名称:" + annotationName);
        // 增加的日志
        Operate operate = new Operate();
        // 执行方法的类类型
        Object target = joinPoint.getTarget();
        Method selectByPrimaryKey = target.getClass().getDeclaredMethod("selectByPrimaryKey",Integer.class);
        // 对新增无效
        Integer id = (Integer) PropertyUtils.getProperty(arg,"id");
        // 更新前的model 只对更新有效
        Object oldModel = null;
        if(methodName.contains("update")){
            // 更新之前的属性
            oldModel = selectByPrimaryKey.invoke(target, id);
            System.out.println("oldModel" + oldModel);
        }

        // *********************  方法执行之前  *********************

        Object proceed = joinPoint.proceed(joinPoint.getArgs());

        // *********************  方法执行之后  *********************
        // 新增
        if(methodName.contains("add")) {
            Integer afterId = (Integer) PropertyUtils.getProperty(arg,"id");
            operate.setAction("新增了id:" + afterId + "的" + annotationName);
            System.out.println(afterId);
        }
        //删除
        if(methodName.contains("delete")){
            operate.setAction("删除了id:" + id + "的" + annotationName);
        }
        if(methodName.contains("update")){
            // 更新之后的属性
            Object newModel = selectByPrimaryKey.invoke(target, id);
            System.out.println("newModel" + newModel);
            // 比较更新前后的属性
            String result = AopLogUtil.compareObj(oldModel, newModel);
            System.out.println(result);
            operate.setAction("修改了id:" + id + "的" + annotationName + ",其" + result);
        }
        operate.setOperator("admin");
        //  只有操作成功才保存到日志表
        if((Integer) proceed > 0){
            operateService.insert(operate);
        }
        return proceed;
    }
}

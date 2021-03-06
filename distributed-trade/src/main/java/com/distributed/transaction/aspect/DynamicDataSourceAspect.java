/*
package com.distributed.transaction.aspect;


import com.distributed.transaction.trade.annos.DataSource;
import com.distributed.transaction.config.datasource.DatabaseContextHolder;
import com.distributed.transaction.trade.enums.TradeDataSourceType;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

*/
/**
 * 动态数据源AOP切面
 *
 * @author ssk www.8win.com Inc.All rights reserved
 * @version v1.0
 * @date 2018-07-18-下午 5:42
 *//*

@Aspect
@Order(-10)
@Component
public class DynamicDataSourceAspect {


    */
/**
     * 切换放在mapper接口的方法上，所以这里要配置AOP切面的切入点
     *//*

    @Pointcut("@annotation(com.distributed.transaction.trade.annos.DataSource)|| @within(com.distributed.transaction.trade.annos.DataSource))")
    public void dataSourcePointCut() {

    }


    @Before("dataSourcePointCut()")
    public void before(JoinPoint point) throws Throwable {

        Class<?> className = point.getTarget().getClass();

        TradeDataSourceType databaseType = TradeDataSourceType.MASTER;

        if (className.isAnnotationPresent(DataSource.class)) {

            DataSource ds = className.getAnnotation(DataSource.class);

            databaseType = ds.value();

        } else {
            // 得到访问的方法对象
            String methodName = point.getSignature().getName();
            Class[] argClass = ((MethodSignature) point.getSignature()).getParameterTypes();
            Method method = className.getMethod(methodName, argClass);
            // 判断是否存在@DS注解
            if (method.isAnnotationPresent(DataSource.class)) {
                DataSource annotation = method.getAnnotation(DataSource.class);
                // 取出注解中的数据源名
                databaseType = annotation.value();
            }
        }

        // 切换数据源
        DatabaseContextHolder.setDB(databaseType);
    }

    @After("dataSourcePointCut()")
    public void after(JoinPoint point) {

        DatabaseContextHolder.clearDB();
    }

}*/

package com.github.wxz.aop;

import com.github.wxz.framework.mybatis.DataSourceContextHolder;
import com.github.wxz.framework.mybatis.DataSourceType;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.core.PriorityOrdered;
import org.springframework.stereotype.Component;

/**
 * 必须在事务AOP之前执行，所以实现Ordered,order的值越小，越先执行
 * 如果一旦开始切换到写库，则之后的读都会走写库
 *
 * @author xianzhi.wang
 * @date 2018/1/11 -13:13
 */
@Aspect
@EnableAspectJAutoProxy(exposeProxy = true, proxyTargetClass = true)
@Component
public class DataSourceAopInService implements PriorityOrdered {


    @Before("execution(* com.github.wxz.service..*.*(..)) "
            + " && @annotation(com.github.wxz.framework.mybatis.annotation.ReadDataSource) ")
    public void setReadDataSourceType() {
        //如果已经开启写事务了，那之后的所有读都从写库读
        if (!DataSourceType.WRITE.getType().equals(DataSourceContextHolder.getReadOrWrite())) {
            DataSourceContextHolder.setRead();
        }
    }

    @Before("execution(* com.github.wxz.service..*.*(..)) "
            + " && @annotation(com.github.wxz.framework.mybatis.annotation.WriteDataSource) ")
    public void setWriteDataSourceType() {
        DataSourceContextHolder.setWrite();
    }

    @Override
    public int getOrder() {
        /**
         * 值越小，越优先执行
         * 要优于事务的执行
         * 在启动类中加上了@EnableTransactionManagement(order = 10)
         */
        return 1;
    }
}

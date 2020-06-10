package com.i520java.seata.aop;

import com.i520java.springcloud.comments.CommentResult;
import io.seata.core.context.RootContext;
import io.seata.core.exception.TransactionException;
import io.seata.tm.api.GlobalTransaction;
import io.seata.tm.api.GlobalTransactionContext;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.bouncycastle.cert.ocsp.RespData;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @PackageName:com.i520java.seata.aop
 * @ClassName:WorkAspect
 * @author:金格[JIN_GE]
 * @date:2020/6/11 01:00
 * @description 此模板由【Jin ge】提供!
 * 更多教程请访问 https://www.520java.com 交流学习
 * 用于处理程序调用发生异常的时候由于异常被处理以后无法触发事务，而进行的处理，使之可以正常的触发事务。
 */
@Aspect
@Component
@Slf4j
public class WorkAspect {

    @Before("execution(* com.i520java.seata.service.*.*(..))")
    public void before(JoinPoint joinPoint) throws TransactionException {
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        log.info("拦截到需要分布式事务的方法," + method.getName());
        // 此处可用redis或者定时任务来获取一个key判断是否需要关闭分布式事务
        // 模拟动态关闭分布式事务
        if ((int)(Math.random() * 100) % 2 == 0) {
            GlobalTransaction tx = GlobalTransactionContext.getCurrentOrCreate();
            tx.begin(300000, "test-client");
        } else {
            log.info("关闭分布式事务");
        }
    }

    @AfterThrowing(throwing = "e", pointcut = "execution(* com.i520java.seata.service.*.*(..))")
    public void doRecoveryActions(Throwable e) throws TransactionException {
        log.info("方法执行异常:{}", e.getMessage());
        if (!StringUtils.isBlank(RootContext.getXID()))
            GlobalTransactionContext.reload(RootContext.getXID()).rollback();
    }

    @AfterReturning(value = "execution(* com.i520java.seata.service.*.*(..))", returning = "result")
    public void afterReturning(JoinPoint point, Object result) throws TransactionException {
        log.info("方法执行结束:{}", result);
        if ((Boolean)result) {
            if (!StringUtils.isBlank(RootContext.getXID())) {
                log.info("分布式事务Id:{}", RootContext.getXID());
                GlobalTransactionContext.reload(RootContext.getXID()).commit();
            }
        }
    }

}

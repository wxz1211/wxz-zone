package com.github.wxz.interceptor;

import com.github.wxz.auth.UserAuth;
import com.github.wxz.common.response.Response;
import com.github.wxz.domain.UserAuthDO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: wangxianzhi
 * @date: 2018/1/13
 * @time: 17:23
 * @email: xianzhi@eastmoney.com
 */
@Component
@Aspect
@Order(value = 11)
public class AuthInterceptor {

    @Autowired
    private UserAuth userAuth;


    @Around("execution(* com.github.wxz.action..*(..))")
    public Object around(JoinPoint joinPoint) throws Throwable {
        HttpServletRequest httpServletRequest = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        UserAuthDO userAuthDO = userAuth.getCurrentUser(httpServletRequest);
        ProceedingJoinPoint proceedingJoinPoint = (ProceedingJoinPoint) joinPoint;
        if (userAuthDO == null) {
            return Response.FAIL;
        } else {
            return proceedingJoinPoint.proceed(joinPoint.getArgs());
        }
    }

}
package com.springapp.proxy.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * @author GavinCook
 * @since 1.0.0
 **/
public class DebugInterceptor implements MethodInterceptor{

    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.println("before invoke method");
        return methodInvocation.proceed();
    }
}

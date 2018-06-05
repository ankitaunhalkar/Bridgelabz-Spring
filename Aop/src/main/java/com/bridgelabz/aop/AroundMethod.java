package com.bridgelabz.aop;

import java.util.Arrays;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class AroundMethod implements MethodInterceptor {

	@Override
	public Object invoke(MethodInvocation methodInvocation) throws Throwable {

        System.out.println("===SPRING AOP=== AroundMethod: Method name : " + methodInvocation.getMethod().getName());
        System.out.println("===SPRING AOP=== AroundMethod: Method arguments :" + Arrays.toString(methodInvocation.getArguments()));
        System.out.println("===SPRING AOP=== AroundMethod: Before method execute");
        try {
            Object result = methodInvocation.proceed();
            System.out.println("===SPRING AOP=== AroundMethod: After method execute");
            return result;
        } catch (IllegalArgumentException e) {
            // same with ThrowsAdvice
            System.out.println("===SPRING AOP=== AroundMethod: When method exception throws ");
            throw e;
        }
	}

}

package com.bridgelabz.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterMethod implements AfterReturningAdvice{
@Override
public void afterReturning(Object arg0, Method arg1, Object[] arg2, Object arg3) throws Throwable {
    System.out.println("===SPRING AOP=== AfterThrowingExceptionMethod : Execute when method throws exception");
}
}

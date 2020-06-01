package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLogginAspect {
//this is where we add all of our related advices for logging
	
	
//let's start with an @Before advice
	
//@Before("execution(public void add*())")
	
@Pointcut("execution(* com.luv2code.aopdemo.dao.*.*(..))")
private void forDaoPackage() {}

@Pointcut("execution(* com.luv2code.aopdemo.dao.*.get*(..))")
private void getter() {}

@Pointcut("execution(* com.luv2code.aopdemo.dao.*.set*(..))")
private void setter() {}

@Pointcut("forDaoPackage() &&!(getter() || setter())")
private void forDaoPackageNoGetterSetter() {}

@Before("forDaoPackageNoGetterSetter()")
public void beforeAddAccountAdvice(){
	
	System.out.println("Executing before");
}
}

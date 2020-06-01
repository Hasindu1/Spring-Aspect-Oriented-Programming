package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.luv2code.aopdemo.Account;

@Aspect
@Component
@Order(2)
public class MyDemoLogginAspect {
//this is where we add all of our related advices for logging
	
	
//let's start with an @Before advice
	
//@Before("execution(public void add*())")
	

@Before("com.luv2code.aopdemo.aspect.LuvAopExpressions.forDaoPackageNoGetterSetter()")
public void beforeAddAccountAdvice(JoinPoint theJoinPoint){
	
	System.out.println("Executing before");
	
	//dispaly the method signature
	MethodSignature methodSig = (MethodSignature)theJoinPoint.getSignature();
	
	
	//display method argumnets
	System.out.println(methodSig);
	
	Object[] args = theJoinPoint.getArgs();
	
	for(Object arg:args) {
		
		System.out.println(arg);
		if(arg instanceof Account ) {
			Account theAccount = (Account)arg;
			System.out.println("Account name is" +theAccount.getName());
			System.out.println("Account level is" + theAccount.getLevel());
		}
	}
}

}

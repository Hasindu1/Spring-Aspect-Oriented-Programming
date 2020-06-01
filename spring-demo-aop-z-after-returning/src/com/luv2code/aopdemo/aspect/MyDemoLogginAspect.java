package com.luv2code.aopdemo.aspect;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
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
	
	
//add a new advice for @AfterReturning on the findAccounts method
	@AfterReturning("execution(* com.luv2code.aopdemo.dao.AccountDAO.yesYes(..))")
	private void helloWorld(JoinPoint joinPoint) {
		//System.out.println(joinPoint.getArgs());
		
		Object[] args =joinPoint.getArgs();
		for(Object temp:args) {
			System.out.println((boolean)temp);
		}
		System.out.println("--------->Returning after the execution<----------");
	}
@AfterReturning(pointcut="execution(* com.luv2code.aopdemo.dao.AccountDAO.findAccounts(..))",returning ="result" )
public void afterReturningFindAccountAdvice(JoinPoint theJoinPoint,List<Account> result) {
	MethodSignature methodSig = (MethodSignature)theJoinPoint.getSignature();
	//method which is advicing on
	System.out.println("Executing @AfterReturning on method:"+methodSig);
	
	System.out.println("Result is" + result);
	
	//let's post process the data..let's modify the data
	
	
	//convert the account names to uppercase
	convertAccountNamesToUpperCase(result);
	System.out.println("Final result is" + result);
}

private void convertAccountNamesToUpperCase(List<Account> result) {
	
for(Account tempAccount:result) {
	tempAccount.setName(tempAccount.getName().toUpperCase());
}
}
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

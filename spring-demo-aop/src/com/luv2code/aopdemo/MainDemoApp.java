package com.luv2code.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.dao.AccountDAO;
import com.luv2code.aopdemo.dao.MemberShipDAO;

public class MainDemoApp {

	public static void main(String[] args) {
		//read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);
		
		
		
		//get the bean from spring container
		AccountDAO theAccountDAO = context.getBean("accountDAO",AccountDAO.class);
		
		//get memebrship bean from spring container
		
		MemberShipDAO theMemberShipDAO = context.getBean("memberShipDAO",MemberShipDAO.class);
		
		
		//call the mebership bussiness method
		
		theMemberShipDAO.addSillyMember();
		//call the business method
		Account myAccount = new Account();
		theAccountDAO.addAccount(myAccount,true); 
		
		
		//close the context
		context.close();

	}

}

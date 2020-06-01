package com.luv2code.aopdemo.dao;

import org.springframework.stereotype.Component;

@Component
public class MemberShipDAO {

	public boolean addSillyMember() {
		System.out.println(getClass()+"Doing stuff:Adding a membership account");
		return true;
	}
}

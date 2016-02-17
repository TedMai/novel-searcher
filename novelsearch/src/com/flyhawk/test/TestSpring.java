package com.flyhawk.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {
	
	@Before
	public void init(){
		System.out.println("Init......");
	}
	
	@Test
	public void callSpringMethod(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml");
		HelloWorld hello = (HelloWorld)ctx.getBean("hello");
		hello.sayHello("liuyonglong");
	}
}

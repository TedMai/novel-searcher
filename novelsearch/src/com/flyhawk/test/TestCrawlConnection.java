package com.flyhawk.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flyhawk.crawl.CrawlEngine;

public class TestCrawlConnection {
	
	CrawlEngine engine;
	@Before
	public void initCrawlEngine(){
		System.setProperty("org.apache.commons.logging.diagnostics.dest", "STDOUT" );
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml");
		engine = (CrawlEngine)ctx.getBean("crawlEngine");
		
	}
	
	@Test
	public void callSpringMethod(){
		
		engine.readPageByGet("http://www.baidu.com");
	}
}

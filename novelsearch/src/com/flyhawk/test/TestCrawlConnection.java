package com.flyhawk.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flyhawk.crawl.CrawlEngine;
import com.flyhawk.crawl.NovelUpdateList;

public class TestCrawlConnection {
	
	NovelUpdateList engine;
	@Before
	public void initCrawlEngine(){
		System.setProperty("org.apache.commons.logging.diagnostics.dest", "STDOUT" );
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml");
		engine = (NovelUpdateList)ctx.getBean("updateList");
		
	}
	
	@Test
	public void callSpringMethod(){
		
		List<String> urls = engine.getPageUrls();
		if(urls == null || urls.isEmpty())
			return ;
		Iterator<String> it = urls.iterator();
		while(it.hasNext()){
			String url =it.next();
			System.out.println(url);
		}
	}
}

package com.flyhawk.test;

import org.apache.http.impl.client.CloseableHttpClient;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flyhawk.crawl.CrawlConnection;

public class TestCrawlConnection {
	@Test
	public void callSpringMethod(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml");
		CrawlConnection hello = (CrawlConnection)ctx.getBean("crawlEngine");
		CloseableHttpClient client = hello.getHttpClient();
	}
}

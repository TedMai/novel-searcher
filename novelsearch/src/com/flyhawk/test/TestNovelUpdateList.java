package com.flyhawk.test;

import java.util.Iterator;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flyhawk.crawl.NovelUpdateList;

public class TestNovelUpdateList {
	NovelUpdateList novelUpdateList;
	@Before
	public void initCrawlEngine(){
		System.setProperty("org.apache.commons.logging.diagnostics.dest", "STDOUT" );
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml");
		novelUpdateList = (NovelUpdateList)ctx.getBean("novelUpdateList");
		
	}
	
	@Test
	public void testNovelUpdateList(){
		List<String> urls = novelUpdateList.getPageUrls();
		if(urls != null && !urls.isEmpty()){
			Iterator<String> it = urls.iterator();
			while(it.hasNext()){
				System.out.println(it.next());
			}
		}
	}
}

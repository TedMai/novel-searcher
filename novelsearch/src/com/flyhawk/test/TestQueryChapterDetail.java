package com.flyhawk.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flyhawk.crawl.NovelChapterDetail;

public class TestQueryChapterDetail {
	NovelChapterDetail novelChapterDetail;
	@Before
	public void initCrawlEngine(){
		System.setProperty("org.apache.commons.logging.diagnostics.dest", "STDOUT" );
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml");
		novelChapterDetail = (NovelChapterDetail)ctx.getBean("novelChapterDetail");
		
	}
	
	@Test
	public void getChapterList(){
		if(novelChapterDetail.queryChapterContent("http://book.zongheng.com/chapter/516129/8416047.html")){
			System.out.println(novelChapterDetail.getTitle());
			System.out.println(novelChapterDetail.getWordCount());
			System.out.println(novelChapterDetail.getContent());
		}
	}
}

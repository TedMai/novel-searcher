package com.flyhawk.test;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flyhawk.crawl.NovelInfo;

public class TestNovelInfo {
	
	NovelInfo novelInfo;
	@Before
	public void initCrawlEngine(){
		System.setProperty("org.apache.commons.logging.diagnostics.dest", "STDOUT" );
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml");
		novelInfo = (NovelInfo)ctx.getBean("novelInfo");
		
	}
	
	@Test
	public void testNovelInfo(){
		novelInfo.queryNovelInfo("http://book.zongheng.com/book/516129.html");
		System.out.println(novelInfo.getName());
		System.out.println(novelInfo.getAuthor());
		System.out.println(novelInfo.getDesc());
		System.out.println(novelInfo.getWordCount());
		System.out.println(novelInfo.getType());
		System.out.println(novelInfo.getLatestChapter());
		System.out.println(novelInfo.getChapterListUrl());
		System.out.println(novelInfo.getKeywords());
	}
}

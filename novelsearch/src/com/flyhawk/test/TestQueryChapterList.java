package com.flyhawk.test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.flyhawk.crawl.NovelChapterList;

public class TestQueryChapterList {
	NovelChapterList novelChapterList;
	@Before
	public void initCrawlEngine(){
		System.setProperty("org.apache.commons.logging.diagnostics.dest", "STDOUT" );
		ApplicationContext ctx = new ClassPathXmlApplicationContext("config/beans.xml");
		novelChapterList = (NovelChapterList)ctx.getBean("novelChapterList");
		
	}
	
	@Test
	public void getChapterList(){
		if(novelChapterList.queryChapterList("http://book.zongheng.com/showchapter/516129.html")){
			List<HashMap<String,String>> data = novelChapterList.getCharpterUrls();
			Iterator<HashMap<String,String>> it = data.iterator();
			while(it.hasNext()){
				HashMap<String,String> map = it.next();
				Iterator<Entry<String,String>> mapit = map.entrySet().iterator();
				while(mapit.hasNext()){
					Entry<String,String > entry = mapit.next();
					System.out.println(entry.getKey() + "=" + entry.getValue());
				}
				System.out.println("----------------------------------");
			}
		}
	}
}

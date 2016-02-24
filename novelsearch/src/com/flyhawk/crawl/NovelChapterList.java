package com.flyhawk.crawl;

import java.util.HashMap;
import java.util.List;

import com.flyhawk.util.RegExpUtil;

public class NovelChapterList {
	
	private CrawlEngine engine;
	private String chapterRegexpStr;
	
	private List<HashMap<String,String>> charpterUrls;
	
	public boolean queryChapterList(String chapterUrl){
		String pageContent = engine.readPageByGet(chapterUrl);
		if(pageContent!=null && !pageContent.isEmpty()){
			String filter = "<div class=\"booklist tomeBean\".*?tomeName=\"正文\".*?>(.*?)</div>";
			String filterContent = RegExpUtil.getFirstMatchedString(pageContent, filter, 1);
			charpterUrls = RegExpUtil.getMutilMatchedFields(filterContent, chapterRegexpStr,5, "chapterId","chapterName","wordNum","updateTime","chapterUrl");
			if(charpterUrls!=null && !charpterUrls.isEmpty())
				return true;
		}
		return false;
	}

	public void setEngine(CrawlEngine engine) {
		this.engine = engine;
	}

	public void setChapterRegexpStr(String chapterRegexpStr) {
		this.chapterRegexpStr = chapterRegexpStr;
	}

	public List<HashMap<String, String>> getCharpterUrls() {
		return charpterUrls;
	}
}

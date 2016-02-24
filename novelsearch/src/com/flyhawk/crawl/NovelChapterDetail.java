package com.flyhawk.crawl;

import com.flyhawk.util.RegExpUtil;

public class NovelChapterDetail {
	
	private CrawlEngine crawlEngine;
	
	private String title;
	private String wordCount;
	private String content;
	
	private String titleRegexpStr;
	private String wordcountRegexpStr;
	private String contentRegexpStr;
	
	public boolean queryChapterContent(String chapterUrl){
		String pageContent = crawlEngine.readPageByGet(chapterUrl);
		if(pageContent!=null && !pageContent.isEmpty()){
			title = RegExpUtil.getFirstMatchedString(pageContent, titleRegexpStr, 1);
			wordCount = RegExpUtil.getFirstMatchedString(pageContent, wordcountRegexpStr, 1);
			content = RegExpUtil.getFirstMatchedString(pageContent, contentRegexpStr, 1);
			return true;
		}
		return false;
	}

	public String getTitle() {
		return title;
	}

	public String getWordCount() {
		return wordCount;
	}

	public String getContent() {
		return content;
	}

	public void setCrawlEngine(CrawlEngine crawlEngine) {
		this.crawlEngine = crawlEngine;
	}

	public void setTitleRegexpStr(String titleRegexpStr) {
		this.titleRegexpStr = titleRegexpStr;
	}

	public void setWordcountRegexpStr(String wordcountRegexpStr) {
		this.wordcountRegexpStr = wordcountRegexpStr;
	}

	public void setContentRegexpStr(String contentRegexpStr) {
		this.contentRegexpStr = contentRegexpStr;
	}
}

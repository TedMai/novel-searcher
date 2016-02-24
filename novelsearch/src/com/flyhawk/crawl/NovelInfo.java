package com.flyhawk.crawl;

import com.flyhawk.util.RegExpUtil;

public class NovelInfo {
	
	private CrawlEngine engine;
	
	private String nameRegexpStr;
	private String authorRegexpStr;
	private String descRegexpStr;
	private String typeRegexpStr;
	private String lastchapterRegexpStr;
	private String chapterlisturlRegexpStr;
	private String wordcountRegexpStr;
	private String keywordsRegexpStr;
	
	private String name;
	private String author;
	private String desc;
	private String type;
	private String lastChapter;
	private String chapterListUrl;
	private String wordCount;
	private String keywords;
	
	public boolean queryNovelInfo(String pageUrl){
		
		String pageContent = engine.readPageByGet(pageUrl);
		if(pageContent !=null && !pageContent.isEmpty()){
			name = RegExpUtil.getFirstMatchedString(pageContent, nameRegexpStr, 1);
			author =RegExpUtil.getFirstMatchedString(pageContent, authorRegexpStr, 1);
			desc = RegExpUtil.getFirstMatchedString(pageContent, descRegexpStr, 1);
			lastChapter=RegExpUtil.getFirstMatchedString(pageContent, lastchapterRegexpStr, 1);
			type = RegExpUtil.getFirstMatchedString(pageContent, typeRegexpStr, 1);
			chapterListUrl = RegExpUtil.getFirstMatchedString(pageContent, chapterlisturlRegexpStr, 1);
			wordCount = RegExpUtil.getFirstMatchedString(pageContent, wordcountRegexpStr, 1);
			String rawKeywords = RegExpUtil.getFirstMatchedString(pageContent, keywordsRegexpStr, 1);
			keywords = RegExpUtil.getAllMatchedString(rawKeywords, "<a.*?>(.*?)</a>"," ", 1);
			return true;
		}
		return false;
	}
	
	/**
	 * 获取小说名
	 * @return
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * 小说作者
	 * @return
	 */
	public String getAuthor(){
		return author;
	}
	
	/***
	 * 小说描述
	 * @return
	 */
	public String getDesc(){
		return desc;
	}
	
	/***
	 * 小说分类
	 * @return
	 */
	public String getType(){
		return type;
	}
	
	/***
	 * 最新章节
	 * @return
	 */
	public String getLatestChapter(){
		return lastChapter;
	}
	
	/***
	 * 章节列表URL
	 * @return
	 */
	public String getChapterListUrl(){
		return chapterListUrl;
	}
	
	/***
	 * 字数
	 * @return
	 */
	public String getWordCount(){
		return wordCount;
	}
	
	/***
	 * 关键词
	 * @return
	 */
	public String getKeywords(){
		return keywords;
	}
	
	public CrawlEngine getEngine() {
		return engine;
	}
	
	public void setEngine(CrawlEngine engine) {
		this.engine = engine;
	}

	public String getNameRegexpStr() {
		return nameRegexpStr;
	}

	public String getAuthorRegexpStr() {
		return authorRegexpStr;
	}

	public String getDescRegexpStr() {
		return descRegexpStr;
	}

	public String getTypeRegexpStr() {
		return typeRegexpStr;
	}

	public String getLastchapterRegexpStr() {
		return lastchapterRegexpStr;
	}

	public String getChapterlisturlRegexpStr() {
		return chapterlisturlRegexpStr;
	}

	public String getWordcountRegexpStr() {
		return wordcountRegexpStr;
	}

	public String getKeywordsRegexpStr() {
		return keywordsRegexpStr;
	}

	public void setNameRegexpStr(String nameRegexpStr) {
		this.nameRegexpStr = nameRegexpStr;
	}

	public void setAuthorRegexpStr(String authorRegexpStr) {
		this.authorRegexpStr = authorRegexpStr;
	}

	public void setDescRegexpStr(String descRegexpStr) {
		this.descRegexpStr = descRegexpStr;
	}

	public void setTypeRegexpStr(String typeRegexpStr) {
		this.typeRegexpStr = typeRegexpStr;
	}

	public void setLastchapterRegexpStr(String lastchapterRegexpStr) {
		this.lastchapterRegexpStr = lastchapterRegexpStr;
	}

	public void setChapterlisturlRegexpStr(String chapterlisturlRegexpStr) {
		this.chapterlisturlRegexpStr = chapterlisturlRegexpStr;
	}

	public void setWordcountRegexpStr(String wordcountRegexpStr) {
		this.wordcountRegexpStr = wordcountRegexpStr;
	}

	public void setKeywordsRegexpStr(String keywordsRegexpStr) {
		this.keywordsRegexpStr = keywordsRegexpStr;
	}
}

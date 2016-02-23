package com.flyhawk.crawl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.flyhawk.util.RegExpUtil;

/***
 * 获得纵横小说网站的更新小说列表
 * @author Administrator
 *
 */
public class NovelUpdateList {
	
	private CrawlEngine engine;
	
	private String rootPath;
	private String regExpStr;
	private int matchedNum;
	private String separator;
	private boolean exclusiveFlag;
	private String exclusiveStr;
	private HashMap<String,String> requestHeaders;
	
	private final static Logger logger = LoggerFactory.getLogger(NovelUpdateList.class);
	
	public NovelUpdateList(){}
	
	public NovelUpdateList(String rootPath){
		this.rootPath = rootPath;
	}
	
	public List<String> getPageUrls(){
		
		List<String> result = null;
		logger.info("start to request the url: {}", rootPath);
		String pageContent = engine.readPageByGet(rootPath);
		logger.info("end the request.");
		logger.info("the request content is : {}" , pageContent);
		logger.info("start to filter the content, using the regular express-- {}" , regExpStr);
		String updateUrls = RegExpUtil.getAllMatchedString(pageContent, regExpStr, separator, matchedNum);
		logger.info("end the filter. the result is: {}" ,updateUrls);
		if(!updateUrls.isEmpty()){
			String[] urls = updateUrls.split(separator);
			result = new ArrayList<String>();
			for(String url : urls){
				if(exclusiveFlag && exclusiveStr!=null && !exclusiveStr.isEmpty()){
					Pattern pattern = Pattern.compile(exclusiveStr);
					Matcher matcher = pattern.matcher(url);
					if(matcher.find()){
						continue;
					}
				}
				logger.info(url);
				result.add(url);
			}
		}
		return result;
	}
	
	public void setRequestHeaders(HashMap<String,String> requestHeaders){
		engine.setRequestHeaders(requestHeaders);
	}

	public CrawlEngine getEngine() {
		return engine;
	}

	public String getRootPath() {
		return rootPath;
	}

	public String getRegExpStr() {
		return regExpStr;
	}

	public int getMatchedNum() {
		return matchedNum;
	}

	public String getSeparator() {
		return separator;
	}

	public String getExclusiveStr() {
		return exclusiveStr;
	}

	public void setEngine(CrawlEngine engine) {
		this.engine = engine;
	}

	public void setRootPath(String rootPath) {
		this.rootPath = rootPath;
	}

	public void setRegExpStr(String regExpStr) {
		this.regExpStr = regExpStr;
	}

	public void setMatchedNum(int matchedNum) {
		this.matchedNum = matchedNum;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

	public void setExclusiveStr(String exclusiveStr) {
		this.exclusiveStr = exclusiveStr;
	}

	public boolean isExclusiveFlag() {
		return exclusiveFlag;
	}

	public void setExclusiveFlag(boolean exclusiveFlag) {
		this.exclusiveFlag = exclusiveFlag;
	}
	
}

package com.flyhawk.crawl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;

/**
 * 网络爬虫主类
 * @author Administrator
 *
 */
public class CrawlEngine {
	
	
	/*
	 * 带参数的get方法请求
	 */
	public boolean readPageByGet(String url, HashMap<String,String> params) throws URISyntaxException{
		if( params == null || params.size() == 0){
			return readPageByGet( url);
		}
		URIBuilder uribuilder = new URIBuilder(url);
		Iterator<Entry<String,String>> paramsIterator = params.entrySet().iterator();
		while(paramsIterator.hasNext()){
			Entry<String,String> entry = paramsIterator.next();
			uribuilder.addParameter(entry.getKey(), entry.getValue());
		}
		return readPageByGet(uribuilder.build().toString());
	}
	
	/*
	 * 不带参数的get方法请求
	 */
	public boolean readPageByGet(String url){
		HttpGet httpget = new HttpGet(url);
		return false;
	}
	
	private boolean readPageByGet(){
		return false;
	}
}

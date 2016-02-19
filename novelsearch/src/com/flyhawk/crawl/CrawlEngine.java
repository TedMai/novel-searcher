package com.flyhawk.crawl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * 网络爬虫主类
 * @author Administrator
 *
 */
public class CrawlEngine extends CrawlConnection{
	
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
		CloseableHttpClient httpclient = getHttpClient();
		try {
			httpclient.execute(httpget);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}
	
	private boolean readPageByGet(){
		return false;
	}
}

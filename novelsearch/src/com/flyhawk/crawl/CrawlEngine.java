package com.flyhawk.crawl;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;

/**
 * 网络爬虫主类
 * @author Administrator
 *
 */
public class CrawlEngine extends CrawlConnection{
	
	private ResponseHandler<String> responseHandler;
	private HashMap<String,String> requestHeaders;
	
	/*
	 * 带参数的get方法请求
	 */
	public String readPageByGet(String url, HashMap<String,String> params) throws URISyntaxException{
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
	public String readPageByGet(String url){
		String result = "";
		HttpGet httpget = new HttpGet(url);
		if(requestHeaders!=null && requestHeaders.size() !=0){
			Iterator<Entry<String,String>> it = requestHeaders.entrySet().iterator();
			while(it.hasNext()){
				Entry<String,String> entry = it.next();
				httpget.addHeader(entry.getKey(), entry.getValue());
			}
		}
		CloseableHttpClient httpclient = getHttpClient();
		try {
			result = httpclient.execute(httpget,responseHandler);
			System.out.println(result);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	
	
	public ResponseHandler<String> getResponseHandler() {
		return responseHandler;
	}

	public void setResponseHandler(ResponseHandler<String> responseHandler) {
		this.responseHandler = responseHandler;
	}
	
	public HashMap<String, String> getRequestHeaders() {
		return requestHeaders;
	}

	public void setRequestHeaders(HashMap<String, String> requestHeaders) {
		this.requestHeaders = requestHeaders;
	}
}

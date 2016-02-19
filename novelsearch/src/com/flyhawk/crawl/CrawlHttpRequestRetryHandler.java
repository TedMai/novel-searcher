package com.flyhawk.crawl;

import java.io.IOException;

import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.protocol.HttpContext;

public class CrawlHttpRequestRetryHandler implements HttpRequestRetryHandler{

	private int maxConnectionTimes;
	
	public CrawlHttpRequestRetryHandler(){
		maxConnectionTimes = -1;
	}
	
	@Override
	public boolean retryRequest(IOException ioexception, int i,
			HttpContext httpcontext) {
		if(i<= maxConnectionTimes){
			return true;
		}
		return false;
	}

	public int getMaxConnectionTimes() {
		return maxConnectionTimes;
	}

	public void setMaxConnectionTimes(int maxConnectionTimes) {
		this.maxConnectionTimes = maxConnectionTimes;
	}
}

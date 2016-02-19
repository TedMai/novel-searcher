package com.flyhawk.crawl;

import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.conn.HttpClientConnectionManager;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

public class CrawlConnection {
	
	private CloseableHttpClient httpclient;
	private HttpClientConnectionManager connMrg;
	private ConnectionKeepAliveStrategy connectionKeepAliveStrategy;
	private HttpRequestRetryHandler httpRequestRetryHandler;
	private CrawlConfig crawlConfig;
	
	private static final Log logger = LogFactory.getLog(CrawlConnection.class);
	
	public CrawlConnection(){
	}
	
	public void init(){
		
		logger.info("initialing http connection start......");
		logger.info("use config " + crawlConfig);
		if(crawlConfig.isUsePool()){
			connMrg = new PoolingHttpClientConnectionManager();
			PoolingHttpClientConnectionManager cm = (PoolingHttpClientConnectionManager)connMrg;
			cm.setMaxTotal(crawlConfig.getMaxPoolSize());
			cm.setDefaultMaxPerRoute(crawlConfig.getDefaultMaxPerRouter());
			connMrg = cm;
			logger.info("Using PoolingHttpClientConnectionManager [ Poolsize= " + crawlConfig.getMaxPoolSize()+",DefaultMaxPerRoute="+crawlConfig.getDefaultMaxPerRouter()+"]");
		}else{
			connMrg = new BasicHttpClientConnectionManager();
			logger.info("Using BasicHttpClientConnectionManager.");
		}
		
        HttpClientBuilder httpClientBuilder = HttpClients.custom();
        httpClientBuilder.setConnectionManager(connMrg);
        httpClientBuilder.evictExpiredConnections();
        httpClientBuilder.evictIdleConnections(crawlConfig.getMaxIdleTime(), TimeUnit.MILLISECONDS);
        
        if(connectionKeepAliveStrategy !=null ){
			httpClientBuilder.setKeepAliveStrategy(connectionKeepAliveStrategy);
		}
        
        if(httpRequestRetryHandler !=null ){
        	 httpClientBuilder.setRetryHandler(httpRequestRetryHandler);
        }
        
        if(crawlConfig.isUserProxy()){
        	HttpHost proxyHost = new HttpHost(crawlConfig.getProxyHost(), crawlConfig.getProxyPort());
        	httpClientBuilder.setProxy(proxyHost);
        }
        
        RequestConfig requestConfig = RequestConfig.custom()
                .setSocketTimeout(crawlConfig.getReadTimeOut())
                .setConnectTimeout(crawlConfig.getConnectTimeOut())
                .setConnectionRequestTimeout(crawlConfig.getConnectRequestTimeOut())
                .build();
        httpClientBuilder.setDefaultRequestConfig(requestConfig);
        httpclient = httpClientBuilder.build();
        
        logger.info("initialing http connection end.");
	}
	
	public void shutdown(){
		connMrg.shutdown();
	}
	
	public CloseableHttpClient getHttpClient(){
		return httpclient;
	}
	
	public void setConnectionKeepAliveStrategy(
			ConnectionKeepAliveStrategy connectionKeepAliveStrategy) {
		this.connectionKeepAliveStrategy = connectionKeepAliveStrategy;
	}

	public void setHttpRequestRetryHandler(
			HttpRequestRetryHandler httpRequestRetryHandler) {
		this.httpRequestRetryHandler = httpRequestRetryHandler;
	}

	public void setCrawlConfig(CrawlConfig crawlConfig) {
		this.crawlConfig = crawlConfig;
	}
}

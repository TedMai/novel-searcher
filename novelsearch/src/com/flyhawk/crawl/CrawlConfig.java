package com.flyhawk.crawl;

/**
 * 
 * @author Administrator
 *
 */
public class CrawlConfig {
	
	private int connectTimeOut;
	private int readTimeOut;
	private int connectRequestTimeOut;
	private String defaultChartset;
	
	private boolean usePool;
	private int maxPoolSize;
	private int defaultMaxPerRouter;
	private int maxIdleTime;
	
	private boolean userProxy;
	private String proxyHost;
	private int proxyPort;
	
	public CrawlConfig(){
		
		connectTimeOut = 3000;
		readTimeOut = 3000;
		connectRequestTimeOut = -1;
		defaultChartset = "ISO-8859-1";
		
		usePool = true;
		maxPoolSize=10;
		defaultMaxPerRouter = 4;
		
		userProxy = false;
		maxIdleTime = -1;
	}

	public int getMaxIdleTime() {
		return maxIdleTime;
	}

	public boolean isUserProxy() {
		return userProxy;
	}

	public String getProxyHost() {
		return proxyHost;
	}

	public int getProxyPort() {
		return proxyPort;
	}

	public void setMaxIdleTime(int maxIdleTime) {
		this.maxIdleTime = maxIdleTime;
	}

	public void setUserProxy(boolean userProxy) {
		this.userProxy = userProxy;
	}

	public void setProxyHost(String proxyHost) {
		this.proxyHost = proxyHost;
	}

	public void setProxyPort(int proxyPort) {
		this.proxyPort = proxyPort;
	}

	public int getConnectTimeOut() {
		return connectTimeOut;
	}

	public int getReadTimeOut() {
		return readTimeOut;
	}

	public String getDefaultChartset() {
		return defaultChartset;
	}

	public boolean isUsePool() {
		return usePool;
	}

	public int getMaxPoolSize() {
		return maxPoolSize;
	}

	public int getDefaultMaxPerRouter() {
		return defaultMaxPerRouter;
	}

	public void setConnectTimeOut(int connectTimeOut) {
		this.connectTimeOut = connectTimeOut;
	}

	public void setReadTimeOut(int readTimeOut) {
		this.readTimeOut = readTimeOut;
	}

	public void setDefaultChartset(String defaultChartset) {
		this.defaultChartset = defaultChartset;
	}

	public void setUsePool(boolean usePool) {
		this.usePool = usePool;
	}

	public void setMaxPoolSize(int maxPoolSize) {
		this.maxPoolSize = maxPoolSize;
	}

	public void setDefaultMaxPerRouter(int defaultMaxPerRouter) {
		this.defaultMaxPerRouter = defaultMaxPerRouter;
	}
	
	public int getConnectRequestTimeOut() {
		return connectRequestTimeOut;
	}

	public void setConnectRequestTimeOut(int connectRequestTimeOut) {
		this.connectRequestTimeOut = connectRequestTimeOut;
	}
	
	@Override
	public String toString() {
		return "CrawlConfig [connectTimeOut=" + connectTimeOut
				+ ", readTimeOut=" + readTimeOut + ", connectRequestTimeOut="
				+ connectRequestTimeOut + ", defaultChartset="
				+ defaultChartset + ", usePool=" + usePool + ", maxPoolSize="
				+ maxPoolSize + ", defaultMaxPerRouter=" + defaultMaxPerRouter
				+ ", maxIdleTime=" + maxIdleTime + ", userProxy=" + userProxy
				+ ", proxyHost=" + proxyHost + ", proxyPort=" + proxyPort + "]";
	}
}

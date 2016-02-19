package com.flyhawk.crawl;

import org.apache.http.HeaderElement;
import org.apache.http.HeaderElementIterator;
import org.apache.http.HttpResponse;
import org.apache.http.conn.ConnectionKeepAliveStrategy;
import org.apache.http.message.BasicHeaderElementIterator;
import org.apache.http.protocol.HTTP;
import org.apache.http.protocol.HttpContext;

/**
 * http规范并没有规定连接就一定要保持和保持的时候要保持多久；有些HTTP服务器使用了一个不是标准的“Keep-Alive”头
 * 来告知客户端服务器想保持这个连接多长时间；HTTPClient默认的保留策略（DefaultConnectionKeepAliveStrategy)是：如果在响应头里没有Keep-Alive头，则假定连接可以永久保持；否则使用Keep-Alive里面的值;
 * 但是现在目前使用的大多数HTTP服务器为了节约系统资源会在连接无用的时候断开连接而不告知客户端；
 * @author Administrator
 *
 */
public class CrawlConnectionKeepAliveStrategy implements ConnectionKeepAliveStrategy {

	private int keepAliveTime;
	
	public CrawlConnectionKeepAliveStrategy(){
		this.keepAliveTime = -1;
	}
	@Override
	public long getKeepAliveDuration(HttpResponse response, HttpContext context) {
		// Honor 'keep-alive' header
        HeaderElementIterator it = new BasicHeaderElementIterator(
                response.headerIterator(HTTP.CONN_KEEP_ALIVE));
        while (it.hasNext()) {
            HeaderElement he = it.nextElement();
            String param = he.getName();
            String value = he.getValue();
            if (value != null && param.equalsIgnoreCase("timeout")) {
                try {
                    return Long.parseLong(value) * 1000;
                } catch(NumberFormatException ignore) {
                }
            }
        }
        return keepAliveTime;
	}
	
	public int getKeepAliveTime() {
		return keepAliveTime;
	}
	public void setKeepAliveTime(int keepAliveTime) {
		this.keepAliveTime = keepAliveTime;
	}

}

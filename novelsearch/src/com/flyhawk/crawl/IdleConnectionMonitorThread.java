package com.flyhawk.crawl;

import java.util.concurrent.TimeUnit;
import org.apache.http.conn.HttpClientConnectionManager;

/**
 * 典型的阻塞式IO模型的缺点是当阻塞在IO操作时，network socket才可以对I/O事件作出回应，当不是I/O操作，比如连接被放回连接池
 * 就不能再监控到network socket的状态,不能对I/O事件作出回应，如果服务端关闭了这个连接，客户端不能够检测到这
 * 个连接是无效的（或者当服务端关闭连接时，能够响应关闭客户端连接；
 * @author Administrator
 *
 */
public class IdleConnectionMonitorThread implements Runnable{
	
	private final HttpClientConnectionManager connMgr;
    private volatile boolean shutdown;
    
    public IdleConnectionMonitorThread(HttpClientConnectionManager connMgr) {
        this.connMgr = connMgr;
    }

    @Override
    public void run() {
        try {
            while (!shutdown) {
                synchronized (this) {
                    wait(5000);
                    // Close expired connections
                    connMgr.closeExpiredConnections();
                    // Optionally, close connections
                    // that have been idle longer than 30 sec
                    connMgr.closeIdleConnections(30, TimeUnit.SECONDS);
                }
            }
        } catch (InterruptedException ex) {
            // terminate
        }
    }
    
    public void shutdown() {
        shutdown = true;
        synchronized (this) {
            notifyAll();
        }
    }
}

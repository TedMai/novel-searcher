package com.flyhawk.crawl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.ContentType;

public class CrawlStringResponseHandler implements ResponseHandler<String>{

	private static final Log logger = LogFactory.getLog(CrawlStringResponseHandler.class);

	@Override
	public String handleResponse(HttpResponse httpresponse)
			throws ClientProtocolException, IOException {
		StatusLine statusLine = httpresponse.getStatusLine();
		logger.info(statusLine);
		if(statusLine.getStatusCode() >=300){
			logger.info("http response error: "+ statusLine.getStatusCode() + ", "+statusLine.getReasonPhrase());
			return null;
		}
		Header[] responseHeaders = httpresponse.getAllHeaders();
		for(Header header : responseHeaders ){
			logger.info(header.getName() + "=" + header.getValue());
		}
		HttpEntity httpEntity = httpresponse.getEntity();
		ContentType contentType = ContentType.getOrDefault(httpEntity);
	    Charset charset = contentType.getCharset();
	    BufferedReader reader = new BufferedReader(new InputStreamReader(httpEntity.getContent(), charset));
	    String responseString = "";
	    StringBuffer sb = new StringBuffer();
	    while((responseString = reader.readLine())!=null){
	    	sb.append(responseString);
	    }
	    reader.close();
		return sb.toString();
	}

}

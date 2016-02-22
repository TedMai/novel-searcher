package com.flyhawk.crawl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.ContentType;
import org.json.JSONObject;

public class CrawlJsonResponseHandler implements ResponseHandler<JSONObject>{

	
	@Override
	public JSONObject handleResponse(HttpResponse response) throws ClientProtocolException,
			IOException {
		
		StatusLine statusLine = response.getStatusLine();
        HttpEntity entity = response.getEntity();
        if (statusLine.getStatusCode() >= 300) {
            throw new HttpResponseException(
                    statusLine.getStatusCode(),
                    statusLine.getReasonPhrase());
        }
        if (entity == null) {
            throw new ClientProtocolException("Response contains no content");
        }
        
        ContentType contentType = ContentType.getOrDefault(entity);
        Charset charset = contentType.getCharset();
        BufferedReader reader = new BufferedReader(new InputStreamReader(entity.getContent(), charset));
        JSONObject jsonObject = new JSONObject(reader.readLine());
        reader.close();
		return jsonObject;
	}

}

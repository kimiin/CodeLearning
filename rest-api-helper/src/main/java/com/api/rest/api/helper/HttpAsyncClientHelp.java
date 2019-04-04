package com.api.rest.api.helper;

import java.io.File;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.nio.client.CloseableHttpAsyncClient;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.ssl.SSLContextBuilder;

import com.api.rest.api.model.RestResponse;

public class HttpAsyncClientHelp {
	
	/**Process different kinds of content of POST Request**/
	private static HttpEntity getHttpEntity(Object content, ContentType type) {
		if (content instanceof String)
			return new StringEntity((String)content, type);
		else if (content instanceof File)
			return new FileEntity((File)content, type);
		else 
			throw new RuntimeException("Entity Type not found.");
	}
	
	/**Get Headers of any Request**/
		private static Header[] getCustomHeaders(Map<String, String> headers) {
			Header[] customHeaders= new Header[headers.size()];
			int i=0;
			for(String key:headers.keySet()) {
				customHeaders[i++]= new BasicHeader(key, headers.get(key));
			}
			return customHeaders;
		}
		
	public static SSLContext getSSLContext() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		TrustStrategy trust = new TrustStrategy() {
			
			@Override
			public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				// TODO Auto-generated method stub
				return true;
			}
		};
		return SSLContextBuilder.create().loadTrustMaterial(trust).build();	
	}
	
	public static CloseableHttpAsyncClient getHttpAsyncClient(SSLContext context) {
		if(context==null)
			return HttpAsyncClientBuilder.create().build();
		else 
			return HttpAsyncClientBuilder.create().setSSLContext(context).build();
	}
	
	/*public static RestResponse performResquest(HttpUriRequest method, SSLContext context) {
		try (CloseableHttpAsyncClient client = getHttpAsyncClient(context)) {
			client.execute(method, context);
			
		}catch(Exception ex) {
			
		}
	}*/
		
	
	
	
	
}

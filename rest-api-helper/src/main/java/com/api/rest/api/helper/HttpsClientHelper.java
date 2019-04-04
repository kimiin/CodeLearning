package com.api.rest.api.helper;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Map;

import javax.net.ssl.SSLContext;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.TrustStrategy;

import com.api.rest.api.model.RestResponse;

public class HttpsClientHelper {
	
	/**Get SSL Certificate Status**/
	public static SSLContext getSSLContext() throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
		TrustStrategy trust = new TrustStrategy() {
			
			@Override
			public boolean isTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				return true;
			}
		};
		return SSLContextBuilder.create().loadTrustMaterial(trust).build();
	}
	
	/**Get client with the SSL Context**/
	public static CloseableHttpClient getHttpClient(SSLContext sslContext) {
		return HttpClientBuilder.create().setSSLContext(sslContext).build();
	}
	
	/**Get Headers of any Request**/
	public static Header[] getCustomHeaders(Map<String, String> headers) {
		Header[] customHeaders = new Header[headers.size()];
		int i=0;
		for(String key : headers.keySet())
			customHeaders[i++] = new BasicHeader(key, headers.get(key));
		return customHeaders;
	}
	
	/**Process different kinds of content of POST Request**/
	public static HttpEntity getEntity(Object content, ContentType type) {
		if(content instanceof String)
			return new StringEntity((String) content, type);
		else if (content instanceof File)
			return new FileEntity((File)content, type);
		else
			throw new RuntimeException("Entity Type not found.");		
	}
		
	/**General Request**/
	public static RestResponse performRequestWithSSL(HttpUriRequest method) {
		CloseableHttpResponse response = null;
		try(CloseableHttpClient client = getHttpClient(getSSLContext())){
			response=client.execute(method);
			ResponseHandler<String> handler = new BasicResponseHandler();
			return new RestResponse(response.getStatusLine().getStatusCode(), handler.handleResponse(response));
		}catch(Exception ex) {
			if (ex instanceof HttpResponseException)
				return new RestResponse(response.getStatusLine().getStatusCode(), ex.getMessage()+"No body returned.");
			throw new RuntimeException(ex.getMessage(), ex);
		}
	}
	
		
	/**Perform GET Request with a string of url**/
	public static RestResponse performGetRequestWithSSL(String url, Map<String, String> headers) {
		try {
			return performGetRequestWithSSL(new URI(url), headers);
		} catch (URISyntaxException e) {
			throw new RuntimeException (e.getMessage(), e);
		}
	}
	
	/**Perform GET Request with a URI**/
	public static RestResponse performGetRequestWithSSL(URI uri, Map<String, String> headers) {
		HttpGet get = new HttpGet(uri);		
		if(headers!=null) 
			get.setHeaders(getCustomHeaders(headers));		
		return performRequestWithSSL(get);
	}
	
	/**Perform POST Request with a string of url**/
	public static RestResponse performPostRequestWithSSL(String url, Map<String, String> headers, Object content, ContentType type)
	{
		try {
			return performPostRequestWithSSL(new URI(url), headers, content, type);
		} catch (URISyntaxException e) {
			throw new RuntimeException (e.getMessage(), e);
		}
	}
	
	/**Perform POST Request with a URI**/
	public static RestResponse performPostRequestWithSSL(URI uri, Map<String, String> headers, Object content, ContentType type)
	{
		HttpUriRequest post = RequestBuilder.post(uri).setEntity(getEntity(content, type)).build();
		if(null != headers)
			post.setHeaders(getCustomHeaders(headers));
		return performRequestWithSSL(post);
	}
	
	/**Perform DELETE Request with a string of URI**/
	public static RestResponse performDeleteRequestWithSSL(String uri, Map<String, String> headers)
	{
		try {
			return performDeleteRequestWithSSL(new URI(uri), headers);
		} catch (URISyntaxException e) {
			throw new RuntimeException (e.getMessage(), e);
		}
	}
	
	/**Perform DELETE Request with a URI**/
	public static RestResponse performDeleteRequestWithSSL(URI uri, Map<String, String> headers)
	{
		HttpUriRequest delete = RequestBuilder.delete(uri).build();
		if(null != headers)
			delete.setHeaders(getCustomHeaders(headers));
		return performRequestWithSSL(delete);
	}
	
	/**Perform PUT Request with a string of URI**/
	public static RestResponse performPutRequestWithSSL(String uri, Map<String, String> headers, Object content, ContentType type)
	{
		try {
			return performPutRequestWithSSL(new URI(uri), headers, content, type);
		} catch (URISyntaxException e) {
			throw new RuntimeException (e.getMessage(), e);
		}
	}
	
	/**Perform PUT Request with a URI**/
	public static RestResponse performPutRequestWithSSL(URI uri, Map<String, String> headers, Object content, ContentType type)
	{
		HttpUriRequest put = RequestBuilder.put(uri).setEntity(getEntity(content, type)).build();
		if(null != headers)
			put.setHeaders(getCustomHeaders(headers));
		return performRequestWithSSL(put);
	}	
}

package com.api.rest.api.helper;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHeader;

import com.api.rest.api.model.RestResponse;

public class RestApiHelper {
	
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
		
	/**General Request**/
	private static RestResponse performRequest(HttpUriRequest method) {
		CloseableHttpResponse response = null;
		try (CloseableHttpClient client = HttpClientBuilder.create().build()) {
			 response = client.execute(method);			
			 ResponseHandler<String> body = new BasicResponseHandler();
			 return new RestResponse(response.getStatusLine().getStatusCode(), body.handleResponse(response));			
		} 
		catch (Exception ex) {
			if(ex instanceof HttpResponseException)
				return new RestResponse(response.getStatusLine().getStatusCode(), ex.getMessage()+"No body returned.");
			throw new RuntimeException (ex.getMessage(), ex);			
		}	
	}
			
	/**Perform GET Request with a string of url**/
	public static RestResponse performGetRequest(String url, Map <String, String> headers) {
		try {
			return performGetRequest(new URI(url), headers);
		}
		catch (URISyntaxException ex) {
			throw new RuntimeException (ex.getMessage(), ex);
		}
		
	}
	
	/**Perform GET Request with a URI**/
	public static RestResponse performGetRequest(URI uri, Map <String, String> headers) {
		HttpGet get = new HttpGet(uri);		
		if(headers != null) {
			/*for(String str : headers.keySet()) {
				get.addHeader(str,headers.get(str));
			}*/
			get.setHeaders(getCustomHeaders(headers));
		}
		
		return performRequest(get);			
	}	
	
	/**Perform POST Request with a string of url**/
	public static RestResponse performPostRequest (String url, Map<String, String> headers, Object content, ContentType type) {
		try {
			return performPostRequest(new URI(url), headers, content, type);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	/**Perform POST Request with a URI**/
	public static RestResponse performPostRequest (URI uri, Map<String,String> headers, Object content, ContentType type){
		HttpPost post = new HttpPost(uri);	
		if(headers!=null)
			post.setHeaders(getCustomHeaders(headers));	
		//post.setEntity(new StringEntity(content, ContentType.APPLICATION_JSON));		
		post.setEntity(getHttpEntity(content, type));		
		/*try(CloseableHttpClient client = HttpClientBuilder.create().build()){			
			response = client.execute(post);
			ResponseHandler<String> handler = new BasicResponseHandler();
			return new RestResponse(response.getStatusLine().getStatusCode(), handler.handleResponse(response) );			
		}catch (Exception ex) {			
			if(ex instanceof HttpResponseException)
				return new RestResponse(response.getStatusLine().getStatusCode(), ex.getMessage());
			throw new RuntimeException(ex.getMessage(), ex);
		}*/
		return performRequest(post);
	}
	
	/**Perform DELETE Request with a string of url**/
	public static RestResponse performDeleteRequest (String url, Map<String, String> headers) {
		try {
			return performDeleteRequest(new URI(url), headers);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
		
	}
	
	/**Perform DELETE Request with a URI**/
	public static RestResponse performDeleteRequest(URI uri, Map<String, String> headers) {
		HttpUriRequest delete = RequestBuilder.delete(uri).build();
		if(headers!=null)
			delete.setHeaders(getCustomHeaders(headers));
		return performRequest(delete);
	}
	
	/**Perform PUT request with a string url**/
	public static RestResponse performPutRequest (String url, Map<String, String> headers, Object content, ContentType type) {
		try {
			return performPutRequest(new URI(url), headers, content, type);
		} catch (URISyntaxException e) {
			throw new RuntimeException(e.getMessage(), e);
		}
	}
	
	/**Perform PUT request with a URI**/
	public static RestResponse performPutRequest (URI uri, Map<String, String> headers, Object content, ContentType type) {
		HttpUriRequest put = RequestBuilder.put(uri).setEntity(getHttpEntity(content, type)).build();
		if(headers!=null)
			put.setHeaders(getCustomHeaders(headers));
		return performRequest(put);
	}
	
}

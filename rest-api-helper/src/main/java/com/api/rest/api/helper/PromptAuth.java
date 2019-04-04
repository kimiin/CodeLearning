package com.api.rest.api.helper;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.api.rest.api.model.RestResponse;

public class PromptAuth {

	public static void main(String[] args) {
		
		//Prompt Auth
		/*Credentials credential = new UsernamePasswordCredentials("admin", "admin");
		CredentialsProvider provider = new BasicCredentialsProvider();
		provider.setCredentials(AuthScope.ANY, credential);		
		HttpClientContext promptContext = HttpClientContext.create();
		promptContext.setCredentialsProvider(provider);
		
		HttpGet get = new HttpGet("http://localhost:8080/laptop-bag/webapi/prompt/all");
		get.addHeader("Accept", "application/json");
		try(CloseableHttpClient client = HttpClientBuilder.create().build();
				CloseableHttpResponse response = client.execute(get, promptContext)){
			ResponseHandler<String> handler = new BasicResponseHandler();
			RestResponse restReponse = new RestResponse(response.getStatusLine().getStatusCode(), handler.handleResponse(response));
			System.out.println(restReponse.toString());
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//SSL Auth
		/*RestResponse restResponse = RestApiHelper.performGetRequest("http://localhost:8080/laptop-bag/webapi/sslres/all", null);*/
		RestResponse restResponse = HttpsClientHelper.performGetRequestWithSSL("http://localhost:8080/laptop-bag/webapi/sslres/all", null);
		System.out.println(restResponse.toString());
	}
}

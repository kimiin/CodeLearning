package com.api.webservice.test;

import org.apache.http.StatusLine;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class GetRequest {

	/**
	 * 1. Create the HTTP Get Method
	 * 2. Create the Http Client
	 * 3. Execute Get Method by Client
	 * 4. Catch return response and validate the response 
	 * 5. Display response to console
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			HttpGet get = new HttpGet("http://13.250.134.32/subrion/registration/");
			CloseableHttpClient client = HttpClientBuilder.create().build();
			CloseableHttpResponse response = client.execute(get);
			StatusLine status = response.getStatusLine();
			System.out.println(status.getStatusCode());
			System.out.println(status.getProtocolVersion());
		}
		catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}

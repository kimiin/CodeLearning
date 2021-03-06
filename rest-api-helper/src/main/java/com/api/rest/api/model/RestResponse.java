package com.api.rest.api.model;

public class RestResponse {
	
	private int statusCode;
	private String responseBody;
	
	//getter & setter
	public int getStatusCode() {
		return statusCode;
	}
	public String getResponseBody() {
		return responseBody;
	}
	
	public RestResponse(int statusCode, String responseBody ) {
		this.statusCode=statusCode;
		this.responseBody=responseBody;
	}
	
	@Override
	public String toString() {
		return String.format("Status Code : %1s Body : %2s", getStatusCode(), getResponseBody());
	}
	
}	

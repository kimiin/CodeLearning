package com.api.rest.api.helper;

//import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;
import org.junit.Assert;
import org.junit.Test;

import com.api.rest.api.model.ResponseBody;
import com.api.rest.api.model.RestResponse;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestPostMethod {
	
	@Test
	public void testPostWithJson() {
		String id=(int)(1000*(Math.random()))+"";
		String jsonBody = "{"+
		        "\"BrandName\": \"Dell\","+
		        "\"Features\": {"+
		            "\"Feature\": ["+
		                "\"8GB RAM\","+
		                "\"1TB Hard Drive\"]"+
		        "},"+
		        "\"Id\": "+ id +","+
		        "\"LaptopName\": \"Latitude\""+
		"}";
		
		//Post Request
		String url = "http://localhost:8080/laptop-bag/webapi/api/add";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept", "application/json");
		headers.put("Content-Type", "application/json");
		RestResponse restResponse = RestApiHelper.performPostRequest(url, headers, jsonBody, ContentType.APPLICATION_JSON);
		Assert.assertTrue ("Expected status Code not found", (HttpStatus.SC_OK == restResponse.getStatusCode()) || (HttpStatus.SC_NO_CONTENT == restResponse.getStatusCode()));
				
		//Get Request
		restResponse = RestApiHelper.performGetRequest("http://localhost:8080/laptop-bag/webapi/api/find/"+id,headers);
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.serializeNulls().setPrettyPrinting().create();
		ResponseBody body = gson.fromJson(restResponse.getResponseBody(), ResponseBody.class);
		
		Assert.assertEquals("Dell", body.getBrandName());
		List<String> expectedFeature = Arrays.asList("8GB RAM", "1TB Hard Drive");
		Assert.assertEquals(expectedFeature,body.getFeatures().getFeature());
		Assert.assertEquals("8GB RAM",body.getFeatures().getFeature().get(0));
		Assert.assertEquals("1TB Hard Drive",body.getFeatures().getFeature().get(1));
		Assert.assertEquals(id, body.getId());
		Assert.assertEquals("Latitude", body.getLaptopName());	
				
		System.out.println(body.getFeatures().getFeature());
		System.out.println(body.getFeatures().getFeature().get(0));
		System.out.println(body.getFeatures().getFeature().get(1));
		
	}
	
	/*@Test
	public void testPostWithXml() {
		String id=(int)(1000*(Math.random()))+"";
		String jsonBody = "{"+
		        "\"BrandName\": \"Dell\","+
		        "\"Features\": {"+
		            "\"Feature\": ["+
		                "\"9GB RAM\","+
		                "\"15.5 inch screen\","+
		                "\"2TB Hard Drive\"]"+
		        "},"+
		        "\"Id\": "+ id +","+
		        "\"LaptopName\": \"Latitude\""+
		"}";
		
		String url = "http://localhost:8080/laptop-bag/webapi/api/add";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept", "application/xml");
		headers.put("Content-Type", "application/json");
		RestResponse restResponse = RestApiHelper.performPostRequest(url, headers, jsonBody, ContentType.APPLICATION_JSON);		
		Assert.assertTrue ("Expected status Code not found", (HttpStatus.SC_OK == restResponse.getStatusCode()) || (HttpStatus.SC_NO_CONTENT == restResponse.getStatusCode()));
		restResponse = RestApiHelper.performGetRequest("http://localhost:8080/laptop-bag/webapi/api/find/"+id,headers);
		XmlMapper xml = new XmlMapper();
		xml.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);		
		try {
			ResponseBody body = xml.readValue(restResponse.getResponseBody(), ResponseBody.class);
			
			Assert.assertEquals("Dell", body.getBrandName());
			List<String> expectedFeature = Arrays.asList("8GB RAM", "1TB Hard Drive");
			Assert.assertEquals(expectedFeature,body.getFeatures().getFeature());
			Assert.assertEquals("8GB RAM",body.getFeatures().getFeature().get(0));
			Assert.assertEquals("1TB Hard Drive",body.getFeatures().getFeature().get(1));
			Assert.assertEquals(id, body.getId());
			Assert.assertEquals("Latitude", body.getLaptopName());	
			//System.out.println(body);
		}catch (IOException e) {
			e.printStackTrace();
		}		
	}*/
}

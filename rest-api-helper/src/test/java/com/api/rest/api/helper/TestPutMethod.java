package com.api.rest.api.helper;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;
import org.junit.Assert;
import org.junit.Test;

import com.api.rest.api.model.ResponseBody;
import com.api.rest.api.model.RestResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class TestPutMethod {

	/**
	 * Step 1 : Call the Post method, validation will be 200 OK
	 * Step 2 : Call the Put method which will update the content , 200 OK 
	 * Step 3 : Call the Get end-point to validate the output , content validation
	 */
	
	@Test
	public void testPut() {
		
		String id = (int)(1000*(Math.random()))+"";
		String xmlBody = "<Laptop>"+
		        "<BrandName>Lenovo</BrandName>"+
		        "<Features>"+
		            "<Feature>8GB RAM</Feature>"+
		            "<Feature>1TB Hard Drive</Feature>"+
		            "<Feature>15.5 inch Screen</Feature>"+
		            "<Feature>128 GB SSD</Feature>"+
		            "<Feature>USB 3.0</Feature>"+
		            "<Feature>4 GB Graphics Card</Feature>"+
		            "<Feature>Put with "+id+"</Feature>"+
		        "</Features>"+
		        "<Id>"+id+"</Id>"+
		        "<LaptopName>L Series</LaptopName>"+
		"</Laptop>";		
		String jsonBody = "{"+
				"\"BrandName\": \"Dell\","+
				"\"Features\": {"+
					"\"Feature\": ["+
						"\"8GB RAM\","+
						"\"1TB Hard Drive\"]"+
					"},"+
				"\"Id\": "+ id+","+
				"\"LaptopName\": \"Latitude\""+
				"}";
		//Post Request
		String urlPost="http://localhost:8080/laptop-bag/webapi/api/add";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept", "application/json");
		headers.put("Content-Type", "application/json");
		RestResponse restResponse = RestApiHelper.performPostRequest(urlPost, headers, jsonBody, ContentType.APPLICATION_JSON);
		Assert.assertEquals(restResponse.getStatusCode(), HttpStatus.SC_OK);
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.serializeNulls().setPrettyPrinting().create();
		ResponseBody body = gson.fromJson(restResponse.getResponseBody(), ResponseBody.class);		
		
		Assert.assertEquals("Dell", body.getBrandName());
		Assert.assertEquals("Latitude", body.getLaptopName());
		Assert.assertEquals(id, body.getId());		
		Assert.assertEquals("8GB RAM", body.getFeatures().getFeature().get(0));
		Assert.assertEquals("1TB Hard Drive", body.getFeatures().getFeature().get(1));		
		
			
		//Put Request
		String urlPut="http://localhost:8080/laptop-bag/webapi/api/update";
		headers.clear();
		headers.put("Content-Type", "application/xml");
		headers.put("Accept", "application/json");
		restResponse = RestApiHelper.performPutRequest(urlPut, headers, xmlBody, ContentType.APPLICATION_XML);
		Assert.assertEquals(restResponse.getStatusCode(), HttpStatus.SC_OK);
		
		body = gson.fromJson(restResponse.getResponseBody(), ResponseBody.class);	
		Assert.assertEquals("Lenovo", body.getBrandName());
		Assert.assertEquals("L Series", body.getLaptopName());
		Assert.assertEquals(id, body.getId());		
		Assert.assertEquals("8GB RAM", body.getFeatures().getFeature().get(0));
		Assert.assertEquals("1TB Hard Drive", body.getFeatures().getFeature().get(1));
		Assert.assertEquals("15.5 inch Screen", body.getFeatures().getFeature().get(2));
		Assert.assertEquals("128 GB SSD", body.getFeatures().getFeature().get(3));
		Assert.assertEquals("USB 3.0", body.getFeatures().getFeature().get(4));
		Assert.assertEquals("4 GB Graphics Card", body.getFeatures().getFeature().get(5));
		Assert.assertEquals("Put with "+id, body.getFeatures().getFeature().get(6));
		
		
		//Get Request
		String urlGet="http://localhost:8080/laptop-bag/webapi/api/find/"+id;
		headers.clear();
		headers.put("Accept", "application/json");
		restResponse = RestApiHelper.performGetRequest(urlGet, headers);
		Assert.assertEquals(restResponse.getStatusCode(), HttpStatus.SC_OK);
		
		body = gson.fromJson(restResponse.getResponseBody(), ResponseBody.class);	
		Assert.assertEquals("Lenovo", body.getBrandName());
		Assert.assertEquals("L Series", body.getLaptopName());
		Assert.assertEquals(id, body.getId());		
		Assert.assertEquals("8GB RAM", body.getFeatures().getFeature().get(0));
		Assert.assertEquals("1TB Hard Drive", body.getFeatures().getFeature().get(1));
		Assert.assertEquals("15.5 inch Screen", body.getFeatures().getFeature().get(2));
		Assert.assertEquals("128 GB SSD", body.getFeatures().getFeature().get(3));
		Assert.assertEquals("USB 3.0", body.getFeatures().getFeature().get(4));
		Assert.assertEquals("4 GB Graphics Card", body.getFeatures().getFeature().get(5));
		Assert.assertEquals("Put with "+id, body.getFeatures().getFeature().get(6));			
	}
	
	@Test
	public void testPutNotFound() {
		
		String xmlBody = "<Laptop>"+
		        "<BrandName>Lenovo</BrandName>"+
		        "<Features>"+
		            "<Feature>8GB RAM</Feature>"+
		            "<Feature>1TB Hard Drive</Feature>"+
		            "<Feature>15.5 inch Screen</Feature>"+
		            "<Feature>128 GB SSD</Feature>"+
		            "<Feature>USB 3.0</Feature>"+
		            "<Feature>4 GB Graphics Card</Feature>"+
		            "<Feature>Put with "+2345+"</Feature>"+
		        "</Features>"+
		        "<Id>"+2345+"</Id>"+
		        "<LaptopName>L Series</LaptopName>"+
		"</Laptop>";		
					
		//Put Request
		String urlPut="http://localhost:8080/laptop-bag/webapi/api/update";
		Map<String, String> headers = new HashMap<String, String>();
		headers.clear();
		headers.put("Content-Type", "application/xml");
		headers.put("Accept", "application/json");
		RestResponse restResponse = RestApiHelper.performPutRequest(urlPut, headers, xmlBody, ContentType.APPLICATION_XML);
		Assert.assertEquals(restResponse.getStatusCode(), HttpStatus.SC_NOT_FOUND);	
	}
}

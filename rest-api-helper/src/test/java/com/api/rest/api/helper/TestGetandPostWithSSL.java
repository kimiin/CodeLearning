package com.api.rest.api.helper;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.apache.http.entity.ContentType;

import com.api.rest.api.model.ResponseBody;
import com.api.rest.api.model.RestResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.junit.Assert;
import org.junit.Test;

public class TestGetandPostWithSSL {

	@Test
	public void testGetnPost() {
		String id = (int) (1000*(Math.random())) + "";
		System.out.println(id);
		String jsonBody = "{"+
		        "\"BrandName\": \"Dell\","+
		        "\"Features\": {"+
		            "\"Feature\": ["+
		                "\"8GB RAM\","+
		                "\"1TB Hard Drive\"]"+
		        "},"+
		        "\"Id\": "+id+","+
		        "\"LaptopName\": \"Latitude\""+
		"}";
		
		//Post Request
		String postURL="https://localhost:8443/laptop-bag/webapi/sslres/add";
		Map<String, String> headers = new HashMap<String, String>();
		//headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		RestResponse restResponse = HttpsClientHelper.performPostRequestWithSSL(postURL, headers, jsonBody, ContentType.APPLICATION_JSON);
		Assert.assertEquals(HttpStatus.SC_OK, restResponse.getStatusCode());
		
		//Get Request
		String getItem="https://localhost:8443/laptop-bag/webapi/sslres/find/"+id;
		restResponse = HttpsClientHelper.performGetRequestWithSSL(getItem, headers);
		Assert.assertEquals(HttpStatus.SC_OK, restResponse.getStatusCode());
		
		//GSON
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.serializeNulls().setPrettyPrinting().create();
		ResponseBody body = gson.fromJson(restResponse.getResponseBody(), ResponseBody.class);
		
		Assert.assertEquals("Dell", body.getBrandName());
		Assert.assertEquals(id, body.getId());
		Assert.assertEquals("Latitude", body.getLaptopName());	
		List<String> expectedFeature = Arrays.asList("8GB RAM", "1TB Hard Drive");
		Assert.assertEquals(expectedFeature,body.getFeatures().getFeature());
		/*Assert.assertEquals("8GB RAM",body.getFeatures().getFeature().get(0));
		Assert.assertEquals("1TB Hard Drive",body.getFeatures().getFeature().get(1));*/
		

	}
}

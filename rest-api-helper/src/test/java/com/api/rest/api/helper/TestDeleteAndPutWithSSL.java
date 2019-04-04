package com.api.rest.api.helper;

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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class TestDeleteAndPutWithSSL {
	
	/**
	 * Step 1 : Post the data, verify the 200 OK
	 * Step 2 : Get the data using GET end point, verify the id also verify the status code
	 * Step 3 : Update the data in the container using PUT end point , verify the status code
	 * Step 4 : Get the data using GET end point, verify the id also verify the status code
	 * Step 5 : Delete the data using DELETE end point, verify the status code
	 * Step 6 : Get the data using GET end point, verify the id also verify the status code 
	 */
	
	@Test
	public void testDeleteAndPut() {
		String id = (int) (1000*(Math.random())) + "";
		System.out.println(id);
		String jsonBody = "{"+
		        "\"BrandName\": \"Dell\","+
		        "\"Features\": {"+
		            "\"Feature\": ["+
		            	"\"This is POST request\","+
		                "\"8GB RAM\","+
		                "\"1TB Hard Drive\"]"+
		        "},"+
		        "\"Id\": "+id+","+
		        "\"LaptopName\": \"Latitude\""+
		"}";
		
		String xmlBody = "<Laptop>"+
		        "<BrandName>Lenovo</BrandName>"+
		        "<Features>"+
		            "<Feature>8GB RAM</Feature>"+
		            "<Feature>1TB Hard Drive</Feature>"+
		            "<Feature>15.5 inch Screen</Feature>"+
		            "<Feature>128 GB SSD</Feature>"+
		            "<Feature>USB 3.0</Feature>"+
		            "<Feature>4 GB Graphics Card</Feature>"+
		            "<Feature>This is PUT request</Feature>"+
		        "</Features>"+
		        "<Id>"+id+"</Id>"+
		        "<LaptopName>Z Series</LaptopName>"+
		"</Laptop>";
		
		//Post Request
		String postURL="https://localhost:8443/laptop-bag/webapi/sslres/add";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept", "application/json");
		RestResponse restResponse = HttpsClientHelper.performPostRequestWithSSL(postURL, headers, jsonBody, ContentType.APPLICATION_JSON);
		Assert.assertEquals(HttpStatus.SC_OK, restResponse.getStatusCode());
		
		//Get Request
		String getItemUrl="https://localhost:8443/laptop-bag/webapi/sslres/find/"+id;
		restResponse = HttpsClientHelper.performGetRequestWithSSL(getItemUrl, headers);
		Assert.assertEquals(HttpStatus.SC_OK, restResponse.getStatusCode());
		
		//GSON
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.serializeNulls().setPrettyPrinting().create();
		ResponseBody body = gson.fromJson(restResponse.getResponseBody(), ResponseBody.class);		
		Assert.assertEquals(id, body.getId());
		
		//----------
		//Put Request
		String putURL="https://localhost:8443/laptop-bag/webapi/sslres/update";
		restResponse = HttpsClientHelper.performPutRequestWithSSL(putURL, headers, xmlBody, ContentType.APPLICATION_XML);
		Assert.assertEquals(HttpStatus.SC_OK, restResponse.getStatusCode());
		
		//Get Request
		restResponse = HttpsClientHelper.performGetRequestWithSSL(getItemUrl, headers);
		Assert.assertEquals(HttpStatus.SC_OK, restResponse.getStatusCode());
		
		//GSON
		body = gson.fromJson(restResponse.getResponseBody(), ResponseBody.class);		
		Assert.assertEquals("Z Series", body.getLaptopName());	
		Assert.assertEquals(id, body.getId());
		Assert.assertEquals("Lenovo", body.getBrandName());
		List<String> expectedFeature = Arrays.asList("8GB RAM", "1TB Hard Drive", "15.5 inch Screen", "128 GB SSD", "USB 3.0", "4 GB Graphics Card", "This is PUT request");
		Assert.assertEquals(expectedFeature,body.getFeatures().getFeature());
						
		//----------
		//Delete Request
		String deleteURL="https://localhost:8443/laptop-bag/webapi/sslres/delete/"+id;
		restResponse = HttpsClientHelper.performDeleteRequestWithSSL(deleteURL, null);
		Assert.assertEquals(HttpStatus.SC_OK, restResponse.getStatusCode());
		
		//Get Request
		restResponse = HttpsClientHelper.performGetRequestWithSSL(getItemUrl, headers);
		Assert.assertEquals(HttpStatus.SC_NOT_FOUND, restResponse.getStatusCode());
		
	}
}

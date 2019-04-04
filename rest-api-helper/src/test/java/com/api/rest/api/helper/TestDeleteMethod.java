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

public class TestDeleteMethod {

	/**
	 * Step 1 : I will Post the data and validate status code as 200 OK
	 * Step 2 : Call delete end point to delete the above posted data, validate the status code is 200 OK
	 * Step 3 : Call the get end point, it should return 404 not found.
	 * Step 4 : Again call the delete end point with same id, expected will be 404 not found
	 */
	@Test
	public void testDeleteItem() {
		
		String id = (int)(1000*(Math.random()))+"";
		
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
		String urlAddItem="http://localhost:8080/laptop-bag/webapi/api/add";
		Map<String, String> headers = new HashMap<String, String>();
		headers.put("Content-Type","application/json");
		headers.put("Accept","application/json");
		RestResponse restResponse = RestApiHelper.performPostRequest(urlAddItem, headers, jsonBody, ContentType.APPLICATION_JSON);
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.serializeNulls().setPrettyPrinting().create();
		ResponseBody body = gson.fromJson(restResponse.getResponseBody(), ResponseBody.class);
		
		Assert.assertEquals(restResponse.getStatusCode(), HttpStatus.SC_OK);
		Assert.assertEquals(body.BrandName, "Dell");
		Assert.assertEquals(body.Id, id);
		Assert.assertEquals(body.LaptopName, "Latitude");
		Assert.assertEquals(body.getFeatures().getFeature().get(0), "8GB RAM");
		Assert.assertEquals(body.getFeatures().getFeature().get(1), "1TB Hard Drive");
		
		//Delete Request
		String urlDeleteItem="http://localhost:8080/laptop-bag/webapi/api/delete/"+id;
		restResponse = RestApiHelper.performDeleteRequest(urlDeleteItem, null);
		
		Assert.assertEquals(restResponse.getStatusCode(), HttpStatus.SC_OK);
		Assert.assertEquals(restResponse.getResponseBody(), id);
		
		//Get Request
		String urlFindItem="http://localhost:8080/laptop-bag/webapi/api/find/"+id;
		restResponse = RestApiHelper.performGetRequest(urlFindItem, null);
		
		Assert.assertEquals(restResponse.getStatusCode(), HttpStatus.SC_NOT_FOUND);

		//Delete Request again
		restResponse = RestApiHelper.performDeleteRequest(urlDeleteItem, null);
		
		Assert.assertEquals(restResponse.getStatusCode(), HttpStatus.SC_NOT_FOUND);
	}
}

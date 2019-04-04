package com.api.rest.api.helper;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.StatusLine;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import com.api.rest.api.model.RestResponse;

public class GetRequest {

	/**
	 * 
	 * @param args
	 * Step 1: - Create the HTTP Get / HTTP Post / HTTP Delete / HTTP Put method
	 * Step 2: - Create the HTTP Client  ---> HttpAsyncClientBuilder Class
	 * Step 3: - Execute the HTTP method using the client
	 * Step 4: - Catch the response of execution
	 * Step 5: - Display the response at the console
	 */
	public static void main(String[] args) {
		
		//Get Request
		//HttpGet get = new HttpGet("http://localhost:8080/laptop-bag/webapi/api/ping/hello");
		HttpGet get = new HttpGet("http://13.250.134.32/subrion/registration/");
		try (CloseableHttpClient client = HttpClientBuilder.create().build();
			 CloseableHttpResponse response = client.execute(get)){
			System.out.println(response.getAllHeaders().toString());			
			StatusLine status=response.getStatusLine();
			System.out.println(status.getStatusCode());
			System.out.println(status.getProtocolVersion());
			
			ResponseHandler<String> body = new BasicResponseHandler();
			RestResponse restResponse = new RestResponse(response.getStatusLine().getStatusCode(), body.handleResponse(response));
			
			//System.out.println(body.handleResponse(response));		
			System.out.println(restResponse.toString());
			
			int[] a = {1,2,4}; 
			a[0] = 2;
			for (int i = 0 ; i <= 2 ; i++) {
				System.out.println(a[i]);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
				
		/*Map<String, String> headers = new HashMap<String, String>();
		headers.put("Accept", "application/json");
		RestResponse restResponse = RestApiHelper.performGetRequest("http://localhost:8080/laptop-bag/webapi/api/all",headers);
		System.out.println(restResponse.toString());*/
		
		/*String jsonBody = "{"+
		        "\"BrandName\": \"Dell\","+
		        "\"Features\": {"+
		            "\"Feature\": ["+
		                "\"8GB RAM\","+
		                "\"1TB Hard Drive\"]"+
		        "},"+
		        "\"Id\": "+ (int)(1000*(Math.random()))+","+
		        "\"LaptopName\": \"Latitude\""+
		"}";*/
		
		/*String xmlBody = "<Laptop>"+
		        "<BrandName>Lenovo</BrandName>"+
		        "<Features>"+
		            "<Feature>8GB RAM</Feature>"+
		            "<Feature>1TB Hard Drive</Feature>"+
		            "<Feature>15.5 inch Screen</Feature>"+
		            "<Feature>128 GB SSD</Feature>"+
		            "<Feature>USB 3.0</Feature>"+
		            "<Feature>4 GB Graphics Card</Feature>"+
		            "<Feature>Put with 999(2)</Feature>"+
		        "</Features>"+
		        "<Id>999</Id>"+
		        "<LaptopName>L Series</LaptopName>"+
		"</Laptop>";*/
		
		/*HttpPost post = new HttpPost("http://localhost:8080/laptop-bag/webapi/api/add");
		try (CloseableHttpClient client = HttpClientBuilder.create().build()){
			post.addHeader("Accept", "application/json");
			post.addHeader("Content-Type", "application/json");					
			//StringEntity data = new StringEntity(jsonBody, ContentType.APPLICATION_JSON);
			
			File file = new File("TestDataFile");
			FileEntity data = new FileEntity(file, ContentType.APPLICATION_JSON);
			post.setEntity(data);
			CloseableHttpResponse response = client.execute(post);
			ResponseHandler<String> handler = new BasicResponseHandler();
			RestResponse restResponse = new RestResponse(response.getStatusLine().getStatusCode(), handler.handleResponse(response));
			System.out.println(restResponse.toString());
		}catch (Exception ex) {
			
		}		*/
		
		/*String url="http://localhost:8080/laptop-bag/webapi/api/add";
		Map<String, String> headers = new LinkedHashMap<String, String>();
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		//File file = new File("TestDataFile");
		RestResponse restReponse = RestApiHelper.performPostRequest(url, headers, jsonBody, ContentType.APPLICATION_JSON);
		System.out.println(restReponse.getStatusCode());
		System.out.println(restReponse.getResponseBody());	
		
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.serializeNulls().setPrettyPrinting().create();
		ResponseBody body = gson.fromJson(restReponse.getResponseBody(), ResponseBody.class);
		
		System.out.println(body.getFeatures().getFeature());
		System.out.println(body.getFeatures().getFeature().get(0));
		System.out.println(body.getFeatures().getFeature().get(1));
		
		List<String> names = Arrays.asList("8GB RAM", "1TB Hard Drive");
		if(names.equals(body.getFeatures().getFeature())){
			System.out.println("True");
		}*/
		
		//HttpDelete delete = new HttpDelete("http://localhost:8080/laptop-bag/webapi/api/delete/101");
	/*	HttpUriRequest delete= RequestBuilder.delete("http://localhost:8080/laptop-bag/webapi/api/delete/771").build();
		
		try(CloseableHttpClient client = HttpClientBuilder.create().build();
			CloseableHttpResponse response = client.execute(delete)){
			ResponseHandler<String> handler = new BasicResponseHandler();
			RestResponse restReponse = new RestResponse(response.getStatusLine().getStatusCode(), handler.handleResponse(response));
			System.out.println(restReponse.toString());
			
		}catch (Exception ex) {
			throw new RuntimeException(ex.getMessage(), ex);
		}*/
		/*RestResponse restReponse = RestApiHelper.performDeleteRequest("http://localhost:8080/laptop-bag/webapi/api/delete/69", null);
		System.out.println(restReponse.toString());		*/
		
		/*HttpUriRequest put = RequestBuilder.put("http://localhost:8080/laptop-bag/webapi/api/update").addHeader("Content-Type", "application/xml").
		addHeader("Accept","application/json").setEntity(new StringEntity(xmlBody, ContentType.APPLICATION_XML)).build();
		try(CloseableHttpClient client = HttpClientBuilder.create().build();
				CloseableHttpResponse response = client.execute(put)){
			ResponseHandler<String> handler =new BasicResponseHandler();
			RestResponse restReponse = new RestResponse(response.getStatusLine().getStatusCode(), handler.handleResponse(response));
			System.out.println(restReponse.toString());
			
		}catch(Exception ex) {
			throw new RuntimeException(ex.getMessage(), ex);		
		}*/
		/*Map<String,String> headers = new HashMap<String, String>();
		headers.put("Content-Type", "application/xml");
		headers.put("Accept", "application/xml");
		RestResponse restReponse = RestApiHelper.performPutRequest("http://localhost:8080/laptop-bag/webapi/api/update", headers, xmlBody, ContentType.APPLICATION_XML);
		System.out.println(restReponse.toString());	*/
		
		
		/*String id = (int)(1000*(Math.random()))+"";
		String xmlBody = "<Laptop>"+
		        "<BrandName>Lenovo</BrandName>"+
		        "<Features>"+
		            "<Feature>8GB RAM</Feature>"+
		            "<Feature>1TB Hard Drive</Feature>"+
		            "<Feature>15.5 inch Screen</Feature>"+
		            "<Feature>128 GB SSD</Feature>"+
		            "<Feature>USB 3.0</Feature>"+
		            "<Feature>4 GB Graphics Card</Feature>"+
		            //"<Feature>Put with "+id+"</Feature>"+
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
		Map<String, String> headers = new HashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		RestResponse restResponse = RestApiHelper.performPostRequest(urlPost, headers, jsonBody, ContentType.APPLICATION_JSON);
		Assert.assertEquals(restResponse.getStatusCode(), HttpStatus.SC_OK);
		
		//Put Request
		String urlPut="http://localhost:8080/laptop-bag/webapi/api/update";
		headers.clear();
		headers.put("Content-Type", "application/xml");
		headers.put("Accept", "application/json");
		restResponse = RestApiHelper.performPutRequest(urlPut, headers, xmlBody, ContentType.APPLICATION_XML);
		Assert.assertEquals(restResponse.getStatusCode(), HttpStatus.SC_OK);
		
		//Get Request
		String urlGet="http://localhost:8080/laptop-bag/webapi/api/find"+id;
		restResponse = RestApiHelper.performGetRequest(urlGet, headers);
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.serializeNulls().setPrettyPrinting().create();
		ResponseBody body = gson.fromJson(restResponse.getResponseBody(), ResponseBody.class);
		
		System.out.println(body.getFeatures().getFeature());
		System.out.println(body.getFeatures().getFeature().get(0));
		System.out.println(body.getFeatures().getFeature().get(1));*/
		
		/*Assert.assertEquals(restResponse.getStatusCode(), HttpStatus.SC_OK);
		Assert.assertEquals("Lenovo", body.getBrandName());
		Assert.assertEquals(id, body.getId());
		Assert.assertEquals("L Series", body.getLaptopName());
		Assert.assertEquals("1TB Hard Drive", body.getFeatures().getFeature().get(0));
		Assert.assertEquals("15.5 inch Screen", body.getFeatures().getFeature().get(1));
		Assert.assertEquals("128 GB SSD", body.getFeatures().getFeature().get(2));
		Assert.assertEquals("USB 3.0", body.getFeatures().getFeature().get(3));
		Assert.assertEquals("4 GB Graphics Card", body.getFeatures().getFeature().get(4));
		Assert.assertEquals("8GB RAM", body.getFeatures().getFeature().get(5));
		Assert.assertEquals("Put with "+id, body.getFeatures().getFeature().get(6));
		*/
		
	}

}

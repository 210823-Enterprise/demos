package com.revature;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate; // RestTemplate is Spring 5, WebCLient Service is now used

public class RestTemplateExample { // https://howtodoinjava.com/spring-boot2/resttemplate/spring-restful-client-resttemplate-example/
	
	// Goal: we want to use the RestTemplate to hit an end point exposed in the FoodController
	
	static String url = "http://localhost:5000/food"; // this will point to my RestController
	
	public static void main(String[] args) {

		// 1. Instantiate the RestTemplate object
		RestTemplate restTemplate = new RestTemplate();
		
		// we need to call the .exchange() method allows 
		// us to exchange data with a server / GET, POST, DELETE< PUT, PATCH
		
		// 2. Build the HTTP Headers to send our request
		HttpHeaders headers = new HttpHeaders();
		// we want to accept back JSON, so we set our Headers to accept JSON as the response
		headers.setAccept(Arrays.asList(new MediaType[] {MediaType.APPLICATION_JSON}));
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		/**
		 * POST request (CREATE a food object in the server)
		 */
		
		// 1. send the food object as a JSON String (send the object as a Food Object)
		String food = "{\r\n" + 
				"    \"dishName\" : \"sushi\",\r\n" + 
				"    \"calories\" : \"200\"\r\n" + 
				"}";
		
		// 2. define the URL pointing to WHERE we're sending the post request (http://localhost:5000/food/add)
		String postUrl = url + "/add"; // (http://localhost:5000/food/add)
		
		// 3. Build an HTTP Entity (this represents the request we're sending to the server (body + headers)
		HttpEntity<String> httpEntity = new HttpEntity<String>(food, headers);
		
		// 4. call the exchange() method to fire the request!
		ResponseEntity<String> httpResponse = restTemplate.exchange(postUrl, HttpMethod.POST, httpEntity, String.class);
		 
		// 5. print the response to the console. 
		System.out.println(httpResponse);
		
		// To run: run spring boot app, then run this class as a Java App
		
		/**
		 * GET
		 */
		
		// 1. Initialize new URL for GET request
		String getUrl = url + "/all"; // "http://localhost:5000/food/all"
		
		// 2. Make a new http entity to get the result as a string
		HttpEntity<String> entity = new HttpEntity<String>(headers);
		
		// 3. Send the GET  request with exchange method
		ResponseEntity<String> getResponse = restTemplate.exchange(getUrl, HttpMethod.GET, entity, String.class);
		
		// 4. print out the JSON response
		System.out.println(getResponse);
		
	}

	
	

}

package com.superhero_villain.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.superhero_villain.endpoints.APIConstants;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC05_Get_AllUsers extends BaseTest{
	@Test(priority = 5)
	public void testGetUsers() throws IOException
	{

		Response response = RestAssured
		.given().spec(userSpec)		
		.when().get(APIConstants.leadrbrdUserAPI);
		

	    System.out.println("body: " + response.jsonPath().getString(""));
	    userAxn.verifyStatusCode(response, 200);
		userAxn.verifyResponseHeader(response, "Content-Type", "application/json; charset=utf-8");
		userAxn.verifyResponseHeader(response, "Server", "Cowboy");
	    	
	}
}

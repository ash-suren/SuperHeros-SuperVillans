package com.superhero_villain.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.superhero_villain.endpoints.APIConstants;
import com.superhero_villain.pojos.UserMethods;

import io.restassured.RestAssured;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;

public class TC07_Update_User extends BaseTest{

	@Test(priority = 7)
	public void testUserUpdate() throws IOException
	{
		RestAssured.defaultParser = Parser.JSON;
		Response response = RestAssured
		.given().spec(userSpec)
		.when().body(payLoad.userUpdatePayload()).put(APIConstants.leadrbrdUserAPI);
		
		System.out.println(response.then().log().all());
		usermethd = response.as(UserMethods.class);
		userAxn.verifyStatusCode(response, 204);
		userAxn.verifyResponseHeader(response, "Server", "Cowboy");

	}
	
}

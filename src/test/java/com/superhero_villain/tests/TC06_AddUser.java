package com.superhero_villain.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.superhero_villain.endpoints.APIConstants;
import com.superhero_villain.pojos.UserMethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC06_AddUser extends BaseTest{
	@Test(priority = 6)
	public void testUserAddition() throws IOException
	{

		Response response = RestAssured
		.given().spec(userSpec)	
		.when().body(payLoad.userAdditionPayload()).post(APIConstants.leadrbrdUserAPI);
		
		System.out.println(response.then().log().all());
		usermethd = response.as(UserMethods.class);
		userAxn.verifyStatusCode(response, 201);	
		userAxn.verifyResponseBody(usermethd.getStatus(), "success");
		userAxn.verifyResponseBody(usermethd.getMessage(), "User added.");
		userAxn.verifyResponseHeader(response, "Content-Type", "application/json; charset=utf-8");
		userAxn.verifyResponseHeader(response, "Server", "Cowboy");
	}

}

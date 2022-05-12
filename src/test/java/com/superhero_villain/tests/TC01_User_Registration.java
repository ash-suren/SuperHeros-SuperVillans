package com.superhero_villain.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.superhero_villain.endpoints.APIConstants;
import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC01_User_Registration extends BaseTest {
	@Test(priority = 1)
	public void testUserRegistration() throws IOException
	{

		Response response = RestAssured
		.given().spec(userSpec)		
		.when().body(payLoad.userCreationPayload()).post(APIConstants.createUserAPI);
		
		System.out.println(response.then().log().all());
		userAxn.verifyStatusCode(response, 200);		
		userAxn.verifyResponseHeader(response, "Content-Type", "application/json; charset=utf-8");
		userAxn.verifyResponseHeader(response, "Server", "Cowboy");
	}

}

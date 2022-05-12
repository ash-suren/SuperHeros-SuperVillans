package com.superhero_villain.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.superhero_villain.endpoints.APIConstants;
import com.superhero_villain.pojos.UserMethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC02_Existing_User_Registration extends BaseTest{
	@Test(priority=2)
	public void exstngUserRegistration() throws IOException
	{

		Response response = RestAssured
		.given().spec(userSpec)		
		.when().body(payLoad.exstngUserCreationPayload()).post(APIConstants.createUserAPI);
		
		System.out.println(response.then().log().all());
		usermethd = response.as(UserMethods.class);
		userAxn.verifyStatusCode(response, 400);	
		userAxn.verifyResponseBody(usermethd.getError().getName(), "error");
		userAxn.verifyResponseHeader(response, "Content-Type", "application/json; charset=utf-8");
		userAxn.verifyResponseHeader(response, "Server", "Cowboy");
	}

}

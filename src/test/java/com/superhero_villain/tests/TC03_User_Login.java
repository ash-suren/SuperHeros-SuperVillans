package com.superhero_villain.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.superhero_villain.endpoints.APIConstants;
import com.superhero_villain.pojos.UserMethods;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC03_User_Login extends BaseTest {

	@Test(priority = 3)
	public void testUserLogin() throws IOException
	{
		
		Response response = RestAssured
		.given().spec(userSpec)		
		.when().body(payLoad.userCreationPayload()).post(APIConstants.loginUserAPI);
		
		System.out.println(response.then().log().all());
		usermethd = response.as(UserMethods.class);
		userAxn.verifyStatusCode(response, 200);
		userAxn.verifyResponseBody(usermethd.getExpiresIn(), "3 min");
		userAxn.verifyResponseHeader(response, "Content-Type", "application/json; charset=utf-8");
		userAxn.verifyResponseHeader(response, "Server", "Cowboy");
	}
}

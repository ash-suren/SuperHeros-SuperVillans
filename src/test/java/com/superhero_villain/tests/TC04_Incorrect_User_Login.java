package com.superhero_villain.tests;

import java.io.IOException;

import org.testng.annotations.Test;

import com.superhero_villain.endpoints.APIConstants;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class TC04_Incorrect_User_Login extends BaseTest{
	@Test(priority = 4)
	public void incrctUserLogin() throws IOException
	{
		
		Response response = RestAssured
		.given().spec(userSpec)		
		.when().body(payLoad.incrctUserCreationPayload()).post(APIConstants.loginUserAPI);
		
		System.out.println(response.then().log().all());
		userAxn.verifyStatusCode(response, 400);
		String resError= userAxn.getDataFromJsonPath(response, "error");
		userAxn.verifyResponseBody(resError, "Username or Password is incorrect");
		userAxn.verifyResponseHeader(response, "Content-Type", "application/json; charset=utf-8");
		userAxn.verifyResponseHeader(response, "Server", "Cowboy");
	}

}

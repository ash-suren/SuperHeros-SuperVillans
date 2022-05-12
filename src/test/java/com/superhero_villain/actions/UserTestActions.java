package com.superhero_villain.actions;

import static org.testng.Assert.assertEquals;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class UserTestActions {
    public <T> T getDataFromJsonPath(Response response, String Path) {

        JsonPath jpath = response.jsonPath();
        return jpath.get(Path);
    }
	public void verifyStatusCode(Response res, int code)
	{
		assertEquals(res.getStatusCode(),code);
	}
	public void verifyResponseBody(String actual, String expected)
	{
		assertEquals(actual, expected);
	}
	public void verifyResponseHeader(Response res, String headerName, String expected)
	{
		String actual= res.header(headerName);
		assertEquals(actual, expected);
	}
}

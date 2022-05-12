package com.superhero_villain.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeMethod;

import com.superhero_villain.actions.UserTestActions;
import com.superhero_villain.payloads.RequestPayloads;
import com.superhero_villain.pojos.UserMethods;

import io.restassured.builder.RequestSpecBuilder;

import io.restassured.specification.RequestSpecification;

public class BaseTest {
		
		protected RequestSpecification userSpec; 
		protected RequestPayloads payLoad = new RequestPayloads();
		protected UserTestActions userAxn = new UserTestActions();
		protected UserMethods usermethd = new UserMethods();
		@BeforeMethod
		protected void setUpRequestConfig() throws IOException
		{
			userSpec = new RequestSpecBuilder().setBaseUri(getProperty("BaseUri"))
					.addHeader("Authorization", getProperty("Token"))
					.addHeader("Content-Type", "application/json").build().log().all();
										
		}
		
		protected String getProperty(String key) throws IOException
		{
			Properties prop = new Properties();
			String configPath = System.getProperty("user.dir")+ "/src/main/resources/Config/config.properties";
			FileInputStream fis = new FileInputStream(configPath);
			prop.load(fis);
			return prop.getProperty(key);			
		}
}

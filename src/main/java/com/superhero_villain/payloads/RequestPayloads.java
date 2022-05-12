package com.superhero_villain.payloads;

import java.io.IOException;

import com.superhero_villain.pojos.UserMethods;
import com.superhero_villain.utils.DataUtils;

public class RequestPayloads {

	UserMethods userGen= new UserMethods();
	
	public UserMethods userCreationPayload() throws IOException
	{
		userGen.setUsername(DataUtils.getCellData(DataUtils.excelPath, "Sheet1", 3, 1));
		userGen.setPassword(DataUtils.getCellData(DataUtils.excelPath, "Sheet1", 3, 2));	
		return	userGen;		
	}
	public UserMethods exstngUserCreationPayload() throws IOException
	{
		userGen.setUsername(DataUtils.getCellData(DataUtils.excelPath, "Sheet1", 1, 1));
		userGen.setPassword(DataUtils.getCellData(DataUtils.excelPath, "Sheet1", 1, 2));	
		return	userGen;		
	}
	public UserMethods incrctUserCreationPayload() throws IOException
	{
		userGen.setUsername(DataUtils.getCellData(DataUtils.excelPath, "Sheet1", 2, 1));
		userGen.setPassword(DataUtils.getCellData(DataUtils.excelPath, "Sheet1", 2, 2));	
		return	userGen;		
	}
	public UserMethods userAdditionPayload() throws IOException
	{
		userGen.setUsername(DataUtils.getCellData(DataUtils.excelPath, "Sheet1", 3, 1));
		userGen.setScore(4000);
		return userGen;
	}
	
	public UserMethods userUpdatePayload() throws IOException
	{
		userGen.setUsername(DataUtils.getCellData(DataUtils.excelPath, "Sheet1", 1, 1));
		userGen.setScore(70);
		return userGen;
	}
}

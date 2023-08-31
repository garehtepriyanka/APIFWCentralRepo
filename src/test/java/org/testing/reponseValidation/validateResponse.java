package org.testing.reponseValidation;


import org.testing.assertions.Assertionn;
import org.testing.utilities.JsonParsingUsingPath;
import org.testng.Assert;

import io.restassured.response.Response;

public class validateResponse 
{
	public static void validateStatusCode(int expectedStatusCode, Response res)
	{
		 //soft assertion
		Boolean response= Assertionn.assert1(expectedStatusCode, res);  
		
		//hard assertion
		Assert.assertTrue(response);
		
	}
	public static void validateResponseData(String expectedData, Response res, String jsonPath)
	{
		String actualValue= JsonParsingUsingPath.jsonparse(res, jsonPath);
		Boolean response= Assertionn.assert1(expectedData, actualValue);
		Assert.assertTrue(response);
	}
	

}

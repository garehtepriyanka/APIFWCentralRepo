package org.testing.reponseValidation;

import org.testing.assertions.Assertionn;
import org.testing.reportslogsCapture.LogCapture;
import org.testing.utilities.JsonParsingUsingPath;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.restassured.response.Response;

public class validateResponse 
{
	public static void validateStatusCode(int expectedStatusCode, Response res, ExtentTest test, String classname)
	{
		 //soft assertion
		Boolean response= Assertionn.assert1(expectedStatusCode, res);  
		
		if(response) //if response is true
		{
			test.log(LogStatus.PASS, "Status Code is matching with the expected status code");	
			LogCapture.takeLogs(classname, "Status Code in log is matching with the expected status code");
		}
		else
		{
			test.log(LogStatus.FAIL, "Status Code is not matching with the expected status code");
			LogCapture.takeLogs(classname, "Status Code in log is not matching with the expected status code");
		}
		
		// hard assertion- Removed now
	}
	public static void validateResponseData(String expectedData, Response res, String jsonPath)
	{
		String actualValue= JsonParsingUsingPath.jsonparse(res, jsonPath);
		Boolean response= Assertionn.assert1(expectedData, actualValue);
		Assert.assertTrue(response);
	}
	

}

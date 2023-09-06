package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.reponseValidation.validateResponse;
import org.testing.reportslogsCapture.ReportHandling;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.JsonParsingUsingOrgJson;
import org.testing.utilities.PropertiesHandle;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.restassured.response.Response;

public class TC2_GetAllRequest 
{
	@Test
	public void testcase2() throws IOException
	{
		ExtentReports report=ReportHandling.takeReport("C://report//report.html");
		ExtentTest test2=report.startTest("TC2_GetAllRequest");
		
		Properties pr=PropertiesHandle.loadPropertiesFile("../JuneBatchAPIFramework/URI.properties");
		HTTPMethods http=new HTTPMethods(pr);
		Response res=http.getmethod("URI_1");
		
		validateResponse.validateStatusCode(200, res, test2, "TC2_GetAllRequest");
		
		report.endTest(test2);
		report.flush(); //// for saving the data- It will write test case status in the report
			
		JsonParsingUsingOrgJson.jsonParse(res.asString(), "id");
	}

}

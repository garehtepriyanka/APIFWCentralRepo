package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.reponseValidation.validateResponse;
import org.testing.reportslogsCapture.ReportHandling;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.PropertiesHandle;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.restassured.response.Response;

public class TC3_GetParticularRequest 
{
	@Test
	public void testcase3() throws IOException
	{
		ExtentReports report=ReportHandling.takeReport("C://report//report.html");
		ExtentTest test3=report.startTest("TC3_GetParticularRequest");
		
		Properties pr=PropertiesHandle.loadPropertiesFile("../JuneBatchAPIFramework/URI.properties");
		HTTPMethods http=new HTTPMethods(pr);
		Response res=http.getparticularmethod("URI_1", TC1_PostRequest.returnidValue);
		
		validateResponse.validateStatusCode(200, res, test3, "TC3_GetParticularRequest");
		validateResponse.validateResponseData("Priyan", res, "firstname");
		
		report.endTest(test3);
		report.flush(); //// for saving the data- It will write test case status in the report

	}

}

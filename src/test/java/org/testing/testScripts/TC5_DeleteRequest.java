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

public class TC5_DeleteRequest 
{
	@Test
	public void testcase5() throws IOException
	{
		ExtentReports report=ReportHandling.takeReport("C://report//report.html");
		ExtentTest test5=report.startTest("TC5_DeleteRequest");
		
		Properties pr=PropertiesHandle.loadPropertiesFile("../JuneBatchAPIFramework/URI.properties");
		HTTPMethods http=new HTTPMethods(pr);
		Response res=http.Deletemethod("URI_1", TC1_PostRequest.returnidValue);
		
		validateResponse.validateStatusCode(200, res, test5, "TC5_DeleteRequest");
		
		report.endTest(test5);
		report.flush(); //// for saving the data- It will write test case status in the report
	}

}

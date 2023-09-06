package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.reponseValidation.validateResponse;
import org.testing.reportslogsCapture.ReportHandling;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.JsonHandle;
import org.testing.utilities.JsonReplacement;
import org.testing.utilities.PropertiesHandle;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import io.restassured.response.Response;

public class TC4_PutRequest 
{
	@Test
	public static void testcase4() throws IOException 
	{
		ExtentReports report=ReportHandling.takeReport("C://report//report.html");
		ExtentTest test4=report.startTest("TC4_PutRequest");
		
		Properties pr= PropertiesHandle.loadPropertiesFile("../JuneBatchAPIFramework/URI.properties");
		String requestBody=JsonHandle.loadJsonFile("../JuneBatchAPIFramework/src/test/java/org/testing/resources/UpdateRequestPayload.json");
		requestBody= JsonReplacement.assignVariableValue(requestBody, "id", TC1_PostRequest.returnidValue);
		HTTPMethods http=new HTTPMethods(pr);
		Response res= http.putmethod(requestBody, "URI_1", TC1_PostRequest.returnidValue);
		validateResponse.validateStatusCode(200, res, test4, "TC4_PutRequest");
		
		report.endTest(test4);
		report.flush(); //// for saving the data- It will write test case status in the report
	}

}

package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.reponseValidation.validateResponse;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.JsonHandle;
import org.testing.utilities.JsonReplacement;
import org.testing.utilities.PropertiesHandle;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC4_PutRequest 
{
	@Test
	public static void testcase4() throws IOException 
	{
		Properties pr= PropertiesHandle.loadPropertiesFile("../JuneBatchAPIFramework/URI.properties");
		String requestBody=JsonHandle.loadJsonFile("../JuneBatchAPIFramework/src/test/java/org/testing/resources/UpdateRequestPayload.json");

		requestBody= JsonReplacement.assignVariableValue(requestBody, "id", TC1_PostRequest.returnidValue);
		HTTPMethods http=new HTTPMethods(pr);
		Response res= http.putmethod(requestBody, "URI_1", TC1_PostRequest.returnidValue);
		validateResponse.validateStatusCode(200, res);
		
		
	}

}

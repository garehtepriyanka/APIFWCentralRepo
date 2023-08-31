package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;
import java.util.Random;

import org.testing.reponseValidation.validateResponse;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.JsonHandle;
import org.testing.utilities.JsonParsingUsingOrgJson;
import org.testing.utilities.JsonReplacement;
import org.testing.utilities.PropertiesHandle;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC1_PostRequest 
{
	static String returnidValue;
	@Test
	public static void testcase1() throws IOException 
	{
		Properties pr= PropertiesHandle.loadPropertiesFile("../JuneBatchAPIFramework/URI.properties");
		String requestBody=JsonHandle.loadJsonFile("../JuneBatchAPIFramework/src/test/java/org/testing/resources/RequestPayload.json");
		Random r= new Random();
		Integer idValue= r.nextInt();
		requestBody= JsonReplacement.assignVariableValue(requestBody, "id", idValue.toString());
		HTTPMethods http=new HTTPMethods(pr);
		Response res= http.postmethod(requestBody, "URI_1");		
		validateResponse.validateStatusCode(201, res);
		
		returnidValue=JsonParsingUsingOrgJson.jsonParse(res.asString(), "id");
		
	}

}

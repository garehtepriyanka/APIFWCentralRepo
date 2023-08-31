package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.reponseValidation.validateResponse;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.JsonParsingUsingOrgJson;
import org.testing.utilities.PropertiesHandle;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC2_GetAllRequest 
{
	@Test
	public void testcase2() throws IOException
	{
		Properties pr=PropertiesHandle.loadPropertiesFile("../JuneBatchAPIFramework/URI.properties");
		HTTPMethods http=new HTTPMethods(pr);
		Response res=http.getmethod("URI_1");
		
		validateResponse.validateStatusCode(200, res);
			
		JsonParsingUsingOrgJson.jsonParse(res.asString(), "id");
	}

}

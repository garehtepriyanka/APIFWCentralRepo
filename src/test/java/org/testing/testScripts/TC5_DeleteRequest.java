package org.testing.testScripts;

import java.io.IOException;
import java.util.Properties;

import org.testing.reponseValidation.validateResponse;
import org.testing.testSteps.HTTPMethods;
import org.testing.utilities.PropertiesHandle;
import org.testng.annotations.Test;

import io.restassured.response.Response;

public class TC5_DeleteRequest 
{
	@Test
	public void testcase5() throws IOException
	{
		Properties pr=PropertiesHandle.loadPropertiesFile("../JuneBatchAPIFramework/URI.properties");
		HTTPMethods http=new HTTPMethods(pr);
		Response res=http.Deletemethod("URI_1", TC1_PostRequest.returnidValue);
		validateResponse.validateStatusCode(200, res);
	}

}

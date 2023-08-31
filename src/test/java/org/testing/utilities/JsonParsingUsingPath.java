package org.testing.utilities;

import io.restassured.response.Response;
// input parameter --- response object and the jsonPath
//purpose---- it will extract value from the response based upon the jsonPath that we are giving
//output parameter----it will return String value

public class JsonParsingUsingPath {
	public static String jsonparse(Response res, String  jsonPath)
	{
		return res.jsonPath().get(jsonPath);
	}

}

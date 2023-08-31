package org.testing.testSteps;

import java.util.Properties;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

//input parameter---RequestBody and URI value-- from the properties
public class HTTPMethods 
{
	Properties pr; //global
	public HTTPMethods(Properties pr)
	{
		this.pr=pr;
	}
	public Response postmethod(String requestBody, String uriKeyName)
	{
		String uriValue=pr.getProperty(uriKeyName);		
		Response res=
		given()
		.contentType(ContentType.JSON)
		.body(requestBody)
		.when()
		.post(uriValue);
		System.out.println("Status code is ");
		System.out.println(res.statusCode());		
		System.out.println("Response is ");
		System.out.println(res.asString());
		return res;
	}
	public Response getmethod(String uriKeyName)
	{
		String uriValue=pr.getProperty(uriKeyName);
		Response res=
		given()
		.contentType(ContentType.JSON)
		.when()
		.get(uriValue);
		System.out.println("Status code is ");
		System.out.println(res.statusCode());		
		System.out.println("Response is ");
		System.out.println(res.asString());
		
		return res;
	}
	public Response getparticularmethod(String uriKeyName, String endPoint)
	{
		String uriValue=pr.getProperty(uriKeyName)+"/"+endPoint;
		Response res=
		given()
		.contentType(ContentType.JSON)
		.when()
		.get(uriValue);
		System.out.println("Status code is ");
		System.out.println(res.statusCode());		
		System.out.println("Response is ");
		System.out.println(res.asString());
		
		return res;
	}
	public Response putmethod(String requestBody, String uriKeyName, String endPoint)
	{
		String uriValue=pr.getProperty(uriKeyName)+"/"+endPoint;		
		Response res=
		given()
		.contentType(ContentType.JSON)
		.body(requestBody)
		.when()
		.put(uriValue);
		System.out.println("Status code is ");
		System.out.println(res.statusCode());		
		System.out.println("Response is ");
		System.out.println(res.asString());
		return res;
	}
	public Response Deletemethod(String uriKeyName, String endPoint)
	{
		String uriValue=pr.getProperty(uriKeyName)+"/"+endPoint;
		Response res=
		given()
		.contentType(ContentType.JSON)
		.when()
		.delete(uriValue);
		System.out.println("Status code is ");
		System.out.println(res.statusCode());		
		System.out.println("Response is ");
		System.out.println(res.asString());
		
		return res;
	}

}

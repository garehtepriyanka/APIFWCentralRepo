package org.testing.utilities;

import java.util.regex.Pattern;

//input parameter --- the complete request body, variableName, variableValue
//purpose of this method—to assign the value to the variable
public class JsonReplacement 
{
	public static String assignVariableValue(String requestBody, String variableName, String variableValue)
	{
		requestBody=requestBody.replaceAll(Pattern.quote("{{"+variableName+"}}"), variableValue);
		return requestBody;
	}

}

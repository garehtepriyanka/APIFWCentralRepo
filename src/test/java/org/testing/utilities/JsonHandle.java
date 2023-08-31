package org.testing.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import org.json.JSONObject;
import org.json.JSONTokener;
	//input parameter-----Json file path
	//purpose of the method --- read json file
	//output parameter----json data in String format
public class JsonHandle 
{
	public static String loadJsonFile(String filepath) throws FileNotFoundException
	{
		File f=new File(filepath);
		FileInputStream fi=new FileInputStream(f);
		JSONTokener js=new JSONTokener(fi);
		JSONObject j=new JSONObject(js);
		return j.toString();		
	}

}

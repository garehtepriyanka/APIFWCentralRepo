package org.testing.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// input parameter--- file path
// purpose of the method--- to load the properties file
//output parameter -- object of properties class

public class PropertiesHandle 
{
	public static Properties loadPropertiesFile(String filePath) throws IOException
	{
		File f=new File(filePath);
		FileInputStream fi=new FileInputStream(f);
		Properties pr=new Properties();
		pr.load(fi);
		return pr;
	}

}

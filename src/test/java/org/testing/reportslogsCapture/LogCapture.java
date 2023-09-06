package org.testing.reportslogsCapture;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class LogCapture 
{
	public static void takeLogs(String classname, String logmsg)
	{
		DOMConfigurator.configure("../JuneBatchAPIFramework/layout.xml");
		Logger L=Logger.getLogger(classname);
		L.info(logmsg);
	}

}

package org.testing.reportslogsCapture;

import com.relevantcodes.extentreports.ExtentReports;

public class ReportHandling 
{
	public static ExtentReports takeReport(String path)
	{
		ExtentReports reports = new ExtentReports(path, false);
		return reports;
	}

}

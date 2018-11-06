package com.autoqa.framework.uitest.reports;

import java.net.InetAddress;
import java.net.UnknownHostException;

import com.autoqa.framework.uitest.utils.PropertyLoader;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

abstract class ExtentReportManager {
	protected static ExtentHtmlReporter htmlReporter = null;
	protected static ExtentReports extentReport = null;

	protected ExtentReportManager() {

	}

	public static ExtentReports generateReport(String testNg_SuiteName, String folderPath_TestResults) {
		if (extentReport == null) {
			// Instantiation of Report related objects
			extentReport = new ExtentReports();
			htmlReporter = new ExtentHtmlReporter(
					folderPath_TestResults + "\\ExtentReport_" + testNg_SuiteName + ".html");

			// HTML Reporter Basic Configurations
			htmlReporter.config().setDocumentTitle("Extent Report for Automation Test using TestNG");
			htmlReporter.config().setReportName(testNg_SuiteName + "Test Report)");
			htmlReporter.config().setTheme(Theme.STANDARD);
			htmlReporter.config().setChartVisibilityOnOpen(true);
			htmlReporter.config().setTestViewChartLocation(ChartLocation.TOP);

			// Extent Report Basic Configurations
			extentReport.setSystemInfo("Environment", PropertyLoader.getInstance().getTestEnvironmentName());
			extentReport.setSystemInfo("Hostname", getHostName());
			extentReport.setSystemInfo("Browser", PropertyLoader.getInstance().getBrowserName().toString());

			extentReport.attachReporter(htmlReporter);

		}
		return extentReport;
	}
	
	private static String getHostName(){
		String hostName = null;
		try{
			hostName = InetAddress.getLocalHost().getHostName();
		}
		catch(UnknownHostException ex){
			ex.printStackTrace();
		}
		return hostName;
	}

	public static void closeReport() {
		extentReport.flush();
	}
}

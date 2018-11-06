package com.autoqa.framework.uitest.seleniumcore;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.autoqa.framework.uitest.reports.ExtentTestManager;
import com.autoqa.framework.uitest.utils.DirectoryCreator;
import com.autoqa.framework.uitest.utils.PropertyLoader;
import com.aventstack.extentreports.utils.FileUtil;

public class BaseTest {
	private static ExtentTestManager extentTestManager;
	protected Driver driver;

	@BeforeSuite
	public void beforeXMLSuiteLaunch(ITestContext context) {
		// Fetch TestNG Suite Name and Current Test Results Folder Path
		String testNg_SuiteName = context.getCurrentXmlTest().getSuite().getName();
		String folder_TestResults = PropertyLoader.getInstance().getTestResultsFolderPath();
		
		// Generating the folder path for current Test Suite Run
		String current_Folder_TestResults = DirectoryCreator.createTestSuiteResultsFolder(folder_TestResults, testNg_SuiteName);
		
		//Generate an Extent Report with Current TestNG Suite Name at the Current Test Results Folder Path
		ExtentTestManager.generateReport(testNg_SuiteName, current_Folder_TestResults);
	}

	@BeforeTest
	public void beforeXMLTestLaunch(ITestContext context) {
		extentTestManager = new ExtentTestManager();
		String testNg_TestName = context.getCurrentXmlTest().getName();
		extentTestManager.createParentTest(testNg_TestName);
	}
	
	@BeforeMethod
	public void initTestMethod(ITestResult result){
		
	}

	@AfterMethod
	public void tearDownTestMethod(){
		
	}
	
	@AfterSuite
	public void afterXMLSuiteEnd(){
		ExtentTestManager.closeReport();
	}
}
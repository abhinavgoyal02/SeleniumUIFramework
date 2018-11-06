package com.autoqa.framework.uitest.reports;

import java.io.IOException;

import com.autoqa.framework.uitest.utils.TestStatus;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;

public class ExtentTestManager extends ExtentReportManager{
	private ExtentTest parentTest;
	private ExtentTest childTest;
	
	public void createParentTest(String testNg_XMLTestName){
		parentTest = extentReport.createTest(testNg_XMLTestName);
	}
	
	public void createTestNode(String testNg_TestMethodName){
		childTest = parentTest.createNode(testNg_TestMethodName);
	}
	
	public void logResult(TestStatus testStepResult, String message, String imagePath) throws IOException{
		if(testStepResult.toString().equalsIgnoreCase("PASS")){
			childTest.log(Status.PASS, message, MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());
		}
		else if (testStepResult.toString().equalsIgnoreCase("FAIL")){
			childTest.log(Status.FAIL, message, MediaEntityBuilder.createScreenCaptureFromPath(imagePath).build());
		}
	}

	public void logInfo(String message){
		childTest.log(Status.INFO, message);
	}
}

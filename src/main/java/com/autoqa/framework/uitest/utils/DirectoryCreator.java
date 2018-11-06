package com.autoqa.framework.uitest.utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DirectoryCreator {
	public static void createFolder(String folderPath) {
		File dir = new File(folderPath);
		boolean success = dir.mkdirs();
		if (success)
			System.out.println("Directory created successfully");
		else
			System.out.println(
					"Failed to create the required directory. However, some parent directories may have been created.");
	}

public static String createTestSuiteResultsFolder(String folder_TestResults, String testNg_SuiteName){
	// Fetching current Date-Time to format as per required Simple Format
	Date date_Now = new Date();
	SimpleDateFormat date_Format = new SimpleDateFormat("MMM-dd-YYYY HH-mm-ss");
	String dateTime = date_Format.format(date_Now);
	
	// Setting the Test Results folder path as per Current TestNG Suite Name and Current Date-Time
	String folder_TestResults_CurrentDateTime = folder_TestResults + "\\" + dateTime + "\\" + testNg_SuiteName;
	
	// Invoking createFolder() method to create the Test Suite Results folder for Current Date-Time
	DirectoryCreator.createFolder(folder_TestResults_CurrentDateTime);
	
	return folder_TestResults_CurrentDateTime;
}

}

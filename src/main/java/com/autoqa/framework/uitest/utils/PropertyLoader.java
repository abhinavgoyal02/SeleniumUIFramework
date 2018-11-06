package com.autoqa.framework.uitest.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import com.autoqa.framework.uitest.utils.BrowserName;

public class PropertyLoader {

	public static Logger log = LogManager.getLogger(PropertyLoader.class.getName());

	// File Paths to Property files for the project
	private static final String PROP_FILE_BASEDIR = "\\resources\\properties\\";
	private static final String PROP_WEBAPP_FILEPATH = System.getProperty("user.dir") + PROP_FILE_BASEDIR
			+ "app-config.properties";

	private Properties prop = null;

	// Static class object for a single instance of type PropertyLoader
	private static PropertyLoader prop_singleton = null;

	// Private constructor to prevent outside instantiation and main a single
	// instance only
	private PropertyLoader() throws FileNotFoundException, IOException {
		prop = new Properties();
		prop.load(new FileInputStream(PROP_WEBAPP_FILEPATH));
	}

	public static PropertyLoader getInstance() {
		try {

			if (prop_singleton == null)
				prop_singleton = new PropertyLoader();

		} catch (Exception e) {

			e.printStackTrace();

		}
		return prop_singleton;
	}

	public String getTestEnvironmentName() {
		String webApp_TestEnv = prop.getProperty("webApp.testEnvironment");

		return webApp_TestEnv.trim().isEmpty() ? "NOT SET" : webApp_TestEnv.trim();
	}

	public String getWebAppURL() {
		String webApp_BaseURL = prop.getProperty("webApp.baseUrl");

		return webApp_BaseURL.trim().isEmpty() ? "http://www.google.co.in" : webApp_BaseURL.trim();
	}

	public BrowserName getBrowserName() {
		String webApp_BrowserName = prop.getProperty("webApp.browserName");

		return webApp_BrowserName.trim().isEmpty() ? BrowserName.CHROME
				: BrowserName.valueOf(webApp_BrowserName.trim());
	}

	public Integer getTimeoutInSeconds() {
		String webApp_ExplicitWaitTime = prop.getProperty("webApp.time.explicitWait");

		return (Integer) (webApp_ExplicitWaitTime.trim().isEmpty() ? 10 : webApp_ExplicitWaitTime.trim());
	}

	public String getTestResultsFolderPath() {
		String webApp_Folder_TestResults = prop.getProperty("webApp.folder.testResults");

		return webApp_Folder_TestResults.trim();
	}

	public String getTestDataFolderPath() {
		String webApp_Folder_TestData = prop.getProperty("webApp.folder.testData");

		return webApp_Folder_TestData.trim();
	}

	public String getSeleniumServerUrl() {
		String webApp_ServerUrl = prop.getProperty("webApp.seleniumGrid.serverUrl");

		return webApp_ServerUrl.trim().isEmpty() ? "http://localhost:4444/wd/hub" : webApp_ServerUrl.trim();
	}

	public boolean isSeleniumGridInUse() {

		return false;

	}

	// TODO: Remove Obsolete function - Change of class design to Singleton
	// pattern
	/*
	 * public static Properties getPropertyFileInstance(String propFileName)
	 * throws FileNotFoundException, IOException {
	 * log.info("Entered getPropertyFileInstance method");
	 * 
	 * if (propFileName == null || propFileName.length() < 1 ||
	 * propFileName.contains(".") ||
	 * propFileName.contains("\\") || propFileName.contains("/")) {
	 * 
	 * log.info("Exit through propFileName condition path"); return null; }
	 * 
	 * else { // prop_singleton = new Properties(); // prop_singleton.load(new
	 * FileInputStream(System.getProperty("user.dir") + PROP_FILE_BASEDIR +
	 * propFileName));
	 * 
	 * log.info("Exited getSnapshot method through proper path"); // return
	 * prop_singleton; } return null; }
	 */

}

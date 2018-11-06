package com.autoqa.framework.uitest.utils;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverMenuTest {
	public static Logger log = LogManager.getLogger(WebDriverMenu.class.getName());

	@Test(enabled = false)
	public void testGetBrowerDriverVersion() {
		log.info("WebDriverMenu Class Unit Test is initiated");

		// Using different invalid combinations of Browser Name and Version
		// Number combinations to check NULL condition
		assertEquals(WebDriverMenu.getBrowerDriverVersion(null, null), null);
		assertEquals(WebDriverMenu.getBrowerDriverVersion("Chrome", null), null);
		assertEquals(WebDriverMenu.getBrowerDriverVersion(null, "68"), null);

		// Using different valid combinations of Browser Name and Version Number
		// combinations to check fetch Driver Version condition
		assertEquals(WebDriverMenu.getBrowerDriverVersion("Chrome", "70"), "2.42");
		assertEquals(WebDriverMenu.getBrowerDriverVersion("Chrome", "68"), "2.42");
		assertEquals(WebDriverMenu.getBrowerDriverVersion("Chrome", "65"), "2.38");

		log.info("WebDriverMenu Class Unit Test is done");
	}

	@Test
	public void testGetWebDriverInstance() {
		log.info("WebDriverMenu Class Unit Test is initiated");

		WebDriver driver = null;
		// Using different invalid combinations of BrowserName, BrowserVersion
		// and PlatformName to check NULL condition
		assertEquals(WebDriverMenu.getWebDriverInstance(null, null, null), null);
		assertEquals(WebDriverMenu.getWebDriverInstance("Chrome", null, null), null);
		assertEquals(WebDriverMenu.getWebDriverInstance(null, "68", null), null);
		assertEquals(WebDriverMenu.getWebDriverInstance("Chrome", null, Platform.WIN10), null);

		// Using different valid combinations of BrowserName, BrowserVersion
		// and PlatformName to check Returned Driver Instance
		driver = WebDriverMenu.getWebDriverInstance("Chrome", "68", Platform.WIN10);
		assertEquals(driver instanceof ChromeDriver, true);
		
		//TODO: Fix issue with Firefox test for proper version calls in actual function
//		driver = WebDriverMenu.getWebDriverInstance("Firefox", "57", Platform.WIN10);
//		assertEquals(driver instanceof FirefoxDriver, true);
		
		//TODO: Fix issue with Firefox test for proper version calls in actual functions
//		driver = WebDriverMenu.getWebDriverInstance("IE", "11", Platform.WIN10);
//		assertEquals(driver instanceof InternetExplorerDriver, true);
		
		//TODO: Implement test for Opera and Safari browsers as well
		
		
		driver.close();
		driver.quit();
		log.info("WebDriverMenu Class Unit Test is done");
	}

}

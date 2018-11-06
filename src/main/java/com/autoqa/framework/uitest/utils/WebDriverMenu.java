package com.autoqa.framework.uitest.utils;

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

import com.gargoylesoftware.htmlunit.javascript.configuration.BrowserName;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverMenu {
	public static Logger log = LogManager.getLogger(WebDriverMenuTest.class.getName());

	private static final String BROWSER_DRIVER_VER_REF_PROP_FILE_NAME = "browserdriver-versionreference";
	private static Properties prop = null;

	public static WebDriver getWebDriverInstance(String browserName, String browserVersion, Platform platformName) {
		if (browserName == null || browserVersion == null || platformName == null) {

			return null;

		} else {
			DesiredCapabilities dCaps = new DesiredCapabilities(browserName, browserVersion, platformName);
//			String browserDriverVersion = getBrowerDriverVersion(browserName, browserVersion);

			if (dCaps.getPlatform().is(Platform.WIN10) || dCaps.getPlatform().is(Platform.WIN8_1)
					|| dCaps.getPlatform().is(Platform.WIN8) || dCaps.getPlatform().is(Platform.WINDOWS)
					|| dCaps.getPlatform().is(Platform.XP)) {

				System.out.println("Current Platform is [" + dCaps.getPlatform() + "]");

				if (dCaps.getBrowserName() == "Chrome") {
					System.out.println("Browser in Use [" + dCaps.getBrowserName() + " - " + dCaps.getVersion() + "]");

//					WebDriverManager.config().setDriverVersion(browserDriverVersion);
					WebDriverManager.chromedriver().setup();

					return new ChromeDriver(dCaps);

				} else if (dCaps.getBrowserName() == "Firefox") {
					System.out.println("Browser in Use [" + dCaps.getBrowserName() + " - " + dCaps.getVersion() + "]");
					
					//TODO: Fix proper version setting of Firefox from property file
//					WebDriverManager.config().setDriverVersion(browserDriverVersion);
					WebDriverManager.firefoxdriver().setup();

					return new FirefoxDriver(dCaps);

				}

				else if (dCaps.getBrowserName() == "IE") {
					System.out.println("Browser in Use [" + dCaps.getBrowserName() + " - " + dCaps.getVersion() + "]");

					//TODO: Fix proper version setting of IE from property file
//					WebDriverManager.config().setDriverVersion(browserDriverVersion);
					WebDriverManager.iedriver().setup();

					return new InternetExplorerDriver(dCaps);

				}

				else if (dCaps.getBrowserName() == "Opera") {
					System.out.println("Browser in Use [" + dCaps.getBrowserName() + " - " + dCaps.getVersion() + "]");

					//TODO: Fix proper version setting of Opera from property file
//					WebDriverManager.config().setDriverVersion(browserDriverVersion);
					WebDriverManager.operadriver().setup();
					
//					return new OperaDriver(dCaps);

				}

			} else if (dCaps.getPlatform().is(Platform.MAC)) {

				System.out.println("Current Platform is [" + dCaps.getPlatform() + "]");

				if (dCaps.getBrowserName() == "Safari") {
					System.out.println("Browser in Use [" + dCaps.getBrowserName() + " - " + dCaps.getVersion() + "]");

					//TODO: Fix proper version setting of Safari from property file
					//TODO: Find solution to Safari as WebDriverManager API does not support it
					
					// return new SafariDriver(dCaps);
				}

				else if (dCaps.getBrowserName() == "Opera") {
					System.out.println("Browser in Use [" + dCaps.getBrowserName() + " - " + dCaps.getVersion() + "]");

					//TODO: Fix proper version setting of Opera from property file
//					WebDriverManager.config().setDriverVersion(browserDriverVersion);
					WebDriverManager.operadriver().setup();
					
					// return new OperaDriver(dCaps);
				}
			}
		}
		return null;
	}

//	public static String getBrowerDriverVersion(String browserName, String browserVersion) {
//		if (browserName == null || browserVersion == null) {
//
//			return null;
//		} else {
//			try {
//				prop = PropertyLoader.getPropertyFileInstance(BROWSER_DRIVER_VER_REF_PROP_FILE_NAME);
//				String propertyKey = browserName + browserVersion;
//				log.debug("Property Key (to fetch browser driver version) = "+ propertyKey);
//				String browserDriverVersion = prop.getProperty(propertyKey);
//				log.debug("Suitable Browser Driver Version for [" + browserName + "] = " + browserDriverVersion);
//
//				return browserDriverVersion;
//
//			} catch (Exception e) {
//				log.error(e.getMessage());
//			}
//			return null;
//		}	
}

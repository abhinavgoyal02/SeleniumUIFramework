package com.autoqa.framework.uitest.utils;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class CaptureScreenshotTest {
	public static Logger log = LogManager.getLogger(CaptureScreenshotTest.class.getName());
	private WebDriver driver = null;
	
	@Test
	public void testGetSnapshot() throws FileNotFoundException, IOException {
		log.info("Capture Screenshot Class Unit Test is initiated");
		
		// Using null driver and different invalid fileName combinations to check driver condition
		assertEquals(ScreenshotCapturer.getSnapshot(driver, "Error Window"), "ERROR: Invalid WebDriver Instance");
		assertEquals(ScreenshotCapturer.getSnapshot(driver, ""), "ERROR: Invalid WebDriver Instance");
		assertEquals(ScreenshotCapturer.getSnapshot(driver, "Error.Window"), "ERROR: Invalid WebDriver Instance");
		
		// Using valid driver and different invalid fileName combinations to check fileName condition
		driver = new ChromeDriver();
		assertEquals(ScreenshotCapturer.getSnapshot(driver, null), "ERROR: Invalid File Name");
		assertEquals(ScreenshotCapturer.getSnapshot(driver, ""), "ERROR: Invalid File Name");
		assertEquals(ScreenshotCapturer.getSnapshot(driver, "Error.Window"), "ERROR: Invalid File Name");
		assertEquals(ScreenshotCapturer.getSnapshot(driver, "Err\\orWindow"), "ERROR: Invalid File Name");
		assertEquals(ScreenshotCapturer.getSnapshot(driver, "Err/orWin/dow"), "ERROR: Invalid File Name");
		
		// Using valid driver and different valid fileName combinations to check fileName condition
		assertEquals(ScreenshotCapturer.getSnapshot(driver, "ErrorSnap"), "C:\\Users\\Abhinav Goyal\\workspace\\WebDriver-Automation\\SeleniumUIFramework\\resources\\screenshots\\ErrorSnap.jpg");
		
		driver.close();
		driver.quit();
		log.info("Capture Screenshot Class Unit Test is done");
	}
}

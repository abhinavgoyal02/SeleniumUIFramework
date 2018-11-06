package com.autoqa.framework.uitest.utils;

import static org.testng.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.bcel.generic.INSTANCEOF;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class PropertyLoaderTest {
	public static Logger log = LogManager.getLogger(PropertyLoaderTest.class.getName());
	private WebDriver driver = null;
	
	@Test
	public void testGetPropertyFileInstance() throws FileNotFoundException, IOException {
		log.info("Property Loader Class Unit Test is initiated");
		
		// Using invalid propFileName combinations to check file name condition
		assertEquals(PropertyLoader.getPropertyFileInstance(null), null);
		assertEquals(PropertyLoader.getPropertyFileInstance(""), null);
		assertEquals(PropertyLoader.getPropertyFileInstance("sn\\ap"), null);
		assertEquals(PropertyLoader.getPropertyFileInstance("/snap"), null);
		assertEquals(PropertyLoader.getPropertyFileInstance("sna.p."), null);
		
		// Using valid propFileName to check property file load
		Properties prop = PropertyLoader.getPropertyFileInstance("snapshot-stores");
		assertEquals(prop instanceof Properties, true);
		
		log.info("Property Loader Class Unit Test is done");
	}
}

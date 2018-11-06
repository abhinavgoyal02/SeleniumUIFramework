package com.autoqa.framework.uitest.webtestcases;

import org.testng.annotations.Test;

import com.autoqa.framework.uitest.utils.WebDriverMenu;

import org.testng.annotations.BeforeClass;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;

public class SampleWebDriverTest {
 
	private WebDriver driver;
	private String baseURL;
	
  @BeforeClass
  public void beforeClass() {
	  baseURL = "http://google.co.in";
	  driver = WebDriverMenu.getWebDriverInstance("Chrome", "68", Platform.WIN10);
	  driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	  driver.manage().window().maximize();
  }
  
  @Test
  public void f() {
	  driver.get(baseURL);
  }

  @AfterClass
  public void afterClass() {
	  driver.close();
	  driver.quit();
  }

}

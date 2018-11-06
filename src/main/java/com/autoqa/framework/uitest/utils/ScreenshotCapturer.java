package com.autoqa.framework.uitest.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.autoqa.framework.uitest.utils.PropertyLoader;

public class ScreenshotCapturer {
	public static Logger log = LogManager.getLogger(ScreenshotCapturer.class.getName());

	public static String getSnapshot(WebDriver driver, String imagePath, String imageName)
			throws FileNotFoundException, IOException {
		
		log.info("Entered getSnapshot() method");
		if (driver == null) {
			log.error("Exit through driver condition path");
			
			return "ERROR: Invalid WebDriver Instance";
		}

		else if (imageName == null || imageName.length() < 1 || imageName.contains(".") || imageName.contains("\\")
				|| imageName.contains("/")) {
			log.error("Exit through file condition path");
			
			return "ERROR: Invalid File Name";
		}

		else {
			log.debug("Snapshot save folder path = " + imagePath);
			String image_TargetPath = imagePath + "\\" + imageName + ".jpg";
			log.debug("Snapshot save desination path = " + image_TargetPath);

			File image_SrcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(image_SrcFile, new File(image_TargetPath));
			log.info("Exited getSnapshot() method through proper path");
			
			return image_TargetPath;
		}
	}
}

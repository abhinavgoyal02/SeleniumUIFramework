package com.autoqa.framework.uitest.utils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.util.Properties;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class SystemWindowHandler {
	public static Logger log = LogManager.getLogger(SystemWindowHandler.class.getName());

	public static void doRobotFileUpload(String uploadFileNamewithExtension) {
		log.info("Entered doRobotFileUpload() method");
		if (uploadFileNamewithExtension == null || uploadFileNamewithExtension.length() < 1) {
			log.info("Exit through file condition path");
		}

		else {
			String uploadFileStoreDir = null;
			try {
				prop = PropertyLoader.getPropertyFileInstance(UPLOAD_FILESTORES_PROP_FILE_NAME);
				uploadFileStoreDir = prop.getProperty("uploadFileStore");
			} catch (Exception e) {
				log.error(e.getMessage());
			}
			log.debug("Upload File Stores Property Value = " + uploadFileStoreDir);
			StringSelection uploadFilePath = new StringSelection(uploadFileStoreDir + uploadFileNamewithExtension);
			log.debug("Upload File Path = " + uploadFilePath.toString());
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(uploadFilePath, null);

			try {
				// Using Java AWT Robot class to mimic user inputs
				Robot inputMimicker = new Robot();
				// Keyboard events for Ctrl + V
				inputMimicker.keyPress(KeyEvent.VK_CONTROL);
				inputMimicker.keyPress(KeyEvent.VK_V);
				inputMimicker.keyRelease(KeyEvent.VK_CONTROL);
				inputMimicker.keyRelease(KeyEvent.VK_V);

				// Keyboard events for Enter
				inputMimicker.keyPress(KeyEvent.VK_ENTER);
				inputMimicker.keyRelease(KeyEvent.VK_ENTER);
			} catch (AWTException awtEx) {
				log.error(awtEx.getMessage());
			}

			log.info("Exited doRobotFileUpload() method through proper path");
		}
	}

	public static void doAutoITFileUpload(String uploadFileNamewithExtension) throws IOException {
		//TODO: FIX the Hard-coded uploadFilePath in AutoIT script by passing it as a parameter
		Runtime.getRuntime().exec("C:\\Users\\Abhinav Goyal\\workspace\\SeleniumUIFramework\\resources\\scripts\\auto-it\\FileUploadScript.exe");
	}
	
	public static void doWindowAuthentication() throws IOException{
		Runtime.getRuntime().exec("C:\\Users\\Abhinav Goyal\\workspace\\SeleniumUIFramework\\resources\\scripts\\auto-it\\WinAuthenticationScript.exe");
	}

}

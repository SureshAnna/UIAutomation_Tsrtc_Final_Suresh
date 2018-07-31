package com.tsrtc.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

	private static Logger logger = Logger.getLogger(ScreenshotUtil.class);

	public static void captureScreenshot(WebDriver driver, String filePath) {
		try {
			filePath = "C:\\Users\\suresh\\Desktop\\screenshot.png";
			TakesScreenshot takeScreenShot = ((TakesScreenshot) driver);
			File file = takeScreenShot.getScreenshotAs(OutputType.FILE);

			File DestFile = new File(filePath);
			FileUtils.copyFile(file, DestFile);
		} catch (Exception exception) {
			logger.error("Exception :: ", exception);
		}
	}
}

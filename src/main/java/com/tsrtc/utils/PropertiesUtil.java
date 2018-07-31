package com.tsrtc.utils;

import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * This is used to read the properties
 * 
 * @author Suresh
 *
 */
public class PropertiesUtil {

	private static Logger logger = Logger.getLogger(PropertiesUtil.class);

	public static String environment = null;
	public static String url = null;
	public static String browserName = null;

	/**
	 * This is used to read main and test properties
	 * 
	 */
	public void initProperties() {
		CommonUtil commonUtil = new CommonUtil();
		try {
			logger.info("Read main properties");
			Properties mainProperties = new Properties();

			mainProperties = commonUtil
					.getProperties("E:\\resume\\UIAutomation\\src\\main\\resources\\main.properties");
			url = commonUtil.getPropetieValue(mainProperties, "test.url");

			logger.info("Read test properties");
			Properties testProperties = new Properties();

			testProperties = commonUtil
					.getProperties("E:\\resume\\UIAutomation\\src\\test\\resources\\test.properties");
			environment = commonUtil.getPropetieValue(testProperties,
					"test.env");
			browserName = commonUtil.getPropetieValue(testProperties,
					"test.browserName");
		} catch (Exception exception) {
			System.out.println("Exception occured :: replaceString method");
			logger.error("Exception occured :: replaceString method");
		}
	}
}

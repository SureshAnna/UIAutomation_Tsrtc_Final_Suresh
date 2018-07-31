package com.tsrtc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * 
 * This class is used commonly across the project
 * 
 * @author Suresh
 *
 */
public class CommonUtil {

	Logger logger = Logger.getLogger(CommonUtil.class);

	/**
	 * This method is used to read the properties file
	 * 
	 * @param propertiesFilePath
	 *            Properties file path
	 * @return Properties file
	 */
	public Properties getProperties(String propertiesFilePath) {
		Properties properties = new Properties();
		try {
			FileInputStream fileInputStream = new FileInputStream(
					propertiesFilePath);
			properties.load(fileInputStream);
			fileInputStream.close();
		} catch (IOException exception) {
			System.out.println("File path not found exception");
			logger.error("File path not found exception");
		} catch (Exception exception) {
			System.out.println("Exception occured :: getProperties method");
			logger.error("Exception occured :: getProperties method");
		}
		return properties;
	}

	/**
	 * This method is used to retrieve Propertie value using Propertie key
	 * 
	 * @param propertiesFile
	 *            Properties file
	 * @param propertieKey
	 *            Propertie key
	 * @return Propertie value
	 */
	public String getPropetieValue(Properties propertiesFile,
			String propertieKey) {
		String propertieValue = null;
		try {
			propertieValue = propertiesFile.getProperty(propertieKey);
		} catch (Exception exception) {
			System.out.println("Exception occured :: getPropetieValue method");
			logger.error("Exception occured :: getPropetieValue method");
		}
		return propertieValue;
	}

	/**
	 * This method is used to replace the string
	 * 
	 * @param actualString
	 *            Actual string to replace
	 * @param oldStringToReplace
	 *            Old string to replace
	 * @param newStringToReplace
	 *            New string to replace
	 * @return Modified string
	 */
	public String replaceString(String actualString, String oldStringToReplace,
			String newStringToReplace) {
		String updatedString = null;
		try {
			updatedString = actualString.replace(oldStringToReplace,
					newStringToReplace);
		} catch (Exception exception) {
			System.out.println("Exception occured :: replaceString method");
			logger.error("Exception occured :: replaceString method");
		}
		return updatedString;
	}
}

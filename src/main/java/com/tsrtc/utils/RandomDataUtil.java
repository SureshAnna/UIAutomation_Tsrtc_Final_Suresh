package com.tsrtc.utils;

import java.util.Random;

import org.apache.log4j.Logger;

/**
 * 
 * This class is used to generate random values
 * 
 * @author Suresh
 *
 */
public class RandomDataUtil {

	private static Logger logger = Logger.getLogger(RandomDataUtil.class);

	private Random random = new Random();

	/**
	 * This method is used to generate random string
	 * 
	 * @return Random string
	 */
	public String generateRandomString() {
		String randomString = "auto";
		try {
			randomString = randomString + random.nextInt();
		} catch (Exception exception) {
			logger.error("Exception :: ", exception);
		}
		return randomString;
	}

	/**
	 * This method is used to generate random email
	 * 
	 * @return Random email
	 */
	public String generateRandomEmail() {
		String randomEmail = "auto";
		try {
			randomEmail = randomEmail + random.nextInt() + "@test.com";
		} catch (Exception exception) {
			logger.error("Exception :: ", exception);
		}
		return randomEmail;
	}

	/**
	 * This method is used to generate random mobile number
	 * 
	 * @return Random mobile number
	 */
	public int generateRandomMobileNumber() {
		int randomMobileNumber = 0;
		try {
			randomMobileNumber = randomMobileNumber + random.nextInt();
		} catch (Exception exception) {
			logger.error("Exception :: ", exception);
		}
		return randomMobileNumber;
	}

}

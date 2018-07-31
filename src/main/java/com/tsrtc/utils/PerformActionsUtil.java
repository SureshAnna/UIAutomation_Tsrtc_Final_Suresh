package com.tsrtc.utils;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.tsrtc.pom.TsrtcRegistrationPage;

public class PerformActionsUtil {

	private static Logger logger = Logger
			.getLogger(TsrtcRegistrationPage.class);

	WebDriver driver;

	public PerformActionsUtil(WebDriver driver) {
		this.driver = driver;
	}

	public void sendKeys(WebElement element, String sendKeysText) {
		try {
			element.clear();
			element.sendKeys(sendKeysText);
		} catch (Exception exception) {
			logger.error("Exception :: {}" + exception);
		}
	}

	public void selectByVisibleText(WebElement element, String visibleText) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(visibleText);
		} catch (Exception exception) {
			logger.error("Exception :: {}" + exception);
		}
	}

	public void selectByValue(WebElement element, String visibleValue) {
		try {
			Select select = new Select(element);
			select.selectByValue(visibleValue);
		} catch (Exception exception) {
			logger.error("Exception :: {}" + exception);
		}
	}

	public void selectByIndex(WebElement element, int valueByIndex) {
		try {
			Select select = new Select(element);
			select.selectByIndex(valueByIndex);
		} catch (Exception exception) {
			logger.error("Exception :: {}" + exception);
		}
	}

}

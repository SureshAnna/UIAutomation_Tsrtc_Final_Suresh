package com.tsrtc.utils;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Function;

public class WaitHandler {

	private static Logger logger = Logger.getLogger(BrowserUtil.class);

	WebDriver driver = null;

	public WaitHandler(WebDriver driver) {
		this.driver = driver;
	}

	public void implicitWait(int waitTime) {
		try {
			driver.manage().timeouts()
					.implicitlyWait(waitTime, TimeUnit.SECONDS);
		} catch (Exception exception) {
			logger.error("Exception :: {}" + exception);
		}
	}

	public void explicitWait(int waitTime) {
		try {
			Thread.sleep(waitTime);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void fluentWait(Duration waitTime, Duration poolingTime, final By by) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).pollingEvery(
				poolingTime).withTimeout(waitTime);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(by);
			}
		});
	}

	public void waitForElementToBeClickable(WebElement element, int waitTime) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception exception) {
			logger.error("Exception :: {}" + exception);
		}
	}

	public void waitForElementToBeSelected(WebElement element, int waitTime) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.elementToBeSelected(element));
		} catch (Exception exception) {
			logger.error("Exception :: {}" + exception);
		}
	}

	public void waitForElementToBeVisibile(WebElement element, int waitTime) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, waitTime);
			wait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception exception) {
			logger.error("Exception :: {}" + exception);
		}
	}

}

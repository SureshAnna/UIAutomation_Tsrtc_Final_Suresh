package com.tsrtc.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.tsrtc.utils.BrowserUtil;

/**
 * This class is used for Home Page
 * 
 * @author Suresh
 *
 */
public class TsrtcHomePage {

	private static Logger logger = Logger.getLogger(BrowserUtil.class);
	private WebDriver driver;

/*	@FindBy(how = How.CLASS_NAME, using = "user")
	WebElement eTicketLogin;*/
	
	@FindBy(xpath="//a[@class='user']")
	WebElement eTicketLogin;

	/*@FindBy(how = How.XPATH, using = "//*[text()='SignUp']")
	WebElement signUp;*/
	@FindBy(xpath="//*[text()='SignUp']")
	WebElement signUp;
	

	public TsrtcHomePage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
		Assert.assertEquals(driver.getTitle(), "TSRTC Official Website for Online Bus Ticket Booking - tsrtconline.in");
	}

	/**
	 * 
	 * This method is used to click on signup and open registration page
	 * 
	 * @return Registration page
	 */
	public TsrtcRegistrationPage clickSignUp() {
		try {
			eTicketLogin.click();
			signUp.click();
		} catch (Exception exception) {
			logger.error("Exception :: {}" + exception);
		}
		return PageFactory.initElements(driver, TsrtcRegistrationPage.class);
	}
}

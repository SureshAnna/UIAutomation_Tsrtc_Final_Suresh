package com.tsrtc.pom;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.tsrtc.utils.PerformActionsUtil;

public class TsrtcRegistrationPage {

	private static Logger logger = Logger
			.getLogger(TsrtcRegistrationPage.class);

	private WebDriver driver = null;
	private PerformActionsUtil performActionsUtil;

	@FindBy(how = How.NAME, using = "loginName")
	WebElement loginName;

	@FindBy(how = How.NAME, using = "fullName")
	WebElement fullName;

	@FindBy(how = How.NAME, using = "email")
	WebElement email;

	@FindBy(how = How.NAME, using = "genderId")
	WebElement gender;

	@FindBy(how = How.NAME, using = "proofTypeId")
	WebElement idType;

	@FindBy(how = How.NAME, using = "mobileNo")
	WebElement mobileNo;

	@FindBy(how = How.NAME, using = "txtDob")
	WebElement dob;

	@FindBy(how = How.NAME, using = "nationalityId")
	WebElement nationalityId;

	@FindBy(how = How.NAME, using = "address1")
	WebElement address1;

	@FindBy(how = How.NAME, using = "address2")
	WebElement address2;

	@FindBy(how = How.NAME, using = "city")
	WebElement city;

	@FindBy(how = How.NAME, using = "stateName")
	WebElement stateName;

	@FindBy(how = How.NAME, using = "zipCode")
	WebElement postalCode;

	@FindBy(how = How.NAME, using = "proofTypeId")
	WebElement idCardType;

	@FindBy(how = How.NAME, using = "idNumber")
	WebElement idCardNumber;

	@FindBy(how = How.NAME, using = "issueAuthority")
	WebElement issueAuthority;

	public TsrtcRegistrationPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		performActionsUtil = new PerformActionsUtil(driver);
	}

	public void userRegistartion(String loginNameTxt, String fullNameTxt,
			String emailTxt, String mobileNoTxt, String address1Txt,
			String address2Txt, String cityTxt, String postalCodeTxt,
			String idCardNumberTxt, String issueAuthorityTxt, String genderTxt,
			String nationalityIdTxt, String idCardTypeTxt) {
		System.out.println("user registartion");
		try {
			performActionsUtil.sendKeys(loginName, loginNameTxt);
			performActionsUtil.sendKeys(fullName, fullNameTxt);
			performActionsUtil.sendKeys(email, emailTxt);
			performActionsUtil.sendKeys(mobileNo, mobileNoTxt);
			performActionsUtil.sendKeys(address1, address1Txt);
			performActionsUtil.sendKeys(address2, address2Txt);
			performActionsUtil.sendKeys(city, cityTxt);
			performActionsUtil.sendKeys(postalCode, postalCodeTxt);
			performActionsUtil.sendKeys(idCardNumber, idCardNumberTxt);
			performActionsUtil.sendKeys(issueAuthority, issueAuthorityTxt);

			performActionsUtil.selectByVisibleText(gender, genderTxt);
			performActionsUtil.selectByVisibleText(nationalityId,
					nationalityIdTxt);
			performActionsUtil.selectByVisibleText(idCardType, idCardTypeTxt);
		} catch (Exception exception) {
			logger.error("Exception :: {}" + exception);
		}
	}
}

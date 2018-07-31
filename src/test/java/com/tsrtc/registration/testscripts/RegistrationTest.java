package com.tsrtc.registration.testscripts;

import java.util.LinkedHashMap;

import org.testng.annotations.Test;

import com.tsrtc.base.TsrtcBase;
import com.tsrtc.pom.TsrtcHomePage;
import com.tsrtc.pom.TsrtcRegistrationPage;

/**
 * 
 * This class is used to test Registration
 * 
 * @author Suresh
 *
 */
public class RegistrationTest extends TsrtcBase {

	@Test(dataProvider = "getData")
	public void registrationTest(LinkedHashMap<String, String> data) {
		try {
			System.out.println("Hello World");
			TsrtcHomePage tsrtcHomePage = new TsrtcHomePage(driver);
			
			System.out.println("Hello World");
			TsrtcRegistrationPage tsrtcRegistrationPage = tsrtcHomePage
					.clickSignUp();
			System.out.println("Click button");
			tsrtcRegistrationPage
					.userRegistartion(randomDataUtil.generateRandomString(),
							randomDataUtil.generateRandomString(),
							randomDataUtil.generateRandomEmail(), String
									.valueOf(randomDataUtil
											.generateRandomMobileNumber()),
							data.get("address1"), data.get("address2"), data
									.get("city"), data.get("postalCode"), data
									.get("idCardNumber"), data
									.get("issueAuthority"), data.get("gender"),
							data.get("nationalityId"), data.get("idCardType"));
		} catch (Exception exception) {
			logger.error("Exception :: {}" + exception);
		}
	}
}

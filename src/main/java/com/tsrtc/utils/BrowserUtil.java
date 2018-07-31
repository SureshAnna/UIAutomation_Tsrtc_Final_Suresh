package com.tsrtc.utils;



import org.apache.log4j.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * 
 * This class is used to launch the browser
 * 
 * @author Suresh
 *
 */
public class BrowserUtil {

	private static Logger logger = Logger.getLogger(BrowserUtil.class);

	/**
	 * This method is used to launch the specific driver
	 * 
	 * @param browserName
	 *            Browser name
	 * @param url
	 *            Url
	 * @return Driver
	 */
	public WebDriver openBrowser(String browserName, String url) {
		WebDriver driver = null;

		try {
			switch (browserName) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\Suresh\\Desktop\\AutomationPOC\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "ie":
				System.setProperty("webdriver.ie.driver",
						"C:\\Users\\ptg\\Downloads\\IEDriverServer_x64_3.13.0\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.firefox.driver",
						"C:\\Users\\Suresh\\Desktop\\AutomationPOC\\geckodriver.exe");
				driver = new ChromeDriver();
				break;

			default:
				logger.error("Please supply valid browser name :: {}"
						+ browserName);
			}

			driver.navigate().to(url);
			driver.manage().window().maximize();
		} catch (Exception exception) {
			logger.error("Exception :: {}" + exception);
		}
		return driver;
		 
	}
}

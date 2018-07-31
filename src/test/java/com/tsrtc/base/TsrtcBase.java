package com.tsrtc.base;

import java.io.File;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.tsrtc.pom.TsrtcHomePage;
import com.tsrtc.utils.CommonUtil;
import com.tsrtc.utils.DataBaseUtil;
import com.tsrtc.utils.DateUtil;
import com.tsrtc.utils.ExcelUtil;
import com.tsrtc.utils.PerformActionsUtil;
import com.tsrtc.utils.PropertiesUtil;
import com.tsrtc.utils.RandomDataUtil;
import com.tsrtc.utils.ReportUtil;
import com.tsrtc.utils.BrowserUtil;

/**
 * This is the base class for all the test classes
 * 
 * @author suresh
 *
 */
public abstract class TsrtcBase {

	protected static Logger logger = Logger.getLogger(TsrtcBase.class);

	protected PropertiesUtil propertiesUtil = new PropertiesUtil();
	protected CommonUtil commonUtil = new CommonUtil();
	protected RandomDataUtil randomDataUtil = new RandomDataUtil();
	protected ExcelUtil excelUtil = new ExcelUtil();
	protected DateUtil dateUtil = new DateUtil();
	protected DataBaseUtil dataBaseUtil = new DataBaseUtil();
	protected ReportUtil reportUtil = new ReportUtil();
	protected BrowserUtil browserUtil = new BrowserUtil();
	protected PerformActionsUtil performActionsUtil;

	public WebDriver driver;
	public ExtentReports extent;
	public ExtentTest testLogger;

	@BeforeClass
	public void beforeClass() {
		propertiesUtil.initProperties();
		String workingDir = System.getProperty("user.dir");
		extent = new ExtentReports(workingDir
				+ "\\test-output\\ExtentReport.html");
		extent.addSystemInfo("Host Name", "UI Automationdemo");
		extent.addSystemInfo("Environment", "Automation Testing");
		extent.addSystemInfo("User Name", "Suresh Kanaparthi");
		extent.loadConfig(new File(System.getProperty("user.dir")
				+ "\\extent-config.xml"));
		driver = browserUtil.openBrowser(PropertiesUtil.browserName,
				PropertiesUtil.url);
		performActionsUtil = new PerformActionsUtil(driver);
		System.out.println("testing");
		testLogger = extent.startTest("Test Name", "Description");
		testLogger.log(LogStatus.PASS, "opened application successfully");
		
	}
	@DataProvider
	public Object[][] getData(ITestContext context) {
		Object[][] excelData = excelUtil.getData(context);
		 return excelData;
	}
	@AfterClass
	public void afterClass() throws InterruptedException {
		Thread.sleep(5000);
		extent.endTest(testLogger);
		// driver.close();
		driver.quit();
		extent.flush();
	}

	
}
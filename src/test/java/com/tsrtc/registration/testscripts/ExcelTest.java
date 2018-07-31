package com.tsrtc.registration.testscripts;

import org.testng.annotations.Test;
import com.tsrtc.base.TsrtcBase;

public class ExcelTest extends TsrtcBase {

	@Test
	public void verifyExcelTest() {
		Object[][] object = new Object[2][1];
		object = excelUtil.readExcelData("E:\\resume\\UIAutomation\\src\\test\\resources\\com\\tsrtc\\registration\\testData\\RegistrationTest.xlsx", "RegistrationTest");
	}
}

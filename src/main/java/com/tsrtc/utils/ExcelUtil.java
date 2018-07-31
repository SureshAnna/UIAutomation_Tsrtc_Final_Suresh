package com.tsrtc.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedHashMap;

import org.apache.log4j.Logger;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.ITestContext;
import org.testng.annotations.DataProvider;

/**
 * 
 * This class is used to read excel data
 * 
 * @author Suresh
 *
 */
public class ExcelUtil {

	private static Logger logger = Logger.getLogger(ExcelUtil.class);

	/**
	 * 
	 * This method is used to read excel data
	 * 
	 * @param excelFilePath
	 *            Excel file path
	 * @param sheetName
	 *            Sheet name
	 */
	public Object[][] readExcelData(String excelFilePath, String sheetName) {
		Object[][] data = null;
		LinkedHashMap<String, String> linkedHashMap;
		try {
			Workbook workbook = WorkbookFactory.create(new FileInputStream(
					excelFilePath));
			Sheet sheet = workbook.getSheet(sheetName);

			int rowCount = sheet.getLastRowNum() + 1;
			int columnCount = sheet.getRow(0).getLastCellNum();

			data = new Object[rowCount - 1][1];

			for (int i = 1; i < rowCount; i++) {
				linkedHashMap = new LinkedHashMap<String, String>();
				for (int j = 0; j < columnCount; j++) {
					linkedHashMap.put(sheet.getRow(0).getCell(j)
							.getStringCellValue(), sheet.getRow(i).getCell(j)
							.getStringCellValue());
					data[i - 1][0] = linkedHashMap;
				}
			}
		} catch (IOException exception) {
			logger.error("Exception :: {}" + exception);
		} catch (Exception exception) {
			logger.error("Exception :: {}" + exception);
		}
		return data;
	}

	/**
	 * 
	 * This method is used to read the excel data
	 * 
	 * @param context
	 *            Context
	 * @return Excel Data
	 */
	// @DataProvider(parallel=true)
	public Object[][] getData(ITestContext context) {
		Object[][] excelData = null;
		try {
			String filePath = "E:\\resume\\UIAutomation\\src\\test\\resources\\com\\tsrtc\\registration\\testData\\RegistrationTest.xlsx";
			String sheet = "RegistrationTest";
			excelData = readExcelData(filePath, sheet);
		} catch (Exception exception) {
			logger.error("Exception :: {}" + exception);
		}
		return excelData;
	}
}

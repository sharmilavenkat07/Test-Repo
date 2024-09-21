package org.page.execution;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.pack.base.BaseTestNG;
import org.page.factory.LoginPageT;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginExecutionT {
	
	@BeforeMethod
	public void openBrowser() throws IOException {
		BaseTestNG.openBrowser("chrome");
		BaseTestNG.launchUrl(BaseTestNG.siteDetails("Url"));
		BaseTestNG.applywaits();
	}

	@AfterMethod
	public void closeBrowser() {
		BaseTestNG.browserClose();
	}
	@Test(dataProvider = "Data")
	public void logIn(String username, String password) throws IOException {

		
		LoginPageT lp = new LoginPageT();
		lp.userName.sendKeys(username);
		lp.passWord.sendKeys(password);
		lp.logIn.click();
	}

	@DataProvider(name = "Data" , parallel= false)
	@Test
	public Object[][] excelRead() throws IOException {
		File file = new File(
				"C:\\Users\\loksh\\eclipse-workspace\\LearnTestNG\\src\\test\\resources\\Cred\\User Cred.xlsx");
		FileInputStream fis = new FileInputStream(file);
		Workbook wk = new XSSFWorkbook(fis);
		Sheet sheet = wk.getSheet("sheet1");
		int rowcount = sheet.getPhysicalNumberOfRows();
		int cellcount = sheet.getRow(0).getPhysicalNumberOfCells();

		Object[][] values = new Object[rowcount - 1][cellcount];
		for (int i = 1; i < rowcount; i++) {
			Row row = sheet.getRow(i);
			for (int j = 0; j < cellcount; j++) {
				Cell cell = row.getCell(j);
				values[i - 1][j] = cellvalue(cell);
			}
		}
		wk.close();
		fis.close();
		return values;
	}
	private static Object cellvalue(Cell cell) {
		switch (cell.getCellType()) {
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				return cell.getDateCellValue();
			} else {
				cell.getNumericCellValue();
			}
		default:
			return null;
		}}
	@BeforeClass
	public void beforeClass() {
		System.out.println("Open DB Connection");
	}
	@AfterClass
	public void afterClass() {
		System.out.println("Open DB Connection");
	}
}
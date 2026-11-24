package DataDriven;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.io.FileInputStream;
import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	FileInputStream file;
	XSSFWorkbook work;

	@Test
	public void f() throws IOException {
		file = new FileInputStream(
				"‪C:\\Users\\ADMIN\\Desktop\\Automation Testing IMP\\Automation Testing\\src\\TestingWith_Excel\\studentData3.xlsx");
		work = new XSSFWorkbook(file);

		XSSFSheet sheet = work.getSheetAt(0);

		int totalRows = sheet.getLastRowNum();
		int totalColoumns = sheet.getRow(0).getLastCellNum();

		System.out.println("Total Row:-" + totalRows);
		System.out.println("Total Coloumn:- " + totalColoumns);

	}

//	@BeforeTest
//	public void beforeTest() {
//		
//	}
//
//	@AfterTest
//	public void afterTest() {
//	}

}

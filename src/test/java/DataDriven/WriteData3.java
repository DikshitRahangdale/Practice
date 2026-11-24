package DataDriven;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteData3 {
	@Test
	public void f() throws IOException {

		FileOutputStream file = new FileOutputStream(
				"C:\\Users\\ADMIN\\Desktop\\Java_Project\\SDET_QA\\src\\test\\java\\DataDriven\\TestData.xlsx");
		XSSFWorkbook work = new XSSFWorkbook();
		XSSFSheet sheet = work.createSheet("Test1");

		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("Sr.NO.");
		row1.createCell(1).setCellValue("URL");
		row1.createCell(2).setCellValue("Username");
		row1.createCell(3).setCellValue("Password");

		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("1");
		row2.createCell(1).setCellValue("wwww.Google.com");
		row2.createCell(2).setCellValue("username123");
		row2.createCell(3).setCellValue("Pass@123");

		work.write(file);
		work.close();
		file.close();

	}
}

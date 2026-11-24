package DataDriven;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteDataExcel {
	@Test
	public void f() throws IOException {

		FileOutputStream file = new FileOutputStream(
				"C:\\Users\\ADMIN\\Desktop\\Java_Project\\SDET_QA\\src\\test\\java\\DataDriven\\ExcelFirst.xlsx");

		XSSFWorkbook work = new XSSFWorkbook();
		XSSFSheet sheet = work.createSheet("Dtat1");
		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("Sr.No.");
		row1.createCell(1).setCellValue("Name");
		row1.createCell(2).setCellValue("Subject");

		work.write(file);
		work.close();
		file.close();

	}
}

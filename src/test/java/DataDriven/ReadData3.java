package DataDriven;

import java.awt.print.Book;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadData3 {
	@Test
	public void f() throws IOException {
		FileInputStream file = new FileInputStream(
				"C:\\\\Users\\\\ADMIN\\\\Desktop\\\\Java_Project\\\\SDET_QA\\\\src\\\\test\\\\java\\\\DataDriven\\\\TestData.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(file);

		XSSFSheet sheet = work.getSheetAt(0);
		int row = sheet.getPhysicalNumberOfRows();
		int cell = sheet.getRow(0).getLastCellNum();

		for (int i = 0; i < row; i++) {
			XSSFRow row2 = sheet.getRow(i);

			for (int j = 0; j < cell; j++) {
				
				XSSFCell cell1 = row2.getCell(j);
				System.out.println(cell1.toString());
			}
		}
		work.close();
		file.close();

	}
}

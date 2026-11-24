package DataDriven;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteData2 {

	@Test
	public void f() throws FileNotFoundException {

		FileOutputStream file = new FileOutputStream(
				"C:\\Users\\ADMIN\\Desktop\\Java_Project\\SDET_QA\\src\\test\\java\\DataDriven\\Excel2.xlsx");
		XSSFWorkbook work = new XSSFWorkbook();

		Scanner scanner = new Scanner(System.in);

		XSSFSheet sheet = work.createSheet("Test Data");
		int row = 3;
		int cell = 4;

		for (int i = 0; i < row; i++) {
			XSSFRow rows = sheet.createRow(i);

			for (int j = 0; j < cell; j++) {
				XSSFCell cell2 = rows.createCell(j);
				cell2.setCellValue(scanner.next());
			}
		}

	}
}

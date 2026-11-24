package DataDriven;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class StudentData {
	@Test
	public void f() throws IOException {

		FileOutputStream file = new FileOutputStream(
				"C:\\Users\\ADMIN\\Desktop\\Java_Project\\SDET_QA\\src\\test\\java\\DataDriven\\StudentData.xlsx");
		XSSFWorkbook work = new XSSFWorkbook();
		XSSFSheet sheet = work.createSheet("Student1");
		Scanner scanner = new Scanner(System.in);
		int row = 3;
		int cell = 3;

		for (int i = 0; i < row; i++) {
			XSSFRow row1 = sheet.createRow(i);

			for (int j = 0; j < cell; j++) {
				XSSFCell cell2 = row1.createCell(j);
				cell2.setCellValue(scanner.next());
			}
		}
		work.write(file);
		work.close();
		file.close();

	}
}

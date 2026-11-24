package DataDriven;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadStudentData {
	@Test
	public void f() throws IOException {
		FileInputStream file = new FileInputStream("C:\\Users\\ADMIN\\Pictures\\movies\\StudentData.xlsx");
		XSSFWorkbook work = new XSSFWorkbook(file);
		XSSFSheet sheet = work.getSheet("Student1");

		int rows = sheet.getLastRowNum();
		int cell = sheet.getRow(0).getLastCellNum();

		System.out.println("Total Rows: " + rows);
		System.out.println("Total Coloumns: " + cell);

		for (int i = 0; i < rows; i++) {
			XSSFRow currentRow = sheet.getRow(i);

			for (int j = 0; j < cell; j++) {
				XSSFCell currentCell = currentRow.getCell(j);
				System.out.println(currentCell.toString());
			}
		}

	}
}

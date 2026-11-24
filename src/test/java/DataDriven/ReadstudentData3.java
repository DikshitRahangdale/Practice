package DataDriven;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.Test;

public class ReadstudentData3 {
	@Test
	public void f() throws IOException {

		File files = new File("C:\\Users\\ADMIN\\Pictures\\movies\\StudentData.xlsx");
		String sheetname = "Student1";

		int rowNumber = ExcelUtility.getRownumber(files, sheetname);
		int cellNumber = ExcelUtility.getCellnumber(files, sheetname, 0);
		String[][] sheetdata = new String[rowNumber][cellNumber];

		System.out.println("Total Row Number: " + rowNumber);
		System.out.println("Total Cell Number: " + cellNumber);

		for (int i = 0; i < rowNumber; i++) {

			for (int j = 0; j < cellNumber; j++) {
				sheetdata[i][j] = ExcelUtility.getCellData(files, sheetname, i, j);

			}
		}

		for (int i = 0; i < sheetdata.length; i++) {

			for (int j = 0; j < sheetdata[i].length; j++) {

				System.out.print(sheetdata[i][j]);

			}
		}

	}
}

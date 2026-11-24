package DatePicker;

import org.testng.annotations.Test;

import java.io.IOException;

import org.testng.annotations.*;

public class DataProviders {

	@DataProvider(name = "Test")
	public String[][] testInput() throws IOException {
		ExcelUtility excel = new ExcelUtility();
		String path = System.getProperty("user.dir") + "\\testData\\apiUserData.xlsx";
		int rowCount = excel.getRowCount(path, 0);
		int cellCount = excel.getCellCount(path, 1);
		String[][] arr = new String[rowCount][cellCount];

		for (int i = 0; i < rowCount; i++) {
			for (int j = 0; j < cellCount; j++) {
				arr[i][j] = excel.getData(path, 0, i, j);
			}
		}
		return arr;

	}

	@Test(dataProvider = "Test")
	public void testdata(String name, String pass) {
		System.out.println(name + " " + pass);
	}
}

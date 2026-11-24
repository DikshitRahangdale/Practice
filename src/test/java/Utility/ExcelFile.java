package Utility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelFile {

	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	FileInputStream inputStream;
	FileOutputStream outputStream;
	String path;

	public ExcelFile(String path) {
		this.path = path;
	}

	public void readExcelFile(int sheetNum) throws IOException {

		inputStream = new FileInputStream(path);
		workbook = new XSSFWorkbook(inputStream);
		sheet = workbook.getSheetAt(sheetNum);
		int rowCount = sheet.getLastRowNum();
		int cellCount = sheet.getRow(1).getLastCellNum();

		for (int i = 0; i <= rowCount; i++) {
			row = sheet.getRow(i);

			for (int j = 0; j < cellCount; j++) {
				System.out.print(row.getCell(j).toString() + "  ");
			}
			System.out.println();
		}
		workbook.close();
		inputStream.close();

	}

	public void writeExcelData() throws IOException {

		inputStream = new FileInputStream(path);
		workbook = new XSSFWorkbook(inputStream);
		inputStream.close();

		outputStream = new FileOutputStream(path);

		sheet = workbook.createSheet("Users4");
		row = sheet.createRow(0);
		cell = row.createCell(0);
		cell.setCellValue("UserName");
		row.createCell(1).setCellValue("Password");

		row = sheet.createRow(1);
		cell = row.createCell(0);
		cell.setCellValue("Admin");
		row.createCell(1).setCellValue("admin@1234");
		workbook.write(outputStream);
		workbook.close();
		outputStream.close();

	}

	public static void main(String[] args) {

		String path = (System.getProperty("user.dir") + "//testData//apiUserData.xlsx");
		ExcelFile excelFile = new ExcelFile(path);

		try {
			//excelFile.writeExcelData();
			excelFile.readExcelFile(0);
			excelFile.readExcelFile(1);
			
		
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			System.out.println("Excel Files");
		}
	}

}

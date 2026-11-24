package DatePicker;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	FileInputStream file;
	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFRow row;
	XSSFCell cell;
	FileOutputStream output;

	public int getRowCount(String fileparh, int sheetcount) throws IOException {
		file = new FileInputStream(fileparh);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheetAt(0);
		int count = sheet.getLastRowNum();
		workbook.close();
		file.close();
		return count;
	}

	public int getCellCount(String path, int sheetcount) throws IOException {
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheetAt(sheetcount);
		row = sheet.getRow(1);
		int count = row.getLastCellNum();
		workbook.close();
		file.close();

		return count;
	}

	public String getData(String path, int sheetcount, int rowcount, int cellcount) throws IOException {
		file = new FileInputStream(path);
		workbook = new XSSFWorkbook(file);
		sheet = workbook.getSheetAt(sheetcount);
		row = sheet.getRow(rowcount);
		cell = row.getCell(cellcount);
		return cell.toString();

	}


}

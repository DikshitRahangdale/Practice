package DataDriven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	public static XSSFWorkbook workbook;
	public static FileInputStream fileInput;
	public static FileOutputStream fileOutput;
	public static XSSFSheet sheet;
	public static XSSFCell cell;
	public static XSSFRow row;
	public static CellStyle style;

	public static int getRownumber(File file, String shet) throws IOException {
		fileInput = new FileInputStream(file);
		workbook = new XSSFWorkbook(fileInput);
		sheet = workbook.getSheet(shet);
		int sheetCount = sheet.getPhysicalNumberOfRows();
		workbook.close();
		fileInput.close();
		return sheetCount;

	}

	public static int getCellnumber(File file, String shet, int rownum) throws IOException {
		fileInput = new FileInputStream(file);
		workbook = new XSSFWorkbook(fileInput);
		sheet = workbook.getSheet(shet);
		row = sheet.getRow(rownum);
		int cellcount = row.getLastCellNum();
		workbook.close();
		fileInput.close();
		return cellcount;
	}

	public static String getCellData(File file, String shet, int rownum, int cellnum) throws IOException {

		fileInput = new FileInputStream(file);
		workbook = new XSSFWorkbook(fileInput);
		sheet = workbook.getSheet(shet);
		row = sheet.getRow(rownum);
		cell = row.getCell(cellnum);
		String celldata = cell.toString();
		workbook.close();
		fileInput.close();
		return celldata;

	}

	public static void setCellData(File file, String shet, int rownum, int cellnum, String data) throws IOException {
		fileInput = new FileInputStream(file);
		workbook = new XSSFWorkbook();
		sheet = workbook.getSheet(shet);
		row = sheet.getRow(rownum);
		cell = row.createCell(cellnum);
		cell.setCellValue(data);
		fileOutput = new FileOutputStream(file);
		workbook.write(fileOutput);
		workbook.close();
		fileInput.close();
		fileOutput.close();

	}
}

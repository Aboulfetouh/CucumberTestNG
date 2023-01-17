package Readerclass;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import net.bytebuddy.asm.Advice.This;

public class xlsxReader {

	XSSFWorkbook wb;
	XSSFSheet sheet;
	Cell cell;
	Row row;

	public static String getFileName(File dir) {
		for (File file : dir.listFiles()) {
			String filePath = file.getPath();
			if (file.isFile() && filePath.endsWith(".xlsx")) {
				return filePath;
			}
		}
		return null;
	}

	public xlsxReader(String excelFilePath, int sheetIndex) {
		try {
			InputStream fis = This.class.getClassLoader().getResourceAsStream(excelFilePath);
			wb = new XSSFWorkbook(fis);
			sheet = wb.getSheetAt(sheetIndex);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public int getRowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	public int getColCount() {
		return sheet.getRow(0).getLastCellNum();
	}

	public Object getDataType(int totalrows, int totalCols) {
		cell = sheet.getRow(totalrows).getCell(totalCols);
		CellType cellType = cell.getCellType();
		switch (cellType) {
		case STRING:
			return cell.getStringCellValue();
		case BOOLEAN:
			return cell.getBooleanCellValue();
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
				System.out.print(dateFormat.format(cell.getDateCellValue()) + "\t\t");
			} else {
				return cell.getNumericCellValue();
			}
		case FORMULA:
			return cell.getCellFormula();
		case ERROR:
			return cell.getErrorCellValue();
		default:
		}
		return cellType;
	}

	public Object[][] getAllData() {
		Object testData[][] = new String[getRowCount() - 1][getColCount()];
		for (int i = 0; i < getRowCount() - 1; i++) {
			for (int j = 0; j < getColCount(); j++) {
			testData[i][j] = getDataType(i + 1, j);}}
			return testData;
	}

	public Object[][] getIndex(int rowIndex) throws Exception {
		try {
			row = sheet.getRow(rowIndex);
			int totalCols = row.getLastCellNum();
			System.out.println("The number of columns found is:> " + totalCols);
			Object testDataAtIndex[][] = new String[1][totalCols];
			for (int j = 0; j < getColCount(); j++) {
				testDataAtIndex[0][j] = getDataType(rowIndex, j);
			}
			return testDataAtIndex;
		} catch (Exception e) {
//			System.out.println("\n" + "**WARRNING** The Row number you are trying to read/load is [ " + row + " ]" + "\n"
//					+ "Please select a valid Row-Index and try again :)" + "\n");
			System.out.println(e.getMessage());
		}
		return null;
	}

	public String getCell(int RowNumber, int CoulmnNumber) {
//		sheet = wb.getSheetAt(SheetNumber);
		String cellValue = sheet.getRow(RowNumber).getCell(CoulmnNumber).getStringCellValue();
		return cellValue;
	}
}
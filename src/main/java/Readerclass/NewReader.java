package Readerclass;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class NewReader {

	XSSFWorkbook wb;
	XSSFSheet sheet;

	public NewReader(String excelFilePath) {
		try {
			File csv = new File(excelFilePath);
			FileInputStream fis = new FileInputStream(csv);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());}
	}

	public String[][] getNewData(int sheetIndex) {
		sheet = wb.getSheetAt(sheetIndex);
		int totalrows = sheet.getPhysicalNumberOfRows();
		int totalCols = sheet.getRow(0).getLastCellNum();
		String testData[][] = new String[totalrows - 1][totalCols];
		for (int i = 0; i < totalrows - 1; i++) {
			for (int j = 0; j < totalCols; j++) {
				DataFormatter format = new DataFormatter();
				testData[i][j] = format.formatCellValue(sheet.getRow(i + 1).getCell(j));
			}}return testData;
	}
}
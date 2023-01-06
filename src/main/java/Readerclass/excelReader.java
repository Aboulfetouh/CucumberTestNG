package Readerclass;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class excelReader {

	XSSFWorkbook wb;
	XSSFSheet sheetOne;

	public excelReader(String excelFilePath) {

		try {
			File csv = new File(excelFilePath);
			FileInputStream fis = new FileInputStream(csv);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public String[][] getAllData(int sheetIndex) {
		sheetOne = wb.getSheetAt(sheetIndex);
		int totalrows = sheetOne.getLastRowNum();
		Row rowCells = sheetOne.getRow(0);
		int totalCols = rowCells.getPhysicalNumberOfCells();

		DataFormatter format = new DataFormatter();
		String testData[][] = new String[totalrows][totalCols];
//			Navigates through the Rows
		for (int i = 1; i <= totalrows; i++) {
//				Navigates through the Columns
			for (int j = 0; j < totalCols; j++) {
				testData[i - 1][j] = format.formatCellValue(sheetOne.getRow(i).getCell(j));
				System.out.println(testData[i - 1][j]);
			}
		}
		return testData;
	}
}
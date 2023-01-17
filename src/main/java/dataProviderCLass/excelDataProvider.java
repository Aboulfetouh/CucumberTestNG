package dataProviderCLass;

import java.io.IOException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Readerclass.NewReader;
import static Readerclass.configReader.*;
import Readerclass.xlsxReader;

public class excelDataProvider {

	@DataProvider(name = "CellValue")
	public Object[][] passNewData() throws IOException {
		NewReader CSV = new NewReader("resources//expectedData.xlsx");
		Object[][] CellValue = CSV.getNewData(0);
		return CellValue;
	}

	@DataProvider(name = "AllDataDynamic")
	public Object[][] passAllValues() throws IOException {
		xlsxReader mySheet = new xlsxReader(getStringValue("testDataFile"), getIntValue("sheetIndex"));
		Object[][] CellValue = mySheet.getAllData();
		return CellValue;
	}

	@DataProvider(name = "IndexDataDynamic")
	public Object[][] passIndexValue() throws Exception {
		xlsxReader mySheet = new xlsxReader(getStringValue("testDataFile"), getIntValue("sheetIndex"));
		Object[][] CellValue = mySheet.getIndex(getIntValue("rowIndex"));
		return CellValue;
	}

	@Test(dataProvider = "AllDataDynamic")
	public void setUp1(String value1, String value2, String value3, String value4) throws IOException {
		System.out.println("This is :>> setUp 1");
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println(value4);
		System.out.println("===============================================");
	}

	@Test(dataProvider = "IndexDataDynamic")
	public void setUp2(String value1, String value2, String value3, String value4) throws IOException {
		System.out.println("This is :>> setUp 2");
		System.out.println(value1);
		System.out.println(value2);
		System.out.println(value3);
		System.out.println(value4);
		System.out.println("===============================================");
	}

	@Test
	public void setUp3() throws IOException {
		xlsxReader mySheet = new xlsxReader(getStringValue("testDataFile"), getIntValue("sheetIndex"));
		System.out.println("This is :>> setUp 3");
		String CellValue = mySheet.getCell(1, 1);
		System.out.println(CellValue);
		System.out.println(mySheet.getCell(1, 2));
		System.out.println("===============================================");
	}
}
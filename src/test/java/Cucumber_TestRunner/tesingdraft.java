package Cucumber_TestRunner;

import java.io.IOException;

import org.testng.annotations.Test;

import Readerclass.configReader;
import Readerclass.dConfigReader;
import Readerclass.xlsxReader;
import io.github.bonigarcia.wdm.WebDriverManager;

public class tesingdraft {

	@Test
	public void setUp() throws Exception {
		System.out.println(dConfigReader.getStringValue("config.properties", "testString1"));
		System.out.println(dConfigReader.getIntValue("config.properties", "testInteger1"));
		System.out.println(dConfigReader.getBooleanValue("config.properties", "testBoolean1"));
		System.out.println(dConfigReader.getStringValue("config.properties", "testString2"));
		System.out.println(dConfigReader.getIntValue("config.properties", "testInteger2"));
		System.out.println(dConfigReader.getBooleanValue("config.properties", "testBoolean2"));
		System.out.println("***************************************");
		System.out.println(configReader.getStringValue("testString1"));
		System.out.println(configReader.getIntValue("testInteger1"));
		System.out.println(configReader.getBooleanValue("testBoolean1"));
		System.out.println(configReader.getStringValue("testDataFile"));
		System.out.println(configReader.getIntValue("sheetIndex"));
	}
}
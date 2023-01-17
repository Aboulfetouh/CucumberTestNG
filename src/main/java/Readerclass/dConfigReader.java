package Readerclass;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import net.bytebuddy.asm.Advice.This;

public class dConfigReader {

	public static Properties getPropertyObjects(String propertyName) throws IOException {
		InputStream FP = This.class.getClassLoader().getResourceAsStream(propertyName);
		Properties prop = new Properties();
		prop.load(FP);
		return prop;
	}

	public static String getStringValue(String propertiesName, String keyVaule) throws IOException {
		return getPropertyObjects(propertiesName).getProperty(keyVaule);
	}

	public static int getIntValue(String propertiesName, String keyVaule) throws IOException {
		return Integer.parseInt(getPropertyObjects(propertiesName).getProperty(keyVaule));
	}

	public static boolean getBooleanValue(String propertiesName, String keyVaule) throws IOException {
		return Boolean.valueOf(getPropertyObjects(propertiesName).getProperty(keyVaule));
	}
}
package Readerclass;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import net.bytebuddy.asm.Advice.This;

public class configReader {

	public static Properties getPropertyObjects() throws IOException {
		InputStream FP = This.class.getClassLoader().getResourceAsStream("config.properties");
		Properties prop = new Properties();
		prop.load(FP);
		return prop;
	}

	public static String getStringValue(String keyVaule) throws IOException {
		return getPropertyObjects().getProperty(keyVaule);
	}

	public static int getIntValue(String keyVaule) throws IOException {
		return Integer.parseInt(getPropertyObjects().getProperty(keyVaule));
	}

	public static boolean getBooleanValue(String keyVaule) throws IOException {
		return Boolean.valueOf(getPropertyObjects().getProperty(keyVaule));
	}
}
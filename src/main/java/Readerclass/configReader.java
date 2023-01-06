package Readerclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {

	public static Properties getPropertyObjects() throws IOException {
		FileInputStream FP = new FileInputStream("resources//config.properties");
		Properties prop = new Properties();
		prop.load(FP);
		return prop;
	}

	public static String getBrowser() throws IOException {
		return getPropertyObjects().getProperty("browser");
	}

	public static String getOrangehrmLiveURL() throws IOException {
		return getPropertyObjects().getProperty("orangehrmliveURL");
	}

	public static String getOrangeDashboardURL() throws IOException {
		return getPropertyObjects().getProperty("orangedashboardURL");
	}

	public static String getLetskodeitURL() throws IOException {
		return getPropertyObjects().getProperty("letskodeitURL");
	}

	public static String getJQueryURL() throws IOException {
		return getPropertyObjects().getProperty("jqueryURL");
	}
}
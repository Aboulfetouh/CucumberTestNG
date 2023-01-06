package Readerclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class directorySourceReader {

	public static Properties getPropertyObjects() throws IOException {
		FileInputStream FP = new FileInputStream("resources//directorySource.properties");
		Properties prop = new Properties();prop.load(FP);return prop;}

	public static String getScreeshotsDirectory() throws IOException {
		return getPropertyObjects().getProperty("screeshotDirectory");}

	public static String getCookiesDirectory() throws IOException {
		return getPropertyObjects().getProperty("cookiesDirectory");}

	public static String getCookiestextFile() throws IOException {
		return getPropertyObjects().getProperty("cookiesTextFile");}

//	public static String getCookiesScreeshot() throws IOException {
//		return getPropertyObjects().getProperty("cookiesScreeshot");}
//
//	public static String getIframeScreeshot() throws IOException {
//		return getPropertyObjects().getProperty("iframeScreeshot");}
}
package UtilitiesClass;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.StringTokenizer;

import org.openqa.selenium.Cookie;

import OrangehrmLive_Pageclass.baseclass;

public class CookiesManager {
	DirectoryManager directoryMan = new DirectoryManager();

	public void storeCookiesToText(String Directory, String Filename) throws IOException {
		File myCoockie = new File(directoryMan.createFileWithDir(Directory, Filename).toString());
		if (myCoockie.exists()) {myCoockie.delete();} myCoockie.createNewFile();
		FileWriter fWriter = new FileWriter(myCoockie);	BufferedWriter bWriter = new BufferedWriter(fWriter);
		for (Cookie cookie : baseclass.getDriver().manage().getCookies()) {
			bWriter.write((cookie.getName() + ";" + cookie.getValue() + ";" + cookie.getDomain() + ";" +
			cookie.getPath()+ ";" + cookie.getExpiry() + ";" + cookie.isSecure()));bWriter.newLine();
			System.out.println("The Cookie content found in the web-browser is:> [ " + cookie + " ]");}
			bWriter.close();fWriter.close();}

	@SuppressWarnings("deprecation")
	public void loadCookies(String Directory, String Filename) {
		try {
			FileReader FR = new FileReader(directoryMan.createFileWithDir(Directory, Filename).toString());
			BufferedReader BR = new BufferedReader(FR);
			String lines;while ((lines = BR.readLine()) != null){
			StringTokenizer cookies = new StringTokenizer(lines, ";");
			while (cookies.hasMoreTokens()) {String name = cookies.nextToken();
			String value = cookies.nextToken();String domain = cookies.nextToken();
			String path = cookies.nextToken();Date expiry = null;String def;
			if (!(def = cookies.nextToken()).equals("null")) {expiry = new Date(def);}
			Boolean isSecure = new Boolean(cookies.nextToken()).booleanValue();
			Cookie myCookies = new Cookie(name, value, domain, path, expiry, isSecure);
			System.out.println("The Cookie content found in the text file is:> [ " + myCookies + " ]");
			baseclass.getDriver().manage().deleteAllCookies();
			baseclass.getDriver().manage().addCookie(myCookies);}}} catch (Exception ex) {ex.printStackTrace();}
//			baseclass.getDriver().get(dashboardURL);
		}
}
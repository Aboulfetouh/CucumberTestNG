package Cucumber_TestRunner;

import org.testng.annotations.Test;

import OrangehrmLive_Pageclass.baseclass;
import static Readerclass.configReader.*;
import UtilitiesClass.DirectoryManager;
import UtilitiesClass.TakeScreenShot;

public class tesingdraft extends baseclass {

	@Test
	public void setDir() throws Exception {
		baseclass base = new baseclass();
		TakeScreenShot screenshot = new TakeScreenShot();
		DirectoryManager dir = new DirectoryManager();
		base.getURL("https://www.google.com/");
//		String browserslist[] = getStringValue("browsers").split(",");
//		for (int i = 0; i < browserslist.length; i++) 
//			System.out.println(browserslist[i]);
		screenshot.takeFullScreenshot(baseclass.getDriver(),
				getStringValue("TestoOutputDir") + getStringValue("screeshotDir"), "Passed AlhamudleAllah--");
	}
}
package UtilitiesClass;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.coordinates.WebDriverCoordsProvider;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class TakeScreenShot {

	public void takeFullScreenshot(WebDriver driver, String directory, String filename) throws Exception {
		DirectoryManager directoryMan = new DirectoryManager();
		Screenshot myScreenshot = new AShot()
				.shootingStrategy(ShootingStrategies.viewportPasting(ShootingStrategies.scaling(1.25f), 1000))
				.takeScreenshot(driver);
		ImageIO.write(myScreenshot.getImage(), "JPG",
				new File(directoryMan.createFileWithDir(directory, filename) + timestamp() + ".jpg"));
		System.out.println("A Full screenshot is being taken now || The name and location of the screenshot is [ " + directory+filename + " "
				+ timestamp() + " ]");
	}

	public void takeElementScreenshot(WebDriver driver, String directory, String filename, WebElement webElement)
			throws Exception {
		DirectoryManager directoryMan = new DirectoryManager();
		Screenshot myScreenshot = new AShot().coordsProvider(new WebDriverCoordsProvider()).shootingStrategy(ShootingStrategies.scaling(1f)).takeScreenshot(driver,
				webElement);
		ImageIO.write(myScreenshot.getImage(), "PNG",
				new File(directoryMan.createFileWithDir(directory, filename) + timestamp() + ".png"));
		System.out.println("A screenshot for a specific element is being taken now || The name and location of the screenshot is [ " + directory+filename + " "
				+ timestamp() + " ]");
	}

	public static String timestamp() {
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
}
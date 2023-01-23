package UtilitiesClass;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.testng.annotations.Test;

public class DirectoryManagerTestclass {

	public Path createFileWithDir(String directory, String fileName) {
		File dir = new File(directory);
		if (!dir.exists())
			dir.mkdirs();
		return Paths.get(directory + File.separatorChar + fileName);
	}

	public File getFile(String fileName) throws IOException, URISyntaxException {
		URL res = getClass().getClassLoader().getResource(fileName);
//		File file = Paths.get(res.toURI()).toFile();
//		String absolutePath = file.getAbsolutePath();
//		System.out.println("here's the getName > " + file.getName());
//		System.out.println("here's the getParent > " + file.getParent());
//		System.out.println("here's the getParentFile > " + file.getParentFile());
//		System.out.println("here's the getCanonicalPath > " + file.getAbsolutePath());
		return Paths.get(res.toURI()).toFile();
	}

	public File[] getResourceFiles(String folderName) {
		URL res = getClass().getClassLoader().getResource(folderName);
//		if (res == null)
//			createFileWithDir(folderName, fileName);
		String path = res.getPath();
		return new File(res.getPath().toString()).listFiles();
	}

	public String getFilePath(String folderName, String fileName) throws IOException, URISyntaxException {
		File[] listOfFiles = getResourceFiles(folderName);
		String csvFile = null;
		for (int i = 0; i <= listOfFiles.length; i++) {
			if (listOfFiles[i].getName().equalsIgnoreCase(fileName)) {
				csvFile = listOfFiles[i].getAbsolutePath();
				System.out.println("Inside method getFilePath >> " + csvFile);
				break;
			}
//			else {
//				System.out.println("The file [ " + fileName + " ] you're looking for is not in the dir folder [ "
//						+ folderName + " ]");
//			}
		}
		return csvFile;

	}

	@Test
	public void getfilename() throws IOException, URISyntaxException {
//		String filepath = getFilePath("TestRunScreeshots/", "testfile.xlsx");
//		System.out.println("The test printout and the value of the file is >> [ " + filepath + " ]");
//		File[] listOfFiles = getResourceFiles("TestRunScreeshots/Passed AlhamudleAllah.jpg");
//		System.out.println(listOfFiles.length);
//		System.out.println(listOfFiles[0].getName());

		String folderpath = getFile("TestRunScreeshots/Passed AlhamudleAllah.jpg").getAbsolutePath();
		System.out.println("The test printout and the value of the folderpath is >> [ " + folderpath + " ]");
		System.out.println("The test printout and the value of the getName is >> [ "
				+ getFile("TestRunScreeshots/Passed AlhamudleAllah.jpg").getName() + " ]");

//		createFileWithDir(getFilePath(null, null));
	}

}
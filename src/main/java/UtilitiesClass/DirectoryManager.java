package UtilitiesClass;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import org.testng.annotations.Test;

public class DirectoryManager {

	public Path createFileWithDir(String directory, String fileName) {
		File dir = new File(directory);
		if (!dir.exists())dir.mkdirs();
		return Paths.get(directory + File.separatorChar + fileName);
	}

	public File getResourceFile(String fileName) throws IOException, URISyntaxException {
		URL res = getClass().getClassLoader().getResource(fileName);
		return Paths.get(res.toURI()).toFile();
	}

	public File[] getResourceList(String folderName) {
		URL res = getClass().getClassLoader().getResource(folderName);
		return new File(res.getPath()).listFiles();
	}

	public String getFilePath(String folderName, String fileName) throws IOException, URISyntaxException {
		File[] listOfFiles = getResourceList(folderName);
		String csvFile = null;
		for (int i = 0; i <= listOfFiles.length; i++) {
			if (listOfFiles[i].getName().equalsIgnoreCase(fileName)) {
				csvFile = listOfFiles[i].getAbsolutePath();
				System.out.println("Inside method getFilePath >> " + csvFile);
				break;}} return csvFile;
	}

//	public Path createPath(String Directory, String fileName) throws IOException {
//		File myfile = new File(getResourceFiles(Directory));
////		URL res = getClass().getClassLoader().getResource(Directory);
////		File myfile = new File(createFileWithDir(res.toString(), fileName).toString());
////		if (!myfile.exists())
////			myfile.mkdirs();
//		return Paths.get(Directory + File.separatorChar + fileName);
//	}
}
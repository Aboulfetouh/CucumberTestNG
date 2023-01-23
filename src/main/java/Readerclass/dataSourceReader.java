package Readerclass;

import java.io.File;
import java.net.URL;

import org.testng.annotations.Test;

public class dataSourceReader {

//	private static File[] getResourceFolderFiles(String folder) {
//		ClassLoader loader = Thread.currentThread().getContextClassLoader();
//		URL url = loader.getResource(folder);
//		String path = url.getPath();
//		return new File(path).listFiles();
//	}
//	
	public File[] getResourceFolderFiles(String folder) {
		URL res = getClass().getClassLoader().getResource(folder);
		String path = res.getPath();
		return new File(path).listFiles();
	}

	@Test
	public void getfilename() {
		for (File f : getResourceFolderFiles("TestData")) {
			System.out.println(f.getName());
			System.out.println(f.getAbsolutePath());

		}
	}
}

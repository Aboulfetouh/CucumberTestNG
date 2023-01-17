package UtilitiesClass;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryManager {

	public Path createFileWithDir(String directory, String filename) {
		File dir = new File(directory);
		if (!dir.exists())
			dir.mkdirs();
		return Paths.get(directory + File.separatorChar + filename);
	}

	public File getPath(String fileName) throws IOException, URISyntaxException {
		URL res = getClass().getClassLoader().getResource(fileName);
		File file = Paths.get(res.toURI()).toFile();
//		String absolutePath = file.getAbsolutePath();
		System.out.println("here's the getName > " + file.getName());
		System.out.println("here's the getParent > " + file.getParent());
		System.out.println("here's the getParentFile > " + file.getParentFile());
		System.out.println("here's the getCanonicalPath > " + file.getAbsolutePath());
		return file;
	}
}
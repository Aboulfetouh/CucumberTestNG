package UtilitiesClass;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DirectoryManager {

	public Path createFileWithDir(String directory, String filename) {
		File dir = new File(directory);
		if (!dir.exists())
			dir.mkdirs();
		return Paths.get(directory + File.separatorChar + filename);
	}
}
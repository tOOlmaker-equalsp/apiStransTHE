package com.equalsp.stransthe;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DesktopFileHanlder implements CachedServiceFileHander {	
	private static final String PATH = "src/main/resources/cachedInthegraService.json";

	@Override
	public String loadCacheFile() throws IOException {
		String fileContent = "";
		Path path = Paths.get(PATH);
		if (Files.exists(path, LinkOption.NOFOLLOW_LINKS) ){
			fileContent = new String(Files.readAllBytes(path));
		}
		return fileContent;
	}

	@Override
	public void saveCacheFile(String cacheJson) throws IOException {
		Path path = Paths.get(PATH);
		Files.deleteIfExists(path);
		Files.createFile(path);
		try (BufferedWriter writer = Files.newBufferedWriter(path)) {
			writer.write(cacheJson);
		}
	}

}

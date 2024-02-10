package com.java.utility;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class Utility {

	public static Properties properties() throws IOException {
		Properties pr = new Properties();
		pr.load(Files.newInputStream(Paths.get("config.properties")));

		return pr;
	}
}

package com.goeuro.task.config;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

	private final String PROPERTIES_FILE_PATH = "config.properties";
	private final String PROPERTY_KEY_URL = "URL";
	private final String PROPERTY_KEY_OUTPUT_FILE = "output_file";

	// singleton instance
	private static Configuration configuration;

	private Properties properties;

	private Configuration() {
		properties = new Properties();
		try (InputStream input = this.getClass().getClassLoader()
				.getResourceAsStream(PROPERTIES_FILE_PATH)) {
			properties.load(input);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static Configuration getInstance() {
		if (configuration == null) {
			configuration = new Configuration();
		}
		return configuration;
	}

	public String getAPIEndpointURL() {
		if (properties != null) {
			return properties.getProperty(PROPERTY_KEY_URL);
		}
		return null;
	}

	public String getCSVFilePath() {
		if (properties != null) {
			return properties.getProperty(PROPERTY_KEY_OUTPUT_FILE);
		}
		return null;
	}

}

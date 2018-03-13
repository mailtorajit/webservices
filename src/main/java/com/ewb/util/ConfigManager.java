package com.ewb.util;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

public class ConfigManager {
	private static final String PROPERTIES_FILE = "/automation.properties";
	private static Properties properties = new Properties();
	protected static ConcurrentHashMap<String, String> _config = null;
	protected static Map<Long, ConcurrentHashMap<String, String>> _overridePropertiesHash = Collections
			.synchronizedMap(new LinkedHashMap<Long, ConcurrentHashMap<String, String>>());

	/**
	 * static method to get Instance of class AutProperties
	 * 
	 * @return
	 */
	public static ConfigManager getInstance() {
		final ConfigManager me = new ConfigManager();
		me.loadProperties(me.getPropertiesFile());
		return me;
	}
	
	public static ConfigManager getInstance(String filename) {
		final ConfigManager me = new ConfigManager();
		me.loadProperties(me.getPropertiesFile(filename));
		return me;
	}

	/**
	 * Step 1
	 *
	 * Get the Property file as input stream
	 * 
	 * @return
	 */
	private InputStream getPropertiesFile() {
		return this.getClass().getResourceAsStream(PROPERTIES_FILE);
	}
	
	private InputStream getPropertiesFile(String filename) {
		return this.getClass().getResourceAsStream(filename);
	}

	/**
	 * Step 2
	 *
	 * Load Properties
	 * 
	 * @param propertiesStream
	 * @return
	 */
	private void loadProperties(InputStream propertiesStream) {
		try {
			properties.load(propertiesStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public String getProperty(String key) {
		return properties.getProperty(key);
	}

	public String getProperty(String key, String defaultValue) {
		return properties.getProperty(key, defaultValue);
	}

	public void setProperty(String key, String value) {
		properties.setProperty(key, value);
	}

	
	public boolean hasProperty(String name) {
		return properties.contains(name);
	}

}

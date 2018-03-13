package com.ewb.base;

import org.testng.ITestContext;
import org.testng.annotations.BeforeSuite;

import com.ewb.util.ConfigManager;

public class BaseTest {
	public BaseTest() {
	}
	
	@BeforeSuite(alwaysRun = true)
	public final void mandatoryBeforeSuite(ITestContext context){
		final String PROPERTIES_FILE = "/properties/Input.properties";
		ConfigManager config = ConfigManager.getInstance(PROPERTIES_FILE);
		System.out.println(config.getProperty("base_url"));
	}

}

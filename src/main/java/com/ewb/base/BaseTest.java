package com.ewb.base;

import org.testng.ITestContext;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.ewb.util.ConfigManager;

public class BaseTest {
	public ConfigManager config;
	public BaseTest() {
	}
	
	@BeforeSuite(alwaysRun = true)
	public final void mandatoryBeforeSuite(ITestContext context){
		final String PROPERTIES_FILE = "/properties/Input.properties";
		 config= ConfigManager.getInstance(PROPERTIES_FILE);
		System.out.println(config.getProperty("base_url"));
	}
	
	@AfterSuite(alwaysRun = true)
	public final void mandatoryAfterSuite(ITestContext context){
		final String PROPERTIES_FILE = "/properties/Input.properties";
		 config= ConfigManager.getInstance(PROPERTIES_FILE);
		System.out.println(config.getProperty("base_url"));
	}

}

package com.ewb.base;

import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ewb.util.ConfigManager;
import com.ewb.util.Log;

public class BaseTest {
	public static ConfigManager config;
	final String PROPERTIES_FILE = "/properties/Input.properties";

	public BaseTest() {
	}

	@BeforeSuite(alwaysRun = true)
	public final void mandatoryBeforeSuite(ITestContext context) {
		config = ConfigManager.getInstance(PROPERTIES_FILE);
		System.out.println(config.getProperty("base_url"));
		System.out.println(config.getProperty("base_url"));
	}

	@AfterSuite(alwaysRun = true)
	public final void mandatoryAfterSuite(ITestContext context) {
		Log.info("************ Suite execution completed *************");
	}

	@BeforeMethod
	public void mandatoryBeforeMethod() {
		//Log.info("Started test case");
		// Log.startTestCase(this.getClass().getEnclosingMethod().getName());
	}

	@AfterMethod
	public void mandatoryAfterMethod() {
		//Log.info("Completed test case");
		// Log.startTestCase(this.getClass().getEnclosingMethod().getName());
	}

	@BeforeClass
	public void mandatoryBeforeClass() {
		Log.startTestCase(this.getClass().getName());
	}

	@AfterClass
	public void mandatoryAfterClass() {
		Log.endTestCase(this.getClass().getName());
	}

}

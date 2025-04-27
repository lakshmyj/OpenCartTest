package com.qa.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.qa.factory.DriverFactory;
import com.qa.pages.HomePage;

public class BaseTest {

	WebDriver driver;
	DriverFactory driverFactory;
	protected Properties propertyFile;
	public HomePage homePage;
	
	@BeforeTest
	@Parameters({"browser", "browserversion"})
	public void setUp(String browserName, String browserVersion) 
	{
		driverFactory = new DriverFactory();
		propertyFile = driverFactory.initProp();	
		
		/*
		 * Browser name and version will be set in testng.xml file. 
		 * These values are set in the property file using setProperty()
		 * This will internally set the value pair and 
		 * will not be visible as is in the property file
		 * Used to access these values from testng xml outside of src/test package
		 * Outside of src/test package, getProperty() will return the browser details
		 */
		if(browserName!=null) {
			propertyFile.setProperty("browser", browserName);
			propertyFile.setProperty("browserversion", browserVersion);
		}
	driver = driverFactory.initDriver(propertyFile);
	homePage = new HomePage(driver);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	
}

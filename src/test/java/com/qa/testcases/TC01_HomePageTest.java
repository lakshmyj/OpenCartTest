package com.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.extentreport.ExtentReportListener;
import com.qa.pages.HomePage;

public class TC01_HomePageTest extends BaseTest{	
	private static Logger logger = LogManager.getLogger(TC01_HomePageTest.class);
	
	@Test
	public void homePageTitleTest()
	{
		logger.info("Asserting home page title");
		ExtentReportListener.getExtentTest().info("Asserting home page title");
		Assert.assertEquals(homePage.validateHomePageTitle(),"Your Store","HomePage Title Mismatch");
	}
	

	
	
}

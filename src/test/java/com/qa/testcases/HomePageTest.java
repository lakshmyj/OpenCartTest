package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.HomePage;

public class HomePageTest extends BaseClass{

	HomePage homepage;
	
	public HomePageTest()
	{
		super();//calls the parent class constructor
	}
	
	@BeforeMethod
	public void setUp()
	{
		//initialization();
		super.setUp();
		homepage = new HomePage();
	}
	
	@Test
	public void homePageTitleTest()
	{
		Assert.assertEquals(homepage.validateHomePageTitle(),"Your Store","HomePage Title Mismatch");
	}
	
//	@AfterMethod
//	public void tearDown()
//	{
//		driver.quit();
//	}
	
	
}

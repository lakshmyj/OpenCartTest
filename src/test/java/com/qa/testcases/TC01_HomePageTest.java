package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.HomePage;

public class TC01_HomePageTest extends BaseTest{	
	@Test
	public void homePageTitleTest()
	{
		Assert.assertEquals(homePage.validateHomePageTitle(),"Your Store","HomePage Title Mismatch");
	}
	

	
	
}

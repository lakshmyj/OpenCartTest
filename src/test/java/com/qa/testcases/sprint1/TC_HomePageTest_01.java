package com.qa.testcases.sprint1;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.HomePage;

public class TC_HomePageTest_01 extends BaseTest{

	//HomePage homepage;
	
	@Test
	public void homePageTitleTest()
	{
		//System.out.println("hptest "+homePage.validateHomePageTitle());
		Assert.assertEquals(homePage.validateHomePageTitle(),"Your Store","HomePage Title Mismatch");
	}
	

	
	
}

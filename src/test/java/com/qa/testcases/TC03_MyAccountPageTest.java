package com.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.pages.HomePage;
import com.qa.pages.MyAccountPage;

public class TC03_MyAccountPageTest extends BaseTest{

	public MyAccountPage myaccountpage;
	public HomePage homepage;
	public LoginPage loginpage;
	private static Logger logger = LogManager.getLogger(TC03_MyAccountPageTest.class);
	
	public void landOnMyAccountsPage() { 
		homePage.clickMyAccountOptions();
		loginpage = homePage.clickOnLoginOption();
		myaccountpage = loginpage.login("lucky@gmail.com","lucky@123");
	}
	
	@Test
	public void myAccountsPageTitleTest() throws InterruptedException
	{
		logger.info("verifying my accounts page title");
		landOnMyAccountsPage();
		Thread.sleep(2000);
		Assert.assertEquals(myaccountpage.validateMyAccountsPageTitle(),"My Account","My Accounts Page Title Mismatch");
	}
	
}

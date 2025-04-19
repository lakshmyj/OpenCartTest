package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.AccountLoginPage;
import com.qa.pages.HomePage;
import com.qa.pages.MyAccountPage;

public class MyAccountPageTest extends BaseClass{

	public MyAccountPage myaccountpage;
	public HomePage homepage;
	public AccountLoginPage accountloginpage;
	
	public MyAccountPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initialization();
		myaccountpage = new MyAccountPage();
		homepage = new HomePage();
		homepage.clickMyAccountOptions();
		accountloginpage = homepage.clickOnLoginOption();
		myaccountpage = accountloginpage.login(propFile.getProperty("username"), propFile.getProperty("password"));
	}
	
	@Test
	public void myAccountsPageTitleTest() throws InterruptedException
	{
		Thread.sleep(2000);
		Assert.assertEquals(myaccountpage.validateMyAccountsPageTitle(),"My Account","My Accounts Page Title Mismatch");
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
	
}

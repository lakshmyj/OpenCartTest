package com.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BaseClass;
import com.qa.pages.AccountLoginPage;
import com.qa.pages.HomePage;
import com.qa.pages.MyAccountPage;
import com.qa.util.ExcelUtility;

public class AccountLoginPageTest extends BaseClass{

	public AccountLoginPage accountloginpage;
	public MyAccountPage myaccountpage;
	public HomePage homepage;
	
	String sheetName="loginData";
	
	public AccountLoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		super.setUp();
		accountloginpage = new AccountLoginPage();
		homepage = new HomePage();
		homepage.clickMyAccountOptions();
		accountloginpage = homepage.clickOnLoginOption();
	}
	
	@Test(priority=1)
//	public void accountLoginPageTitleTest()
//	{
//		Assert.assertEquals(accountloginpage.validateAccountsPageTitle(),"Account Login","Account Login Page Title Mismatch");
//	}
	
	@DataProvider
	public Object[][] getLoginTestData() {
		Object data[][] = ExcelUtility.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getLoginTestData")
	public void loginTest(String username, String password, String expectedResult) throws InterruptedException
	{
		//myaccountpage = accountloginpage.login(propFile.getProperty("username"), propFile.getProperty("password"));
		myaccountpage = accountloginpage.login(username,password);
		
		if(myaccountpage.isMyAccountHeadingPresent())
		{
			if(myaccountpage.getMyAccountHeading().equals("My Account"))
				Assert.assertEquals("Valid",expectedResult);				
		}
		else
		{
			Assert.assertEquals("Invalid",expectedResult);
		}
	}

}

package com.qa.testcases;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.base.BaseTest;
import com.qa.pages.LoginPage;
import com.qa.pages.HomePage;
import com.qa.pages.MyAccountPage;
import com.qa.util.ExcelUtility;

public class TC02_LoginPageTest extends BaseTest{

	public LoginPage loginpage;
	public MyAccountPage myaccountpage;
	//public HomePage homePage;
	
	String sheetName="loginData";
	private static Logger logger = LogManager.getLogger(TC02_LoginPageTest.class);
	
//	public TC02_LoginPageTest()
//	{
//		super();
//	}
	
//	@BeforeMethod
//	public void setUp()
//	{
////		super.setUp();
////		accountloginpage = new AccountLoginPage();
////		homepage = new HomePage();
////		homepage.clickMyAccountOptions();
////		accountloginpage = homepage.clickOnLoginOption();
//	}
	
	public void landOnLoginPage() { 
		homePage.clickMyAccountOptions();
		loginpage = homePage.clickOnLoginOption();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() throws InterruptedException
	{
		logger.info("verifying login page title");
		landOnLoginPage();
		Thread.sleep(2000);
		Assert.assertEquals(loginpage.getLoginPageTitle(),"Account Login","Account Login Page Title Mismatch");
	}
	
	@DataProvider
	public Object[][] getLoginTestData() {
		Object data[][] = ExcelUtility.getTestData(sheetName);
		return data;
	}
	
	@Test(priority=2, dataProvider="getLoginTestData")
	public void loginTest(String username, String password, String expectedResult) throws InterruptedException
	{
		landOnLoginPage();
		myaccountpage = loginpage.login(username,password);
		Thread.sleep(2000);
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

package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class AccountLoginPage extends BaseClass{

	//Page Factory
	@FindBy(id="input-email")
	WebElement login_email;
	
	@FindBy(id="input-password")
	WebElement login_password;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement login_button;
	
	//Initializing Page Objects
	public AccountLoginPage()
	{
		//System.out.println("Pagefactory initialization of AccountLoginPage inside self constructor");
		//PageFactory.initElements(driver,this);
		PageFactory.initElements(BaseClass.getDriver(),this);
	}
	
	//Actions
	public String validateAccountsPageTitle()
	{
//		System.out.println("account login title "+driver.getTitle());
//		return driver.getTitle();
		System.out.println("account login title "+BaseClass.getDriver().getTitle());
		return BaseClass.getDriver().getTitle();
	}
	
	public MyAccountPage login(String uname,String password)
	{
		//System.out.println("acclogin page login "+"uname "+uname+" password "+password);
		login_email.sendKeys(uname);
		login_password.sendKeys(password);
//		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", login_button);
//		((JavascriptExecutor) driver).executeScript("arguments[0].click();", login_button);	
		((JavascriptExecutor) BaseClass.getDriver()).executeScript("arguments[0].scrollIntoView(true);", login_button);
		((JavascriptExecutor) BaseClass.getDriver()).executeScript("arguments[0].click();", login_button);	
		return new MyAccountPage();
		
	}
	
}

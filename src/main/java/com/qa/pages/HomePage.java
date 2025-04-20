package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class HomePage extends BaseClass{
	
	//PageFactory
	@FindBy(xpath="//img[@title='Your Store']")
	WebElement pageLogo;
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement loginButton;
	
	//Initializing Page Objects
	public HomePage()
	{
		//System.out.println("HomePage constructor");
	//	PageFactory.initElements(driver,this);
		PageFactory.initElements(BaseClass.getDriver(),this);
	}
	
	//Actions
	public String validateHomePageTitle()
	{
		System.out.println("home title "+BaseClass.getDriver().getTitle());
		return BaseClass.getDriver().getTitle();
//		System.out.println("home title "+driver.getTitle());
//		return driver.getTitle();
	}
	
	public void clickMyAccountOptions()
	{
		myAccount.click();
	}
	
	public AccountLoginPage clickOnLoginOption()
	{
		loginButton.click();
		return new AccountLoginPage();
	}
}

package com.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class HomePage extends BasePage{
	
	//PageFactory
	@FindBy(xpath="//img[@title='Your Store']")
	WebElement pageLogo;
	
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement myAccount;
	
	@FindBy(xpath="//a[normalize-space()='Login']")
	WebElement loginButton;
	
	//Initializing Page Objects
	public HomePage(WebDriver driver)
	{
		super(driver);
		//System.out.println("HomePage constructor");
	//	PageFactory.initElements(driver,this);
//		this.driver = driver;
//		PageFactory.initElements(driver,this);
	}
	
	//Actions
	public String validateHomePageTitle()
	{
		System.out.println("home title "+driver.getTitle());
		return driver.getTitle();
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
//		return new AccountLoginPage();
		return new AccountLoginPage(driver);
	}
}

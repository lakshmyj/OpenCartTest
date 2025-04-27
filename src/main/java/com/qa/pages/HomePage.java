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
	}
	
	//Actions
	public String validateHomePageTitle()
	{
		return driver.getTitle();
	}
	
	public void clickMyAccountOptions()
	{
		myAccount.click();
	}
	
	public LoginPage clickOnLoginOption()
	{
		loginButton.click();
		return new LoginPage(driver);
	}
}

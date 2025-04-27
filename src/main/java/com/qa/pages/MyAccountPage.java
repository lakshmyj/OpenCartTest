package com.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class MyAccountPage extends BasePage{

	//PageFactory
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement myAccountHeading;
	
	//Initializing Page Objects
	public MyAccountPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Actions
	public String validateMyAccountsPageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean isMyAccountHeadingPresent()
	{
		try
		{
			return myAccountHeading.isDisplayed();
		}
		catch(NoSuchElementException e)
		{
			return false;
		}
	}
	
	public String getMyAccountHeading()
	{
		return myAccountHeading.getText();
	}
}

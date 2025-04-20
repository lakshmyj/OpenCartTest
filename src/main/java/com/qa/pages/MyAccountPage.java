package com.qa.pages;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BaseClass;

public class MyAccountPage extends BaseClass{

	//PageFactory
	@FindBy(xpath="//div[@id='content']/h1")
	WebElement myAccountHeading;
	
	//Initializing Page Objects
	public MyAccountPage()
	{
		//System.out.println("myaccountpage constructor");
		PageFactory.initElements(BaseClass.getDriver(),this);
//		PageFactory.initElements(driver,this);
		
	}
	
	//Actions
	public String validateMyAccountsPageTitle()
	{
		return BaseClass.getDriver().getTitle();
//		return driver.getTitle();
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

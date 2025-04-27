package com.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.BasePage;

public class LoginPage extends BasePage{

	//Page Factory
	@FindBy(id="input-email")
	WebElement login_email;
	
	@FindBy(id="input-password")
	WebElement login_password;
	
	@FindBy(xpath="//button[normalize-space()='Login']")
	WebElement login_button;
	
	//Initializing Page Objects
	public LoginPage(WebDriver driver)
	{
		super(driver);
	}
	
	//Actions
	public String getLoginPageTitle()
	{
		return driver.getTitle();
	}
	
	public MyAccountPage login(String uname,String password)
	{
		login_email.sendKeys(uname);
		login_password.sendKeys(password);
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", login_button);
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", login_button);	
		return new MyAccountPage(driver);
		
	}
	
}

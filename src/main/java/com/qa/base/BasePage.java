package com.qa.base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.qa.util.MySeleniumListener;
import com.qa.util.TestUtils;
//import com.qa.util.WebEventListener;

public class BasePage {

//	public static Properties propFile;
	protected WebDriver driver;
//	public MySeleniumListener myseleniumlistener;
//	public EventFiringDecorator decorator;
	//private static ThreadLocal<WebDriver> tldriver = new ThreadLocal<>();
	//public WebEventListener eventListener;
	//public WebDriverListener listener;
	//public Logger logger;
	
	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver,this);
		
	}
	
//	public void initialization()
//	{
//		
//		System.out.println("Initializing Browser");
//		//driver = new ChromeDriver();
//		
//		myseleniumlistener = new MySeleniumListener();
//		decorator = new EventFiringDecorator(myseleniumlistener);
//		//driver =decorator.decorate(new ChromeDriver());
//		tldriver.set(decorator.decorate(new ChromeDriver()));
//		
//		getDriver().get(propFile.getProperty("appURL"));
//		getDriver().manage().window().maximize();
//		getDriver().manage().deleteAllCookies();
//		getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.PAGE_LOAD_TIMEOUT));
//		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICIT_WAIT_DURATION));
////		driver.get(propFile.getProperty("appURL"));
////		driver.manage().window().maximize();
////		driver.manage().deleteAllCookies();
////		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.PAGE_LOAD_TIMEOUT));
////		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICIT_WAIT_DURATION));
//
//	}

}

package com.qa.base;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;
import org.openqa.selenium.support.events.WebDriverListener;

import com.qa.util.MySeleniumListener;
import com.qa.util.TestUtils;
//import com.qa.util.WebEventListener;

public class BaseClass {

	public static Properties propFile;
	public static WebDriver driver;
	public MySeleniumListener myseleniumlistener;
	public EventFiringDecorator decorator;
	//public WebEventListener eventListener;
	//public WebDriverListener listener;
	
	public BaseClass()
	{
		try
		{
			String propertiesFilePath=System.getProperty("user.dir")+"/src/main/java/com/qa/config/config.properties";
			FileReader fr = new FileReader(propertiesFilePath);
			propFile=new Properties();
			propFile.load(fr);
			//System.out.println("BaseClass constructor: Reading properties file");
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public void initialization()
	{
		//System.out.println("Initializing Browser");
		//driver = new ChromeDriver();
		
		myseleniumlistener = new MySeleniumListener();
		decorator = new EventFiringDecorator(myseleniumlistener);
		driver =decorator.decorate(new ChromeDriver());
		
		driver.get(propFile.getProperty("appURL"));
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtils.PAGE_LOAD_TIMEOUT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtils.IMPLICIT_WAIT_DURATION));
		
	}
}

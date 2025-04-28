package com.qa.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import com.qa.extentreport.ExtentReportListener;
import com.qa.util.MySeleniumListener;

public class DriverFactory {

	WebDriver driver;
	Properties propertyFile;
	private static Logger logger = LogManager.getLogger(DriverFactory.class);
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	OptionsManager optionsManager;

	public WebDriver initDriver(Properties propertyFile) {

		// logger = LogManager.getLogger(DriverFactory.class);
		String browserName = propertyFile.getProperty("browser");
		String executionEnv = propertyFile.getProperty("executionEnv");
//		System.out.println("browser name is : " + browserName);
//		System.out.println("executionEnv is : " + executionEnv);
		optionsManager = new OptionsManager(propertyFile);

		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			if (executionEnv.equals("local")) {
				// tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
				WebDriver decoratedDriver = new EventFiringDecorator<WebDriver>(new MySeleniumListener())
						.decorate(new ChromeDriver(optionsManager.getChromeOptions()));
				tlDriver.set(decoratedDriver);
			} else {
				try {
					//tlDriver.set(new RemoteWebDriver(new URL(propertyFile.getProperty("huburl")),
					//		optionsManager.getChromeOptions()));
					
					WebDriver decoratedDriver = new EventFiringDecorator<WebDriver>(new MySeleniumListener())
									.decorate(new RemoteWebDriver(new URL(propertyFile.getProperty("huburl")),
											optionsManager.getChromeOptions()));
					tlDriver.set(decoratedDriver);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
			break;
		case "firefox":
			if (executionEnv.equals("local")) {
				// tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
				WebDriver decoratedDriver = new EventFiringDecorator<WebDriver>(new MySeleniumListener())
						.decorate(new FirefoxDriver(optionsManager.getFirefoxOptions()));
				tlDriver.set(decoratedDriver);
			} else {
				try {
					//tlDriver.set(new RemoteWebDriver(new URL(propertyFile.getProperty("huburl")),
					//		optionsManager.getFirefoxOptions()));
					WebDriver decoratedDriver = new EventFiringDecorator<WebDriver>(new MySeleniumListener())
						.decorate(new RemoteWebDriver(new URL(propertyFile.getProperty("huburl")),
								optionsManager.getFirefoxOptions()));
					tlDriver.set(decoratedDriver);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
			break;
		case "edge":
			if (executionEnv.equals("local")) {
				// tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
				WebDriver decoratedDriver = new EventFiringDecorator<WebDriver>(new MySeleniumListener())
						.decorate(new EdgeDriver(optionsManager.getEdgeOptions()));
				tlDriver.set(decoratedDriver);
			} else {
				try {
					//tlDriver.set(new RemoteWebDriver(new URL(propertyFile.getProperty("huburl")),
					//		optionsManager.getEdgeOptions()));
					WebDriver decoratedDriver = new EventFiringDecorator<WebDriver>(new MySeleniumListener())
							.decorate(new RemoteWebDriver(new URL(propertyFile.getProperty("huburl")),
									optionsManager.getEdgeOptions()));
					tlDriver.set(decoratedDriver);
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
			break;
//		case "safari":
//			tlDriver.set(new SafariDriver());
//			break;
		default:
			System.out.println(browserName + " is invalid");
		}
		
		getDriver().get(propertyFile.getProperty("appURL"));
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		// System.out.println("Processed OptionsManager and returning driver");
		return getDriver();

	}

	public static WebDriver getDriver() {

//		if (tlDriver.get() == null) {
//            // Create a new ChromeDriver wrapped with EventFiringDecorator
//            EventFiringWebDriver eventDriver = new EventFiringWebDriver(new ChromeDriver());
//            // Attach the event listener to the driver
//            eventDriver.register(new MySeleniumListener());
//            // Set the WebDriver instance for the current thread
//            tldriver.set(eventDriver);
//        }
		return tlDriver.get();
	}

	public Properties initProp() {
		propertyFile = new Properties();
		logger.info("Initializing property file");
		try {
			FileInputStream ip = new FileInputStream("./src/test/resources/config/config.properties");
			propertyFile.load(ip);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return propertyFile;
	}

}

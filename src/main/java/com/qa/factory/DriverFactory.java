package com.qa.factory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;

import com.qa.factory.OptionsManager;

public class DriverFactory {

	WebDriver driver;
	Properties propertyFile;
	public Logger logger;
	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<WebDriver>();
	OptionsManager optionsManager;

	public WebDriver initDriver(Properties propertyFile) {

		logger = LogManager.getLogger(this.getClass());
		String browserName = propertyFile.getProperty("browser");
		String executionEnv = propertyFile.getProperty("executionEnv");
		System.out.println("browser name is : " + browserName);
		System.out.println("executionEnv is : " + executionEnv);
		optionsManager = new OptionsManager(propertyFile);

		switch (browserName.toLowerCase().trim()) {
		case "chrome":
			if (executionEnv.equals("local"))
				tlDriver.set(new ChromeDriver(optionsManager.getChromeOptions()));
			else {
				try {
					tlDriver.set(new RemoteWebDriver(new URL(propertyFile.getProperty("huburl")),
							optionsManager.getChromeOptions()));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
			break;
		case "firefox":
			if (executionEnv.equals("local"))
				tlDriver.set(new FirefoxDriver(optionsManager.getFirefoxOptions()));
			else {
				try {
					tlDriver.set(new RemoteWebDriver(new URL(propertyFile.getProperty("huburl")),
							optionsManager.getFirefoxOptions()));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
			break;
		case "edge":
			if (executionEnv.equals("local"))
				tlDriver.set(new EdgeDriver(optionsManager.getEdgeOptions()));
			else {
				try {
					tlDriver.set(new RemoteWebDriver(new URL(propertyFile.getProperty("huburl")),
							optionsManager.getEdgeOptions()));
				} catch (MalformedURLException e) {
					e.printStackTrace();
				}
			}
			break;
		case "safari":
			tlDriver.set(new SafariDriver());
			break;
		default:
			System.out.println(browserName + " is invalid");
		}

		getDriver().get(propertyFile.getProperty("appURL"));
		getDriver().manage().window().maximize();
		getDriver().manage().deleteAllCookies();
		System.out.println("Processed OptionsManager and returning driver");
		return getDriver();

	}

	public static WebDriver getDriver() {
		return tlDriver.get();
	}

	public Properties initProp() {
		propertyFile = new Properties();
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

	public static String getScreenshot(String methodName) {
		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);// temp dir
		String path = System.getProperty("user.dir") + "/screenshot/" + methodName + "_" + System.currentTimeMillis()
				+ ".png";
		File destination = new File(path);
		try {
			FileHandler.copy(srcFile, destination);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}

}

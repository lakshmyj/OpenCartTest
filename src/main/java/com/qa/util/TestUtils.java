package com.qa.util;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.base.BasePage;
import com.qa.factory.DriverFactory;

//public class TestUtils extends BasePage{
public class TestUtils{

//	public TestUtils(WebDriver driver) {
//		super(driver);
//		// TODO Auto-generated constructor stub
//	}

	public static long PAGE_LOAD_TIMEOUT = 15;
	public static long IMPLICIT_WAIT_DURATION = 10;
	 
	//Wait for page to load completely
//	public static void waitForPageToLoad(WebDriver driver, int timeoutInSeconds) {
//	    new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(
//	        webDriver -> ((JavascriptExecutor) webDriver)
//	            .executeScript("return document.readyState").equals("complete"));
//	}
	
	//Wait for page to get loaded and then get title
//	public static String waitForPageLoadAndGetTitle(WebDriver driver, int timeoutInSeconds) {
//	    new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(
//	        webDriver -> ((JavascriptExecutor) webDriver)
//	            .executeScript("return document.readyState").equals("complete")
//	    );
//	    return driver.getTitle();
//	}
	
//	public static String takeScreenShot(WebDriver driver, String error) {
//	        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//	        try {
//	            FileUtils.copyFile(src, new File("screenshots/error_" + System.currentTimeMillis() + ".png"));
//	        } catch (IOException e) {
//	            e.printStackTrace();
//	        }
//	        return src.toString();
//	}
	
	public static String captureScreen(String methodName) {
		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	//	TakesScreenshot screenShot = (TakesScreenshot) driver;
	//	File sourceFile = screenShot.getScreenshotAs(OutputType.FILE);
		TakesScreenshot screenShot = (TakesScreenshot) DriverFactory.getDriver();
		File sourceFile = screenShot.getScreenshotAs(OutputType.FILE);
		String targetFilePath = System.getProperty("user.dir") + "\\screenshots\\" + methodName + "_" + timeStamp + ".png";
	//	System.out.println("capturescreen targetpath "+targetFilePath);
		File targetFile = new File(targetFilePath);
		sourceFile.renameTo(targetFile);
		return targetFilePath;
	}
	
	public static String getScreenshot(String methodName) {
//		File srcFile = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.FILE);// temp dir
		File srcFile = ((TakesScreenshot) DriverFactory.getDriver()).getScreenshotAs(OutputType.FILE);// temp dir
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

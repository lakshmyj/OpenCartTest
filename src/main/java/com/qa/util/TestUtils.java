package com.qa.util;

import java.time.Duration;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestUtils {

	public static long PAGE_LOAD_TIMEOUT = 15;
	public static long IMPLICIT_WAIT_DURATION = 10;
	 
	//Wait for page to load completely
	public static void waitForPageToLoad(WebDriver driver, int timeoutInSeconds) {
	    new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(
	        webDriver -> ((JavascriptExecutor) webDriver)
	            .executeScript("return document.readyState").equals("complete"));
	}
	
	//Wait for page to get laoded and then get title
	public static String waitForPageLoadAndGetTitle(WebDriver driver, int timeoutInSeconds) {
	    new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds)).until(
	        webDriver -> ((JavascriptExecutor) webDriver)
	            .executeScript("return document.readyState").equals("complete")
	    );
	    return driver.getTitle();
	}
}

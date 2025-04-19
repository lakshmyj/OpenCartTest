package com.qa.util;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import com.qa.base.BaseClass;

public class MySeleniumListener extends BaseClass implements WebDriverListener{
 
	public void beforeFindElement(WebDriver driver, By locator) {
		System.out.println("Finding element "+locator.toString());
	}

	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
		System.out.println("Found element "+locator.toString());
	}

	public void beforeFindElements(WebDriver driver, By locator) {
		System.out.println("Finding elements "+locator.toString());
	}

	public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
		System.out.println("Found elements "+locator.toString());
	}

	public void beforeClose(WebDriver driver) {
		System.out.println("Closing driver");
	}
	
	public void afterClose(WebDriver driver) {
		System.out.println("Closed driver");
	}
	
	public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
		System.out.println("Sending keys "+keysToSend.toString()+" to element: "+element.toString());
	}

	public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
		System.out.println("Sent keys "+keysToSend.toString()+" to element: "+element.toString());
	}

	public void beforeTo(WebDriver.Navigation navigation, String url) {
		System.out.println("Navigating to '"+url+"'");; 
	}
	
    public void afterTo(WebDriver.Navigation navigation, String url) {
		System.out.println("Navigated to '"+url+"'");
	}
    
    public void beforeBack(WebDriver.Navigation navigation) {
		System.out.println("Navigating back to previous page");
	}
	
	public void afterBack(WebDriver.Navigation navigation) {
		System.out.println("Navigated back to previous page");
	}
 
	public void beforeForward(WebDriver.Navigation navigation) {
		System.out.println("Navigating forward to next page");
	}
	
	public void afterForward(WebDriver.Navigation navigation) {
		System.out.println("Navigated forward to next page");
	}
	
	public void beforeRefresh(WebDriver.Navigation navigation) {
		System.out.println("Refreshing Page");
	}
	
	public void afterRefresh(WebDriver.Navigation navigation) {
		System.out.println("Refreshed Page");
	}
	
	public void beforeAccept(Alert alert) {
		System.out.println("Accepting alert");
	}

	public void afterAccept(Alert alert) {
		System.out.println("Accepted alert");
	}

	public void beforeDismiss(Alert alert) {
		System.out.println("Dismissing alert");
	}

	public void afterDismiss(Alert alert) {
		System.out.println("Dismissed alert");
	} 
	
    public void beforeClick(WebElement element) {
        System.out.println("Trying to click on: " + element);
    }

    public void onError(Object target, Throwable error) {
        System.out.println("Exception: " + error.getMessage());
    }
	 
	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Value of the "+element.toString()+" before any chagnes made");
	}
	
	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		System.out.println("Element value changed to "+element.toString());
	}
	
	public void beforeClickOn(WebElement element, WebDriver driver) {
		System.out.println("Trying to click on "+element.toString());
	}
	
	public void afterClickOn(WebElement element, WebDriver driver) {
		System.out.println("Clicked on "+element.toString());
	}
	
	public void onException(Throwable error, WebDriver driver) {
		System.out.println("Exception occured "+error);
		try
		{
			TestUtils.takeScreenAtEndOfTest(driver,error.toString());
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
}

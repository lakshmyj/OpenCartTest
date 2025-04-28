package com.qa.util;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;

import com.qa.extentreport.ExtentReportListener;

//public class MySeleniumListener extends BasePage implements WebDriverListener {
public class MySeleniumListener implements WebDriverListener {
	private static Logger logger = LogManager.getLogger(MySeleniumListener.class);

	public void beforeFindElement(WebDriver driver, By locator) {
		//System.out.println("Finding element " + locator.toString());
		logger.info("Finding element " + locator.toString());
		ExtentReportListener.getExtentTest().info("Finding element " + locator.toString());
	}

	public void afterFindElement(WebDriver driver, By locator, WebElement result) {
		//System.out.println("Found element " + locator.toString());
		logger.info("Found element "+elementDescription(result)+" "+locator.toString());
		ExtentReportListener.getExtentTest().info("Found element "+elementDescription(result)+" "+locator.toString());
	}

	public void beforeFindElements(WebDriver driver, By locator) {
		//System.out.println("Finding elements " + locator.toString());
		logger.info("Finding elements " + locator.toString());
		ExtentReportListener.getExtentTest().info("Finding elements " + locator.toString());
	}

	public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
		//System.out.println("Found elements " + locator.toString());
		logger.info("Found elements " + locator.toString());
		ExtentReportListener.getExtentTest().info("Found elements " + locator.toString());
	}

	public void beforeClose(WebDriver driver) {
		//System.out.println("Closing driver");
		logger.info("Closing driver");
		ExtentReportListener.getExtentTest().info("Closing driver");
	}

	public void afterClose(WebDriver driver) {
		//System.out.println("Closed driver");
		logger.info("Closed driver");
		ExtentReportListener.getExtentTest().info("Closed driver");
	}

	public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
		//System.out.println("Sending keys " + keysToSend.toString() + " to element: "+elementDescription(element)+" "+ element.toString());
		logger.info("Sending keys " + keysToSend.toString() + " to element: "+elementDescription(element)+" "+ element.toString());
		ExtentReportListener.getExtentTest().info("Sending keys " + keysToSend.toString() + " to element: "+elementDescription(element)+" "+ element.toString());
	}

	public void afterSendKeys(WebElement element, CharSequence... keysToSend) {
		//System.out.println("Sent keys " + keysToSend.toString() + " to element: "+elementDescription(element)+" "+ element.toString());
		logger.info("Sent keys " + keysToSend.toString() + " to element: "+elementDescription(element)+" "+ element.toString());
		ExtentReportListener.getExtentTest().info("Sent keys " + keysToSend.toString() + " to element: "+elementDescription(element)+" "+ element.toString());
	}

	public void beforeTo(WebDriver.Navigation navigation, String url) {
		//System.out.println("Navigating to '" + url + "'");
		logger.info("Navigating to '" + url + "'");
		ExtentReportListener.getExtentTest().info("Navigating to '" + url + "'");
	}

	public void afterTo(WebDriver.Navigation navigation, String url) {
		//System.out.println("Navigated to '" + url + "'");
		logger.info("Navigated to '" + url + "'");
		ExtentReportListener.getExtentTest().info("Navigated to '" + url + "'");
	}

	public void beforeBack(WebDriver.Navigation navigation) {
		//System.out.println("Navigating back to previous page");
		logger.info("Navigating back to previous page");
		ExtentReportListener.getExtentTest().info("Navigating back to previous page");
	}

	public void afterBack(WebDriver.Navigation navigation) {
		//System.out.println("Navigated back to previous page");
		logger.info("Navigated back to previous page");
		ExtentReportListener.getExtentTest().info("Navigated back to previous page");
	}

	public void beforeForward(WebDriver.Navigation navigation) {
		//System.out.println("Navigating forward to next page");
		logger.info("Navigating forward to next page");
		ExtentReportListener.getExtentTest().info("Navigating forward to next page");
	}

	public void afterForward(WebDriver.Navigation navigation) {
		//System.out.println("Navigated forward to next page");
		logger.info("Navigated forward to next page");
		ExtentReportListener.getExtentTest().info("Navigated forward to next page");
	}

	public void beforeRefresh(WebDriver.Navigation navigation) {
		//System.out.println("Refreshing Page");
		logger.info("Refreshing Page");
		ExtentReportListener.getExtentTest().info("Refreshing Page");
	}

	public void afterRefresh(WebDriver.Navigation navigation) {
		//System.out.println("Refreshed Page");
		logger.info("Refreshed Page");
		ExtentReportListener.getExtentTest().info("Refreshed Page");
	}

	public void beforeAccept(Alert alert) {
		//System.out.println("Accepting alert");
		logger.info("Accepting alert");
		ExtentReportListener.getExtentTest().info("Accepting alert");
	}

	public void afterAccept(Alert alert) {
		//System.out.println("Accepted alert");
		logger.info("Accepted alert");
		ExtentReportListener.getExtentTest().info("Accepted alert");
	}

	public void beforeDismiss(Alert alert) {
		//System.out.println("Dismissing alert");
		logger.info("Dismissing alert");
		ExtentReportListener.getExtentTest().info("Dismissing alert");
	}

	public void afterDismiss(Alert alert) {
		//System.out.println("Dismissed alert");
		logger.info("Dismissed alert");
		ExtentReportListener.getExtentTest().info("Dismissed alert");
	}

	public void beforeClick(WebElement element) {
		//System.out.println("Trying to click on: " + elementDescription(element));
		logger.info("Trying to click on: " + element);
		ExtentReportListener.getExtentTest().info("Trying to click on: " + element);
	}

	public void beforeChangeValueOf(WebElement element, WebDriver driver) {
		//System.out.println("Value of the " + elementDescription(element) +" "+ element.toString() + " before any chagnes made");
		logger.info("Value of the " + elementDescription(element) +" "+ element.toString() + " before any chagnes made");
		ExtentReportListener.getExtentTest().info("Value of the " + elementDescription(element) +" "+ element.toString() + " before any chagnes made");
	}

	public void afterChangeValueOf(WebElement element, WebDriver driver) {
		//System.out.println("Element value changed to " + elementDescription(element) +" "+ element.toString());
		logger.info("Element value changed to " + elementDescription(element) +" "+ element.toString());
		ExtentReportListener.getExtentTest().info("Element value changed to " + elementDescription(element) +" "+ element.toString());
	}

	public void beforeClickOn(WebElement element, WebDriver driver) {
		//System.out.println("Trying to click on " + elementDescription(element) +" "+element.toString());
		logger.info("Trying to click on " + elementDescription(element) +" "+element.toString());
		ExtentReportListener.getExtentTest().info("Trying to click on " + elementDescription(element) +" "+element.toString());
	}

	public void afterClickOn(WebElement element, WebDriver driver) {
		//System.out.println("Clicked on " + elementDescription(element) +" "+element.toString());
		logger.info("Clicked on " + elementDescription(element) +" "+element.toString());
		ExtentReportListener.getExtentTest().info("Clicked on " + elementDescription(element) +" "+element.toString());
	}

	public void onError(Object target, Throwable error) {
		//System.out.println("Exception: " + error.getMessage());
		logger.error("Exception: " + error.getMessage());
		ExtentReportListener.getExtentTest().fail("Exception: " + error.getMessage());
	}

	public void onException(Throwable error, WebDriver driver) {
		//System.out.println("Exception occured " + error);
		logger.error("Exception occured " + error);
		ExtentReportListener.getExtentTest().fail("Exception occured " + error);
//		try {
//			//TestUtils.takeScreenShot(driver, error.toString());
//			TestUtils.getScreenshot(error.toString());
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
	}
	
	private String elementDescription(WebElement element) {
        try {
            return element.getTagName() + " - " + element.getText();
        } catch (Exception e) {
            return "Unknown element";
        }
    }

}

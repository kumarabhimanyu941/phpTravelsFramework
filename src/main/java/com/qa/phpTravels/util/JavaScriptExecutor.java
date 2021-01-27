package com.qa.phpTravels.util;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutor {

	WebDriver driver;

	public void JavaScriptExecutor(WebDriver driver) {
		this.driver = driver;
	}

	/**
	 * getElement method
	 * 
	 * @param driver
	 * @param locator
	 * @return
	 */
	public static WebElement getElement(WebDriver driver, By locator) {

		WebElement element = null;

		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Unable to locate element :" + locator);
		}
		return element;

	}
	
	/**
	 * This method will click on the WebElement using JavaScriptExecutor
	 * 
	 * @param driver
	 * @param loginBtn2
	 */
	public static void performClickByJS(WebDriver driver, By locator) {
		WebElement element = getElement(driver, locator);
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("arguments[0].click();", element);
	}

	/**
	 * This method will do a sendkeys for an element located by ID using
	 * Javascript
	 * 
	 * @param driver
	 * @param id
	 * @param value
	 */
	public static void doSendKeysforIDUsingJS(WebDriver driver, String id, String value) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('" + id + "').value='" + value + "'");
	}

	/**
	 * This method will do a sendkeys for an element located by ID using
	 * Javascript
	 * 
	 * @param driver
	 * @param id
	 * @param value
	 */
	public static void doSendKeysforNameUsingJS(WebDriver driver, String name, String value) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.getElementById('" + name + "').value='" + value + "'");
	}

	/**
	 * This method will do a browser refresh using JS
	 * 
	 * @param driver
	 */
	public static void doBrowserRefreshUsingJS(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("history.go(0);");

	}

	/**
	 * This method will get the browser info using JS
	 * 
	 * @param driver
	 */

	public static String getBrowserInfoUsingJS(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		return jse.executeScript("return navigator.userAgent;").toString();
	}

	public static String getPageTitleUsingJS(WebDriver driver) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		return jse.executeScript("return document.Title;").toString();

	}

}

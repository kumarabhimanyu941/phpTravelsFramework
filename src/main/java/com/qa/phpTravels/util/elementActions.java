package com.qa.phpTravels.util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class elementActions {

	public WebDriver driver;
	WebDriverWait wait;
	Actions action;
	Select select;

	public elementActions(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, AppConstants.WebDriver_Wait_TimeOut);
		action = new Actions(driver);

	}

	// Generic functions

	/**
	 * This method will fetch an element located by the given locator
	 * 
	 * @param locator
	 * @param value
	 */

	public WebElement getElement(By locator) {
		WebElement element = null;
		try {
			element = driver.findElement(locator);
		} catch (Exception e) {
			System.out.println("Error occurred while creating the element : " + locator);
		}
		return element;
	}

	/**
	 * This method will perform click on the element located by the locator
	 * 
	 * @param locator
	 * @param value
	 */
	public void doClick(By locator) {
		getElement(locator).click();
	}

	/**
	 * This method will perform sendkeys on the element located by the locator
	 * 
	 * @param locator
	 * @param value
	 */
	public void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}

	/**
	 * This method will wait till the element is present on the page
	 * 
	 * @param locator
	 */
	public void waitTillElementPresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}

	/**
	 * This method will wait till the element is visible on the page
	 * 
	 * @param locator
	 */
	public void waitTillElementVisible(By locator) {
		WebElement ele = getElement(locator);
		wait.until(ExpectedConditions.visibilityOf(ele));
	}

	/**
	 * This method will fetch the title of the page
	 * 
	 * @return title
	 * 
	 */
	public String doGetTitle(String title) {
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}

	/**
	 * This method will fetch the text of the element found using the locator
	 * 
	 * @param locator
	 * @return
	 */
	public String performGetText(By locator) {
		return getElement(locator).getText();
	}

	/**
	 * This method will check if and return if the element is dislapyed on the
	 * page or not
	 * 
	 * @param locator
	 * @return
	 */
	public boolean checkIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();

	}

	/**
	 * This method will clear the text from the field located by the mentioned
	 * locator
	 * 
	 * @param locator
	 */
	public void performClearText(By locator) {
		driver.findElement(locator).clear();
	}

	/**
	 * This method will perform a click on the web element using the Actions
	 * class
	 * 
	 * @param locator
	 */
	public void performActionsClick(By locator) {
		action.click(getElement(locator)).build().perform();
	}

	/**
	 * This method will perform send keys for the web element using the actions
	 * class
	 * 
	 * @param locator
	 * @param value
	 */
	public void performActionsSendKeys(By locator, String value) {
		action.sendKeys(getElement(locator), value);
	}

	/**
	 * This method will move the driver focus to the element specified by the
	 * locator
	 * 
	 * @param locator
	 */
	public void performMoveToElement(By locator) {
		action.moveToElement(getElement(locator));
	}

	/**
	 * This method will perform a drag and drop from element1 to element2
	 * 
	 * @param locator1
	 * @param locator2
	 */
	public void performdragAndDrop(By locator1, By locator2) {
		action.dragAndDrop(getElement(locator1), getElement(locator2));
	}

	/**
	 * This method will select the value from drop down based on visible text
	 * 
	 * @param locator
	 * @param value
	 */
	public void selectByVisibleText(By locator, String visibletext) {
		select = new Select(getElement(locator));
		select.selectByVisibleText(visibletext);
	}

	/**
	 * This method will select the value from drop down based on index
	 * 
	 * @param locator
	 * @param value
	 */
	public void selectByIndex(By locator, int index) {
		select = new Select(getElement(locator));
		select.selectByIndex(index);
	}

	/**
	 * This method will select the value from drop down based on value
	 * 
	 * @param locator
	 * @param value
	 */
	public void selectByValue(By locator, String value) {
		select = new Select(getElement(locator));
		select.selectByValue(value);
	}

}

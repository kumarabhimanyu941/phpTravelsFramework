package com.qa.phpTravels.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.qa.phpTravels.util.elementActions;

public class RegisterPage {

	WebDriver driver;
	elementActions elementActions;

	// 1)By Locators

	By inputfirstName = By.xpath("//input[@id='inputFirstName']");
	By inputlastName = By.xpath("//input[@id='inputLastName']");
	By inputEmail = By.xpath("//input[@id='inputEmail']");
	By inputPhone = By.xpath("//input[@id='inputPhone']");

	// 2)Constructor of the class

	public void RegisterPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new elementActions(driver);

	}

	// 3) Page Actions

	public void PerformFillRegisterForm() {
		elementActions.waitTillElementPresent(inputfirstName);
		//elementActions.performClearText(inputfirstName);
		elementActions.doSendKeys(inputfirstName, "firstname");

		//elementActions.performClearText(inputlastName);
		elementActions.doSendKeys(inputlastName, "LastName");
		//elementActions.performClearText(inputEmail);
		elementActions.doSendKeys(inputEmail, "test@gmail.com");
		//elementActions.performClearText(inputPhone);
		elementActions.doSendKeys(inputPhone, "9876545678");
	}

}


package com.qa.phpTravels.Pages;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

import com.qa.phpTravels.Base.basePage;
import com.qa.phpTravels.util.AppConstants;
import com.qa.phpTravels.util.elementActions;

public class loginPage {

	public WebDriver driver;
	public elementActions elementActions;

	// 1.By Locators

	By username = By.xpath("//input[@id='inputEmail']");
	By password = By.xpath("//input[@id='inputPassword']");
	By viewCartBtn = By.cssSelector("li.primary-action");
	By loginBtn = By.xpath("//input[@id='login']");
	By forgotPwd = By.xpath("//a[text()='Forgot Password?']");
	By loginSuccessMsg = By.xpath("//div[@class='header-lined']/h1");
	By captchaCheckBox = By.cssSelector(".recaptcha-checkbox-borderAnimation");
	By loginErrorMsg = By.cssSelector(".alert.alert-danger.text-center");
	By registerButton = By.xpath("//a[text()='Register']");
	By registerPageMsg = By.xpath("//small[text()='Create an account with us . . .']");
	// 2.Login Page Constructor

	public loginPage(WebDriver driver) {
		this.driver = driver;
		elementActions = new elementActions(driver);
	}

	// 3.Page Actions

	/**
	 * This method will fetch the current title of the page
	 * 
	 * @return will return the current title of the page
	 */
	public String getPageTitle() {
		return elementActions.doGetTitle(AppConstants.Login_Page_Title);
	}

	/**
	 * This method will verify the login text
	 * 
	 * @return will return true or false based on whether the loginText is
	 *         displayed or not
	 */
	public boolean viewCartBtn() {
		elementActions.waitTillElementPresent(viewCartBtn);
		return elementActions.checkIsDisplayed(viewCartBtn);
	}

	/**
	 * This method will verify if the forgot pwd link is displayed or not
	 * 
	 * @return boolean based on whether the forgot pwd link is displayed or not
	 */
	public boolean verifyforgotPwd() {
		elementActions.waitTillElementPresent(forgotPwd);
		return elementActions.checkIsDisplayed(forgotPwd);
	}

	/**
	 * This method will login to the application.It will take below two
	 * parameters
	 * 
	 * @param uname
	 * @param pwd
	 */

	public homePage login(String uname, String pwd) {
		elementActions.performClearText(username);
		elementActions.doSendKeys(username, uname);
		elementActions.performClearText(password);
		elementActions.doSendKeys(password, pwd);
		elementActions.doClick(loginBtn);

		return new homePage();
	}

	/**
	 * This method will return the message for successfull login
	 * 
	 * @return
	 */
	public String getLoginSuccessMsg() {
		elementActions.waitTillElementVisible(loginSuccessMsg);
		return elementActions.performGetText(loginSuccessMsg);
	}

	/**
	 * this method will fetch the login error message and display true or false
	 * based on if it is displayed or not
	 * 
	 * @return
	 */
	public boolean isLoginErrorMsgDisplayed() {
		elementActions.waitTillElementPresent(loginErrorMsg);
		return elementActions.checkIsDisplayed(loginErrorMsg);
	}

	/**
	 * This method will navigate to register page by clicking on register button
	 * 
	 * @return
	 */

	public RegisterPage navigateToRegisterPage() {
		elementActions.waitTillElementPresent(registerButton);
		elementActions.doClick(registerButton);

		return new RegisterPage();

	}

	/**
	 * This method will navigate to register page by clicking on register button
	 * 
	 * @return String register page message
	 */
	public String verifyRegisterPageMessage() {
		return elementActions.performGetText(registerPageMsg);

	}

}

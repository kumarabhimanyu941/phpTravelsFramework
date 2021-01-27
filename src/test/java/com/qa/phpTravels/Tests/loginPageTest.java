package com.qa.phpTravels.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.qa.phpTravels.Base.basePage;
import com.qa.phpTravels.Pages.homePage;
import com.qa.phpTravels.Pages.loginPage;
import com.qa.phpTravels.util.AppConstants;

public class loginPageTest {

	public basePage basepage;
	public Properties prop;
	public WebDriver driver;
	public loginPage loginpage;
	public homePage homepage;

	@BeforeTest
	// @Parameters("browser")
	public void setUp() {
		basepage = new basePage();

		prop = basepage.init_Prop();
		driver = basepage.init_driver(prop);
		loginpage = new loginPage(driver);

	}

	@Test(priority = 1)
	public void verifyTitleTest() {
		String title = loginpage.getPageTitle();
		Assert.assertTrue(title.contains(AppConstants.Login_Page_Title));
	}

	@Test(priority = 2)
	public void verifyViewCartBtnTest() {
		Assert.assertTrue(loginpage.viewCartBtn());
	}

	@Test(priority = 3)
	public void forgotPwdTest() {
		Assert.assertTrue(loginpage.verifyforgotPwd());
	}

	@Test(priority = 4)
	public void loginTest() {
		homepage = loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
		String loginMsg = loginpage.getLoginSuccessMsg();
		Assert.assertEquals(loginMsg, AppConstants.Home_Page_Message);

	}

	@DataProvider
	public Object[][] getInvalidLoginCredentials() {
		Object[][] data = {

				{ "test@gmail.com", "Password1" }, { "test@gmail.com1", "Password2" }, { "test@gmail.com", "" },
				{ "", "Password1" }

		};
		return data;
	}

	@Test(priority = 5, dataProvider = "getInvalidLoginCredentials", enabled = false)
	public void negativeLoginTest(String username, String password) {
		loginpage.login(username, password);
		Assert.assertTrue(loginpage.isLoginErrorMsgDisplayed());

	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}

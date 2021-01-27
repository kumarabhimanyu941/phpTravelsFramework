package com.qa.phpTravels.Tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.phpTravels.Base.basePage;
import com.qa.phpTravels.Pages.RegisterPage;
import com.qa.phpTravels.Pages.loginPage;
import com.qa.phpTravels.util.AppConstants;
import com.qa.phpTravels.util.excelUtil;

public class RegisterPageTest {

	basePage basepage;
	loginPage loginpage;
	RegisterPage registerpage;
	WebDriver driver;
	Properties prop;

	@BeforeTest
	public void setUp() {
		basepage = new basePage();
		prop = basepage.init_Prop();
		driver = basepage.init_driver(prop);
		loginpage = new loginPage(driver);

		registerpage=loginpage.navigateToRegisterPage();

	}

	@Test(priority = 1)
	public void performnavigateToRegisterPage() {
		String message = loginpage.verifyRegisterPageMessage();
		Assert.assertEquals(message, AppConstants.Register_Page_Message);

	}

	@DataProvider
	public Object[][] getRegisterData(){
		return excelUtil.getTestData(AppConstants.Register_Page_Sheet_Name);
		
	}
	
	
	@Test(priority = 2,dataProvider="getRegisterData")
	public void fillRegistrationDetails(String firstName,String lastName,String email,String phone ) {
		registerpage.PerformFillRegisterForm();
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}

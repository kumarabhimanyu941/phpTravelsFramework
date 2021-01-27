package com.qa.phpTravels.Base;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class basePage {

	public Properties prop;
	public WebDriver driver;

	/**
	 * This method will initialize and load the properties from the
	 * config.properties file
	 * 
	 * @return
	 */
	public Properties init_Prop() {
		prop = new Properties();

		try {
			FileInputStream ip = new FileInputStream("./src/main/java/com//qa/phpTravels/config/config.properties");
			prop.load(ip);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Config file not found");
		}

		return prop;

	}

	public WebDriver init_driver(Properties prop) {

		String browser = prop.getProperty("browser");
		Boolean headless = Boolean.parseBoolean(prop.getProperty("headless"));

		if (browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();

			if (headless) {
				ChromeOptions co = new ChromeOptions();
				driver = new ChromeDriver(co);
			} else {
				driver = new ChromeDriver();
			}

		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();

			if (headless) {
				FirefoxOptions fo = new FirefoxOptions();
				driver = new FirefoxDriver(fo);
			} else {
				driver = new FirefoxDriver();
			}
		}

		else {
			System.out.println(browser + "not found.Please enter correct browser");
		}

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(prop.getProperty("appUrl"));

		return driver;

	}

	public String getScreenshot() {
		File source = ((TakesScreenshot) init_driver(prop)).getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png";
		File destination = new File(path);

		try {
			FileUtils.copyFile(source, destination);
		} catch (Exception e) {
			System.out.println("Some error occurred while taking and copying screenshot");
			e.printStackTrace();
		}

		return path;
	}

}

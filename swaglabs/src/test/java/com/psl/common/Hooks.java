package com.psl.common;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks extends BasePage {
	
	@Before // Cucumber Before Hook
	public static void setupDriver(Scenario senario) {
		BasePage.driver = BrowserFactory.openBrowser(Constants.browserName);
//        driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("https://www.saucedemo.com/");
	}
	
	@After // Cucumber After hook
	public static void quitDriver() throws Exception {
		BasePage.driver.quit();
	}

	@AfterStep
	public void addScreenshot(Scenario scenario) {
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(screenshot, "image/png", "image");
	}
}

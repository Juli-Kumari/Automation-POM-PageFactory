package com.psl.common;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;

public class BasePage extends PageFactory {

	public static WebDriver driver;

	static PropertiesDataProvider config = new PropertiesDataProvider("config");

	public static PropertiesDataProvider getConfigProvider() {
		return config;
	}
	// generic methods

	// verify the web element is displayed or not
	public void verifyWebElementIsDisplayed(WebElement element) {
		try {
			WaitUtils.waitForElement(element, 10);
			element.isDisplayed();
		} catch (NoSuchElementException | ElementNotInteractableException e) {
			System.out.println("Exception Caught while displaying element: " + e.getMessage());
		}

	}

	// send keys action on text field
	public void sendKeysWebElements(WebElement element, String text) {
		try {
			WaitUtils.waitForElement(element, 10);
			element.clear();
			element.sendKeys(text);
		} catch (NoSuchElementException | ElementNotInteractableException e) {
			System.out.println("Error while sending the text: " + e.getMessage());
		}

	}

	// click on web element
	public void clickOnWebElement(WebElement element) {
		try {
			WaitUtils.waitForElement(element, 30);
			element.click();
		} catch (NoSuchElementException | ElementNotInteractableException e) {
			System.out.println("Exception Caught while click on the web element: " + e.getMessage());
		}
	}

	// getting the text from the web element
	public String getTextFromWebElement(WebElement element) {
		return element.getText();
	}

	// method for selecting the dropdoen list
	public void selectByVisibleText(WebElement element, String optionText) {
		try {
			Select select = new Select(element);
			select.selectByVisibleText(optionText);
		} catch (NoSuchElementException | ElementNotInteractableException e) {
			System.out.println("Error selecting dropdown option: " + e.getMessage());
		}

	}

	// mouse hover and click
	public void mouseHoverAndClickOnElement(WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).click().build().perform();
	}

	// return list of web elements from the selector
	public List<WebElement> findElements(By selector) {
		return driver.findElements(selector);
	}

	public boolean webElementNotPresent(WebElement elementName, long waitTimeSeconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(waitTimeSeconds));
		Boolean element = wait.until(ExpectedConditions.invisibilityOf(elementName));
		return element;
	}

	public boolean enabledWebElement(WebElement element) {
		boolean bool = element.isEnabled();
		return bool;
	}

	public static String getBrowserDetails() {
		Capabilities cap = ((RemoteWebDriver) driver).getCapabilities();
		String browserName = cap.getBrowserName().toLowerCase();
		String os =cap.getPlatformName().toString();
		String v = cap.getBrowserVersion().toString();
		return "Browser: "+browserName + "\nOperating System: "+os +"\nBrowser Version: "+v ;
	}
}

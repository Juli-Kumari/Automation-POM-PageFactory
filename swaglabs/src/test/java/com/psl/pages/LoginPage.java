package com.psl.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.testng.Assert;

import com.psl.common.BasePage;

public class LoginPage extends BasePage {

	// constructor
	public LoginPage() {
		// all objects on this page get initialiszed
		PageFactory.initElements(driver, this);
	}

	// page locator
	@FindBy(how = How.XPATH, using = "//*[@class=\"login_logo\"]")
	@CacheLookup
	WebElement logo;
	@FindBy(how = How.XPATH, using = "//input[@id=\"user-name\"]")
	@CacheLookup
	WebElement user_name;
	@FindBy(how = How.XPATH, using = "//input[@id=\"password\"]")
	@CacheLookup
	WebElement pass_word;
	@FindBy(how = How.XPATH, using = "//input[@id=\"login-button\"]")
	@CacheLookup
	WebElement login_button;
	@FindBy(how = How.XPATH, using = "//*[@class=\"app_logo\"]")
	WebElement page_title;
	@FindBy(how = How.XPATH, using = "//*[@data-test = \"error\"]")
	@CacheLookup
	WebElement error_message;

	// open login page
	public void openLoginPage() {
		BasePage.driver.get("https://www.saucedemo.com/");
	}
	
	// page actions
	public void logoIsDisplayed() {
		verifyWebElementIsDisplayed(logo);
	}

	public void enterUsername(String username) {
		sendKeysWebElements(user_name, username);
	}

	public void enterPassword(String password) {
		sendKeysWebElements(pass_word, password);
	}

	public void clickOnLoginButton() {
		clickOnWebElement(login_button);
	}

	public void pageTitleIsDisplayed(String title) {
		Assert.assertEquals(getTextFromWebElement(page_title), title);
	}

	public void errorMessageIsDisplayed(String errorMessage) {
		Assert.assertEquals(getTextFromWebElement(error_message), errorMessage);
	}

//	public By logoLocator = By.xpath("//*[@class=\"login_logo\"]");
//	public By userNameLocator = By.xpath("//input[@id=\"user-name\"]");
//	public By passwordLocator = By.xpath("//input[@id=\"password\"]");
//	public By loginButtonLocator = By.xpath("//input[@id=\"login-button\"]");
//	public By pageTitleLocator = By.xpath("//*[@class=\"app_logo\"]");
//	public By errorMessageLocator = By.xpath("//*[@data-test = \"error\"]");
//	
//	public void logoIsDisplayed() {
//		driver.findElement(logoLocator).isDisplayed();
//	}
//	
//	public void enterUsername(String username) {
//		driver.findElement(userNameLocator).sendKeys(username);
//	}
//	
//	public void enterPassword(String password) {
//		driver.findElement(passwordLocator).sendKeys(password);
//	}
//	
//	public void clickOnLoginButton() {
//		driver.findElement(loginButtonLocator).click();
//	}
//	
//	public boolean pageTitleIsDisplayed() {
//		
//     return driver.findElement(pageTitleLocator).isDisplayed();
//		
//	}
//	
//	public String errorMessageIsDisplayed() {
//		return driver.findElement(errorMessageLocator).getText();
//	}
//
}

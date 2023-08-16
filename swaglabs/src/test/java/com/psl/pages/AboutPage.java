package com.psl.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.psl.common.BasePage;
import com.psl.common.WaitUtils;

public class AboutPage extends BasePage {

	public AboutPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//*[@class= \"MuiBox-root css-1x2l18i\"]//a//span")
	WebElement pricingTab;
	@FindBy(xpath  = "//*[@class='MuiTypography-root MuiTypography-label css-1ojx2zp']")
	WebElement pricingText;
	@FindBy(xpath  = "//button[normalize-space()='Sign in']")
	WebElement signInButton;
	@FindBy(className  = "login__title")
	WebElement signInPage;
	@FindBy(xpath  = "//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeLarge css-1dyvkz7']//img[@alt='search']")
	WebElement searchButton;
	@FindBy(id  = "search")
	WebElement searchInputField;
	@FindBy(xpath  = "//mark[@class='ais-Snippet-highlighted'][text()='Selenium']")
	WebElement seleniumResult;
	@FindBy(xpath  = "//*[@id=\"__next\"]/header/div/div/div[2]/div/button/div/span/img")
	WebElement closeButton;
	@FindBy(xpath  = "//span[normalize-space()='Topic Hub']")
	WebElement aboutPage;
	
	
	public void clickOnPricing() {
		clickOnWebElement(pricingTab);
	}
	public void displayedPricingPage() {
		WaitUtils.waitForElement(pricingText, 80);
		Assert.assertEquals(getTextFromWebElement(pricingText), "PRICING PLANS");
	}
	public void clickOnSignInButton() {
		clickOnWebElement(signInButton);
	}
	public void navigateToSignInPage() {
		WaitUtils.waitForElement(signInPage, 60);
		Assert.assertEquals(getTextFromWebElement(signInPage), "Sign in");
	}
	public void clickOnSearchButton() {
		WaitUtils.waitForElement(searchButton, 60);
		clickOnWebElement(searchButton);
	}
	public void enterTextOnSearchFiled(String text) {
		
		sendKeysWebElements(searchInputField, text);
	}
	public void result() {
		verifyWebElementIsDisplayed(searchInputField);
	}
	public void clickOnCloseButton() {
		clickOnWebElement(closeButton);
	}
	public void redirectToAboutPage() {
		Assert.assertEquals(getTextFromWebElement(aboutPage), "Topic Hub");
	}
}

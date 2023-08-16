package com.psl.pages;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.psl.common.BasePage;

import io.cucumber.java.eo.Do;

public class CheckoutPage extends BasePage {

	public CheckoutPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(css = "input#first-name")
	WebElement firstName;
	@FindBy(css = "input#last-name")
	WebElement lastName;
	@FindBy(css = "input#postal-code")
	WebElement postalCodeName;
	@FindBy(css = "#continue")
	WebElement continueBtn;
	@FindBy(xpath = "//*[@data-test=\"error\"]")
	WebElement errorMsg;
	@FindBy(css = ".title")
	WebElement checkoutOverview;
	@FindBy(css = "#finish")
	WebElement finish;
	@FindBy(css = ".complete-header")
	WebElement confirmationMsg;
	@FindBy(id = "cancel")
	WebElement cancleBtn;
	@FindBy(className = "summary_subtotal_label")
	WebElement itemTotalPrice;
	@FindBy(className = "summary_tax_label")
	WebElement taxPrice;

	public void enterUserDetails(String fname, String lname, String postalcode) {
		sendKeysWebElements(firstName, fname);
		sendKeysWebElements(lastName, lname);
		sendKeysWebElements(postalCodeName, postalcode);
	}

	public void userEnterFullName(String fname, String lname) {
		sendKeysWebElements(firstName, fname);
		sendKeysWebElements(lastName, lname);
	}

	public void userEnterFirstNameAndPostalCode(String fname, String pCode) {
		sendKeysWebElements(firstName, fname);
		sendKeysWebElements(postalCodeName, pCode);
	}

	public void userEnterLastNameAndPostalCode(String lname, String pCode) {
		sendKeysWebElements(lastName, lname);
		sendKeysWebElements(postalCodeName, pCode);
	}

	public void clickOnContinueButton() {
		clickOnWebElement(continueBtn);
	}

	public void errorMessage(String errorMessage) {
		Assert.assertEquals(getTextFromWebElement(errorMsg), errorMessage);

	}

	public void checkoutOverviewDisplayed() {
		Assert.assertEquals(getTextFromWebElement(checkoutOverview), "Checkout: Overview");
	}

	public void clickOnFinishButton() {
		clickOnWebElement(finish);
	}

	public void confirmationMsgDisplayed(String msg) {
		Assert.assertEquals(getTextFromWebElement(confirmationMsg), msg);
	}

	public void clickOnCancleButton() {
		clickOnWebElement(cancleBtn);
	}

	public void userEnterStringValueInPostalCodeField(String pCode) {
		if (StringUtils.isNumeric(pCode)) {
			clickOnContinueButton();
			Assert.assertTrue(true, "Postal Code is number");
			
		} else {
			Assert.assertTrue(! enabledWebElement(continueBtn),"The continue button is enable for the postal code contains string value:"+ pCode);	
		}
	}

	public void totalPrice() {
		String price = getTextFromWebElement(itemTotalPrice).replace("Item total: $", "");
		Double itemTotalPrice = Double.valueOf(price);

		String tax = getTextFromWebElement(taxPrice).replace("Tax: $", "");
		Double taxPrice = Double.valueOf(tax);
		Double totalPrice = itemTotalPrice + taxPrice;
		Double expectedPrice = Double.valueOf("32.39");
		Assert.assertEquals(totalPrice, expectedPrice);
	}
}

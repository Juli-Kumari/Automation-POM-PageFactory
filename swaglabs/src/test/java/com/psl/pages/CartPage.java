package com.psl.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.psl.common.BasePage;

public class CartPage extends BasePage {

	public CartPage() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css ="a#item_4_title_link" )
	WebElement productBagPackName;
	@FindBy(css ="a#item_0_title_link" )
	WebElement productBikeLightName;
	@FindBy(css ="button#checkout")
	WebElement checkout;
	@FindBy(className = "title")
	WebElement yourCartTitle;
	@FindBy(id = "continue-shopping")
	WebElement continueShopping;
	@FindBy(id = "remove-sauce-labs-backpack")
	WebElement removeProduct;
	@FindBy(className = "shopping_cart_badge")
	WebElement shopping_cart_badge;
	
	
	public void singleProductName() {
		Assert.assertEquals(getTextFromWebElement(productBagPackName), "Sauce Labs Backpack");
	}
	public void mutipleProductName() {
		Assert.assertEquals(getTextFromWebElement(productBagPackName), "Sauce Labs Backpack");
		Assert.assertEquals(getTextFromWebElement(productBikeLightName), "Sauce Labs Bike Light");
	}
	public void clickOnChcekoutButton() {
		clickOnWebElement(checkout);
	}
	public void displayCartPage() {
		Assert.assertEquals(getTextFromWebElement(yourCartTitle), "Your Cart");
	}
	public void clickOnremoveButton() {
		clickOnWebElement(removeProduct);
	}
	
	public void clickOncontinueShoppingButton() {
		clickOnWebElement(continueShopping);
	}
	public void productIsRemove() {
		webElementNotPresent(shopping_cart_badge, 10);
	}
	
}

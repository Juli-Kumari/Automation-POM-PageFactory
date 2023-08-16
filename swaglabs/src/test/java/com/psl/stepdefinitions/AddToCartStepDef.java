package com.psl.stepdefinitions;

import org.testng.Assert;

import com.psl.pages.CartPage;
import com.psl.pages.ProductPage;

import io.cucumber.java.en.*;

public class AddToCartStepDef {

	ProductPage productPage = new ProductPage();
	CartPage cartPage = new CartPage();

	@When("User click on add to cart button for one product")
	public void user_click_on_add_to_cart_button_for_one_product() {
	   productPage.clickOnAddToCartBtnForOneItem();
	}

	@Then("Confirm the cart updated item count to one")
	public void confirm_the_cart_updated_item_count_to_one() {
	   productPage.shoppingCartIncrementToOne();
	}

	@When("Click on shopping cart")
	public void click_on_shopping_cart() {
	   productPage.clickOnShoppingCartLink();
	}

	@Then("User see that one Product is added to the cart")
	public void user_see_that_one_product_is_added_to_the_cart() {
	    cartPage.singleProductName();
	}

	@When("User click on add to cart button for more than one product")
	public void user_click_on_add_to_cart_button_for_more_than_one_product() {
	   productPage.clickOnAddToCartBtnForMultipleItem();
	}

	@Then("Confirm the cart updated item count should increase")
	public void confirm_the_cart_updated_item_count_should_increase() {
		productPage.shoppingCartIncrementedToMoreThanOne();
	}

	@Then("User see that multiple product is added to the cart")
	public void user_see_that_multiple_product_is_added_to_the_cart() {
		cartPage.mutipleProductName();
	}
	@When("user click on remove button")
	public void user_click_on_remove_button() {
	    cartPage.clickOnremoveButton();
	}

	@Then("the product is remove")
	public void the_product_is_remove() {
	   cartPage.productIsRemove();
	}
	@When("user click on the continue shopping button")
	public void user_click_on_the_continue_shopping_button() {
	    cartPage.clickOncontinueShoppingButton();
	}


}

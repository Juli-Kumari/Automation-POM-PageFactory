package com.psl.stepdefinitions;

import org.testng.Assert;

import com.psl.common.BasePage;
import com.psl.pages.LoginPage;
import com.psl.pages.ProductPage;

import io.cucumber.java.en.*;

public class ProductsStepDef extends BasePage {
	LoginPage loginPage = new LoginPage();
	ProductPage productPage = new ProductPage();

	@And("User is logged in with username {string} and password {string}")
	public void user_is_logged_in_with_username_and_password(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
		loginPage.clickOnLoginButton();
	}

	@When("User on the products page")
	public void user_on_the_products_page() {
		productPage.productsPageIsDisplayed();
	}

	@Then("user see the products price should be present with a {string} sign")
	public void user_see_the_products_price_should_be_present_with_a_doller_sign(String dollerSign) {
		productPage.productsPricePresentInDollerSign(dollerSign);
	}

	@When("User click on sorting option by name in descending order")
	public void user_click_on_sorting_option_by_name_in_descending_order() {
		productPage.selectDropdownByNameInDescendingOrder();
	}

	@Then("user see the products are sorted by name in descending order")
	public void user_see_the_products_are_sorted_by_name_in_descending_order() {
		productPage.productsNameInDescendingOrder();
	}

	@When("User click on sorting option by name in ascending order")
	public void user_click_on_sorting_option_by_name_in_ascending_order() {
		productPage.selectDropdownByNameInAscendingOrder();
	}

	@Then("user see the products are sorted by name in ascending order")
	public void user_see_the_products_are_sorted_by_name_in_ascending_order() {
		productPage.selectDropdownByNameInAscendingOrder();
	}

	@When("User click on sorting option by price in ascending order")
	public void user_click_on_sorting_option_by_price_in_ascending_order() {
		productPage.selectDropdownByPriceInAscendingOrder();
	}

	@Then("user see the products are sorted by price in ascending order")
	public void user_see_the_products_are_sorted_by_price_in_ascending_order() {

		productPage.productsPriceInAscendingOrder();
	}

	@When("User click on sorting option by price in descending order")
	public void user_click_on_sorting_option_by_price_in_descending_order() {
		productPage.selectDropdownByPriceInDescendingOrder();
	}

	@Then("user see the products are sorted by price in descending order")
	public void user_see_the_products_are_sorted_by_price_in_descending_order() {
		productPage.productsPriceInDescendingOrder();
	}

}

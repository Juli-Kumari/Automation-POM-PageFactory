package com.psl.stepdefinitions;


import com.psl.pages.CartPage;
import com.psl.pages.CheckoutPage;
import com.psl.pages.ProductPage;

import io.cucumber.java.en.*;

public class CheckoutStepDef {

	CartPage cartPage = new CartPage();
	CheckoutPage checkoutPage = new CheckoutPage();
	ProductPage productPage = new ProductPage();

	@Then("Click on checkout")
	public void click_on_checkout() {
		cartPage.clickOnChcekoutButton();
	}

	@Then("user can see and enter the {string} {string} {string}")
	public void user_can_see_and_enter_the(String firstName, String lastName, String postalCode) {
		checkoutPage.enterUserDetails(firstName, lastName, postalCode);
	}

	@When("user enter the first name as {string} and postal code as {string}")
	public void user_enter_the_first_name_as_and_postal_code_as(String firstName, String postalCode) {
		checkoutPage.userEnterFirstNameAndPostalCode(firstName, postalCode);
	}

	@When("user enter the last name as {string} and postal code as {string}")
	public void user_enter_the_last_name_as_and_postal_code_as(String lastName, String postalCode) {
		checkoutPage.userEnterLastNameAndPostalCode(lastName, postalCode);
	}

	@When("user enter the {string} {string}")
	public void user_enter_the(String firstName, String lastName) {
		checkoutPage.userEnterFullName(firstName, lastName);
	}

	@And("user click on continue")
	public void user_click_on_continue() {
		checkoutPage.clickOnContinueButton();
	}

	@Then("user see the error message as {string}")
	public void user_see_the_error_message_as(String errorMsg) {
		checkoutPage.errorMessage(errorMsg);
	}

	@Then("user enter the {string} {string} {string}")
	public void user_enter_the(String firstName, String lastName, String postalCode) {
		checkoutPage.enterUserDetails(firstName, lastName, postalCode);
	}

	@Then("user can see the checkout overview")
	public void user_can_see_the_checkout_overview() {
		checkoutPage.checkoutOverviewDisplayed();
	}

	@When("user click on finish")
	public void user_click_on_finish() {
		checkoutPage.clickOnFinishButton();
	}

	@Then("user see the order confirmation message {string} should displayed")
	public void user_see_the_order_confirmation_message_should_displayed(String msg) {
		checkoutPage.confirmationMsgDisplayed(msg);
	}

	@Then("user should see the error message {string}")
	public void user_should_see_the_error_message(String msg) {
		checkoutPage.confirmationMsgDisplayed(msg);
	}

	@Then("user not able to see the continue button is enable with {string}")
	public void user_not_able_to_see_the_continue_button_is_enable_with(String pCode) {
		checkoutPage.userEnterStringValueInPostalCodeField(pCode);
	}

	@And("User is able to see the total price for the product")
	public void user_is_able_to_see_the_total_price_for_the_product() {
		checkoutPage.totalPrice();
	}

	@When("user click on cancle button in checkout-information page")
	public void user_click_on_cancle_button_in_checkout_information_page() {
		checkoutPage.clickOnCancleButton();
	}

	@Then("user redirect to the cart page again")
	public void user_redirect_to_the_cart_page_again() {
		cartPage.displayCartPage();
	}

	@When("user click on cancle button in checkout-overview page")
	public void user_click_on_cancle_button_in_checkout_overview_page() {
		checkoutPage.clickOnCancleButton();
	}

	@Then("user redirect to the product page again")
	public void user_redirect_to_the_product_page_again() {
		productPage.productsPageIsDisplayed();
	}
}

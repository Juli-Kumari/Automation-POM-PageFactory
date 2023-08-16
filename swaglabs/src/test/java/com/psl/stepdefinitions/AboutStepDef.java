package com.psl.stepdefinitions;

import com.psl.pages.AboutPage;

import io.cucumber.java.en.*;

public class AboutStepDef {
	
	AboutPage aboutPage = new AboutPage();
	
	@When("User click on pricing")
	public void user_click_on_pricing() {
	    aboutPage.clickOnPricing();
	}

	@Then("user navigate to the pricing page")
	public void user_navigate_to_the_pricing_page() {
		aboutPage.displayedPricingPage();
	}

	@Then("User is able to click on sign in button")
	public void user_is_able_to_click_on_sign_in_button() {
		aboutPage.clickOnSignInButton();
	}


	@When("User click on search button")
	public void user_click_on_search_button() {
	    aboutPage.clickOnSearchButton();
	}

	@When("user enter {string} on the search field")
	public void user_enter_on_the_search_field(String text) {
	   aboutPage.enterTextOnSearchFiled(text);
	}

	@When("user click on the close tab")
	public void user_click_on_the_close_tab() {
	   aboutPage.clickOnCloseButton();
	}

}

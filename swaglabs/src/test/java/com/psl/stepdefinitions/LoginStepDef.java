package com.psl.stepdefinitions;

import com.psl.pages.LoginPage;

import io.cucumber.java.en.*;

public class LoginStepDef{

	LoginPage loginPage = new LoginPage();

	@Given("User is on login page")
	public void user_is_on_login_page()  {
		loginPage.openLoginPage();
		loginPage.logoIsDisplayed();
	}

	@When("User enter username as {string} and password as {string}")
	public void user_enter_username_as_and_password_as(String username, String password) {
		loginPage.enterUsername(username);
		loginPage.enterPassword(password);
	}

	@When("Click on login button")
	public void click_on_login_button() {
		loginPage.clickOnLoginButton();
	}

	@Then("{string} title displayed after succesfully login")
	public void title_displayed_after_succesfully_login(String title) {
		loginPage.pageTitleIsDisplayed(title);
	}

	@Then("Error Message as {string} is displayed after unsuccessful login")
	public void displayed_after_unsuccessful_login(String errorMessage) {
		loginPage.errorMessageIsDisplayed(errorMessage);
	}
	@Then("Error Message as {string} is displayed")
	public void error_message_as_displayed(String errorMessage) {
		loginPage.errorMessageIsDisplayed(errorMessage);
	}
	@When("User enter username as {string}")
	public void user_enter_username_as(String username) {
		loginPage.enterUsername(username);
	}
	@Then("Error Message as {string} is displayed after enter only username")
	public void error_message_as_displayed_after_unsuccessful_login_after_enter_only_username(String errorMessage) {
		loginPage.errorMessageIsDisplayed(errorMessage);
	}
}

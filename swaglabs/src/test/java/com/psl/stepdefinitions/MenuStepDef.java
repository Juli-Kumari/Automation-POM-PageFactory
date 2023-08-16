package com.psl.stepdefinitions;

import java.time.Duration;

import org.testng.Assert;

import com.psl.common.BasePage;
import com.psl.pages.LoginPage;
import com.psl.pages.ProductPage;

import io.cucumber.java.en.*;

public class MenuStepDef extends BasePage {

	LoginPage loginPage= new LoginPage();
	ProductPage productPage = new ProductPage();
	
	@When("User click on menu")
	public void user_click_on_menu(){
	   productPage.clickOnMenuTab();
	  
	}

	@Then("User is able to see the options {string} {string} {string} {string}")
	public void user_is_able_to_see_the_options(String allItems, String about, String logout, String resetAppStates){
	   productPage.allItemsInMenuTab(allItems, about, logout, resetAppStates);
	}

	@When("User click on About tab")
	public void user_click_on_about_tab(){
	   productPage.clickOnAboutTab();
	 
	}

	@Then("User is able to see the tabs {string} {string} {string} {string}")
	public void user_is_able_to_see_the_tabs(String Products, String Solutions, String Pricing, String Resources){
		productPage.seeAllAboutPageTabs( Products,Solutions,  Pricing,  Resources);
	}

	@When("User click on logout option")
	public void user_click_on_logout_option(){
	   productPage.clickOnLogoutOption();
	}

	@Then("Redirect to the login page again")
	public void redirect_to_the_login_page_again() {
		loginPage.logoIsDisplayed();
	}

}

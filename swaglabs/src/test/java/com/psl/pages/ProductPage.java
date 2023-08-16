package com.psl.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.psl.common.BasePage;

public class ProductPage extends BasePage {

	public ProductPage() {
		PageFactory.initElements(driver, this);
	}

	// menu
	@FindBy(how = How.XPATH, using = "//span[@class=\"title\"]")
	@CacheLookup
	WebElement product;
	@FindBy(how = How.CLASS_NAME, using = "inventory_item_price")
	@CacheLookup
	WebElement productPrice;
	@FindBy(how = How.CLASS_NAME, using = "product_sort_container")
	@CacheLookup
	WebElement productFilter;
	@FindBy(how = How.CLASS_NAME, using = "inventory_item_name")
	@CacheLookup
	WebElement productName;
	@FindBy(how = How.CSS, using = "#react-burger-menu-btn")
	@CacheLookup
	WebElement menu;
	@FindBy(how = How.CSS, using = "a#inventory_sidebar_link")
	@CacheLookup
	WebElement menuAllItems;
	@FindBy(how = How.CSS, using = "a#about_sidebar_link")
	@CacheLookup
	WebElement menuAbout;
	@FindBy(how = How.CSS, using = "a#logout_sidebar_link")
	@CacheLookup
	WebElement menuLogout;
	@FindBy(how = How.CSS, using = "a#reset_sidebar_link")
	@CacheLookup
	WebElement menuResetAppState;

	// About Page
	@FindBy(xpath = "//*[@class= \"MuiBox-root css-0\"]//span[text()=\"Products\"]")
	WebElement productsTab;
	@FindBy(xpath = "//*[@class= \"MuiBox-root css-0\"]//span[text()=\"Solutions\"]")
	WebElement solutionsTab;
	@FindBy(xpath = "//*[@class= \"MuiBox-root css-1x2l18i\"]//a//span")
	WebElement pricingTab;
	@FindBy(xpath = "//*[@class= \"MuiBox-root css-0\"]//span[text()=\"Resources\"]")
	WebElement resourcesTab;

	// single product add to cart
	@FindBy(css = "#add-to-cart-sauce-labs-backpack")
	WebElement addToCartBackpack;
	@FindBy(css = ".shopping_cart_badge")
	WebElement shoppingCartBadge;
	@FindBy(css = "a.shopping_cart_link")
	WebElement shoopingCart;

	// mutiple product add to cart
	@FindBy(css = "#add-to-cart-sauce-labs-bike-light")
	WebElement addToCartBikeLight;

	public By productPriceLocator = By.className("inventory_item_price");

	public By productNameLocator = By.className("inventory_item_name");
	
	public void productsPageIsDisplayed() {
		verifyWebElementIsDisplayed(product);
	}

	public void productsPricePresentInDollerSign(String dollerSign) {
		Assert.assertTrue(getTextFromWebElement(productPrice).contains(dollerSign));
	}

	// menu
	public void clickOnMenuTab() {
		clickOnWebElement(menu);
	}

	public void allItemsInMenuTab(String allItems, String about, String logout, String resetAppStates) {
		Assert.assertEquals(getTextFromWebElement(menuAllItems), allItems);
		Assert.assertEquals(getTextFromWebElement(menuAbout), about);
		Assert.assertEquals(getTextFromWebElement(menuLogout), logout);
		Assert.assertEquals(getTextFromWebElement(menuResetAppState), resetAppStates);
	}

	// About Page
	public void clickOnAboutTab() {
		clickOnWebElement(menuAbout);
	}

	public void seeAllAboutPageTabs(String Products, String Solutions, String Pricing, String Resources) {
		Assert.assertEquals(getTextFromWebElement(productsTab), Products);
		Assert.assertEquals(getTextFromWebElement(solutionsTab), Solutions);
		Assert.assertEquals(getTextFromWebElement(pricingTab), Pricing);
		Assert.assertEquals(getTextFromWebElement(resourcesTab), Resources);
	}

	public void clickOnLogoutOption() {
		clickOnWebElement(menuLogout);
	}

	// single product add to cart
	public void clickOnAddToCartBtnForOneItem() {
		clickOnWebElement(addToCartBackpack);
	}

	public void shoppingCartIncrementToOne() {
		String badge = getTextFromWebElement(shoppingCartBadge);
		Assert.assertEquals(Integer.parseInt(badge), 1);
	}

	public void clickOnShoppingCartLink() {
		clickOnWebElement(shoopingCart);
	}

	// multiple products add to cart
	public void clickOnAddToCartBtnForMultipleItem() {
		clickOnWebElement(addToCartBackpack);
		clickOnWebElement(addToCartBikeLight);
	}

	public void shoppingCartIncrementedToMoreThanOne() {
		String badge = getTextFromWebElement(shoppingCartBadge);
		Assert.assertEquals(Integer.parseInt(badge), 2);
	}

	public void selectDropdownByNameInDescendingOrder() {
		verifyWebElementIsDisplayed(productFilter);
	}

	// products price in ascending order
	public void productsNameInDescendingOrder() {
		// 1. before filter capture the price
		List<WebElement> beforeFilterProductsName = findElements(productNameLocator);
		// 2. get the list of the products
		ArrayList<String> beforeFilterProductsNameList = new ArrayList<>();
		for (WebElement n : beforeFilterProductsName) {
			beforeFilterProductsNameList.add(n.getText());

		}
		// 3. filter the name from the dropdown in Name (Z to A)
		selectByVisibleText(productFilter, "Name (Z to A)");

		// 4. after filter capture the product name
		List<WebElement> afterFilterProductsName = findElements(productNameLocator);
		// 5. get the list of the products
		ArrayList<String> afterFilterProductsNameList = new ArrayList<>();
		for (WebElement n : afterFilterProductsName) {
			afterFilterProductsNameList.add(n.getText());

		}
		// 6. sort the value in decending order and compare with the before filter
		// values/ assert the values
		Collections.sort(beforeFilterProductsNameList); // return the beforeFilterPriceList in sorting the form of
														// ascending order

		Collections.reverse(beforeFilterProductsNameList); // decending order

		Assert.assertEquals(beforeFilterProductsNameList, afterFilterProductsNameList);

	}

	public void selectDropdownByNameInAscendingOrder() {
		// 3. filter the price from the dropdown in Price (low to high)
		verifyWebElementIsDisplayed(productFilter);

	}

	// products price in ascending order
	public void productsNameInAscendingOrder() {

		// 1. before filter capture the price
		List<WebElement> beforeFilterProductsName = findElements(productNameLocator);
		// 2. get the list of the products
		ArrayList<String> beforeFilterProductsNameList = new ArrayList<>();
		for (WebElement n : beforeFilterProductsName) {
			beforeFilterProductsNameList.add(n.getText());

		}
		// 3. filter the name from the dropdown in Name (A to Z)
		selectByVisibleText(productFilter, "Name (A to Z)");
		// 4. after filter capture the product name
		List<WebElement> afterFilterProductsName = findElements(productNameLocator);
		// 5. get the list of the products
		ArrayList<String> afterFilterProductsNameList = new ArrayList<>();
		for (WebElement n : afterFilterProductsName) {
			afterFilterProductsNameList.add(n.getText());

		}
		// 6. sort the value in decending order and compare with the before filter
		// values/ assert the values
		Collections.sort(beforeFilterProductsNameList); // return the beforeFilterPriceList in sorting the form of
														// ascending order

		Assert.assertEquals(beforeFilterProductsNameList, afterFilterProductsNameList);

	}

	public void selectDropdownByPriceInAscendingOrder() {
		// 3. filter the price from the dropdown in Price (low to high)
		verifyWebElementIsDisplayed(productFilter);
	}

	// products price in ascending order
	public void productsPriceInAscendingOrder() {

		// 1. before filter capture the price
		List<WebElement> beforeFilterPrice = findElements(productPriceLocator);

		// 2. remove the "$" symbol from the price then convert the string into double
		List<Double> beforeFilterPriceList = new ArrayList<>();
		for (WebElement price : beforeFilterPrice) {
			// price.getText()
			// price.getText().replace("$", "")
			// Double.valueOf(price.getText().replace("$", ""))
			beforeFilterPriceList.add(Double.valueOf(price.getText().replace("$", "")));
		}

		// 3. filter the price from the dropdown in Price (low to high)
		selectByVisibleText(productFilter, "Price (low to high)");
		// 4. after filter capture the price
		List<WebElement> afterFilterPrice = findElements(productPriceLocator);
		// 5. remove the "$" symbol from the price then convert the string into double
		List<Double> afterFilterPriceList = new ArrayList<>();
		for (WebElement p : afterFilterPrice) {
			afterFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
		}
		// 6. sort the value in decending order and compare with the before filter
		// values/ assert the values
		Collections.sort(beforeFilterPriceList); // return the beforeFilterPriceList in sorting the form of ascending
													// order

		Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList);

	}

	public void selectDropdownByPriceInDescendingOrder() {
		// 3. filter the price from the dropdown in Price (low to high)
		verifyWebElementIsDisplayed(productFilter);
	}

	// products price in scending order
	public void productsPriceInDescendingOrder() {

		// 1. before filter capture the price
		List<WebElement> beforeFilterPrice = findElements(productPriceLocator);

		// 2. remove the "$" symbol from the price then convert the string into double
		List<Double> beforeFilterPriceList = new ArrayList<>();
		for (WebElement price : beforeFilterPrice) {
			// price.getText()
			// price.getText().replace("$", "")
			// Double.valueOf(price.getText().replace("$", ""))
			beforeFilterPriceList.add(Double.valueOf(price.getText().replace("$", "")));
		}

		// 3. filter the price from the dropdown in Price (high to low)
		selectByVisibleText(productFilter, "Price (high to low)");
		// 4. after filter capture the price
		List<WebElement> afterFilterPrice = findElements(productPriceLocator);
		// 5. remove the "$" symbol from the price then convert the string into double
		List<Double> afterFilterPriceList = new ArrayList<>();
		for (WebElement p : afterFilterPrice) {
			afterFilterPriceList.add(Double.valueOf(p.getText().replace("$", "")));
		}
		// 6. sort the value in decending order and compare with the before filter
		// values/ assert the values
		Collections.sort(beforeFilterPriceList); // return the beforeFilterPriceList in sorting the form of ascending
													// order
		Collections.reverse(beforeFilterPriceList); // reverse the list beforeFilterPriceList

		Assert.assertEquals(beforeFilterPriceList, afterFilterPriceList);

	}

}

package com.psl.common;

import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtils {
	// setting explicit wait for checking an element is visible and enabled 
			public static WebElement waitForElement(WebElement elementName, long waitTimeSeconds) {
				WebDriverWait wait = new WebDriverWait(BasePage.driver, Duration.ofSeconds(waitTimeSeconds));
				WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementName));
				return element;
			}
}

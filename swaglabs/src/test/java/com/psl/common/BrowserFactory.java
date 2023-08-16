package com.psl.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserFactory {

	public static WebDriver driver = null;

	public static WebDriver openBrowser(String browserName) {
		
		if (browserName.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
			System.out.println("Chrome is launched........");
		} else if (browserName.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			System.out.println("Firefox is launched........");
		} else if (browserName.equalsIgnoreCase("edge")) {
			driver = new EdgeDriver();
			System.out.println("Edge is launched........");
		}
		driver.manage().window().maximize();
		return driver;
     
	}
}

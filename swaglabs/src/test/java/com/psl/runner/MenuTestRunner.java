package com.psl.runner;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import com.psl.common.Constants;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features/", glue = { "com.psl.common",
		"com.psl.stepdefinitions" }, tags ="@menu", monochrome = true, plugin = { "pretty",
				"json:target/cucumber-reports/cucumber.json", "html:target/cucumber-reports/cucumber.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
				})

public class MenuTestRunner extends AbstractTestNGCucumberTests {
	// Parallel Test Execution
//	@Override
//    @DataProvider(parallel = true)
//    public Object[][] scenarios() {
//        return super.scenarios();
//    }	
	
	@BeforeSuite
	@Parameters("browserName")
	public void beforeSuite(String browserName) {
		Constants.browserName = browserName;
	}
}

package com.psl.runner;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.psl.common.Constants;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features = "src/test/resources/Features/", glue = { "com.psl.common",
		"com.psl.stepdefinitions" }, tags = "@check_postalCode_With_stringValue", monochrome = true, 
//		dryRun = true,  // verify individual steps in the Feature file and the implementation code of steps in Feature file within the Step Definition file.
				 plugin = { "pretty",
				"json:target/cucumber-reports/cucumber.json", "html:target/cucumber-reports/cucumber.html",
				"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"})

public class FailedTestRunner extends AbstractTestNGCucumberTests {
	@BeforeSuite
	@Parameters("browserName")
	public void beforeSuite(String browserName) {
		Constants.browserName = browserName;
		
	}
}

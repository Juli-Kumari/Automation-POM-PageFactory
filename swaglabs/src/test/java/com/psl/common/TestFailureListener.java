package com.psl.common;

import org.apache.commons.codec.binary.Base64;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import java.io.UnsupportedEncodingException;


public class TestFailureListener extends TestListenerAdapter {
	@Override
	public void onTestFailure(ITestResult result) {
		String testName = result.getName();
		String exceptionMessage = result.getThrowable().getMessage();
		String browserDetails = BasePage.getBrowserDetails();
		
		String sendFrom = BasePage.getConfigProvider().getPropertyValue("EMAIL_ID");
		
		String senderPassword = null;
		try {
			senderPassword = new String(
					Base64.decodeBase64(BasePage.getConfigProvider().getPropertyValue("EMAIL_PASSWORD")), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Error occure while decoding the password");
		}
		String sendTo = BasePage.getConfigProvider().getPropertyValue("RECEIPIENTS_LIST");
		String subject = BasePage.getConfigProvider().getPropertyValue("EMAIL_SUBJECT");
		
		String body = "Test Name: " + testName + "\nException: " + exceptionMessage +"\n"+browserDetails;
		// call the sendEmail method
		EmailSender.sendEmail(sendTo, sendFrom, senderPassword, subject, body);

	}
}

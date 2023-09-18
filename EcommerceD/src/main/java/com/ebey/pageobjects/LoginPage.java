package com.ebey.pageobjects;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import com.ebey.mystore.actiondriver.ActionDriver;
import com.ebey.mystore.base.BaseClass;


public class LoginPage extends BaseClass {

	@FindBy(xpath="//*[@id=\"userid\"]")
	WebElement emailInput;
	
	@FindBy(xpath="//*[@id=\"pass\"]")
	WebElement passwordInput;
	
	@FindBy(xpath="//*[@id=\"signin-continue-btn\"]")
	WebElement continueWithMailButton;
	
	@FindBy(xpath="//*[@id=\"sgnBt\"]")
	WebElement signInButton;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	@Test
	public HomePage clickToSignInButton() {
		try {
			
			Thread.sleep(2000);
			ActionDriver.type(emailInput,prop.getProperty("username"));
			Thread.sleep(2000);
			ActionDriver.click(driver, continueWithMailButton);
			Thread.sleep(2000);
			ActionDriver.type(passwordInput, prop.getProperty("password"));
			Thread.sleep(2000);
			ActionDriver.click(driver, signInButton);
			
			return new HomePage();
			
		}catch(Exception e) {
			System.out.println("an error occured while signin button click in LoginPage - "+e);
			return null;
		}
	}
	
}

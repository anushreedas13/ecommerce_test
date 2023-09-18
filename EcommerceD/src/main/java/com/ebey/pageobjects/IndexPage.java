package com.ebey.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebey.mystore.actiondriver.ActionDriver;
import com.ebey.mystore.base.BaseClass;

public class IndexPage extends BaseClass {

	@FindBy(xpath="//*[@id=\"gh-ug\"]/a")
	WebElement signInButton;
	
	public IndexPage() {
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickToSignIn() {
		try {
			System.out.println("clicking action");
			ActionDriver.click(driver, signInButton);
			System.out.println("clicked action");
			
			return new LoginPage();
			
		}catch(Exception e) {
			System.out.println("an error occured while signin button click in indexPage - "+e);
			return null;
		}
	}	
	
}



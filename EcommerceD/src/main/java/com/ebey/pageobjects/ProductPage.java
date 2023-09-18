package com.ebey.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebey.mystore.base.BaseClass;

public class ProductPage extends BaseClass {

	@FindBy(xpath="//*[@id=\"gh-ac\"]")
	WebElement serachInput;
	
	@FindBy(xpath="//*[@id=\"gh-btn\"]")
	WebElement searchButton;
	
	
	
	public ProductPage() {
		PageFactory.initElements(driver, this);
	}
	
	
}

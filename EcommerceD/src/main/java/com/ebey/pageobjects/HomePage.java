package com.ebey.pageobjects;

import java.util.ArrayList;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ebey.mystore.actiondriver.ActionDriver;
import com.ebey.mystore.base.BaseClass;

public class HomePage extends BaseClass {

	
	@FindBy(xpath="//*[@id=\"gh-ac\"]")
	WebElement serachInput;
	
	@FindBy(xpath="//*[@id=\"gh-btn\"]")
	WebElement searchButton;
	
	@FindBy(xpath="//*[@id=\"item4ded2ecebd\"]/div/div[2]/a/div/span")
	WebElement firstproduct;
	
	@FindBy(xpath="//*[@id=\"mainContent\"]/div[2]/div/div[1]/div[2]/ul/li[2]/div/a")
	WebElement AddToCart;
	
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public ProductPage search() {
		
		try {
			
			Thread.sleep(2000);
			ActionDriver.type(serachInput, prop.getProperty("product_for_search"));
			Thread.sleep(2000);
			ActionDriver.click(driver, searchButton);
			
			
		}catch(Exception e) {
			System.out.println("an error occured while searching product in home page - "+e);
		}
		return null;
		
	}
	
	public AddToCart SelectFirstProduct() throws Exception {
		
		
		ActionDriver.click(driver, firstproduct);
		ActionDriver.Wait(driver, 5);
		
		
		ArrayList<String> newTb = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(newTb.get(1));
		System.out.println("Tab switch");
		ActionDriver.Wait(driver, 5);
		ActionDriver.click(driver, AddToCart);
		
		return new AddToCart();
		
	}

	
	
}





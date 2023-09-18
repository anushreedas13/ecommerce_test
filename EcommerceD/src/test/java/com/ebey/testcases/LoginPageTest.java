package com.ebey.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.ebey.mystore.base.BaseClass;
import com.ebey.pageobjects.HomePage;
import com.ebey.pageobjects.IndexPage;
import com.ebey.pageobjects.LoginPage;


public class LoginPageTest extends BaseClass {

	IndexPage currentIndexPage;
	LoginPage currentLoginPage;
	HomePage currentHomePage;
	
	
	@BeforeMethod
	public void setup() {
		
		loadConfig();
		LaunchApp();
	}
	
	@AfterMethod
	public void quitSetup() {
		driver.quit();
	}
	
	@Test
	public void IndexSigninClickTest() throws InterruptedException {
		
		Thread.sleep(5000);
		currentIndexPage = new IndexPage();
		currentLoginPage = currentIndexPage.clickToSignIn();
		Thread.sleep(3000);
		currentHomePage = currentLoginPage.clickToSignInButton();
		Thread.sleep(10000);
		
		
	}
}

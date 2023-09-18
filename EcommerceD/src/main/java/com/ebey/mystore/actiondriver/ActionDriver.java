package com.ebey.mystore.actiondriver;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.ebey.mystore.base.BaseClass;

public class ActionDriver extends BaseClass {
	
	public static void scrollByVisibilityofElement(WebDriver drive, WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntroView();", ele);
	}
	
	
	public static void click(WebDriver ldriver, WebElement locatorName)
	{
		Actions act = new Actions(ldriver);
		act.moveToElement(locatorName).click().build().perform();
	}
    public static boolean findElement(WebDriver ldriver, WebElement ele)
    {
    	boolean flag=false;
    	try {
    		ele.isDisplayed();
    		flag=true;
    	} catch (Exception e)
    	{
    		flag = false;
    	}
    	finally
    	{
    		if(flag) {
    			System.out.println("Sucessfully found Element at");
    		} else
    		{
    			System.out.println("The element is not found");
    		}
    	}
    	return flag;
    }
    
    public static boolean isDisplayed (WebDriver ldriver, WebElement ele)
    {
    	boolean flag=false;
    	flag=findElement(ldriver,ele);
    	if(flag)
    	{
    		flag=ele.isDisplayed();
    		if(flag)
    		{
    			System.out.println("The element is Displayed");
    		}
    		else
    		{
    			System.out.println("The Element is not Displayed");
    		}
    	}
    	else
    	{
    		System.out.println("NOT DISPLAYED");
    	}
    	return flag;
    }
    
    public static boolean isSelected (WebDriver ldriver, WebElement ele) {
    		boolean flag = false;
    		flag = findElement(ldriver, ele);
    		if(flag ) {
    		flag = ele.isSelected();
    		if(flag) {
    			System.out.println("The element is Selected");
    		} else {
    			System.out.println("The element is not Selected");
    		} 
    		}
    		else {
    			System.out.println("Not selected");
    		}
    		return flag;
    }
    
    
    
    //check sir
    public static boolean isEnabled (WebDriver ldriver, WebElement ele) {
		boolean flag = false;
		flag = findElement(ldriver, ele);
		if(flag ) {
		flag = ele.isEnabled();
		if(flag) {
			System.out.println("The element is Enabled");
		} else {
			System.out.println("The element is not Enabled");
		} 
		}
		else {
			System.out.println("Not selected");
		}
		return flag;
}
    
    
    public static boolean type(WebElement ele, String text) { //throws Throw
    boolean flag = false;
    try {
    	flag = ele.isDisplayed();
    	ele.clear();
    	ele.sendKeys(text);
    	//logger.info("Entered text:"+text");
    	flag = true;
    } catch (Exception e) {
    	System.out.println("Location Not found");
    	flag = false;
    } finally {
    	if (flag) {
    		System.out.println("Sucessfully entered value");
    	} else {
    		System.out.println("Unable to enter value");
    	}
    }
    
    return flag;
    
 }
    
    public static void Wait(WebDriver driver, int sec) {
    	driver.manage().timeouts().implicitlyWait(sec, TimeUnit.SECONDS);
    }
   
    
    
    
    
}

package com.ebey.mystore.base;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
		public static WebDriver driver;
		public static Properties prop;
		
		
		
		public void loadConfig()
		{
			try {
				prop=new Properties();
				FileInputStream ip = new FileInputStream(System.getProperty("user.dir") +"\\Configuration\\config.properties");
				prop.load(ip);
				System.out.println("driver:" +driver);
				
				String browserName=prop.getProperty("browser");
				System.out.println("Browser is - :" +browserName);
				
			} catch(FileNotFoundException e)
			{
				e.printStackTrace();
			} catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		
		public static void LaunchApp()
		{
			WebDriverManager.edgedriver().setup();
			String browserName=prop.getProperty("browser");
			
			if(browserName.contains("Edge")) {
				driver = new EdgeDriver();
			}
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			
			driver.get(prop.getProperty("url"));
		}
}








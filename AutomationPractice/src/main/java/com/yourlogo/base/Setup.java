package com.yourlogo.base;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.yourlogo.testdata.TestData;
import com.yourlogo.utilities.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author sugat
 * Setup - this page is setups the webdriver, browser and weburl under test.
 */

public class Setup 
{
	public static WebDriver driver;
	final String baseURL="http://automationpractice.com/index.php";
	public TestData data;
	
	public Setup() 
	{
		//Setup webdriver
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		//Setup testdata
		data=new TestData();
		
	}
	
	public Setup(String browser)
	{
		if(browser.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();		
		}
		
		if(browser.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}

		data=new TestData();
	}
	
	public void startApplication()
	{
		driver.get(baseURL);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);
	}
	

	public static void main(String[] args) 
	{
		Setup obj=new Setup("firefox");
		
		obj.startApplication();
		
		Utility.takeScreenshot("Setup", "HomePage Check");
		
		System.out.println("Setup test complete");
		
		System.exit(0);
	}
	
}

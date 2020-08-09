package com.yourlogo.base;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.yourlogo.testdata.TestData;
import com.yourlogo.utilities.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author sugat
 * Setup - this page is setups the webdriver, browser and weburl under test.
 */

public class Setup 
{

	final String baseURL="http://automationpractice.com/index.php";
	
	public static WebDriver driver;
	public TestData data;
	public Actions actions;
	public WebDriverWait wait;
	
	public static Logger logger=LogManager.getLogger("Automation Practice");
	
	@SuppressWarnings("deprecation")
	public Setup() 
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		data=new TestData();	
		actions=new Actions(driver);
		
		wait=new WebDriverWait(driver, 40);
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
		actions=new Actions(driver);
		wait=new WebDriverWait(driver, 40);
	}
	
	public void startApplication()
	{
		logger.info("Application Started");
		
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

package com.yourlogo._base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * @author sugat
 * Setup - this page is setups the baseurl and drivers under test
 */
public class Setup 
{
	public WebDriver driver;
	
	final String baseURL="http://automationpractice.com/index.php";
	
	public Setup()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		//WebDriverManager.firefoxdriver().setup();
		//driver=new FirefoxDriver();

		driver.get(baseURL);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);	
	}
	
	
	
	
	public static void main(String[] args) 
	{
		Setup obj=new Setup();
	}
	

}

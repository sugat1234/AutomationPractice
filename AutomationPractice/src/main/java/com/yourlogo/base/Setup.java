package com.yourlogo.base;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author sugat
 * Setup - this page is setups the webdriver, browser and weburl under test.
 */

public class Setup 
{
	public WebDriver driver;
	
	final String baseURL="http://automationpractice.com/index.php";

	public Setup() {}
	
	public Setup(String browser)
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
		//WebDriverManager.firefoxdriver().setup();
		//driver=new FirefoxDriver();

		driver.get(baseURL);
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().pageLoadTimeout(80, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(80, TimeUnit.SECONDS);	
	}
	
	
	public void takeScreenshot(String moduleName, String testName)
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		String filePath="C:\\Users\\sugat\\git\\AutomationPractice\\AutomationPractice\\src\\test\\java\\com\\yourlogo\\screenshots\\";
		
		try 
		{
			FileUtils.copyFile(scrFile, new File(filePath+moduleName+"-"+testName+".png"));
		} catch (IOException e) {e.printStackTrace();}
	}
	

	public static void main(String[] args) 
	{
		Setup obj=new Setup();
		
		//obj.takeScreenshot("Setup", "HomePage Check");
		
		System.out.println("Done");
	}
	
}

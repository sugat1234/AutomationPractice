package com.yourlogo.modules;


import java.util.HashMap;
import org.openqa.selenium.By;
import com.yourlogo.base.Setup;
import com.yourlogo.testdata.TestData;

public class Login extends Setup
{
	HashMap<String, String> loginTestData;
	
	public Login()
	{
		super();
	}
	
	public Login(String browserName)
	{
		super(browserName);
	}
	
	public void setupLoginData(int colNum)
	{
		loginTestData=data.getLoginData(colNum);
	}
	
	public void enterLoginDetailsAndSubmit()
	{
		System.out.println("Test Name : "+loginTestData.get("scenarioName"));
		
		driver.findElement(By.xpath("//a[@class='login']")).click();
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(loginTestData.get("loginEmailId"));
		
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(loginTestData.get("loginPassword"));
		
		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		
	}
	
	public String getTestName()
	{
		return loginTestData.get("scenarioName");
	}
	public static void main(String[] args) 
	{
		Login obj=new Login("firefox");
		
		obj.startApplication();
		
		obj.setupLoginData(3);
		
		obj.enterLoginDetailsAndSubmit();
		
		System.exit(0);
		
	}

}

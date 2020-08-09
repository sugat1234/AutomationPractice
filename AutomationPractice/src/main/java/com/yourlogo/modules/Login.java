package com.yourlogo.modules;

import java.text.DecimalFormat;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import com.yourlogo._base.Setup;
import com.yourlogo.testdata.TestData;

public class Login extends Setup
{
	TestData login;
	HashMap<String, String> loginTestData;
	
	public Login()
	{
		login=new TestData();
	}
	
	public void setupLoginData(int colNum)
	{
		loginTestData=login.getLoginData(colNum);
	}
	
	public void applicationlogin()
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
		Login obj=new Login();
		
		obj.setupLoginData(1);
		
		obj.applicationlogin();
		
	}

}

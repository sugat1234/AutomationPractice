package com.yourlogo.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yourlogo.login.Login;



public class Test_Login 
{
	Login login;
	String errMsg;
	
	@BeforeMethod
	public void loginPreTest()
	{
		login=new Login();
	}
	
	@Test(priority=1)
	public void emailIdBlank()
	{
		login.setupLoginData(1);
		
		login.applicationlogin();
		
		errMsg=login.driver.findElement(By.xpath("//li[contains(text(),'An email add')]")).getText();
		
		Assert.assertEquals(errMsg, "An email address required.");
		
		login.takeScreenshot("Login", login.getTestName());
	}
	
	
	@Test(priority=2)
	public void passwordBlank()
	{
		login.setupLoginData(2);
		
		login.applicationlogin();
		
		errMsg=login.driver.findElement(By.xpath("//li[contains(text(),'Password is required.')]")).getText();
		
		Assert.assertEquals(errMsg, "Password is required.");
		
		login.takeScreenshot("Login", login.getTestName());
	}
	
	@Test(priority=3)
	public void invalidEmailId()
	{
		login.setupLoginData(3);
		
		login.applicationlogin();
		
		errMsg=login.driver.findElement(By.xpath("//li[contains(text(),'Invalid email ad')]")).getText();
		
		Assert.assertEquals(errMsg, "Invalid email address.");
		
		login.takeScreenshot("Login", login.getTestName());
		
	}
	
	@Test(priority=4)
	public void invalidPassword()
	{	
		login.setupLoginData(4);
		
		login.applicationlogin();
		
		errMsg=login.driver.findElement(By.xpath("//li[contains(text(),'Authentication failed.')]")).getText();
		
		Assert.assertEquals(errMsg, "Authentication failed.");
		
		login.takeScreenshot("Login", login.getTestName());
	}
	
	@Test(priority=5)
	public void validLogin()
	{
		login.setupLoginData(5);
		
		login.applicationlogin();
		
		String url=login.driver.getCurrentUrl();
		
		if(url.contains("http://automationpractice.com/index.php?controller=my-account"))
			Assert.assertTrue(true);
		else 
			Assert.assertTrue(false);
		
		login.takeScreenshot("Login", login.getTestName());
		
		
	}
	
	@AfterMethod
	public void loginPostTest()
	{
		login.driver.close();
	}
	

}


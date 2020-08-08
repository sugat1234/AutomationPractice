package com.yourlogo.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yourlogo.buyproduct.BuyProduct;

public class Test_Login 
{
	BuyProduct buyProductLogin;
	String errMsg;
	
	@BeforeMethod
	public void loginPreTest()
	{
		buyProductLogin=new BuyProduct();
	}
	
	@Test(priority=1)
	public void emailIdBlank()
	{
		buyProductLogin.setupLoginData(1);
		
		buyProductLogin.login();
		
		errMsg=buyProductLogin.driver.findElement(By.xpath("//li[contains(text(),'An email add')]")).getText();
		
		Assert.assertEquals(errMsg, "An email address required.");
		
	}
	
	
	@Test(priority=2)
	public void passwordBlank()
	{
		buyProductLogin.setupLoginData(2);
		
		buyProductLogin.login();
		
		errMsg=buyProductLogin.driver.findElement(By.xpath("//li[contains(text(),'Password is required.')]")).getText();
		
		Assert.assertEquals(errMsg, "Password is required.");
		
	}
	
	@Test(priority=3)
	public void invalidEmailId()
	{
		buyProductLogin.setupLoginData(3);
		
		buyProductLogin.login();
		
		errMsg=buyProductLogin.driver.findElement(By.xpath("//li[contains(text(),'Invalid email ad')]")).getText();
		
		Assert.assertEquals(errMsg, "Invalid email address.");
		
	}
	
	@Test(priority=4)
	public void invalidPassword()
	{	
		buyProductLogin.setupLoginData(4);
		
		buyProductLogin.login();
		
		errMsg=buyProductLogin.driver.findElement(By.xpath("//li[contains(text(),'Authentication failed.')]")).getText();
		
		Assert.assertEquals(errMsg, "Authentication failed.");
	}
	
	@Test(priority=5)
	public void validLogin()
	{
		buyProductLogin.setupLoginData(5);
		
		buyProductLogin.login();
		
		String url=buyProductLogin.driver.getCurrentUrl();
		
		if(url.contains("http://automationpractice.com/index.php?controller=my-account"))
			Assert.assertTrue(true);
		else 
			Assert.assertTrue(false);
		
		
	}
	
	@AfterMethod
	public void loginPostTest()
	{
		buyProductLogin.driver.close();
	}
	

}


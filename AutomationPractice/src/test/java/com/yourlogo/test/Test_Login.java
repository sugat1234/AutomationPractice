package com.yourlogo.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yourlogo.buyproduct.BuyProduct;

public class Test_Login 
{
	BuyProduct buy;
	String errMsg;
	
	@BeforeMethod
	public void loginPreTest()
	{
		buy=new BuyProduct();
	}
	
	@Test(priority=1)
	public void emailIdBlank()
	{
		buy.setupLoginData(1);
		
		buy.login();
		
		errMsg=buy.driver.findElement(By.xpath("//li[contains(text(),'An email add')]")).getText();
		
		Assert.assertEquals(errMsg, "An email address required.");
		
	}
	
	@Test(priority=2)
	public void passwordBlank()
	{
		buy.setupLoginData(2);
		
		buy.login();
		
		errMsg=buy.driver.findElement(By.xpath("//li[contains(text(),'Password is required.')]")).getText();
		
		Assert.assertEquals(errMsg, "Password is required.");
		
	}
	
	@Test(priority=3)
	public void invalidEmailId()
	{
		buy.setupLoginData(3);
		
		buy.login();
		
		errMsg=buy.driver.findElement(By.xpath("//li[contains(text(),'Invalid email ad')]")).getText();
		
		Assert.assertEquals(errMsg, "Invalid email address.");
		
	}
	
	@Test(priority=4)
	public void invalidPassword()
	{	
		buy.setupLoginData(4);
		
		buy.login();
		
		errMsg=buy.driver.findElement(By.xpath("//li[contains(text(),'Authentication failed.')]")).getText();
		
		Assert.assertEquals(errMsg, "Authentication failed.");
	}
	
	@Test(priority=5)
	public void validLogin()
	{
		buy.setupLoginData(5);
		
		buy.login();
		
		String url=buy.driver.getCurrentUrl();
		
		if(url.contains("http://automationpractice.com/index.php?controller=my-account"))
			Assert.assertTrue(true);
		else 
			Assert.assertTrue(false);
		
		
	}
	
	@AfterMethod
	public void loginPostTest()
	{
		buy.driver.close();
	}
	

}


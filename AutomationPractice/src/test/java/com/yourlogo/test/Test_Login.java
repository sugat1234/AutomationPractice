package com.yourlogo.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import com.yourlogo.modules.Login;
import com.yourlogo.utilities.Utility;


@SuppressWarnings("static-access")
public class Test_Login 
{
	Login login;
	String errMsg;
	
	
	@Parameters({"browser"})
	@BeforeMethod(groups = {"group1"})
	public void loginPreTest(@Optional("firefox")String browserName)
	{
		login=new Login(browserName);
	}
	
	
	@Test(priority=1, groups = {"group1"})
	public void emailIdBlank()
	{
		login.setupLoginData(1);
	
		login.startApplication();
		
		login.enterLoginDetailsAndSubmit();
		
		errMsg=login.driver.findElement(By.xpath("//li[contains(text(),'An email add')]")).getText();
		
		Assert.assertEquals(errMsg, "An email address required.");
		
	}
	
	
	@Test(priority=2)
	public void passwordBlank()
	{
		login.setupLoginData(2);
		
		login.startApplication();
		
		login.enterLoginDetailsAndSubmit();
		
		errMsg=login.driver.findElement(By.xpath("//li[contains(text(),'Password is required.')]")).getText();
		
		Assert.assertEquals(errMsg, "Password is required.");
		
	}
	
	@Test(priority=3)
	public void invalidEmailId()
	{
		login.setupLoginData(3);
		
		login.startApplication();
		
		login.enterLoginDetailsAndSubmit();
		
		errMsg=login.driver.findElement(By.xpath("//li[contains(text(),'Invalid email ad')]")).getText();
		
		Assert.assertEquals(errMsg, "Invalid email address.");
		
	}
	
	@Test(priority=4)
	public void invalidPassword()
	{	
		login.setupLoginData(4);
		
		login.startApplication();
		
		login.enterLoginDetailsAndSubmit();
		
		errMsg=login.driver.findElement(By.xpath("//li[contains(text(),'Authentication failed.')]")).getText();
		
		Assert.assertEquals(errMsg, "Authentication failed.");
		
	}
	
	@Test(priority=5)
	public void validLogin()
	{
		login.setupLoginData(5);
		
		login.startApplication();
		
		login.enterLoginDetailsAndSubmit();
		
		String url=login.driver.getCurrentUrl();
		
		if(url.contains("http://automationpractice.com/index.php?controller=my-account"))
			Assert.assertTrue(true);
		else 
			Assert.assertTrue(false);
	}
	
	@AfterMethod(groups = {"group1"})
	public void loginPostTest()
	{
		Utility.takeScreenshot("Login", login.getTestName());
		
		login.driver.close();
	}
	

}


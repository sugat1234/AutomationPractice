package com.yourlogo.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.yourlogo.modules.Registration;
import com.yourlogo.utilities.Utility;

@SuppressWarnings("static-access")
public class Test_Registration 
{
	Registration reg;
	String errMsg;
	
	@Parameters({"browser"})
	@BeforeMethod
	public void registrationPreTest(@Optional("firefox")String browserName)
	{
		reg=new Registration(browserName);		
	}
	
	@Test(priority=1)
	public void invalidEmailId()
	{
		reg.setUpRegistrationData(1);
		
		reg.startApplication();
		
		reg.checkEmailValidity();
		
		errMsg=reg.driver.findElement(By.xpath("//li[contains(text(),'Invalid ema')]")).getAttribute("innerHTML");

		Assert.assertEquals(errMsg,"Invalid email address.");
				
	}
	
	@Test(priority=2)
	public void blankEmailId()
	{
		reg.setUpRegistrationData(2);
		
		reg.startApplication();
		
		reg.checkEmailValidity();
		
		errMsg=reg.driver.findElement(By.xpath("//li[contains(text(),'Invalid ema')]")).getAttribute("innerHTML");

		Assert.assertEquals(errMsg,"Invalid email address.");
		
	
	}
	
	@Test(priority=3)
	public void alreadyRegisteredEmailId()
	{
		reg.setUpRegistrationData(3);
		
		reg.startApplication();
		
		reg.checkEmailValidity();
		
		errMsg=reg.driver.findElement(By.xpath("//li[contains(text(),'An account using this email address has already be')]")).getAttribute("innerHTML");

		Assert.assertEquals(errMsg,"An account using this email address has already been registered. Please enter a valid password or request a new one. ");
		
		
	}

	@Test(priority=4)
	public void firstNameBlank()
	{
		reg.setUpRegistrationData(4);
		
		reg.startApplication();
		
		reg.checkEmailValidity();
		
		reg.enterPersonalInformation();
		
		reg.submitData();
		
		errMsg=reg.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"firstname is required.");
	
	}

	@Test(priority=5)
	public void firstNameInvalid()
	{
		reg.setUpRegistrationData(5);
		
		reg.startApplication();
		
		reg.checkEmailValidity();
		
		reg.enterPersonalInformation();
		
		reg.submitData();
		
		errMsg=reg.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"firstname is invalid.");
	
	}
	
	
	@Test(priority=6)
	public void lastNameBlank()
	{
		reg.setUpRegistrationData(6);
		
		reg.startApplication();
		
		reg.checkEmailValidity();
		
		reg.enterPersonalInformation();
		
		reg.submitData();
		
		errMsg=reg.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"lastname is required.");
	
	}
	
	@Test(priority=7)
	public void lastNameInvalid()
	{
		reg.setUpRegistrationData(7);
		
		reg.startApplication();
		
		reg.checkEmailValidity();
		
		reg.enterPersonalInformation();
		
		reg.submitData();
		
		errMsg=reg.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"lastname is invalid.");
	
	}
	
	@Test(priority=8)
	public void passwordBlank()
	{
		reg.setUpRegistrationData(8);
		
		reg.startApplication();
		
		reg.checkEmailValidity();
		
		reg.enterPersonalInformation();
		
		reg.submitData();
		
		errMsg=reg.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"passwd is required.");
	}
	
	@Test(priority=9)
	public void passwordLessThanFiveChars()
	{
		reg.setUpRegistrationData(9);
		
		reg.startApplication();
		
		reg.checkEmailValidity();
		
		reg.enterPersonalInformation();
		
		reg.submitData();
		
		errMsg=reg.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"passwd is invalid.");
	}
	
	@Test(priority=10)
	public void firstNameRepeatBlank()
	{
		reg.setUpRegistrationData(10);
		
		reg.startApplication();

		reg.checkEmailValidity();
		
		reg.enterPersonalInformation();
		
		reg.submitData();
		
		errMsg=reg.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"firstname is required.");
	}
	
	@Test(priority=11)
	public void firstNameRepeatInvalid()
	{
		reg.setUpRegistrationData(11);
		
		reg.startApplication();
			
		reg.checkEmailValidity();
		
		reg.enterPersonalInformation();
		
		reg.submitData();
		
		errMsg=reg.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"firstname is invalid.");
	}

	
	@Test(priority=12)
	public void lastNameRepeatBlank()
	{
		reg.setUpRegistrationData(12);
		
		reg.startApplication();
		
		reg.checkEmailValidity();
		
		reg.enterPersonalInformation();
		
		reg.submitData();
		
		errMsg=reg.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"lastname is required.");
	}
	
	@Test(priority=13)
	public void lastNameRepeatInvalid()
	{
		reg.setUpRegistrationData(13);
		
		reg.startApplication();
		
		reg.checkEmailValidity();
		
		reg.enterPersonalInformation();
		
		reg.submitData();
		
		errMsg=reg.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"lastname is invalid.");
	}

	@Test(priority=14)
	public void addressOneBlank()
	{
		reg.setUpRegistrationData(14);
		
		reg.startApplication();
		
		reg.checkEmailValidity();
		
		reg.enterPersonalInformation();
		
		reg.submitData();
		
		errMsg=reg.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"address1 is required.");
	}
	
	@Test(priority=15)
	public void cityBlank()
	{
		reg.setUpRegistrationData(15);
		
		reg.startApplication();
		
		reg.checkEmailValidity();
		
		reg.enterPersonalInformation();
		
		reg.submitData();
		
		errMsg=reg.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"city is required.");
	}
	
	@Test(priority=16)
	public void stateBlank()
	{
		reg.setUpRegistrationData(16);
		
		reg.startApplication();
		
		reg.checkEmailValidity();
		
		reg.enterPersonalInformation();
		
		reg.submitData();
		
		errMsg=reg.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"This country requires you to choose a State.");
	}
	
	@Test(priority=17)
	public void zipCodeBlank()
	{
		reg.setUpRegistrationData(17);
		
		reg.startApplication();
		
		reg.checkEmailValidity();
		
		reg.enterPersonalInformation();
		
		reg.submitData();
		
		errMsg=reg.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
	}
	
	@Test(priority=18)
	public void zipCodeInvalid()
	{
		reg.setUpRegistrationData(18);
		
		reg.startApplication();
		
		reg.checkEmailValidity();
		
		reg.enterPersonalInformation();
		
		reg.submitData();
		
		errMsg=reg.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
	}
	
	@Test(priority=19)
	public void countryBlank()
	{
		reg.setUpRegistrationData(19);
		
		reg.startApplication();
		
		reg.checkEmailValidity();
		
		reg.enterPersonalInformation();
		
		reg.submitData();
		
		errMsg=reg.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"id_country is required.");
	
	}
	

	@Test(priority=20)
	public void bothPhoneNumberBlank()
	{
		reg.setUpRegistrationData(20);
		
		reg.startApplication();
		
		reg.checkEmailValidity();
		
		reg.enterPersonalInformation();
		
		reg.submitData();
		
		errMsg=reg.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"You must register at least one phone number.");
	
	}
	
	
	@Test(priority=21)
	public void invalidHomePhone()
	{
		reg.setUpRegistrationData(21);
		
		reg.startApplication();
		
		reg.checkEmailValidity();
		
		reg.enterPersonalInformation();
		
		reg.submitData();
		
		errMsg=reg.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"phone is invalid.");
	
	}
	
	@Test(priority=22)
	public void invalidMobilePhone()
	{
		reg.setUpRegistrationData(22);
		
		reg.startApplication();
		
		reg.checkEmailValidity();
		
		reg.enterPersonalInformation();
		
		reg.submitData();
		
		errMsg=reg.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"phone_mobile is invalid.");
	
	}
	
	@AfterMethod
	public void registrationPostTest()
	{
		Utility.takeFullPageScreenshot("Registration", reg.getTestName());
		
		reg.driver.close();
	}
	

}

package com.yourlogo.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yourlogo.accountcreation.Registration;

public class Test_Registration 
{
	Registration regTest;
	String errMsg;
	
	@BeforeMethod
	public void registrationPreTest()
	{
		regTest=new Registration();		
	}
	
	
	@Test(priority=1)
	public void invalidEmailId()
	{
		regTest.setUpRegistrationData(1);
		
		regTest.checkEmailValidity();
		
		errMsg=regTest.driver.findElement(By.xpath("//li[contains(text(),'Invalid ema')]")).getAttribute("innerHTML");

		Assert.assertEquals(errMsg,"Invalid email address.");
		
	
	}
	
	@Test(priority=2)
	public void blankEmailId()
	{
		regTest.setUpRegistrationData(2);
		
		regTest.checkEmailValidity();
		
		errMsg=regTest.driver.findElement(By.xpath("//li[contains(text(),'Invalid ema')]")).getAttribute("innerHTML");

		Assert.assertEquals(errMsg,"Invalid email address.");
		
	
	}
	
	@Test(priority=3)
	public void alreadyRegisteredEmailId()
	{
		regTest.setUpRegistrationData(3);
		
		regTest.checkEmailValidity();
		
		errMsg=regTest.driver.findElement(By.xpath("//li[contains(text(),'An account using this email address has already be')]")).getAttribute("innerHTML");

		Assert.assertEquals(errMsg,"An account using this email address has already been registered. Please enter a valid password or request a new one. ");
		
		
	}

	@Test(priority=4)
	public void firstNameBlank()
	{
		regTest.setUpRegistrationData(4);
		
		regTest.checkEmailValidity();
		
		regTest.enterPersonalInformation();
		
		regTest.submitData();
		
		errMsg=regTest.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"firstname is required.");
	
	}

	@Test(priority=5)
	public void firstNameInvalid()
	{
		regTest.setUpRegistrationData(5);
		
		regTest.checkEmailValidity();
		
		regTest.enterPersonalInformation();
		
		regTest.submitData();
		
		errMsg=regTest.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"firstname is invalid.");
	
	}
	
	
	@Test(priority=6)
	public void lastNameBlank()
	{
		regTest.setUpRegistrationData(6);
		
		regTest.checkEmailValidity();
		
		regTest.enterPersonalInformation();
		
		regTest.submitData();
		
		errMsg=regTest.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"lastname is required.");
	
	}
	
	@Test(priority=7)
	public void lastNameInvalid()
	{
		regTest.setUpRegistrationData(7);
		
		regTest.checkEmailValidity();
		
		regTest.enterPersonalInformation();
		
		regTest.submitData();
		
		errMsg=regTest.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"lastname is invalid.");
	
	}
	
	@Test(priority=8)
	public void passwordBlank()
	{
		regTest.setUpRegistrationData(8);
		
		regTest.checkEmailValidity();
		
		regTest.enterPersonalInformation();
		
		regTest.submitData();
		
		errMsg=regTest.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"passwd is required.");
	}
	
	@Test(priority=9)
	public void passwordLessThanFiveChars()
	{
		regTest.setUpRegistrationData(9);
		
		regTest.checkEmailValidity();
		
		regTest.enterPersonalInformation();
		
		regTest.submitData();
		
		errMsg=regTest.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"passwd is invalid.");
	}
	
	@Test(priority=10)
	public void firstNameRepeatBlank()
	{
		regTest.setUpRegistrationData(10);
		
		regTest.checkEmailValidity();
		
		regTest.enterPersonalInformation();
		
		regTest.submitData();
		
		errMsg=regTest.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"firstname is required.");
	}
	
	@Test(priority=11)
	public void firstNameRepeatInvalid()
	{
		regTest.setUpRegistrationData(11);
		
		regTest.checkEmailValidity();
		
		regTest.enterPersonalInformation();
		
		regTest.submitData();
		
		errMsg=regTest.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"firstname is invalid.");
	}

	
	@Test(priority=12)
	public void lastNameRepeatBlank()
	{
		regTest.setUpRegistrationData(12);
		
		regTest.checkEmailValidity();
		
		regTest.enterPersonalInformation();
		
		regTest.submitData();
		
		errMsg=regTest.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"lastname is required.");
	}
	
	@Test(priority=13)
	public void lastNameRepeatInvalid()
	{
		regTest.setUpRegistrationData(13);
		
		regTest.checkEmailValidity();
		
		regTest.enterPersonalInformation();
		
		regTest.submitData();
		
		errMsg=regTest.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"lastname is invalid.");
	}

	@Test(priority=14)
	public void addressOneBlank()
	{
		regTest.setUpRegistrationData(14);
		
		regTest.checkEmailValidity();
		
		regTest.enterPersonalInformation();
		
		regTest.submitData();
		
		errMsg=regTest.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"address1 is required.");
	}
	
	@Test(priority=15)
	public void cityBlank()
	{
		regTest.setUpRegistrationData(15);
		
		regTest.checkEmailValidity();
		
		regTest.enterPersonalInformation();
		
		regTest.submitData();
		
		errMsg=regTest.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"city is required.");
	}
	
	@Test(priority=16)
	public void stateBlank()
	{
		regTest.setUpRegistrationData(16);
		
		regTest.checkEmailValidity();
		
		regTest.enterPersonalInformation();
		
		regTest.submitData();
		
		errMsg=regTest.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"This country requires you to choose a State.");
	}
	
	@Test(priority=17)
	public void zipCodeBlank()
	{
		regTest.setUpRegistrationData(17);
		
		regTest.checkEmailValidity();
		
		regTest.enterPersonalInformation();
		
		regTest.submitData();
		
		errMsg=regTest.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
	}
	
	@Test(priority=18)
	public void zipCodeInvalid()
	{
		regTest.setUpRegistrationData(18);
		
		regTest.checkEmailValidity();
		
		regTest.enterPersonalInformation();
		
		regTest.submitData();
		
		errMsg=regTest.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"The Zip/Postal code you've entered is invalid. It must follow this format: 00000");
	}
	
	@Test(priority=19)
	public void countryBlank()
	{
		regTest.setUpRegistrationData(19);
		
		regTest.checkEmailValidity();
		
		regTest.enterPersonalInformation();
		
		regTest.submitData();
		
		errMsg=regTest.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"id_country is required.");
	
	}
	

	@Test(priority=20)
	public void bothPhoneNumberBlank()
	{
		regTest.setUpRegistrationData(20);
		
		regTest.checkEmailValidity();
		
		regTest.enterPersonalInformation();
		
		regTest.submitData();
		
		errMsg=regTest.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"You must register at least one phone number.");
	
	}
	
	
	@Test(priority=21)
	public void invalidHomePhone()
	{
		regTest.setUpRegistrationData(21);
		
		regTest.checkEmailValidity();
		
		regTest.enterPersonalInformation();
		
		regTest.submitData();
		
		errMsg=regTest.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"phone is invalid.");
	
	}
	
	@Test(priority=22)
	public void invalidMobilePhone()
	{
		regTest.setUpRegistrationData(22);
		
		regTest.checkEmailValidity();
		
		regTest.enterPersonalInformation();
		
		regTest.submitData();
		
		errMsg=regTest.driver.findElement(By.xpath("//div[@class='columns-container']//li[1]")).getText();

		Assert.assertEquals(errMsg,"phone_mobile is invalid.");
	
	}
	
	@AfterMethod
	public void registrationPostTest()
	{
		regTest.driver.close();
	}
	

}

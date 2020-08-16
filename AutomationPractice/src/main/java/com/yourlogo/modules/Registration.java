package com.yourlogo.modules;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.yourlogo.base.Setup;

/**
 * @author sugat
 * This page is flow for creating an account on website.
 * If email id to be registered already exists then error will be displayed.
 * Only unregistered email id can be used to create new account.
 */

public class Registration extends Setup 
{	

	HashMap<String, String> regTestData;
	
	public Registration()
	{
		super();
	}
	
	public Registration(String browserName)
	{
		super(browserName);
	}
	
	public void setUpRegistrationData(int colNum)
	{
		logger.info("Setting up Test Data for Registration module");
		
		regTestData=data.getRegistrationData(colNum);
	}

	
	public void checkEmailValidity()
	{
		System.out.println("Test Name : "+regTestData.get("scenarioName"));
		
		logger.info("Enter an Email ID and click on 'Create an Account'");
		
		driver.findElement(By.xpath("//a[@class='login']")).click();
		
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(regTestData.get("emailAddress"));
		
		driver.findElement(By.xpath("//form[@id='create-account_form']//span[1]")).click();

	}
	
	public void enterPersonalInformation()
	{
		logger.info("Entering details for creating an account ");
		
		if(regTestData.get("title").equalsIgnoreCase("Mr"))
		{
			driver.findElement(By.xpath("//input[@id='id_gender1']")).click();				
		}
		
		if(regTestData.get("title").equalsIgnoreCase("Mrs"))
		{
			driver.findElement(By.xpath("//input[@id='id_gender2']")).click();	
		}

			
		driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(regTestData.get("firstName"));
		
		driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(regTestData.get("lastName"));
		
		driver.findElement(By.xpath("//input[@id='email']"));
		
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(regTestData.get("password"));
		
		Select day=new Select(driver.findElement(By.xpath("//select[@id='days']")));
		
		day.selectByValue(regTestData.get("dateOfBirthDay"));
		
		Select month=new Select(driver.findElement(By.xpath("//select[@id='months']")));
		
		month.selectByValue(regTestData.get("dateOfBirthMonth"));
		
		Select year=new Select(driver.findElement(By.xpath("//select[@id='years']")));
		
		year.selectByValue(regTestData.get("dateOfBirthYear"));
		
		if(regTestData.get("newsLetter").equalsIgnoreCase("Yes"))
		{
			driver.findElement(By.xpath("//input[@id='newsletter']")).click();				
		}

		if(regTestData.get("specialOffers").equalsIgnoreCase("Yes"))
		{
			driver.findElement(By.xpath("//input[@id='optin']")).click();	
		}
		
		
		if(regTestData.get("firstNameRepeat").isEmpty())
		{
			driver.findElement(By.xpath("//input[@id='firstname']")).clear();				
		}
		else
		{
			driver.findElement(By.xpath("//input[@id='firstname']")).clear();				
			driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(regTestData.get("firstNameRepeat"));				
		}
		
		if(regTestData.get("lastNameRepeat").isEmpty())
		{
			driver.findElement(By.xpath("//input[@id='lastname']")).clear();				
		}
		else
		{
			driver.findElement(By.xpath("//input[@id='lastname']")).clear();
			driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(regTestData.get("lastNameRepeat"));				
		}
		

		driver.findElement(By.xpath("//input[@id='company']")).sendKeys(regTestData.get("company"));
		
		driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(regTestData.get("addressLine1"));
		
		driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(regTestData.get("addressLine2"));
		
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys(regTestData.get("city"));
		
		Select country =new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
		
		country.selectByVisibleText(regTestData.get("country"));
		
		if(regTestData.get("country").equalsIgnoreCase("United States"))
		{
			Select state =new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
			
			state.selectByVisibleText(regTestData.get("state"));
			
			driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(regTestData.get("postalCode"));	
		}
		
		driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys(regTestData.get("additionalInformation"));
		
		driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(regTestData.get("homePhone"));
		
		driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(regTestData.get("mobilePhone"));
		
		driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(regTestData.get("addressAlais"));
			

		logger.info("All details for creating an account entered");
				
	}
	
	public void submitData()
	{
		logger.info("Click on Register");
		
		driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
	
	}

	public String getTestName()
	{
		return regTestData.get("scenarioName");
	}
	
	public static void main(String[] args) 
	{
		Registration obj=new Registration();
		
		try
		{
			obj.startApplication();
			
			obj.setUpRegistrationData(7);
			
			obj.checkEmailValidity();
			
			obj.enterPersonalInformation();
			
			obj.submitData();	
		}
		catch(Exception e)
		{
			System.out.println("An error has occured");
		}
		
		System.exit(0);
		
		System.out.println("Registration test complete");
	}

}

package com.yourlogo.modules;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import com.yourlogo.base.Setup;
import com.yourlogo.testdata.TestData;

/**
 * @author sugat
 * This page is flow for creating an account on website.
 * If email id to be registered already exists then error will be displayed.
 * Only unregistered email id can be used to create new account.
 */

public class Registration extends Setup 
{	
	TestData reg;
	HashMap<String, String> testData;
	
	public Registration()
	{
		reg=new TestData();
	}
	
	public void setUpRegistrationData(int colNum)
	{
		testData=reg.getRegistrationData(colNum);
	}
	
	public void checkEmailValidity()
	{
		System.out.println("Test Name : "+testData.get("scenarioName"));
		
		driver.findElement(By.xpath("//a[@class='login']")).click();
		
		driver.findElement(By.xpath("//input[@id='email_create']")).sendKeys(testData.get("emailAddress"));
		
		driver.findElement(By.xpath("//form[@id='create-account_form']//span[1]")).click();
	
	}
	
	public String getTestName()
	{
		return testData.get("scenarioName");
	}
	
	public void enterPersonalInformation()
	{
			if(testData.get("title").equalsIgnoreCase("Mr"))
			{
				driver.findElement(By.xpath("//input[@id='id_gender1']")).click();				
			}
			
			if(testData.get("title").equalsIgnoreCase("Mrs"))
			{
				driver.findElement(By.xpath("//input[@id='id_gender2']")).click();	
			}

				
			driver.findElement(By.xpath("//input[@id='customer_firstname']")).sendKeys(testData.get("firstName"));
			
			driver.findElement(By.xpath("//input[@id='customer_lastname']")).sendKeys(testData.get("lastName"));
			
			driver.findElement(By.xpath("//input[@id='email']"));
			
			driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(testData.get("password"));
			
			Select day=new Select(driver.findElement(By.xpath("//select[@id='days']")));
			
			day.selectByValue(testData.get("dateOfBirthDay"));
			
			Select month=new Select(driver.findElement(By.xpath("//select[@id='months']")));
			
			month.selectByValue(testData.get("dateOfBirthMonth"));
			
			Select year=new Select(driver.findElement(By.xpath("//select[@id='years']")));
			
			year.selectByValue(testData.get("dateOfBirthYear"));
			
			if(testData.get("newsLetter").equalsIgnoreCase("Yes"))
			{
				driver.findElement(By.xpath("//input[@id='newsletter']")).click();				
			}

			if(testData.get("specialOffers").equalsIgnoreCase("Yes"))
			{
				driver.findElement(By.xpath("//input[@id='optin']")).click();	
			}
			
			
			if(testData.get("firstNameRepeat").isBlank())
			{
				driver.findElement(By.xpath("//input[@id='firstname']")).clear();				
			}
			else
			{
				driver.findElement(By.xpath("//input[@id='firstname']")).clear();				
				driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys(testData.get("firstNameRepeat"));				
			}
			
			if(testData.get("lastNameRepeat").isBlank())
			{
				driver.findElement(By.xpath("//input[@id='lastname']")).clear();				
			}
			else
			{
				driver.findElement(By.xpath("//input[@id='lastname']")).clear();
				driver.findElement(By.xpath("//input[@id='lastname']")).sendKeys(testData.get("lastNameRepeat"));				
			}
			

			driver.findElement(By.xpath("//input[@id='company']")).sendKeys(testData.get("company"));
			
			driver.findElement(By.xpath("//input[@id='address1']")).sendKeys(testData.get("addressLine1"));
			
			driver.findElement(By.xpath("//input[@id='address2']")).sendKeys(testData.get("addressLine2"));
			
			driver.findElement(By.xpath("//input[@id='city']")).sendKeys(testData.get("city"));
			
			Select country =new Select(driver.findElement(By.xpath("//select[@id='id_country']")));
			
			country.selectByVisibleText(testData.get("country"));
			
			if(testData.get("country").equalsIgnoreCase("United States"))
			{
				Select state =new Select(driver.findElement(By.xpath("//select[@id='id_state']")));
				
				state.selectByVisibleText(testData.get("state"));
				
				driver.findElement(By.xpath("//input[@id='postcode']")).sendKeys(testData.get("postalCode"));	
			}
			
			driver.findElement(By.xpath("//textarea[@id='other']")).sendKeys(testData.get("additionalInformation"));
			
			driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(testData.get("homePhone"));
			
			driver.findElement(By.xpath("//input[@id='phone_mobile']")).sendKeys(testData.get("mobilePhone"));
			
			driver.findElement(By.xpath("//input[@id='alias']")).sendKeys(testData.get("addressAlais"));
			
				
	}
	
	public void submitData()
	{
		driver.findElement(By.xpath("//span[contains(text(),'Register')]")).click();
	}

	public static void main(String[] args) {
		Registration obj=new Registration();
		
		obj.setUpRegistrationData(7);
		
		obj.checkEmailValidity();
		
		obj.enterPersonalInformation();
		
		obj.submitData();
		
		System.out.println("Success");
	}

}

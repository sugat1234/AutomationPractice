package com.yourlogo.buyproduct;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import com.yourlogo._base.Setup;
import com.yourlogo.testdata.TestData;

public class BuyProduct extends Setup
{
	TestData buyProd;
	HashMap<String, String> loginTestData;
	
	public BuyProduct()
	{
		buyProd=new TestData();
	}
	
	public void setupLoginData(int colNum)
	{
		loginTestData=buyProd.getLoginData(colNum);
	}
	
	
	public void login()
	{
		driver.findElement(By.xpath("//a[@class='login']")).click();
		
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(loginTestData.get("loginEmailId"));
		
		driver.findElement(By.xpath("//input[@id='passwd']")).sendKeys(loginTestData.get("loginPassword"));
		
		driver.findElement(By.xpath("//p[@class='submit']//span[1]")).click();
		
	}
	
	public void buyWomensProduct()
	{
		driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]")).click();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)");
		   
	    driver.findElement(By.cssSelector(".hovered .quick-view > span")).click();
	    driver.switchTo().frame(0);
	    driver.findElement(By.id("quantity_wanted")).click();
	    driver.findElement(By.id("quantity_wanted")).clear();
	    driver.findElement(By.id("quantity_wanted")).sendKeys("2");
	    driver.findElement(By.cssSelector(".exclusive > span")).click();
	    driver.switchTo().defaultContent();
	    driver.findElement(By.cssSelector(".button-medium:nth-child(2) > span")).click();
	    
	    
	    driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")).click();

	    driver.findElement(By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")).click();
	    
	    driver.findElement(By.id("cgv")).click();

	    driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")).click();
	    		
		System.out.println("Product Selected");
	}
	
	public void paymentMethod_BankWire()
	{
	    driver.findElement(By.xpath("//a[@class='bankwire']")).click();		
	}
	
	public void paymentMethod_Cheque()
	{
	    driver.findElement(By.xpath("//a[@class='cheque']")).click();		
	}
	
	public void verifyOrderDetails()
	{
		driver.findElement(By.xpath("//a[@class='account']")).click();
		
		driver.findElement(By.xpath("//span[contains(text(),'Order history and details')]")).click();
	}
	
	
	public static void main(String[] args) {
		BuyProduct obj=new BuyProduct();
		
		obj.setupLoginData(5);
		
		obj.login();
		
		obj.buyWomensProduct();
		
		//obj.paymentMethod_BankWire();
		
		obj.paymentMethod_Cheque();
		
		obj.verifyOrderDetails();
	}

}

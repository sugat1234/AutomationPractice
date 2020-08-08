package com.yourlogo.buyproduct;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;

import com.yourlogo._base.Setup;
import com.yourlogo.testdata.TestData;

/**
 * @author sugat
 * In the below code, user logs into the website and places an order of quantity n.
 * After the order is placed, the order is verified in order details in MyAccount
 */

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
	
	final int quantity=2;
	public void buyWomensProduct()
	{
		driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]")).click();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)");
		   
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
		
		
	    driver.findElement(By.cssSelector(".hovered .quick-view > span")).click();
	    driver.switchTo().frame(0);
	   
	    /*
	    String productCostString=driver.findElement(By.xpath("//span[@id='our_price_display']")).getText();
	    System.out.println(productCostString);
	    
	    String[] splitdata=productCostString.split("$");
	    System.out.println(splitdata[0]);
	    
	    double productCost=Double.parseDouble(productCostString);
	    */
	    
	    driver.findElement(By.id("quantity_wanted")).click();
	    driver.findElement(By.id("quantity_wanted")).clear();
	    driver.findElement(By.id("quantity_wanted")).sendKeys(Integer.toString(quantity));
	    driver.findElement(By.cssSelector(".exclusive > span")).click();
	    driver.switchTo().defaultContent();
	    driver.findElement(By.cssSelector(".button-medium:nth-child(2) > span")).click();
	    
	 /*   
	    driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")).click();

	    driver.findElement(By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")).click();
	    
	    driver.findElement(By.id("cgv")).click();

	    driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")).click();
	    		
		System.out.println("Product Selected");
		
	*/
	}
	
	public void paymentMethod_BankWire()
	{
	    driver.findElement(By.xpath("//a[@class='bankwire']")).click();		
	}
	
	public void paymentMethod_Cheque()
	{
	    driver.findElement(By.xpath("//a[@class='cheque']")).click();		
	}
	
	public void placeOrder()
	{
		driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]")).click();
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
		
		//obj.paymentMethod_Cheque();
		
		//obj.verifyOrderDetails();
		
		//obj.placeOrder();
	}

}

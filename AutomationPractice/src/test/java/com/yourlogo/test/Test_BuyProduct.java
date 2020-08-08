package com.yourlogo.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.yourlogo.buyproduct.BuyProduct;



public class Test_BuyProduct 
{
	BuyProduct buyProduct1;
	String msg;
	
	@BeforeMethod
	public void buyProductPreTest()
	{
		buyProduct1=new BuyProduct();
	}
	
	@Test(priority=1)
	public void placeOrderUsingBankWire()
	{
		buyProduct1.setupLoginData(5);
		
		buyProduct1.login();
		
		buyProduct1.buyWomensProduct();
		
		buyProduct1.paymentMethod_BankWire();
		
		buyProduct1.placeOrder();
		
		msg=buyProduct1.driver.findElement(By.xpath("//strong[contains(text(),'Your order on My Store is complete.')]")).getText();
		
		Assert.assertEquals(msg, "Your order on My Store is complete.");
	
		buyProduct1.verifyOrderDetails();
		
	}
	
	@Test(priority=2)
	public void placeOrderUsingCheque()
	{
		buyProduct1.setupLoginData(5);
		
		buyProduct1.login();
		
		buyProduct1.buyWomensProduct();
				
		buyProduct1.paymentMethod_Cheque();
		
		buyProduct1.placeOrder();
		
		msg=buyProduct1.driver.findElement(By.xpath("//strong[contains(text(),'Your order on My Store is complete.')]")).getText();
		
		Assert.assertEquals(msg, "Your order on My Store is complete.");
		
		buyProduct1.verifyOrderDetails();
		
	}
	
	@AfterMethod
	public void buyProductPostTest()
	{
		buyProduct1.driver.close();
	}

}

package com.yourlogo.test;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;

import com.yourlogo.modules.BuyProduct;

public class Test_BuyProduct 
{
	BuyProduct buy;
	String msg;
	
	@BeforeMethod
	public void buyProductPreTest()
	{
		buy=new BuyProduct();
	}
	
	@Test(priority=1)
	public void placeOrderUsingBankWire()
	{
		buy.setupLoginData(6);
		
		buy.startApplication();
		
		buy.enterLoginDetailsAndSubmit();
		
		buy.selectProductAndQuantity(1);
		
		buy.checkTransactionDetails();
		
		buy.paymentMethod_BankWire();
				
		buy.placeOrder();
		
		buy.verifyOrderDetails();
		
	}
	
	@Test(priority=2)
	public void placeOrderUsingCheque()
	{
		buy.setupLoginData(6);
		
		buy.startApplication();
		
		buy.enterLoginDetailsAndSubmit();
		
		buy.selectProductAndQuantity(4);
		
		buy.checkTransactionDetails();
		
		buy.paymentMethod_Cheque();
				
		buy.placeOrder();
		
		buy.verifyOrderDetails();
		
	}
	
	@SuppressWarnings("static-access")
	@AfterMethod
	public void buyProductPostTest()
	{
		buy.driver.close();
	}

}

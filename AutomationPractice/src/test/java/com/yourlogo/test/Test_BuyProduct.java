package com.yourlogo.test;

import org.testng.annotations.*;

import com.yourlogo.modules.BuyProduct;

public class Test_BuyProduct 
{
	final int validLoginData=6;
	BuyProduct buy;
		
	@Parameters({"browser"})
	@BeforeMethod
	public void buyProductPreTest(@Optional("firefox") String browserName)
	{
		buy=new BuyProduct(browserName);
	}
	
	@Test(priority=1)
	public void placeOrderUsingBankWire()
	{
		buy.setupLoginData(validLoginData);
		
		buy.startApplication();
		
		buy.enterLoginDetailsAndSubmit();
		
		buy.selectProductAndQuantity(3);
		
		buy.checkTransactionDetails();
		
		buy.paymentMethod_BankWire();
				
		//buy.placeOrder();
		
		//buy.verifyOrderDetails();
		
	}
	
	@Test(priority=2)
	public void placeOrderUsingCheque()
	{
		buy.setupLoginData(validLoginData);
		
		buy.startApplication();
		
		buy.enterLoginDetailsAndSubmit();
		
		buy.selectProductAndQuantity(6);
		
		buy.checkTransactionDetails();
		
		buy.paymentMethod_Cheque();
				
		//buy.placeOrder();
		
		//buy.verifyOrderDetails();
		
	}
	
	@SuppressWarnings("static-access")
	@AfterMethod
	public void buyProductPostTest()
	{
		buy.driver.close();
	}

}

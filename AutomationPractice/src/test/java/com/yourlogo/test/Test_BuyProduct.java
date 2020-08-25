package com.yourlogo.test;

import org.testng.annotations.*;

import com.yourlogo.modules.BuyProduct;
import com.yourlogo.utilities.Utility;

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
		
		buy.selectProductAndQuantity(2);
		
		Utility.takeScreenshot("Buy Product 1", "Select Product");
		
		buy.checkTransactionDetails();
		
		buy.paymentMethod_BankWire();
				
		buy.placeOrder();

		Utility.takeScreenshot("Buy Product 1", "Order Placed");
		
		buy.verifyOrderDetails();

		Utility.takeScreenshot("Buy Product 1", "Order Details Verified");
	}
	
	@Test(priority=2)
	public void placeOrderUsingCheque()
	{
		buy.setupLoginData(validLoginData);
		
		buy.startApplication();
		
		buy.enterLoginDetailsAndSubmit();
		
		buy.selectProductAndQuantity(5);
		
		Utility.takeScreenshot("Buy Product 2", "Select Product");
		
		buy.checkTransactionDetails();
		
		buy.paymentMethod_Cheque();
				
		buy.placeOrder();

		Utility.takeScreenshot("Buy Product 2", "Order Placed");
		
		buy.verifyOrderDetails();

		Utility.takeScreenshot("Buy Product 2", "Order Details Verified");
	}
	
	@SuppressWarnings("static-access")
	@AfterMethod
	public void buyProductPostTest()
	{
		buy.driver.close();
	}

}

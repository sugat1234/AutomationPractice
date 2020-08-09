package com.yourlogo.modules;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;


/**
 * @author sugat
 * In the below code, user logs into the website and places an order of quantity n.
 * After the order is placed, the order is verified in order details in MyAccount
 */

public class BuyProduct extends Login
{
	DecimalFormat form;
	Actions actions;
	
	public BuyProduct()
	{
		form=new DecimalFormat("#00.00");
		actions=new Actions(driver);
	}
		    
    ArrayList<WebElement> productList;
    public WebElement getProduct(int index)
    {
		productList=new ArrayList<WebElement>();
    	
    	try
    	{
	    	productList.add(driver.findElement(By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]")));
			
	    	productList.add(driver.findElement(By.xpath("//div[@class='right-block']//a[@class='product-name'][contains(text(),'Blouse')]")));
			
			productList.add(driver.findElements(By.partialLinkText("Printed Dre")).get(0));
			
			productList.add(driver.findElements(By.partialLinkText("Printed Dre")).get(1));
			
			productList.add(driver.findElements(By.partialLinkText("Printed Summer Dre")).get(0));
			
			productList.add(driver.findElements(By.partialLinkText("Printed Summer Dre")).get(1));
			
			productList.add(driver.findElement(By.xpath("//div[@class='right-block']//a[@class='product-name'][contains(text(),'Printed Chiffon Dress')]")));
			
    	}
    	catch(Exception e)
    	{
    		System.out.println("Products do not exist");
    	}
		
    	return productList.get(index);
    	
    }
    
    
    int quantity=2;
	final double shipping=2.00;
	double productCost, total;
	
	public void selectProductAndQuantity(int itemNum)
	{				
		driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]")).click();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)");
		   
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
			
		actions.moveToElement(getProduct(--itemNum)).build().perform();
		
	    driver.findElement(By.cssSelector(".hovered .quick-view > span")).click();
	    driver.switchTo().frame(0);
	   
	    String productCostString=driver.findElement(By.xpath("//span[@id='our_price_display']")).getText();    
	    productCost=convertToNumber(productCostString);
	   
	    driver.findElement(By.id("quantity_wanted")).clear();
	    driver.findElement(By.id("quantity_wanted")).sendKeys(Integer.toString(quantity));
	    
	    driver.findElement(By.cssSelector(".exclusive > span")).click();
	    driver.switchTo().defaultContent();
	    driver.findElement(By.cssSelector(".button-medium:nth-child(2) > span")).click();
	}
	
	//Converts amount text to double
	private double convertToNumber(String productCostString)
	{
		System.out.println("Product Cost :"+productCostString);
	    
		String pricetemp="";
		
		for (int i = 1; i < productCostString.length(); i++) 
		{
			pricetemp+=productCostString.charAt(i);	
		}
		
		//System.out.println(pricetemp);
		
		double prodCost=Double.parseDouble(pricetemp);
		
		//System.out.println(prodCost);
		
		return prodCost;
	}
	
    String totalCalculatedAmountStr, totalActualAmountStr, totalOnPaymentMethodPage;
	public void checkTransactionDetails()
	{
	    total=productCost*quantity+shipping;
	    
	    totalCalculatedAmountStr="$"+form.format(total);
	    
	    totalActualAmountStr=driver.findElement(By.xpath("//span[@id='total_price']")).getText();
	    
	    System.out.println(totalCalculatedAmountStr+"\t"+totalActualAmountStr);
	    
	    Assert.assertEquals(totalActualAmountStr, totalCalculatedAmountStr);			//Verify the total cost of product
	    
	    driver.findElement(By.xpath("//a[@class='button btn btn-default standard-checkout button-medium']//span[contains(text(),'Proceed to checkout')]")).click();

	    driver.findElement(By.xpath("//textarea[@name='message']")).sendKeys("Test Message");
	    
	    driver.findElement(By.xpath("//button[@name='processAddress']//span[contains(text(),'Proceed to checkout')]")).click();
	    
	    driver.findElement(By.id("cgv")).click();

	    driver.findElement(By.xpath("//button[@name='processCarrier']//span[contains(text(),'Proceed to checkout')]")).click();
	    
	    totalOnPaymentMethodPage=driver.findElement(By.xpath("//span[@id='total_price']")).getText();
	    
	    Assert.assertEquals(totalOnPaymentMethodPage, totalCalculatedAmountStr);
	    
	   	System.out.println("Check Txn Details completed");	
	}
	
	boolean bankwireMethod=false, chequeMethod=false;
	
	public void paymentMethod_BankWire()
	{
	    driver.findElement(By.xpath("//a[@class='bankwire']")).click();
	    
	    bankwireMethod=true;
	}
	
	public void paymentMethod_Cheque()
	{
	    driver.findElement(By.xpath("//a[@class='cheque']")).click();	
	    chequeMethod=true;
	}
	
	public String msg,content, referenceCode;
	
	public void placeOrder()
	{
		driver.findElement(By.xpath("//span[contains(text(),'I confirm my order')]")).click();
		
		if(bankwireMethod)
		{
			msg=driver.findElement(By.xpath("//strong[contains(text(),'Your order on My Store is complete.')]")).getText();
			
			Assert.assertEquals(msg, "Your order on My Store is complete.");	
			
			content=driver.findElement(By.xpath("//div[@class='box']")).getText();		
			
			//System.out.println(content);
			
			String[] strs=content.split("-");
			
			//System.out.println(strs[5]);
			
			referenceCode=strs[5].substring(46, 55);
			
			System.out.println(referenceCode);
			
			System.out.println(Pattern.compile("([A-Z]){9}").matcher(referenceCode).find());
			
		}
		
		if(chequeMethod)
		{
			msg=driver.findElement(By.xpath("//h3[@class='page-subheading']")).getText();
			
			Assert.assertEquals(msg, "YOUR CHECK MUST INCLUDE:");	
			
			content=driver.findElement(By.xpath("//div[@class='box order-confirmation']")).getText();
			
			//System.out.println(content);
			
			String[] strs2=content.split("-");
			
			referenceCode=strs2[4].substring(47, 56);
			
			System.out.println(referenceCode);
			
			System.out.println(Pattern.compile("([A-Z]){9}").matcher(referenceCode).find());	
		}
		
	}
	
	public void verifyOrderDetails()
	{
		
		driver.findElement(By.xpath("//a[@class='account']")).click();
		
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
		
		driver.findElement(By.xpath("//span[contains(text(),'Order history and details')]")).click();
		
		/*
		List<WebElement> col=driver.findElements(By.xpath("//table[@id='order-list']//thead//tr/th"));
		
		for(WebElement s:col)
		{
			System.out.println(s.getText());
		}
		*/
		
		List<WebElement> rows=driver.findElements(By.xpath("//table[@id='order-list']//tbody//tr"));
		
		/*	
		for(WebElement r:rows)
		{
			System.out.println(r.getText());
		}
	 	*/	
		
		//System.out.println(rows.size());
		
		String orderReference,totalPriceStr;
		
		for (int i = 1; i <= rows.size(); i++) 
		{
			orderReference=driver.findElement(By.xpath("//table[@id='order-list']//tbody//tr["+i+"]//td[1]")).getText();
			
			if(orderReference.equalsIgnoreCase(referenceCode))
			{
				totalPriceStr=driver.findElement(By.xpath("//table[@id='order-list']//tbody//tr["+i+"]//td[3]")).getText();
				
				Assert.assertEquals(totalPriceStr, totalCalculatedAmountStr);
			}

		}
		
		System.out.println("Order Details Verified");
	}
	
	
	public static void main(String[] args) 
	{
		BuyProduct obj=new BuyProduct();
		
		obj.setupLoginData(6);
		
		obj.startApplication();
		
		obj.enterLoginDetailsAndSubmit();
				
		obj.selectProductAndQuantity(1);
		
		obj.checkTransactionDetails();
		
		//obj.paymentMethod_BankWire();
		
		obj.paymentMethod_Cheque();
				
		obj.placeOrder();
		
		obj.verifyOrderDetails();
		
		System.out.println("Test Buy Product Complete");
	}

}

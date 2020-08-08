package com.yourlogo.buyproduct;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

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
	DecimalFormat form;
	Actions actions;
	
	public BuyProduct()
	{
		buyProd=new TestData();
		form=new DecimalFormat("#00.00");
		actions=new Actions(driver);
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
	
	
    WebElement sleeveTshirt, blouse, printedChiffonDress;
    List<WebElement> printedDresses, printedSummerDresses;
    public void products()
    {
    	sleeveTshirt=driver.findElement(By.xpath("//a[contains(text(),'Faded Short Sleeve T-shirts')]"));
		
		blouse=driver.findElement(By.xpath("//div[@class='right-block']//a[@class='product-name'][contains(text(),'Blouse')]"));
		
		printedDresses=driver.findElements(By.partialLinkText("Printed Dre"));
		
		printedSummerDresses=driver.findElements(By.partialLinkText("Printed Summer Dre"));
		
		printedChiffonDress=driver.findElement(By.xpath("//div[@class='right-block']//a[@class='product-name'][contains(text(),'Printed Chiffon Dress')]"));
    }
    
    
    int quantity=2;
	final double shipping=2;
	double productCost, total;
	
	public void selectProductAndQuantity()
	{				
		driver.findElement(By.xpath("//a[@class='sf-with-ul'][contains(text(),'Women')]")).click();
		
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("window.scrollBy(0,1000)");
		   
		try {Thread.sleep(5000);} catch (InterruptedException e) {e.printStackTrace();}
		
		products();
		
		actions.moveToElement(printedSummerDresses.get(1)).build().perform();
		
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
		//referenceCode="WYGJIUHAX";
		//totalCalculatedAmountStr="$35.02";
		
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
		
		System.out.println("Verified");
	}
	
	
	public static void main(String[] args) 
	{
		BuyProduct obj=new BuyProduct();
		
		obj.setupLoginData(5);
		
		obj.login();
		
		obj.selectProductAndQuantity();
		
		obj.checkTransactionDetails();
		
		//obj.paymentMethod_BankWire();
		
		obj.paymentMethod_Cheque();
				
		obj.placeOrder();
		
		obj.verifyOrderDetails();
		
		System.out.println("Test Buy Product Complete");
	}

}

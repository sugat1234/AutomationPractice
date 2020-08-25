package com.yourlogo.testdata;

import java.io.IOException;
import java.util.HashMap;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TestData 
{
	XSSFWorkbook book;
	XSSFSheet sheet;
	XSSFCell fieldValue, fieldName;
	HashMap<String, String> data1,data2;

	public TestData()
	{
		try 
		{
			book =new XSSFWorkbook("C:\\Users\\sugat\\eclipse-workspace\\AutomationPractice\\src\\main\\java\\com\\yourlogo\\testdata\\TestDataYourLogo.xlsx");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
		
		data1=new HashMap<String, String>();
		
		data2=new HashMap<String, String>();
	}
	
	public void setRegistrationData(int colNum)
	{
		sheet=book.getSheet("Registration_Formatted");
		
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) 
		{
			fieldName=sheet.getRow(i).getCell(0);
			
			fieldValue=sheet.getRow(i).getCell(colNum);
			
			data1.put(fieldName.getStringCellValue(), fieldValue.getStringCellValue());
			
		//	System.out.println(fieldName.getStringCellValue()+"\t"+fieldValue.getStringCellValue());
		}
		
	}
	
	public HashMap<String, String> getRegistrationData(int colNum)
	{
		setRegistrationData(colNum);
		
		return data1;
		
	}
	
	
	public void setLoginData(int colNum)
	{
		sheet=book.getSheet("Login_Formatted");
		
		for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) 
		{
			fieldName=sheet.getRow(i).getCell(0);
			
			fieldValue=sheet.getRow(i).getCell(colNum);
			
			data2.put(fieldName.getStringCellValue(), fieldValue.getStringCellValue());
			
			//System.out.println(fieldName.getStringCellValue()+"\t"+fieldValue.getStringCellValue());
		}
		
	}
	
	public HashMap<String, String> getLoginData(int colNum)
	{
		setLoginData(colNum);
		
		return data2;
		
	}
	
	public static void main(String[] args) 
	{
		TestData obj=new TestData();
		
		obj.setLoginData(3);
	
		
		HashMap<String, String> testData=obj.getLoginData(1);
		
		Iterable<String> keys=testData.keySet();
		
		for(String k:keys)
		{
			System.out.println(k);
		}
		
		Iterable<String> values=testData.values();
		
		for(String v:values)
		{
			System.out.println(v);
		}
		
	
		System.exit(0);
		
	}

}

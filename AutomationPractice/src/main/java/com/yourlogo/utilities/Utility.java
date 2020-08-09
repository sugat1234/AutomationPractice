package com.yourlogo.utilities;

import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.yourlogo.base.Setup;

import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;

public class Utility extends Setup
{
	public static void takeScreenshot(String moduleName, String testName)
	{
		File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		String filePath="C:\\Users\\sugat\\git\\AutomationPractice\\AutomationPractice\\src\\test\\java\\com\\yourlogo\\screenshots\\";
		
		try 
		{
			FileUtils.copyFile(scrFile, new File(filePath+moduleName+"-"+testName+".png"));
		} catch (IOException e) {e.printStackTrace();}
	}
	
	
	public static void takeFullPageScreenshot(String moduleName, String testName)
	{
		Screenshot screenshot=new AShot().shootingStrategy(ShootingStrategies.viewportPasting(1000)).takeScreenshot(driver);             

		String filePath="C:\\Users\\sugat\\git\\AutomationPractice\\AutomationPractice\\src\\test\\java\\com\\yourlogo\\screenshots\\";
		
		try { ImageIO.write(screenshot.getImage(),"PNG",new File(filePath+moduleName+"-"+testName+".png"));             
		} catch (IOException e) {e.printStackTrace();} 
	}

}

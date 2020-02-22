package utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.Test_Base;

public class Utility extends Test_Base
{
	 WebDriver driver;
	public Utility(WebDriver driver)
	{
		this.driver=driver;
	}
public  void TakeSnapShot(String TastCaseName) throws IOException
{
	TakesScreenshot scr = (TakesScreenshot)driver;
	File src = scr.getScreenshotAs(OutputType.FILE);
	File desc = new File("C:\\Users\\Arijit Ghosh\\eclipse-workspace\\TestAutomationPractice\\FailedScreenShot\\snap.jpeg");
	FileUtils.copyFile(src, desc);
	
}

}

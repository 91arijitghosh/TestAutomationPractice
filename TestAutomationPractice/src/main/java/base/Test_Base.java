package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class Test_Base 
{
	public static WebDriver driver;
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports reporter;
	public ExtentTest logger;
	public static Properties prop;
	
	
	public static void setup(String URL, String Browsername) throws IOException
	{   
		prop = new Properties();
		   try {
			FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\param.properties");
		    prop.load(fis);
		   } catch (FileNotFoundException e) {
			System.out.println("File is not visible");
		   } 
		   if(Browsername.equalsIgnoreCase("chrome"))
		   {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+prop.getProperty("ChromeDriverPath"));
	    driver = new ChromeDriver();
		   }else if (Browsername.equals("firefox"))
		   {
			   //System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+prop.getProperty("ChromeDriverPath"));
			    driver = new FirefoxDriver(); 
		   }
	    driver.manage().window().maximize();
	    driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    driver.get(URL);
	    
	    htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+prop.getProperty("ReportPath"));
	    reporter = new ExtentReports();
	    reporter.attachReporter(htmlReporter);
	    
	}
	public void teardown()
	{
		driver.quit();
	}

}

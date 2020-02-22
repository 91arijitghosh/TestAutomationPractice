package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.MediaEntityBuilder;

import base.Test_Base;
import pages.HomePage;
import pages.Login_Page;
import pages.UserHomePage;
import utilities.Utility;

public class SearchDress extends Test_Base 
{
	HomePage hpage;
	Login_Page lpage;
	UserHomePage Uhpage;
	int expected;
	int actual;
	Utility obj;
	String TastCaseName = "SearchDress";
	String Screenpath;
	String Browsername;
	String url;
	

  //@Parameters({"url","Browsername"})
  @BeforeMethod
 // public void launch(String url, String Browsername) throws IOException
  public void launch() throws IOException
  {
	  url = System.getProperty("url");  
	  //url = "http://automationpractice.com/index.php";
	  Browsername = System.getProperty("Browsername");
	  //String Browsername = "chrome";
	  setup(url, Browsername);
	  Screenpath = System.getProperty("user.dir")+prop.getProperty("ScreenShotPath");
	  logger = reporter.createTest(TastCaseName);
	  obj = new Utility(driver);
  }
  @Test
  public void searchDress() throws AWTException
  {
	  
	  
	  logger.info("HomePage Launched");
	  hpage = new HomePage(driver);
	  
	  hpage.navigate_to_SignIn();
	  logger.info("Navigated to sign in Page");
	  
	  lpage = new Login_Page(driver, prop);
	  lpage.LogIn_to_existingAcc();
	  logger.info("User Logged In");
	  
	  Uhpage = new UserHomePage(driver);
	  Uhpage.search_Products();
	  logger.info("Product Searched");
	  
	  expected = Uhpage.search_resultCount();
	  actual = Uhpage.verify_ProductSearch();
	  reporter.flush();
	  
	  Assert.assertEquals(actual, expected);
	  
  }
  @AfterMethod(alwaysRun = true)
  public void Logging(ITestResult result) throws IOException
  {
	  
		/*
		 * if(result.getStatus()==ITestResult.FAILURE) {
		 * logger.fail("Following Test Case failed: "+TastCaseName);
		 * obj.TakeSnapShot(TastCaseName); logger.info("Taking ScreenShot",
		 * MediaEntityBuilder.createScreenCaptureFromPath(Screenpath).build());
		 * logger.info(result.getThrowable());
		 * 
		 * }else if(result.getStatus()==ITestResult.SUCCESS) {
		 * logger.pass("Following Test Case passed: "+TastCaseName);
		 * obj.TakeSnapShot(TastCaseName); logger.info("Taking ScreenShot",
		 * MediaEntityBuilder.createScreenCaptureFromPath(Screenpath).build()); }else
		 * if(result.getStatus()==ITestResult.SKIP) { logger.skip("Test Case skipped");
		 * logger.info(result.getThrowable()); }else { System.out.println("error");
		 * //logger.info("Some error occurred"); } reporter.flush();
		 */
  }
}

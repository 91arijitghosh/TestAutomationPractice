package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Test_Base;
import pages.HomePage;
import pages.Login_Page;
import pages.UserHomePage;

public class Buy_Product extends Test_Base{
  
	HomePage hpage;
	Login_Page lpage;
	UserHomePage Uhpage;
	String expected;
	String actual;
	
  @Parameters({"url","BrowserName"})	
  @Test
  public void searchDress(String url, String BrowserName) throws AWTException, IOException 
  {
	  setup(url, BrowserName);
	  hpage = new HomePage(driver);
	  hpage.navigate_to_SignIn();
	  lpage = new Login_Page(driver,prop);
	  lpage.LogIn_to_existingAcc();
	  Uhpage = new UserHomePage(driver);
	  Uhpage.search_Products();
	  actual = Uhpage.Buy_product();
	  expected = Uhpage.returnConfirmation();
	  
	  Assert.assertEquals(actual, expected);
	  
	  }
}

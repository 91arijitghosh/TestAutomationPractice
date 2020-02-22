package testCases;
import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Test_Base;
import pages.HomePage;
import pages.Login_Page;
import pages.UserHomePage;

public class DownloadInvoice extends Test_Base
{
	HomePage hpage;
	Login_Page lpage;
	UserHomePage Uhpage;
	
  @Parameters({"url","BrowserName"})
  @Test
  public void DownloadPDFInvoice(String url, String BrowserName) throws AWTException, IOException 
  {
	  setup(url, BrowserName);
	  hpage = new HomePage(driver);
	  hpage.navigate_to_SignIn();
	  
	  lpage = new Login_Page(driver,prop);
	  lpage.LogIn_to_existingAcc();
	  
	  Uhpage = new UserHomePage(driver);
	  Uhpage.Download_invoice();
  }
}

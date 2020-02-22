package testCases;

import java.awt.AWTException;
import java.io.IOException;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import base.Test_Base;
import pages.Create_New_Account_Page;
import pages.HomePage;
import pages.Login_Page;

public class CreateNewUser extends Test_Base {
 
	Create_New_Account_Page newPage;
	HomePage hpage;
	Login_Page lpage;
  
  @Parameters({"url","BrowserName"})
  @Test
  public void CreateAccount(String url, String BrowserName) throws AWTException, IOException 
  {
	  setup(url,BrowserName);
	  hpage = new HomePage(driver);
	  hpage.navigate_to_SignIn();
	  
	  lpage = new Login_Page(driver,prop);
	  lpage.Create_new_account();
	  
	  newPage = new Create_New_Account_Page(driver);
	  newPage.Create_New_User_Form();
  }
}

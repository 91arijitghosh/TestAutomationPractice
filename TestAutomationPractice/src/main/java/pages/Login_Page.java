package pages;

import java.awt.AWTException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;
import reuseables.KeyboardEvent;

public class Login_Page extends Test_Base
{
	   @FindBy(xpath="//input[@id='email_create']")
	   @CacheLookup
	   WebElement EmailNewAccount;
	   
	   @FindBy(xpath="//button[@id='SubmitCreate']")
	   @CacheLookup
	   WebElement CreateAccBtn;
	   
	   @FindBy(xpath="//input[@id='email']")
	   @CacheLookup
	   WebElement UserID;
	   
	   @FindBy(xpath="//input[@id='passwd']")
	   @CacheLookup
	   WebElement Password;
	   
	   @FindBy(xpath="//button[@name='SubmitLogin']")
	   @CacheLookup
	   WebElement SignInBtn;
	   
	   public Login_Page (WebDriver driver,Properties prop)
	   {
		   this.driver = driver;
		   this.prop = prop;
		   PageFactory.initElements(driver, this);
	   }
	   
	   public void Create_new_account() throws AWTException
	   {
		   EmailNewAccount.click();
		   EmailNewAccount.sendKeys(prop.getProperty("UserName"));
		   KeyboardEvent.press_tab();
		   CreateAccBtn.click();
	   }
	   
	   public void LogIn_to_existingAcc() throws AWTException
	   {
		   UserID.click();
		   UserID.sendKeys(prop.getProperty("UserName"));
		   KeyboardEvent.press_tab();
		   Password.click();
		   Password.sendKeys(prop.getProperty("Password"));
		   KeyboardEvent.press_tab();
		   SignInBtn.click();
	   }
	   
	   
	   
}

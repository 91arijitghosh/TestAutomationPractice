package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;

public class HomePage extends Test_Base
{
   @FindBy(xpath="//a[@class='login']")
   @CacheLookup
   WebElement loginButton;
   
   @FindBy(xpath="//input[@name='search_query']")
   @CacheLookup
   WebElement SearchBar;
   
   @FindBy(xpath="//button[@name='submit_search']")
   @CacheLookup
   WebElement SearchIcon;
   
   public HomePage(WebDriver driver)
   {
	   this.driver=driver;
	   PageFactory.initElements(driver, this);
   }
   public void navigate_to_SignIn()
   {
	   loginButton.click();
   }
}

package pages;

import java.awt.AWTException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;
import reuseables.ActionClass;
import reuseables.KeyboardEvent;

public class Create_New_Account_Page extends Test_Base
{  
	Actions act;
  
	@FindBy(xpath="//input[@id='id_gender1']")
	@CacheLookup
	WebElement Title;
	
	@FindBy(xpath="//input[@id='customer_firstname']")
	@CacheLookup
	WebElement FirstName;

	@FindBy(xpath="//input[@id='customer_lastname']")
	@CacheLookup
	WebElement LastName;
	
	@FindBy(xpath="//input[@id='passwd']")
	@CacheLookup
	WebElement Password;
	
	@FindBy(xpath="//select[@id='days']")
	@CacheLookup
	WebElement BirthDate;
	
	@FindBy(xpath="//select[@id='months']")
	@CacheLookup
	WebElement BirthMonth;
	
	@FindBy(xpath="//select[@id='years']")
	@CacheLookup
	WebElement BirthYear;
	
	@FindBy(xpath="//input[@id='firstname']")
	@CacheLookup
	WebElement AddressFirstName;
	
	@FindBy(xpath="//input[@id='lastname']")
	@CacheLookup
	WebElement AddressLastName;
	
	@FindBy(xpath="//input[@id='address1']")
	@CacheLookup
	WebElement Address;
	
	@FindBy(xpath="//input[@id='city']")
	@CacheLookup
	WebElement City;
	
	@FindBy(xpath="//select[@id='id_state']")
	@CacheLookup
	WebElement State;
	
	@FindBy(xpath="//input[@id='postcode']")
	@CacheLookup
	WebElement ZipCode;
	
	@FindBy(xpath="//select[@id='id_country']")
	@CacheLookup
	WebElement Country;
	
	@FindBy(xpath="//input[@id='phone_mobile']")
	@CacheLookup
	WebElement MobilePhone;
	
	@FindBy(xpath="//input[@id='alias']")
	@CacheLookup
	WebElement AddressRef;
	
	@FindBy(xpath="//button[@id='submitAccount']")
	@CacheLookup
	WebElement RegisterButton;
	
	public Create_New_Account_Page(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void Create_New_User_Form() throws AWTException
	{
		 act = new Actions(driver);
		
		Title.click();
		
		act.moveToElement(FirstName).click(FirstName).sendKeys("Arijit").moveByOffset(10, 0).click().build().perform();
		act.moveToElement(LastName).click(LastName).sendKeys("Ghosh").moveByOffset(10, 0).click().build().perform();
		
		Password.click();
		Password.sendKeys("Demo@1234#");
		KeyboardEvent.press_tab();
		
		ActionClass.selectByValue(BirthDate, "10");
		ActionClass.selectByValue(BirthMonth, "6");
		ActionClass.selectByValue(BirthYear, "1991");
		
		Address.click();
		Address.sendKeys("28, RockFordLane");
		KeyboardEvent.press_tab();
		
		City.click();
		City.sendKeys("NewTown");
		KeyboardEvent.press_tab();
		
		ActionClass.selectByValue(State, "16");
		
		ZipCode.click();
		ZipCode.sendKeys("12345");
		
		MobilePhone.click();
		MobilePhone.sendKeys("0987654321");
		KeyboardEvent.press_tab();
		
		AddressRef.click();
		AddressRef.sendKeys("DemoAlies");
		KeyboardEvent.press_tab();
		
		RegisterButton.click();
		
	}
}

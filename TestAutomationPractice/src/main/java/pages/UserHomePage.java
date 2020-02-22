package pages;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Test_Base;

public class UserHomePage extends Test_Base
{
	int ExpectedResultCount = 0;
	int ActualResultCount = 0;
	String ExpectedConfirmation="Your order on My Store is complete";
	Actions act;
	Set<String> windows;
	
	@FindBy(xpath="//input[@name='search_query']")
	@CacheLookup
	WebElement SearchBar;
	
	@FindBy(xpath="//button[@name='submit_search']")
	@CacheLookup
	WebElement SearchIcon;

	@FindBy(xpath="//ul[@class='product_list grid row']//h5")
	@CacheLookup
	List<WebElement> SearchResults;
	
	@FindBy(xpath="(//ul[@class='product_list grid row']//h5)[3]")
	@CacheLookup
	WebElement desiredProduct;
	
	@FindBy(xpath="(span[text()='Add to cart'])[3]")
	@CacheLookup
	WebElement AddToCart;
	
	@FindBy(xpath="//a[@title='Proceed to checkout]")
	@CacheLookup
	WebElement checkout;
	
	@FindBy(xpath="(//a[@title='Proceed to checkout])[2]")
	@CacheLookup
	WebElement checkout2;
	
	@FindBy(xpath="//button[@name='processAddress]")
	@CacheLookup
	WebElement ProcessAddress;
	
	@FindBy(xpath="//input[@name='cgv']")
	@CacheLookup
	WebElement TarmsCd;
	
	@FindBy(xpath="//button[@name='processCarrier']")
	@CacheLookup
	WebElement ProcessCarrier;
	
	@FindBy(xpath="//a[@class='cheque']")
	@CacheLookup
	WebElement PayByCheck;
	
	@FindBy(xpath="//span[text()='I confirm my order']")
	@CacheLookup
	WebElement OrderConfirmation;
	
	@FindBy(xpath="//p[@class='alert alert-success']")
	@CacheLookup
	WebElement confirmationMessage;
	
	@FindBy(xpath="//a[@title='Orders']")
	@CacheLookup
	WebElement Orderhistory;
	
	@FindBy(xpath="//a[@title='Invoice']")
	@CacheLookup
	WebElement InvoiceLink;
	
	@FindBy(xpath="//a[@class='button']")
	@CacheLookup
	WebElement DownloadBtn;
	
	@FindBy(xpath="//i[@class='fa fa-download']")
	@CacheLookup
	WebElement DownloadConf;
	
	public UserHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		act = new Actions(driver);
	}
	public void Download_invoice()
	{
		Orderhistory.click();
		InvoiceLink.click();
		windows = driver.getWindowHandles();
		for(String newTab : windows)
		{
			driver.switchTo().window(newTab);
		}
		DownloadBtn.click();
		DownloadConf.click();
	}
	public void search_Products()
	{
		SearchBar.click();
		SearchBar.sendKeys("Dress");
		SearchIcon.click();
	}
	public String Buy_product()
	{
		act.moveToElement(desiredProduct).moveToElement(AddToCart).click().build().perform();
		checkout.click();
		checkout2.click();
		ProcessAddress.click();
		TarmsCd.click();
		ProcessCarrier.click();
		PayByCheck.click();
		OrderConfirmation.click();
		String Message = confirmationMessage.getText();
		return Message;
	}
	public String returnConfirmation()
	{
		return ExpectedConfirmation;
	}
	public int search_resultCount()
	{
		ExpectedResultCount = SearchResults.size();
		return ExpectedResultCount;
	}
	public int verify_ProductSearch()
	{
		for(WebElement ref : SearchResults)
		{
			if(ref.getText().contains("Dress"))
			{
				ActualResultCount++;
			}
		}
		return ActualResultCount;
	}

}

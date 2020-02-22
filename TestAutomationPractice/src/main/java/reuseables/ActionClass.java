package reuseables;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class ActionClass 
{
	static Actions act;
	static Select drop;
	
	public static void selectByValue(WebElement ele, String Value)
	{
		drop = new Select(ele);
		drop.selectByValue(Value);
	}

}

package reuseables;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

public class KeyboardEvent 
{
	static Robot rb;
	
	public static void press_tab() throws AWTException
	{
		rb = new Robot();
	    rb.keyPress(KeyEvent.VK_TAB);
	    rb.keyRelease(KeyEvent.VK_TAB);
	}

}

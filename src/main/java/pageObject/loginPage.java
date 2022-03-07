package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class loginPage {
	
	public WebDriver driver;
	//creating a page object for the sign in page
	By email = By.cssSelector("input[name='user[email]']");
	By passwrd = By.cssSelector("input[name='user[password]']");
	By submit = By.cssSelector("input[type='submit']");
	
	public loginPage(WebDriver driver) {
		// driver object is assigned to the above driver variable
		this.driver = driver;

	}

	public WebElement getemail() 
	{
		return driver.findElement(email);
	}
	public WebElement getpass() 
	{
		return driver.findElement(passwrd);
	}
	public WebElement submitButton() 
	{
		return driver.findElement(submit);
	}

}

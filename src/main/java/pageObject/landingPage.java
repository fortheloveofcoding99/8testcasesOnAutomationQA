package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class landingPage {
	
	public WebDriver driver;
	//creating a page object for https://courses.ultimateqa.com/users/sign_in
	By signIn = By.linkText("Login automation");
	By text1 = By.id("Get_Latest_Blog_Posts");
	By head = By.xpath("//header/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[2]");
	By footer = By.id("footer-info");
	By sidebar = By.xpath("//body/div[2]");
	By subscrib = By.xpath("//button[contains(text(),'Subscribe')]");
	
	public landingPage(WebDriver driver) {
		// driver object is assigned to the above driver variable
		this.driver = driver;

	}

	public WebElement getLogin() 
	{
		return driver.findElement(signIn);
	}
	
	public WebElement textCheck()
	{
		return driver.findElement(text1);	
	}
	public WebElement header()
	{
		return driver.findElement(head);	
	}
	public WebElement footerCheck()
	{
		return driver.findElement(footer);
	}
	public WebElement sidebarCheck()
	{
		return driver.findElement(sidebar);
	}
	public WebElement subscribeCheck()
	{
		return driver.findElement(subscrib);
	}

}

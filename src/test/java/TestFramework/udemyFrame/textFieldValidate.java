package TestFramework.udemyFrame;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.landingPage;
import resources.base;

public class textFieldValidate extends base{
	
	public WebDriver driver;
	
	@BeforeTest
	public void initialize() throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
	}
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	@Test
	public void homepage() throws IOException {
		
		System.out.println(driver.getTitle());
		//calling object of the landing page class
		
		landingPage lp = new landingPage(driver);
		String actual = lp.textCheck().getText();
		String expected = "Get Latest Blog Posts";
		Assert.assertEquals(actual, expected);
		
		
	}
	@Test
	public void homepage1() {
		
		landingPage lp = new landingPage(driver);
		String actual = lp.footerCheck().getText();
		String exp = "© NextLevel Solutions USA, LLC";
		Assert.assertEquals(actual, exp);
	}
	
	@Test
	public void subscribe() {
		
		landingPage lp = new landingPage(driver);
		WebElement button = lp.subscribeCheck();
		Assert.assertTrue(button.isEnabled());
		
	}
	
	
}

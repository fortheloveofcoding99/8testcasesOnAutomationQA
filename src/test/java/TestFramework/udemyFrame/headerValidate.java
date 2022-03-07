package TestFramework.udemyFrame;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.landingPage;
import resources.base;

public class headerValidate extends base{
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
		Assert.assertTrue(lp.header().isDisplayed());
				
	}
	@Test
	public void homepage1() {
		landingPage lp = new landingPage(driver);
		Assert.assertTrue(lp.footerCheck().isDisplayed());
	}
	
}

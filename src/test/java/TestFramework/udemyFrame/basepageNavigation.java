package TestFramework.udemyFrame;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.landingPage;
import pageObject.loginPage;
import resources.base;

public class basepageNavigation extends base{
	public WebDriver driver;
	@Test (dataProvider = "getData")
	public void homepage(String email, String Password, String text) throws IOException {
		driver = initializeDriver();
		driver.get(prop.getProperty("url"));
		System.out.println(driver.getTitle());
		//calling object of the landing page class
		
		landingPage lp = new landingPage(driver);
		lp.getLogin().click();
		loginPage lop = new loginPage(driver);
		lop.getemail().sendKeys(email);
		lop.getpass().sendKeys(Password);
		System.out.println(text);
		lop.submitButton().click();
				
	}
		
	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		//Row stands for how many different data types should run
		//Column stands for how many values per each test
		Object[][] data = new Object[2][3];
		//0th row 
		data[1][0] = "abc@gmail.com";
		data[1][1] = "Password@123";
		data[1][2] = "DOnt have an account register";
		
		data[0][0] = "abcd@gmai.com";
		data[0][1] = "Pass@123";
		data[0][2] = "Registered User";
		
		
		
		return data;
	}
}

package TestFramework.udemyFrame;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import resources.base;

public class brokenLinks extends base{
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
	public void checkBrokenLinks() {
		
		String url = "";
		HttpURLConnection huc = null;
		int respCode = 200;
		List<WebElement> links = driver.findElements(By.tagName("a"));
		
		Iterator<WebElement> it = links.iterator();
		while(it.hasNext()) {
			url = it.next().getAttribute("href");
			if (url == null || url.isEmpty()){
				System.out.println("URL is either not configured for anchor tag or it is empty");
				continue;
			}
			
			try {
				huc = (HttpURLConnection)(new URL(url).openConnection());
				huc.setRequestMethod("HEAD");
				huc.connect();
				respCode = huc.getResponseCode();
				if(respCode >= 400){
					System.out.println(url+" is a broken link");
					}
					else{
					System.out.println(url+" is a valid link");
					}
			}
				catch (MalformedURLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					}
			}
		
		}
	
	}



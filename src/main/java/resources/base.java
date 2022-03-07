package resources;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;


public class base {
	
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {
		//invoking the browser drivers
		prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\befor\\eclipse-workspace\\udemyFrame\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
		System.out.println(browserName);
		if(browserName.contains("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C://Users//befor//New folder//chromedriver.exe");
			ChromeOptions options = new ChromeOptions();
			if (browserName.contains("headless")) {
			options.addArguments("headless");
			}
			driver = new ChromeDriver(options);
		}
		else if(browserName.equals("firefox"))
		{
			
		}
		else if(browserName.equals("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C://Users//befor//New folder//msedgedriver.exe");
			driver = new EdgeDriver();
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		return driver;
	}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
		
		TakesScreenshot tks = (TakesScreenshot)driver;
		File source = tks.getScreenshotAs(OutputType.FILE);
		String destfile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source,new File(destfile));
		return destfile;
		
	}
}

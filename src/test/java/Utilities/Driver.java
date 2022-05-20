package Utilities;

import org.testng.annotations.AfterMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	public static WebDriver driver;

	public static WebDriver getDriver() {

		if (driver == null) {

			switch (ConfigurationProperties.getProperty("browser")) {

			case "firefox":

				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "Chrome":

				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				break;

			case "safari":

				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;

			case "headless":

				// headless Driver
				break;

			}

		//	driver.get("https://www.techcircleschool.com");
			
			driver.get("http://practice.automationtesting.in/");

		}

		return driver;
	}
	
	
	//close/quit browser
	@AfterMethod
	public static void tearDown() {
		
		if(driver != null) {
			driver.close();
			
		}
		
	}
	
	
	
	
	
	
	
	
	

}

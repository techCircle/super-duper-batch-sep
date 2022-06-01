package MeenaUtilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class MeenaDriver {

	
public static WebDriver driver;
	
	public static WebDriver getDriver() {
		
		if(driver==null) {
			
			//switch("Chrome") {
			
			switch(MeenaDriver.getProperty("browser")) {
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(MeenaDriver.getProperty("url"));
			    driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(MeenaConstants.implicitWaitTime, TimeUnit.SECONDS);
				break;
				
			case "Chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(MeenaDriver.getProperty("url"));
			    driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(MeenaConstants.implicitWaitTime, TimeUnit.SECONDS);
				break;
			
			case "Safari":
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				driver.get(MeenaDriver.getProperty("url"));
			    driver.manage().window().maximize();
	            driver.manage().timeouts().implicitlyWait(MeenaConstants.implicitWaitTime, TimeUnit.SECONDS);
				break;
				
			case "Headless":
				// headless Driver
				break;
			
			
			}
			
	
	}
		return driver;	
	
	}
	//close or quit driver
	public static void tearDown() {
		
		if(driver != null) {
			
			driver.close();
		}
		
	}	
	
	
	//			  properties file
	public static Properties configfile;
	
	

	// example.
	// public static WebDriver driver;

	static {

		try {
			String path = MeenaConstants.config_filePath;
			FileInputStream input = new FileInputStream(path);

			configfile = new Properties();
			configfile.load(input);

			input.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getProperty(String keyName) {

		return configfile.getProperty(keyName);
	}

	
	
	
	
	
}

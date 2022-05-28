package Emmie_Utilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Utilities.ConfigurationProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
	public static WebDriver driver;

	public static WebDriver getDriver() {

		if (driver == null) {

			switch (ConfigurationProperties.getProperty("browser")) {

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				break;

			case "Chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				break;

			case "safari":
//				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

				break;

			case "headless":
				// headless Driver
				break;
			}

			// driver.get("https://www.google.com/");
			driver.get(ConfigurationProperties.getProperty("url"));

		}

		return driver;
	}

	// close or quit the browser
	public static void tearDown() {
		if (driver != null) {
			driver.close();
		}

	}


}

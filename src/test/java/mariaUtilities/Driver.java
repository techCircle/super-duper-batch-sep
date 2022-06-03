package mariaUtilities;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
//changes to push
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
				Driver.getDriver().manage().window().maximize();
				Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				break;

			case "safari":

				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				break;

			case "headless":

				// headless Driver
				break;

			}
			//driver.get(ConfigurationProperties.getProperty("swaglabUrl"));

			// driver.get("https://www.techcircleschool.com/");

			driver.get(ConfigurationProperties.getProperty("url"));
		
		}

		return driver;
	}

	// close/quit browser
public static void tearDown() {
		
		if(driver != null) {
			driver.close();
			
		}
		
	}
}


package Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {

	public WebDriver driver;

	public WebDriver getDriver() {

		if (driver == null) {

			switch ("Chrome") {

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

		}

		return driver;
	}

}

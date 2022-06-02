package SeleniumDay_11;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;

public class ParallelTesting {

	@Test
	public void parallelFirefox() {
		WebDriverManager.firefoxdriver().setup();

		WebDriver driver = new FirefoxDriver();

		// This method will maximize the browser before route to the url
		driver.manage().window().maximize();

		// get method will take you the URL you have given.
		driver.get("https://www.google.com");

	}

	@Test
	public void parallelChrome() {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		// This method will maximize the browser before route to the url
		driver.manage().window().maximize();

		// get method will take you the URL you have given.
		driver.get("https://www.google.com");
	}

}

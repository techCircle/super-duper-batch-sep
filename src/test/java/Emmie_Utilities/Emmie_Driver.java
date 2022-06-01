package Emmie_Utilities;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;


import io.github.bonigarcia.wdm.WebDriverManager;

public class Driver {
	
	public static WebDriver driver;

	public static WebDriver getDriver() {

		if (driver == null) {

			switch (Driver.getProperty("browser")) {

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(Driver.getProperty("url"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Constants.implicitWaitTime, TimeUnit.SECONDS);
				break;

			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(Driver.getProperty("url"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Constants.implicitWaitTime, TimeUnit.SECONDS);

				break;

			case "safari":
//				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				driver.get(Driver.getProperty("url"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Constants.implicitWaitTime, TimeUnit.SECONDS);

				break;

			case "headless":
				// headless Driver
				break;
			}

		}

		return driver;
	}

	public static void getCurrentUrl() {
		System.out.println("CURRENT URL : " + Driver.getDriver().getCurrentUrl());
	}

	public static void clickProductFromList(List<WebElement> list, String str) {

		for (WebElement products : list) {
			String productList = products.getText();
			if (productList.contains(Driver.getProperty(str))) {
				products.click();
				break;
			}
		}

	}

	public static double getDouble(WebElement element) {
		return Double.parseDouble(element.getText().substring(1));

	}

	public static void navigateBack() {
		Driver.getDriver().navigate().back();
	}

	// close or quit the browser
	public static void tearDown() {
		if (driver != null) {
			driver.close();

			driver = null;
		}

	}

	// configReaderClass
	private static Properties configFile;

	static {

		try {
			String filePath = Constants.config_filePath;

			FileInputStream input = new FileInputStream(filePath);

			configFile = new Properties();
			configFile.load(input);

			input.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static String getProperty(String keyName) {
		return configFile.getProperty(keyName);
	}
}

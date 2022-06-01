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

public class Emmie_Driver {
	
	public static WebDriver driver;

	public static WebDriver getDriver() {

		if (driver == null) {

			switch (Emmie_Driver.getProperty("browser")) {

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(Emmie_Driver.getProperty("url"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Emmie_Constants.implicitWaitTime, TimeUnit.SECONDS);
				break;

			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(Emmie_Driver.getProperty("url"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Emmie_Constants.implicitWaitTime, TimeUnit.SECONDS);

				break;

			case "safari":
//				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				driver.get(Emmie_Driver.getProperty("url"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Emmie_Constants.implicitWaitTime, TimeUnit.SECONDS);

				break;

			case "headless":
				// headless Driver
				break;
			}

		}

		return driver;
	}

	public static void getCurrentUrl() {
		System.out.println("CURRENT URL : " + Emmie_Driver.getDriver().getCurrentUrl());
	}

	public static void clickProductFromList(List<WebElement> list, String str) {

		for (WebElement products : list) {
			String productList = products.getText();
			if (productList.contains(Emmie_Driver.getProperty(str))) {
				products.click();
				break;
			}
		}

	}

	public static double getDouble(WebElement element) {
		return Double.parseDouble(element.getText().substring(1));

	}

	public static void navigateBack() {
		Emmie_Driver.getDriver().navigate().back();
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
			String filePath = Emmie_Constants.config_filePath;

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

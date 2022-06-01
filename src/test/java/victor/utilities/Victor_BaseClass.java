package victor.utilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import Utilities.Victor_BaseClass;
import Utilities.Victor_Constants;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Victor_BaseClass {

	// DRIVER CLASS
	public static WebDriver driver;

	public static WebDriver getDriver() {

		if (driver == null) {

			switch (Victor_BaseClass.getProperty("browser")) {

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(Victor_BaseClass.getProperty("url"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Victor_Constants.implicitWaitTime, TimeUnit.SECONDS);

				break;
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(Victor_BaseClass.getProperty("url"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Victor_Constants.implicitWaitTime, TimeUnit.SECONDS);

				break;
			case "safari":
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				driver.get(Victor_BaseClass.getProperty("url"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Victor_Constants.implicitWaitTime, TimeUnit.SECONDS);

				break;
			case "headless":
				// code
				break;

			}
			
		}

		return driver;
	}

	// close/quit browser
	public static void tearDown() {
		if (driver != null) {
			driver.close();
			// driver.quit();
			driver = null;
		}
	}
	
	
	
	// configReaderClass
	private static Properties configFile;

	static {

		try {
			String filePath = Victor_Constants.config_filePath;

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

package Utilities;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	// DRIVER CLASS
	public static WebDriver driver;

	public static WebDriver getDriver() {

		if (driver == null) {

			switch (BaseClass.getProperty("browser")) {

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				PageInitializer.initialize();

				break;
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				PageInitializer.initialize();

				break;
			case "safari":
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				PageInitializer.initialize();

				break;
			case "headless":
				// code
				break;

			}
			
		}
		
		
		return driver;
	}

	// close/quit browser
	public void tearDown() {
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
			String filePath = "src/test/resources/propertiesFolder/config.properties";

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
	
	
	
	
	// configReaderClass
		private static Properties userDataConfig;

		static {

			try {
				String filePath = "src/test/resources/propertiesFolder/userData.properties";

				FileInputStream input = new FileInputStream(filePath);

				userDataConfig = new Properties();
				userDataConfig.load(input);

				input.close();

			} catch (Exception e) {
				e.printStackTrace();
			}

		}

		public static String getUserDataProperty(String keyName) {
			return userDataConfig.getProperty(keyName);
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}

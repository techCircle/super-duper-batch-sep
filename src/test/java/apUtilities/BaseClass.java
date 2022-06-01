package apUtilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;  //driver = null

	public static WebDriver getDriver() {

		if (driver == null) {

			switch (BaseClass.getProperty("browser")) {

			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				driver.get(BaseClass.getProperty("url"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Constants.implicitWaitTime, TimeUnit.SECONDS);				
				break;
				
			case "chrome":
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				driver.get(BaseClass.getProperty("url"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Constants.implicitWaitTime, TimeUnit.SECONDS);				
				break;
				
			case "safari":
				WebDriverManager.safaridriver().setup();
				driver = new SafariDriver();
				driver.get(BaseClass.getProperty("url"));
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Constants.implicitWaitTime, TimeUnit.SECONDS);			
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

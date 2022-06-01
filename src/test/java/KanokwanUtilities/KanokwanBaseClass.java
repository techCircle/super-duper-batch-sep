package kanokwanUtilities;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class KanokwanBaseClass {


		// DRIVER CLASS
		public static WebDriver driver;

		public static WebDriver getDriver() {

			if (driver == null) {

				switch (KanokwanBaseClass.getProperty("browser")) {

				
				case "chrome":
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver();
					driver.get(KanokwanBaseClass.getProperty("url"));
	                driver.manage().window().maximize();
	                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

					break;
					
				case "firefox":
					WebDriverManager.firefoxdriver().setup();
					driver = new FirefoxDriver();
					driver.get(KanokwanBaseClass.getProperty("url"));
	                driver.manage().window().maximize();
	                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

					break;
				case "safari":
					WebDriverManager.safaridriver().setup();
					driver = new SafariDriver();
					driver.get(KanokwanBaseClass.getProperty("url"));
	                driver.manage().window().maximize();
	                driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	                
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
	

		public static Properties configfile;
 

		// example.
		// public static WebDriver driver;

		static {

			try {
				String path = Constants.config_filePath;
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
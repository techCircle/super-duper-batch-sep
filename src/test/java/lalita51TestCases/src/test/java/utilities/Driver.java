package lalita51TestCases.src.test.java.utilities;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import java.util.concurrent.TimeUnit;

public class Driver {
    public static WebDriver driver;
    public static WebDriver getDriver() {

        if (driver == null) {
            switch (ConfigProp.getProperty("browser")) {
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    break;
                case "safari":
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    break;
            }
            driver.manage().window().maximize();
            driver.get(ConfigProp.getProperty("url"));
            driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
        }
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.close();
            driver = null;
        }
    }


}

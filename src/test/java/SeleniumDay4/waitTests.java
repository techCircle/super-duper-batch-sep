package SeleniumDay4;

import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class waitTests {

	WebDriver driver;
	WebDriverWait wait;

	@Before
	public void setUp() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 30);
	}

	@Test
	public void explicitWaitTest() throws InterruptedException {
		driver.findElement(By.name("q")).sendKeys("TechCircle School", Keys.ENTER);
		
		Thread.sleep(15000);

		WebElement firstLink = driver
				.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div[1]/div/div/div[1]/div/a/h3"));
		wait.until(ExpectedConditions.elementToBeClickable(firstLink));
		firstLink.click();

		/*
		 * //*[@id="rso"]/div[2]/div/div/div[1]/div/div/div[1]/div/a/h3
		 */

	}

	@Test
	public void fluentWaitTest() {
		Wait wait = new FluentWait(driver)
				.withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(3, TimeUnit.SECONDS)
				.ignoring(Exception.class);

		WebElement firstLink = driver
				.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div[1]/div/div/div[1]/div/a/h3"));

		wait.until(ExpectedConditions.elementToBeClickable(firstLink));
		firstLink.click();

	}

}

package SeleniumDay5;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AssertLearning {

	WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://the-internet.herokuapp.com/");
		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void assertEqualsTest() {

		String actualWelcomeText = driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();

		System.out.println(actualWelcomeText);
		
		String expectedWelcomeText = "Welcome to the-internet";

		AssertJUnit.assertEquals(expectedWelcomeText, actualWelcomeText);

	}

	@Test
	public void assertTrueTest() {

		Boolean AvailExText = driver.findElement(By.xpath("//*[@id=\"content\"]/h2")).isDisplayed();

		Assert.assertTrue(AvailExText);

	}

	@Test
	public void assertFalseTest() {

		// Assert.assertFalse(driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).isDisplayed());

		AssertJUnit.assertFalse(isEvenNumber(3));

	}

	public boolean isEvenNumber(int number) {

		boolean result = false;
		if (number % 2 == 0) {
			result = true;
		}
		return result;
	}

}

package SeleniumDay6;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class tolaAlerts {
	WebDriver driver;

	@Before
	public void setUp() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // implicit wait
		driver.get("https://demoqa.com/");
	}

	@Test
	public void alert() throws InterruptedException {

		driver.findElement(By.xpath("//*[@id=\"app\"]/div/div/div[2]/div/div[3]/div/div[2]")).click();
		driver.findElement(By.xpath("//*[text()='Alerts']")).click();

		// click me
		driver.findElement(By.id("alertButton")).click();
		Thread.sleep(2000);
		Alert simpleAlert = driver.switchTo().alert();
		System.out.println(simpleAlert.getText());
		Thread.sleep(2000);
		simpleAlert.accept();
		Thread.sleep(2000);

		// timer
		driver.findElement(By.id("timerAlertButton")).click();
		Thread.sleep(5000);
		Alert timerAlert = driver.switchTo().alert();
		System.out.println(timerAlert.getText());
		Thread.sleep(2000);
		timerAlert.accept();
		Thread.sleep(2000);

		// confirm
		driver.findElement(By.id("confirmButton")).click();
		Alert confirmedAlert = driver.switchTo().alert();
		System.out.println(confirmedAlert.getText());
		Thread.sleep(2000);
		confirmedAlert.dismiss();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("confirmResult")).getText());
		Thread.sleep(2000);

		// promptBox
		driver.findElement(By.id("promtButton")).click();
		Alert promptAlert = driver.switchTo().alert();
		System.out.println(promptAlert.getText());
		Thread.sleep(2000);
		promptAlert.sendKeys("Tola Chea");
		promptAlert.accept();
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.id("promptResult")).getText());
		
		Boolean ifContainsName = driver.findElement(By.id("promptResult")).getText().contains("Tola Chea");
		Assert.assertTrue(ifContainsName);
	
	}

}

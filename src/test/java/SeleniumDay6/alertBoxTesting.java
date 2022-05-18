package SeleniumDay6;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alertBoxTesting {
	
	WebDriver driver;

	@Before
	public void setUp() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void alerts() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id='alertButton']")).click();
		
		Thread.sleep(3000);
		
		driver.switchTo().alert().accept();
		
		
		
	}
	
	
	//   
	
	
	
	
	
	

}

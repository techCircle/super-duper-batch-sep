package SaturdayPractice;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practicetwo {
	WebDriver driver;

	@BeforeMethod
	public void setUp() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/elements");
		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void practiceTwo() {

//		//WebElement elementsTab = driver.findElement(By.xpath("//*[contains(@class,'card mt-4 top-card')]"));
//		WebElement textBox = driver.findElement(By.xpath("//*[contains(@id,'item-0')]"));
//		WebElement firstName = driver.findElement(By.xpath("//*[@id='userName']"));
//		WebElement email = driver.findElement(By.xpath("//*[@id='userEmail']"));
//		WebElement currentAddress = driver.findElement(By.xpath("//*[@id='currentAddress']"));
//		WebElement permanentAddress = driver.findElement(By.xpath("//*[@id='permanentAddress']"));
//		WebElement submitButton = driver.findElement(By.id("submit"));
//
//	//	elementsTab.click();
//		textBox.click();
//		firstName.sendKeys("Faruk");
//		email.sendKeys("test@automation.com");
//		currentAddress.sendKeys("currentAddress ST, VA");
//		permanentAddress.sendKeys("permanentAddress ST, VA");
//		submitButton.click();

		// driver.findElement(By.xpath("//*[@class='card mt-4 top-card'][1]")).click();
		driver.findElement(By.xpath("//*[@id=\"item-0\"]")).click();

		driver.findElement(By.xpath("//*[@id=\"userName\"]")).sendKeys("test123");
		driver.findElement(By.xpath("//*[@id=\"userEmail\"]")).sendKeys("test123@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"currentAddress\"]")).sendKeys("1234 Abcd Dr.");
		driver.findElement(By.xpath("//*[@id=\"permanentAddress\"]")).sendKeys("same as current address");
		driver.findElement(By.xpath("//button[contains(@id,'submit')]")).click();
		
		//String name = driver.findElement(By.xpath("//*[@id='name']/text()[2]")).toString();
		String name2 = driver.findElement(By.xpath("//*[@class = 'border col-md-12 col-sm-12']")).getText();
		
		
		System.out.println(name2);
		String expectedName = "test123";
		
		
		
		
		
		//Assert.assertEquals(expectedName, name2);
	
		
		
		AssertJUnit.assertTrue(name2.contains(expectedName));
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}

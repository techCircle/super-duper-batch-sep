package maria.HomePageTest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.ConfigurationProperties;
import io.github.bonigarcia.wdm.WebDriverManager;
//changes to pushzzzz
public class Registeration {
	WebDriver driver;

	@BeforeClass
	public void beforeClass() {
		System.out.println("Before class");
	}

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(ConfigurationProperties.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@AfterMethod
	public void tearDown() {
		driver.close();
	}
	@Test
	public void testCase1() {

		/*
		 * this case is running fine every time we run we just need to change the name
		 * in email address as random
		 */

		
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
		driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys("mmamiarl2020@gmail.com");
		driver.findElement(By.name("password")).sendKeys("Rtmamt786*");
		driver.findElement(By.xpath("//form[@class='register']/p[3]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testCase2() {
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys("samia2020@gcom");
		driver.findElement(By.name("password")).sendKeys("Rtmamt786*");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//form[@class='register']/p[3]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Boolean invalidEmail = driver.findElement(By.xpath("//input[@id='reg_email']")).isDisplayed();

		Assert.assertTrue(invalidEmail);

	}

	@Test
	public void testCase3() {
//		
				driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys("");
				driver.findElement(By.name("password")).sendKeys("Rtmamt786*");
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				driver.findElement(By.xpath("//form[@class='register']/p[3]")).click();
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				Boolean invalidEmail = driver.findElement(By.xpath("//input[@id='reg_email']")).isDisplayed();

				Assert.assertTrue(invalidEmail);

	}
	
	@Test
	public void testCase4() {
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys("elona@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"reg_password\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String actualError = driver.findElement(By.xpath("//*[@class='woocommerce-error']")).getText();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String expectedError="Error: Please enter an account password.";
		System.out.println(actualError);

		Assert.assertEquals(expectedError, actualError);

	}
	
	@Test
	public void testCase5() {
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@id='reg_email']")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"reg_password\"]")).sendKeys("");		
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);		
		String ErrorEmail = driver.findElement(By.xpath("//*[@class='woocommerce-error']")).getText();
		System.out.println("Error: Please provide a valid email address.");
		String expectError="Error: Please provide a valid email address.";
		Assert.assertEquals(expectError, ErrorEmail);

	}

}

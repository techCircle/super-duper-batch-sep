package Nui51TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyAccountRegistration {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public static void before() {
		
	}

	@BeforeMethod
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://practice.automationtesting.in/");		
		wait = new WebDriverWait(driver, 30);
	}
	
	@Test
	public void signIn() {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"reg_email\"]")).sendKeys("baa@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"reg_password\"]")).sendKeys("nnljl:)");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("/html/body")).isDisplayed());
	}

	@Test
	public void invalidEmailId() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"reg_password\"]")).sendKeys("Nnljl563:)");
		driver.findElement(By.xpath("//*[@id=\"reg_email\"]")).sendKeys("boo@gmail");
		Thread.sleep(1000);
		//has to do this to make register button clickable
		driver.findElement(By.xpath("//*[@id=\"reg_password\"]")).sendKeys(" ");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='woocommerce-error']/li"))));
		
		String errorMessage = driver.findElement(By.xpath("//*[@class='woocommerce-error']/li")).getText();
		
		String expectedErrMsg = "Error: Please provide a valid email address.";
		Assert.assertTrue(errorMessage.equals(expectedErrMsg));
		
	}
	
	@Test
	public void emptyEmailId() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"reg_password\"]")).sendKeys("nnljljdkwajdkaw:) ");
		Thread.sleep(1000);
		//has to do this to make register button clickable
		driver.findElement(By.xpath("//*[@id=\"reg_password\"]")).sendKeys(" ");

		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();
		Thread.sleep(3000);
		
		String errorMessage = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/ul/li")).getText();
		System.out.println("Empty email: "+errorMessage);
		String expectedErrMsg = "Error: Please provide a valid email address.";
		Assert.assertTrue(errorMessage.equals(expectedErrMsg));
	}
	
	@Test
	public void emptyPwd() {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"reg_email\"]")).sendKeys("booooooooooo@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"reg_password\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();
		
		String errorMessage = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
		System.out.println("Empty Pwd: "+errorMessage);
		String expectedErrMsg = "Error: Please enter an account password.";
		Assert.assertTrue(errorMessage.equals(expectedErrMsg));
		
	}  
	
	@Test
	public void emptyEmailIdEmptyPwd() {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"reg_email\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"reg_password\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();
		
		String errorMessage = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
		System.out.println("EmptyBoth: "+errorMessage);
		String expectedErrMsg = "Error: Please provide a valid email address.";
		Assert.assertTrue(errorMessage.equals(expectedErrMsg));
		
	}
	
	@AfterMethod
	public void after() {
		System.out.println("closing");
		driver.quit();
	}

}

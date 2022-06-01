package PracticeAutomation51TestCases.MyAccountRegistration4;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import org.openqa.selenium.support.ui.ExpectedConditions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyAccountRegistration {

//	MY ACCOUNT - REGISTRATION
//	1. Registration-Sign-in / abc053120221@gmail.com / Abc12!?$
//	2. Registration with invalid Email-id / abc05312022 / Abc12!?$
//	3. Registration with empty Email-id / empty / Abc12!?$
//	4. Registration with empty password / abc053120222@gmail.com / empty
//	5. Registration with empty Email-id & password / empty / empty

	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.automationtesting.in/");
        
        // implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

//	1. Registration-Sign-in
	
	@Test
	public void _01signIn() {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"reg_email\"]")).sendKeys("abc053120221@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"reg_password\"]")).sendKeys("Abc12!?$");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();
		
		Assert.assertTrue(driver.findElement(By.xpath("/html/body")).isDisplayed());
	}

//	2. Registration with invalid Email-id
	@Test
	public void _02invalidEmailId() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"reg_email\"]")).sendKeys("abc05312022");
		driver.findElement(By.xpath("//*[@id=\"reg_password\"]")).sendKeys("Abc12!?$");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();
		
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='woocommerce-error']/li"))));
		
		String errorMessage = driver.findElement(By.xpath("//*[@class='woocommerce-error']/li")).getText();
		String expectedErrorMessage = "Error: Please provide a valid email address.";
		Assert.assertTrue(errorMessage.equals(expectedErrorMessage));
		
	}
//	3. Registration with empty Email-id
	@Test
	public void _03emptyEmailId() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
//		driver.findElement(By.xpath("//*[@id=\"reg_email\"]")).sendKeys("abc05312022@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"reg_password\"]")).sendKeys("Abc12!?$");
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();
				
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//*[@class='woocommerce-error']/li"))));
				
		String errorMessage = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/ul/li")).getText();
		String expectedErrorMessage = "Error: Please provide a valid email address.";
		Assert.assertTrue(errorMessage.equals(expectedErrorMessage));
	}
	
//	4. Registration with empty password
	
	@Test
	public void _04emptyPassword() {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"reg_email\"]")).sendKeys("abc053120222@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"reg_password\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();
		
		String errorMessage = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
		String expectedErrorMessage = "Error: Please enter an account password.";
		Assert.assertTrue(errorMessage.equals(expectedErrorMessage));
		
	}  
	
//	5. Registration with empty Email-id & password
	
	@Test
	public void _05emptyEmailIdEmptyPassword() {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"reg_email\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"reg_password\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();
		
		String errorMessage = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
		String expectedErrorMessage = "Error: Please provide a valid email address.";
		Assert.assertTrue(errorMessage.equals(expectedErrorMessage));
		
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.close();
			
	}
	

}
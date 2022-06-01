package PracticeAutomation51TestCases.MyAccountLogin8;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import KangUtilities.KangConfigurationProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MyAccountLogin {
	
//	MY ACCOUNT - LOGIN
//	 1. Log-in with valid username and password.
//	 2. Log-in with incorrect username and incorrect password.
//	 3. Log-in with correct username and empty password.
//	 4. Log-in with empty username and valid password.
//	 5. Log-in with empty username and empty password.
//	 6. Log-in -Password should be masked
//	 7. Login-Handles case sensitive
//	 8. Login-Authentication

	WebDriver driver;
	
	@BeforeMethod
    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.automationtesting.in/");
        
        // implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
//	public void clickMyAccount() {
//		WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a"));
//		myAccount.click();
//	}
//		
//	public void inputEmail() {
//		WebElement email = driver.findElement(By.xpath("//*[@id=\"username\"]"));
//		email.sendKeys(KangConfigurationProperties.getProperty("email"));
//	}
//	
//	public void inputPassword() {
//		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
//		password.sendKeys(KangConfigurationProperties.getProperty("password"));
//	}
//	
//	public void clickLogin() {
//		WebElement login = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]"));
//		login.click();
//	}
	
	
//	 1. Log-in with valid username and password.
	
	@Test
public void _1validUsernamePassword() throws InterruptedException {
			
//abc05312022@gmail.com
//Abc12!?$

		
		WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a"));
		myAccount.click();
		
		WebElement email = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		email.sendKeys(KangConfigurationProperties.getProperty("email"));
		
		Thread.sleep(3000);
		
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		password.sendKeys(KangConfigurationProperties.getProperty("password"));

		WebElement login = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]"));
		login.click();
		
		
		String logOut = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")).getText();
		String signOut = "Sign out";
		
		//check if user logging in successfully
		Assert.assertTrue(logOut.equals(signOut));
	}
		
//	 2. Log-in with incorrect username and incorrect password.
	
	@Test
	public void _2incorrectUsernamePassword() throws InterruptedException {
		
		WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a"));
		myAccount.click();
		
		WebElement email = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		email.sendKeys(KangConfigurationProperties.getProperty("incorrectEmail"));
		
		Thread.sleep(3000);
		
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		password.sendKeys(KangConfigurationProperties.getProperty("incorrectPassword"));

		WebElement login = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]"));
		login.click();
	
	String errorMessage = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
	
	System.out.println(errorMessage);
	String expectedErrorMessage = "Error: A user could not be found with this email address.";
	Assert.assertTrue(errorMessage.equals(expectedErrorMessage));
	
	}
		
//	 3. Log-in with correct username and empty password.
	
	@Test
	public void _3correctUsernameEmptyPassword() throws InterruptedException {
		
		WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a"));
		myAccount.click();
		
		WebElement email = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		email.sendKeys(KangConfigurationProperties.getProperty("email"));
		
		Thread.sleep(3000);
		
//		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
//		password.sendKeys(ConfigurationProperties.getProperty(""));

		WebElement login = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]"));
		login.click();
		
		Thread.sleep(3000);
	
	String errorMessage = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
	
	System.out.println(errorMessage);
	String expectedErrorMessage = "Error: Password is required.";	
	Assert.assertTrue(errorMessage.equals(expectedErrorMessage));
	
	}
	
//	 4. Log-in with empty username and valid password.
	
	@Test
	public void _4emptyUsernameValidPassword() throws InterruptedException {
		
		WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a"));
		myAccount.click();
		
//		WebElement email = driver.findElement(By.xpath("//*[@id=\"username\"]"));
//		email.sendKeys(ConfigurationProperties.getProperty(""));
		
		Thread.sleep(3000);
		
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		password.sendKeys(KangConfigurationProperties.getProperty("password"));

		Thread.sleep(3000);
		
		WebElement login = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]"));
		login.click();
	
	String errorMessage = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
	
	System.out.println(errorMessage);
	String expectedErrorMessage = "Error: Username is required.";	
	Assert.assertTrue(errorMessage.equals(expectedErrorMessage));
	
	}
	
//	 5. Log-in with empty username and empty password.
	
	@Test
	public void _5emptyUsernameEmptyPassword() throws InterruptedException {
		
		WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a"));
		myAccount.click();
		
//		WebElement email = driver.findElement(By.xpath("//*[@id=\"username\"]"));
//		email.sendKeys(ConfigurationProperties.getProperty(""));
//		
//		Thread.sleep(3000);
//		
//		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
//		password.sendKeys(ConfigurationProperties.getProperty(""));

		WebElement login = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]"));
		login.click();
	
	String errorMessage = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
	
	System.out.println(errorMessage);
	String expectedErrorMessage = "Error: Username is required.";	
	Assert.assertTrue(errorMessage.equals(expectedErrorMessage));
	
	}
//	 6. Log-in -Password should be masked
	
	@Test
	public void _6passwordShouldBeMasked() throws InterruptedException {
		
		WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a"));
		myAccount.click();
		
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		password.sendKeys(KangConfigurationProperties.getProperty("password"));
		
		Thread.sleep(3000);
		
		WebElement password1 = driver.findElement(By.xpath("//*[@class='woocommerce-FormRow woocommerce-FormRow--wide form-row form-row-wide'][2]/input"));
		Assert.assertTrue(password1.getAttribute("type").equals("password")); 
	}
		
//	 7. Login-Handles case sensitive
	
//	???
	
	@Test
	public void _7caseSensitive() throws InterruptedException {
		
		WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a"));
		myAccount.click();
		
		WebElement email = driver.findElement(By.xpath("//*[@id=\"username\"]"));
		email.sendKeys("ABC05312022@GMAIL.COM");
		
		
		Thread.sleep(3000);
		
		WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
		password.sendKeys("ABC12!?$");

		WebElement login = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]"));
		login.click();
	
	String errorMessage = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
	System.out.println(errorMessage);
		
	String expectedErrorMessage = "ERROR: The password you entered for the username ABC05312022@GMAIL.COM is incorrect. Lost your password?";
	Assert.assertTrue(errorMessage.equals(expectedErrorMessage));
	
	
	}
	
//	 8. Login-Authentication
	@Test
	public void _8authentication() throws InterruptedException {
			
			WebElement myAccount = driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a"));
			myAccount.click();
			
			WebElement email = driver.findElement(By.xpath("//*[@id=\"username\"]"));
			email.sendKeys(KangConfigurationProperties.getProperty("email"));
			
			Thread.sleep(3000);
			
			WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
			password.sendKeys(KangConfigurationProperties.getProperty("password"));

			WebElement login = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]"));
			login.click();
			
			
			String logOut = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")).getText();
			String signOut = "Sign out";
			
			//check if user logging in successfully
			Assert.assertTrue(logOut.equals(signOut));
			
			driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")).click();
			driver.navigate().back();
			Thread.sleep(3000);
			
			//check if general webpage is visible
			Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"customer_login\"]")).isDisplayed());
			
			
		}
			
		
	@AfterMethod
	public void tearDown() {
		driver.close();
			
	}
	
	
	
}

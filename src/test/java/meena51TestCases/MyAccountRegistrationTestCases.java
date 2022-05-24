package meena51TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyAccountRegistrationTestCases {

	WebDriver driver;
	Actions act;

	@BeforeTest
	public void setUp() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://practice.automationtesting.in");
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test(priority = 1)
	public void registerEmail() throws InterruptedException {

		/*
		 * 1) Open the browser 
		 * 2) Enter the URL “http://practice.automationtesting.in/”
		 * 3) Click on My Account Menu 
		 * 4) Enter registered Email Address in Email-Address textbox 
		 * 5) Enter your own password in password textbox 
		 * 6) Click on Register button 
		 * 7) User will be registered successfully and will be navigated to the Home page
		 */

		// My Account button
		driver.findElement(By.xpath("//*[@id='menu-item-50']")).click();

		// Enter register username
		
		
		driver.findElement(By.xpath("//*[@id='reg_email']")).sendKeys("meena189@gmail.com");
		// Enter password
		driver.findElement(By.xpath("//*[@id='reg_password']")).sendKeys("A12bc34de56@");

		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);    
		
		//Register button click
		WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]"));
		registerButton.click();
		
		Thread.sleep(3000);
		
		String expectText = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
		Assert.assertTrue(expectText.contains("From your account dashboard you can view your"));
		
	}

	@Test(priority = 2)
	public void invalidEmailValidPassword() {
		/*
		 * 1) Open the browser 
		 * 2) Enter the URL “http://practice.automationtesting.in/”
		 * 3) Click on My Account Menu 
		 * 4) Enter invalid Email Address in Email-Address textbox 
		 * 5) Enter your own password in password textbox 
		 * 6) Click on Register button 
		 * 7) Registration must fail with a warning message(ie You must enter a valid email address)
		 */

		// My Account button
		driver.findElement(By.xpath("//*[@id='menu-item-50']")).click();

		// Enter invalid email
		driver.findElement(By.xpath("//*[@id='reg_email']")).sendKeys("meena@gmail.com");
		// Enter password
		driver.findElement(By.xpath("//*[@id='reg_password']")).sendKeys("A12bc34de56@");

		
		// click register
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		
		String expectText = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
		Assert.assertTrue(expectText.contains("Error: "));

	}

	@Test(priority = 3)
	public void emptyEmailValidPassword() {

		/*
		 * 1) Open the browser 
		 * 2) Enter the URL “http://practice.automationtesting.in/”
		 * 3) Click on My Account Menu 
		 * 4) Enter empty Email Address in Email-Address textbox 
		 * 5) Enter your own password in password textbox 
		 * 6) Click on Register button 
		 * 7) Registration must fail with a warning message(ie please provide valid email address)
		 * 
		 */

		// My Account button
		driver.findElement(By.xpath("//*[@id='menu-item-50']")).click();

		// Enter empty email
		driver.findElement(By.xpath("//*[@id='reg_email']")).sendKeys("");
		// Enter password
		driver.findElement(By.xpath("//*[@id='reg_password']")).sendKeys("A12bc34de56@");

		
		// click register
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//
		String expectText = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
		Assert.assertTrue(expectText.contains("Error: Please provide a valid email address."));

	}

	@Test(priority = 4)
	public void validEmailEmptyPassword() {

		/*
		 * 1) Open the browser 
		 * 2) Enter the URL “http://practice.automationtesting.in/”
		 * 3) Click on My Account Menu 
		 * 4) Enter valid Email Address in Email-Address textbox 
		 * 5) Enter empty password in password textbox 
		 * 6) Click on Register button 
		 * 7) Registration must fail with a warning message(ie please enter an account password)
		 * 
		 */

		// My Account button
		driver.findElement(By.xpath("//*[@id='menu-item-50']")).click();

		// Enter valid email
		driver.findElement(By.xpath("//*[@id='reg_email']")).sendKeys("meena@gmail.co");
		// Enter empty password
		driver.findElement(By.xpath("//*[@id='reg_password']")).sendKeys("");

		// click register
		// click register
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//		unclickable
		
//		String expectText = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
//		Assert.assertTrue(expectText.contains("From your account dashboard you can view your"));

	}

	@Test(priority = 5)
	public void emptyEmailAndEmptyPassword() {
		/*
		 * 1) Open the browser 
		 * 2) Enter the URL “http://practice.automationtesting.in/”
		 * 3) Click on My Account Menu 
		 * 4) Enter empty Email Address in Email-Address textbox 
		 * 5) Enter empty password in password textbox 
		 * 6) Click on Register button 
		 * 7) Registration must fail with a warning message(ie please provide valid email address)
		 */

		// My Account button
		driver.findElement(By.xpath("//*[@id='menu-item-50']")).click();

		// Enter empty email
		driver.findElement(By.xpath("//*[@id='reg_email']")).sendKeys("");
		// Enter empty password
		driver.findElement(By.xpath("//*[@id='reg_password']")).sendKeys("");

		// click register
		// click register
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);


		String expectText = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
		Assert.assertTrue(expectText.contains("Error: Please provide a valid email address."));

	}
	

	@AfterTest
    public void tearDown() {
        driver.quit();
    }
	
}

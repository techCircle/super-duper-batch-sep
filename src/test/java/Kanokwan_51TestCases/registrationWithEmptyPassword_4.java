package Kanokwan_51TestCases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class registrationWithEmptyPassword_4 {

WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		
		//setup the chrome driver by using WebDriverManager
    	//declaration and instantiation of objects/variables

        WebDriverManager.chromedriver().setup();
        
       //Create driver object for Chrome
        
        driver = new ChromeDriver();
        
        //Enter the URL “http://practice.automationtesting.in/”
		//1) Open the browser
		//2) Enter the URL “http://practice.automationtesting.in/”
        
		driver.get("http://practice.automationtesting.in/");
		
		//To maximize the browser
        
        driver.manage().window().maximize();
        
        // implicit wait
        /*
         * Implicit Wait in Selenium is used to tell the web driver to wait for a certain amount 
         * of time before it throws a “No Such Element Exception”. The default setting is 0. Once we set the time, 
         * the web driver will wait for the element for that time before throwing an exception.
         */
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	
	
	@Test
	public void registrationWithEmptyPassword() throws InterruptedException {
		
		//4. Registration with empty password
		
		//3) Click on My Account Menu
		//Get the WebElement corresponding to  shop menu
		//Use Web Element findElement() to find the elements on the web page
		
		WebElement accountMenu = driver.findElement(By.xpath("//*[@id='menu-item-50']"));
		accountMenu.click();
		
		//4) Enter valid Email Address in Email-Address textbox
		WebElement registerEmail = driver.findElement(By.xpath("//*[@id=\"reg_email\"]"));
		registerEmail.sendKeys("tiew157abc@gmail.com");
				
		Thread.sleep(3000);
		
		//5) Enter empty password in password textbox
		
		WebElement registerPassword = driver.findElement(By.xpath("//*[@id=\"reg_password\"]"));	
		registerPassword.sendKeys("");
		
		Thread.sleep(3000);
				
		//6) Click on register button
				
		WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]"));
		registerButton.click();
				
		Thread.sleep(3000);
		
		//7) Registration must fail with a warning message(ie please enter an account password)
		//Use assertion. Assertions are important for comparing the expected results to the actual results.
		//If it matches, the test case passes. If not, then the test case fails.
		

	    String actualText = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
		
	    String expectedUrl = actualText.toString();

		Assert.assertEquals(expectedUrl, actualText);

		System.out.println("Actual Text : "+actualText);
		
		System.out.println("Expected Text : "+expectedUrl);
		
		System.out.println("ERROR :" +" : "+ "Please enter an account password");
		
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		
	}
}




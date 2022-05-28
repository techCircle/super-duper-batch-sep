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

public class myAccounstOrdersNumber_4 {
	
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
	public void myAccounstOrdersNumber() throws InterruptedException {
		
		
		//4. My Accounts-Orders

		//3) Click on My Account Menu
		//Get the WebElement corresponding to  shop menu
		//Use Web Element findElement() to find the elements on the web page
								
		WebElement accountMenu = driver.findElement(By.xpath("//*[@id='menu-item-50']"));
		accountMenu.click();
								
								
		//4) Enter registered username in username textbox
		//Get the WebElement corresponding to the email.
								
		//use Thread. sleep while performing Selenium test automation, it will stop the execution of the script 
		//for the time specified in the script, irrespective of the fact that the element on the web page has been found.
				
								
		WebElement registerEmail = driver.findElement(By.xpath("//*[@id=\"reg_email\"]"));
		registerEmail.sendKeys("tiew404abc@gmail.com");
						
		Thread.sleep(3000);
						
		//5) Enter password in password textbox
		//Get the WebElement corresponding to the email.
								
		WebElement registerPassword = driver.findElement(By.xpath("//*[@id=\"reg_password\"]"));	
		registerPassword.sendKeys("T@ew!43@93#$abc");
						
		Thread.sleep(3000);
						
						
		//6) Click on register button
						
		WebElement registerButton = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]"));
		registerButton.click();
						
		Thread.sleep(3000);
						
				
		//7) User must successfully login to the web page
		//8) Click on My account link which leads to Dashboard
				
		WebElement dashBoard = driver.findElement(By.xpath("//*[@id='menu-item-50']"));
		dashBoard.click();
				
		//9) Click on Orders link
			
		WebElement orderLink = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[2]/a"));
		orderLink.click();
			
		//10) Click view button
		
		//11) User must view Order Number Ordered date and Status of the order on clicking view button
					
		String actualText = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div")).getText();
				
		String expectedUrl = actualText.toString();

		Assert.assertEquals(expectedUrl, actualText);

		System.out.println("Actual Text : "+actualText);
				
		System.out.println("Expected Text : "+expectedUrl);
				
		System.out.println("User must view Order Number Ordered date and Status");
					
	}
			
				
		@AfterClass
		public void tearDown() {
			driver.close();
			
				}
		}





package Kanokwan_51TestCases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class shopProductCategoriesFunctionality_2 {
	
	WebDriver driver;
	Actions act;
		
		@BeforeClass
		public void setUp() {
			
			//setup the chrome driver by using WebDriverManager
	    	//declaration and instantiation of objects/variables

	        WebDriverManager.chromedriver().setup();
	        
	       //Create driver object for Chrome
	        
	        driver = new ChromeDriver();
	        
	        //Enter the URL “http://practice.automationtesting.in/”
	        
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
	public void shopProductCategoriesFunctionality() {
			
	//2. Shop-Product Categories Functionality
			
	// 3) Click on Shop Menu
	//Get the WebElement corresponding to  shop menu
	//Use Web Element findElement() to find the elements on the web page
		    			
	WebElement shopMenu = driver.findElement(By.id("menu-item-40"));
	shopMenu.click();
			
	//4) Click any of the product links available in the product category
	//Picture Number 1
	
	WebElement picture1 = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a[1]/img"));
	picture1.click();
	
	
	
	//5) Now user can view only that particular product
	
	//Use assertion. Assertions are important for comparing the expected results to the actual results.
	//If it matches, the test case passes. If not, then the test case fails.
			
		    String actualText = driver.findElement(By.xpath("//*[@id=\"product-169\"]/div[1]")).getText();
			
		    String expectedUrl = actualText.toString();

			Assert.assertEquals(expectedUrl, actualText);

			System.out.println("Actual Text : "+actualText);
			
			System.out.println("Expected Text : "+expectedUrl);
			
			System.out.println("Android Quick Start Guide");
}
	
	@AfterClass
	public void tearDown() {
		driver.close();
		
	}
}

	

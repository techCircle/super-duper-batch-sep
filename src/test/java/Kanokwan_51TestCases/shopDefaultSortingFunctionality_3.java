package Kanokwan_51TestCases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class shopDefaultSortingFunctionality_3 {

	
	WebDriver driver;
	
		
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
	public void shopDefaultSortingFunctionality() throws InterruptedException {
			
	//3. Shop-Default Sorting Functionality
			
	// 3) Click on Shop Menu
	//Get the WebElement corresponding to  shop menu
	//Use Web Element findElement() to find the elements on the web page
		    			
	WebElement shopMenu = driver.findElement(By.id("menu-item-40"));
	shopMenu.click();
	
	//4) Click on Sort by Popularity item in Default sorting dropdown
	
	driver.findElement(By.xpath("//*[@class='woocommerce-ordering']"));
	Thread.sleep(3000);
	
	//5) Now user can view the popular products only
	
	//Use Select Methods, Declare the drop-down element as an instance of the Select class.
	//Use selectByVisibleText(), selects an option by its displayed text.
	
	Select dropPopularity = new Select(driver.findElement(By.name("orderby")));
	dropPopularity.selectByVisibleText("Sort by popularity");
	
	Thread.sleep(3000);
	
	
	//Use assertion. Assertions are important for comparing the expected results to the actual results.
	//If it matches, the test case passes. If not, then the test case fails.
				
	String actualText = driver.findElement(By.xpath("//*[@id=\"content\"]/form/select")).getText();
				
	String expectedUrl = actualText.toString();

	Assert.assertEquals(expectedUrl, actualText);

	System.out.println("Actual Text : "+actualText);
				
	System.out.println("Expected Text : "+expectedUrl);
	
	System.out.println("Default Sorting by Popularity" +" : "+"User can view the popular products only");
				
	}
		
	@AfterClass
	public void tearDown() {
		driver.close();
			
		}
	}

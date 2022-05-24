package Kanokwan_51TestCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class shopFilterByPriceFunctionality_1 {
	
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
	public void shopFilterByPrice() {
			
	//1. Shop-Filter By Price Functionality
			
	// 3) Click on Shop Menu
	//Get the WebElement corresponding to  shop menu
	//Use Web Element findElement() to find the elements on the web page
		    			
	WebElement shopMenu = driver.findElement(By.id("menu-item-40"));
	shopMenu.click();
			
	//4) Adjust the filter by price between 150 to 450 rps
		  
    //slider xpath
	WebElement slider = driver.findElement(By.xpath("//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/span[2]"));
    
    Actions act = new Actions(driver);
    act.dragAndDropBy(slider,-28, 0).perform();
    
	
    WebElement filterButton = driver.findElement(By.xpath("//*[@class='button']"));
    filterButton.click();
    
    String selectPrice = driver.getCurrentUrl().toString();
    System.out.println(selectPrice);    
    String expectedPrice = "http://practice.automationtesting.in/shop/?min_price=150&max_price=451";
    Assert.assertEquals(selectPrice, expectedPrice);
    System.out.println("User can view books only between 150 to 451");
	
	}
    
    
	@AfterClass
		public void tearDown() {
		driver.close();
		
	}
}

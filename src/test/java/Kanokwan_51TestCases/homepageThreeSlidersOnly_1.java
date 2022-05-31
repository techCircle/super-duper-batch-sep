package Kanokwan_51TestCases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class homepageThreeSlidersOnly_1 {
	
	WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {

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
    public void homePageSliders() {
    	
    	// 1. Home Page with three Sliders only
    	
    	//Click on Shop Menu
    	//Use  findElement() to find the elements on the web page
        driver.findElement(By.id("menu-item-40")).click();
        
        //Click on Home menu button
      	driver.findElement(By.xpath("//*[@id=\"content\"]/nav/a")).click();
      	
        // Test whether the Home page has Three Sliders only
      	// The Home page must contains only three sliders
        List<WebElement> threeSlides = driver.findElements(By.xpath("//*[@id='themify_builder_content-22']/div"));
        
        int slides = threeSlides.size();
        System.out.println(slides);
    
        assert(slides==3);
        System.out.println("Test is Completed!");
        System.out.println("Home page contains only three arrivals");
        
    }
    
    @AfterClass
    public void tearDown() {
        driver.close();


	    }
}


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

public class homepageThreeArrivalsOnly_2 {
	
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
    public void imageInArrivals() {
    	
    	// 2. Home page with three Arrivals only
    	
    	//3.Click on Shop Menu
    	//Get the WebElement corresponding to  shop menu
    	//Use findElement() to find the elements on the web page
    	
    	WebElement shopMenu = driver.findElement(By.xpath("//*[@id='menu-item-40']"));
    	shopMenu.click();
    	
    	//Now click on Home menu button
    	//Get the WebElement corresponding to home menu button
    	
    	//4) Now click on Home menu button
        //Get the WebElement corresponding to home menu button
        	        
        WebElement homeMenuButton = driver.findElement(By.xpath("//*[@id=\"content\"]/nav/a"));
        homeMenuButton.click();
    	
    	//Test whether the Home page has Three Arrivals only
    	//The Home page must contains only three sliders
    	List<WebElement> newArrivals = driver.findElements(By.xpath("//*[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div"));

        int items = newArrivals.size();
        System.out.println(items);

        assert(items==3);
        
    	//driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-1-1-0']")).click();
    	System.out.println("Test Complet!!");
    	System.out.println("Home page shows Three Arrivals");
    	
    }

    
    @AfterClass
    public void tearDown() {
        driver.close();
        
    }
}


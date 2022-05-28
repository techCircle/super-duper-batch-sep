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

public class homepageAll18TestCases {
	
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
    public void printAll18TestCaseName() {
        
    	//Go to Home page
    	List<WebElement> HomePageTestCaseTitles = driver.findElements(By.xpath("//*[@id='accordion-222-sub_row_1-0-1-0-0']/ul/li"));
        
        
        for(WebElement eachElement:HomePageTestCaseTitles ) {
        	
            String each = eachElement.getText();
            
            System.out.println(each);
            System.out.println("HomePage");
		}
    }
    
        @AfterClass
         public void tearDown() {
        	driver.close();
        }
        	
        
    }
		


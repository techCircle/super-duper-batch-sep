package Kanokwan_51TestCases;

import java.util.List;
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

public class homepageImagesInArrivals_3 {
	
	WebDriver driver;

    @BeforeClass
    public void setUp() throws InterruptedException {

    	//setup the chrome driver by using WebDriverManager
    	//declaration and instantiation of objects/variables

    	WebDriverManager.chromedriver().setup();
    			
    	//Create driver object for Chrome

    	driver = new ChromeDriver();
    			
    	//To maximize the browser
    			
    	driver.manage().window().maximize();
    			
    	// 1) Open the browser
    	// 2) Enter the URL “http://practice.automationtesting.in/”
    	//Navigate to a URL 
    	
    	driver.get("http://practice.automationtesting.in/");
    			
    	 /*
    	   * Implicit Wait in Selenium is used to tell the web driver to wait for a certain amount 
    	   * of time before it throws a “No Such Element Exception”. The default setting is 0. Once we set the time, 
    	   * the web driver will wait for the element for that time before throwing an exception.
    	 */
    	
    			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    		}
    		
    @Test
    public void arrivalsImageDescription() throws InterruptedException {
    	        
    //  4. Home page - Arrivals-Images-Description
    	    	
    // 3) Click on Shop Menu
    //Get the WebElement corresponding to  shop menu
    //Use Web Element findElement() to find the elements on the web page
    			
    WebElement shopMenu = driver.findElement(By.id("menu-item-40"));
    shopMenu.click();
    	        
    //4) Now click on Home menu button
    //Get the WebElement corresponding to home menu button
    	        
    WebElement homeMenuButton = driver.findElement(By.xpath("//*[@id=\"content\"]/nav/a"));
    homeMenuButton.click();
    	    	
    //5) Test whether the Home page has Three Arrivals only
    //6) The Home page must contains only three Arrivals
    	      	
	List<WebElement> newArrivals = driver.findElements(By.xpath("//*[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div"));

    		int items = newArrivals.size();
    		System.out.println(items);

    		assert(items==3);
    
    		System.out.println("Test Complet!!");
    		System.out.println("Home page shows Three Arrivals");

        	 
         //7) Now click the image in the Arrivals
         //8) Test whether it is navigating to next page where the user can add that book into his basket.
         //9) Image should be click able and should navigate to next page where user can add that book to his basket
         
        //first picture
        WebElement firstPic = driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-2-0-0']"));
        firstPic.click();
        
        String expectedText1 = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();
        
        Assert.assertTrue(expectedText1.contains("Selenium Ruby"));
          
          //Go back  Home to click second picture
        
         WebElement backHome = driver.findElement(By.xpath("//*[@id=\"content\"]/nav/a[1]"));
         backHome.click();
         
         //second picture
         WebElement secondPic = driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-2-1-0']"));
         secondPic.click();
         
         String expectedText2 = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();
         
         Assert.assertTrue(expectedText2.contains("Thinking in HTML"));
         
         //Go back Home to click third picture
         
         WebElement backHome2 =driver.findElement(By.xpath("//*[@id=\"content\"]/nav/a[1]"));
         backHome2.click();
         
         //Third picture
         WebElement thirdPic = driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-2-2-0']"));
         thirdPic.click();
         
         String expectedText3 = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();
         
         Assert.assertTrue(expectedText3.contains("Mastering JavaScript"));
        		 
       //Go back Home to see 3 pictures
         
         WebElement backHome3 = driver.findElement(By.xpath("//*[@id=\"content\"]/nav/a[1]"));
         backHome3.click();
         
         
    }
        
        @AfterClass
        public void tearsDown() {
        driver.close();
        
         }
}
    
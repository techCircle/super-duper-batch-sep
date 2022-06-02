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

public class homepageArrivalsImageReview_5 {
	
WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		
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
   
	//7) Now click the image in the Arrivals
    //8) Test whether it is navigating to next page where the user can add that book into his basket.
    //9) Image should be click able and should navigate to next page where user can add that book to his basket
    
   	 //first picture
        
   driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-2-0-0']")).click();
   
   String expectedText1 = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();
   
   Assert.assertTrue(expectedText1.contains("Selenium Ruby"));
     
     //Go back  Home to click second picture
    driver.findElement(By.xpath("//*[@id=\"content\"]/nav/a[1]")).click();
    
    //second picture
    driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-2-1-0']")).click();
    
    String expectedText2 = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();
    
    Assert.assertTrue(expectedText2.contains("Thinking in HTML"));
    
    //Go back Home to click third picture
    driver.findElement(By.xpath("//*[@id=\"content\"]/nav/a[1]")).click();
    
    //Third picture
    driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-2-2-0']")).click();
    
    String expectedText3 = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();
    
    Assert.assertTrue(expectedText3.contains("Mastering JavaScript"));
   		 
    //Go back Home 
    driver.findElement(By.xpath("//*[@id=\"content\"]/nav/a[1]")).click();
    
		
		//10) Now clock on Reviews tab for the book you clicked on.
	    //11) There should be a Reviews regarding that book the user clicked on
    
		//picture 1
    
        driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-0-0\"]/div/ul/li/a[1]")).click();
        driver.findElement(By.xpath("//*[@id=\"product-160\"]/div[3]/ul/li[2]/a")).click();
        
        String expectText4 = driver.findElement(By.xpath("//*[@id=\"comments\"]/h2")).getText();
        
        Assert.assertTrue(expectText4.contains("Reviews"));
        
        System.out.println("Product Reviews picture1 completed");
        
        Thread.sleep(3000);
        
	    //Go back  Home to click picture 2
        
	        driver.navigate().back();
        
	   //picture 2
        driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-2-1-0']")).click();
	    driver.findElement(By.xpath("//*[@id=\"product-163\"]/div[3]/ul/li[2]")).click();
	        
	    String expectedText5 = driver.findElement(By.xpath("//*[@id=\"comments\"]/h2")).getText();
	        
	    Assert.assertTrue(expectedText5.contains("Reviews"));
	    
	    System.out.println("Product Reviews picture2 completed");
	    
	    Thread.sleep(3000);
	    
	  //Go back  Home to click picture 3
        
        driver.navigate().back();
        
        //picture 3
	     
        driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-2-2-0']")).click();
        driver.findElement(By.xpath("//*[@id=\"product-165\"]/div[3]/ul/li[2]")).click();
        
        String expectedText6 = driver.findElement(By.xpath("//*[@id=\"comments\"]/h2")).getText();
        
        Assert.assertTrue(expectedText6.contains("Reviews"));
        
        System.out.println("Product Reviews picture3 completed");
       		 
        Thread.sleep(3000);
        
      //Go back Home to see 3 pictures
        
      driver.navigate().back();
      //driver.navigate().to("http://practice.automationtesting.in/");
      
	        
	}
	
	
		@AfterClass
		public void tearDown() {
		driver.close();
		
		}
}


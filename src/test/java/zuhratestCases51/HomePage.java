package zuhratestCases51;



import java.util.List;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage {

	
	WebDriver driver;
	
	
	//Open the Browser
	 @Before
	 public void setUp() throws InterruptedException {
		 
		    WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();
	        driver.get("http://practice.automationtesting.in");
	        driver.manage().window().maximize();
	        // implicit wait
	        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 }
	 
	
	 
	@Ignore
	 @Test //Home Page with three Sliders Only
	 
	    public void homePageTestOne() {
		  //Click on Shop Menu
		 driver.findElement(By.xpath("//*[@id='menu-item-40']/a")).click();
		 //Click on Home element
		 driver.findElement(By.xpath("//*[@id='content']/nav/a")).click();
		 //
		
		 assert(driver.findElements( By.xpath(("//*[@class='n2-ss-slider-3']/div"))).size()==3);
		
		 
	        
	    }
	 @Ignore
	 @Test //Home page with three Arrivals only
	 
	    public void homePageTestTwo() {
		  //Click on Shop Menu
		 driver.findElement(By.xpath("//*[@id='menu-item-40']/a")).click();
		
		 //Click on Home element
		 driver.findElement(By.xpath("//*[@id='content']/nav/a")).click();
		 
		 //finding new arrivals 
		List<WebElement> newArrivals = driver.findElements(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div/div"));
		
		//checking new arrivals has only three Arrivals								
		Assert.assertEquals(3, newArrivals.size());
		
				
	        
	    }
	 

	 @Test //Home page Images in Arrivals should navigate
	 
	    public void homePageTestThree() {
		 //Click on Shop Menu
		driver.findElement(By.xpath("//*[@id='menu-item-40']/a")).click();
		
		//Click on Home element
		driver.findElement(By.xpath("//*[@id='content']/nav/a")).click();
		
		//finding new arrivals 
		List<WebElement> newArrivals = driver.findElements(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div/div"));
		
		//checking new arrivals has only three Arrivals								
		Assert.assertEquals(3, newArrivals.size());
			
			
		 //click on image and navigate to next page
		
		//Selenium Ruby
		driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-2-0-0']")).click();
		driver.findElement(By.xpath("//*[@id='content']/nav/a[1]")).click();
		
		//Thinking in HTML
		driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-2-1-0']")).click();
		driver.findElement(By.xpath("//*[@id='content']/nav/a[1]")).click();
		
		
		//Mastering JavaScript
		driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-2-2-0']")).click();
		driver.findElement(By.xpath("//*[@id='content']/nav/a[1]")).click();
		
		
		//can navigate to next page but no option to add to basket as no stock is available
					        
	    }

}

package PracticeAutomation51TestCases.HomePage18;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _011HomeArrivalsAddToBasketItemsRemoveBook {

	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	

	
	@BeforeClass
	
	
    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.automationtesting.in/");
        
        // implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void RemoveBook() throws InterruptedException {
			
			WebElement shopMenu = driver.findElement(By.xpath("//*[@id='menu-item-40']/a"));
			
			shopMenu.click();
			
			WebElement siteLogoHomeMenu = driver.findElement(By.xpath("//*[@id='content']/nav/a"));
			siteLogoHomeMenu.click();
				
//				5) Test whether the Home page has Three Arrivals only
				List<WebElement> arrivals = driver.findElements(By.xpath("//*[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div"));
				
//				6) The Home page must contains only three Arrivals
				Assert.assertEquals(3, arrivals.size());

//				7) Now click the image in the Arrivals
				
				WebElement arrival3 = driver.findElement(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div[3]"));
				arrival3.click();

//				8) Test whether it is navigating to next page where the user can add that book into his basket.
				WebElement clickBook1 = driver.findElement(By.xpath("//*[@id=\"product-165\"]/div[5]/ul/li[1]/a[1]"));
				clickBook1.click();
				

				
//				9) Image should be clickable and should navigate to next page where user can add that book to his basket
//				WebElement addToBasket1 = driver.findElement(By.xpath("//*[@id=\"product-170\"]/div[2]/form/button"));
//				addToBasket1.click();

				
//				10) Click on the Add To Basket button which adds that book to your basket
				WebElement addToBasket1 = driver.findElement(By.xpath("//*[@id=\"product-170\"]/div[2]/form/button"));
				addToBasket1.click();
				
//				11) User can view that Book in the Menu item with price.
				
				Boolean priceText = driver.findElement(By.xpath("//*[@id=\"product-170\"]/div[2]/div[1]/p/span")).isDisplayed();
								        Assert.assertTrue(priceText);
								      //*[@id="product-170"]/div[2]/div[1]/p/span
								        
//				12) Now click on Item link which navigates to proceed to check out page.
				WebElement checkOut1 = driver.findElement(By.xpath("//*[@id=\"wpmenucartli\"]/a/span[2]"));
				checkOut1.click();
														        
//				13) Now click on Remove this icon in Check out page which removes that book from the grid.
//				14) User has the feasibility to remove the book at the time of check out also	
				
				//click remove this item 
				driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[1]/td[1]/a")).click();
				Thread.sleep(3000);
				
				//Verify that the item has been removed
				String text = driver.findElement(By.xpath("//*[@class='cart-empty']")).getText();
				System.out.println(text);
				String expectedText = "Your basket is currently empty.";
				Assert.assertTrue(text.equals(expectedText));

        
								        
								        
								        
	}

		@AfterClass
		public void tearDown() {
			driver.close();
				
		}
}

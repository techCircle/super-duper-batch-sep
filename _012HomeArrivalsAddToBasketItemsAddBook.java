package PracticeAutomation51TestCases.HomePage18;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.List;
import java.util.Locale;
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

public class _012HomeArrivalsAddToBasketItemsAddBook {

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
	public void AddBook() throws InterruptedException {
			
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
				
//				13) Click on textbox value under quantity in Check out page to add or subtract books.
//				14) Now after the above change ‘Update Basket’ button will turn into Clickable mode.
//				15) Now click on Update Basket to reflect those changes
//				16) User has the feasibility to Update Basket at the time of check out.
				
				//add more book
				String quantityItem = "3";
				driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input")).clear();
				driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input")).sendKeys(quantityItem);
				
				//click update basket button
				driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[2]/td/input[1]")).click();
				
				//Verify if price has been updated
				String pricePerItem = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[1]/td[4]/span")).getText();
				Thread.sleep(2000);
				
				String totalPrice = driver.findElement(By.xpath("//td[@class='product-subtotal']/span")).getText();
//				System.out.println(pricePerItem + "  " + totalPrice);
				
//				BigDecimal parsedPrice = Currency.parse(pricePerItem, Locale.US);			
//				BigDecimal parsedTotal = Currency.parse(totalPrice, Locale.US);

//				System.out.println(parsedPrice);
//				System.out.println(parsedTotal);
//				System.out.println("Price per item is : "+ pricePerItem  +" "+ "Total price is : " + totalPrice);
				
//				Assert.assertTrue(Double.valueOf(numItem) * Double.valueOf(parsedPrice.toString()) == Double.valueOf(parsedTotal.toString()));
				
				
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
			
	}
}
				
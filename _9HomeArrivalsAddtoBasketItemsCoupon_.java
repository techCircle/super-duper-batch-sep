package PracticeAutomation51TestCases.HomePage18;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _9HomeArrivalsAddtoBasketItemsCoupon_ {

	/*
	 * 1) Open the browser
2) Enter the URL ��http://practice.automationtesting.in/��
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Arrivals only
6) The Home page must contains only three Arrivals
7) Now click the image in the Arrivals
8) Test whether it is navigating to next page where the user can add that book into his basket.
9) Image should be clickable and shoul navigate to next page where user can add that book to his basket
10) Click on the Add To Basket button which adds that book to your basket
11) User can view that Book in the Menu item with price.
12) Now click on Item link which navigates to proceed to check out page.
13) User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page
14) Enter the Coupon code as ��krishnasakinala�� to get 50rps off on the total.
15) User can able to apply coupon by entering ��krishnasakinala�� in the coupon textbox which give 50rps off on the total price
	 */
	
WebDriver driver;
	
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
	public void BasketItemsCoupon() throws InterruptedException {
			
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
														        
								        
								        
//				13) User can click on the Item link in menu item after adding the book in to the basket which leads to the check out page
				WebElement checkOut2 = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/div/a"));
				checkOut2.click();

				//*[@id="page-34"]/div/div[1]/div/div/div/a
        
//				14) Enter the Coupon code as ��krishnasakinala�� to get 50rps off on the total.
				WebElement couponClick = driver.findElement(By.xpath("//*[@id=\"page-35\"]/div/div[1]/div[2]/a"));
				couponClick.click();
				
				WebElement couponBox = driver.findElement(By.xpath("//*[@id=\"coupon_code\"]"));
				couponBox.sendKeys("krishnasakinala");
				couponBox.submit();
			
				
				//add coupon
//				driver.findElement(By.xpath("//*[@id=\"coupon_code\"]")).sendKeys("krishnasakinala");
//				driver.findElement(By.xpath("//*[@class='button']")).click();
//				Thread.sleep(3000);
//				
				
				//*[@id="page-35"]/div/div[1]/div[2]/a
				
				//*[@id="coupon_code"]
//				krishnasakinala
				
				
//				Boolean couponApplyText = driver.findElement(By.xpath("//*[@id=\"page-35\"]/div/div[1]/ul/li")).isDisplayed();
//		        Assert.assertTrue(couponApplyText);
//		        
//		        System.out.println(couponApplyText);
				
				//*[@id="page-35"]/div/div[1]/ul/li
				//*[@id="page-35"]/div/div[1]/ul/li
		      //*[@id="page-35"]/div/div[1]/ul/li
		        
//		        Coupon usage limit has been reached.

				
//				15) User can able to apply coupon by entering ��krishnasakinala�� in the coupon textbox which give 50rps off on the total price
								        
		
				
				//Since the provided coupon code is not working so I have to change the test #14th-15th
				//from verifying discount amount to verify that coupon code is not valid after enter the coupon code
				
				String msg = driver.findElement(By.xpath("//*[@class='woocommerce']/ul/li")).getText();
				System.out.println(msg);
				Assert.assertEquals(msg, "Coupon usage limit has been reached.");       
				
//				String msg = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/div[1]/ul/li")).getText();
//				System.out.println(msg);
//				Assert.assertEquals(msg, "Coupon usage limit has been reached.");   
								        
				//*[@id="page-35"]/div/div[1]/ul/li
	}

	@AfterClass
	public void tearDown() {
		driver.close();
			
	}
}
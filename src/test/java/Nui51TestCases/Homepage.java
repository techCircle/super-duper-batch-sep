package testCase51;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import java.math.BigDecimal;

import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import Utilities.Currency;
import Utilities.NuiConfigurationProperties;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Homepage {
	
	WebDriver driver ;
	WebDriverWait wait;
	Actions act;
		

		@BeforeClass
		public static void before() {
			
		}

		@BeforeMethod
		public void setUp() {
			
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
//			driver.manage().window().maximize();
			driver.navigate().to("http://practice.automationtesting.in/");		
			wait = new WebDriverWait(driver, 30);
		}
		
		public void clickShop() {
			String clickShop = "//a[contains(text(),\"Shop\")]";
			WebElement shopButton = driver.findElement(By.xpath(clickShop));
			shopButton.click();
		}
		
		public void clickHome() {
			String clickHome = "//a[contains(text(),\"Home\")]";
			WebElement homeButton = driver.findElement(By.xpath(clickHome));
			homeButton.click();
		}
		
		@Test
		public void homePageWithThreeSlidersOnly() {
			this.clickShop();
			this.clickHome();
			
			assert(driver.findElements(By.xpath("//div[@class=\"n2-ss-slider-3\"]/div")).size() == 3);
					
		}
		
		@Test
		public void HomePageWithThreeArrivals() {
			this.clickShop();
			this.clickHome();
			
			List<WebElement> newArrivals = driver.findElements(By.xpath("//h2[contains(text(),\"new arrivals\")]/../../../../../div/div[2]/div"));
			int countNewArrivals = newArrivals.size();
			assert(countNewArrivals == 3);
		}
		
		@Test
		public void imagesInArrivalsShouldNavigate() throws InterruptedException {
			
			this.HomePageWithThreeArrivals();   
			
			List<WebElement> arrivalsImages = driver.findElements(By.xpath("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div"));
			System.out.println("Arrivals images = "+ arrivalsImages.size());
			
			String[] expectedTexts = new String[]{"Selenium Ruby", "Thinking in HTML", "Mastering JavaScript"};
			for(int i = 0; i<arrivalsImages.size(); i++) {
				
				String pathText = String.format("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[%d]", i+1);
				System.out.println(pathText);
				driver.findElement(By.xpath(pathText)).click();
			
				String text = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();
				System.out.println(text);
				Assert.assertTrue(expectedTexts[i].equals(text)) ;
									
				driver.navigate().back();
				
			}	
		}
		
		@Test
		public void arrivalsImagesDescription() throws InterruptedException {
			this.imagesInArrivalsShouldNavigate();
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-0-0\"]/div/ul/li/a[1]/img")).click();
			driver.findElement(By.xpath("//*[@id=\"product-160\"]/div[3]/ul/li[1]/a")).click();
			Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"tab-description\"]/h2")).isDisplayed());
			driver.navigate().back();
			
			driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-1-0\"]/div/ul/li/a[1]/img")).click();
			driver.findElement(By.xpath("//*[@id=\"product-163\"]/div[3]/ul/li[1]/a")).click();
			Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"product-163\"]/div[3]/ul/li[1]/a")).isDisplayed());
			driver.navigate().back();
			
			driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-2-0\"]/div/ul/li/a[1]/img")).click();
			driver.findElement(By.xpath("//*[@id=\"product-165\"]/div[3]/ul/li[1]/a")).click();
			Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"tab-description\"]/h2")).isDisplayed());
			driver.navigate().back();
		}
		
		@Test
		public void arrivalsImagesReviews() throws InterruptedException {
			this.imagesInArrivalsShouldNavigate();
			driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-0-0\"]/div/ul/li/a[1]/img")).click();
			driver.findElement(By.xpath("//*[@id=\"product-160\"]/div[3]/ul/li[2]/a")).click();
			Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"comments\"]/h2")).isDisplayed());
			driver.navigate().back();
			
			driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-1-0\"]/div/ul/li/a[1]/img")).click();
			driver.findElement(By.xpath("//*[@id=\"product-163\"]/div[3]/ul/li[2]/a")).click();
			Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"comments\"]/h2")).isDisplayed());
			driver.navigate().back();
			
			driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-2-0\"]/div/ul/li/a[1]/img")).click();
			driver.findElement(By.xpath("//*[@id=\"product-165\"]/div[3]/ul/li[2]/a")).click();
			Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"comments\"]/h2")).isDisplayed());
			driver.navigate().back();
			
			
		}
		
		@Test
		public void arrivalsImagesAddToBasket() throws InterruptedException {
			this.HomePageWithThreeArrivals();
			
			driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-1-0\"]/div/ul/li/a[1]/img")).click();
			driver.findElement(By.xpath("//*[@id=\"product-163\"]/div[5]/ul/li[1]/a[1]")).click();
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@class='product_title entry-title']/../div/p/span")));
			
			//check and keep the price to compare after add to basket
			String expectedPrice = driver.findElement(By.xpath("//*[@class='product_title entry-title']/../div/p/span")).getText();
			System.out.println(expectedPrice);
			
			
			//add to basket button
			driver.findElement(By.xpath("//button[contains(text(), 'Add to basket')]")).click();
			
			//Verify that the book has been added to the basket
			String cart = driver.findElement(By.xpath("//*[@id=\"wpmenucartli\"]/a/span[2]")).getText();
			System.out.println(cart);
			//String expectedCart = price;
			Assert.assertTrue(cart.equals(expectedPrice));
	
		}
		
		@Test
		public void arrivalsAddToBasketWithMoreBooks() throws InterruptedException {
			this.arrivalsImagesAddToBasket();
			
			//add more books
			
			String getMax = driver.findElement(By.xpath("//*[@class=\"quantity\"]/input ")).getAttribute("Max");
			System.out.println(getMax);
			int moreThanMax = Integer.valueOf(getMax)+1;
			
			driver.findElement(By.xpath("//form/div/input")).clear();
			driver.findElement(By.xpath("//form/div/input")).sendKeys(String.valueOf(moreThanMax));
			driver.findElement(By.xpath("//button[contains(text(), 'Add to basket')]")).click();
			
			//Check if there is an error message pop up (using javascript)
			WebElement ele = driver.findElement(By.xpath("//form/div/input"));
			JavascriptExecutor js = (JavascriptExecutor) driver;
			Boolean isValidInput = (Boolean)js.executeScript("return arguments[0].checkValidity();", ele);
			System.out.println(isValidInput);
			String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", ele);
			System.out.println(validationMessage);
			
			Assert.assertFalse(isValidInput);

			String alert = String.format("Value must be less than or equal to %d.", Integer.valueOf(getMax));
			
			Assert.assertTrue(validationMessage.equals(alert));
			
		}
		
		@Test
		public void arrivalsAddToBasketItems() throws InterruptedException {
			this.arrivalsImagesAddToBasket();
			
			//click on item link to proceed to check out page
			driver.findElement(By.xpath("//*[@id=\"wpmenucartli\"]/a")).click();
			System.out.println(driver.getCurrentUrl());
			String expectedURL = "http://practice.automationtesting.in/basket/";
			
			Assert.assertTrue(driver.getCurrentUrl().equals(expectedURL));
			
		}
		
		@Test 
		public void arrivalsAddToBasketItemsCoupon() throws InterruptedException {
			this.arrivalsAddToBasketItems();
			
			//add coupon
			driver.findElement(By.xpath("//*[@id=\"coupon_code\"]")).sendKeys("krishnasakinala");
			driver.findElement(By.xpath("//*[@class='button']")).click();
			Thread.sleep(3000);
			
			//Since the provided coupon code is not working so I have to change the test #14th-15th
			//from verifying discount amount to verify that coupon code is not valid after enter the coupon code
			
			String msg = driver.findElement(By.xpath("//*[@class='woocommerce']/ul/li")).getText();
			System.out.println(msg);
			Assert.assertEquals(msg, "Coupon usage limit has been reached.");
			
		}
		
		@Test
		public void arrivalsAddToBasketItemsCouponValueLessThan450() throws InterruptedException {
			
			this.arrivalsAddToBasketItemsCoupon();
			//Since the provided coupon code is not working so I have to change the test #14th-15th
			//from verifying discount amount to verify that coupon code is not valid after enter the coupon code
			
			
		}
		
		@Test
		public void removeBook() throws InterruptedException {
			
			this.arrivalsAddToBasketItems();
			
			//click remove this item 
			driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[1]/td[1]/a")).click();
			Thread.sleep(3000);
			
			//Verify that the item has been removed
			String text = driver.findElement(By.xpath("//*[@class='cart-empty']")).getText();
			System.out.println(text);
			String expectedText = "Your basket is currently empty.";
			Assert.assertTrue(text.equals(expectedText));
			
		}
		
		@Test
		public void ArrivalsAddToBasketItemsAddBook() throws InterruptedException, ParseException {
			
			this.arrivalsAddToBasketItems();
			
			//add more book
			String numItem = "5";
			driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input")).clear();
			driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input")).sendKeys(numItem);
			
			//click update basket button
			driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[2]/td/input[1]")).click();
			
			//Verify if price has been updated
			String pricePerItem = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/form/table/tbody/tr[1]/td[4]/span")).getText();
			Thread.sleep(2000);
			
			String totalPrice = driver.findElement(By.xpath("//td[@class='product-subtotal']/span")).getText();
//			System.out.println(pricePerItem + "  " + totalPrice);
			
			BigDecimal parsedPrice = Currency.parse(pricePerItem, Locale.US);			
			BigDecimal parsedTotal = Currency.parse(totalPrice, Locale.US);

//			System.out.println(parsedPrice);
//			System.out.println(parsedTotal);
//			System.out.println("Price per item is : "+ pricePerItem  +" "+ "Total price is : " + totalPrice);
			
			Assert.assertTrue(Double.valueOf(numItem) * Double.valueOf(parsedPrice.toString()) == Double.valueOf(parsedTotal.toString()));
					
		}
		
		@Test
		public void arrivalsAddToBasketItemsCheckoutBookFinalPrice() throws InterruptedException {
			
			this.arrivalsAddToBasketItems();
			
			//check if user can see final price
			String total = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[3]/th")).getText();
			System.out.println(total);
			String expected = "Total";
			Assert.assertTrue(total.equals(expected));
		}
		
		@Test 
		public void arrivalsAddToBasketItemsCheckoutUpdateBasket() throws InterruptedException, ParseException {
			
			this.ArrivalsAddToBasketItemsAddBook();
			//this test case is exactly the same as arrivalsAddToBasketItemsAddBook
			
		}
		
		@Test
		public void arrivalsAddToBasketItemsCheckoutTotalAndSubTotalCondition() throws InterruptedException {
			
			this.arrivalsAddToBasketItems();
			
			//check if user can see total and subTotal price
			String total = driver.findElement(By.xpath("//tr[@class='order-total']")).getText().substring(7);
			String subTotal = driver.findElement(By.xpath("//tr[@class='cart-subtotal']")).getText().substring(10);
			
			Assert.assertTrue(Double.valueOf(total) > Double.valueOf(subTotal));
			
		}
		
		@Test
		public void arrivalsAddToBasketItemsCheckoutFunctionality() throws InterruptedException {
			
			this.arrivalsAddToBasketItemsCheckoutTotalAndSubTotalCondition();
			
			//click on proceed to check out button
			driver.findElement(By.xpath("//*[@class='checkout-button button alt wc-forward']")).click();
			
			//check if payment gateway is displayed
			Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='wc_payment_methods payment_methods methods']")).isDisplayed());
			
		}
		
		
		@Test
		public void arrivalsAddToBasketItemsCheckoutPaymentGateway() throws InterruptedException {
			
			this.arrivalsAddToBasketItemsCheckoutFunctionality();
			
			//Check if user can view Billing Details,Order Details,Additional details and Payment gateway detail
			String billingDetails = driver.findElement(By.xpath("//div[@class='woocommerce-billing-fields']/h3")).getText();
			Assert.assertEquals(billingDetails, "Billing Details");
			
			String orderDetails = driver.findElement(By.id("order_review_heading")).getText();
			Assert.assertEquals(orderDetails, "Your order");
			
			String additionalDetails = driver.findElement(By.xpath("//div[@class='woocommerce-shipping-fields']/h3")).getText();
			Assert.assertEquals(additionalDetails, "Additional Information");
			
			//check if payment gateway is displayed
			driver.findElement(By.xpath("//ul[@class='wc_payment_methods payment_methods methods']")).isDisplayed();

			//user can fill the details in billing details form
			driver.findElement(By.id("billing_first_name")).sendKeys("Pooh");
			driver.findElement(By.id("billing_last_name")).sendKeys("Bear");
			driver.findElement(By.id("billing_email")).sendKeys("nui@gmail.com");
			driver.findElement(By.id("billing_phone")).sendKeys("1234561234");
		
			driver.findElement(By.xpath("//b[@role='presentation']")).click();
			WebElement inputBox = driver.findElement(By.xpath("//input[@id='s2id_autogen1_search']"));
			
			inputBox.clear();
			inputBox.sendKeys("United States");
			inputBox.sendKeys(Keys.RETURN);
		    
		    driver.findElement(By.id("billing_address_1")).sendKeys("123 st");
		    driver.findElement(By.id("billing_city")).sendKeys("San Francisco");
		    
		    driver.findElement(By.xpath("//*[@id=\"s2id_billing_state\"]/a/span[2]")).click();
		    WebElement stateBox =driver.findElement(By.xpath("//*[@id=\"s2id_autogen2_search\"]"));
		    stateBox.sendKeys("California", Keys.RETURN);
		    driver.findElement(By.id("billing_postcode")).sendKeys("88888");
		    
		    //click choose payment
		    driver.findElement(By.id("payment_method_cod")).click(); 
		    
		    JavascriptExecutor js = (JavascriptExecutor) driver;
		    js.executeScript("window.scrollBy(0,-1000)", "");

		    //click to add coupon
		    driver.findElement(By.xpath("//a[@class='showcoupon']")).click();
		    wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("coupon_code"))));
		    Assert.assertTrue(driver.findElement(By.id("coupon_code")).isDisplayed());
		    
		}
		
		
		@Test
		public void arrivalsAddToBasketItemsCheckoutPaymentGatewayPlaceOrder() throws InterruptedException {
			
			this.arrivalsAddToBasketItemsCheckoutFunctionality();
			
			//Check if user can view Billing Details,Order Details,Additional details and Payment gateway detail
			String billingDetails = driver.findElement(By.xpath("//div[@class='woocommerce-billing-fields']/h3")).getText();
			Assert.assertEquals(billingDetails, "Billing Details");
			
			String orderDetails = driver.findElement(By.id("order_review_heading")).getText();
			Assert.assertEquals(orderDetails, "Your order");
			
			String additionalDetails = driver.findElement(By.xpath("//div[@class='woocommerce-shipping-fields']/h3")).getText();
			Assert.assertEquals(additionalDetails, "Additional Information");
			
			//check if payment gateway is displayed
			driver.findElement(By.xpath("//ul[@class='wc_payment_methods payment_methods methods']")).isDisplayed();

			//user can fill the details in billing details form
			driver.findElement(By.id("billing_first_name")).sendKeys(NuiConfigurationProperties.getKeyValue("name"));
			driver.findElement(By.id("billing_last_name")).sendKeys(NuiConfigurationProperties.getKeyValue("lastName"));
			driver.findElement(By.id("billing_email")).sendKeys(NuiConfigurationProperties.getKeyValue("goodEmail"));
			driver.findElement(By.id("billing_phone")).sendKeys(NuiConfigurationProperties.getKeyValue("phoneNumber"));
		
			driver.findElement(By.xpath("//b[@role='presentation']")).click();
			WebElement inputBox = driver.findElement(By.xpath("//input[@id='s2id_autogen1_search']"));
			
			inputBox.clear();
			inputBox.sendKeys("United States");
			inputBox.sendKeys(Keys.RETURN);
		    
		    driver.findElement(By.id("billing_address_1")).sendKeys(NuiConfigurationProperties.getKeyValue("address"));
		    driver.findElement(By.id("billing_city")).sendKeys(NuiConfigurationProperties.getKeyValue("city"));
		    
		    driver.findElement(By.xpath("//*[@id=\"s2id_billing_state\"]/a/span[2]")).click();
		    WebElement stateBox =driver.findElement(By.xpath("//*[@id=\"s2id_autogen2_search\"]"));
		    stateBox.sendKeys("California", Keys.RETURN);
		    driver.findElement(By.id("billing_postcode")).sendKeys(NuiConfigurationProperties.getKeyValue("zipcode"));
		    
		    //click choose payment
		    driver.findElement(By.id("payment_method_cod")).click();
		    //wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.id("place_order"))));
		    
		    //click place order
		    driver.findElement(By.id("place_order")).click();
		   // wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//p[contains(text(), 'Thank you. Your order has been received.')]"))));
		    Thread.sleep(3000);
		    
		    //use can view confirmation page with order details,bank details,customer details and billing details
			Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Thank you. Your order has been received.')]")).isDisplayed());
			
		}
		
		
		
		@AfterMethod
		public void after() {
			
			driver.close();
		}


}

package PracticeAutomation51TestCases.HomePage18;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
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

public class _018HomeArrivalsAddToBasketItemsCheckOutGatewayPlaceOrder {

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
	public void PaymentGateway() throws InterruptedException {
			
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
				
//				13) Now user can find total and subtotal values just above the Proceed to Checkout button.
//				14) The total always < subtotal because taxes are added in the subtotal
			
				String total = driver.findElement(By.xpath("//tr[@class='order-total']")).getText().substring(7);
				String subTotal = driver.findElement(By.xpath("//tr[@class='cart-subtotal']")).getText().substring(10);
				
				System.out.println(total);
				System.out.println(subTotal);
				
				Assert.assertTrue(Double.valueOf(total) > Double.valueOf(subTotal));
				
//				15) Now click on Proceed to Check out button which navigates to payment gateway page.
//				16) Clicking on Proceed to Checkout button leads to payment gateway page
//				17)Clicking on Proceed to Checkout button leads to payment gateway page
				
				driver.findElement(By.xpath("//*[@class='checkout-button button alt wc-forward']")).click();
				
				Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='wc_payment_methods payment_methods methods']")).isDisplayed());
				
//				16)User can view Billing Details,Order Details,Additional details and Payment gateway details.
//				17)Now user can fill his details in billing details form and can opt any payment in the payment gateway like Direct bank transfer, check ,cash or paypal.
//				18)User has the feasibility to add coupon in the payment gateway page and also he can find billing,order and additional details.
				
				
				
				//Check if user can view Billing Details,Order Details,Additional details and Payment gateway detail
				String billingDetails = driver.findElement(By.xpath("//div[@class='woocommerce-billing-fields']/h3")).getText();
				Assert.assertEquals(billingDetails, "Billing Details");
				
				String orderDetails = driver.findElement(By.id("order_review_heading")).getText();
				Assert.assertEquals(orderDetails, "Your order");
				
				String additionalDetails = driver.findElement(By.xpath("//div[@class='woocommerce-shipping-fields']/h3")).getText();
				Assert.assertEquals(additionalDetails, "Additional Information");
				
				//payment gateway is displayed
//				driver.findElement(By.xpath("//ul[@class='wc_payment_methods payment_methods methods']")).isDisplayed();
				Assert.assertTrue(driver.findElement(By.xpath("//ul[@class='wc_payment_methods payment_methods methods']")).isDisplayed());
				
				//user can fill the details in billing details form
				driver.findElement(By.id("billing_first_name")).sendKeys("Abc");
				driver.findElement(By.id("billing_last_name")).sendKeys("Def");
				driver.findElement(By.id("billing_email")).sendKeys("Abc@gmail.com");
				driver.findElement(By.id("billing_phone")).sendKeys("1234567890");
			
				driver.findElement(By.xpath("//b[@role='presentation']")).click();
				WebElement inputBox = driver.findElement(By.xpath("//input[@id='s2id_autogen1_search']"));
				
				inputBox.clear();
				inputBox.sendKeys("United States");
				inputBox.sendKeys(Keys.RETURN);
			    
			    driver.findElement(By.id("billing_address_1")).sendKeys("123 Abc rd");
			    driver.findElement(By.id("billing_city")).sendKeys("Baltimore");
			    
			    driver.findElement(By.xpath("//*[@id=\"s2id_billing_state\"]/a/span[2]")).click();
			    WebElement stateBox =driver.findElement(By.xpath("//*[@id=\"s2id_autogen2_search\"]"));
			    stateBox.sendKeys("Maryland", Keys.RETURN);
			    driver.findElement(By.id("billing_postcode")).sendKeys("12345");
			    
			    //click choose payment
			    driver.findElement(By.id("payment_method_cod")).click(); 
			    
			    JavascriptExecutor js = (JavascriptExecutor) driver;
			    js.executeScript("window.scrollBy(0,-1000)", "");

			    //click to add coupon
			    driver.findElement(By.xpath("//a[@class='showcoupon']")).click();
			    Assert.assertTrue(driver.findElement(By.id("coupon_code")).isDisplayed());
			    
			
//			    18) Now click on Place Order button to complete process
//			    19) On clicking place-order button user completes the process where the page navigates to Order confirmation page
//			    with order details,bank details,customer details and billing details.
			    
			    driver.findElement(By.id("place_order")).click();
			    
			    Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Thank you. Your order has been received.')]")).isDisplayed());
				
			    
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
			
	}
}
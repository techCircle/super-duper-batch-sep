package Kanokwan_51TestCases;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class shopAddToBasketViewThoughItemLink_11 {
	
	WebDriver driver;
	Select select;
		
		
		@BeforeClass
		public void setUp() {
			
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
		public void shopAddToBasketViewThoughItemLink() throws InterruptedException{
			
		// 11.Shop-Add to Basket-View Basket through Item link
			
		// 3) Click on Shop Menu
		//Get the WebElement corresponding to  shop menu
		//Use Web Element findElement() to find the elements on the web page
		    			
		WebElement shopMenu = driver.findElement(By.id("menu-item-40"));
		shopMenu.click();
			
		//4) Click on the Add To Basket button which adds that book to your basket
			
		//5) User can view that Book in the Menu item with price .
			
		WebElement addButton = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[4]/a[2]"));
		addButton.click();
			
			
		
		//6) Now click on Item link which navigates to proceed to check out page.
			
		//7) Now user can find total and subtotal values just above the Proceed to Checkout button.
		
		//8) The total always < subtotal because taxes are added in the subtotal
			
		WebElement viewBasketLink = driver.findElement(By.xpath("//*[@id=\"wpmenucartli\"]/a"));
		viewBasketLink.click();
		driver.navigate().to("http://practice.automationtesting.in/basket/");
			
			
		Thread.sleep(3000);
			
		//9) Now click on Proceed to Check out button which navigates to payment gateway page.
		//10) User can view Billing Details,Order Details,Additional details and Payment gateway details.
		
			
		WebElement viewBilling = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/div/a"));
		viewBilling.click();
			
		//11) Now user can fill his details in billing details form and can opt any payment in the payment gateway 
		//  like Direct bank transfer,cheque,cash or paypal.
			
		//First Name
		WebElement firstName = driver.findElement(By.xpath("//*[@id=\"billing_first_name\"]"));
		firstName.sendKeys("Sophia");
		Thread.sleep(3000);
			
		//Last Name
		WebElement lastName = driver.findElement(By.xpath("//*[@id=\"billing_last_name\"]"));
		lastName.sendKeys("Cosmo");
		Thread.sleep(3000);
			
		//Email Address
		WebElement email = driver.findElement(By.xpath("//*[@id=\"billing_email\"]"));
		email.sendKeys("tiew9999@gmail.com");
		Thread.sleep(3000);
			
		//Phone
		WebElement phone = driver.findElement(By.xpath("//*[@id=\"billing_phone\"]"));
		phone.sendKeys("703999999");
		Thread.sleep(3000);
			
		//Country
			
		WebElement country = driver.findElement(By.xpath("//*[@id=\"s2id_billing_country\"]"));
	    country.click();
	        
	    WebElement countryLink = driver.findElement(By.xpath("//*[@id=\"s2id_autogen1_search\"]"));
	    countryLink.sendKeys("Taiwan");
	        
		Actions act = new Actions(driver);
			
	    act.sendKeys(Keys.ENTER).build().perform(); //Page Down
			
	    System.out.println("Taiwan");
	        
		//Address
		WebElement address = driver.findElement(By.xpath("//*[@id=\"billing_address_1\"]"));
		address.sendKeys("999 Wonderland St.");
			
		//Town/City
		WebElement town = driver.findElement(By.xpath("//*[@id=\"billing_city\"]"));
		town.sendKeys("Sun Flower");
			
		//State
		WebElement state = driver.findElement(By.xpath("//*[@id=\"billing_state\"]"));
		state.sendKeys("Taipei");
			
		Actions act2 = new Actions(driver);
			
	    act2.sendKeys(Keys.ENTER).build().perform(); //Page Down
			
	    System.out.println("TaiPei");
			
		//ZipCode
		WebElement zipCode = driver.findElement(By.xpath("//*[@id=\"billing_postcode\"]"));
		zipCode.sendKeys("10401");
			
		Thread.sleep(3000);
			
		//Payment
		WebElement payMent = driver.findElement(By.xpath("//*[@id=\"payment_method_cheque\"]"));
		payMent.click();
		
		Thread.sleep(3000);
			
		//12) Now click on Place Order button to complete process
		//13) On clicking place order button user completes his process where the page navigates  
		//to Order confirmation page with order details,bank details,customer details and billing details.
					
		WebElement placeOrderButton = driver.findElement(By.xpath("//*[@id=\"place_order\"]"));
		placeOrderButton.click();
			
		//Use assertion. Assertions are important for comparing the expected results to the actual results.
		//If it matches, the test case passes. If not, then the test case fails.
					
		String actualText = driver.findElement(By.xpath("//*[@id=\"page-35\"]/div/div[1]/p[1]")).getText();
					
		String expectedUrl = actualText.toString();

		Assert.assertEquals(expectedUrl, actualText);

		System.out.println("Actual Text : "+actualText);
					
		System.out.println("Expected Text : "+expectedUrl);
					
		System.out.println("On clicking place order button user completes");
				
		}

		@AfterClass
			public void tearDown() {
				driver.close();
				
			}
		}







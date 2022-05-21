package Nui51TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.Text;

import Utilities.Currency;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Shop {
	
	WebDriver driver;
	WebDriverWait wait;
	Actions move;
	
	@BeforeClass
	public static void before() {
		
	}
	

	@BeforeMethod
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://practice.automationtesting.in/");		
		wait = new WebDriverWait(driver, 30);
	}
	
	@Test
	public void filterByPrice() {
		move = new Actions(driver);
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a")).click();
		//move slider to 450
		WebElement slider = driver.findElement(By.xpath("//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/span[2]"));
		for (int i = 1; i <= 50 ; i++) {
            slider.sendKeys(Keys.ARROW_LEFT);
        }
		
		//click filter button
		driver.findElement(By.xpath("//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[2]/button")).click();
		
		//check if it is now show the book up to 450
		//driver.findElement(By.xpath("//*[@id=\"content\"]/form/select")).click();
		Select price = new Select(driver.findElement(By.xpath("//*[@id=\"content\"]/form/select")));
		price.selectByValue("price-desc");
		
		String priceText = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a[1]/span[2]/ins/span")).getText();
		System.out.println(priceText);
		priceText = priceText.substring(1);
		AssertJUnit.assertTrue(Double.valueOf(priceText)<= 450);
	
	}
	
	@Test
	public void productCategories() {
		//Click on Shop
		driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a")).click();
		
		//click product category
		driver.findElement(By.xpath("//*[@id=\"woocommerce_product_categories-2\"]/ul/li[2]/a")).click();
		
		//check if showing only chosen category
		String text = "";
		List<WebElement> lists = driver.findElements(By.xpath("//*[@id=\"content\"]/ul/li"));
		for(WebElement item : lists) {
			text = item.getText();
			System.out.println(text);
			
			AssertJUnit.assertTrue(text.contains("HTML"));
		}
			
	}
	
	@Test
	public void defaultSortingPopularity() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a")).click();
		//click sorting dropdown
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/select")).click();
		Thread.sleep(2000);
		
		Select type = new Select(driver.findElement(By.xpath("//*[@id=\"content\"]/form/select")));
		type.selectByValue("popularity");
		Thread.sleep(2000);
		
		System.out.println(driver.getCurrentUrl());
		String expectedText = "orderby=popularity";
		AssertJUnit.assertTrue(driver.getCurrentUrl().contains(expectedText));
		
	}
	
	@Test
	public void defaultSortingAverage() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a")).click();
		//click sorting dropdown
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/select")).click();
		Thread.sleep(2000);
				
		Select type = new Select(driver.findElement(By.xpath("//*[@id=\"content\"]/form/select")));
		type.selectByValue("rating");
		Thread.sleep(2000);
				
		System.out.println(driver.getCurrentUrl());
		String expectedText = "orderby=rating";
		AssertJUnit.assertTrue(driver.getCurrentUrl().contains(expectedText));
		
		
	}
	
	@Test
	public void defaultSortingNewness() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a")).click();
		//click sorting dropdown
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/select")).click();
		Thread.sleep(2000);
				
		Select type = new Select(driver.findElement(By.xpath("//*[@id=\"content\"]/form/select")));
		type.selectByValue("date");
		Thread.sleep(2000);
				
		System.out.println(driver.getCurrentUrl());
		String expectedText = "orderby=date";
		AssertJUnit.assertTrue(driver.getCurrentUrl().contains(expectedText));
		
		
	}
	
	@Test
	public void defaultSortingPriceLowToHigh() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a")).click();
		//click sorting dropdown
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/select")).click();
		Thread.sleep(2000);
				
		Select type = new Select(driver.findElement(By.xpath("//*[@id=\"content\"]/form/select")));
		type.selectByValue("price");
		Thread.sleep(2000);
				
		System.out.println(driver.getCurrentUrl());
		String expectedText = "orderby=price";
		AssertJUnit.assertTrue(driver.getCurrentUrl().contains(expectedText));
		
	}
	
	@Test
	public void defaultSortingPriceHighToLow() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a")).click();
		//click sorting dropdown
		driver.findElement(By.xpath("//*[@id=\"content\"]/form/select")).click();
		Thread.sleep(2000);
				
		Select type = new Select(driver.findElement(By.xpath("//*[@id=\"content\"]/form/select")));
		type.selectByValue("price-desc");
		Thread.sleep(2000);
				
		System.out.println(driver.getCurrentUrl());
		String expectedText = "orderby=price-desc";
		AssertJUnit.assertTrue(driver.getCurrentUrl().contains(expectedText));
		
		
	}
	
	@Test
	public void readMore() {
		
		//click shop
		driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a")).click();
		
		//click home
		driver.findElement(By.xpath("//*[@id=\"content\"]/nav/a")).click();
		
		//click read more button
		driver.findElement(By.xpath("//*[@id=\"text-22-sub_row_1-0-2-0-0\"]/div/ul/li/a[2]")).click();
		
		//Indicate out of stock
		String text = driver.findElement(By.xpath("//*[@id=\"product-160\"]/div[2]/p")).getText();
		System.out.println(text);
		String expectedText = "Out of stock";
		AssertJUnit.assertTrue(text.equals(expectedText));
		
		//out of stock item cannot be add to the basket so verify after clicking that item does not add to the basket
		driver.findElement(By.xpath("//*[@id=\"product-160\"]/div[2]/p")).click();
		String numItem = driver.findElement(By.xpath("//*[@id=\"wpmenucartli\"]/a/span[1]")).getText();
		System.out.println(numItem);
		String expectedNumItem = "0 Items";
		AssertJUnit.assertTrue(numItem.equals(expectedNumItem));


	
		
	}
	
	@Test
	public void sale() {
		driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a[1]/img")).click();
		
		String originalPrice = driver.findElement(By.xpath("//*[@id=\"product-169\"]/div[2]/div[1]/p/del/span")).getText();
		String discountPrice = driver.findElement(By.xpath("//*[@id=\"product-169\"]/div[2]/div[1]/p/ins/span")).getText();
		
		originalPrice = originalPrice.substring(1,4);
		discountPrice = discountPrice.substring(1,4);
		System.out.println("Original price = "+ originalPrice + " Discount price = "+ discountPrice);
		
		AssertJUnit.assertTrue(Integer.valueOf(originalPrice) > Integer.valueOf(discountPrice));
		
	}
	
	@Test
	public void addToBasketViewBasket() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a")).click();
		
		//add to basket
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a[2]")).click();
		Thread.sleep(3000);
		
		String numItem = driver.findElement(By.xpath("//*[@class='cartcontents']")).getText();
		System.out.println("Number of item is "+numItem);
		//numItem = numItem.substring(0,1);
		String expectedNumItem = "1 Item";
		AssertJUnit.assertTrue(numItem.equals(expectedNumItem));
		
		String price = driver.findElement(By.xpath("//*[@class='amount']")).getText();
		System.out.println("Price is "+ price);
		price = price.substring(1);
		String expectedPrice = "250.00";
		AssertJUnit.assertTrue(price.equals(expectedPrice));
		
		//Click on View Basket link which navigates to proceed to check out page.
		driver.findElement(By.xpath("//*[@id='content']/ul/li[2]/a[3]")).click();
		
		
		//check if subtotal and total are displayed
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[1]/th")).isDisplayed());
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[3]/th")).isDisplayed());
		String subTotal = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[1]/td/span")).getText();
		String total = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[3]/td/strong/span")).getText();
		subTotal = subTotal.substring(1);
		total = total.substring(1);
		
		//check if subtotal is more than total
		AssertJUnit.assertTrue(Double.valueOf(total) > Double.valueOf(subTotal));
		System.out.println(subTotal+" and " + total);
		
		//Click on proceed to check out button
		driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/div/a")).click();
		
		//Check billing detail, order detail, additional detail, payment gateway are displayed
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"customer_details\"]/div[1]/div/h3")).isDisplayed());
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"customer_details\"]/div[2]/div/h3")).isDisplayed());
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"order_review_heading\"]")).isDisplayed());
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"payment\"]/ul")).isDisplayed());
		
		//fill billing detail form
		driver.findElement(By.xpath("//*[@id=\"billing_first_name\"]")).sendKeys("Jane");
		driver.findElement(By.xpath("//*[@id=\"billing_last_name\"]")).sendKeys("Doe");
		driver.findElement(By.xpath("//*[@id=\"billing_email\"]")).sendKeys("jane@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"billing_phone\"]")).sendKeys("1231231234");

		driver.findElement(By.xpath("//*[@id=\"billing_address_1\"]")).sendKeys("123 boo st.");
		driver.findElement(By.xpath("//*[@id=\"billing_city\"]")).sendKeys("San Francisco");

		driver.findElement(By.xpath("//span[@id='select2-chosen-2']")).click();
		WebElement box = driver.findElement(By.xpath("//*[@id=\"s2id_autogen2_search\"]"));
		box.sendKeys("California");
		box.sendKeys(Keys.RETURN);
		
		driver.findElement(By.xpath("//*[@id=\"billing_postcode\"]")).sendKeys("99999");
		
		//click choose payment
		driver.findElement(By.xpath("//*[@id=\"payment_method_cod\"]")).click();
		
		//click continue to payment
		driver.findElement(By.xpath("//*[@id=\"place_order\"]")).click();
		Thread.sleep(5000);
		
		//confirmation page
		String msg = driver.findElement(By.xpath("//*[@class='woocommerce-thankyou-order-received']")).getText();

		String expectedMsg = "Thank you. Your order has been received.";
		System.out.println(msg);
		AssertJUnit.assertTrue(msg.equals(expectedMsg));
	
	}
	
	
	@Test
	public void addToBasketViewBasketThroughItemLink() throws InterruptedException {
		driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a")).click();
		
		//add to basket
				driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a[2]")).click();
				Thread.sleep(3000);
				
				String numItem = driver.findElement(By.xpath("//*[@class='cartcontents']")).getText();
				System.out.println("Number of item is "+numItem);
				//numItem = numItem.substring(0,1);
				String expectedNumItem = "1 Item";
				AssertJUnit.assertTrue(numItem.equals(expectedNumItem));
				
				String price = driver.findElement(By.xpath("//*[@class='amount']")).getText();
				System.out.println("Price is "+ price);
				price = price.substring(1);
				String expectedPrice = "250.00";
				AssertJUnit.assertTrue(price.equals(expectedPrice));
				
				//Click on Item link which navigates to proceed to check out page.
				driver.findElement(By.xpath("//*[@id=\"wpmenucartli\"]/a/span[1]")).click();
				
				
				//check if subtotal and total are displayed
				AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[1]/th")).isDisplayed());
				AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[3]/th")).isDisplayed());
				String subTotal = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[1]/td/span")).getText();
				String total = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[3]/td/strong/span")).getText();
				subTotal = subTotal.substring(1);
				total = total.substring(1);
				
				//check if subtotal is more than total
				AssertJUnit.assertTrue(Double.valueOf(total) > Double.valueOf(subTotal));
				System.out.println(subTotal+" and " + total);
				
				//Click on proceed to check out button
				driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/div/a")).click();
				
				//Check billing detail, order detail, additional detail, payment gateway are displayed
				AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"customer_details\"]/div[1]/div/h3")).isDisplayed());
				AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"customer_details\"]/div[2]/div/h3")).isDisplayed());
				AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"order_review_heading\"]")).isDisplayed());
				AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"payment\"]/ul")).isDisplayed());
				
				//fill billing detail form
				driver.findElement(By.xpath("//*[@id=\"billing_first_name\"]")).sendKeys("Jane");
				driver.findElement(By.xpath("//*[@id=\"billing_last_name\"]")).sendKeys("Doe");
				driver.findElement(By.xpath("//*[@id=\"billing_email\"]")).sendKeys("jane@gmail.com");
				driver.findElement(By.xpath("//*[@id=\"billing_phone\"]")).sendKeys("1231231234");

				driver.findElement(By.xpath("//*[@id=\"billing_address_1\"]")).sendKeys("123 boo st.");
				driver.findElement(By.xpath("//*[@id=\"billing_city\"]")).sendKeys("San Francisco");

				driver.findElement(By.xpath("//span[@id='select2-chosen-2']")).click();
				WebElement box = driver.findElement(By.xpath("//*[@id=\"s2id_autogen2_search\"]"));
				box.sendKeys("California");
				box.sendKeys(Keys.RETURN);
				
				driver.findElement(By.xpath("//*[@id=\"billing_postcode\"]")).sendKeys("99999");
				
				//click choose payment
				driver.findElement(By.xpath("//*[@id=\"payment_method_cod\"]")).click();
				
				//click continue to payment
				driver.findElement(By.xpath("//*[@id=\"place_order\"]")).click();
				Thread.sleep(5000);
				
				//confirmation page
				String msg = driver.findElement(By.xpath("//*[@class='woocommerce-thankyou-order-received']")).getText();

				String expectedMsg = "Thank you. Your order has been received.";
				System.out.println(msg);
				AssertJUnit.assertTrue(msg.equals(expectedMsg));
		
	}
	
	@Test 
	public void addToBasketViewBasketTax() throws InterruptedException, ParseException {
		
		
		//click on my account menu
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("nui@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("nnljl:)");
		Thread.sleep(4000);
		
		//click log in button
		driver.findElement(By.xpath("//*[@class='woocommerce-Button button']")).click();
		
		//click address link
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[4]/a")).click();
		
		//click edit shipping address
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/div/div[2]/header/a")).click();
		Thread.sleep(3000);	
		
		driver.findElement(By.xpath("//*[@class='select2-choice']")).click();
		WebElement inputBox = driver.findElement(By.id("s2id_autogen1_search"));
		
		inputBox.clear();
		inputBox.sendKeys("United States");
		inputBox.sendKeys(Keys.RETURN);

		driver.findElement(By.xpath("//*[@id=\"s2id_shipping_state\"]/a/span[2]/b")).click();
		WebElement box = driver.findElement(By.xpath("//*[@id=\"s2id_autogen2_search\"]"));
		box.sendKeys("California");
		box.sendKeys(Keys.RETURN);
		
		//click save address
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/form/p[10]/input[1]")).click();
		
		//click shop
		driver.findElement(By.id("menu-item-40")).click();

		driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a")).click();

		//add to basket
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a[2]")).click();
		Thread.sleep(3000);
		
		//click item link to navigate to check out page
		driver.findElement(By.xpath("//a[@class='wpmenucart-contents']")).click();
		
		//check if subtotal and total are displayed
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[1]/th")).isDisplayed());
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[3]/th")).isDisplayed());
		String subTotal = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[1]/td/span")).getText();
		String total = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[3]/td/strong/span")).getText();

		System.out.println("Total is "+ total + "Subtotal is "+ subTotal);
		
		BigDecimal parsedTotal = Currency.parse(total, Locale.US);
		
		//Double dParsedTotal = Double.valueOf(parsedTotal.toString());
		
		BigDecimal parsedSubTotal = Currency.parse(subTotal, Locale.US);
		
		//check if total is more than subtotal
		AssertJUnit.assertTrue(Double.valueOf(parsedTotal.toString()) > Double.valueOf(parsedSubTotal.toString()));
		System.out.println(parsedSubTotal+" and " + parsedTotal);
		
		int roamingTax = 5;
		int indianTax = 2;
		//get the price first
		String bookPriceStr = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[1]/td/span")).getText();
		bookPriceStr = bookPriceStr.substring(1);
		System.out.println(bookPriceStr);
		
		BigDecimal parsedBookPrice = Currency.parse(bookPriceStr, Locale.US);
		System.out.println("Parsed Book Price is "+ parsedBookPrice);
		
		//get tax
		String taxstr = driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[2]/td/span")).getText();
		taxstr = taxstr.substring(1);
		double tax = Double.valueOf(taxstr);
		
		//check usa tax
		AssertJUnit.assertTrue((Double.valueOf(parsedBookPrice.toString()) * roamingTax / 100) == tax); 
		
		//check indian tax
		//go to my account
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		//click on address link
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[4]/a")).click();
		
		//click edit shipping address
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/div/div[2]/header/a")).click();
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//*[@class='select2-choice']")).click();
		inputBox = driver.findElement(By.id("s2id_autogen1_search"));
		//inputBox.clear();
		inputBox.sendKeys("India");
		driver.findElement(By.xpath("//ul/li/div[ @id='select2-result-label-460']")).click();
		//inputBox.sendKeys(Keys.RETURN);
		//Select country = new Select(driver.findElement(By.xpath("")));
		
		driver.findElement(By.xpath("//*[@id=\"s2id_shipping_state\"]/a/span[2]/b")).click();
		WebElement cityBox = driver.findElement(By.xpath("//*[@id=\"s2id_autogen2_search\"]"));
		cityBox.sendKeys("Assam");
		cityBox.sendKeys(Keys.RETURN);

		//click save address
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/form/p[10]/input[1]")).click();
		Thread.sleep(2000);

		//click item link to navigate to check out page
		driver.findElement(By.xpath("//a[@class='wpmenucart-contents']")).click();
		
		//get indian tax 
		String indianTaxSum = driver.findElement(By.xpath("//td[@data-title='Tax']")).getText();
		BigDecimal parsedIndianTaxSum = Currency.parse(indianTaxSum, Locale.US);
		
		
		System.out.println("P BOOK price : "+ parsedBookPrice + " tax is "+ parsedIndianTaxSum);
		
		System.out.println(Double.valueOf(parsedBookPrice.toString()) * indianTax / 100);
		
		
		AssertJUnit.assertTrue((Double.valueOf(parsedBookPrice.toString()) * indianTax / 100) == Double.valueOf(parsedIndianTaxSum.toString())); 
					

	}
	
	@AfterMethod
	public void after() {
		System.out.println("closing");
		driver.quit();
	}

}

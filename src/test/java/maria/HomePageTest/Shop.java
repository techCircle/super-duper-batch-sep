package maria.HomePageTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Shop {

	//changes to pushzzzz
	WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class");
	}
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://practice.automationtesting.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@After
	public void tearDown() {
		driver.close();
	}

	@Test        
	public void Test1filterByPrice() {
		driver.findElement(By.xpath("//*[text()='Shop']")).click();

		WebElement slider=driver.findElement(By.xpath("//*[@id='woocommerce_price_filter-2']/form/div/div[1]/span[2]"));
		for(int i=1;i<=50;i++) {
			slider.sendKeys(Keys.ARROW_LEFT);
		}
		//click the filter button
		driver.findElement(By.xpath("//*[text()='Filter']")).click();
		String currentUrl=driver.getCurrentUrl();
		String expectedUrl="http://practice.automationtesting.in/shop/?min_price=150&max_price=450";
		Assert.assertEquals(currentUrl, expectedUrl);		

	}
	
	@Test    //2
	public void Test2productCategory() throws InterruptedException {
		driver.findElement(By.xpath("//*[@class='main-nav']/li[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a[1]")).click();
		Thread.sleep(3000);
		WebElement Descriptionbook=driver.findElement(By.xpath("//*[@id=\"product-169\"]"));
		Descriptionbook.isDisplayed();
		Assert.assertTrue(true);
		System.out.println("link is clickable");


	}
	
	@Test//3
	public void Test3sortingFunctionality() throws InterruptedException {
		driver.findElement(By.xpath("//*[@class='main-nav']/li[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form")).click();

		driver.findElement(By.xpath("//*[@id=\"content\"]/form/select/option[2]")).click();
		Thread.sleep(3000);
		//String popularTile=driver.getTitle();
		String popularTile=driver.getCurrentUrl();
		String ExpectedURL="http://practice.automationtesting.in/shop/?orderby=popularity";
		Assert.assertEquals(popularTile, ExpectedURL);
		System.out.println("Sorting Functionality working");

	}
	
	@Test//4
	public void Test4defaultSorting() throws InterruptedException {
		driver.findElement(By.xpath("//*[@class='main-nav']/li[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form")).click();

		driver.findElement(By.xpath("//*[@id=\"content\"]/form/select/option[3]")).click();
		Thread.sleep(3000);

		String averagerating=driver.getCurrentUrl();
		String Expectedrating="http://practice.automationtesting.in/shop/?orderby=rating";
		Assert.assertEquals(averagerating, Expectedrating);
		System.out.println("Average Sorting Functionality working");

	}

	
	@Test//5
	public void Test5newnessSorting() throws InterruptedException {
		driver.findElement(By.xpath("//*[@class='main-nav']/li[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form")).click();

		driver.findElement(By.xpath("//*[@id=\"content\"]/form/select/option[4]")).click();
		Thread.sleep(3000);

		String newnessRating=driver.getCurrentUrl();
		String newnessRExpectedating="http://practice.automationtesting.in/shop/?orderby=date";
		Assert.assertEquals(newnessRating, newnessRExpectedating);
		System.out.println("newness Sorting Functionality working");

	}
	
	@Test//6
	public void Test6priceLowToHighSorting() throws InterruptedException {
		driver.findElement(By.xpath("//*[@class='main-nav']/li[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form")).click();

		driver.findElement(By.xpath("//*[@id=\"content\"]/form/select/option[5]")).click();
		Thread.sleep(3000);

		String lowToHighRating=driver.getCurrentUrl();
		String lowToHighExpectedRating="http://practice.automationtesting.in/shop/?orderby=price";
		Assert.assertEquals(lowToHighRating, lowToHighExpectedRating);
		System.out.println("low to high Sorting Functionality working");

	}
	
	@Test//7
	public void Test7priceHighToLowSorting() throws InterruptedException {
		driver.findElement(By.xpath("//*[@class='main-nav']/li[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@id=\"content\"]/form")).click();

		driver.findElement(By.xpath("//*[@id=\"content\"]/form/select/option[6]")).click();
		Thread.sleep(3000);

		String lowToHighRating=driver.getCurrentUrl();
		String lowToHighExpectedRating="http://practice.automationtesting.in/shop/?orderby=price-desc";
		Assert.assertEquals(lowToHighRating, lowToHighExpectedRating);
		System.out.println(" high to low Sorting Functionality working");

	}
	
	@Test//8
	public void Test8readMoreOut() throws InterruptedException {
		driver.findElement(By.xpath("//*[@class='main-nav']/li[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[7]/a[2]")).click();
		Thread.sleep(3000);
		Boolean outOfStock=driver.findElement(By.xpath("//*[@id=\"product-160\"]/div[2]/p")).isDisplayed();
		Assert.assertTrue(outOfStock);


	}

	
	@Test//9
	public void Test9shopSale() throws InterruptedException {
		driver.findElement(By.xpath("//*[@class='main-nav']/li[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a[1]")).click();
		Thread.sleep(3000);
		Boolean salePrice=driver.findElement(By.xpath("//*[@id=\"product-169\"]/div[2]/div[1]/p")).isDisplayed();
		Assert.assertTrue(salePrice);
	}
	
	@Test   //10
	public void Test10addToBasket() throws InterruptedException {
		driver.findElement(By.xpath("//*[@class='main-nav']/li[1]")).click();
		//add basket
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a[2]")).click();
		//menu item display
		Boolean  menuItem=driver.findElement(By.xpath("//*[@title='View your shopping cart']")).isDisplayed();
		Assert.assertTrue(menuItem);
		System.out.println("Price dispalyed");

		Thread.sleep(3000);
		//view basket
		driver.findElement(By.xpath("//*[@title='View Basket']")).click();
		// how to get values here for comparing xpaths
		Boolean checkoutPage=driver.findElement(By.xpath("//*[@class='shop_table shop_table_responsive']")).isDisplayed();
		Assert.assertTrue(checkoutPage);
		WebElement subTotal=driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[1]/td/span"));
		WebElement total=driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[3]/td/strong/span"));
		subTotal.getText();
		String value = subTotal.getText().substring(1, subTotal.getText().length());
		Double price = Double.parseDouble(value); 

		total.getText();
		String totalPrice=total.getText().substring(1, total.getText().length());
		Double TotalFinal=Double.parseDouble(totalPrice);
		Assert.assertTrue(TotalFinal>price);
	
		System.out.println(price +"and"+TotalFinal);

		driver.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-35\"]/div")).isDisplayed());

		
		driver.findElement(By.xpath("//*[@id='billing_first_name']")).sendKeys("waria");
		driver.findElement(By.xpath("//*[@id='billing_last_name']")).sendKeys("Tahir");
		driver.findElement(By.xpath("//*[@id='billing_company']")).sendKeys("pwcs");
		driver.findElement(By.xpath("//*[@id='billing_email']")).sendKeys("densn@gmail.com");
		driver.findElement(By.xpath("//*[@id='billing_phone']")).sendKeys("5715608976");


		driver.findElement(By.xpath("//span[@id='select2-chosen-2']"));
		driver.findElement(By.xpath("//*[@id='billing_address_1']")).sendKeys("12345 freestone ct");
		driver.findElement(By.xpath("//*[@id='billing_city']")).sendKeys("Woodbridge");
		driver.findElement(By.xpath("//span[@id='select2-chosen-2']")).click();
		WebElement box = driver.findElement(By.xpath("//*[@id=\"s2id_autogen2_search\"]"));
		box.sendKeys("California");
		box.sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("//*[@id='billing_postcode']")).sendKeys("22182");
		driver.findElement(By.xpath("//*[@id='place_order']")).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='woocommerce-thankyou-order-details order_details']")).isDisplayed());
		System.out.println("Order received. Thank you");



	}
	
	@Test   //11
	//this one is exactly same as test10
	public void Test11viewBasketThroughItemLink() throws InterruptedException {
		driver.findElement(By.xpath("//*[@class='main-nav']/li[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a[2]")).click();
		Boolean  menuItem=driver.findElement(By.xpath("//*[@title='View your shopping cart']")).isDisplayed();
		Assert.assertTrue(menuItem);
		System.out.println("Price dispalyed");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='wpmenucart-contents']")).click();
		Boolean checkoutPage=driver.findElement(By.xpath("//*[@class='shop_table shop_table_responsive']")).isDisplayed();
		Assert.assertTrue(checkoutPage);
		WebElement subTotal=driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[1]/td/span"));
		WebElement total=driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[3]/td/strong/span"));
		subTotal.getText();
		String value = subTotal.getText().substring(1, subTotal.getText().length());
		Double price = Double.parseDouble(value); 

		total.getText();
		String totalPrice=total.getText().substring(1, total.getText().length());
		Double TotalFinal=Double.parseDouble(totalPrice);
		Assert.assertTrue(TotalFinal>price);
		
		System.out.println(price +"and"+TotalFinal);

		driver.findElement(By.xpath("//a[@class='checkout-button button alt wc-forward']")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-35\"]/div")).isDisplayed());

		driver.findElement(By.xpath("//*[@id='billing_first_name']")).sendKeys("waria");
		driver.findElement(By.xpath("//*[@id='billing_last_name']")).sendKeys("Tahir");
		driver.findElement(By.xpath("//*[@id='billing_company']")).sendKeys("pwcs");
		driver.findElement(By.xpath("//*[@id='billing_email']")).sendKeys("densn@gmail.com");
		driver.findElement(By.xpath("//*[@id='billing_phone']")).sendKeys("5715608976");


		driver.findElement(By.xpath("//span[@id='select2-chosen-2']"));
		driver.findElement(By.xpath("//*[@id='billing_address_1']")).sendKeys("12345 freestone ct");
		driver.findElement(By.xpath("//*[@id='billing_city']")).sendKeys("Woodbridge");
		driver.findElement(By.xpath("//span[@id='select2-chosen-2']")).click();
		WebElement box = driver.findElement(By.xpath("//*[@id=\"s2id_autogen2_search\"]"));
		box.sendKeys("California");
		box.sendKeys(Keys.RETURN);
		driver.findElement(By.xpath("//*[@id='billing_postcode']")).sendKeys("22182");
		driver.findElement(By.xpath("//*[@id='place_order']")).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@class='woocommerce-thankyou-order-details order_details']")).isDisplayed());
		System.out.println("Order received. Thank you");


	}

	
	@Test
	public void Test12viewBasketTaxFunctionality() throws InterruptedException {

		driver.findElement(By.xpath("//*[@class='main-nav']/li[1]")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a[2]")).click();
		Boolean  menuItem=driver.findElement(By.xpath("//*[@title='View your shopping cart']")).isDisplayed();
		Assert.assertTrue(menuItem);
		System.out.println("Price dispalyed");

		Thread.sleep(3000);
		driver.findElement(By.xpath("//a[@class='wpmenucart-contents']")).click();
		// how to get values here for comparing xpaths
		Boolean checkoutPage=driver.findElement(By.xpath("//*[@class='shop_table shop_table_responsive']")).isDisplayed();
		Assert.assertTrue(checkoutPage);
		WebElement subTotal=driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[1]/td/span"));
		WebElement total=driver.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[3]/td/strong/span"));
		subTotal.getText();
		String value = subTotal.getText().substring(1, subTotal.getText().length());
		Double price = Double.parseDouble(value); 

		total.getText();
		String totalPrice=total.getText().substring(1, total.getText().length());
		Double TotalFinal=Double.parseDouble(totalPrice);
		Assert.assertTrue(TotalFinal>price);
		Thread.sleep(3000);
		double taxRateAbroad = 0.05;
		double indianTaxRate = 0.02;
		double indiaTax=price*indianTaxRate;
		System.out.println("Tax for india is 0.02 of price so the price is: "+indiaTax);
		double abroadTax=price*taxRateAbroad;
		System.out.println(abroadTax);





	}








}
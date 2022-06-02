package KanokwanObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import KanokwanUtilities.KanokwanBaseClass;

public class shopPage {
	
	public shopPage() {
		PageFactory.initElements(KanokwanBaseClass.getDriver(), this);
	}
	
	//SHOP
	//Click on Shop Menu
	@FindBy(xpath = "//*[@id=\"menu-item-40\"]")
	public WebElement shopMenuButton;
	
	//Adjust the filter by price between 150 to 450
	@FindBy(xpath = "//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/div")
	public WebElement sliderBar;
	
	//click Functional Programming Product
	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[2]/a[1]/img")
	public WebElement functionalProduct;
	
	//Verify Functional Programming Product
	@FindBy(xpath = "//*[@id=\"product-170\"]/div[2]/h1")
	public WebElement verifyFunctionalProductText;
	
	//Pick a book on read more
	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[7]/a[2]")
	public WebElement readMoreSeleniumRuby;
	
	//Click on sale written product
	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[1]/a[1]/span[1]")
	public WebElement saleProductButton;
	
	//Click on the Add To Basket to add your book to basket
	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[1]/a[2]")
	public WebElement addToBasketButton;
	
	//Click view basket
	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[1]/a[3]")
	public WebElement viewBasketButton;
	
	//Menu Item with price
	@FindBy(xpath = "//*[@id=\"wpmenucartli\"]/a")
	public WebElement cartItemProduct;
	
	//Cart order total and sub total
	@FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[1]")
	public WebElement cartSubtotal;
	
	@FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[3]")
	public WebElement cartTotal;
	
	//Proceed to checkout
	@FindBy(xpath = "//*[@id=\"page-34\"]/div/div[1]/div/div/div/a")
	public WebElement proceedToCheckoutButton;
	
	//view Billing Details,Order Details,Additional details and Payment gateway details
	@FindBy(xpath = "//*[@id=\"customer_details\"]/div[1]/div/h3")
	public WebElement billingDetails;
	
	@FindBy(xpath = "//*[@id=\"order_review_heading\"]")
	public WebElement yourOrder;
	
	@FindBy(xpath = "//*[@id=\"customer_details\"]/div[2]/div/h3")
	public WebElement additionalInformation;
	
	@FindBy(xpath = "//*[@id=\"payment\"]/ul/li[1]/div")
	public WebElement payment;
	
	//fill details in billing details form and can opt any payment
	@FindBy(id = "billing_first_name")
	public WebElement firstName;
	
	@FindBy(id = "billing_last_name")
	public WebElement lastName;
	
	@FindBy(id = "billing_email")
	public WebElement emailAddress;
	
	@FindBy(id = "billing_phone")
	public WebElement phone;
	
	@FindBy(id = "select2-chosen-1")
	public WebElement country;
	
	@FindBy(id = "billing_address_1")
	public WebElement address;
	
	@FindBy(id = "billing_city")
	public WebElement city;
	
	@FindBy(id = "billing_state")
	public WebElement state;
	
	@FindBy(xpath = "//*[@id='s2id_autogen2_search']")
	public WebElement stateBox;
	
	@FindBy(xpath = "//span[@id='select2-chosen-2']")
	public WebElement california;
	
	@FindBy(id = "billing_postcode")
	public WebElement zipCode;
	
	@FindBy(id = "payment_method_cheque")
	public WebElement directBankTransferButton;
	
	@FindBy(id = "place_order")
	public WebElement placeOrderButton;
	
	//verify order completed
	@FindBy(xpath = "//*[@id=\"page-35\"]/div/div[1]/p[1]")
	public WebElement verifyOrderCompleted;
	
	
	public void shopMenuButton() {
		shopMenuButton.click();
	}
	
	public void sliderBar() {
		WebElement slider = sliderBar.findElement(By.xpath("//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/span[2]"));
		for (int i = 1; i <= 50 ; i++) {
            slider.sendKeys(Keys.ARROW_LEFT);
            
            System.out.println("Filler By Price between 150 to 450");
		}
        
	}
	
	public void functionalProduct() {
		functionalProduct.click();
	}
	
	public void verifyFunctionalProductText() {
		Assert.assertTrue(verifyFunctionalProductText.isDisplayed());
		}
	
	public void sortByPopularity() {	
		Select dropPopularity = new Select(KanokwanBaseClass.driver.findElement(By.name("orderby")));
		dropPopularity.selectByVisibleText("Sort by popularity");
		String popularityURL = KanokwanBaseClass.driver.getCurrentUrl().toString();
		Assert.assertEquals("http://practice.automationtesting.in/shop/?orderby=popularity", popularityURL);
	}
	
	public void sortByAverageRatings() {
		Select dropAverage = new Select(KanokwanBaseClass.driver.findElement(By.name("orderby")));
		dropAverage.selectByVisibleText("Sort by average rating");
		String averageRatingURL = KanokwanBaseClass.driver.getCurrentUrl().toString();
		Assert.assertEquals("http://practice.automationtesting.in/shop/?orderby=rating", averageRatingURL);
	}
	
	public void verifySortByNewness() {
		Select dropNewness = new Select(KanokwanBaseClass.driver.findElement(By.xpath("//*[@class='orderby']")));
		dropNewness.selectByValue("date");
		String newnessURL = KanokwanBaseClass.driver.getCurrentUrl().toString();
		Assert.assertEquals("http://practice.automationtesting.in/shop/?orderby=date", newnessURL);
	}

	public void verifySortByLowToHigh() {
		Select dropLowToHigh = new Select(KanokwanBaseClass.driver.findElement(By.xpath("//*[@class='orderby']")));
		dropLowToHigh.selectByValue("price");
		String lowToHighURL = KanokwanBaseClass.driver.getCurrentUrl().toString();
		Assert.assertEquals("http://practice.automationtesting.in/shop/?orderby=price", lowToHighURL);
	}

	public void verifySortByHighToLow() {
		Select dropHighToLow = new Select(KanokwanBaseClass.driver.findElement(By.xpath("//*[@class='orderby']")));
		dropHighToLow.selectByVisibleText("Sort by price: high to low");
		String highToLowURL = KanokwanBaseClass.driver.getCurrentUrl().toString();
		Assert.assertEquals("http://practice.automationtesting.in/shop/?orderby=price-desc", highToLowURL);
	}
	
	public void readMoreSeleniumRuby() {
		readMoreSeleniumRuby.click();
		String outOfStockCheck = KanokwanBaseClass.driver.findElement(By.xpath("//*[@class='stock out-of-stock']")).getText();
		Assert.assertTrue(outOfStockCheck.contains("Out of stock"));
	}
	
	public void saleProductButton() {
		saleProductButton.click();
	}
	
	public void verifySaleProduct() {
		String originalPrice = KanokwanBaseClass.driver.findElement(By.xpath("//*[@id=\"product-169\"]/div[2]/div[1]/p/del/span")).getText();
		Assert.assertTrue(originalPrice.contains("600.00"));
		String salePrice = KanokwanBaseClass.driver.findElement(By.xpath("//*[@id=\"product-169\"]/div[2]/div[1]/p/ins/span")).getText();
		Assert.assertTrue(salePrice.contains("450.00"));
	}
	
	public void addToBasketButton() {
		addToBasketButton.click();
	}
	
	public void viewBasketButton() {
		viewBasketButton.click();
	}
	
	public void verifyCartItemsProduct() {
		String cartItemProduct = KanokwanBaseClass.driver.findElement(By.xpath("//*[@id=\"wpmenucartli\"]/a/span[1]")).getText();
		System.out.println("Number of item is " + cartItemProduct);
		String expectedCartItemProduct = "1 Item";
		Assert.assertTrue(cartItemProduct.equals(expectedCartItemProduct));
	}
	
	public void verifyCartSubtotal() {
		Assert.assertTrue(cartSubtotal.isDisplayed());
	}
	
	public void verifycartTotal() {
		Assert.assertTrue(cartTotal.isDisplayed());
	}
	
	public void totalGreaterThanSubtotal() {
		String total = KanokwanBaseClass.driver
			.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[3]/td/strong/span")).getText();
		String subTotal = KanokwanBaseClass.driver
			.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[1]/td/span")).getText();
		total = total.substring(1);
		subTotal = subTotal.substring(1);
		Assert.assertTrue(Double.valueOf(total) > Double.valueOf(subTotal));
		System.out.println(subTotal + " and " + total);
		
	}
	
	public void verifyDetailsCheckout() {
		Assert.assertTrue(billingDetails.isDisplayed());
		Assert.assertTrue(yourOrder.isDisplayed());
		Assert.assertTrue(additionalInformation.isDisplayed());
		Assert.assertTrue(payment.isDisplayed());
	}
	
	public void proceedToCheckoutButton() {
		proceedToCheckoutButton.click();
	}
	
	public void fillingDetailsCheckoutForm() throws InterruptedException {
		firstName.sendKeys(KanokwanBaseClass.getProperty("firstName"));
		Thread.sleep(3000);
		lastName.sendKeys(KanokwanBaseClass.getProperty("lastName"));
		Thread.sleep(3000);
		emailAddress.sendKeys(KanokwanBaseClass.getProperty("emailAddress"));
		Thread.sleep(3000);
		phone.sendKeys(KanokwanBaseClass.getProperty("phone"));
		Thread.sleep(3000);
		address.sendKeys(KanokwanBaseClass.getProperty("address"));
		Thread.sleep(3000);
		city.sendKeys(KanokwanBaseClass.getProperty("city"));
		Thread.sleep(3000);
		state.click();
		stateBox.click();
		Thread.sleep(3000);
		stateBox.sendKeys("California");
		Thread.sleep(3000);
		stateBox.sendKeys(Keys.RETURN);
		zipCode.sendKeys(KanokwanBaseClass.getProperty("zipCode"));
		Thread.sleep(3000);
		directBankTransferButton.click();
		Thread.sleep(3000);
		placeOrderButton.click();
	}
	
	public void verifyOrderCompleted() {
		String ActualTitle = KanokwanBaseClass.driver.getTitle();
		String ExpectedTitle = "Thank you. Your order has been received.";
		Assert.assertNotEquals(ActualTitle, ExpectedTitle);
	}
}
	

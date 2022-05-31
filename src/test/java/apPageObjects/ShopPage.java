package apPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import apUtilities.BaseClass;

public class ShopPage {

	WebDriver driver = BaseClass.getDriver();
	Select select;

	// initialize page factory
	public ShopPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[contains(text(),'Shop')]")
	public WebElement shopMenu;
	@FindBy(xpath = "//*[@id=\\\"woocommerce_price_filter-2\\\"]/form/div/div[1]/span[2]")
	public WebElement sliderBar;
	@FindBy(xpath = "//*[@id=\"woocommerce_product_categories-2\"]/ul/li[1]/a")
	public WebElement product;
	@FindBy(xpath = "//*[contains(text(),'Read more')]")
	public WebElement readMoreBtn;
	@FindBy(xpath = "//*[@id='content']/ul/li[1]/a[1]/span[1]")
	public WebElement saleBtn;
	@FindBy(xpath = "//*[@id=\"content\"]/ul/li[1]/a[2]")
	public WebElement addToBasket;
	@FindBy(xpath = "//a[normalize-space()='View Basket']")
	public WebElement viewBasket;
	@FindBy(xpath ="//*[@class='wpmenucart-contents']")
	public WebElement itemLink;
	@FindBy(xpath = "//*[@class='order-total']//th[contains(text(),'Total')]")
	public WebElement total;
	@FindBy(xpath = "//*[normalize-space()='Subtotal']")
	public WebElement subtotal;
	@FindBy(xpath = "//a[normalize-space()='Proceed to Checkout']")
	public WebElement proceedToCheckout;
	@FindBy(xpath = "//h3[normalize-space()='Additional Information']")
	public WebElement additionalInformation;
	@FindBy(xpath = "//h3[normalize-space()='Billing Details']")
	public WebElement billingDetails;
	@FindBy(id = "payment")
	public WebElement payments;
	@FindBy(xpath = "//h3[@id='order_review_heading']")
	public WebElement yourOrder;
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
	@FindBy(xpath = "//span[@id='select2-chosen-2']")
	public WebElement state;
	@FindBy(xpath = "//*[@id='s2id_autogen2_search']")
	public WebElement stateBox;
	@FindBy(xpath = "//span[@id='select2-chosen-2']")
	public WebElement virginia;
	@FindBy(id = "billing_postcode")
	public WebElement zipCode;
	@FindBy(id = "payment_method_cheque")
	public WebElement checkPaymentBtn;
	@FindBy(id = "place_order")
	public WebElement placeOrderBtn;
	@FindBy(xpath = "//*[@class='woocommerce-thankyou-order-received']")
	public WebElement thankyouMsg;

	public void verifySlider() {
		WebElement rightSlider = driver.findElement(By.xpath("//*[contains(@class,'price_slider')" + "]/span[2]"));
		WebElement priceTo;
		String price;
		do {
			priceTo = driver.findElement(By.cssSelector("div.price_label > span.to"));
			price = priceTo.getText().substring(1); // $450 ---> 450
			rightSlider.sendKeys(Keys.ARROW_LEFT);
		} while (!price.equals("450"));
		Assert.assertEquals(price, "450");
	}

	public void verifyProduct() {
		String andriodDescription = BaseClass.driver.findElement(By.xpath("//*[@id='content']/ul/li/a/h3")).getText();
		System.out.println(andriodDescription);
		Assert.assertEquals("Android Quick Start Guide", andriodDescription);
	}

	public void verifySortByPopularity() {
		Select select = new Select(BaseClass.driver.findElement(By.xpath("//*[@class='orderby']")));
		select.selectByIndex(1);
		String popularityURL = BaseClass.driver.getCurrentUrl().toString();
		Assert.assertEquals("http://practice.automationtesting.in/shop/?orderby=popularity", popularityURL);
	}

	public void verifySortByAverageRating() {
		Select select = new Select(BaseClass.driver.findElement(By.xpath("//*[@class='orderby']")));
		select.selectByIndex(2);
		String averageRatingURL = BaseClass.driver.getCurrentUrl().toString();
		Assert.assertEquals("http://practice.automationtesting.in/shop/?orderby=rating", averageRatingURL);
	}

	public void verifySortByNewness() {
		Select select = new Select(BaseClass.driver.findElement(By.xpath("//*[@class='orderby']")));
		select.selectByValue("date");
		String newnessURL = BaseClass.driver.getCurrentUrl().toString();
		Assert.assertEquals("http://practice.automationtesting.in/shop/?orderby=date", newnessURL);
	}

	public void verifySortByLowToHigh() {
		Select select = new Select(BaseClass.driver.findElement(By.xpath("//*[@class='orderby']")));
		select.selectByValue("price");
		String priceURL = BaseClass.driver.getCurrentUrl().toString();
		Assert.assertEquals("http://practice.automationtesting.in/shop/?orderby=price", priceURL);
	}

	public void verifySortByHighToLow() {
		Select select = new Select(BaseClass.driver.findElement(By.xpath("//*[@class='orderby']")));
		select.selectByValue("price-desc");
		String priceDesURL = BaseClass.driver.getCurrentUrl().toString();
		Assert.assertEquals("http://practice.automationtesting.in/shop/?orderby=price-desc", priceDesURL);
	}

	public void VerifyReadMoreFunctionallity() {
		readMoreBtn.click();
		String outOfStockCheck = BaseClass.driver.findElement(By.xpath("//*[@class='stock out-of-stock']")).getText();
		Assert.assertTrue(outOfStockCheck.contains("Out of stock"));
	}

	public void verifySaleFunctionallity() {
		String originalPrice = BaseClass.driver.findElement(By.xpath("//*[@class='price']/del/span")).getText();
		Assert.assertTrue(originalPrice.contains("600.00"));
		String salePrice = BaseClass.driver.findElement(By.xpath("//*[@class='price']/ins/span")).getText();
		Assert.assertTrue(salePrice.contains("450.00"));
	}

	public void verifyCartItems() {
		String cartItem = BaseClass.driver.findElement(By.xpath("//*[@class='cartcontents']")).getText();
		System.out.println("Number of item is " + cartItem);
		String expectedCartItem = "1 Item";
		Assert.assertTrue(cartItem.equals(expectedCartItem));
	}

	public void totalDisplay() {
		Assert.assertTrue(total.isDisplayed());
	}

	public void subtotalDisplay() {
		Assert.assertTrue(subtotal.isDisplayed());
	}

	public void totalGreaterThanSubtotal() {
		String total = driver
				.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[3]/td/strong/span"))
				.getText();
		String subTotal = driver
				.findElement(By.xpath("//*[@id=\"page-34\"]/div/div[1]/div/div/table/tbody/tr[1]/td/span")).getText();
		total = total.substring(1);
		subTotal = subTotal.substring(1);
		Assert.assertTrue(Double.valueOf(total) > Double.valueOf(subTotal));
		System.out.println(subTotal + " and " + total);
	}

	public void chkoutPageDisplay() {
		Assert.assertTrue(billingDetails.isDisplayed());
		Assert.assertTrue(additionalInformation.isDisplayed());
		Assert.assertTrue(payments.isDisplayed());
		Assert.assertTrue(yourOrder.isDisplayed());
	}

	public void fillingchkoutForm() {
		firstName.sendKeys(BaseClass.getProperty("firstname"));
		lastName.sendKeys(BaseClass.getProperty("lastname"));
		emailAddress.sendKeys(BaseClass.getProperty("email"));
		phone.sendKeys(BaseClass.getProperty("phone"));
		address.sendKeys(BaseClass.getProperty("address"));
		city.sendKeys(BaseClass.getProperty("city"));
		state.click();
		stateBox.click();
		stateBox.sendKeys("Virginia");
		stateBox.sendKeys(Keys.RETURN);
		zipCode.sendKeys(BaseClass.getProperty("zipcode"));
		checkPaymentBtn.click();
		placeOrderBtn.click();
	}

	public void VerifyOrderComplete() {
		Assert.assertTrue(thankyouMsg.isDisplayed());
	}

}

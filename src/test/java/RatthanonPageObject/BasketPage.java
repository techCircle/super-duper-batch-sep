package RatthanonPageObject;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import RatthanonUtilities.BaseClassR;

public class BasketPage {
	
	public WebDriver driver = BaseClassR.getDriver();
	String titleweb[] = {"selenium-ruby","thinking-in-html","mastering-javascript"};
		
			
		
		public BasketPage() {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//tr[@class='cart_item']/td[3]/a")
		public WebElement NameProduct;
		
		@FindBy(xpath="//td[@class='product-price']/span")
		public WebElement PriceProduct;
		
		@FindBy(xpath="//input[@id='coupon_code']")
		public WebElement ProductCode;
		
		@FindBy(xpath="//ul[@class='woocommerce-error']/li")
		public WebElement errorMaxCoupon;
		
		@FindBy(xpath="//input[@name='apply_coupon']")
		public WebElement applycouponButton;
		
		@FindBy(xpath="//td[@class='product-remove']/a")
		public WebElement removeButton;
		
		@FindBy(xpath="//div[@class='woocommerce-message']")
		public WebElement removeItemMessage;
		
		@FindBy(xpath="//div[@class='quantity']/input")
		public WebElement QuantityInput;
		
		@FindBy(xpath="//input[@name='update_cart']")
		public WebElement updateCartButton;
		
		@FindBy(xpath="//div[@class='woocommerce-message']")
		public WebElement updateBasketMessage;
		
		@FindBy(xpath="//td[@class='product-subtotal']/span")
		public WebElement totalPrice;
		
		@FindBy(xpath="//td[@data-title='Total']/strong/span")
		public WebElement subTotal;
		
		@FindBy(xpath="//div[@class='wc-proceed-to-checkout']/a")
		public WebElement ProceedCheckButton;
		
		//@FindBy(xpath="//tr[@class='tax-rate tax-rate-roaming-tax-1']/td/span")
		@FindBy(xpath="//tr[contains(@class,'tax-rate')]/td/span")
		public WebElement tax;
		
		@FindBy(xpath="//table[@class='shop_table shop_table_responsive']/tbody/tr[2]/th")
		public WebElement taxCountry;
		//tr[@class='tax-rate tax-rate-roaming-tax-1']/td/span
		
		
		
		public void verifyTotalPrice() {
			double ProductPrice = Double.parseDouble(PriceProduct.getText().substring(1));
			double quanity= Double.parseDouble(QuantityInput.getAttribute("value"));
			double total = Double.parseDouble(totalPrice.getText().substring(1));
			Assert.assertEquals(total, ProductPrice * quanity);			
			
		}
		
		public void verifyTotalAndSubTotal() {
			double total = Double.parseDouble(totalPrice.getText().substring(1));
			double subtotal = Double.parseDouble(subTotal.getText().substring(1));
			Assert.assertTrue(total<subtotal);
			
		}
		
		public void verifyTax() {
			
			double taxPercent;
			if(taxCountry.getText().contains("India")) {
				taxPercent = 0.02;
			}else {
				taxPercent = 0.05;
			}
			
			double total = Double.parseDouble(totalPrice.getText().substring(1));
			double totalTax = Double.parseDouble(tax.getText().substring(1));			
			double subtotal = Double.parseDouble(subTotal.getText().substring(1));
			
			Assert.assertEquals(taxPercent*total, totalTax );
			
			
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}

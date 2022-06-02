package RatthanonPageObject;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RatthanonUtilities.BaseClassR;

public class BasketPage {
	
	public WebDriver driver = BaseClassR.getDriver();
	String titleweb[] = {"selenium-ruby","thinking-in-html","mastering-javascript"};
		
			
		
		public BasketPage() {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//tr[@class='cart_item']/td[3]/a")
		public WebElement NameProduct;
		
		@FindBy(xpath="//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[4]/span")
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
		
		
		
		//div[@class='woocommerce-message']
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

}

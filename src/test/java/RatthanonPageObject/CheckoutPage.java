package RatthanonPageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import RatthanonUtilities.BaseClassR;
import RatthanonUtilities.Constants_ratthanon;

public class CheckoutPage {
	public WebDriver driver = BaseClassR.getDriver();
	
	    WebDriverWait wait;

				
		public CheckoutPage() {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//div[@class='woocommerce-billing-fields']/h3")
		public WebElement checkOutText;
		
		@FindBy(xpath="//p[@id='billing_first_name_field']/input")
		public WebElement inputFirstName;
		
		@FindBy(xpath="//p[@id='billing_last_name_field']/input")
		public WebElement inputLastName;
		
		@FindBy(xpath="//p[@id='billing_company_field']/input")
		public WebElement inputCompany;
		
		@FindBy(xpath="//p[@id='billing_email_field']/input")
		public WebElement inputEmail;
		
		@FindBy(xpath="//p[@id='billing_phone_field']/input")
		public WebElement inputPhone;
		
		@FindBy(xpath="//p[@id='billing_address_1_field']/input")
		public WebElement inputAddress;
		
		@FindBy(xpath="//p[@id='billing_city_field']/input")
		public WebElement inputCity;
		
		@FindBy(xpath="//div[@id='s2id_billing_state']")
		public WebElement inputState;
		
		@FindBy(xpath="//input[@id='billing_postcode']")
		public WebElement inputzipcode;
		
		
		@FindBy(xpath="//input[@id='s2id_autogen2_search']")
		public WebElement inputStateSelect;
		
		@FindBy(xpath="//input[@id='payment_method_bacs']")
		public WebElement DirectBankTranfer;
		
		@FindBy(xpath="//input[@id='payment_method_cheque']")
		public WebElement CheckPayments;
		
		@FindBy(xpath="//input[@id='payment_method_cod']")
		public WebElement CashOnDelivert;
		
		@FindBy(xpath="//input[@id='payment_method_ppec_paypal']")
		public WebElement PayPalCheckOut;
		
		@FindBy(xpath="//input[@id='place_order']")
		public WebElement placeOrderButton;
		
		@FindBy(xpath="//p[@class='woocommerce-thankyou-order-received']")
		public WebElement textsuccessOrder;
		
		@FindBy(xpath="//a[@class='showcoupon']")
		public WebElement linkEnterCoupon;
		
		@FindBy(xpath="//input[@id='coupon_code']")
		public WebElement inputCoupon;
		
		@FindBy(xpath="//input[@name='apply_coupon']")
		public WebElement applyCoupon;
		
		@FindBy(xpath="//ul[@class='woocommerce-error']/li")
		public WebElement messageAddCoupon;
		
		@FindBy(xpath="//h2[text()='Order Details']")
		public WebElement textOrderDetail;
		
		
		
		
		
		

		
		public void verifyAddCoupon() {
			linkEnterCoupon.click();
			inputCoupon.sendKeys(Constants_ratthanon.productCode);
			applyCoupon.click();
			
			wait = new WebDriverWait(driver, 30);
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul[@class='woocommerce-error']/li")));
			
			Assert.assertTrue(DirectBankTranfer.isEnabled() && CheckPayments.isEnabled() && CashOnDelivert.isEnabled() && PayPalCheckOut.isEnabled());	
			
			
			//The valid coupon is usage limit so we have to validate with the display coupon message
			Assert.assertEquals(messageAddCoupon.getText(), Constants_ratthanon.validateCouponMessage);			
		}
		
				
		
		public void VerifyBilling() throws InterruptedException {
			inputFirstName.sendKeys(Constants_ratthanon.checkOutFname);
			inputLastName.sendKeys(Constants_ratthanon.checkoutLastName);
			inputCompany.sendKeys(Constants_ratthanon.checkoutcompany);
			inputEmail.sendKeys(Constants_ratthanon.username);
			inputPhone.sendKeys(Constants_ratthanon.checkoutphone);	
			inputAddress.sendKeys(Constants_ratthanon.address);
			inputCity.sendKeys(Constants_ratthanon.city);
			
			inputState.click();
			Thread.sleep(2000);
			inputStateSelect.sendKeys("Virginia" + "\n");
			//Thread.sleep(1000);
			inputzipcode.clear();
			inputzipcode.sendKeys(Constants_ratthanon.zipcode);
			Thread.sleep(5000);
			
			Assert.assertTrue(DirectBankTranfer.isEnabled() && CheckPayments.isEnabled() && CashOnDelivert.isEnabled() && PayPalCheckOut.isEnabled());		
			
		}
		
		public void verifyMakeOrder() {
			placeOrderButton.click();			
			//wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[@class='woocommerce-thankyou-order-received']")));
			System.out.println(textsuccessOrder.getText());
			Assert.assertTrue(textsuccessOrder.getText().contains(Constants_ratthanon.displayOrderSuccess) && textOrderDetail.getText().contains("Order Details"));

			//WebElement firstLink = driver.findElement(By.xpath("//*[@id=\"rso\"]/div[2]/div/div/div[1]/div/div/div[1]/div/a/h3"));
			//wait.until(ExpectedConditions.elementToBeClickable(firstLink));
			
			
		}

}

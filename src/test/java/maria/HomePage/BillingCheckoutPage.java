package maria.HomePage;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.ConfigurationProperties;
import Utilities.Driver;

public class BillingCheckoutPage {
	public BillingCheckoutPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
////changes to push
	@FindBy(id="billing_first_name")
	public WebElement bfirstName;
	
	@FindBy(id="billing_last_name")
	public WebElement blastName;
	
	@FindBy(id="billing_company")
	public WebElement bcompanyName;
	
	
	@FindBy(id="billing_email")
	public WebElement billingEmail;
	
	@FindBy(id="billing_phone")
	public WebElement billingPhone;
	
	@FindBy(id="billing_address_1")
	public WebElement billingaddress;
	
	
	@FindBy(id="billing_city")
	public WebElement billingCity;
	

	@FindBy (xpath = "//span[@id='select2-chosen-2']")
	public WebElement billingState;
	
	@FindBy (xpath = "//*[@id='s2id_autogen2_search']")
	public WebElement stateBox;
	
	@FindBy(id="billing_postcode")
	public WebElement billingZipCode;
	

	@FindBy(xpath="//label[@for='payment_method_cod']")
	public WebElement cashOnDeliveryPayment;
	
	

	@FindBy(id="place_order")
	public WebElement placeOrderBTn;
	

	@FindBy(xpath="//div[@class='woocommerce-billing-fields']")
	public WebElement billingDetailsdisplay;
	
	
	
	@FindBy(xpath="//div[@class='woocommerce-shipping-fields']")
	public WebElement shippingDetailsdisplay;
	
	
	@FindBy(xpath="//p[@class='woocommerce-thankyou-order-received']")
	public WebElement orderConfirmation;
	
	@FindBy(xpath="//table[@class='shop_table order_details']")
	public WebElement bOrderDetails;
	
	
	//Methods
	
	public void verifyBillingPage() {
		Assert.assertTrue(billingDetailsdisplay.isDisplayed());
		Assert.assertTrue(shippingDetailsdisplay.isDisplayed());
		
	}
	
public void billingDetails() {
	bfirstName.sendKeys(ConfigurationProperties.getProperty("bfirstName"));
	blastName.sendKeys(ConfigurationProperties.getProperty("blastName"));
	bcompanyName.sendKeys(ConfigurationProperties.getProperty("bcompanyName"));
	billingEmail.sendKeys(ConfigurationProperties.getProperty("billingEmail"));
	billingPhone.sendKeys(ConfigurationProperties.getProperty("billingPhone"));
	billingaddress.sendKeys(ConfigurationProperties.getProperty("billingaddress"));
	billingCity.sendKeys(ConfigurationProperties.getProperty("billingCity"));
	billingState.click();
	stateBox.sendKeys(ConfigurationProperties.getProperty("stateBox"));
	stateBox.sendKeys(Keys.RETURN);
	billingZipCode.sendKeys(ConfigurationProperties.getProperty("billingZipCode"));	
	
	
	}
public void placeOrder() {
placeOrderBTn.click();
Assert.assertTrue(orderConfirmation.isDisplayed());
Assert.assertTrue(bOrderDetails.isDisplayed());
}}

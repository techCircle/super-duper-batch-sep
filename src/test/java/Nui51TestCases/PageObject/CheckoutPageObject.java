package Nui51TestCases.PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import NuiUtilities.Driver;
import NuiUtilities.NuiConfigurationProperties;

public class CheckoutPageObject {
	

	WebDriver driver = Driver.getDriver();

	public CheckoutPageObject() {
		PageFactory.initElements(driver, this); 
	}
	
	
	@FindBy (xpath = "//*[@id='customer_details']/div[1]/div/h3")
	public WebElement billingDt;
	
	@FindBy (xpath = "//*[@id='customer_details']/div[2]/div/h3")
	public WebElement additionalDt;
	
	@FindBy (xpath = "//*[@id='order_review_heading']")
	public WebElement orderDt;
	
	@FindBy (xpath = "//*[@id='payment']/ul")
	public WebElement payment;
	
	@FindBy (xpath = "//*[@id='billing_first_name']")
	public WebElement billingFN;
	
	@FindBy (xpath = "//*[@id='billing_last_name']")
	public WebElement billingLN;
	
	@FindBy (xpath = "//*[@id='billing_email']")
	public WebElement billingEmail;
	
	@FindBy (xpath = "//*[@id='billing_phone']")
	public WebElement billingPhone;
	
	@FindBy (xpath = "//*[@id='billing_address_1']")
	public WebElement billingAdd;
	
	@FindBy (xpath = "//*[@id='billing_city']")
	public WebElement billingCity;
	
	@FindBy (xpath = "//span[@id='select2-chosen-2']")
	public WebElement ddState;
	
	@FindBy (xpath = "//*[@id='s2id_autogen2_search']")
	public WebElement stateBox;
	
	@FindBy (xpath = "//*[@id='billing_postcode']")
	public WebElement billingZip;
	
	@FindBy (xpath = "//*[@id='payment_method_cod']")
	public WebElement CashOnDeliveryPayment;
	
	@FindBy (xpath = "//*[@id='place_order']")
	public WebElement placeOrderBtn;
	
	
	public void verifyCheckoutPage() {
		Assert.assertTrue(billingDt.isDisplayed());
		Assert.assertTrue(additionalDt.isDisplayed());
		Assert.assertTrue(orderDt.isDisplayed());
		Assert.assertTrue(payment.isDisplayed());
	}
	
	public void fillBillingForm() {
		billingFN.sendKeys(NuiConfigurationProperties.getKeyValue("name"));
		billingLN.sendKeys(NuiConfigurationProperties.getKeyValue("lastName"));
		billingEmail.sendKeys(NuiConfigurationProperties.getKeyValue("goodEmail"));
		billingPhone.sendKeys(NuiConfigurationProperties.getKeyValue("phoneNumber"));
		billingAdd.sendKeys(NuiConfigurationProperties.getKeyValue("address"));
		billingCity.sendKeys(NuiConfigurationProperties.getKeyValue("city"));
		ddState.click();
		stateBox.sendKeys(NuiConfigurationProperties.getKeyValue("state"));
		stateBox.sendKeys(Keys.RETURN);
		billingZip.sendKeys(NuiConfigurationProperties.getKeyValue("zipcode"));
	}
	
	

}

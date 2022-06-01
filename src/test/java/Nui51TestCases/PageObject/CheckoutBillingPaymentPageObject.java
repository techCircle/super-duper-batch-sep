package Nui51TestCases.PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import NuiUtilities.Driver;
import NuiUtilities.NuiConfigurationProperties;

public class CheckoutBillingPaymentPageObject {
	
	
	WebDriver driver = Driver.getDriver();
	WebDriverWait wait;

	public CheckoutBillingPaymentPageObject() {
		PageFactory.initElements(driver, this); 
		wait = new WebDriverWait(driver, 30);
	}
		
	@FindBy (xpath = "//ul[@class='wc_payment_methods payment_methods methods']")
	public WebElement paymentGateWay;
	
	@FindBy (xpath = "//div[@class='woocommerce-billing-fields']/h3")
	public WebElement billingDetails;
	
	@FindBy (id = "order_review_heading")
	public WebElement orderDetails;
	
	@FindBy (xpath = "//div[@class='woocommerce-shipping-fields']/h3")
	public WebElement additionalDetails;
	
	@FindBy (id = "billing_first_name")
	public WebElement billingFN;
	
	@FindBy (id = "billing_last_name")
	public WebElement billingLN;
	
	@FindBy (id = "billing_email")
	public WebElement billingEmail;
	
	@FindBy (id = "billing_phone")
	public WebElement billingPhone;
	
	@FindBy (xpath = "//b[@role='presentation']")
	public WebElement dropDownCountry;
	
	@FindBy (xpath = "//input[@id='s2id_autogen1_search']")
	public WebElement inputBox;
	
	@FindBy (id = "billing_address_1")
	public WebElement billingAddress;
	
	@FindBy (id = "billing_city")
	public WebElement billingCity;
	
	@FindBy (xpath = "//b[@role='presentation']")
	public WebElement dropDown;
	
	@FindBy (xpath = "//*[@id='s2id_billing_state']/a/span[2]")
	public WebElement dropDownState;
	
	@FindBy (xpath = "//*[@id='s2id_autogen2_search']")
	public WebElement stateBox;
	
	@FindBy (id = "billing_postcode")
	public WebElement billingPostCode;
	
	@FindBy (id = "payment_method_cod")
	public WebElement paymentMtd;
	
	@FindBy (xpath = "//a[@class='showcoupon']")
	public WebElement showCouponBox;
	
	@FindBy (id = "coupon_code")
	public WebElement counponCodeField;
	
	@FindBy (id = "place_order")
	public WebElement placeOrderBtn;
	
	
	public void verifyBillingPage() {
		Assert.assertTrue(billingDetails.getText().equals(NuiConfigurationProperties.getKeyValue("billingStr")));
		Assert.assertTrue(orderDetails.getText().equals(NuiConfigurationProperties.getKeyValue("orderStr")));
		Assert.assertTrue(additionalDetails.getText().equals(NuiConfigurationProperties.getKeyValue("additionalStr")));
		Assert.assertTrue(paymentGateWay.isDisplayed());
	}
	
	public void fillFormBillingAndPayment() {
		billingFN.sendKeys(NuiConfigurationProperties.getKeyValue("name"));
		billingLN.sendKeys(NuiConfigurationProperties.getKeyValue("lastName"));
		billingEmail.sendKeys(NuiConfigurationProperties.getKeyValue("goodEmail"));
		billingPhone.sendKeys(NuiConfigurationProperties.getKeyValue("phoneNumber"));
		dropDownCountry.click();
		inputBox.clear();
		inputBox.sendKeys(NuiConfigurationProperties.getKeyValue("country"));
		inputBox.sendKeys(Keys.RETURN);
		billingAddress.sendKeys(NuiConfigurationProperties.getKeyValue("address"));
		billingCity.sendKeys(NuiConfigurationProperties.getKeyValue("city"));
		dropDownState.click();
		stateBox.sendKeys(NuiConfigurationProperties.getKeyValue("state"), Keys.RETURN);
		billingPostCode.sendKeys(NuiConfigurationProperties.getKeyValue("zipcode"));
	}
	
	public void clickCoupon() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("window.scrollBy(0,-1000)", "");
	    showCouponBox.click();
	    wait.until(ExpectedConditions.visibilityOf(counponCodeField));
	    Assert.assertTrue(counponCodeField.isDisplayed());	
	}

	
	
}





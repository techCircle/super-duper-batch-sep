package maria.MyAccountObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import mariaUtilities.Driver;



public class MyAccountsEditAddressPage {

	public MyAccountsEditAddressPage() {
PageFactory.initElements(Driver.getDriver(), this);	
	
}

	
	
	
	////////////////////////changes to push
	
	@FindBy(xpath="//h3[normalize-space()='Billing Address']")
	WebElement billingAddress;
	
	@FindBy(xpath="//div[@class='u-column1 col-1 woocommerce-Address']//address[1]")
	WebElement billingAddressDetails;
	
	@FindBy(xpath="//h3[normalize-space()='Shipping Address']")
	WebElement shippingAddress;
	
	@FindBy(xpath="//a[@href='http://practice.automationtesting.in/my-account/edit-address/shipping']")
	WebElement editShippingAddressBtn;


public void verifyingbillingAndshipAddress() {
	
	
	Assert.assertTrue(billingAddress.isDisplayed());
	Assert.assertTrue(billingAddressDetails.isDisplayed());
	Assert.assertTrue(shippingAddress.isDisplayed());
}

public void editShipAddressClick() {
	
	editShippingAddressBtn.click();


}}

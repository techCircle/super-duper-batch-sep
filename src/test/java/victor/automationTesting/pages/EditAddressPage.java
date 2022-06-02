package victor.automationTesting.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import victor.utilities.Victor_BaseClass;

public class EditAddressPage {
	public EditAddressPage () {
		PageFactory.initElements(Victor_BaseClass.getDriver(), this);
		}
	
	@FindBy (xpath="//*[@id=\"page-36\"]/div/div[1]/div/div/div[1]/header/h3")
	public WebElement billingAddress;
	
	@FindBy (xpath="//*[@id=\"page-36\"]/div/div[1]/div/div/div[2]/header/h3")
	public WebElement shippingAddress;
	
	public void addressVerification () {
		Assert.assertTrue(billingAddress.getText().equals("Billing Address"));
		Assert.assertTrue(shippingAddress.getText().equals("Shipping Address"));
	}
}

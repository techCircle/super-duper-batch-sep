package victor.automationTesting.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import victor.utilities.Victor_BaseClass;

public class EditAddressPage {
	public EditAddressPage () {
		PageFactory.initElements(Victor_BaseClass.getDriver(), this);
		}
	
	@FindBy (xpath="//*[@id=\"page-36\"]/div/div[1]/div/div/div[1]/header/h3")
	public WebElement billingAddress;
	
	@FindBy (xpath="//*[@id=\"page-36\"]/div/div[1]/div/div/div[2]/header/h3")
	public WebElement shippingAddress;
	
	@FindBy (xpath="//*[@id=\"page-36\"]/div/div[1]/div/div/div[2]/header/a")
			public WebElement editShippingAddress;
	
	@FindBy (xpath= "//*[@id=\"page-36\"]/div/div[1]/div/form/p[10]/input[1]")
	public WebElement saveAddressButton;
	
	public void addressVerification () {
		Assert.assertTrue(billingAddress.getText().equals("Billing Address"));
		Assert.assertTrue(shippingAddress.getText().equals("Shipping Address"));
	}
}

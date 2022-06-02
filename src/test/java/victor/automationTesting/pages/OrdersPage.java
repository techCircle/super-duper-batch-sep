package victor.automationTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import victor.utilities.Victor_BaseClass;

public class OrdersPage {
	public OrdersPage () {
		PageFactory.initElements(Victor_BaseClass.getDriver(), this);
		}
	
	@FindBy (xpath="//*[@id='page-36']/div/div[1]/div/h2")
	public WebElement orderDetails;

	@FindBy (xpath="//*[@id='page-36']/div/div[1]/div/header[1]/h2")
	public WebElement customerDetails;
	
	@FindBy (xpath="//*[@id=\"page-36\"]/div/div[1]/div/header[2]/h3")
	public WebElement BillingAddress;
	
	@FindBy (xpath="//*[@id=\"page-36\"]/div/div[1]/div/p")
	public WebElement orderStatus;
	
	
	public void orderVerification () {
		Assert.assertTrue(orderDetails.getText().equals("Order Details"));
		Assert.assertTrue(customerDetails.getText().equals("Customer Details"));
		Assert.assertTrue(BillingAddress.getText().equals("Billing Address"));
	}
}

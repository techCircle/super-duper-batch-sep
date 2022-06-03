package maria.MyAccountObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import mariaUtilities.Driver;


public class myAccountOrderPage {

	public myAccountOrderPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	//changes to push
	@FindBy(xpath="//a[@class='button view']")
	WebElement viewButton;
	
	@FindBy(xpath="//div[@class='woocommerce-MyAccount-content']")
	WebElement OrderDetailsWindow;

	
	
	@FindBy(xpath="//a[normalize-space()='#10701']")
	WebElement orderNoLink;
	
	
	
	public void orderclick() {
		//orderLinkBtn.click();
		OrderDetailsWindow.isDisplayed();
		Assert.assertTrue(OrderDetailsWindow.isDisplayed());
	}

	
	public void viewBTNclick() {
		viewButton.click();
		
	}
	
	
	
}

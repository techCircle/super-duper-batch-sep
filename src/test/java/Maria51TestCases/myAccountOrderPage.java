package Maria51TestCases;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.Driver;

public class myAccountOrderPage {

	public myAccountOrderPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
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

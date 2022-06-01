package Nui51TestCases.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import NuiUtilities.Driver;

public class EditAddressPageObject {
	

	WebDriver driver = Driver.getDriver();
	WebDriverWait wait;

	public EditAddressPageObject() {
		PageFactory.initElements(driver, this); 
		wait = new WebDriverWait(driver, 30);
	}
	
	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/div/div/div[1]/header/h3")
	public WebElement billingAddressHeader;
	
	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/div/div/div[2]/header/h3")
	public WebElement shippingAddressHeader;
	
	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/div/div/div[2]/header/a")
	public WebElement editShippingAddBtn;
	
	
	public void verifyBillingShippingAdd() {
		Assert.assertTrue(billingAddressHeader.isDisplayed());
		Assert.assertTrue(shippingAddressHeader.isDisplayed());
	}
	
	

}

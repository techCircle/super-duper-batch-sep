package Nui51TestCases.PageObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import NuiUtilities.Driver;

public class ConfirmationPageObject {
	
	WebDriver driver = Driver.getDriver();
	WebDriverWait wait;

	public ConfirmationPageObject() {
		PageFactory.initElements(driver, this); 
		wait = new WebDriverWait(driver, 30);
	}

	@FindBy (xpath = "//li[@class='order']")
	public WebElement orderNumber;
	
	@FindBy (xpath = "//li[@class='date']")
	public WebElement orderDate;
	
	@FindBy (xpath = "//li[@class='total']")
	public WebElement orderTotal;
	
	@FindBy (xpath = "//li[@class='method']")
	public WebElement orderPaymentMtd;
	
	@FindBy (xpath = "//*[@class='woocommerce-thankyou-order-received']")
	public WebElement cfMsg;

	
	public void verifyOrderConfirmation() {
		
		Assert.assertTrue(orderNumber.isDisplayed());
		Assert.assertTrue(orderDate.isDisplayed());
		Assert.assertTrue(orderTotal.isDisplayed());
		Assert.assertTrue(orderPaymentMtd.isDisplayed());
		Assert.assertTrue(driver.findElement(By.xpath("//p[contains(text(), 'Thank you. Your order has been received.')]")).isDisplayed());
		
	}
	
}

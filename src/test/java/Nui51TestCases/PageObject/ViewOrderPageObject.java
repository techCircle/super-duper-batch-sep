package Nui51TestCases.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import NuiUtilities.Driver;
import NuiUtilities.NuiConfigurationProperties;

public class ViewOrderPageObject {
	
	WebDriver driver = Driver.getDriver();

	public ViewOrderPageObject() {
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/div/h2")
	public WebElement orderDtMsg;
	
	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/div/header[1]/h2")
	public WebElement customerDtMsg;
	
	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/div/header[2]/h3")
	public WebElement billingDtMsg;
	
	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/div/p")
	public WebElement orderNumDateStatus;
	
	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/div/p")
	public WebElement orderDt;
	
	
	
	public void verifyOrderNumDateStatus() {
		Assert.assertTrue(orderDt.getText().contains("Order"));
		Assert.assertTrue(orderDt.getText().contains("placed on"));
		Assert.assertTrue(orderDt.getText().contains("currently"));	
	}
	
	
	
	
	public void verifyViewOrderPage() {
		Assert.assertTrue(orderDtMsg.getText().equals(NuiConfigurationProperties.getKeyValue("orderMsg")));
		Assert.assertTrue(customerDtMsg.getText().equals(NuiConfigurationProperties.getKeyValue("customerMsg")));
		Assert.assertTrue(billingDtMsg.getText().equals(NuiConfigurationProperties.getKeyValue("billingMsg")));
	}


}

package thunpanBeePageObj;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import thunpanBee51TestCases.ConfigurationProperties;
import thunpanBee51TestCases.Driver;


public class CheckOutPage {
	public CheckOutPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath = "//*[@class='title']")
	public WebElement checkoutLabel;
	
	@FindBy(id="first-name")
	public WebElement firstNameField;
	@FindBy(id="last-name")
	public WebElement lastNameField;
	@FindBy(id="postal-code")
	public WebElement zipCodeField;
	@FindBy(id="continue")
	public WebElement continueButton;
	
	
	public void verifyToNextPage() {
		String currentUrl = Driver.getDriver().getCurrentUrl();
		System.out.println(currentUrl);
		Assert.assertTrue(checkoutLabel.isDisplayed());
		
	}
	
	public void formInput() {
		firstNameField.sendKeys(ConfigurationProperties.getProperty("swagLabfirstNameInput"));
		lastNameField.sendKeys(ConfigurationProperties.getProperty("swagLablastNameInput"));
		zipCodeField.sendKeys(ConfigurationProperties.getProperty("swagLabzipCodeInput"));
		continueButton.click();
		
	}
}

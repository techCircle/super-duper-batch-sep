package Maria51TestCases;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.ConfigurationProperties;
import Utilities.Driver;

public class MyAccountPageObject {



	public MyAccountPageObject() {
		PageFactory.initElements(Driver.getDriver(), this);
	}	

	@FindBy(linkText="My Account")
	public WebElement myAccountBtn; 

	@FindBy(id="username")
	public WebElement userName;


	@FindBy(id="password")
	public WebElement userPassword;

	@FindBy(name="login")
	public WebElement loginBtn;

	@FindBy(xpath="//div[@id='customer_login']")
	public WebElement homePageDisplay;
	
	



	public void clickMyAccount() {
		
		
		myAccountBtn.click();
		
		userName.sendKeys(ConfigurationProperties.getProperty("userName"));
		userPassword.sendKeys(ConfigurationProperties.getProperty("userPassword"));
		loginBtn.click();
		



	}
	public void homePageDisplay() {
		Assert.assertTrue(homePageDisplay.isDisplayed());
	}

}

package thunpanBeePageObj;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import thunpanBee51TestCases.ConfigurationProperties;
import thunpanBee51TestCases.Driver;


public class loginPage {
	public loginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(id="user-name")
	public WebElement userNameField;

	@FindBy(id="password")
	public WebElement passwordField;

	@FindBy(id="login-button")
	public WebElement loginBtn;
	
	
	public void doLogin() {

		userNameField.sendKeys(ConfigurationProperties.getProperty("swagLabusername"));
		passwordField.sendKeys(ConfigurationProperties.getProperty("swagLabpassword"));
		loginBtn.click();
	}
}

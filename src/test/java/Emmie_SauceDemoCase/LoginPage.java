package Emmie_SauceDemoCase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Emmie_Utilities.ConfigurationProperties;
import Emmie_Utilities.Driver;

public class LoginPage {
	public LoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(id = "user-name")
	public WebElement userNameField;
	
	@FindBy(id = "password")
	public WebElement passwordField;
	
	@FindBy(id = "login-button")
	public WebElement loginBtn;
	
	
	
	public void login() {
		
		userNameField.sendKeys(ConfigurationProperties.getProperty("userName"));
		passwordField.sendKeys(ConfigurationProperties.getProperty("password"));
		loginBtn.click();
		
	}
	

}

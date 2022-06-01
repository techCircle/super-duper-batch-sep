package Nui51TestCases.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import NuiUtilities.Driver;

public class LoginPageObject {
	

	WebDriver driver = Driver.getDriver();

	public LoginPageObject() {
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy (xpath = "//*[@id='username']")
	public WebElement loginField;
	
	@FindBy (xpath = "//*[@id='password']")
	public WebElement passwordField;
	
	@FindBy (xpath = "//*[@id='customer_login']/div[1]/form/p[3]/input[3]")
	public WebElement loginBtn;

	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/ul/li")
	public WebElement errMsg;
	
	@FindBy (xpath = "//*[@id='customer_login']")
	public WebElement loginPage;
	
	@FindBy (xpath = "//*[@id='reg_email']")
	public WebElement regEmailField;
	
	@FindBy (xpath = "//*[@id='reg_password']")
	public WebElement regPwdField;
	
	@FindBy (xpath = "//*[@id='customer_login']/div[2]/form/p[3]/input[3]")
	public WebElement registerBtn;
	
	@FindBy (xpath = "//*[@class='woocommerce-error']/li")
	public WebElement errMsgInvalidEmail;
	
	@FindBy (xpath = "//*[@id='customer_login']/div[1]/h2")
	public WebElement loginTxt;
	
	
	@FindBy (xpath = "//*[@class='woocommerce-FormRow woocommerce-FormRow--wide form-row form-row-wide'][2]/input")
	public WebElement passwordDisplay;

	public void verifyIncorrectUserPwdErrMsg() {
		String expectedErrMsg = "Error: A user could not be found with this email address.";
		Assert.assertTrue(errMsg.getText().equals(expectedErrMsg));
	}
	
	public void verifyEmptyPwdErrMsg() {
		String expectedErrMsg = "Error: Password is required.";
		Assert.assertTrue(errMsg.getText().equals(expectedErrMsg));
	}
	
	public void verifyEmptyUsernameValidPwdErrMsg(){
		String expectedErrMsg = "Error: Username is required.";
		Assert.assertTrue(errMsg.getText().equals(expectedErrMsg));
	}
	
	public void verifyEmptyUsernameEmptyPwdErrMsg() {
		String expectedErrMsg = "Error: Username is required.";
		Assert.assertTrue(errMsg.getText().equals(expectedErrMsg));
		
	}
	
	public void verifyCaseSensitiveEmailPwdErrMsg() {
		String expectedErrMsg = "ERROR: The password you entered for the username NUI@gmail.com is incorrect. Lost your password?";
		Assert.assertTrue(errMsg.getText().equals(expectedErrMsg));
		
	}
	


}

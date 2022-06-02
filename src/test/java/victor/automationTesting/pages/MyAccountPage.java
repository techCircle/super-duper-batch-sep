package victor.automationTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import victor.utilities.Victor_BaseClass;
import victor.utilities.Victor_Constants;

public class MyAccountPage {

	public MyAccountPage () {
		PageFactory.initElements(Victor_BaseClass.getDriver(), this);
		
	}
	
	@FindBy (xpath="//*[@id=\"menu-item-50\"]/a")
	public WebElement myAccount;
	
	@FindBy (id = "username")
	public WebElement username;
	
	@FindBy (id = "password")
	public WebElement password;
	
	@FindBy (xpath="//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")
	public WebElement loginButton;
	
	@FindBy (xpath="//*[contains(@class,'woocommerce-error')]")
	public WebElement messageError;
	
	@FindBy (xpath="//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[6]/a")
	public WebElement logout;
	
	@FindBy (id="reg_email")
	public WebElement reg_email;
	
	@FindBy (id="reg_password")
	public WebElement reg_password;
	
	@FindBy (xpath="//*[@id=\"customer_login\"]/div[2]/form/p[3]/input[3]")
	public WebElement registerButton;
	
	public void loginWithValidUserAndPAssword () {
		username.sendKeys(Victor_BaseClass.getProperty("userName"));
		password.sendKeys(Victor_BaseClass.getProperty("password"));
		loginButton.click();
		
		
	}
	public void loginWithInvalidUserAndPAssword () {
		username.sendKeys(Victor_BaseClass.getProperty("invalidUserName"));
		password.sendKeys(Victor_BaseClass.getProperty("invalidPassword"));
		loginButton.click();
		Assert.assertTrue(messageError.getText().equals(Victor_Constants.expectedMessageError));
	}
	
	public void loginWithValidUserAndEmpyPAssword () {
		username.sendKeys(Victor_BaseClass.getProperty("userName"));
		password.sendKeys(Victor_BaseClass.getProperty("empypassword"));
		loginButton.click();
		Assert.assertTrue(messageError.getText().equals(Victor_Constants.EmpyPasswordMessageError));
	}
	
	public void loginWithEmpyUserAndValidPAssword () {
		username.sendKeys(Victor_BaseClass.getProperty("empyUserName"));
		password.sendKeys(Victor_BaseClass.getProperty("password"));
		loginButton.click();
		Assert.assertTrue(messageError.getText().equals(Victor_Constants.EmpyUsernameMessageError));
	}
	
	public void loginWithEmpyUserAndEmptyPAssword () {
		username.sendKeys(Victor_BaseClass.getProperty("empyUserName"));
		password.sendKeys(Victor_BaseClass.getProperty("empypassword"));
		loginButton.click();
		Assert.assertTrue(messageError.getText().equals(Victor_Constants.EmpyUsernameMessageError));
	}
	
	public void passwordField() {
		password.sendKeys(Victor_BaseClass.getProperty("password"));
		loginButton.click();
		Assert.assertTrue(password.getAttribute("type").equals("password")); 
		
	}
	
	public void loginWithValidUserAndPsasword () {
		username.sendKeys(Victor_BaseClass.getProperty("userName"));
		password.sendKeys(Victor_BaseClass.getProperty("psasword"));
		loginButton.click();
		Assert.assertTrue(messageError.getText().equals(Victor_Constants.wrongPasswordMessageError));
		
	}
	
	public void registrationSignIn () {
		reg_email.sendKeys(Victor_BaseClass.getProperty("userName"));
		reg_password.sendKeys(Victor_BaseClass.getProperty("password"));
		registerButton.click();
		
	}
	
	public void registrationInvalidEmail () {
		reg_email.sendKeys(Victor_BaseClass.getProperty("invalidEmail"));
		reg_password.sendKeys(Victor_BaseClass.getProperty("password"));
		registerButton.click();
		Assert.assertTrue(messageError.getText().equals(Victor_Constants.invalidEmailAddress));
	}
	
	public void registrationEmpyEmail () {
		reg_email.sendKeys(Victor_BaseClass.getProperty("empyUserName"));
		reg_password.sendKeys(Victor_BaseClass.getProperty("password"));
		registerButton.click();
		Assert.assertTrue(messageError.getText().equals(Victor_Constants.invalidEmailAddress));
	}
	
	public void registrationEmpyPassword () {
		reg_email.sendKeys(Victor_BaseClass.getProperty("userName2"));
		reg_password.sendKeys(Victor_BaseClass.getProperty("empypassword"));
		registerButton.click();
		Assert.assertTrue(messageError.getText().equals(Victor_Constants.emptyPasswordError));
	}
	
	public void registrationEmpyEmailandPAssword () {
		reg_email.sendKeys(Victor_BaseClass.getProperty("empyUserName"));
		reg_password.sendKeys(Victor_BaseClass.getProperty("empypassword"));
		registerButton.click();
		Assert.assertTrue(messageError.getText().equals(Victor_Constants.invalidEmailAddress));
	}
}

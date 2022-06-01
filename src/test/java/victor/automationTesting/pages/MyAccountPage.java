package victor.automationTesting.pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
}

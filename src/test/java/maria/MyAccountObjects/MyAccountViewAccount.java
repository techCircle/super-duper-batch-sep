package maria.MyAccountObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.ConfigurationProperties;
import Utilities.Driver;

public class MyAccountViewAccount {

	public MyAccountViewAccount() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

//changes to push
	@FindBy(id="account_first_name")
	public WebElement firstNameEdit;



	@FindBy(id="account_last_name")
	public WebElement lastNameEdit;

	@FindBy(xpath="//label[@for='password_current']")
	public WebElement PasswordChange;


	@FindBy(xpath="//label[@for='password_1']")
	public WebElement newPassword;


	@FindBy(xpath="//label[@for='password_2']")
	public WebElement newConfirmPassword;

	@FindBy(name="save_account_details")
	public WebElement saveChanges;

	@FindBy(xpath="//*[@id='page-36']/div/div[1]/div[1]/text()")
	public WebElement passwordChangeConfim;

	


	public void editAccountDetails() {

		System.out.println(PasswordChange.getText());
		Assert.assertTrue(PasswordChange.isDisplayed());
		Assert.assertTrue(newPassword.isDisplayed());
		Assert.assertTrue(newConfirmPassword.isDisplayed());
	}



}

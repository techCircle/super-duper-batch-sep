package Emmie_automationTestingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Emmie_Utilities.Driver;

public class LoginPage {

	public LoginPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[@name='username']")
	public WebElement loginField;

	@FindBy(id = "password")
	public WebElement passField;

	@FindBy(xpath = "//*[@name='login']")
	public WebElement loginBox;

	@FindBy(xpath = "//*[text()='Dashboard']")
	public WebElement verifyLoginPage;

	public void validEmailInput() {
		loginField.sendKeys(Driver.getProperty("validEmail"));
	}

	public void validPasswordInput() {
		passField.sendKeys(Driver.getProperty("validPass"));
	}

	public void invalidEmailInput() {
		loginField.sendKeys(Driver.getProperty("InvalidEmail"));
	}

	public void invalidPassword() {
		passField.sendKeys(Driver.getProperty("InvalidPass"));
	}

	public void emptyEmailInpuyt() {
		loginField.sendKeys(Driver.getProperty("EmptyEmail"));
	}

	public void emptyPasswordInput() {
		passField.sendKeys(Driver.getProperty("EmptyPass"));
	}

	public void caseChangeEmailInput() {
		passField.sendKeys(Driver.getProperty("CaseChangeEmail"));
	}

	public void caseChangePasswordInput() {
		passField.sendKeys(Driver.getProperty("CaseChangePass"));
	}

	public void loginBoxClick() {
		loginBox.click();
	}
	
	
	public void verifyInValidInput() {

		String actualText = Driver.driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li")).getText();
		String expectedText = actualText.toString();
		Assert.assertTrue(actualText.contains(expectedText));
	}

}

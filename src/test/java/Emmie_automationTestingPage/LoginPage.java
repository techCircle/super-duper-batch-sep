package Emmie_automationTestingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Emmie_Utilities.Emmie_Driver;

public class LoginPage {

	public LoginPage() {
		PageFactory.initElements(Emmie_Driver.getDriver(), this);
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
		loginField.sendKeys(Emmie_Driver.getProperty("validEmail"));
	}

	public void validPasswordInput() {
		passField.sendKeys(Emmie_Driver.getProperty("validPass"));
	}

	public void invalidEmailInput() {
		loginField.sendKeys(Emmie_Driver.getProperty("InvalidEmail"));
	}

	public void invalidPassword() {
		passField.sendKeys(Emmie_Driver.getProperty("InvalidPass"));
	}

	public void emptyEmailInpuyt() {
		loginField.sendKeys(Emmie_Driver.getProperty("EmptyEmail"));
	}

	public void emptyPasswordInput() {
		passField.sendKeys(Emmie_Driver.getProperty("EmptyPass"));
	}

	public void caseChangeEmailInput() {
		passField.sendKeys(Emmie_Driver.getProperty("CaseChangeEmail"));
	}

	public void caseChangePasswordInput() {
		passField.sendKeys(Emmie_Driver.getProperty("CaseChangePass"));
	}

	public void loginBoxClick() {
		loginBox.click();
	}
	
	
	public void verifyInValidInput() {

		String actualText = Emmie_Driver.driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li")).getText();
		String expectedText = actualText.toString();
		Assert.assertTrue(actualText.contains(expectedText));
	}

}

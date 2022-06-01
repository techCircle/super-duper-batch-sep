package Emmie_automationTestingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Emmie_Utilities.Emmie_Driver;

public class RegistrationPage {
	public RegistrationPage() {
		PageFactory.initElements(Emmie_Driver.getDriver(), this);
	}

	@FindBy(id = "reg_email")
	public WebElement emailField;

	@FindBy(id = "reg_password")
	public WebElement passwordlField;

	@FindBy(xpath = "//*[@name='register']")
	public WebElement registerBox;

	public void validEmailInput() {
		emailField.sendKeys(Emmie_Driver.getProperty("validEmail"));
	}

	public void validPasswordInput() {
		passwordlField.sendKeys(Emmie_Driver.getProperty("validPass"));
	}

	public void invalidEmailInput() {
		emailField.sendKeys(Emmie_Driver.getProperty("InvalidEmail"));
	}

	public void invalidPassword() {
		passwordlField.sendKeys(Emmie_Driver.getProperty("InvalidPass"));
	}
	
	public void emptyEmailInpuyt() {
		emailField.sendKeys(Emmie_Driver.getProperty("EmptyEmail"));
	}
	public void emptyPasswordInput(){
		passwordlField.sendKeys(Emmie_Driver.getProperty("EmptyPass"));
	}
	
	

	public void verifyErrorText() {
		// Error (xPath)
		String actualText = Emmie_Driver.driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li")).getText();
		String expectedText = actualText.toString();
		Assert.assertTrue(actualText.contains(expectedText));

	}
}

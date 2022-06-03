package Kanlaya_51TestCasePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Kanlaya_51TestCaseUtilities.Base;

public class MyAccountRegistrationPage {
	
	

	public MyAccountRegistrationPage() {
		
		PageFactory.initElements(Base.getDriver(),this);
	}
	
	
	// REGISTRATION
		@FindBy(id = "reg_email")
		public WebElement regEmailBox;

		@FindBy(id = "reg_password")
		public WebElement regPasswordBox;

		@FindBy(xpath = "//input[@name = 'register']")
		public WebElement regButton;
		
		@FindBy(xpath = "//*[@class = 'woocommerce']/ul/li")
		public WebElement actualRegisterErrorMessage;
		
		public void validRegister() throws InterruptedException {
			regEmailBox.sendKeys(Base.getProperty("email"));
			Thread.sleep(1000);
			regPasswordBox.sendKeys(Base.getProperty("password"));
			Thread.sleep(1000);
			regButton.click();
		}

		public void registerInvalidEmailID() throws InterruptedException {
			regEmailBox.sendKeys(Base.getProperty("incorrectEmail"));
			Thread.sleep(1000);
			regPasswordBox.sendKeys(Base.getProperty("password"));
			Thread.sleep(1000);
			regButton.click();
			Thread.sleep(1000);
			String actualMessage = actualRegisterErrorMessage.getText();
			System.out.println(actualMessage);
			String expectedText = Base.getProperty("expectedErrorMessageRegisterInvalidEmail");
			Assert.assertEquals(actualMessage, expectedText);
		}

		public void registerEmptyEmail() throws InterruptedException {
			regEmailBox.sendKeys(Base.getProperty("emptyEmail"));
			Thread.sleep(1000);
			regPasswordBox.sendKeys(Base.getProperty("password"));
			Thread.sleep(1000);
			regButton.click();
			Thread.sleep(1000);
			String actualMessage = actualRegisterErrorMessage.getText();
			System.out.println(actualMessage);
			String expectedText = Base.getProperty("expectedErrorMessageRegisterEmptyEmail");
			Assert.assertEquals(actualMessage, expectedText);
		}

		public void registerEmptyPassword() throws InterruptedException {
			regEmailBox.sendKeys(Base.getProperty("email"));
			Thread.sleep(1000);
			regPasswordBox.sendKeys(Base.getProperty("emptyPassword"));
			Thread.sleep(1000);
			regButton.click();
			Thread.sleep(1000);
			String actualMessage = actualRegisterErrorMessage.getText();
			System.out.println(actualMessage);
			String expectedText = Base.getProperty("expectedErrorMessageRegisterEmptyPassword");
			Assert.assertEquals(actualMessage, expectedText);
		}

		public void registerEmptyEmailAndPassword() throws InterruptedException {
			regEmailBox.sendKeys(Base.getProperty("emptyEmail"));
			Thread.sleep(1000);
			regPasswordBox.sendKeys(Base.getProperty("emptyPassword"));
			Thread.sleep(1000);
			regButton.click();
			Thread.sleep(1000);
			String actualMessage = actualRegisterErrorMessage.getText();
			System.out.println(actualMessage);
			String expectedText = Base.getProperty("expectedErrorMessageRegisterEmptyEmailAndPassword");
			Assert.assertEquals(actualMessage, expectedText);

		}


}

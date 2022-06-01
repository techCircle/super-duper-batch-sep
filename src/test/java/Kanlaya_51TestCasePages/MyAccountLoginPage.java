package Kanlaya_51TestCasePages;

import static org.testng.Assert.assertTrue;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Kanlaya_51TestCaseUtilities.Base;

public class MyAccountLoginPage {

	public MyAccountLoginPage() {
		
		PageFactory.initElements(Base.getDriver(), this);
		
	}
	
	// LOGIN PAGE
		@FindBy(id = "username")
		public WebElement usernameBox;

		@FindBy(xpath = "//*[@id='password']")
		public WebElement passwordBox;

		@FindBy(xpath = "//*[@name='login']")
		public WebElement loginButton;
		
		@FindBy(xpath = "//*[text() = 'Login']")
		public WebElement loginText;
		
		@FindBy(xpath = "//*[@class = 'woocommerce']/ul/li")
		public WebElement actualLoginErrorMessage;
		
		@FindBy(xpath = "//*[text() = 'Sign out']")
		public WebElement signoutLink;

		@FindBy(xpath = "//*[text() = 'Logout']")
		public WebElement logoutButton;


		// LOGIN PAGE
		public void validLogin() {
			usernameBox.sendKeys(Base.getProperty("email"));
			passwordBox.sendKeys(Base.getProperty("password"));
			loginButton.click();
			String actualMessage = logoutButton.getText();
			String exptText = Base.getProperty("expectedLoginSucessText");
			Assert.assertTrue(actualMessage.contains(exptText));
		}

		public void incorrectUsernameIncorrectPassword() {
			usernameBox.sendKeys(Base.getProperty("incorrectUsername"));
			passwordBox.sendKeys(Base.getProperty("incorrectPassword"));
			loginButton.click();

			String actualMessage = actualLoginErrorMessage.getText();
			String exptErrorText = Base.getProperty("expectedErrorMessageIncorrectUsernameAndPassword");
			Assert.assertEquals(actualMessage, exptErrorText);
		}

		public void correctUsernameEmptyPassword() {
			usernameBox.sendKeys(Base.getProperty("email"));
			passwordBox.sendKeys(Base.getProperty("emptyPassword"));
			loginButton.click();

			String actualMessage = actualLoginErrorMessage.getText();
			String exptErrorText = Base.getProperty("expectedErrorMessageCorrectUsernameEmptyPassword");
			Assert.assertEquals(actualMessage, exptErrorText);
		}

		public void emptyUsernamecorrectPassword() {
			usernameBox.sendKeys(Base.getProperty("emptyUsername"));
			passwordBox.sendKeys(Base.getProperty("password"));
			loginButton.click();

			String actualMessage = actualLoginErrorMessage.getText();
			String exptErrorText = Base.getProperty("expectedErrorMessageEmptyUsernameCorrectPassword");
			Assert.assertEquals(actualMessage, exptErrorText);
		}

		public void emptyUsernameEmptyPassword() {
			usernameBox.sendKeys(Base.getProperty("emptyUsername"));
			passwordBox.sendKeys(Base.getProperty("emptyPassword"));
			loginButton.click();

			String actualMessage = actualLoginErrorMessage.getText();
			String exptErrorText = Base.getProperty("expectedErrorMessageEmptyUsernameAndPassword");
			Assert.assertEquals(actualMessage, exptErrorText);
		}

		public void verifyPasswordShouldBeMasked() {
			passwordBox.sendKeys(Base.getProperty("password"));
			Assert.assertEquals(passwordBox.getAttribute("type"), "password");
			String actualType = passwordBox.getAttribute("type");
			String expectedType = "password";
			System.out.println("Actual Type : " + actualType);
			System.out.println("Expected Type : " + expectedType);
		}

		public void verifyCaseSensitive() {
			usernameBox.sendKeys(Base.getProperty("caseSensitiveUsername"));
			passwordBox.sendKeys(Base.getProperty("caseSensitivePassword"));
			loginButton.click();

			String actualMessage = actualLoginErrorMessage.getText();
			String exptErrorText = Base.getProperty("expectedErrorMessageCaseChangesUsernameAndPassword");
			Assert.assertEquals(actualMessage, exptErrorText);
		}

		public void verifyLoginAuthentication() {
			usernameBox.sendKeys(Base.getProperty("email"));
			passwordBox.sendKeys(Base.getProperty("password"));
			loginButton.click();

			Boolean signOut = signoutLink.isDisplayed();
			System.out.println(signoutLink.getText());
			assertTrue(signOut);
			signoutLink.click();

			Boolean visibleLoginText = loginText.isDisplayed();
			Assert.assertTrue(visibleLoginText);

		}

}

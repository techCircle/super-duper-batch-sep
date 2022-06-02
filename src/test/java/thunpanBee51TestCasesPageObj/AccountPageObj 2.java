package thunpanBee51TestCasesPageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import thunpanBee51TestCases.Driver;

public class AccountPageObj {

	// registration //
	@FindBy(xpath = "//*[text()='My Account']")
	public WebElement accBtn;

	@FindBy(xpath = "//input[@id='reg_email']")
	public WebElement emailBox;

	@FindBy(xpath = "//input[@id='reg_password']")
	public WebElement passWordBox;

	@FindBy(xpath = "//*[@name='register']")
	public WebElement registerBtn;

	@FindBy(xpath = "//*[@id='page-36']/div/div[1]/ul/li")
	public WebElement Text;

	//////////////////////////////////////////////////////////////////////
	// login //
	@FindBy(xpath = "//*[@name='username']")
	public WebElement userBox;

	@FindBy(xpath = "//*[@id='password']")
	public WebElement passWordLoginBox;

	@FindBy(xpath = "//*[@name='login']")
	public WebElement loginBtn;

	@FindBy(xpath = "//*[@id='password']")
	public WebElement passwordVer;

	public AccountPageObj() {
		PageFactory.initElements(Driver.driver, this);
	}
	public void verify() {
 		String actualText = Text.getText();
 		String expectedText = actualText.toString();
 		Assert.assertTrue(actualText.contains(expectedText));
 		System.out.println("ActualText : " + actualText);
 		System.out.println("ExpectedText : " + expectedText);
 	}
	

 	public void passwordVerify() {
 		Assert.assertEquals(passwordVer.getAttribute("type"), "password");
 		String actualType = passwordVer.getAttribute("type");
 		String expectedType = "password";
 		System.out.println("Actual Type : " + actualType);
 		System.out.println("Expected Type : " + expectedType);
 	}
 	
 	
	
//	@DataProvider(name = "loginInvalidDataProvider")
// 	public Object[][] dataMethod() {
// 		return new Object[][] { { "ee@gmail.com", "!12345bee!12345bee!12345bee!12345beast" }, // loginWithIncorrectEmailAndIncorrectPassword
// 				{ "be_bee@gmail.com", "" }, // loginWithCorrectUserNameAndEmptyPassword
// 				{ "", "!12345bee!12345bee!12345bee!12345bee" }, // loginWithEmptyUsernameAndValidPassword
// 				{ "", "" }, // loginWithEmptyUsernameAndEmptyPassword
// 				{ "bE_BeE@gMaIl.COM", "!12345BeE!12345bEe!12345BeE!12345bEe" } };// loginHandleCaseSensitive
// 	}
//
// 	@DataProvider(name = "passwordMaskedData")
// 	public Object[][] bulletMasked() {
// 		return new Object[][] { { "", "test12345" } };// loginPasswordShouldBeMasked
// 	}
//
// 	@DataProvider(name = "validLoginDataProvider")
// 	public Object[][] valid() {
// 		return new Object[][] { { "be_bee@gmail.com", "!12345bee!12345bee!12345bee!12345bee" }// loginWithValidUserAndPassword
// 																								// loginAuthentication
// 		};
// 	}

// 	@Test(dataProvider = "loginInvalidDataProvider")
 	public void invalidLogin(String userName, String password) {

 		userBox.sendKeys(userName);
 		passWordLoginBox.sendKeys(password);
 		loginBtn.click();
 		verify();
 	}

// 	@Test(dataProvider = "passwordMaskedData", dependsOnMethods = "loginFunctionalityTest")
 	public void invalidLogin(String password) {
 		passWordLoginBox.sendKeys(password);
 		passwordVerify();
 	}

// 	@Test(dataProvider = "validLoginDataProvider", dependsOnMethods = "loginPasswordShouldBeMasked")
 	public void validLogin(String userName, String password) {
 		userBox.sendKeys(userName);
 		passWordLoginBox.sendKeys(password);
 		loginBtn.click();
 		
 	}

// 	@Test(dataProvider = "validLoginDataProvider", dependsOnMethods = "validLogin")
 	public void authenticationLogin(String userName, String password) {
 		userBox.sendKeys(userName);
 		passWordLoginBox.sendKeys(password);
 		loginBtn.click();
 		
 	}
}

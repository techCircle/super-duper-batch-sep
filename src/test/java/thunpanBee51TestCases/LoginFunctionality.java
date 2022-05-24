package thunpanBee51TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginFunctionality extends Driver {
	private ObjectFactory loginPage;

	@BeforeClass
	public void setUp() {
		getDriver();
		System.out.println("Successful Open Browser");

	}

	@BeforeMethod
	public void beforeTest() {
		loginPage = new ObjectFactory(driver);
		loginPage.accBtn.click();
	}

	@DataProvider(name = "loginInvalidDataProvider")
	public Object[][] dataMethod() {
		return new Object[][] { { "ee@gmail.com", "!12345bee!12345bee!12345bee!12345beast" }, // loginWithIncorrectEmailAndIncorrectPassword
				{ "be_bee@gmail.com", "" }, // loginWithCorrectUserNameAndEmptyPassword
				{ "", "!12345bee!12345bee!12345bee!12345bee" }, // loginWithEmptyUsernameAndValidPassword
				{ "", "" }, // loginWithEmptyUsernameAndEmptyPassword
				{ "bE_BeE@gMaIl.COM", "!12345BeE!12345bEe!12345BeE!12345bEe" } };// loginHandleCaseSensitive
	}

	@DataProvider(name = "passwordMaskedData")
	public Object[][] bulletMasked() {
		return new Object[][] { { "", "test12345" } };// loginPasswordShouldBeMasked
	}

	@DataProvider(name = "validLoginDataProvider")
	public Object[][] valid() {
		return new Object[][] { { "be_bee@gmail.com", "!12345bee!12345bee!12345bee!12345bee" }// loginWithValidUserAndPassword
																								// loginAuthentication
		};
	}

	@Test(dataProvider = "loginInvalidDataProvider")
	public void loginFunctionalityTest(String userName, String password) {

		loginPage.userBox.sendKeys(userName);
		loginPage.passWordLoginBox.sendKeys(password);
		loginPage.loginBtn.click();
		loginPage.verify();
	}

	@Test(dataProvider = "passwordMaskedData", dependsOnMethods = "loginFunctionalityTest")
	public void loginPasswordShouldBeMasked(String userName, String password) {
		loginPage.passWordLoginBox.sendKeys(password);
		loginPage.passwordVerify();
	}

	@Test(dataProvider = "validLoginDataProvider", dependsOnMethods = "loginPasswordShouldBeMasked")
	public void validLogin(String userName, String password) {
		loginPage.userBox.sendKeys(userName);
		loginPage.passWordLoginBox.sendKeys(password);
		loginPage.loginBtn.click();
		loginPage.loginVerify();
		loginPage.signOutBtn.click();
	}

	@Test(dataProvider = "validLoginDataProvider", dependsOnMethods = "validLogin")
	public void authenticationLogin(String userName, String password) {
		loginPage.userBox.sendKeys(userName);
		loginPage.passWordLoginBox.sendKeys(password);
		loginPage.loginBtn.click();
		loginPage.signOutBtn.click();
		driver.navigate().back();
	}

	@AfterClass
	public void Destroy() {
		destroy();
	}
}

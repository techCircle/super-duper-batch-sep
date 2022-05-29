package thunpanBee51TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import thunpanBee51TestCasesPageObj.AccountPageObj;
import thunpanBee51TestCasesPageObj.LoginDashBoardObj;

public class LoginFunctionality{
	private AccountPageObj loginPage;
	private LoginDashBoardObj loginDashBoard;

 	@BeforeClass
 	public void setUp() {
 		Driver.getDriver();
 		System.out.println("Successful Open Browser");

 	}

 	@BeforeMethod
 	public void beforeTest() {
 		loginPage = new AccountPageObj();
 		loginDashBoard = new LoginDashBoardObj();
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
 	public void TC001_loginWithInvalidUserNameAndPassword(String userName,String password) {

 		loginPage.invalidLogin(userName,password);
 	}

 	@Test(dataProvider = "passwordMaskedData", dependsOnMethods = "TC001_loginWithInvalidUserNameAndPassword")
 	public void TC002_loginPasswordShouldBeMasked(String userName, String password) {
 		loginPage.invalidLogin(password);
 		loginPage.passwordVerify();
 		
 	}

 	@Test(dataProvider = "validLoginDataProvider", dependsOnMethods = "TC002_loginPasswordShouldBeMasked")
 	public void TC003_validLogin(String userName, String password) {
 		loginPage.validLogin(userName, password);
 		loginDashBoard.loginVerify();
 		loginDashBoard.clickOnSignOutBtn();
 	}

 	@Test(dataProvider = "validLoginDataProvider", dependsOnMethods = "TC003_validLogin")
 	public void TC004_authenticationLogin(String userName, String password) {
 		loginPage.authenticationLogin(userName, password);
 		loginDashBoard.clickOnSignOutBtn();
 		loginDashBoard.navigateBack();
 	}
//
// 	@AfterClass
// 	public void Destroy() {
// 		Driver.destroy();
// 	}
}

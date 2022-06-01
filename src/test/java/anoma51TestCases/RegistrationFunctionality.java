package anoma51TestCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import apPageObjects.RegisterPage;
import apUtilities.BaseClass;


public class RegistrationFunctionality {

	@DataProvider(name = "RegistrationDataProvider")
	public Object[][] dpMethod() {
		return new Object[][] { { BaseClass.getProperty("validUsername"), BaseClass.getProperty("validPassword") },
				{ BaseClass.getProperty("invalidUsername"), BaseClass.getProperty("validPassword") },
				{ "", BaseClass.getProperty("validPassword") }, { BaseClass.getProperty("validUsername"), "" },
				{ "", "" } };
	}

	RegisterPage rp = new RegisterPage();
	
	@BeforeSuite
	public void setUp() {
		BaseClass.getDriver();
	}

	@Test(groups="anoma",dataProvider="RegistrationDataProvider")
	public void registration(String username, String Password) throws InterruptedException {	
		rp.accountMenu.click();
		rp.usernameInput.sendKeys(username);
		rp.passwordInput.sendKeys(Password);
		Thread.sleep(3000);
		rp.registerBtn.click();
		rp.verify();
	}

	@AfterSuite
	public void tearDown() {
		BaseClass.tearDown();
	}
}

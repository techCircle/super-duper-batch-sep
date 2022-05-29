package thunpanBee51TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class RegistrationFunctionality extends Driver{
	private ObjectFactory registerPage;

 	@BeforeClass
 	public void setUp() {
 		getDriver();
 		System.out.println("Successful Open Browser");
 	}

 	@DataProvider(name = "RegistrationDataProvider")
 	public Object[][] dpMethod() {
 		return new Object[][] { { "be_bee@gmail.com", "!12345bee!12345bee!12345bee!12345bee" }, // registrationWithValidEmailAndValidPassword
 				{ "bbee@g", "!12345bee!12345bee!12345bee!12345bee" }, // registrationWithInvalidEmailID
 				{ "", "!12345bee!12345bee!12345bee!12345bee" }, // registrationWithEmptyEmailID
 				{ "be_bee@gmail.com", "" }, // registrationWithEmptyPassword
 				{ "", "" } };// registrationWithEmptyEmailIDAndPassword
 	}

 	@Test(dataProvider = "RegistrationDataProvider")
 	public void registrationFunctionality(String username, String password) {
 		registerPage = new ObjectFactory(driver);
 		registerPage.accBtn.click();
 		registerPage.emailBox.sendKeys(username);
 		registerPage.passWordBox.sendKeys(password);
 		registerPage.registerBtn.click();
 		registerPage.verify();
 	}

 	@AfterClass
 	public void Destroy() {
 		destroy();
 	}
}

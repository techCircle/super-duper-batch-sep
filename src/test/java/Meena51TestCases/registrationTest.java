package Meena51TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import MeenaObject.registrationPage;

public class registrationTest {

	registrationPage regiteration = new registrationPage();

	@DataProvider(name = "RegistrationDataProvider")
 	public Object[][] dataProviderMethod() {
 		return new Object[][] { { "userName", "regPassword" }, // validEmailAndValidPassword
 				{ "invalidUserName", "regPassword" }, // InvalidEmail
 				{ "", "regPassword" }, //emptyEmail
 				{ "userName", "" }, // emptyPassword
 				{ "", "" } };// emptyEmailAndPassword
 	}

 	@Test(dataProvider = "RegistrationDataProvider", groups = {"Meena"})
 	public void registration(String username, String password) throws InterruptedException {
 		
 		regiteration.loginWithEmptyEmailID(username, password);
 	}

 	@AfterClass
 	public void TearDown() {
 		regiteration.tearDown();
 	}
	
}

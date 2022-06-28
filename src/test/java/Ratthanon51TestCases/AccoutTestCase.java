package Ratthanon51TestCases;

import org.testng.annotations.AfterClass;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import RatthanonPageObject.AccoutDetail;
import RatthanonPageObject.HomePage;
import RatthanonPageObject.MyAccountPage;
import RatthanonUtilities.BaseClassR;
import RatthanonUtilities.Constants_ratthanon;



public class AccoutTestCase {
	
	HomePage hp = new HomePage();
	MyAccountPage ac = new MyAccountPage();
	AccoutDetail ad = new AccoutDetail();
	
	 
	  @DataProvider(name="LoginAccoutDataprovider")
		public Object[][] dpMethod() {
			return new Object[][] { { Constants_ratthanon.Invalidusername,Constants_ratthanon.Invalidpassword,Constants_ratthanon.messageInvalidUser  }, { Constants_ratthanon.username,"",Constants_ratthanon.messageCorrectUserEmptyPassword  }, { "",Constants_ratthanon.password,Constants_ratthanon.messageEmtyUservalidPassword  }, { "","",Constants_ratthanon.messageEmtyUservalidPassword }  };
		} 

	@BeforeMethod
	public void beforeClass() {
		BaseClassR.getDriver();
		hp.MyAccountMenu.click();
	}
    
	@Test(priority = 1)
	public void LoginValidUserPassword() {
		ac.LoginvalidUser();		
		Assert.assertTrue(ad.signOutlink.isDisplayed() && ad.signOutlink.isEnabled());
		ad.signOutlink.click();

	}
	
	
	@Test(dataProvider="LoginAccoutDataprovider",priority = 2)
	  public void VerifyLogin(String username,String password,String expecterror) {			
			ac.inputUserName.sendKeys(username);
			ac.inputPassword.sendKeys(password);
			ac.loginButton.click();
			
			Assert.assertTrue(ac.errorText.getText().contains(expecterror));
			Assert.assertTrue(ac.loginForm.isDisplayed());
		 
	  }
	
	@Test(priority = 3)
	  public void MaskedPassword() {
		  ac.inputUserName.sendKeys(Constants_ratthanon.username);
		  ac.inputPassword.sendKeys(Constants_ratthanon.password);
		  Assert.assertTrue(ac.inputPassword.getAttribute("type").equals("password"));
	  }
	
	@Test(priority = 4)
	public void LoginCaseSensitive() {
		 ac.inputUserName.sendKeys(ac.ChageCase(Constants_ratthanon.username));
		 ac.inputPassword.sendKeys(ac.ChageCase(Constants_ratthanon.password));
		
		ac.loginButton.click();
		Assert.assertTrue(ac.errorText.getText().indexOf(Constants_ratthanon.ErrorSensitive) != -1 && ac.errorText.getText().indexOf(Constants_ratthanon.ErrorSensitiveTwo) != -1);

	}
	
	@Test(priority = 5)
	public void LoginAuthentication() {
		  ac.inputUserName.sendKeys(Constants_ratthanon.username);
		  ac.inputPassword.sendKeys(Constants_ratthanon.password);
		  ac.loginButton.click();
		  
		  ad.signOutlink.click();
		  BaseClassR.getDriver().navigate().back();	
		  Assert.assertTrue(ac.loginForm.isDisplayed());
		 
		  
	}
	
	@Test(priority = 6)
	public void RegisterValidInfo() throws InterruptedException {	
		  ac.RegisterWithValidInfo();
		  ad.signOutlink.click();
		 		  
	}
	
	@Test(priority = 7)
	public void RegisterinValidEmail() throws InterruptedException {	
		  ac.RegisterWithinvalidEmail();		  
		  ac.RegisterButton.click();
		  Assert.assertTrue(ac.errorText.getText().contains(Constants_ratthanon.invalidErrorMessages));
		 
		  
	}
	
	@Test(priority = 8)
	public void RegisterWithemptyEmail() throws InterruptedException {	
		  ac.RegisterWithEmptyEmail();		  
		  ac.RegisterButton.click();
		  Assert.assertTrue(ac.errorText.getText().contains(Constants_ratthanon.invalidErrorMessages));
		  
	}
	
	@Test(priority = 9)
	public void RegisterWithEmptypassword() throws InterruptedException {		
		  ac.RegisterWithEmptyPassword();		  
		  ac.RegisterButton.click();
		  System.out.println(ac.errorText.getText());
		  Assert.assertTrue(ac.errorText.getText().contains(Constants_ratthanon.EmtypasswordErrorMessages ));		 
		  
	}	
	
	@Test(priority = 10)
	public void RegisterWithEmptyemailpassword()throws InterruptedException {
		  ac.RegisterWithEmptyEmailPassword();
		  ac.RegisterButton.click();
		  Assert.assertTrue(ac.errorText.getText().contains(Constants_ratthanon.invalidErrorMessages));
	}
	
	
	
	

	@AfterClass
	public void afterClass() {
		BaseClassR.tearDown();
	}

}

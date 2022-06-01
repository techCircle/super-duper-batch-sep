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
	}

	@Test(priority = 1)
	public void LoginValidUserPassword() {

		hp.MyAccountMenu.click();
		ac.LoginvalidUser();		
		Assert.assertTrue(ad.signOutlink.isDisplayed() && ad.signOutlink.isEnabled());
		ad.signOutlink.click();

	}
	
	
	@Test(dataProvider="LoginAccoutDataprovider",priority = 2)
	  public void VerifyLogin(String username,String password,String expecterror) {
		  hp.MyAccountMenu.click();
			
			
			ac.inputUserName.sendKeys(username);
			ac.inputPassword.sendKeys(password);
			ac.loginButton.click();
			
			Assert.assertTrue(ac.errorText.getText().contains(expecterror));
			Assert.assertTrue(ac.loginForm.isDisplayed());
		 
	  }
	
	@Test(priority = 3)
	  public void MaskedPassword() {
		  hp.MyAccountMenu.click();
		  ac.inputUserName.sendKeys(Constants_ratthanon.username);
		  ac.inputPassword.sendKeys(Constants_ratthanon.password);
		  Assert.assertTrue(ac.inputPassword.getAttribute("type").equals("password"));
	  }
	
	@Test(priority = 4)
	public void LoginCaseSensitive() {
		
		 hp.MyAccountMenu.click();
		 ac.inputUserName.sendKeys(ac.ChageCase(Constants_ratthanon.username));
		 ac.inputPassword.sendKeys(ac.ChageCase(Constants_ratthanon.password));
		
		ac.loginButton.click();
		Assert.assertTrue(ac.errorText.getText().indexOf("The password you entered for the username") != -1 && ac.errorText.getText().indexOf("is incorrect") != -1);

	}
	
	@Test(priority = 5)
	public void LoginAuthentication() {
		  hp.MyAccountMenu.click();
		  ac.inputUserName.sendKeys(Constants_ratthanon.username);
		  ac.inputPassword.sendKeys(Constants_ratthanon.password);
		  ac.loginButton.click();
		  
		  ad.signOutlink.click();
		  BaseClassR.getDriver().navigate().back();	
		  Assert.assertTrue(ac.loginForm.isDisplayed());
		 
		  
	}
	
	@Test(priority = 6)
	public void RegisterValidInfo() throws InterruptedException {
		  hp.MyAccountMenu.click();
		  ac.RegisterWithValidInfo();
		  
		  Thread.sleep(5);
		  
		  Assert.assertTrue(ac.errorText.getText().contains(Constants_ratthanon.RegisterwithAlreadyAccout));
			
		  //System.out.println(ac.RegisterButton.isEnabled());
		 
		  
	}
	
	@Test(priority = 7)
	public void RegisterinValidEmail() throws InterruptedException {
		  hp.MyAccountMenu.click();
		  ac.RegisterWithinvalidEmail();
		  
		  ac.RegisterButton.click();
		  Assert.assertTrue(ac.errorText.getText().contains("Error: Please provide a valid email address."));
		 
		  
	}
	
	@Test(priority = 8)
	public void RegisterWithemptyEmail() throws InterruptedException {
		  hp.MyAccountMenu.click();
		  ac.RegisterWithEmptyEmail();
		  
		  ac.RegisterButton.click();
		  Assert.assertTrue(ac.errorText.getText().contains("Error: Please provide a valid email address."));
		  
	}
	
	@Test(priority = 9)
	public void RegisterWithEmptypassword() throws InterruptedException {
		  hp.MyAccountMenu.click();
		  ac.RegisterWithEmptyPassword();
		  
		  ac.RegisterButton.click();
		  System.out.println(ac.errorText.getText());
		  Assert.assertTrue(ac.errorText.getText().contains("Error: Please enter an account password."));		 
		  
	}	
	
	@Test(priority = 10)
	public void RegisterWithEmptyemailpassword()throws InterruptedException {
		  hp.MyAccountMenu.click();
		  ac.RegisterWithEmptyEmailPassword();
		  ac.RegisterButton.click();
		  Assert.assertTrue(ac.errorText.getText().contains("Error: Please provide a valid email address."));
	}
	
	
	
	

	@AfterClass
	public void afterClass() {
		BaseClassR.tearDown();
	}
}

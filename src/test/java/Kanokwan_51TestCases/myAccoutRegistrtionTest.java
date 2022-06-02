package Kanokwan_51TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import KanokwanObject.myAccountRegistrationPage;
import KanokwanUtilities.KanokwanBaseClass;


public class myAccoutRegistrtionTest {
		
	myAccountRegistrationPage arp = new myAccountRegistrationPage();
	
	@BeforeClass
	public void setUp() {
		
		KanokwanBaseClass.getDriver();
	}
	


	@BeforeMethod
		public void beforeMethod() {
		
		arp.myAccountMenu();
	}

	@Test(priority = 1)
	public void validEmailAndPassword() throws InterruptedException {
		
		arp.valid_userName_register();
		Thread.sleep(3000);
		arp.valid_password_register();
		Thread.sleep(3000);
		arp.registerButton();
		arp.verifyRegisterText();
		arp.signOutButton();
		arp.verifySignout();
		
	}
	
	@Test(priority = 2)
	public void invalidEmailAnaValidPassword () throws InterruptedException {
		
		arp.inValid_userName_register();
		Thread.sleep(3000);
		arp.valid_password_register();
		Thread.sleep(3000);
		arp.registerButton();
		arp.verifyErrorText();
		
	}
	
	@Test(priority = 3)
	public void emptyEmailAnaValidPassword () throws InterruptedException {
		
		arp.emptyUserName_register();
		Thread.sleep(3000);
		arp.valid_password_register();
		Thread.sleep(3000);
		arp.registerButton();
		arp.verifyErrorText();
	}
		
	@Test(priority = 4)
	public void validEmailAnaEmptyPassword () throws InterruptedException {
		
		arp.valid_userName_register();
		Thread.sleep(3000);
		arp.emptyPassword_register();
		Thread.sleep(3000);
		arp.registerButton();
		arp.verifyErrorText();
	}
	
	@Test(priority = 5)
	public void EmptyEmailAnaEmptyPassword () throws InterruptedException {
		
		arp.emptyUserName_register();
		Thread.sleep(3000);
		arp.emptyPassword_register();
		Thread.sleep(3000);
		arp.registerButton();
		arp.verifyErrorText();
	}
	
    @AfterClass
    public void tearDown() {
        KanokwanBaseClass.tearDown();
    }
}

package Nui51TestCases.Test;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Nui51TestCases.PageObject.CommonPageObject;
import Nui51TestCases.PageObject.HomePageObject;
import Nui51TestCases.PageObject.LoginPageObject;
import Nui51TestCases.PageObject.MyAccountPageObject;
import NuiUtilities.Driver;
import NuiUtilities.NuiConfigurationProperties;
import NuiUtilities.RandomString;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class MyAccountRegistration {
	
	WebDriver driver;
	WebDriverWait wait;
	HomePageObject hp = new HomePageObject();
	LoginPageObject lg = new LoginPageObject();
	CommonPageObject cp = new CommonPageObject();
	MyAccountPageObject ap = new MyAccountPageObject();
	
	@BeforeClass
	public static void before() {
		
	}

	@BeforeMethod
	public void setUp() {
		
		driver = Driver.getDriver();
		driver.get(NuiConfigurationProperties.getKeyValue("url"));
		wait = new WebDriverWait(driver, 30);
	}
	
	@Test
	public void signIn() throws InterruptedException {
		cp.myaccountBtn.click();
		lg.regEmailField.sendKeys(RandomString.generateRandomString(10)+ "@gmail.com");
		lg.regPwdField.sendKeys(NuiConfigurationProperties.getKeyValue("goodPassword"));
		Thread.sleep(1000);
		lg.regPwdField.sendKeys(NuiConfigurationProperties.getKeyValue("goodPassword"));
		lg.registerBtn.click();
		Thread.sleep(3000);
		hp.verifyAlreadyLogin();
	}

	@Test
	public void invalidEmailId() throws InterruptedException {
		cp.myaccountBtn.click();
		lg.regEmailField.sendKeys(NuiConfigurationProperties.getKeyValue("invalidEmail"));
		lg.regPwdField.sendKeys(NuiConfigurationProperties.getKeyValue("goodPassword"));
		Thread.sleep(1000);
		lg.regPwdField.sendKeys(" "); //has to do this to make register button clickable
		lg.registerBtn.click();
		wait.until(ExpectedConditions.visibilityOf(lg.errMsgInvalidEmail));
		Assert.assertTrue(lg.errMsgInvalidEmail.getText().equals(NuiConfigurationProperties.getKeyValue("inValidEmailErrMsg")));
	}
	
	@Test
	public void emptyEmailId() throws InterruptedException {
		cp.myaccountBtn.click();
		lg.regPwdField.sendKeys(NuiConfigurationProperties.getKeyValue("goodPassword"));
		Thread.sleep(1000);
		lg.regPwdField.sendKeys(" "); //has to do this to make register button clickable
		lg.registerBtn.click();
		wait.until(ExpectedConditions.visibilityOf(lg.errMsgInvalidEmail));
		Assert.assertTrue(lg.errMsgInvalidEmail.getText().equals(NuiConfigurationProperties.getKeyValue("inValidEmailErrMsg")));
	}
	
	@Test
	public void emptyPwd() {
		cp.myaccountBtn.click();
		lg.regEmailField.sendKeys(NuiConfigurationProperties.getKeyValue("registeredEmailEmptyPwd"));
		lg.regPwdField.sendKeys("");
		lg.registerBtn.click();
		System.out.println(lg.errMsg.getText());
		Assert.assertTrue(lg.errMsg.getText().equals(NuiConfigurationProperties.getKeyValue("emptyPwdErrMsg")));
	}  
	
	@Test
	public void emptyEmailIdEmptyPwd() {
		cp.myaccountBtn.click();
		lg.regEmailField.sendKeys("");
		lg.regPwdField.sendKeys("");
		lg.registerBtn.click();
		Assert.assertTrue(lg.errMsg.getText().equals(NuiConfigurationProperties.getKeyValue("inValidEmailErrMsg")));
	}
	
	@AfterClass
	public void after() {
		
		driver.quit();
	}

}

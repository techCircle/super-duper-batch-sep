package Nui51TestCases.Test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Nui51TestCases.PageObject.CommonPageObject;
import Nui51TestCases.PageObject.HomePageObject;
import Nui51TestCases.PageObject.LoginPageObject;
import Nui51TestCases.PageObject.MyAccountPageObject;
import NuiUtilities.Driver;
import NuiUtilities.NuiConfigurationProperties;

public class MyAccountLogin {
	
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
	public void validUsernamePassword() {
		cp.myaccountBtn.click();
		lg.loginField.sendKeys(NuiConfigurationProperties.getKeyValue("goodEmail"));
		lg.passwordField.sendKeys(NuiConfigurationProperties.getKeyValue("goodPassword"));
		lg.loginBtn.click();
		hp.verifyAlreadyLogin();
	}
	
	@Test
	public void incorrectUsernameIncorrectPassword() {
		cp.myaccountBtn.click();
		lg.loginField.sendKeys(NuiConfigurationProperties.getKeyValue("badEmail"));
		lg.passwordField.sendKeys(NuiConfigurationProperties.getKeyValue("badPassword"));
		lg.loginBtn.click();
		lg.verifyIncorrectUserPwdErrMsg();
	}
	
	@Test
	public void validUsernameEmptyPwd() {
		cp.myaccountBtn.click();
		lg.loginField.sendKeys(NuiConfigurationProperties.getKeyValue("goodEmail"));
		lg.passwordField.sendKeys("");
		lg.loginBtn.click();
		lg.verifyEmptyPwdErrMsg();
	}
	
	@Test
	public void emptyUsernameValidPwd() {
		cp.myaccountBtn.click();
		lg.loginField.sendKeys("");
		lg.passwordField.sendKeys(NuiConfigurationProperties.getKeyValue("goodPassword"));
		lg.loginBtn.click();
	}
	
	@Test
	public void emptyUsernameEmptyPwd() {
		cp.myaccountBtn.click();
		lg.loginField.sendKeys("");
		lg.passwordField.sendKeys("");
		lg.loginBtn.click();
		lg.verifyEmptyUsernameEmptyPwdErrMsg();
	}
	
	@Test
	public void pwdShouldBeMasked() {
		cp.myaccountBtn.click();
		lg.passwordField.sendKeys(NuiConfigurationProperties.getKeyValue("goodPassword"));
		Assert.assertTrue(lg.passwordDisplay.getAttribute("type").equals("password"));
	}
	
	@Test
	public void handlesCaseSensitive() {
		cp.myaccountBtn.click();
		lg.loginField.sendKeys(NuiConfigurationProperties.getKeyValue("upperCaseEmail"));
		lg.passwordField.sendKeys(NuiConfigurationProperties.getKeyValue("upperCasePwd"));
		lg.loginBtn.click();
		lg.verifyCaseSensitiveEmailPwdErrMsg();
	}
	
	@Test
	public void authentication() throws InterruptedException {
		cp.myaccountBtn.click();
		lg.loginField.sendKeys(NuiConfigurationProperties.getKeyValue("goodEmail"));
		lg.passwordField.sendKeys(NuiConfigurationProperties.getKeyValue("goodPassword"));
		lg.loginBtn.click();
		hp.verifyAlreadyLogin();
		ap.signoutBtn.click();
		driver.navigate().back();
		Thread.sleep(3000);
		Assert.assertTrue(lg.loginPage.isDisplayed());
	}
	
	
	@AfterClass
	public void after() {
		
		driver.close();
	}


}

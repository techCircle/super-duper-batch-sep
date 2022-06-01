package apPageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import apUtilities.BaseClass;

public class LoginPage {

	WebDriver driver = BaseClass.getDriver();

	// initialize page factory
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}

	//Elements
	@FindBy(xpath = "//*[@id='menu-item-50']")
	public WebElement accountMenu;
	@FindBy(id = "username")
	public WebElement usernameInput;
	@FindBy(xpath = "//*[@id = 'password']")
	public WebElement passwordInput;
	@FindBy(xpath = "//input[@type='submit']")
	public WebElement submitBtn;
	@FindBy(xpath = "//*[@class = 'woocommerce-MyAccount-content']")
	public WebElement greetingMsg;
	@FindBy(xpath = "//*[@class = 'woocommerce-error']/li")
	public WebElement errorMsg;
	@FindBy(xpath = "//*[contains(text(),'Sign out')]")
	public WebElement signOutBtn;
 	@FindBy(xpath = "//*[@id='page-36']/div/div[1]/ul/li")
 	public WebElement Text;
 	@FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']")
 	public WebElement loginText;
 	
 	
 	//method --verify
 	public void verifyLogin() {
 		Assert.assertTrue(greetingMsg.isDisplayed());
 	}

 	public void VerifyLoginError() {
 		Assert.assertTrue(errorMsg.isDisplayed());
 	}
 	public void VerifyLoginMasked() {
		String expectText = BaseClass.driver.findElement(By.xpath("//*[@id='password']")).getAttribute("type");
		Boolean type = expectText.equals("password");
		Assert.assertTrue(type);
 	}
 	public void VerifySignout() {
		String actualURL = BaseClass.driver.getCurrentUrl().toString();
		String expectedURL = "http://practice.automationtesting.in/my-account/";
		Assert.assertEquals(actualURL, expectedURL);
 	}


}

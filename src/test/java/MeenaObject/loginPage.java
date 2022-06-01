package MeenaObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import MeenaUtilities.MeenaDriver;

public class loginPage {

	public loginPage() {

		PageFactory.initElements(MeenaDriver.getDriver(), this);
	}

	@FindBy(xpath = "//*[@id=\"menu-item-50\"]/a")
	public WebElement accountBtn;

	@FindBy(id = "username")
	public WebElement userNameLogin;

	@FindBy(id = "password")
	public WebElement passwordLogin;

	@FindBy(xpath="//*[@class='woocommerce-Button button']")
	public WebElement loginBtn;

	@FindBy(xpath = "//*[@id='page-36']/div/div[1]/div")
	public WebElement signInText;

	@FindBy(xpath = "//*[@id='page-36']/div/div[1]/div/p[1]/a")
	public WebElement signOut;

	@FindBy(xpath = "//*[@class='woocommerce-error']/li")
	public WebElement errorText;

	@FindBy(xpath="//*[@id='customer_login']/div[1]/h2")
	public WebElement loginText;
	
	
	public void setup() {
		
		accountBtn.click();
		
	}
	
	
	public void inputUsername() {
		userNameLogin.sendKeys(MeenaDriver.getProperty("userName"));
		
	}
	
	public void inputPassword() {
		
		passwordLogin.sendKeys(MeenaDriver.getProperty("password"));
	}
	
	public void invalidUsername() {
		
		userNameLogin.sendKeys(MeenaDriver.getProperty("invalidUserName"));
	}
	
	public void invalidPassword() {
	
		passwordLogin.sendKeys(MeenaDriver.getProperty("invalidPassword"));
		
	}
	
	public void caseChangedUsername() {


		// 4) Enter the case changed username in username textbox
		userNameLogin.sendKeys(MeenaDriver.getProperty("caseChangedUserName"));
	}				
		
	public void caseChangedPassword() {
		
		// 5) Enter the case changed password in the password tetxbox
		passwordLogin.sendKeys(MeenaDriver.getProperty("caseChangedPassword"));
	}
			

	public void verifyErrorText() {
	
		Assert.assertTrue(errorText.isDisplayed());

	}
	
	public void verifyLoginText() {
		
		Assert.assertTrue(signInText.isDisplayed());
	}
	
	public void verifyPasswordBoxDisplyBullets() {

		// The password field should display the characters in asterisks or bullets such
		// that the password is not visible on the screen
		// when type in passwordbox it shows bullet need to verify the type if it is
		// password it will passed
		String expectText = passwordLogin.getAttribute("type");
		Boolean type = expectText.equals("password");
		Assert.assertTrue(type);

		System.out.println(type);
		System.out.println("passwordbox it shows bullet");
	
		System.out.println(" User unsuccessfully login to the web page!");
	}

	public void authentication() throws InterruptedException{
		
	
		MeenaDriver.getDriver().navigate().back();
		Thread.sleep(3000);
		
		//verify User shouldn’t be signed in to his account rather a general webpage must be visible
		String verifyText = loginText.getText();
		Boolean signout = verifyText.equals("Login");
		
		Assert.assertTrue(signout);
		
		System.out.println("User is signout");
		
	}

	public void tearDown() {
		MeenaDriver.tearDown();
	}
	
	
	
	
}

package MeenaObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.DataProvider;

import MeenaUtilities.MeenaDriver;

public class registrationPage {
	


	@DataProvider(name = "RegistrationDataProvider")
 	public Object[][] dataProviderMethod() {
 		return new Object[][] { { "userName", "Password" }, // validEmailAndValidPassword
 				{ "invalidUserName", "Password" }, // InvalidEmail
 				{ "", "Password" }, //emptyEmail
 				{ "userName", "" }, // emptyPassword
 				{ "", "" } };// emptyEmailAndPassword
 	}
	
	
	
	public registrationPage() {
		
		PageFactory.initElements(MeenaDriver.getDriver(), this);
	}
	
	@FindBy(xpath="//*[text()='My Account']")
	public WebElement myAccount;
	
	
	@FindBy(xpath="//*[@id='reg_email']")
	public WebElement regEmail;
	
	@FindBy(xpath="//*[@id='reg_password']")
	public WebElement regPassword;
	
	@FindBy(xpath="//*[@name='register']")
	public WebElement submitReg;
	
	@FindBy(xpath = "//*[@id='page-36']/div/div[1]/ul/li")
 	public WebElement text;

 	@FindBy(xpath = "//*[@class='woocommerce-MyAccount-content']")
 	public WebElement loginText;
 	
 	
	public void loginWithEmptyEmailID(String username, String Password) throws InterruptedException {
    //3) Click on My Account Menu
		myAccount.click();

    //4) Enter empty Email Address in Email-Address textbox	
		regEmail.sendKeys(MeenaDriver.getProperty("regEmail"));

    //5) Enter your own password in password textbox
		regPassword.sendKeys(MeenaDriver.getProperty("regPassword"));

    //6) Click on Register button
		Thread.sleep(3000);
    	submitReg.click();


    //7) Registration must fail with a warning message(ie please provide valid email address)

    	String actualText = text.getText();
    	String expectedText =actualText.toString();
    	Assert.assertTrue(actualText.contains(expectedText));
    	
  
}
	public void tearDown() {
		MeenaDriver.tearDown();
	}
	
	
	
	

}

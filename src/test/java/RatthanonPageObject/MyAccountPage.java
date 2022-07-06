package RatthanonPageObject;

import java.util.Random;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import RatthanonUtilities.Constants_ratthanon;
import RatthanonUtilities.BaseClassR;

public class MyAccountPage {
	
	public WebDriver driver = BaseClassR.getDriver();
	public String user;

	public MyAccountPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//input[@id='username']")
	public WebElement inputUserName;
	
	@FindBy(xpath = "//input[@id='password']")
	public WebElement inputPassword;
	
	@FindBy(xpath = "//input[@name='login']")
	public WebElement loginButton;
	
	@FindBy(xpath = "//div[@id='page-36']/div/div/ul")
	public WebElement errorText;
	
	@FindBy(xpath = "//form[@class='login']")
	public WebElement loginForm;
	
	@FindBy(xpath = "//input[@id='reg_email']")
	public WebElement registEmailForm;
	
	@FindBy(xpath = "//input[@id='reg_password']")
	public WebElement registPasswordForm;
	
	@FindBy(xpath = "//input[@name='register']")
	public WebElement RegisterButton;
	
	
	@FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']/p[1]")
	public WebElement RegisterSucessMessage;
	//div[@class='woocommerce-MyAccount-content']/p[1]
	
	//input[@name='register']
	
	public void LoginvalidUser() {
		inputUserName.sendKeys(Constants_ratthanon.username);
		inputPassword.sendKeys(Constants_ratthanon.password);
		loginButton.click();
		
	}
	
	public void RegisterWithValidInfo() throws InterruptedException {
		  String Email = generateRanDomText() + "@gmail.com";
		  //registEmailForm.sendKeys(Constants_ratthanon.Registerusername);
		  registEmailForm.sendKeys(Email);
		  registPasswordForm.sendKeys(Constants_ratthanon.Registerpassword);
		  Thread.sleep(3000);
		  registPasswordForm.sendKeys(Keys.RETURN);
		  Assert.assertTrue(RegisterSucessMessage.getText().contains(user));
		
	}
	
	public void RegisterWithinvalidEmail() throws InterruptedException {
		  registEmailForm.sendKeys(Constants_ratthanon.Invalidusername);
		  registPasswordForm.sendKeys(Constants_ratthanon.password);
		  Thread.sleep(3000);
		  registPasswordForm.sendKeys(Keys.RETURN);
		  //registEmailForm.click();
		  
		
	}
	
	public void RegisterWithEmptyEmail() throws InterruptedException {
		  registEmailForm.sendKeys("");
		  registPasswordForm.sendKeys(Constants_ratthanon.password);
		  Thread.sleep(3000);
		  registPasswordForm.sendKeys(Keys.RETURN);	  
		  //registEmailForm.click();
		
	}
	
	public void RegisterWithEmptyPassword() throws InterruptedException {
		  registEmailForm.sendKeys(Constants_ratthanon.RegisterusernameTest);
		  registPasswordForm.sendKeys("");
		  Thread.sleep(3000);
		  registPasswordForm.sendKeys(Keys.RETURN);	  
		  //registEmailForm.click();
		
	}
	
	public void RegisterWithEmptyEmailPassword() throws InterruptedException {
		  registEmailForm.sendKeys("");
		  registPasswordForm.sendKeys("");
		  Thread.sleep(3000);
		  registPasswordForm.sendKeys(Keys.RETURN);	  
		  //registEmailForm.click();
		
	}

	
	public String generateRanDomText() {
		// create a string of all characters
	    String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

	    // create random string builder
	    StringBuilder sb = new StringBuilder();

	    // create an object of Random class
	    Random random = new Random();

	    // specify length of random string
	    int length = 8;

	    for(int i = 0; i < length; i++) {

	      // generate random index number
	      int index = random.nextInt(alphabet.length());

	      // get character specified by index
	      // from the string
	      char randomChar = alphabet.charAt(index);

	      // append the character to string builder
	      sb.append(randomChar);
	    }

	        user = sb.toString();
	    return user;
	}
	
	
	public String ChageCase(String text) {
		
		  char c = 0;
	      String str = text;
	      
	      // length of string
	      int len = str.length();
	      StringBuffer strBuffer = new StringBuffer(len);
	      for (int i = 0; i < len; i++) {
	         c = str.charAt(i);
	         // title case converted to lower case
	         if (Character.isTitleCase(c)) {
	            c = Character.toLowerCase(c);
	         }
	         // upper case converted to lower case
	         if (Character.isUpperCase(c)) {
	            c = Character.toLowerCase(c);
	         }
	         // lower case converted to upper case
	         if (Character.isLowerCase(c)) {
	            c = Character.toUpperCase(c);
	         }
	         strBuffer.append(c);
	      }
	      
	      return strBuffer.toString();		
		
	}
	

}

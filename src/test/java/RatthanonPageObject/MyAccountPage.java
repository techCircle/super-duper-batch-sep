package RatthanonPageObject;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import RatthanonUtilities.Constants_ratthanon;
import RatthanonUtilities.BaseClass;

public class MyAccountPage {
	
	public WebDriver driver = BaseClass.getDriver();

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
	
	//input[@name='register']
	
	public void LoginvalidUser() {
		inputUserName.sendKeys(Constants_ratthanon.username);
		inputPassword.sendKeys(Constants_ratthanon.password);
		loginButton.click();
		
	}
	
	public void RegisterWithValidInfo() throws InterruptedException {
		  registEmailForm.sendKeys(Constants_ratthanon.Registerusername);
		  registPasswordForm.sendKeys(Constants_ratthanon.Registerpassword);
		  Thread.sleep(3000);
		  registPasswordForm.sendKeys(Keys.RETURN);
		  //registEmailForm.click();
		
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

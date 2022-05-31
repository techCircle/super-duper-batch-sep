package KanokwanObject;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import KanokwanUtilities.KanokwanBaseClass;



public class myAccountLonginPage {
	 
	public myAccountLonginPage() {
		
		PageFactory.initElements(KanokwanBaseClass.getDriver(), this);
		
	}
	
	//MY ACCOUNT - LOGIN
	
	//Click on My Account Menu
	@FindBy(id = "menu-item-50")
	public WebElement myAccount;
	
	//Enter user name
	@FindBy(id = "username")
	public WebElement userName;
	
	//Enter password
	@FindBy(id = "password")
	public WebElement password;
	
	//Click on login button
	@FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")
	public WebElement loginButton;

	@FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/div/p[2]")
	public WebElement verifyLoginCompletedText;
	
	
	//login error
	@FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/ul/li/strong[1]")
	public WebElement verifyLoginErrorTex;
	
	//sign out button
	@FindBy(xpath = "//*[text()='Sign out']")
	public WebElement signOutButton;
	
	//verify text
	@FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/h2")
	public WebElement loginText;

	
	public void myAccount() {
		
		myAccount.click();
	}
	
	public void valid_userName_login() {
        userName.sendKeys(KanokwanBaseClass.getProperty("validUserName"));
        
	}
	public void valid_password_login() {
        password.sendKeys(KanokwanBaseClass.getProperty("validPassword"));
      
	}
	
	public void inValid_userName_login() {
		userName.sendKeys(KanokwanBaseClass.getProperty("inValidUserName"));
		
	}
	public void inValid_password_login() {
	   password.sendKeys(KanokwanBaseClass.getProperty("inValidPassword"));
       
	}
	
	public void emptyUserName_login() {
		userName.sendKeys(KanokwanBaseClass.getProperty("emptyUserName"));
       
	}
	public void emptyPassword_login() {
		password.sendKeys(KanokwanBaseClass.getProperty("emptyPassword"));
        
	}

	
	public void changeUserName_login() {
		userName.sendKeys(KanokwanBaseClass.getProperty("changeUserName"));
        
	}
	
	public void changePassword_login() {
		password.sendKeys(KanokwanBaseClass.getProperty("changePassword"));

	}
	
	public void loginButton() {
		
		loginButton.click();
	}
	
	public void signOutButton() {
		
		signOutButton.click();
	}
	
	public void verifyLoginText() {
		
	}
	
	 //method to verify
	
    public void verifyLogin() {
        Assert.assertTrue(verifyLoginCompletedText.isDisplayed());
    }

    public void verifyLoginError() {
        Assert.assertTrue(verifyLoginErrorTex.isDisplayed());
    }
    
    public void verifyPasswordMasked() {
       String expectText = KanokwanBaseClass.driver.findElement(By.xpath("//*[@id='password']")).getAttribute("type");
       Boolean type = expectText.equals("password");
       Assert.assertTrue(type);
       
    }
    
    public void verifySignout() {
       String actualURL = KanokwanBaseClass.driver.getCurrentUrl().toString();
       String expectedURL = "http://practice.automationtesting.in/my-account/";
       Assert.assertEquals(actualURL, expectedURL);
    }
	
    public void authenticationVerify(){
		
    	KanokwanBaseClass.getDriver().navigate().back();
    	String actualText = loginText.getText();
 		String expectedText = actualText.toString();
 		Assert.assertTrue(actualText.contains(expectedText));
 		System.out.println("ActualText : " + actualText);
 		System.out.println("ExpectedText : " + expectedText);
		
    }
	
}
	

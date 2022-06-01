package kanokwanPageObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import kanokwanUtilities.KanokwanBaseClass;


public class myAccountRegistrationPage {

	public myAccountRegistrationPage() {
        PageFactory.initElements(KanokwanBaseClass.getDriver(), this);
    }

	//my account menu
    @FindBy(xpath = "//*[@id='menu-item-50']")
    public WebElement myAccountMenu;
    
    //Enter register email address
    @FindBy(id = "reg_email")
    public WebElement username;
    
    //Enter register password
    @FindBy(id = "reg_password")
    public WebElement password;
    
    //click register button
    @FindBy(xpath = "//input[@name='register']")
    public WebElement registerButton;
    
    @FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/div/p[2]")
    public WebElement verifyRegisterText;
    
    @FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/ul/li/strong")
    public WebElement verifyErrorText;
    
    @FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")
    public WebElement signOutButton;
    
    public void myAccountMenu() {
    	myAccountMenu.click();
    }
   
    public void valid_userName_register() {
        username.sendKeys(KanokwanBaseClass.getProperty("validRegisterUserName"));
        
	}
	public void valid_password_register() {
        password.sendKeys(KanokwanBaseClass.getProperty("validRegisterPassword"));
      
	}
	
	public void inValid_userName_register() {
		username.sendKeys(KanokwanBaseClass.getProperty("inValidRegisterUserName"));
		
	}
	public void inValid_password_register() {
	   password.sendKeys(KanokwanBaseClass.getProperty("inValidRegisterPassword"));
       
	}
	
	public void emptyUserName_register() {
		username.sendKeys(KanokwanBaseClass.getProperty("emptyRegisterUserName"));
       
	}
	public void emptyPassword_register() {
		password.sendKeys(KanokwanBaseClass.getProperty("emptyRegisterPassword"));
        
	}
	public void registerButton() {
		registerButton.click();
		
	}

	public void signOutButton() {
		signOutButton.click();
		
	}
    public void verifyRegisterText() {
    	Assert.assertTrue(verifyRegisterText.isDisplayed());
    }
    
    public void verifyErrorText() {
        Assert.assertTrue(verifyErrorText.isDisplayed());
    }
    
    public void verifySignout() {
        String actualURL = KanokwanBaseClass.driver.getCurrentUrl().toString();
        String expectedURL = "http://practice.automationtesting.in/my-account/";
        Assert.assertEquals(actualURL, expectedURL);
    
    }
    
}


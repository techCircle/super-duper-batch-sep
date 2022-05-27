package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.BaseClass;
import Utilities.Driver;

public class CheckoutPage {
	


    //initialize page factory
    public CheckoutPage() {
        PageFactory.initElements(BaseClass.getDriver(), this); // this = this object
    }
    
    @FindBy(id = "checkout")
    public WebElement checkoutBtn;
    
    @FindBy(id = "checkout")
    public WebElement nick;
    
    @FindBy(id ="first-name")
    public WebElement firstNameInput;
    
    @FindBy(id ="last-name")
    public WebElement lastNameInput;
    
    @FindBy (id ="postal-code")
    public WebElement postcode;
    
    @FindBy (id ="continue")
    public WebElement con;
    
    @FindBy (id ="finish")
    public WebElement fn;
    
    @FindBy(xpath ="//h2[@class='complete-header']")
    public WebElement txt;
    
    public void chkout() {
        checkoutBtn.click();
        firstNameInput.sendKeys("Pooh");
        lastNameInput.sendKeys("Bear");
        postcode.sendKeys("12345");
        con.click();
        fn.click();
        
    }
    
    
    public void verifyAlltheConfirmation() {
    	
    	Assert.assertTrue(txt.isDisplayed());  
    }

}

package apPageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import apUtilities.BaseClass;


public class RegisterPage {
	WebDriver driver = BaseClass.getDriver();

	public RegisterPage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='menu-item-50']")
	public WebElement accountMenu;
	@FindBy(id = "reg_email")
	public WebElement usernameInput;
	@FindBy(id = "reg_password")
	public WebElement passwordInput;
	@FindBy(xpath = "//input[@name='register']")
	public WebElement registerBtn;
	@FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/ul/li/strong")
	public WebElement errorMsg;

	public void verify() {
		Assert.assertTrue(errorMsg.isDisplayed());
	}
}

package Nui51TestCases.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import NuiUtilities.Driver;

public class EditAccountPageObject {
	
	WebDriver driver = Driver.getDriver();
	WebDriverWait wait;

	public EditAccountPageObject() {
		PageFactory.initElements(driver, this); 
		wait = new WebDriverWait(driver, 30);
	}
	
	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/div/form/fieldset/p[2]/label")
	public WebElement EditPwdTxt;
	
	
}

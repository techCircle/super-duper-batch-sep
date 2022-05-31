package Nui51TestCases.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NuiUtilities.Driver;

public class CommonPageObject {
	
	WebDriver driver = Driver.getDriver();

	public CommonPageObject() {
		PageFactory.initElements(driver, this); 
	}
	
	
	@FindBy (xpath = "//li[@id='menu-item-50']/a") 
	public WebElement myaccountBtn;
	
	@FindBy (xpath = "//a[contains(text(),\"Shop\")]")
	public WebElement clickShop;
	
	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/div/p[1]/a")
	public WebElement logout;
	
	@FindBy (xpath = "//*[@id='wpmenucartli']/a")
	public WebElement cartLink;
	
	@FindBy (xpath = "//*[@id='wpmenucartli']/a/span[1]")
	public WebElement itemLink;
	
	
}

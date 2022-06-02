package Nui51TestCases.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import NuiUtilities.Driver;

public class OrdersPageObject {
	
	WebDriver driver = Driver.getDriver();
	WebDriverWait wait;

	public OrdersPageObject() {
		PageFactory.initElements(driver, this); 
		wait = new WebDriverWait(driver, 30);
	}
	
	@FindBy (xpath = "//td[@class='order-number']")
	public WebElement orderTxt;
	
	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/div/table/tbody/tr/td[5]/a")
	public WebElement viewBtn;
	
	
}

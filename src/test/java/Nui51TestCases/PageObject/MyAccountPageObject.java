package Nui51TestCases.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NuiUtilities.Driver;

public class MyAccountPageObject {
	
	WebDriver driver = Driver.getDriver();

	public MyAccountPageObject() {
		PageFactory.initElements(driver, this); 
	}
	

	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/div/p[1]/a")
	public WebElement signoutBtn;
	
	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/nav/ul/li[1]/a")
	public WebElement dashboardBtn;
	
	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/div/p[2]")
	public WebElement dashboardMsg;
	
	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/nav/ul/li[2]/a")
	public WebElement orderBtn;
	
	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/nav/ul/li[4]/a")
	public WebElement addressBtn;
	
	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/div[1]")
	public WebElement addChangeMsg;
	

	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/nav/ul/li[5]/a")
	public WebElement myAccBtn;
	

}

package victor.automationTesting.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import victor.utilities.Victor_BaseClass;

public class MyAccountLogInPage {
	public MyAccountLogInPage () {
		PageFactory.initElements(Victor_BaseClass.getDriver(), this);
		}
	
	@FindBy (xpath="//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[6]/a")
	public WebElement logOut;
	
	
	@FindBy (xpath="//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[1]/a")
	public WebElement dashboard;
	
	@FindBy (xpath="//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[2]/a")
	public WebElement orders;
	
	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/div/p[2]")
	public WebElement dashboardsite;
	
	@FindBy (xpath= "//*[contains(@class,'button view')]")
	public WebElement viewButton;
	
	@FindBy (xpath= "//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[4]/a")
	public WebElement addresses;
	
	@FindBy (xpath= "//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[5]/a")
	public WebElement accountDetails;
}

package RatthanonPageObject;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RatthanonUtilities.BaseClass;

public class AccoutDetail {
	
	WebDriver driver = BaseClass.getDriver();
	
	public AccoutDetail() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']/p/a")
	public WebElement signOutlink;
	
	@FindBy(xpath = "//nav[@class='woocommerce-MyAccount-navigation']/ul/li[1]")
	public WebElement dashboarcdlink;
	
	@FindBy(xpath = "//nav[@class='woocommerce-MyAccount-navigation']")
	public WebElement dashboarNavigate;
	
	@FindBy(xpath = "//nav[@class='woocommerce-MyAccount-navigation']/ul/li[2]/a")
	public WebElement orderlink;
	
	

}

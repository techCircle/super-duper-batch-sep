package Nui51TestCases.PageObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import NuiUtilities.Driver;
import NuiUtilities.NuiConfigurationProperties;

public class EditAddressShippingPageObject {
	

	WebDriver driver = Driver.getDriver();
	WebDriverWait wait;

	public EditAddressShippingPageObject() {
		PageFactory.initElements(driver, this); 
		wait = new WebDriverWait(driver, 30);
	}
	
	@FindBy (xpath = "//*[@id='shipping_first_name']")
	public WebElement firstNameField;
	
	@FindBy (xpath = "//*[@id='shipping_last_name']")
	public WebElement lastNameField;
	
	@FindBy (xpath = "//*[@id='s2id_shipping_country']/a/span[2]/b")
	public WebElement dropdownCountryBtn;
	
	@FindBy (xpath = "//*[@id='s2id_autogen1_search']")
	public WebElement countryField;
	
	@FindBy (xpath = "//*[@id='shipping_address_1']")
	public WebElement addBx;
	
	@FindBy (xpath = "//*[@id='shipping_city']")
	public WebElement cityBx;
	
	@FindBy (xpath = "//*[@id='s2id_shipping_state']/a/span[2]/b")
	public WebElement dropdownState;
	
	@FindBy (xpath = "//*[@id='s2id_autogen2_search']")
	public WebElement stateBx;
	
	@FindBy (xpath = "//*[@id='shipping_postcode']")
	public WebElement zipcodeBx;
	
	@FindBy (xpath = "//*[@id='page-36']/div/div[1]/div/form/p[10]/input[1]")
	public WebElement saveAddBtn;
	
	@FindBy (xpath = "//ul/li/div[ @id='select2-result-label-460']")
	public WebElement india;
	
	@FindBy (xpath = "//*[@id='s2id_shipping_state']/a/span[2]/b")
	public WebElement ddStateIndia;
	
	
	public void fillFormEditShippingAdd() throws InterruptedException {
		firstNameField.clear();
		firstNameField.sendKeys(NuiConfigurationProperties.getKeyValue("name"));
		lastNameField.clear();
		lastNameField.sendKeys(NuiConfigurationProperties.getKeyValue("lastName"));
		dropdownCountryBtn.click();
		countryField.sendKeys(NuiConfigurationProperties.getKeyValue("country"));
		Thread.sleep(2000);
		countryField.sendKeys(Keys.RETURN);
		addBx.clear();
		addBx.sendKeys(NuiConfigurationProperties.getKeyValue("address"));
		cityBx.clear();
		cityBx.sendKeys(NuiConfigurationProperties.getKeyValue("city"));
		dropdownState.click();
		stateBx.sendKeys(NuiConfigurationProperties.getKeyValue("state"));
		stateBx.sendKeys(Keys.RETURN);
		zipcodeBx.clear();
		zipcodeBx.sendKeys(NuiConfigurationProperties.getKeyValue("zipcode"));
		saveAddBtn.click();
	}
	
	
	public void fillFormEditShippingIndiaAdd() throws InterruptedException {
		dropdownCountryBtn.click();
		countryField.sendKeys(NuiConfigurationProperties.getKeyValue("india"));
		Thread.sleep(2000);
		india.click();
		ddStateIndia.click();
		Thread.sleep(2000);
		stateBx.sendKeys(NuiConfigurationProperties.getKeyValue("indiaState"));
		stateBx.sendKeys(Keys.RETURN);
		saveAddBtn.click();
	}
	
}

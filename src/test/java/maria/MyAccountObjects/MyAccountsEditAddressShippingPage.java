package maria.MyAccountObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.ConfigurationProperties;
import Utilities.Driver;

public class MyAccountsEditAddressShippingPage {

	public MyAccountsEditAddressShippingPage() {
		PageFactory.initElements(Driver.getDriver(), this);

	}


//changes to push
	@FindBy(xpath="//input[@id='shipping_first_name']")
	WebElement firstNameShipping;

	@FindBy(xpath="//input[@id='shipping_last_name']")
	WebElement lastNameShipping;

	@FindBy(id="shipping_company")
	WebElement shippingCompany;

	@FindBy(xpath="//*[@id='s2id_shipping_country']/a/span[2]/b")
	WebElement countryEntry;
	/*driver.findElement(By.xpath("//*[@id=\"s2id_shipping_country\"]/a/span[2]/b")).click();
	driver.findElement(By.xpath("//*[@id=\"s2id_autogen1_search\"]")).sendKeys("United States (US)");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//*[@id=\"select2-result-label-402\"]/span")).click();*/
	@FindBy(xpath="//*[@id='s2id_autogen1_search']")
	WebElement countryEntrylist;

	@FindBy(xpath="//*[@id='select2-result-label-402']/span")
	WebElement countryClick;

	@FindBy(xpath="//*[@id='select2-chosen-1']")
	WebElement selectCountry;

	@FindBy(xpath="//input[@id='shipping_address_1']")
	WebElement streetaddress;

	@FindBy(id="shipping_city")
	WebElement shippingCity;
	//driver.findElement(By.xpath("//*[@id=\"s2id_shipping_state\"]/a/span[2]/b")).click();
//	WebElement box = driver.findElement(By.xpath("//*[@id=\"s2id_autogen2_search\"]"));
//	box.sendKeys("California");
//	box.sendKeys(Keys.RETURN);

	@FindBy(xpath="//*[@id='s2id_shipping_state']/a/span[2]/b")
	WebElement state;

	@FindBy(xpath="//*[@id='s2id_autogen2_search']")
	WebElement stateBox;
	
	@FindBy(id="shipping_postcode")
	WebElement zipCode;

	@FindBy(name="save_address")
	WebElement saveAddressBtn;
	@FindBy(xpath="//*[text()='Address changed successfully.']")
	WebElement changeAddressSuccess;


	public void editShippingaddress() throws InterruptedException {
		firstNameShipping.clear();
		firstNameShipping.sendKeys(ConfigurationProperties.getProperty("firstNameShipping"));
		lastNameShipping.clear();
		lastNameShipping.sendKeys(ConfigurationProperties.getProperty("lastNameShipping"));
		
		shippingCompany.clear();
		shippingCompany.sendKeys(ConfigurationProperties.getProperty("shippingCompany"));

		countryEntry.click();
		countryEntrylist.sendKeys(ConfigurationProperties.getProperty("countryName"));
		Thread.sleep(2000);
		countryClick.click();
		streetaddress.clear();
		streetaddress.sendKeys(ConfigurationProperties.getProperty("streetaddress"));
		
		shippingCity.clear();
		shippingCity.sendKeys(ConfigurationProperties.getProperty("shippingCity"));
		
		state.click();
		stateBox.sendKeys(ConfigurationProperties.getProperty("state"));
		stateBox.sendKeys(Keys.RETURN);
		zipCode.clear();
		zipCode.sendKeys(ConfigurationProperties.getProperty("zipCode"));
		
		saveAddressBtn.click();
		Thread.sleep(3000);
		Assert.assertTrue(changeAddressSuccess.isDisplayed());
		System.out.println(changeAddressSuccess.getText());



	}




}

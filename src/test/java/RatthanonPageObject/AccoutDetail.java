package RatthanonPageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import RatthanonUtilities.BaseClassR;
import RatthanonUtilities.Constants_ratthanon;

public class AccoutDetail {
	
WebDriver driver = BaseClassR.getDriver();
	
	public AccoutDetail() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']/p/a")
	public WebElement signOutlink;
	
	@FindBy(xpath = "//nav[@class='woocommerce-MyAccount-navigation']/ul/li[1]/a")
	public WebElement dashboarcdlink;
	
	@FindBy(xpath = "//nav[@class='woocommerce-MyAccount-navigation']")
	public WebElement dashboarNavigate;
	
	@FindBy(xpath = "//nav[@class='woocommerce-MyAccount-navigation']/ul/li[2]/a")
	public WebElement orderlink;
	
	@FindBy(xpath = "//td[@class='order-number']")
	public WebElement orderNumber;
	
	@FindBy(xpath = "//td[@class='order-status']")
	public WebElement orderStatus;
	
	@FindBy(xpath = "//td[@class='order-total']")
	public WebElement orderTotal;
	
	@FindBy(xpath = "//nav[@class='woocommerce-MyAccount-navigation']/ul/li[6]/a")
	public WebElement logoutlink;
	
	@FindBy(xpath = "//td[@class='order-actions']/a")
	public WebElement viewButton;
	
	@FindBy(xpath = "//td[@class='product-name']/a")
	public WebElement productName;
	
	@FindBy(xpath = "//table[@class='shop_table customer_details']/tbody/tr[1]/td")
	public WebElement Email;
	
	@FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']/address")
	public WebElement address;
	
	@FindBy(xpath = "//mark[@class='order-number']")
	public WebElement ordernumerText;
	
	@FindBy(xpath = "//mark[@class='order-date']")
	public WebElement orderDateText;
	
	@FindBy(xpath = "//mark[@class='order-status']")
	public WebElement orderStatusText;
	
	@FindBy(xpath = "//nav[@class='woocommerce-MyAccount-navigation']/ul/li[4]/a")
	public WebElement addresslink;
	
	@FindBy(xpath = "//div[@class='u-column1 col-1 woocommerce-Address']/address")
	public WebElement billingAddress;
	
	@FindBy(xpath = "//div[@class='u-column2 col-2 woocommerce-Address']/address")
	public WebElement shippingAddress;
	
	@FindBy(xpath = "//div[@class='u-columns woocommerce-Addresses col2-set addresses']/div[2]/header/a")
	public WebElement ShippingeditButton;
	
	@FindBy(xpath = "//input[@id='shipping_postcode']")
	public WebElement inputZipCode;
	
	@FindBy(xpath = "//input[@name='save_address']")
	public WebElement buttonSaveAddress;
	
	@FindBy(xpath = "//div[@class='woocommerce']/div[1]")
	public WebElement ChangeAddressPassed;
	
	@FindBy(xpath = "//nav[@class='woocommerce-MyAccount-navigation']/ul/li[5]/a")
	public WebElement AccoutDetailsLink;
	
	@FindBy(xpath = "//input[@id='password_current']")
	public WebElement InputCurentPassword;
	
	
	@FindBy(xpath = "//input[@id='password_1']")
	public WebElement InputNewPassword;	

	
	@FindBy(xpath = "//input[@id='password_2']")
	public WebElement InputNewPasswordConfirm;
	
	@FindBy(xpath = "//ul[@class='woocommerce-error']/li[1]")
	public WebElement ErrorPasswordFirst;
	
	@FindBy(xpath = "//ul[@class='woocommerce-error']/li[2]")
	public WebElement ErrorPasswordSecond;
	
	@FindBy(xpath = "//input[@name='save_account_details']")
	public WebElement SaveChangeButton;
	
	@FindBy(xpath = "//input[@id='account_first_name']")
	public WebElement inputAccountFName;
	
	@FindBy(xpath = "//input[@id='account_last_name']")
	public WebElement inputAccountLName;
	
	@FindBy(xpath = "//div[@class='woocommerce-message']")
	public WebElement ChangeAccoutMessages;
	
	@FindBy(xpath = "//div[@id='s2id_shipping_country']/a")
	public WebElement SelectCountry;
	
	@FindBy(xpath = "//input[@id='s2id_autogen1_search']")
	public WebElement InputCountry;
	
	@FindBy(xpath = "//input[@id='s2id_autogen2_search']")
	public WebElement InputState2;

		
	@FindBy(xpath = "//input[@id='shipping_city']")
	public WebElement InputCity;
	
	@FindBy(xpath = "//div[@id='s2id_shipping_state']")
	public WebElement InputState;
	
	
	@FindBy(xpath = "//input[@id='shipping_postcode']")
	public WebElement InputpostCode;
	
	@FindBy(xpath = "//a[@class='wpmenucart-contents']/span[2]")
	public WebElement cartLink;
	
	//a[@class='wpmenucart-contents']/span[2]
		
	
	public void verifyChangePassWord() {
		Assert.assertTrue(InputCurentPassword.isDisplayed() && InputNewPassword.isDisplayed() && InputNewPasswordConfirm.isDisplayed());
		inputAccountFName.sendKeys(Constants_ratthanon.checkOutFname);
		inputAccountLName.sendKeys(Constants_ratthanon.checkoutLastName);
		SaveChangeButton.click();
		Assert.assertEquals(ChangeAccoutMessages.getText(), Constants_ratthanon.MessageChangeAccount);
        
	}
	
	public void ChangeAddress(String country) throws InterruptedException{
		
		String Country = country;
		String City = Constants_ratthanon.city;
		String State= Constants_ratthanon.state;
		String Zipcode= Constants_ratthanon.zipcode;
		
	    addresslink.click();
	    ShippingeditButton.click();
	    SelectCountry.click();
		Thread.sleep(2000);
		
		if (country.equals("India")) {
			City = Constants_ratthanon.cityIndia;
			State= Constants_ratthanon.stateIndia;
			Zipcode= Constants_ratthanon.zipcodeIndia;

			List<WebElement> ct = driver.findElements(By.xpath("//ul[@id='select2-results-1']/li"));
			for (int i = 0; i < ct.size(); i++) {
				if (ct.get(i).getText().equals("India")) {
					ct.get(i).click();
					break;
				}
			}
		}else {
			InputCountry.sendKeys(Constants_ratthanon.usaname + "\n");
			
		}
				
		
		InputCity.clear();
		InputCity.sendKeys(City);
		InputState.click();
		InputState2.sendKeys(State + "\n");
		InputpostCode.clear();
		InputpostCode.sendKeys(Zipcode);
		buttonSaveAddress.click();
			    	
	}
	
	

}

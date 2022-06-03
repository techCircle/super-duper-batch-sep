package Kanlaya_51TestCasePages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Kanlaya_51TestCaseUtilities.Base;

public class MyAccountPage {
	
	JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();


	public MyAccountPage() {
		
		PageFactory.initElements(Base.getDriver(), this);
	}
	
	// MY ACCOUNT

	
	@FindBy(xpath = "//*[@class = 'woocommerce-MyAccount-content']/h2")
	public WebElement oderDetails;

	@FindBy(xpath = "//*[@class = 'woocommerce-MyAccount-content']/header/h2")
	public WebElement customerDetails;

	@FindBy(xpath = "//header[@class = 'title']/h3")
	public WebElement BillingAddressDetails;
	
	@FindBy(xpath = "//*[@class = 'woocommerce-MyAccount-content']/p")
	public WebElement orderDateAndSatatus;

	@FindBy(xpath = "//*[@class = 'woocommerce-MyAccount-content']/p/mark[1]")
	public WebElement orderNumber;

	@FindBy(xpath = "//*[@class = 'woocommerce-MyAccount-content']/p/mark[2]")
	public WebElement orderDate;

	@FindBy(xpath = "//*[@class = 'woocommerce-MyAccount-content']/p/mark[3]")
	public WebElement orderStatus;
	
//	@FindBy(xpath = "//*[@class = 'order']/td[5]/a")
//	public WebElement viewButton;
	@FindBy(xpath = "//*[@class ='order'][1]/td[5]")
	public WebElement viewButton;
	
	
	@FindBy(xpath = "//*[@class = 'woocommerce-Message woocommerce-Message--info woocommerce-info']/a")
	public WebElement goShopButton;

	@FindBy(xpath = "//*[@class = 'woocommerce-MyAccount-navigation']/ul/li[1]/a")
	public WebElement dashboardButton;

	@FindBy(xpath = "//*[@class = 'woocommerce-MyAccount-navigation']/ul/li[2]/a")
	public WebElement odersButton;

	@FindBy(xpath = "//*[@class = 'woocommerce-MyAccount-navigation']/ul/li[3]/a")
	public WebElement downloadsButton;

	@FindBy(xpath = "//*[@class = 'woocommerce-MyAccount-navigation']/ul/li[4]/a")
	public WebElement addressButton;

	@FindBy(xpath = "//*[@class = 'woocommerce-MyAccount-navigation']/ul/li[5]/a")
	public WebElement accountDetailsButton;

	@FindBy(xpath = "//*[text() = 'Logout']")
	public WebElement logoutButton;

	@FindBy(xpath = "//*[text() = 'Sign out']")
	public WebElement signoutLink;

	@FindBy(xpath = "//*[@class= 'woocommerce-MyAccount-content']/p[2]/a[1]")
	public WebElement recentOdersLink;
	
	@FindBy(xpath = "//*[@class= 'woocommerce-MyAccount-content']/p[2]/a[2]")
	public WebElement shippingAndBillingAndAddressLink;
	
	@FindBy(xpath = "//*[@class= 'woocommerce-MyAccount-content']/p[2]/a[3]")
	public WebElement editPasswordAndAccountDetailsLink;

	@FindBy(xpath = "//*[text() = 'Login']")
	public WebElement loginText;
	
	@FindBy(xpath = "//*[@class = 'woocommerce-MyAccount-content']/div/div[1]/header/h3")
	public WebElement billingAddressText;

	@FindBy(xpath = "//*[@class = 'woocommerce-MyAccount-content']/div/div[2]/header/h3")
	public WebElement shippingAddressText;
	
	@FindBy(xpath = "//*[@id = 'password_current']")
	public WebElement currentPasswordField;

	@FindBy(xpath = "//*[@id = 'password_1']")
	public WebElement newPasswordField1;

	@FindBy(xpath = "//*[@id = 'password_2']")
	public WebElement newPasswordField2;

	@FindBy(xpath = "//*[@name = 'save_account_details']")
	public WebElement saveAccountDetailsButton;
	

	@FindBy(xpath = "//*[@id = 'shipping_first_name']")
	public WebElement shippingNameField;

	@FindBy(xpath = "//*[@id = 'shipping_last_name']")
	public WebElement shippingLastNameField;

	@FindBy(xpath = "//input [@id = 'shipping_company']")
	public WebElement shippingCompanyField;

	@FindBy(xpath = "//*[@id = 'shipping_country_field']/div/a/span[2]/b")
	public WebElement shippingCountryDropDown;
	
	@FindBy(xpath = "//*[@id = 's2id_autogen1_search']")
	public WebElement shippingCountrySearchBox;

	@FindBy(xpath = "//*[@id = 'shipping_address_1']")
	public WebElement shippingAddressField1;

	@FindBy(xpath = "//*[@id = 'shipping_address_2']")
	public WebElement shippingAddressField2;

	@FindBy(xpath = "//*[@id = 'shipping_city']")
	public WebElement shippingCityField;

	@FindBy(xpath = "//*[@id = 's2id_shipping_state']/a/span[2]")
	public WebElement shippingStateDropDown;

	@FindBy(xpath = "//*[@id = 's2id_autogen2_search']")
	public WebElement shippingStateSearchBox;

	@FindBy(xpath = "//*[@id = 'shipping_postcode']")
	public WebElement shippingZipCodeBox;

	@FindBy(xpath = "//*[@method = 'post']/p[10]/input[@type = 'submit']")
	public WebElement shippingSaveAddressButton;

	@FindBy(xpath = "//*[@class = 'u-columns woocommerce-Addresses col2-set addresses']/div[1]/header/a")
	public WebElement billingEditButton;

	@FindBy(xpath = "//*[@class = 'woocommerce-MyAccount-content']/div/div[2]/header/a")
	public WebElement shippingEditButton;
	

	@FindBy(xpath = "//*[@id = 'billing_first_name']")
	public WebElement billingNameField;

	@FindBy(xpath = "//*[@id = 'billing_last_name']")
	public WebElement billingLastNameField;

	@FindBy(xpath = "//*[@id = 'billing_company']")
	public WebElement billingCompanyField;

	@FindBy(xpath = "//*[@id = 'billing_email']")
	public WebElement billingEmailField;

	@FindBy(xpath = "//*[@id = 'billing_phone']")
	public WebElement billingPhoneField;

	@FindBy(xpath = "//*[@id = 'billing_country_field']")
	public WebElement billingCountryField;

	@FindBy(xpath = "//*[@id = 'billing_country_field']/select")
	public WebElement billingCountrySelect;

	@FindBy(xpath = "//*[@id = 's2id_autogen1_search']")
	public WebElement billingCountrySearchBox;

	@FindBy(xpath = "//*[@id = 'billing_address_1']")
	public WebElement billingAddressField1;

	@FindBy(xpath = "//*[@id = 'billing_address_2']")
	public WebElement billingAddressField2;

	@FindBy(xpath = "//*[@id = 'billing_city']")
	public WebElement billingCityField;

	@FindBy(xpath = "//*[@id = 'billing_state_field']")
	public WebElement billingStateField;

	@FindBy(xpath = "//*[@id = 'billing_state_field']/select")
	public WebElement billingStateSelect;

	@FindBy(xpath = "//*[@id = 's2id_autogen1_search']")
	public WebElement billingStateSearchBox;

	@FindBy(xpath = "//*[@id = 'billing_postcode']")
	public WebElement billingZipCodeBox;

	@FindBy(xpath = "//input[@name = 'save_address']")
	public WebElement billingSaveAddressButton;
	
	@FindBy(xpath = "//*[@class ='woocommerce']/div[1]")
	public WebElement addressChangedMsg;
	
	
	public void verifyNoOrder() {
		String noOrderText = goShopButton.getText();
		String expectedNoOrderText = Base.getProperty("goShopText");
		Assert.assertEquals(noOrderText, expectedNoOrderText);
	}

	public void verifyMyAccountEditShippingAddressFunctionallity() throws InterruptedException {
		shippingNameField.clear();
		shippingNameField.sendKeys(Base.getProperty("shippingName"));
		shippingLastNameField.clear();
		shippingLastNameField.sendKeys(Base.getProperty("shippingLastName"));
		shippingCompanyField.clear();
		shippingCompanyField.sendKeys(Base.getProperty("companyName"));
		shippingCountryDropDown.click();
		shippingCountrySearchBox.sendKeys(Base.getProperty("shippingCountry"));
		Thread.sleep(2000);
		shippingCountrySearchBox.sendKeys(Keys.RETURN);
		shippingAddressField1.clear();
		shippingAddressField1.sendKeys(Base.getProperty("address1"));
		shippingAddressField2.clear();
		shippingAddressField2.sendKeys(Base.getProperty("address2"));
		shippingCityField.clear();
		shippingCityField.sendKeys(Base.getProperty("city"));
		shippingStateDropDown.click();
		shippingStateSearchBox.sendKeys(Base.getProperty("shippingStates"));
		Thread.sleep(2000);
		shippingStateSearchBox.sendKeys(Keys.RETURN);
		shippingZipCodeBox.clear();
		shippingZipCodeBox.sendKeys(Base.getProperty("zipCode"));
		shippingSaveAddressButton.click();
	}
	
/*	
	public void verifyMyAccountEditBillingAddressFunctionallity() {
		billingNameField.clear();
		billingNameField.sendKeys(Base.getProperty("billingName"));
		billingLastNameField.clear();
		billingLastNameField.sendKeys(Base.getProperty("billingLastName"));
		billingCompanyField.sendKeys(Base.getProperty("companyName"));
		billingEmailField.sendKeys(Base.getProperty("email"));
		billingPhoneField.sendKeys(Base.getProperty("phone"));
		billingCountryField.click();
		Select select = new Select(billingCountrySelect);
		select.selectByValue("US");
		billingAddressField1.sendKeys(Base.getProperty("address1"));
		billingAddressField2.sendKeys(Base.getProperty("address2"));
		billingCityField.sendKeys(Base.getProperty("city"));
		select = new Select(billingStateSelect);
		select.selectByValue("VA");
		billingZipCodeBox.sendKeys(Base.getProperty("zipCode"));
		billingSaveAddressButton.click();
	}
	*/		
		public void verifyShippingAddressChangedSuccess() {	
		String actualAddressChangedSucess = addressChangedMsg.getText();
		String expectedShippingAddressChangedMsg = Base.getProperty("expectedShippingAddressChangedSucessMsg");
		Assert.assertTrue(actualAddressChangedSucess.contains(expectedShippingAddressChangedMsg));

	}

	public void verifyBillingAddressText() {
		String actualBillingAddressText = billingAddressText.getText();
		String expectedBillingAddressText = Base.getProperty("expectedBillingAddressText");
		Assert.assertTrue(actualBillingAddressText.contains(expectedBillingAddressText));
	}

	public void verifyShippingAddessText() {
		String actualShippingAddressText = shippingAddressText.getText();
		String expectedShippingAddressText = Base.getProperty("expectedShippingAddressText");
		Assert.assertTrue(actualShippingAddressText.contains(expectedShippingAddressText));

	}

	public void accountDetails() {
		currentPasswordField.sendKeys(Base.getProperty("password"));
		newPasswordField1.sendKeys("HelloNewLaya");
		newPasswordField2.sendKeys("hellonewlaya");
		saveAccountDetailsButton.click();
		
	}

	public void verifyOrderDetails() {
		String actualOrderDetailsText = oderDetails.getText();
		String expectedOrderDetailsText = Base.getProperty("expectedOrderDetailsText");
		Assert.assertEquals(actualOrderDetailsText, expectedOrderDetailsText);
	}

	public void verifyCustomerDetails() {
		js.executeScript("window.scrollBy(0,500)", "");
		String actualCustomerDetailsText = customerDetails.getText();
		String expectedCustomerDetailsText = Base.getProperty("expectedCustomerDetailsText");
		Assert.assertEquals(actualCustomerDetailsText, expectedCustomerDetailsText);
	}

	public void verifyBillingAdrressDetails() {
		js.executeScript("window.scrollBy(0,500)", "");
		String actualBillingAddressDetails = BillingAddressDetails.getText();
		String expectedBillingAddressDetails = Base.getProperty("expectedBillingAddressDetails");
		Assert.assertEquals(actualBillingAddressDetails, expectedBillingAddressDetails);
	}

	public void verifyOrderDateAndStatus() {
		String actualOrderDateAndStatusText = orderDateAndSatatus.getText();
		String order_Number = orderNumber.getText();
		String oder_Date = orderDate.getText();
		String order_Status = orderStatus.getText();
		String expectedOrderDateAndStatusText = "Order #" + order_Number + " was placed on " + oder_Date
				+ " and is currently " + order_Status + ".";
		Assert.assertEquals(actualOrderDateAndStatusText, expectedOrderDateAndStatusText);
	}

	public void logOut() {
		logoutButton.click();
		String actualLogOut = loginText.getText();
		String expectedLogout = "Login";
		Assert.assertEquals(actualLogOut, expectedLogout);
	}
	
	public void clickOrdersBtn() {
		odersButton.click();
	}
	
	public void clickViewBtn() {
		viewButton.click();
	}
	
	public void clickDashBoardBtn() {
		dashboardButton.click();
	}
	
	public void clickAddressBtn() {
		addressButton.click();
	}
	
	public void clickBillingEditBtn() {
		billingEditButton.click();
	}
	
	public void clickShippingEditBtn() {
		shippingEditButton.click();
	}
	
	public void clickAccountDetailsBtn() {
	accountDetailsButton.click();
	}
}
	

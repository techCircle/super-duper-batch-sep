package thunpanBee51TestCasesPageObj;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import thunpanBee51TestCases.Driver;

public class CheckoutPageObj {

	public CheckoutPageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[text()='Billing Details']")
	private WebElement billingLabel;

	@FindBy(xpath = "//*[@id='page-35']/div/div[1]/form[3]")
	private WebElement form;

	@FindBy(xpath = "//*[@id='billing_first_name']")
	private WebElement firstNameBox;
	@FindBy(xpath = "//*[@id='billing_last_name']")
	private WebElement lastNameBox;
	@FindBy(xpath = "//*[@id='billing_email']")
	private WebElement billingEmailBox;
	@FindBy(xpath = "//*[@id='billing_phone']")
	private WebElement phoneBox;
	// countrySeS //
	@FindBy(xpath = "//*[@id='s2id_billing_country']/a/span[2]/b")
	private WebElement countryDropDown;
	@FindBy(xpath = "//*[@id='s2id_autogen1_search']")
	private WebElement countryBox;
	@FindBy(xpath = "//*[@id='select2-results-1']/li")
	private List<WebElement> countryList;

	@FindBy(xpath = "//*[@id='billing_address_1']")
	private WebElement streetBox;
	@FindBy(xpath = "//*[@id='billing_city']")
	private WebElement cityBox;

	// stateSeS //
	@FindBy(xpath = "//*[@id='s2id_billing_state']/a/span[2]/b")
	private WebElement stateDropDown;
	@FindBy(xpath = "//*[@id='s2id_autogen2_search']")
	private WebElement stateBox;
	@FindBy(xpath = "//*[@id='select2-result-label-418']")
	private WebElement stateSelect;
	@FindBy(xpath = "//*[@id='billing_postcode']")
	private WebElement zipCodeBox;

	@FindBy(xpath = "//*[@id='createaccount']")
	private WebElement createAccCheckBox;
	@FindBy(xpath = "//*[@id='account_password']")
	private WebElement createPassword;

	@FindBy(xpath = "//*[@id='payment_method_cod']")
	private WebElement cashRadioBtn;
	@FindBy(xpath = "//*[@id='place_order']")
	private WebElement placeOrderBtn;
	
	@FindBy(xpath = "//*[@id='order_review']/table/tfoot/tr[2]//span")
	private WebElement tax;
	

	public void formFillIn() {

		firstNameBox.sendKeys(thunpanBee51TestCases.ConfigurationProperties.getProperty("firstName"));
		lastNameBox.sendKeys(thunpanBee51TestCases.ConfigurationProperties.getProperty("lastName"));
		billingEmailBox.sendKeys(thunpanBee51TestCases.ConfigurationProperties.getProperty("email"));
		phoneBox.sendKeys(thunpanBee51TestCases.ConfigurationProperties.getProperty("phone"));
		countryDropDown.click();
		countryBox.sendKeys(thunpanBee51TestCases.ConfigurationProperties.getProperty("country"));
		//Driver.clickOnProduct(countryList, null);
		streetBox.sendKeys(thunpanBee51TestCases.ConfigurationProperties.getProperty("address"));
		cityBox.sendKeys(thunpanBee51TestCases.ConfigurationProperties.getProperty("city"));
		stateDropDown.click();
		stateBox.sendKeys(thunpanBee51TestCases.ConfigurationProperties.getProperty("state"));
		stateSelect.click();
		zipCodeBox.sendKeys(thunpanBee51TestCases.ConfigurationProperties.getProperty("zipCode"));
		createAccCheckBox.click();
		createPassword.sendKeys(thunpanBee51TestCases.ConfigurationProperties.getProperty("password"));

	}

	public void clickPlaceOrder() {
		placeOrderBtn.click();
	}

	
	public void compareTax() {
		countryDropDown.click();
		countryBox.sendKeys("india");
		
		for(WebElement option : countryList) {
			String optionList = option.getText();
			if(optionList.equals("India")) {
				option.click();
			}	
		}		
		
		String taxLabel = tax.getText();
		System.out.println("Tax : "+taxLabel);
	}
	
	public void compareTax2() {
		countryDropDown.click();
		countryBox.sendKeys("thailand");
		Driver.clickOnProduct(countryList, "Thai");
		String tax2 = tax.getText();
		System.out.println("Romimg Tax: "+tax2);
		
		
	}
	
	

	
	
	
	public void verifyBillinLabelAndForm() {

		System.out.println("Billing label isDisplayed : " + billingLabel.isDisplayed());
		System.out.println("Form IsDisplayed : " + form.isDisplayed());

	}

}

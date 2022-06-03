package thunpanBee51TestCasesPageObj;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.Locale;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import thunpanBee51TestCases.Constant;
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
	@FindBy(xpath = "//*[@id='select2-results-1']/li/div")
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
	@FindBy(xpath = "//*[@id='order_review']/table/tbody/tr/td/span")
	private WebElement totalPrice;
	@FindBy(xpath = "//*[@id='order_review']/table/tfoot/tr[2]//span")
	private WebElement tax;
	@FindBy(xpath = "//*[@id='order_review']/table/tfoot/tr[2]/td/span")
	private WebElement romingTax;
	@FindBy(xpath = "//*[@id=\"select2-result-label-460\"]/span")
	private WebElement india;

	public void formFillIn() {

		firstNameBox.sendKeys(thunpanBee51TestCases.ConfigurationProperties.getProperty("firstName"));
		lastNameBox.sendKeys(thunpanBee51TestCases.ConfigurationProperties.getProperty("lastName"));
		billingEmailBox.sendKeys(thunpanBee51TestCases.ConfigurationProperties.getProperty("email"));
		phoneBox.sendKeys(thunpanBee51TestCases.ConfigurationProperties.getProperty("phone"));
		countryDropDown.click();
		countryBox.sendKeys(thunpanBee51TestCases.ConfigurationProperties.getProperty("country"));
		// Driver.clickOnProduct(countryList, null);
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

	public void indianTax() throws InterruptedException {
		countryDropDown.click();
		countryBox.sendKeys("india");
		india.click();
		Thread.sleep(2000);
		double indianTax = Driver.getPriceAsInt(tax);
		double $price = Driver.getPriceAsInt(totalPrice);
//		System.out.println(indianTax);
//		System.out.println($price);
		double priceTax = $price * Constant.indianTax / 100;
//		System.out.println(priceTax);
		Assert.assertTrue(indianTax == priceTax);
	}

	/*
	 * Try to use BigDecimal
	 * 
	 */
	public void roamingTax() throws ParseException {
		BigDecimal parseroamimgTax = Currency.parse(tax.getText(), Locale.US);
		BigDecimal price = Currency.parse(totalPrice.getText(), Locale.US);
		double roamimgtax = Double.valueOf(parseroamimgTax.toString());
//		System.out.println(parseroamimgTax);
//		System.out.println(Double.valueOf(price.toString())*5/100);
		Assert.assertTrue(roamimgtax == Double.valueOf(price.toString()) * Constant.roamingTax / 100);
	}

	public void verifyBillinLabelAndForm() {
		System.out.println("Billing label isDisplayed : " + billingLabel.isDisplayed());
		System.out.println("Form IsDisplayed : " + form.isDisplayed());

	}

	/// Currency ///
	static class Currency {

		public static BigDecimal parse(final String amount, final Locale locale) throws ParseException {
			final NumberFormat format = NumberFormat.getNumberInstance(locale);
			if (format instanceof DecimalFormat) {
				((DecimalFormat) format).setParseBigDecimal(true);
			}
			return (BigDecimal) format.parse(amount.replaceAll("[^\\d.,]", ""));
		}

	}

}

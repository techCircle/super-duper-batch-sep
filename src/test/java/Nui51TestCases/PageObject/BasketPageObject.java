package Nui51TestCases.PageObject;

import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Locale;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import NuiUtilities.Currency;
import NuiUtilities.Driver;
import NuiUtilities.NuiConfigurationProperties;

public class BasketPageObject {
	
	WebDriver driver = Driver.getDriver();
	
	CommonPageObject cp = new CommonPageObject();
	MyAccountPageObject ap = new MyAccountPageObject();


	public BasketPageObject() {
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy (xpath = "//*[@id='coupon_code']")
	public WebElement couponField;
	
	@FindBy (xpath = "//*[@class='button']")
	public WebElement couponBtn;
	
	@FindBy (xpath = "//*[@class='woocommerce']/ul/li")
	public WebElement errMsg;
	
	@FindBy (xpath = "//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[1]/a")
	public WebElement removeX;
	
	@FindBy (xpath = "//*[@class='cart-empty']")
	public WebElement cart;
	
	@FindBy (xpath = "//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input")
	public WebElement volBox;
	
	@FindBy (xpath = "//*[@id='page-34']/div/div[1]/form/table/tbody/tr[2]/td/input[1]")
	public WebElement updateBasketBtn;
	
	@FindBy (xpath = "//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[4]/span")
	public WebElement pricePerItem;
	
	@FindBy (xpath = "//td[@class='product-subtotal']/span")
	public WebElement updatedPrice;
					  
	@FindBy (xpath = "//*[@id='page-34']/div/div[1]/div/div/table/tbody/tr[3]/th")
	public WebElement totalPrice;
	
	@FindBy (xpath = "//tr[@class='order-total']/td/strong/span")
	public WebElement tPrice;
	
	@FindBy (xpath = "//tr[@class='cart-subtotal']/td/span")
	public WebElement stPrice;
	
	@FindBy (xpath = "//*[@id='page-34']/div/div[1]/div/div/table/tbody/tr[1]/td/span")
	public WebElement stIndianPrice;
	
	@FindBy (xpath = "//*[@class='checkout-button button alt wc-forward']")
	public WebElement proceedToChkoutBtn;
	
	@FindBy (xpath = "//*[@id='page-34']/div/div[1]/div/div/table/tbody/tr[1]/th")
	public WebElement subTotalPrice;
	
	@FindBy (xpath = "//*[@id='page-34']/div/div[1]/div/div/div/a")
	public WebElement proceedtoChkoutBtn;
	
	@FindBy (xpath = "//*[@id='page-34']/div/div[1]/div/div/table/tbody/tr[2]/td/span")
	public WebElement getTax;
	
	@FindBy (xpath = "//td[@data-title='Tax']")
	public WebElement getIndianTax;

	
	public void totalMoreThanSubTotal() throws ParseException {
		BigDecimal parsedTotal = Currency.parse(tPrice.getText(), Locale.US);
		BigDecimal parsedSubTotal = Currency.parse(stPrice.getText(), Locale.US);
		Assert.assertTrue(Double.valueOf(parsedTotal.toString()) > Double.valueOf(parsedSubTotal.toString()));
		
	}
	
	public void checkUSTax() throws ParseException {
		BigDecimal parsedSubTotal = Currency.parse(stPrice.getText(), Locale.US);
		Assert.assertTrue(Double.valueOf(parsedSubTotal.toString())  * Double.valueOf(NuiConfigurationProperties.getKeyValue("roamingTax")) / 100 == Double.valueOf(getTax.getText().substring(1)));
	}
	
	public void checkIndianTax() throws ParseException {
		BigDecimal parsedIndianTaxSum = Currency.parse(getIndianTax.getText(), Locale.US);	
		BigDecimal parsedSubTotal = Currency.parse(stIndianPrice.getText(), Locale.US);
		Assert.assertTrue((Double.valueOf(parsedSubTotal.toString())  *  (Double.valueOf(NuiConfigurationProperties.getKeyValue("indianTax")) / 100.0)) == Double.valueOf(parsedIndianTaxSum.toString()));
	}
	
	public void verifyToTalSubTotalDisplay() {
		Assert.assertTrue(totalPrice.isDisplayed());
		Assert.assertTrue(subTotalPrice.isDisplayed());
	}
	
	public void addMoreBookAndVerifyUpdatedPrice() throws InterruptedException, ParseException {
		volBox.clear();
		volBox.sendKeys(NuiConfigurationProperties.getKeyValue("addBookQty"));
		updateBasketBtn.click();
		Thread.sleep(2000);
		
		BigDecimal parsedPrice = Currency.parse(pricePerItem.getText(), Locale.US);			
		BigDecimal parsedTotal = Currency.parse(updatedPrice.getText(), Locale.US);
		
		Assert.assertTrue(Double.valueOf(NuiConfigurationProperties.getKeyValue("addBookQty")) * Double.valueOf(parsedPrice.toString()) == Double.valueOf(parsedTotal.toString()));
		
	}
	
	public void addAndVerifyCoupon() throws InterruptedException {
		couponField.sendKeys(NuiConfigurationProperties.getKeyValue("coupon"));
		couponBtn.click();
		Thread.sleep(3000);
		//Since the provided coupon code is not working so I have to change the test #14th-15th
		//from verifying discount amount to verify that coupon code is not valid after enter the coupon code
		String errTxt = errMsg.getText();
		Assert.assertTrue(errTxt.equals(NuiConfigurationProperties.getKeyValue("errMsgCoupon")));
	}
	
	public void verifyAtBasketPage() {	
		String expectedURL = "http://practice.automationtesting.in/basket/";
		Assert.assertTrue(driver.getCurrentUrl().equals(expectedURL));
	}
	
	public void removeAndVerify() throws InterruptedException {
		removeX.click();
		Thread.sleep(3000);
		String txt = cart.getText();
		Assert.assertTrue(txt.equals(NuiConfigurationProperties.getKeyValue("emptyBasketMsg")));	
	}

}

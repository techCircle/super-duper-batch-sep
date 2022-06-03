package thunpanBee51TestCasesPageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import thunpanBee51TestCases.ConfigurationProperties;
import thunpanBee51TestCases.Driver;
import thunpanBee51TestCases.ThunpanBeeConstant;

public class BasketObj {

	@FindBy(xpath = "//div[@class='quantity']/input")
	private WebElement QTYBox;

	@FindBy(xpath = "//input[@value='Update Basket']")
	private WebElement updateBtn;

	@FindBy(xpath = "//div[@class='page-content entry-content']")
	private WebElement info;

	@FindBy(xpath = "//div[@class='woocommerce-message']")
	private WebElement updateLabel;

	@FindBy(xpath = "//*[@class='checkout-button button alt wc-forward']")
	private WebElement checkOutBtn;

	@FindBy(xpath = "//*[@id='coupon_code']")
	private WebElement couponCodeBox;

	@FindBy(xpath = "//*[@name='apply_coupon']")
	private WebElement applyCouponBtn;

	@FindBy(xpath = "//*[text()='Coupon usage limit has been reached.']")
	private WebElement couponText;

	@FindBy(xpath = "//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[1]/a")
	private WebElement removeBtn;

	@FindBy(xpath = "//*[@id='page-34']/div/div[1]")
	private WebElement removeText;
	
	@FindBy(xpath = "//*[@id='page-34']/div/div[1]/div/div/table/tbody/tr[3]/td/strong/span")
	public WebElement totalPrice;
	
	@FindBy(xpath = "//*[@id='page-34']/div/div[1]/div/div/table/tbody/tr[1]/td/span")
	public WebElement totalBeforeTax;

	
	
	public BasketObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	public void clickCheckout() {
		checkOutBtn.click();
	}

	public void clickRvmBtn() {
		removeBtn.click();
	}

	public void couponBoxInput() {
		couponCodeBox.click();
		couponCodeBox.sendKeys(ConfigurationProperties.getInputDataProperty("coupon"));
		applyCouponBtn.click();
	}

	public void inputQTYBox() {
		QTYBox.clear();
		QTYBox.sendKeys(ConfigurationProperties.getInputDataProperty("input"));
		updateBtn.click();

	}
	
	public void totalAndSubtotal() {
		double beforeTax = Driver.getPriceAsInt(totalBeforeTax);
		double finalTotal = Driver.getPriceAsInt(totalPrice);
		System.out.println("Before Tax Total : " + beforeTax);
		System.out.println("After Tax Total : " + finalTotal);
		Assert.assertTrue(beforeTax<finalTotal);
	}
	
	
	public void verifyTotalPrice() {
		String actualText = totalPrice.getText();
		String expectedText = ThunpanBeeConstant.totalTextExp ;
		System.out.println("Actual Text : " + actualText);
		System.out.println("Expected Text : " + expectedText);
		Assert.assertTrue(actualText.contains(expectedText));
	}
	
	public void verifyRemove() {
		String actualText = removeText.getText();
		String expectedText = ThunpanBeeConstant.removeExp;
		System.out.println("Actual Text : " + actualText);
		System.out.println("Expected Text : " + expectedText);
		Assert.assertTrue(actualText.contains(expectedText));
	}

	public void verifyCheckoutBtn() {

		System.out.println("CheckOut Button isEnable : " + checkOutBtn.isEnabled());
	}

	public void couponVerify() {
		String actualText = couponText.getText();
		String expectedText = ThunpanBeeConstant.couponExp;
		Assert.assertTrue(actualText.contains(expectedText));
		System.out.println("Actual Text : " + actualText);
		System.out.println("Expected Text : " + expectedText);
	}

	public void verifyUpadteInfo() {
		String actual = updateLabel.getText();
		String expected = ConfigurationProperties.getInputDataProperty("verifyUpdate");

		System.out.println("Actual : " + actual);
		System.out.println("Expected : " + expected);
		Assert.assertTrue(actual.contains(expected));
	}
}

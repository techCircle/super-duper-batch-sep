package thunpanBee51TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ObjectFactory extends Driver {
	
	JavascriptExecutor js;

	// registration //
	@FindBy(xpath = "//*[text()='My Account']")
	public WebElement accBtn;

	@FindBy(xpath = "//input[@id='reg_email']")
	public WebElement emailBox;

	@FindBy(xpath = "//input[@id='reg_password']")
	public WebElement passWordBox;

	@FindBy(xpath = "//*[@name='register']")
	public WebElement registerBtn;

	@FindBy(xpath = "//*[@id='page-36']/div/div[1]/ul/li")
	public WebElement Text;

	@FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']")
	public WebElement loginText;
	//////////////////////////////////////////////////////////////////////
	// login //
	@FindBy(xpath = "//*[@name='username']")
	public WebElement userBox;

	@FindBy(xpath = "//*[@id='password']")
	public WebElement passWordLoginBox;

	@FindBy(xpath = "//*[@name='login']")
	public WebElement loginBtn;

	@FindBy(xpath = "//*[text()='Sign out']")
	public WebElement signOutBtn;

	@FindBy(xpath = "//*[@id='password']")
	public WebElement passwordVer;

	//////////////////////////////////////////////////////////////////////

	List<WebElement> list = driver.findElements(
			By.xpath("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div"));

	// homePage//
	@FindBy(xpath = "//*[text()='Shop']")
	public WebElement shopBtn;

	@FindBy(xpath = "//*[text()='Home']")
	public WebElement homeBtn;

	@FindBy(xpath = "//*[@class='n2-ss-slider-3']/div")
	public List<WebElement> hpSlide;

	@FindBy(xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div")
	public List<WebElement> newArrivalImageList;

	@FindBy(xpath = "//div[@class='col3-1 last sub_column sub_column_1-0-2-2 sub_column_post_22']//img")
	public WebElement masterJavaBookImg;

	@FindBy(xpath = "//ul[@class='products']/li[2]//img")
	public WebElement programmingBook;

	@FindBy(xpath = "//*/button[@type='submit']")
	public WebElement addCartBtn;

	@FindBy(xpath = "//li[@class='description_tab active']")
	public WebElement descriptionTab;

	@FindBy(xpath = "//div[@id='tab-description']//p")
	public WebElement descriptionText;

	@FindBy(xpath = "//*[@id='product-170']/div[3]/ul/li[2]/a")
	public WebElement reviewTab;

	@FindBy(xpath = "//div[@id='comments']")
	public WebElement reviewText;

	@FindBy(xpath = "//*[@class='cartcontents']")
	public WebElement itemBasket;

	@FindBy(xpath = "//*[@id='wpmenucartli']/a/span[2][contains(text(),'₹')]")
	public WebElement priceBasket;

	@FindBy(xpath = "//*[@name='quantity']")
	public WebElement input;

	@FindBy(xpath = "//*[@title='View your shopping cart']")
	public WebElement viewCart;

	@FindBy(xpath = "//*[@class='checkout-button button alt wc-forward']")
	public WebElement checkOutBtn;

	@FindBy(xpath = "//*[@class='input-text']")
	public WebElement couponCodeBox;

	@FindBy(xpath = "//*[@name='apply_coupon']")
	public WebElement applyCouponBtn;

	@FindBy(xpath = "//*[text()='Coupon usage limit has been reached.']")
	public WebElement couponText;

	@FindBy(xpath = "//*[@title='Remove this item']")
	public WebElement removeBtn;

	@FindBy(xpath = "//*[text()='JS Data Structures and Algorithm removed. ']")
	public WebElement removeText;

	@FindBy(xpath = "//*[@title='Qty']")
	public WebElement qtyBox;

	@FindBy(xpath = "//*[@name='update_cart']")
	public WebElement updateBasketBtn;

	@FindBy(xpath = "//*[text()='Basket updated.']")
	public WebElement basketText;

	@FindBy(xpath = "//*[@class='order-total']")
	public WebElement totalPrice;

	@FindBy(xpath = "//*[@class='cart-subtotal']")
	public WebElement totalBeforeTax;

	@FindBy(xpath = "//*[text()='Billing Details']")
	public WebElement billingLabel;

	@FindBy(xpath = "//*[@id='page-35']/div/div[1]/form[3]")
	public WebElement form;

	@FindBy(xpath = "//*[@id='place_order']")
	public WebElement placeOrderBtn;

	public ObjectFactory(WebDriver driver) {
		Driver.driver = driver;// this.driver linked to BaseTest WebDriver driver
		PageFactory.initElements(driver, this);
	}

	public void getTitle() {
		String urlVerify = getDriver().getCurrentUrl().toString();
		System.out.println("Verify Navigate To Next Page : " + urlVerify);
	}

	public void verify() {
		String actualText = Text.getText();
		String expectedText = actualText.toString();
		Assert.assertTrue(actualText.contains(expectedText));
		System.out.println("ActualText : " + actualText);
		System.out.println("ExpectedText : " + expectedText);
	}

	public void loginVerify() {
		String actualText = loginText.getText();
		String expectedText = actualText.toString();
		Assert.assertTrue(actualText.contains(expectedText));
		System.out.println("ActualText : " + actualText);
		System.out.println("ExpectedText : " + expectedText);
	}

	public void passwordVerify() {
		Assert.assertEquals(passwordVer.getAttribute("type"), "password");
		String actualType = passwordVer.getAttribute("type");
		String expectedType = "password";
		System.out.println("Actual Type : " + actualType);
		System.out.println("Expected Type : " + expectedType);
	}

	public void homePageSlideVerify() {
		int actualHpSlide = hpSlide.size();
		int expectedSlide = 3;
		System.out.println("Actual Homepage slide: " + actualHpSlide);
		System.out.println("Expected Homepage slide: " + expectedSlide);
		Assert.assertEquals(actualHpSlide, expectedSlide);
	}

	public void newArrivalImageVerify() {
		int actualImageSlide = newArrivalImageList.size();
		int expectedSlide = 3;
		System.out.println("Actual image slide: " + actualImageSlide);
		System.out.println("Expected image slide: " + expectedSlide);
		Assert.assertEquals(actualImageSlide, expectedSlide);

	}

	public void addCartBtnIsEnable() {
		String addBtnIsEnable = "Add To Basket Button Is Enable";
		if (addCartBtn.isEnabled()) {
			System.out.println("Verify user can add item to basket: " + addBtnIsEnable);
		}
	}

	public void descriptionVerify() {
		String actualText = descriptionText.getText();
		String expected = actualText.toString();
		System.out.println("Actual Text: " + actualText);
		System.out.println("Expected Text: " + expected);
		Assert.assertTrue(actualText.contains(expected));
	}

	public void reviewVerify() {
		String actualText = reviewText.getText();
		String expected = actualText.toString();
		System.out.println("Actual Text: " + actualText);
		System.out.println("Expected Text: " + expected);
		Assert.assertTrue(actualText.contains(expected));
	}

	public void verifyBasket() {
		String item = itemBasket.getText();
		String price = priceBasket.getText();
		System.out.println("Verify Item view : " + item);
		System.out.println("Verify Price view : " + price);
	}

	public void inputQuantity() {
		String maxInput = input.getAttribute("Max");
		System.out.println("Maximum quantity : " + maxInput);

		int maxPlusOne = Integer.parseInt(maxInput + 1);
		input.clear();
		input.sendKeys(maxPlusOne + "");
		addCartBtn.click();

		js = (JavascriptExecutor) driver;
		Boolean isValidInput = (Boolean) js.executeScript("return arguments[0].checkValidity();", input);
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", input);
		System.out.println("Actual Alert : " + validationMessage);
		Assert.assertFalse(isValidInput);
		String alert = String.format("Value must be less than or equal to %d.", Integer.valueOf(maxInput));
		Assert.assertTrue(alert.contains(validationMessage));
		System.out.println("Expected Alert : " + alert);
	}

	public void isCheckoutBtnEnable() {
		String checkoutButton = "Checkout button Is Enable";
		if (checkOutBtn.isEnabled()) {
			System.out.println("Verify Checkout button : " + checkoutButton);
		}
	}

	public void inputSend4() {
		input.clear();
		input.sendKeys("4");
	}

	public void couponBoxInput() {
		couponCodeBox.sendKeys("krishnasakinala");
		applyCouponBtn.click();
	}

	public void couponVerify() {
		String actualText = couponText.getText();
		String expectedText = actualText.toString();
		Assert.assertTrue(actualText.contains(expectedText));
		System.out.println("Actual Text : " + actualText);
		System.out.println("Expected Text : " + expectedText);
	}

	public void removeVerify() {
		String actualText = removeText.getText();
		String expectedText = actualText.toString();
		Assert.assertTrue(actualText.contains(expectedText));
		System.out.println("Actual Text : " + actualText);
		System.out.println("Expected Text : " + expectedText);
	}

	public void qtyInput() {
		qtyBox.clear();
		qtyBox.sendKeys("3");
	}

	public void isUpdateBasketBtnIsEnable() {
		String updateBtn = "Update button Is Enable";
		if (updateBasketBtn.isEnabled()) {
			System.out.println("Verify Update button : " + updateBtn);
		}
	}

	public void basketTextVerify() {
		String actualText = basketText.getText();
		String expectedText = actualText.toString();
		Assert.assertTrue(actualText.contains(expectedText));
		System.out.println("Actual Text : " + actualText);
		System.out.println("Expected Text : " + expectedText);
	}

	public void totalPriceVerify() {
		String actualText = totalPrice.getText();
		String expectedText = actualText.toString();
		Assert.assertTrue(actualText.contains(expectedText));
		System.out.println("Actual Text : " + actualText);
		System.out.println("Expected Text : " + expectedText);
	}

	public void totalAndSubtotal() {
		String beforeTax = totalBeforeTax.getText();
		String finalTotal = totalPrice.getText();
		System.out.println("Before Tax Total : " + beforeTax);
		System.out.println("After Tax Total : " + finalTotal);
	}

	public void billingLabelVerify() {
		String expectedText = billingLabel.getText();
		System.out.println("Verify of navigate to payment page : " + expectedText);
	}

	public void formVerify() {
		String formRe = form.getText();
		System.out.println(formRe);
	}

	@FindBy(xpath = "//*[@id='billing_first_name']")
	public WebElement firstNameBox;
	@FindBy(xpath = "//*[@id='billing_last_name']")
	public WebElement lastNameBox;
	@FindBy(xpath = "//*[@id='billing_email']")
	public WebElement billingEmailBox;
	@FindBy(xpath = "//*[@id='billing_phone']")
	public WebElement phoneBox;
	@FindBy(xpath = "//*[@id='s2id_billing_country']/a/span[2]/b")

	// countrySeS //
	public WebElement countryDropDown;
	@FindBy(xpath = "//*[@id='s2id_autogen1_search']")
	public WebElement countryBox;
	@FindBy(xpath = "//*[@id='select2-results-1']/li[3]")
	public WebElement countrySelect;

	@FindBy(xpath = "//*[@id='billing_address_1']")
	public WebElement streetBox;
	@FindBy(xpath = "//*[@id='billing_city']")
	public WebElement cityBox;

	// stateSeS //
	@FindBy(xpath = "//*[@id='s2id_billing_state']/a/span[2]/b")
	public WebElement stateDropDown;
	@FindBy(xpath = "//*[@id='s2id_autogen2_search']")
	public WebElement stateBox;
	@FindBy(xpath = "//*[@id='select2-result-label-418']")
	public WebElement stateSelect;
	@FindBy(xpath = "//*[@id='billing_postcode']")
	public WebElement zipCodeBox;

	@FindBy(xpath = "//*[@id='createaccount']")
	public WebElement createAccCheckBox;
	@FindBy(xpath = "//*[@id='account_password']")
	public WebElement createPassword;

	@FindBy(xpath = "//*[@id='page-35']/div/div[1]/table[1]")
	public WebElement orderDetail;
	@FindBy(xpath = "//*[@id='page-35']/div/div[1]/table[2]")
	public WebElement customerDetail;
	@FindBy(xpath = "//*[@id='page-35']/div/div[1]/address")
	public WebElement billingDetail;

	public void formFillIn() {
		String firstName = "John";
		String lastName = "Doe";
		// have to change email every executed//
		String email = "a@jmail.com";
		String phone = "0123456789";
		String address = "123 techcircle St";
		String city = "TechCircle";
		String zipCode = "01234";
		String country = "Unit";
		String state = "Vir";
		String password = "!12345bee!12345bee!12345bee!12345bee";

		firstNameBox.sendKeys(firstName);
		lastNameBox.sendKeys(lastName);
		billingEmailBox.sendKeys(email);
		phoneBox.sendKeys(phone);
		countryDropDown.click();
		countryBox.sendKeys(country);
		countrySelect.click();
		streetBox.sendKeys(address);
		cityBox.sendKeys(city);
		stateDropDown.click();
		stateBox.sendKeys(state);
		stateSelect.click();
		zipCodeBox.sendKeys(zipCode);
		createAccCheckBox.click();
		createPassword.sendKeys(password);
	}

	public void orderConfirm() {
		String order = orderDetail.getText();
		String customer = customerDetail.getText();
		String billing = billingDetail.getText();
		System.out.println("-Order Detail-\n" + order);
		System.out.println("-Customer Detail-\n" + customer);
		System.out.println("-Billing Detail-\n" + billing);
	}
}

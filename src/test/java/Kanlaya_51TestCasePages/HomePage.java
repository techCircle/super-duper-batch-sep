package Kanlaya_51TestCasePages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Kanlaya_51TestCaseUtilities.Base;

public class HomePage {

	JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();

	public HomePage() {
		PageFactory.initElements(Base.getDriver(), this);
	}

	// HOMEPAGE
	@FindBy(xpath = "//*[@id = 'main-nav']/li[2]")
	public WebElement myAccountButton;

	@FindBy(xpath = "//*[@id= 'content']/ul/li")
	public List<WebElement> bookList;

	@FindBy(xpath = "//*[@id='menu-item-40']/a")
	public WebElement shopButton;

	@FindBy(xpath = "//div[@class = 'n2-ss-slider-3']/div")
	public List<WebElement> sliders;

	@FindBy(xpath = "//*[@class = 'themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div")
	public List<WebElement> arrivals;

	@FindBy(xpath = "//*[text() = 'Description']")
	public WebElement descriptionTab;

	@FindBy(xpath = "//*[@id = 'tab-description']")
	public WebElement descriptionDetails;

	@FindBy(xpath = "//*[@class = 'woocommerce-tabs wc-tabs-wrapper']/ul/li[2]")
	public WebElement reviewTab;

	@FindBy(xpath = "//*[@id= 'comment']")
	public WebElement reviewField;

	@FindBy(xpath = "//*[@title = 'Functional Programming in JS']")
	public WebElement functionalProgrammingInJSBook;

	@FindBy(xpath = "//*[@class = 'quantity']/input")
	public WebElement quantityField;

	@FindBy(xpath = "//*[@class = 'cart']/button")
	public WebElement addToBasketButton;

	@FindBy(xpath = "//*[@class = 'summary entry-summary']/div/p/span")
	public WebElement bookPrice;

	@FindBy(xpath = "//*[text() = 'View Basket']")
	public WebElement viewBasketButton;

	@FindBy(xpath = "//*[@class = 'wc-proceed-to-checkout']/a")
	public WebElement checkoutButton;

	@FindBy(xpath = "//*[@class = 'woocommerce-billing-fields']/h3")
	public WebElement BilligDetailsText;

	@FindBy(xpath = "//*[@class ='woocommerce']/div[2]/a")
	public WebElement addCouponLink;

	@FindBy(xpath = "//*[@class ='woocommerce']/div[1]/a")
	public WebElement clicToLogInLink;

	@FindBy(xpath = "//*[@id='coupon_code']")
	public WebElement couponField;

	@FindBy(xpath = "//*[@name ='apply_coupon']")
	public WebElement applyCouponButton;

	@FindBy(xpath = "//*[@class = 'woocommerce']/ul/li")
	public WebElement limitCouponReach;

	@FindBy(xpath = "//*[@class = 'product-remove']/a")
	public WebElement removeIcon;

	@FindBy(xpath = "//*[@class = 'return-to-shop']")
	public WebElement returnToShopButton;

	@FindBy(xpath = "//*[@class = 'cart-empty']")
	public WebElement cartEmptyText;

	@FindBy(xpath = "//*[@name = 'update_cart']")
	public WebElement updateBasketButton;

	public void clickMyAcctBtn() {
		myAccountButton.click();
	}
	
	public void verifyHomePageHas3SlidesOnly(int count) {
		Assert.assertEquals(count, sliders.size());
	}

	public void verifyHomePageWith3ArrivalsOnly(int count) {
		Assert.assertEquals(arrivals.size(), count);
	}

	public void verifyImagesInArrivalsShouldNavigate() {

		String[] expectedTexts = new String[] { "Selenium Ruby", "Thinking in HTML", "Mastering JavaScript" };

		for (int i = 0; i < arrivals.size(); i++) {

			String pathText = String.format(
					"//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[%d]", i + 1);
			Base.getDriver().findElement(By.xpath(pathText)).click();
			String text = Base.getDriver().findElement(By.xpath("//*[@class='product_title entry-title']")).getText();
			Assert.assertTrue(expectedTexts[i].equals(text));
			Base.getDriver().navigate().back();
		}
	}

	public void verifyArrivalsDescription() {

		String[] expectedTexts = new String[] { "Selenium Ruby", "Thinking in HTML", "Mastering JavaScript" };

		for (int i = 0; i < arrivals.size(); i++) {

			String pathText = String.format(
					"//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[%d]", i + 1);
			Base.getDriver().findElement(By.xpath(pathText)).click();
			String text = Base.getDriver().findElement(By.xpath("//*[@class='product_title entry-title']")).getText();
			Assert.assertTrue(expectedTexts[i].equals(text));

			Assert.assertTrue(descriptionTab.isDisplayed());
			descriptionTab.click();
			Assert.assertTrue(descriptionDetails.isDisplayed());

			Base.getDriver().navigate().back();
		}

	}

	public void verifyArrivalsReviews() {

		String[] expectedTexts = new String[] { "Selenium Ruby", "Thinking in HTML", "Mastering JavaScript" };

		for (int i = 0; i < arrivals.size(); i++) {

			String pathText = String.format(
					"//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[%d]", i + 1);
			Base.getDriver().findElement(By.xpath(pathText)).click();
			String text = Base.getDriver().findElement(By.xpath("//*[@class='product_title entry-title']")).getText();
			Assert.assertTrue(expectedTexts[i].equals(text));

			Assert.assertTrue(reviewTab.isDisplayed());
			reviewTab.click();
			Assert.assertTrue(reviewField.isDisplayed());

			Base.getDriver().navigate().back();

		}

	}

	public void verifyBookPrice() {
		Assert.assertTrue(bookPrice.isDisplayed());
	}

	public void verifyAddBook() {
		Assert.assertTrue(viewBasketButton.isDisplayed());
	}

	public void addBooksMoreThanBooksAvaialble() {
		quantityField.clear();
		String maxNumber = quantityField.getAttribute("max");
		int moreThanMax = Integer.valueOf(maxNumber) + 1;
		quantityField.sendKeys(String.valueOf(moreThanMax));
		addToBasketButton.click();
		// Check if there is an error message pop up (using javascript)
		JavascriptExecutor js = (JavascriptExecutor) Base.getDriver();
		Boolean isValidInput = (Boolean) js.executeScript("return arguments[0].checkValidity();", quantityField);
		System.out.println(isValidInput); // false; not valid number
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", quantityField);
		System.out.println(validationMessage);
		Assert.assertFalse(isValidInput);
		String alert = String.format("Value must be less than or equal to %d.", Integer.valueOf(maxNumber));
		Assert.assertTrue(validationMessage.equals(alert));
		quantityField.clear();
		Base.getDriver().navigate().back();
	}

	public void verifyCheckoutPage() {

		String actualBillingDetailsText = BilligDetailsText.getText();
		String expectedBillingDetalsText = "Billing Details";

		Assert.assertEquals(actualBillingDetailsText, expectedBillingDetalsText);

	}

	public void verifyAddCoupon() {
		String limitCounponReachMsg = limitCouponReach.getText();
		String expectedCouponMsg = "Coupon usage limit has been reached.";
		Assert.assertEquals(limitCounponReachMsg, expectedCouponMsg);
		System.out.println("no discount");

	}

	public void verifyBookRemoved() {
		String returnToShop = cartEmptyText.getText();
		String expectedReturnToShopText = "Your basket is currently empty.";
		Assert.assertEquals(returnToShop, expectedReturnToShopText);
	}



}

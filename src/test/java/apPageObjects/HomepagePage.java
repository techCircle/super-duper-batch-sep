package apPageObjects;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import apUtilities.BaseClass;

public class HomepagePage {
	WebDriver driver = BaseClass.getDriver();

	public HomepagePage() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "menu-item-40")
	public WebElement shopMenu;
	@FindBy(xpath = "//*[contains(text(),'Home')]")
	public WebElement homeMenu;
	@FindBy(xpath = "//*[@id=\"n2-ss-6\"]/div[1]/div/div/div")
	public List<WebElement> sliders;
	@FindBy(xpath = "//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div")
	public List<WebElement> newArrs;
	@FindBy(xpath = "//*[@id='text-22-sub_row_1-0-2-0-0']")
	public WebElement seleniumRuby;
	@FindBy(xpath = "//*[@id='text-22-sub_row_1-0-2-1-0']")
	public WebElement HTML;
	@FindBy(xpath = "//*[@id='text-22-sub_row_1-0-2-2-0']")
	public WebElement javaScript;
	@FindBy(xpath = "//*[contains(text(),'Selenium Ruby') and@class='product_title entry-title']")
	public WebElement seleniumRubyText;
	@FindBy(xpath = "//img[@title='Selenium Ruby']")
	public WebElement seleniumRubyImg;
	@FindBy(xpath = "//*[contains(text(),'Thinking in HTML') and@class='product_title entry-title']")
	public WebElement HTMLText;
	@FindBy(xpath = "//img[@title='Thinking in HTML']")
	public WebElement HTMLImg;
	@FindBy(xpath = "//*[contains(text(),'Mastering JavaScript') and@class='product_title entry-title']")
	public WebElement javaScriptText;
	@FindBy(xpath = "//img[@title='Mastering JavaScript']")
	public WebElement javaScriptImg;
	@FindBy(xpath = "//*[@class='description_tab active']")
	public WebElement descriptionBtn;
	@FindBy(xpath = "//*[@id=\"tab-description\"]/h2")
	public WebElement descriptionTxt;
	@FindBy(xpath = "//*[@class='reviews_tab']")
	public WebElement reviewsBtn;
	@FindBy(xpath = "//*[@id=\"comments\"]/h2")
	public WebElement reviewsTxt;
	@FindBy(xpath = "//*[@id=\"product-163\"]/div[5]/ul/li[1]/a[2]")
	public WebElement addToBasketBtn;
	@FindBy(xpath = "//*[@class='added_to_cart wc-forward']")
	public WebElement viewBasketBtn;
	@FindBy(xpath = "//*[@class='wpmenucart-contents']")
	public WebElement itemLink;
	@FindBy(xpath = "//th[@class='product-name']")
	public WebElement product;
	@FindBy(xpath = "//th[@class='product-price']")
	public WebElement price;
	@FindBy(id = "coupon_code")
	public WebElement couponBox;

	public void checkSlidersCount(int count) {
		Assert.assertEquals(count, sliders.size());
	}

	public void checkArrivalsCount(int count) {
		Assert.assertEquals(count, newArrs.size());
	}

	public void ImagesArrivalsShouldNavigate_byUrl() {
		String url1 = "http://practice.automationtesting.in/product/selenium-ruby/";
		String url2 = "http://practice.automationtesting.in/product/thinking-in-html/";
		String url3 = "http://practice.automationtesting.in/product/mastering-javascript/";

		List<String> list = new ArrayList<>(Arrays.asList(url1, url2, url3));
		for (int i = 0; i < newArrs.size(); i++) {
			WebElement eachItem = newArrs.get(i);
			eachItem.click();
			Assert.assertTrue(BaseClass.getDriver().getCurrentUrl().equalsIgnoreCase(list.get(i)));
			BaseClass.getDriver().navigate().back();
		}
	}

	public void verifyNewArrivalsDescription() {
		seleniumRubyImg.click();
		descriptionBtn.click();
		Assert.assertTrue(descriptionTxt.isDisplayed());
		driver.navigate().back();

		HTMLImg.click();
		descriptionBtn.click();
		Assert.assertTrue(descriptionTxt.isDisplayed());
		driver.navigate().back();

		javaScriptImg.click();
		descriptionBtn.click();
		Assert.assertTrue(descriptionTxt.isDisplayed());
		driver.navigate().back();
	}

	public void verifyNewArrivalsReviews() {
		seleniumRubyImg.click();
		reviewsBtn.click();
		Assert.assertTrue(reviewsTxt.isDisplayed());
		driver.navigate().back();

		HTMLImg.click();
		reviewsBtn.click();
		Assert.assertTrue(reviewsTxt.isDisplayed());
		driver.navigate().back();

		javaScriptImg.click();
		reviewsBtn.click();
		Assert.assertTrue(reviewsTxt.isDisplayed());
		driver.navigate().back();
	}

	public void VerifyArrivalImgAddToBasket() {
		HTMLImg.click();
		addToBasketBtn.click();
		viewBasketBtn.click();
		Assert.assertTrue(product.isDisplayed());
		Assert.assertTrue(price.isDisplayed());
	}

	public void VerifyArrivalImgItemLink() {
		HTMLImg.click();
		addToBasketBtn.click();
		itemLink.click();
		Assert.assertTrue(product.isDisplayed());
		Assert.assertTrue(price.isDisplayed());
	}

	public void VerifyArrivalImgItemCoupon() {
		HTMLImg.click();
		addToBasketBtn.click();
		itemLink.click();
//		couponBox.click();
//		couponBox.sendKeys(BaseClass.getProperty("couponCode"));
//		String msg = driver.findElement(By.xpath("//*[@class='woocommerce']/ul/li")).getText();
//		System.out.println(msg);
	}

	public void getTitle() {
		String urlVerify = BaseClass.getDriver().getCurrentUrl().toString();
		System.out.println("Verify Navigate To Next Page : " + urlVerify);
	}

}

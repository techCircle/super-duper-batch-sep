package thunpanBee51TestCasesPageObj;

import java.util.List;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import thunpanBee51TestCases.ConfigurationProperties;
import thunpanBee51TestCases.Driver;
import thunpanBee51TestCases.ThunpanBeeConstant;

public class ShopObjPage {

	Actions action = new Actions(Driver.getDriver());

	@FindBy(xpath = "//*[text()='Shop']")
	private WebElement shopBtn;

	@FindBy(xpath = "//*[text()='Home']")
	public WebElement homeBtn;

	@FindBy(xpath = "//button[contains(text(),'Filter')]")
	private WebElement filterBtn;

	@FindBy(xpath = "//div[@class='price_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']/span[2]")
	private WebElement rightSlider;

	@FindBy(xpath = "//*[@id='content']/form/select")
	private WebElement sortPrice;

	@FindBy(xpath = "//*/ins/span")
	private WebElement priceTag;

	@FindBy(xpath = "//*[@id='woocommerce_product_categories-2']//a")
	private List<WebElement> productCatagoryList;

	@FindBy(xpath = "//a[@class='woocommerce-LoopProduct-link']//h3")
	private WebElement productHeaderlabel;

	@FindBy(xpath = "//ul[@class='products masonry-done']/li")
	private List<WebElement> productList;

	@FindBy(xpath = "//*[text()='Read more']")
	private WebElement readMoreBtn;

	@FindBy(xpath = "//*/span[@class='onsale']")
	private WebElement onsale;

	@FindBy(xpath = "//*[@class='button product_type_simple add_to_cart_button ajax_add_to_cart']")
	private List<WebElement> addBasket;

	public ShopObjPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	public void clickShopBtn() {
		shopBtn.click();
	}

	public void clickOnHomeBtn() {
		homeBtn.click();
	}

	public void readMore() {
		readMoreBtn.click();
	}

	public void onSaleSelect() {
		onsale.click();
	}

	public void addProduct() {

		addBasket.get(1).click();

	}

	public void clickOnProductCatagoryOption() {

		for (WebElement productOption : productCatagoryList) {

			String productList = productOption.getText();
			System.out.println(productList);

			if (productList.contains(ConfigurationProperties.getInputDataProperty("HTML"))) {
				productOption.click();
				break;
			}
		}
	}

	public void adjSliderPrice() {

		for (int i = 1; i <= 50; i++) {
			rightSlider.sendKeys(Keys.ARROW_LEFT);
		}

		filterBtn.click();
		Select priceSorted = new Select(sortPrice);
		priceSorted.selectByValue(ConfigurationProperties.getInputDataProperty("sortHighToLow"));

	}

	public void sorting() {
		selectSorting();
		selectSortingAvg();
		selectSortingNew();
		selectSortingLow();
		selectSortingHigh();
	}

	public void selectSorting() {
		Select priceSorted = new Select(sortPrice);
		priceSorted.selectByValue(ConfigurationProperties.getInputDataProperty("sortPopular"));
	}

	public void selectSortingAvg() {
		Select priceSorted = new Select(sortPrice);
		priceSorted.selectByValue(ConfigurationProperties.getInputDataProperty("sortAvarage"));
	}

	public void selectSortingNew() {
		Select priceSorted = new Select(sortPrice);
		priceSorted.selectByValue(ConfigurationProperties.getInputDataProperty("sortNewness"));
	}

	public void selectSortingLow() {
		Select priceSorted = new Select(sortPrice);
		priceSorted.selectByValue(ConfigurationProperties.getInputDataProperty("sortLowToHigh"));
	}

	public void selectSortingHigh() {
		Select priceSorted = new Select(sortPrice);
		priceSorted.selectByValue(ConfigurationProperties.getInputDataProperty("sortHighToLow"));
	}

	public void verifyProductLabel() {

		for (WebElement pLabel : productList) {
			String label = pLabel.getText();
			System.out.println(label);
		}
	}

	public void verifyCategoryProuct() {

		String actual = productHeaderlabel.getText();
		String expected = ThunpanBeeConstant.productLabel;
		System.out.println("Actual Product Display: " + actual);
		System.out.println("Expected Product Display: " + expected);
		Assert.assertTrue(actual.contains(expected));
	}

	public void verifyPrice() {

		double price = Driver.getPriceAsInt(priceTag);
		double expected = ThunpanBeeConstant.price;
		System.out.println("Actual Price: " + price);
		System.out.println("Expected Price: " + expected);
		Assert.assertTrue(Double.valueOf(price) <= 450);
	}

}

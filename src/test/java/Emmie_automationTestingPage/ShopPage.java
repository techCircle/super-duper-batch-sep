package Emmie_automationTestingPage;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Emmie_Utilities.Emmie_Driver;

public class ShopPage {
	public ShopPage() {
		PageFactory.initElements(Emmie_Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[text()='Home']")
	public WebElement homeBtn;

	@FindBy(xpath = "//*[text()='My Account']")
	private WebElement myAccBtn;

	@FindBy(xpath = "//div[@class='price_slider ui-slider ui-slider-horizontal ui-widget ui-widget-content ui-corner-all']/span[2]")
	public WebElement rightSlider;

	@FindBy(xpath = "//*[text()='Filter']")
	public WebElement filterBtn;

	@FindBy(xpath = "//*[@class='widget woocommerce widget_product_categories']")
	public WebElement productCategories;

	@FindBy(xpath = "//*[@id='woocommerce_product_categories-2']//a")
	public List<WebElement> categoriesList;

	@FindBy(xpath = "//*[@id='content']/form/select")
	public WebElement defaultSorting;

	// *[ins/span]
	@FindBy(xpath = "//*[@id='content']/ul/li[1]/a[1]/span[2]/ins")
	public WebElement priceTag;

	public void myAccBtnClick() {
		myAccBtn.click();
	}

	public void homeBtnClick() {
		homeBtn.click();
	}


	public void filterBtnClick() {
		filterBtn.click();
	}

	public void moveSlider() {

		for (int i = 1; i <= 50; i++) {
			rightSlider.sendKeys(Keys.ARROW_LEFT);
		}
	}

	public void productCatergory() {

		String products = productCategories.getText();
		String text = products;
		System.out.println(products);
		System.out.println(text);
		Assert.assertEquals(products, text);
	}

	public void clickProductCategory() {

		Emmie_Driver.clickProductFromList(categoriesList, Emmie_Driver.getProperty("Android"));

	}

	public void verifyPrices() {
		
		System.out.println("Price after moved filter : " + Emmie_Driver.getDouble(priceTag));
		Assert.assertTrue(Emmie_Driver.getDouble(priceTag) <= 450);
		

	}
	
	public void selectSortingPopularity() {
		Select select = new Select(defaultSorting);
		select.selectByVisibleText("Sort by popularity");	
		
	}
	public void selectSortingAveRating() {
		Select select = new Select(defaultSorting);
		select.selectByVisibleText("Sort by average rating");	
		
	}
	public void selectSortingNewness() {
		Select select = new Select(defaultSorting);
		select.selectByVisibleText("Sort by newness");	
		
	}
	public void selectSortingLowToHigh() {
		Select select = new Select(defaultSorting);
		select.selectByVisibleText("Sort by price: low to high");	
		
	}
	public void selectSortingHighToLow() {
		Select select = new Select(defaultSorting);
		select.selectByVisibleText("Sort by price: high to low");	
		
	}
	
	
	
}

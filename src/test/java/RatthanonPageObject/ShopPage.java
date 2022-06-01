package RatthanonPageObject;

import java.util.List;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import RatthanonUtilities.BaseClassR;

public class ShopPage {
	
public WebDriver driver = BaseClassR.getDriver();
	
	
	int adjustPrice;
	
	
	public ShopPage() {
		
		//this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//div[@id='content']/nav/a")
	public WebElement HomeMenu;
	
	@FindBy(xpath="//div[@class='price_slider_wrapper']/div/span[2]")
	public WebElement slidePrice;
	
	@FindBy(xpath="//*[@id='woocommerce_price_filter-2']/form/div/div[1]/span[2]")
	public WebElement slidePrice2;
	
	@FindBy(xpath="//div[@class='price_label']")
	public WebElement textPrice;
	
	@FindBy(xpath="//div[@class='price_slider_amount']/button")
	public WebElement filterButton;
	

	@FindBy(xpath="//*[@id=\"content\"]/ul/li[1]/a[1]/span[2]/ins/span")
	public WebElement bookHighestPrice;
	
	
	@FindBy(xpath="//form[@class='woocommerce-ordering']/select")
	public WebElement SelectFilter;
	
	@FindBy(xpath="//li[@class='cat-item cat-item-21']/a")
	public WebElement linkproduct;
	
	@FindBy(xpath="//a[@data-product_id='160']")
	public WebElement readmoreButton;
	
	
	@FindBy(xpath="//div[@class='summary entry-summary']/p")
	public WebElement itemprice;
	
	@FindBy(xpath="//ul[@class='products masonry-done']/li[1]")
	public WebElement itemsale;
	
	
	@FindBy(xpath="//div[@id='product-169']/span[@class='onsale']")
	public WebElement itemonsale;
	
	
	
	/*
	 * public WebElement ItemOnSale() {
	 * 
	 * return itemonsale;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * public WebElement ItemSale() {
	 * 
	 * return itemsale;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * public WebElement ItemPrice() {
	 * 
	 * return itemprice;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public WebElement ReadmoreButton() {
	 * 
	 * return readmoreButton;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * 
	 * public WebElement LinkProduct() {
	 * 
	 * return linkproduct;
	 * 
	 * }
	 * 
	 * 
	 * public WebElement FilterButton() {
	 * 
	 * return filterButton;
	 * 
	 * }
	 * 
	 * 
	 * 
	 * public WebElement homeMenu() {
	 * 
	 * return HomeMenu;
	 * 
	 * }
	 * 
	 * public WebElement SlidePrice() {
	 * 
	 * return slidePrice;
	 * 
	 * }
	 * 
	 * public WebElement SlidePrice2() {
	 * 
	 * return slidePrice2;
	 * 
	 * }
	 * 
	 * public WebElement TextPrice() {
	 * 
	 * return textPrice;
	 * 
	 * }
	 */
	public void SlideTabPriceRight(int price) {
		
		int maxPriceR =  500;
		adjustPrice = price;
		int adjustPrice = 500 - price;
		
		
		for (int i = 1; i <= 50 ; i++) {
			slidePrice2.sendKeys(Keys.ARROW_LEFT);
        }
		
	}
	
	public void SelectSorting(String str) {
		Select sl = new Select(SelectFilter);
		sl.selectByValue(str);		
		
	}
	
	public double verifyBookPrice() {		
		Select sl = new Select(SelectFilter);
		sl.selectByValue("price-desc");
		return Double.parseDouble(bookHighestPrice.getText().substring(1));
		
	}
	
	
	
	
	
	

}

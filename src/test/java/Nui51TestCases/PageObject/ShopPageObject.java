package Nui51TestCases.PageObject;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import NuiUtilities.Driver;
import NuiUtilities.NuiConfigurationProperties;

public class ShopPageObject {
	
	WebDriver driver = Driver.getDriver();

	public ShopPageObject() {
		PageFactory.initElements(driver, this); 
	}
	
	@FindBy (xpath = "//a[contains(text(),\"Home\")]")
	public WebElement clickHome;
	
	@FindBy (xpath = "//*[@id='content']/ul/li[2]/a[2]")
	public WebElement programBookAddToBasketBtn;
	
	@FindBy (xpath = "//*[@id='woocommerce_product_categories-2']/ul/li[2]/a")
	public WebElement htmlCategoryBtn;
	
	@FindBy (xpath = "//*[@id='content']/form/select")
	public WebElement sortingDropdown;

	@FindBy (xpath = "//*[@id='woocommerce_price_filter-2']/form/div/div[1]/span[2]")
	public WebElement slider;
	
	@FindBy (xpath = "//*[@id='woocommerce_price_filter-2']/form/div/div[2]/button")
	public WebElement filterBtn;
	
	@FindBy (xpath = "//*[@id='content']/ul/li[1]/a[1]/span[2]/ins/span")
	public WebElement highestPriceTxt;
	
	@FindBy (xpath = "//*[@id='content']/ul/li[1]/a[1]/img")
	public WebElement saleBook;
	
	@FindBy (xpath = "//*[@id='content']/ul/li[2]/a[2]")
	public WebElement buyBook;
	
	@FindBy (xpath = "//*[@class='cartcontents']")
	public WebElement itemInCart;
	
	@FindBy (xpath = "//*[@class='amount']")
	public WebElement priceInCart;
	
	@FindBy (xpath = "//*[@id='content']/ul/li[2]/a[3]")
	public WebElement viewBasketBtn;
	

	
	
	public void verifyItemAndPriceInCart() {
		Assert.assertTrue(itemInCart.getText().equals(NuiConfigurationProperties.getKeyValue("expectedOneItem")));
		Assert.assertTrue(priceInCart.getText().substring(1).equals(NuiConfigurationProperties.getKeyValue("expectedPrice")));
	}
	
	
	public void selectByHighToLowAndVerify() throws InterruptedException {
		
		Select type = new Select(sortingDropdown);
		type.selectByValue(NuiConfigurationProperties.getKeyValue("sortHighToLow"));
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains(NuiConfigurationProperties.getKeyValue("cfSortByHighToLow")));
	}
	
	public void selectByLowToHighAndVerify() throws InterruptedException {
		
		Select type = new Select(sortingDropdown);
		type.selectByValue(NuiConfigurationProperties.getKeyValue("sortLowToHigh"));
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains(NuiConfigurationProperties.getKeyValue("cfSortByLowToHigh")));
	}
	
	public void selectByNewnessAndVerify() throws InterruptedException {
		
		Select type = new Select(sortingDropdown);
		type.selectByValue(NuiConfigurationProperties.getKeyValue("sortNewness"));
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains(NuiConfigurationProperties.getKeyValue("cfSortByNewness")));
	}
	
	public void selectByRatingAndVerify() throws InterruptedException {
		
		Select type = new Select(sortingDropdown);
		type.selectByValue(NuiConfigurationProperties.getKeyValue("sortRating"));
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains(NuiConfigurationProperties.getKeyValue("cfSortByRating")));
	}
	
	public void selectByPopularityAndVerify() throws InterruptedException {
		
		Select type = new Select(sortingDropdown);
		type.selectByValue(NuiConfigurationProperties.getKeyValue("sortPopularity"));
		Thread.sleep(2000);
		Assert.assertTrue(driver.getCurrentUrl().contains(NuiConfigurationProperties.getKeyValue("cfSortByPopularity")));
	}

	public void selectByFilterAndVerify() throws InterruptedException {
		
		Select type = new Select(sortingDropdown);
		type.selectByValue(NuiConfigurationProperties.getKeyValue("sortHighToLow"));
		Thread.sleep(3000);
		double highPrice = Double.parseDouble(highestPriceTxt.getText().substring(1));
		double desirePrice = Double.parseDouble(NuiConfigurationProperties.getKeyValue("desirePrice"));
		//check if it is now show the book up to 450
		Assert.assertTrue(highPrice <= desirePrice);	
	}
	
	public void moveSlider() {
	
		for (int i = 1; i <= 50 ; i++) {
          slider.sendKeys(Keys.ARROW_LEFT);
      }
	}

	

}

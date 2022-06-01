package MeenaObject;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import MeenaUtilities.MeenaDriver;

public class shopPage {

	public shopPage() {
		
		PageFactory.initElements(MeenaDriver.getDriver(), this);

		}
		
		@FindBy(xpath = "//*[text()='Home']")
	 	public WebElement homeBtn;

		@FindBy(xpath = "//*[text()='Shop']")
		public WebElement shopBtn;

		@FindBy(xpath = "//*[@id='woocommerce_price_filter-2']/form/div/div[1]/span[2]")
		public WebElement filterSlider;

		@FindBy(xpath = "//*[@id='woocommerce_price_filter-2']/form/div/div[2]/button")
		public WebElement filterBtn;

		@FindBy(xpath = "//*[@id='content']/ul/li[1]/a[1]/span[2]/ins/span")
		public WebElement verifyPrice;

		@FindBy(xpath="//*[@id='woocommerce_product_categories-2']/ul/li[3]/a")
		public WebElement productCategories;

		@FindBy (xpath="//*[@id='content']/nav")
		public WebElement javaScript;
		
		@FindBy (xpath="//select[@name='orderby']")
		public WebElement defaultSorting;
		
		
		@FindBy(xpath="//*[@id='content']/form/select")
		public WebElement sortingDropDown;
		
		@FindBy(xpath="//*[@id='content']/form/select/option[2]")
		public WebElement verifySort;
		
		@FindBy(xpath="//*[@id='content']/ul/li[1]/a[1]/img")
		public WebElement onSaleProduct;
		
		@FindBy(xpath="//*[@class='price']/del/span")
		public WebElement originalPrice;
		
		@FindBy(xpath="//*[@class='price']/ins/span")
		public WebElement onSalePrice;
		
		
		public void setup() {
			
			shopBtn.click();
		}

		public void moveFilter() {
			
			WebElement slider = filterSlider;
			for (int i = 1; i <= 50; i++) {
				slider.sendKeys(Keys.ARROW_LEFT);
			}
		}
		
		public void verifyValue() {
			
			// checkBookValue
			String priceText = verifyPrice.getText();
			Assert.assertTrue(priceText.contains("450"));
			System.out.println(priceText);
			
		}

		public void verifyChosenProductCategority() {

			// check if showing only chosen category
			String text = javaScript.getText();
			Assert.assertTrue(text.contains(MeenaDriver.getProperty("productCategory")));
			
			System.out.println(text);
		}

		public void selectSortingPopularity() throws InterruptedException {
			
			Select poplarity = new Select(sortingDropDown);
			
			poplarity.selectByValue("popularity");
			Thread.sleep(2000);
		}
		
		public void verifyPopularity()	{
			String expectedText = MeenaDriver.getProperty("verifyPopularityText");
			Assert.assertTrue(MeenaDriver.getDriver().getCurrentUrl().contains(expectedText));
			System.out.println(expectedText);
		}
		
		public void selectSortingAverage() throws InterruptedException {
					
			Select average = new Select(sortingDropDown);
			average.selectByValue("rating");
			Thread.sleep(2000);
					
		}
		
		public void verifyAverage()	{
			String expectedText = MeenaDriver.getProperty("verifyAverageText");
			Assert.assertTrue(MeenaDriver.getDriver().getCurrentUrl().contains(expectedText));
			System.out.println(expectedText);
			
		}
		
		public void selectSortingNewness() throws InterruptedException {
				
			Select newness = new Select(sortingDropDown);
			newness.selectByValue("date");
			Thread.sleep(2000);
		
		}
		
		public void verifyNewness()	{
			String expectedText = MeenaDriver.getProperty("verifyNewnessText");
			Assert.assertTrue(MeenaDriver.getDriver().getCurrentUrl().contains(expectedText));
			System.out.println(expectedText);
			
		}
		public void selectSortingPriceLowToHigh() throws InterruptedException {
			
			
			Select priceLowToHigh = new Select(sortingDropDown);
			priceLowToHigh.selectByValue("price");
			Thread.sleep(2000);
		}
		
		public void verifyPriceLowToHigh()	{
			String expectedText = MeenaDriver.getProperty("verifyPriceLowToHigh");
			Assert.assertTrue(MeenaDriver.getDriver().getCurrentUrl().contains(expectedText));
			System.out.println(expectedText);
		}
		

		public void selectSortingPriceHighToLow() throws InterruptedException {
		
			Select priceHighToLow = new Select(sortingDropDown);
			priceHighToLow.selectByValue("price-desc");
			Thread.sleep(2000);
		
		}
		
		public void verifyPriceHighToLow()	{

			String expectedText = MeenaDriver.getProperty("verifyPriceHighToLow");
			Assert.assertTrue(MeenaDriver.getDriver().getCurrentUrl().contains(expectedText));
			
			System.out.println(expectedText);
		}
		

		public void verifyOnSalePrice() {
			String original = originalPrice.getText();
			Assert.assertTrue(originalPrice.isDisplayed());
			
			String onSale = onSalePrice.getText();
			Assert.assertTrue(onSalePrice.isDisplayed());
		

			System.out.println(original);
			System.out.println(onSale);
		}
		
		public void tearDown() {
			MeenaDriver.tearDown();
		}
		
		
	
	
	
	
}

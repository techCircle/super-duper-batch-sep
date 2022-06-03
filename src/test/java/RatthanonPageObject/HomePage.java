package RatthanonPageObject;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import RatthanonUtilities.Constants_ratthanon;
import RatthanonUtilities.BaseClassR;


public class HomePage {
	
	public WebDriver driver = BaseClassR.getDriver();
	String titleweb[] = {"selenium-ruby","thinking-in-html","mastering-javascript"};
		
			
		
		public HomePage() {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//li[@id='menu-item-40']/a")
		public WebElement ShopMenu;
		
		@FindBy(xpath="//img[contains(@class,'n2-ss-slide-background-image')]")
		public List<WebElement> SlidepPicture;
		
		@FindBy(xpath="//ul[@class='products']/li")
		public List<WebElement> bookArrivals;
		
		@FindBy(xpath="//li[contains(@class,'description_tab')]")
		public WebElement descriptionBooktab;
		
		@FindBy(xpath="//div[@id='tab-description']")
		public WebElement descriptiontext;
		
		@FindBy(xpath="//li[contains(@class,'reviews_tab')]")
		public WebElement reviewBooktab;

		
		@FindBy(xpath="//div[@id='reviews']")
		public WebElement reviewtext;
		
		@FindBy(xpath="//ul[@id='main-nav']/li[2]")
		public WebElement MyAccountMenu;
		
		
		@FindBy(xpath="//*[@id='text-22-sub_row_1-0-2-1-0']/div/ul/li/a[2]")
		public WebElement ReadMoreButton;
		
		
		@FindBy(xpath="//*[@id='product-163']/div[5]/ul/li[1]/a[2]")
		public WebElement AddToBasketButton;
		
		
		@FindBy(xpath="//*[@id='product-181']/div[2]/form/button")
		public WebElement AddToBasketButton2;
		
		@FindBy(xpath="//*[@id='wpmenucartli']/a/span[1]")
		public WebElement itemNumberbusket;
		
		//@FindBy(xpath="//*[@id='product-163']/div[5]/ul/li[1]/a[3]")
		@FindBy(xpath="//a[text()='View Basket']")
		public WebElement viewbusket;
		
		
		@FindBy(xpath="//*[@id='product-163']/div[5]/ul/li[1]/a[1]/h3")
		public WebElement itemNametoAdd;
		
		@FindBy(xpath="//li[@id='wpmenucartli']/a/span[2]")
		public WebElement itemPrice;
		
		@FindBy(xpath="(//span[@class='price'])[1]")
		public WebElement showPriceproduct;
		
		
		
		
		
		
		public void verifyAddBusket() throws InterruptedException {
			ReadMoreButton.click();
			AddToBasketButton.click();
			Thread.sleep(1000);
			//Assert.assertEquals(itemPrice.getText(), showPriceproduct.getText());
			//Double price = Double.parseDouble(itemPrice.getText().substring(1)); 
			Assert.assertEquals(viewbusket.getText(), "View Basket");			
		}
		
		public void verifyClickItem() throws InterruptedException {
			itemPrice.click();
			Assert.assertTrue(BaseClassR.getDriver().getCurrentUrl().contains("basket"));
			//viewbusket.click();
		}
		
		
		
		public int slidePicture() {

			return SlidepPicture.size();

		}
		
		public int BookArrivals() {

			return bookArrivals.size();

		}
		
			
		
		
		public void ClickAbleImage() throws InterruptedException {
			int j = 0;

			for (int i = 1; i <= Constants_ratthanon.slidersCount; i++) {
				String xpathFormat = "(//ul[@class='products']/li)" + "[" + i + "]";
				WebElement links = driver.findElement(By.xpath(xpathFormat));
				links.click();
				Thread.sleep(1000);
				Assert.assertTrue(driver.getCurrentUrl().contains(titleweb[j]));	
				
				driver.navigate().back();
				// Thread.sleep(3000);
				j++;
			}
		}
		
		public void VerifyDescription() throws InterruptedException {
			int j = 0;

			for (int i = 1; i <= Constants_ratthanon.titleweb.length; i++) {
				String xpathFormat = "(//ul[@class='products']/li)" + "[" + i + "]";
				WebElement links = driver.findElement(By.xpath(xpathFormat));
				links.click();

				Assert.assertTrue(driver.getCurrentUrl().contains(titleweb[j]));
				Thread.sleep(1000);
				descriptionBooktab.click();
				Assert.assertTrue(descriptiontext.isDisplayed());
				
				
				driver.navigate().back();
				// Thread.sleep(3000);
				j++;
			}
		}
		
		
		public void ValidateReview() throws InterruptedException {
			int j = 0;

			for (int i = 1; i <= 3; i++) {
				String xpathFormat = "(//ul[@class='products']/li)" + "[" + i + "]";
				WebElement links = driver.findElement(By.xpath(xpathFormat));
				links.click();
				Assert.assertTrue(driver.getCurrentUrl().contains(titleweb[j]));
				reviewBooktab.click();
				Thread.sleep(2000);
				Assert.assertTrue(reviewtext.isDisplayed());
				
				

				driver.navigate().back();
				// Thread.sleep(1000);
				j++;
			}
		}
		
		

}

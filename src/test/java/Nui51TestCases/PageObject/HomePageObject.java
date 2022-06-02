package Nui51TestCases.PageObject;

import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import NuiUtilities.Driver;
import NuiUtilities.NuiConfigurationProperties;

public class HomePageObject {
	

	WebDriver driver = Driver.getDriver();
	CommonPageObject cpo = new CommonPageObject();
	ProductPageObject pp = new ProductPageObject();
	BasketPageObject bp = new BasketPageObject();
	WebDriverWait wait;

	public HomePageObject() {
		PageFactory.initElements(driver, this); 
	}
	
	
	@FindBy (xpath = "//div[@class='n2-ss-slider-3']/div")
	public List<WebElement> threeSliders; 
	
	@FindBy (xpath = "//h2[contains(text(),'new arrivals')]/../../../../../div/div[2]/div")
	public List<WebElement> newArrivals;
	
	@FindBy (xpath = "//*[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a[1]/img")
	public WebElement firstBook;
	
	@FindBy (xpath = "//*[@id='text-22-sub_row_1-0-2-1-0']/div/ul/li/a[1]/img")
	public WebElement secondBook;
	
	@FindBy (xpath = "//*[@id='text-22-sub_row_1-0-2-2-0']/div/ul/li/a[1]/img")
	public WebElement thirdBook;
	
	@FindBy (xpath = "//*[@id='tab-description']/h2")
	public WebElement firstBookDescription;
	
	@FindBy (xpath = "//*[@id='product-163']/div[3]/ul/li[1]/a")
	public WebElement secondBookDescription;
	
	@FindBy (xpath = "//*[@id='tab-description']/h2")
	public WebElement thirdBookDescription;
	
	@FindBy (xpath = "//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div")
	public List<WebElement> arrivalsImgs;
	
	@FindBy (xpath = "//*[@id='product-160']/div[3]/ul/li[2]/a")
	public WebElement firstBookReviewBtn;
	
	@FindBy (xpath = "//*[@id='product-163']/div[3]/ul/li[2]/a")
	public WebElement secondBookReviewBtn;
	
	@FindBy (xpath = "//*[@id='product-165']/div[3]/ul/li[2]/a")
	public WebElement thirdBookReviewBtn;
	
	@FindBy (xpath = "//h2[@class='woocommerce-Reviews-title']")
	public WebElement reviewTxt;
	
	@FindBy (xpath = "//*[@id='product-163']/div[5]/ul/li[1]/a[1]")
	public WebElement htmlBook;
	
	@FindBy (xpath = "//*[@class='product_title entry-title']/../div/p/span")
	public WebElement price;

	@FindBy (xpath = "//*[@id='wpmenucartli']/a/span[2]")
	public WebElement priceInCart;
	
	@FindBy (xpath = "//*[@class='quantity']/input ")
	public WebElement numMax;
	
	@FindBy (xpath = "//form/div/input")
	public WebElement QtyBox;
	
	@FindBy (xpath = "//*[@id='text-22-sub_row_1-0-2-0-0']/div/ul/li/a[2]")
	public WebElement readMoreBtn;
	
	
	public void addMoreThanMaxBookAndVerifyErrMsg() {
		
		String getMax = numMax.getAttribute("Max");
		int moreThanMax = Integer.valueOf(getMax)+1;
		QtyBox.clear();
		QtyBox.sendKeys(String.valueOf(moreThanMax));
		pp.addToBasketBtn.click();
		
		//Check if there is an error message pop up (using javascript)
		WebElement ele = driver.findElement(By.xpath("//form/div/input"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Boolean isValidInput = (Boolean)js.executeScript("return arguments[0].checkValidity();", ele);
		System.out.println(isValidInput);
		String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", ele);
		System.out.println(validationMessage);
		
		Assert.assertFalse(isValidInput);
		String alert = String.format("Value must be less than or equal to %d.", Integer.valueOf(getMax));
		Assert.assertTrue(validationMessage.equals(alert));
	}
	
	public void verifyThreeSliders() {
		Assert.assertTrue(threeSliders.size()== Integer.parseInt(NuiConfigurationProperties.getKeyValue("sliders")));
	}
	
	public void verifyThreeNewArrivals() {
		Assert.assertTrue(newArrivals.size()== Integer.parseInt(NuiConfigurationProperties.getKeyValue("newArr")));
	}
	
	public void verifyAlreadyLogin() {
		String signOut = "Sign out";
		Assert.assertTrue(cpo.logout.getText().equals(signOut));
	}
	
	public void verifyThreeBookDescription() {
		firstBook.click();
		Assert.assertTrue(firstBookDescription.isDisplayed());
		driver.navigate().back();
		secondBook.click();
		Assert.assertTrue(secondBookDescription.isDisplayed());
		driver.navigate().back();
		thirdBook.click();
		Assert.assertTrue(thirdBookDescription.isDisplayed());
		driver.navigate().back();	
	}
	
	public void verifyImagesInArrivalsShouldNavigate() {
		String[] expectedTexts = new String[]{"Selenium Ruby", "Thinking in HTML", "Mastering JavaScript"};
		for(int i = 0; i<arrivalsImgs.size(); i++) {
			
			String pathText = String.format("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[%d]", i+1);
			System.out.println(pathText);
			driver.findElement(By.xpath(pathText)).click();
		
			String text = driver.findElement(By.xpath("//*[@class='product_title entry-title']")).getText();
			System.out.println(text);
			Assert.assertTrue(expectedTexts[i].equals(text)) ;					
			driver.navigate().back();			
		}		
	}
	
	public void verifyArrivalsImgReview() {
		firstBook.click();
		firstBookReviewBtn.click();
		Assert.assertTrue(reviewTxt.isDisplayed());
		driver.navigate().back();
		
		secondBook.click();
		secondBookReviewBtn.click();
		Assert.assertTrue(reviewTxt.isDisplayed());
		driver.navigate().back();
		
		thirdBook.click();
		thirdBookReviewBtn.click();
		Assert.assertTrue(reviewTxt.isDisplayed());
		driver.navigate().back();	
	}
	
	public void addToBasket() {
		secondBook.click();
		htmlBook.click();
		//check and keep the price to compare after add to basket
		price.getText();
		pp.addToBasketBtn.click();	
	}
	
	public void verifyCorrectBookAndPriceInBasket() throws InterruptedException {
		String inCartPrice = priceInCart.getText();
		String expectedPrice = price.getText();
		System.out.println(inCartPrice + " " + expectedPrice);
		Assert.assertTrue(inCartPrice.equals(expectedPrice));
		//bp.removeX.click();
//		cpo.cartLink.click();
//		driver.findElement(By.xpath("//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[5]/div/input")).clear();
//		bp.updateBasketBtn.click();
	}
	

}

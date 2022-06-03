package MeenaObject;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import MeenaUtilities.MeenaDriver;

public class homePage {


	public homePage() {
		
		PageFactory.initElements(MeenaDriver.getDriver(), this);
		

	}
	@FindBy(xpath = "//*[text()='Shop']")
 	public WebElement shopBtn;

 	@FindBy(xpath = "//*[text()='Home']")
 	public WebElement homeBtn;
	
 	@FindBy(xpath = "//*[@id=\"n2-ss-6\"]/div[1]/div/div/div")
	public List<WebElement> sliders;

	@FindBy(xpath = "//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div")
	public List<WebElement> arrivals;
	
	@FindBy(xpath="//img[@title='Selenium Ruby']")
	public WebElement firstPic;
	
	@FindBy(xpath="//img[@title='Thinking in HTML']")
	public WebElement secondPic;

	@FindBy(xpath="//img[@title='Mastering JavaScript']")
	public WebElement thirdPic;
	
	@FindBy(xpath="//*[@class='product_title entry-title']")
	public WebElement bookTitle;
	
	@FindBy(xpath = "//*[@id='tab-description']/h2")
 	public WebElement descriptionText;
	
	@FindBy(xpath = "//*[@class='reviews_tab']/a")
 	public WebElement reviewTab;

 	@FindBy(xpath = "//*[@id='commentform']/p[3]/label")
 	public WebElement reviewText;
 	
 	@FindBy (xpath="//*[@id='product-165']/div[5]/ul/li[1]/a[2]")
 	public WebElement addToBasket;
	
 	@FindBy(xpath="//*[@id='product-165']/div[5]/ul/li[1]/a[3]")
 	public WebElement viewBasketText;
	
 	@FindBy(xpath="//*[@class='products']/li/a[2]")
	public WebElement readMore;
 	
 	@FindBy(xpath="//*[@id='product-160']/div[2]/p")
	public WebElement verifyOutOfStock;
	
	@FindBy(xpath="//*[@id='wpmenucartli']/a/span[1]")
	public WebElement verifyBasket;
	
	
	public void checkSlidersCount(int count) {

		Assert.assertEquals(count, sliders.size());
	}

	public void checkArrivalsCount(int count) {

		Assert.assertEquals(count, arrivals.size());
	}

	public void verifyImagesInArrivalsShouldNavigate() {
		
        String[] expectedTexts = new String[]{"Selenium Ruby", "Thinking in HTML", "Mastering JavaScript"};
        
        for(int i = 0; i<arrivals.size(); i++) {
            
            String pathText = String.format("//div[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div[%d]", i+1);
//            System.out.println(pathText);
            MeenaDriver.getDriver().findElement(By.xpath(pathText)).click();
        
            String text = MeenaDriver.getDriver().findElement(By.xpath("//*[@class='product_title entry-title']")).getText();
          //  System.out.println(text);
            Assert.assertTrue(expectedTexts[i].equals(text)) ;                    

			MeenaDriver.getDriver().navigate().back();
      }
	}

	public void verifyImagesInArrivalsShouldNavigate_URL() {
		String url1 = "http://practice.automationtesting.in/product/selenium-ruby/";
		String url2 = "http://practice.automationtesting.in/product/thinking-in-html/";
		String url3 = "http://practice.automationtesting.in/product/mastering-javascript/";

		List<String> urls = new ArrayList<String>();

		urls.add(url1);
		urls.add(url2);
		urls.add(url3);

		for (int i = 0; i < arrivals.size(); i++) {

			WebElement eachItem = arrivals.get(i);

			eachItem.click();

			Assert.assertTrue(MeenaDriver.getDriver().getCurrentUrl().equalsIgnoreCase(urls.get(i)));

			MeenaDriver.getDriver().navigate().back();
		}
	}
	
	public void verifyPicDescription() {
			
		String firstDescription = descriptionText.getText();
		Assert.assertTrue(firstDescription.contains("Product Description"));
			
		MeenaDriver.getDriver().navigate().back();
			
		secondPic.click();
		String secondDescription = descriptionText.getText();
		Assert.assertTrue(secondDescription.contains("Product Description"));
			
		MeenaDriver.getDriver().navigate().back();
			
		thirdPic.click();
		String thirdDescription = descriptionText.getText();
		Assert.assertTrue(thirdDescription.contains("Product Description"));
		}
		
	public void clickReviewTap() {
			
		
		String firstReview = reviewText.getText();
		Assert.assertTrue(firstReview.contains("Your Review"));
			
		MeenaDriver.getDriver().navigate().back();
			
		secondPic.click();
		reviewTab.click();
		String secondReview = reviewText.getText();
		Assert.assertTrue(secondReview.contains("Your Review"));
			
		MeenaDriver.getDriver().navigate().back();

		thirdPic.click();
		reviewTab.click();
		String thirdReview = reviewText.getText();
		Assert.assertTrue(thirdReview.contains("Your Review"));
		}
		
	public void addToBasket() {
			
		shopBtn.click();
		homeBtn.click();
		thirdPic.click();
		//arrivalsPage		addToBasket.click();
		String verifyAddToBasket = viewBasketText.getText();
		Assert.assertTrue(verifyAddToBasket.contains("View Basket"));
	}
	
	
	
	
	









	public void readMoreFunction() {		

	//Indicate out of stock
		String text = verifyOutOfStock.getText();
//	System.out.println(text);
		String expectedText = MeenaDriver.getProperty("outOfStockExpectedText");
		Assert.assertTrue(text.equals(expectedText));
	}	
	
	//out of stock item cannot be add to the basket so verify after clicking that item does not add to the basket
	public void verifyItemCanNotBeAdd() {
		String itemInBasket =verifyBasket.getText();
//	System.out.println(itemInBasket);
		String expectedNumItem = MeenaDriver.getProperty("expectedItem");
		Assert.assertTrue(itemInBasket.equals(expectedNumItem));
	
}
	
}

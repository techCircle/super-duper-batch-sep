package kanokwanPageObject;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import kanokwanUtilities.KanokwanBaseClass;



public class homePage {
	
	public homePage() {
		
		PageFactory.initElements(KanokwanBaseClass.getDriver(), this);
	}
	
	//Click on Shop menu
	@FindBy(id = "menu-item-40")
	public WebElement shopButton;
	
	//click on Home menu button
	@FindBy(xpath = "//*[@id=\"content\"]/nav/a")
	public WebElement homeButton;
	
	//Home page has Three Sliders only
	@FindBy(xpath = "//*[@id=\"n2-ss-6\"]/div[1]/div/div/div")
	public List<WebElement> sliders;
		
	@FindBy(xpath = "//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div")
	public List<WebElement> arrivals;
	
	//picture1
	@FindBy(xpath = "//*[@id='text-22-sub_row_1-0-2-0-0']")
	public WebElement seleniumRuby;
	
	//picture2
	@FindBy(xpath = "//*[@id='text-22-sub_row_1-0-2-1-0']")
	public WebElement ThinkingInHTML;
	
	//picture3
	@FindBy(xpath = "//*[@id='text-22-sub_row_1-0-2-2-0']")
	public WebElement MasteringJavaScript;
	
	//verify picture1
	@FindBy(xpath = "//*[contains(text(),'Selenium Ruby') and@class='product_title entry-title']")
	public WebElement seleniumRubyText;
	
	@FindBy(xpath = "//img[@title='Selenium Ruby']")
	public WebElement seleniumRubyImg;
	
	//verify picture2
	@FindBy(xpath = "//*[contains(text(),'Thinking in HTML') and@class='product_title entry-title']")
	public WebElement ThinkingInHTMLText;
	
	@FindBy(xpath = "//img[@title='Thinking in HTML']")
	public WebElement ThinkingInHTMLImg;
	
	//verify picture3
	@FindBy(xpath = "//*[contains(text(),'Mastering JavaScript') and@class='product_title entry-title']")
	public WebElement MasteringJavaScriptText;
	
	@FindBy(xpath = "//img[@title='Mastering JavaScript']")
	public WebElement MasteringJavaScriptImg;
	
	@FindBy(xpath = "//*[@class='description_tab active']")
	public WebElement descriptionButton;
	
	@FindBy(xpath = "//*[@id=\"tab-description\"]/h2")
	public WebElement descriptionText;
	
	@FindBy(xpath = "//*[@class='reviews_tab']")
	public WebElement reviewsButton;
	
	@FindBy(xpath = "//*[@id=\"comments\"]/h2")
	public WebElement reviewsText;
	

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
          //System.out.println(pathText);
          KanokwanBaseClass.getDriver().findElement(By.xpath(pathText)).click();
        
          String text = KanokwanBaseClass.getDriver().findElement(By.xpath("//*[@class='product_title entry-title']")).getText();
          //System.out.println(text);
          Assert.assertTrue(expectedTexts[i].equals(text)) ;                    
          KanokwanBaseClass.getDriver().navigate().back();            
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

			Assert.assertTrue(KanokwanBaseClass.getDriver().getCurrentUrl().equalsIgnoreCase(urls.get(i)));

			KanokwanBaseClass.getDriver().navigate().back();
		}
	}

	public void shopButton() {
		shopButton.click();
	}
	
	public void homeButton() {
		homeButton.click();
	}

	public void verifyNewArrivalsDescription() {
		seleniumRubyImg.click();
		descriptionButton.click();
		Assert.assertTrue(descriptionText.isDisplayed());
		KanokwanBaseClass.driver.navigate().back();

		ThinkingInHTMLImg.click();
		descriptionButton.click();
		Assert.assertTrue(descriptionText.isDisplayed());
		KanokwanBaseClass.driver.navigate().back();

		MasteringJavaScriptImg.click();
		descriptionButton.click();
		Assert.assertTrue(descriptionText.isDisplayed());
		KanokwanBaseClass.driver.navigate().back();
	}

	public void verifyNewArrivalsReviews() {
		seleniumRubyImg.click();
		reviewsButton.click();
		Assert.assertTrue(reviewsText.isDisplayed());
		KanokwanBaseClass.driver.navigate().back();

		ThinkingInHTMLImg.click();
		reviewsButton.click();
		Assert.assertTrue(reviewsText.isDisplayed());
		KanokwanBaseClass.driver.navigate().back();

		MasteringJavaScriptImg.click();
		reviewsButton.click();
		Assert.assertTrue(reviewsText.isDisplayed());
		KanokwanBaseClass.driver.navigate().back();
	}
}

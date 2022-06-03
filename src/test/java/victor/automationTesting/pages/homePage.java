package victor.automationTesting.pages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import victor.utilities.Victor_BaseClass;
import victor.utilities.Victor_Constants;

public class homePage {
	
	
	public homePage() {
		PageFactory.initElements(Victor_BaseClass.getDriver(), this);
		
	}
	
	
	@FindBy (id="menu-item-40")
	public WebElement shopbutton;
	
	@FindBy (xpath="//*[@id=\"n2-ss-6\"]/div[1]/div/div/div")
	public List<WebElement> sliders;
	
	@FindBy(xpath = "//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div")
	public List<WebElement> arrivals;
	
	@FindBy (xpath= "//*[contains(@class,'description_tab active')]")
	public WebElement description;
	
	@FindBy (xpath= "//*[contains(@class,'reviews_tab')]")
	public WebElement reviews;
	
	@FindBy (xpath = "//*/button[@type='submit']")
	public WebElement AddToBasket;
	
	
	
	
	public void checkSlidersCount(int count) {
	Assert.assertEquals(count, sliders.size());
	}
	
	public void checkArrivalsCount(int count) {
		Assert.assertEquals(count, arrivals.size());
		}
	
	public void VerifyImagesInArrivalsShouldNavigate () {
	
	List<String> urls = new ArrayList<>(Arrays.asList(Victor_Constants.url1,Victor_Constants.url2,Victor_Constants.url3));
	
	for (int i = 0; i< arrivals.size(); i++) {
		WebElement eachItem = arrivals.get(i);
		eachItem.click();
		Assert.assertTrue(Victor_BaseClass.getDriver().getCurrentUrl().equalsIgnoreCase(urls.get(i)));
		
		Victor_BaseClass.getDriver().navigate().back();
		}
	}
	
	public void VerifyImagesInArrivalsShouldNavigateWithDescription () {
		
		List<String> urls = new ArrayList<>(Arrays.asList(Victor_Constants.url1,Victor_Constants.url2,Victor_Constants.url3));
		
		for (int i = 0; i< arrivals.size(); i++) {
			WebElement eachItem = arrivals.get(i);
			eachItem.click();
			Assert.assertTrue(Victor_BaseClass.getDriver().getCurrentUrl().equalsIgnoreCase(urls.get(i)));
			description.click();
			System.out.println(description.getText().toString());	
			Victor_BaseClass.getDriver().navigate().back();
			}
		}
	
	public void VerifyImagesInArrivalsShouldNavigateWithReviews () {
		
		List<String> urls = new ArrayList<>(Arrays.asList(Victor_Constants.url1,Victor_Constants.url2,Victor_Constants.url3));
		
		
		for (int i = 0; i< arrivals.size(); i++) {
			WebElement eachItem = arrivals.get(i);
			eachItem.click();
			Assert.assertTrue(Victor_BaseClass.getDriver().getCurrentUrl().equalsIgnoreCase(urls.get(i)));
			reviews.click();
			System.out.println(reviews.getText().toString());	
			Victor_BaseClass.getDriver().navigate().back();
			}
		}
	
	public void VerifyAddToBasketButtonEnable () {
		
		List<String> urls = new ArrayList<>(Arrays.asList(Victor_Constants.url1,Victor_Constants.url2,Victor_Constants.url3));
		
		for (int i = 0; i< arrivals.size(); i++) {
			WebElement eachItem = arrivals.get(i);
			eachItem.click();
			Assert.assertTrue(Victor_BaseClass.getDriver().getCurrentUrl().equalsIgnoreCase(urls.get(i)));
			
			if (AddToBasket.isSelected()) {
				AddToBasket.click();
			}
			Victor_BaseClass.getDriver().navigate().back();
			}
		}
		
	
}

package victor.automationTesting.pages;



import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import victor.utilities.Victor_BaseClass;

public class shopPage {
	public shopPage() {
		PageFactory.initElements(Victor_BaseClass.getDriver(), this);
		
	}
	
	
	@FindBy (xpath="//*[@id='content']/nav/a")
	public WebElement homeButton;
	
	
	@FindBy (xpath= "//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/span[2]")
	public WebElement Slider;
	
	@FindBy (xpath = "//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[2]/button")
	public WebElement filterButton;
	
	@FindBy (xpath = "//*[@id='woocommerce_price_filter-2']/form/div/div[2]/div[1]/span[2]")
	public WebElement output;
	
	public void Slider() {
		Actions action = new Actions (Victor_BaseClass.driver);
		action.dragAndDropBy(Slider, 582, 560).perform();
		filterButton.click();

	}
	
	
}

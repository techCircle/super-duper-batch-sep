package Emmie_automationTestingPage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Emmie_Utilities.Emmie_Driver;

public class HomePage {
	public HomePage() {
		PageFactory.initElements(Emmie_Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[text()='Shop']")
	public WebElement shopBtn;

	@FindBy(xpath = "//*[@class='n2-ss-slide-background-image n2-ss-slide-fill n2-ow']")
	public List<WebElement> sliders;

	@FindBy(xpath = "//*[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div")
	public List<WebElement> newArrival;

	@FindBy(xpath = "//*[text()='Thinking in HTML']")
	public WebElement clickThinkingInHTMLBook;
	
	@FindBy(xpath = "//*[@class='product_title entry-title']")
	public WebElement productLabel;

	
	public void shopBtnClick() {

		shopBtn.click();

	}
	
	
	
	public void checkSliderCount() {

		int slider = sliders.size();
		int expected = slider;
		System.out.println("Slider have : " + slider);
		System.out.println("Expected : " + expected);

	}

	public void checkNewArrival() {
		int arrival = newArrival.size();
		int expected = arrival;
		System.out.println("New Arrival have : " + arrival);
		System.out.println("Expected : " + expected);

	}

	public void threeArrivalShouldNavigate() {

		String url1 = "http://practice.automationtesting.in/product/selenium-ruby/";
		String url2 = "http://practice.automationtesting.in/product/thinking-in-html/";
		String url3 = "http://practice.automationtesting.in/product/mastering-javascript/";
		

		List<String> urls = new ArrayList<String>(Arrays.asList(url1, url2, url3));

		for (int i = 0; i < newArrival.size(); i++) {

			WebElement eachItem = newArrival.get(i);
			eachItem.click();
			
			String label = productLabel.getText();
			
			System.out.println("Actual: "+label);
			System.out.println("Expected: "+urls.get(i));
			
			
			Assert.assertTrue(Emmie_Driver.getDriver().getCurrentUrl().equalsIgnoreCase(urls.get(i)));

			Emmie_Driver.getDriver().navigate().back();

			
		}

	}


}

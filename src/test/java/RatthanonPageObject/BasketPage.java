package RatthanonPageObject;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import RatthanonUtilities.BaseClass;

public class BasketPage {
	
	public WebDriver driver = BaseClass.getDriver();
	String titleweb[] = {"selenium-ruby","thinking-in-html","mastering-javascript"};
		
			
		
		public BasketPage() {
			PageFactory.initElements(driver, this);
		}
		
		@FindBy(xpath="//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[3]/a")
		public WebElement NameProduct;
		
		@FindBy(xpath="//*[@id='page-34']/div/div[1]/form/table/tbody/tr[1]/td[4]/span")
		public WebElement PriceProduct;
		
		
		
		
		
		
		
		

}

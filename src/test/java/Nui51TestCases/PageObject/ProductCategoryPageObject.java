package Nui51TestCases.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import NuiUtilities.Driver;

public class ProductCategoryPageObject {
	
	WebDriver driver = Driver.getDriver();
	WebDriverWait wait;

	public ProductCategoryPageObject() {
		PageFactory.initElements(driver, this); 
		wait = new WebDriverWait(driver, 30);
	}
	
	@FindBy (xpath = "//*[@id='content']/ul/li")
	public List<WebElement> productList ;
	
	
	public void verifyOnlyHTML() {
		
		for(WebElement item : productList) {
			String text = item.getText();
			Assert.assertTrue(text.contains("HTML"));
		}
	}
	
	
}

package RatthanonPageObject;

import java.util.List;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import RatthanonUtilities.BaseClass;

public class ProductPage {
	
	WebDriver driver = BaseClass.getDriver();

	public ProductPage() {

		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//*[@id='product-169']/span")
	public WebElement salelogo;

	@FindBy(xpath = "//del")
	public WebElement deleteprice;
	
	
	@FindBy(xpath = "//div[@class='quantity']/input")
	public WebElement inputNumberItem;
	
	@FindBy(xpath = "//form[@class='cart']/button")
	public WebElement ButtonAddItem;
	
	@FindBy(xpath = "//*[@id='content']/div[1]/a")
	public WebElement viewBucketButton;
	//*[@id="content"]/div[1]/a
	
	@FindBy(xpath = "//div[@class='summary entry-summary']/p")
	public WebElement maxItem;
	
	
	
	//*[@id="product-182"]/div[2]/p
	
	
	
	
	public void verifyAddexceedItems() {
		

		String max = maxItem.getText().split(" ")[0];
		int addExceedNumber = Integer.parseInt(String.valueOf(max)) + 1; 
		
		inputNumberItem.sendKeys(String.valueOf(addExceedNumber));
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Boolean isValidInput = (Boolean)js.executeScript("return arguments[0].checkValidity();", inputNumberItem);
		
		Assert.assertFalse(isValidInput );
		String validationMessage = (String)js.executeScript("return arguments[0].validationMessage;", inputNumberItem);
		System.out.println(validationMessage);
		
		Assert.assertTrue(validationMessage.contains("Value must be less than or equal"));
				
		
	}
	
	
	
}

package Nui51TestCases.PageObject;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import NuiUtilities.Driver;
import NuiUtilities.NuiConfigurationProperties;

public class ProductPageObject {
	
	
	WebDriver driver = Driver.getDriver();

	public ProductPageObject() {
		PageFactory.initElements(driver, this); 
	}
	
	
	@FindBy (xpath = "//button[contains(text(), 'Add to basket')]")
	public WebElement addToBasketBtn;
	
	@FindBy (xpath = "//*[@id='product-160']/div[2]/p")
	public WebElement outOfStockTxt;
	
	@FindBy (xpath = "//*[@id='wpmenucartli']/a/span[1]")
	public WebElement numInCart;
	
	@FindBy (xpath = "//*[@id='product-169']/div[2]/div[1]/p/del/span")
	public WebElement originalPrice;
	
	@FindBy (xpath = "//*[@id='product-169']/div[2]/div[1]/p/ins/span")
	public WebElement discountPrice;
	
	
	

	public void verifySalePrice() {
		String originalPStr = originalPrice.getText().substring(1, 4);
		String salePStr = discountPrice.getText().substring(1, 4);
		Assert.assertTrue(Integer.valueOf(originalPStr) > Integer.valueOf(salePStr));
	}
	
	
	public void verifyOutOfStock() {
		Assert.assertTrue(outOfStockTxt.getText().equals(NuiConfigurationProperties.getKeyValue("outstockMsg")));
		outOfStockTxt.click();
		Assert.assertTrue(numInCart.getText().equals(NuiConfigurationProperties.getKeyValue("expectedNumItem")));
	}

	
}

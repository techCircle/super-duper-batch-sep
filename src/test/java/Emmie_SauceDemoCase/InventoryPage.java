package Emmie_SauceDemoCase;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Emmie_Utilities.Driver;

public class InventoryPage {
	
	public InventoryPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(id = "add-to-cart-sauce-labs-backpack")
	public WebElement firstProduct;

	@FindBy(id = "add-to-cart-sauce-labs-bolt-t-shirt")
	public WebElement secondProduct;

	@FindBy(id = "add-to-cart-sauce-labs-onesie")
	public WebElement thirdProduct;
	
	@FindBy(id = "shopping_cart_container")
	public WebElement clickCartBtn;
	
	@FindBy (id ="checkout")
	public WebElement checkoutBtn;
	
	
	// list 
	 @FindBy(xpath = "//*[@id='inventory_container']//div[@class='inventory_item']") 
     public List <WebElement> productList; 
	
	
	public void addCart() {
		firstProduct.click();
		secondProduct.click();
		thirdProduct.click();
		clickCartBtn.click();
//		checkoutBtn.click();
	
	}
	
	public void verifyProductsList() {
		
		int product_List = productList.size();
		int expected = product_List;
		System.out.println("Inventory Page have : " + product_List + " items");
		System.out.println("Expected list : " + expected + " items");
		Assert.assertEquals(product_List, expected);
		
		
		
	}
	

}

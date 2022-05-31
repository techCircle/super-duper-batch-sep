package thunpanBeePageObj;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import thunpanBee51TestCases.Driver;



public class ProductPage {
	public ProductPage() {
		PageFactory.initElements(Driver.getDriver(),this);
	}
	
	@FindBy(xpath="//button[@id='add-to-cart-sauce-labs-backpack']")
	public WebElement backPack;
	
	@FindBy(id="add-to-cart-sauce-labs-bolt-t-shirt")
	public WebElement tShirt;
	
	@FindBy(id="add-to-cart-sauce-labs-onesie")
	public WebElement onesieProduct;
	
	@FindBy(xpath = "//span[@class='shopping_cart_badge']")
	public WebElement cartBtn;
	
	@FindBy(xpath = "//*[@id='inventory_container']//div[@class='inventory_item']")
	public List<WebElement>	productList ;
	
	
	
	public void clickOnProduct() {
		backPack.click();
		tShirt.click();
		onesieProduct.click();
		cartBtn.click();
	}
	
	public void verifyPruductList() {
		
		int productSize = productList.size();
		int expected = productSize;
		System.out.println("Pruduct list: "+ productSize);
		System.out.println("Expected list: "+ expected);
		Assert.assertEquals(productSize, expected);
	}
}

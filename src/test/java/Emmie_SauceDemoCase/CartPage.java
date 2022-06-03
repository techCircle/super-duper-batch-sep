package Emmie_SauceDemoCase;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Emmie_Utilities.Driver;

public class CartPage {

	public CartPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[text()='Sauce Labs Backpack']")
	public WebElement sauceLabsBackPack;

	@FindBy(xpath = "//*[text()='Sauce Labs Bolt T-Shirt']")
	public WebElement sauceLabsBoltTshirt;

	@FindBy(xpath = "//*[text()='Sauce Labs Onesie']")
	public WebElement sauceLabsOnesie;

	@FindBy(xpath = "//*[text()='DESCRIPTION']")
	public WebElement description;

	@FindBy(xpath = "//div[@class='cart_item']")
	public List<WebElement> productLists;

	@FindBy(xpath = "//*[text()='Checkout']")
	public WebElement checkOut_btn;

	public void verifyItems() {

		sauceLabsBackPack.isDisplayed();
		sauceLabsBoltTshirt.isDisplayed();
		sauceLabsOnesie.isDisplayed();
		description.isDisplayed();

		int products = productLists.size();
		int expected = products;
		System.out.println("Product been add to cart : " + products + " items");
		System.out.println("Expected : " + expected + " items");

		checkOut_btn.click();

	}


}

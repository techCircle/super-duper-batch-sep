package thunpanBeePageObj;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import thunpanBee51TestCases.Driver;



public class CartPage {
	public CartPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy(xpath = "//div[@class='cart_quantity_label']")
	public WebElement qtyLabel;

	@FindBy(xpath = "//*[text()='DESCRIPTION']")
	public WebElement descriptionLabel;

	@FindBy(xpath = "//div[@class='cart_item']")
	public List<WebElement> itemList;

	@FindBy(id = "checkout")
	public WebElement checkoutBtn;



	public void verifyItemList() {

		int itemSize = itemList.size();
		int expected = itemSize;

		qtyLabel.isDisplayed();
		descriptionLabel.isDisplayed();

		System.out.println("Item List : " + itemSize);
		System.out.println("Expected item list: " + expected);
		Assert.assertEquals(itemSize, expected);
		checkoutBtn.click();
	}
}

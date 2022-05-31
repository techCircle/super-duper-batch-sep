package thunpanBee51TestCasesPageObj;

import java.util.List;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import thunpanBee51TestCases.Constant;
import thunpanBee51TestCases.Driver;

public class ProductPageObj {

	public ProductPageObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[text()='Out of stock']")
	private WebElement OOSLabel;

	@FindBy(xpath = "//*/p[@class='price']/del")
	private WebElement ogPrice;

	@FindBy(xpath = "//*/p[@class='price']/ins")
	private WebElement salePrice;

	@FindBy(xpath = "//*[@class='product_title entry-title']")
	public WebElement productLabel;

	@FindBy(xpath = "//ul[@class='products']/li")
	public List<WebElement> relatedProductList;

	@FindBy(xpath = "//button[@type='submit']")
	private WebElement addBaskeBtn;

	@FindBy(xpath = "//*[@title='View your shopping cart']")
	private WebElement viewCart;

	@FindBy(xpath = "//*[text()='Description']")
	private WebElement descriptionTab;

	@FindBy(xpath = "//*[@id='tab-description']")
	private WebElement descriptionP;

	@FindBy(xpath = "//*[@id='product-170']/div[3]/ul/li[2]/a")
	public WebElement reviewTab;

	@FindBy(xpath = "//div[@id='comments']")
	public WebElement reviewText;

	@FindBy(xpath = "//*[@name='quantity']")
	public WebElement input;
	
	public void clickOnAddBasket() {
		addBaskeBtn.click();
	}

	public void clickDescription() {
		descriptionTab.click();
	}

	public void clickreview() {
		reviewText.click();
	}
	
	public void inputQuantity() {
		
	}

	public void verifyViewCartIsDisplay() {

		System.out.println("Cart tab isDisplayes: " + viewCart.isDisplayed());
		Assert.assertTrue(viewCart.isDisplayed());
		System.out.println(viewCart.getText());
	}

	public void verifyDescription() {
		String des = descriptionP.getText();
		String expected = Constant.desExp;
		System.out.println("Actual : " + des);
		System.out.println("Expected : " + expected);
		Assert.assertTrue(des.contains(expected));
	}

	public void verifyReview() {
		String actualText = reviewText.getText();
		String expected = "";
		System.out.println("Actual : " + actualText);
		System.out.println("Expected : " + expected);
		Assert.assertTrue(actualText.contains(expected));
	}

	public void verifyAddBasKetBtn() {

		System.out.println("Add Basket isDisplayed: " + addBaskeBtn.isDisplayed());
		Assert.assertTrue(addBaskeBtn.isEnabled());
	
	}

	public void verifyOgAndSalePrice() {
		String ogP = ogPrice.getText();
		String sale = salePrice.getText();
		System.out.println("Original Price : " + ogP);
		System.out.println("Sale Price: " + sale);
		Assert.assertNotEquals(ogP, sale);

	}

	public void verifyOutOfStock() {
		String actual = OOSLabel.getText();
		String expected = Constant.outOfStock;
		System.out.println("Actual Displayed : " + actual);
		System.err.println("Expected : " + expected);
		Assert.assertTrue(actual.contains(expected));
	}

}

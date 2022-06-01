package MeenaObject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import MeenaUtilities.MeenaDriver;

public class arrivalsPage {

	public arrivalsPage() {

		PageFactory.initElements(MeenaDriver.getDriver(), this);

	}

	@FindBy(xpath = "//*[@class='product_title entry-title']")
	public WebElement bookTitle;

	@FindBy(xpath = "//*[@id=\"tab-description\"]/h2")
	public WebElement descriptionText;

	@FindBy(xpath = "//*[@class='reviews_tab']/a")
	public WebElement reviewTab;

	@FindBy(xpath = "//*[@id=\"commentform\"]/p[3]/label")
	public WebElement reviewText;

	@FindBy(xpath = "//*[@id=\"product-165\"]/div[5]/ul/li[1]/a[2]")
	public WebElement addToBasketBtn;

	@FindBy(xpath = "//*[@id=\"product-165\"]/div[5]/ul/li[1]/a[3]")
	public WebElement viewBasketText;

	public void addToBasket() {

		String verifyAddToBasket = viewBasketText.getText();
		Assert.assertTrue(verifyAddToBasket.contains("View Basket"));

	}

}

package Emmie_automationTestingPage;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Emmie_Utilities.Emmie_Driver;

public class ProductPage {
	JavascriptExecutor js = (JavascriptExecutor) Emmie_Driver.driver;

	public ProductPage() {
		PageFactory.initElements(Emmie_Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[text()='Thinking in HTML']")
	public WebElement clickThinkingInHTMLBook;

	@FindBy(xpath = "//*[text()='Description']")
	public WebElement descriptionBtn;

	@FindBy(xpath = "//*[@class='layoutArea']/div")
	public WebElement description;

	@FindBy(xpath = "//*[text()='Reviews (0)']")
	public WebElement reviewBtn;

	@FindBy(xpath = "//*[@class='comment-reply-title']")
	public WebElement reviewText;

	@FindBy(xpath = "//*[@id='product-163']/div[5]/ul/li")
	public List<WebElement> clickBook;

	@FindBy(xpath = "//*[@id='product-182']/div[2]/form/button")
	public WebElement addBooksToBasket;

	@FindBy(xpath = "//*[text()='HTML5 WebApp Develpment']")
	public WebElement bookTitle;

	@FindBy(xpath = "//*[@class='input-text qty text']")
	public WebElement boxQty;
	
	@FindBy(xpath = "//*[@class='wpmenucart-contents']")
	public WebElement itemBtn;

	public void navigateToDespription() {
		clickThinkingInHTMLBook.click();
		descriptionBtn.click();

		String descp = description.getText();
		String expected = descp;
		System.out.println("Description : " + descp);
		System.out.println(expected);
		Assert.assertTrue(descp.contains(expected));

	}

	public void reviewBtnClick() {
		clickThinkingInHTMLBook.click();
		reviewBtn.click();

		String review = reviewText.getText();
		String expectedText = review;
		System.out.println(review);
		System.out.println(expectedText);
		Assert.assertTrue(review.contains(expectedText));

	}

	public void addBookToBasket() {
		clickThinkingInHTMLBook.click();
		Emmie_Driver.clickProductFromList(clickBook, "HTML5");
		addBooksToBasket.click();
		String bookName = bookTitle.getText();
		System.out.println("BOOK TITLE : " + bookName);
		bookTitle.isDisplayed();
	}

	public void addMoreBooks() {
		clickThinkingInHTMLBook.click();
		Emmie_Driver.clickProductFromList(clickBook, "HTML5");
		String bookName = bookTitle.getText();
		System.out.println("BOOK TITLE : " + bookName);
		bookTitle.isDisplayed();

		String maxInput = boxQty.getAttribute("max");
		System.out.println("Maximum quantity : " + maxInput);

		int maxPlusOne = Integer.parseInt(maxInput + 1);

		boxQty.clear();
		boxQty.sendKeys(maxPlusOne + "");
		// boxQty.sendKeys(String.valueOf(maxPlusOne));
		addBooksToBasket.click();

		js = (JavascriptExecutor) Emmie_Driver.getDriver();
		Boolean isValidInput = (Boolean) js.executeScript("return arguments[0].checkValidity();", boxQty);
		String validationMessage = (String) js.executeScript("return arguments[0].validationMessage;", boxQty);
		System.out.println("Actual Alert : " + validationMessage);
		Assert.assertFalse(isValidInput);
		String alert = String.format("Value must be less than or equal to %d.", Integer.valueOf(maxInput));
		Assert.assertTrue(alert.contains(validationMessage));
		System.out.println("Expected Alert : " + alert);
	}

}


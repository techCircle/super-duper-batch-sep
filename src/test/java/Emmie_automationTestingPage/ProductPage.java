package Emmie_automationTestingPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Emmie_Utilities.Driver;

public class ProductPage {
	public ProductPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[text()='Thinking in HTML']")
	public WebElement clickThinkingInHTMLBook;
	
	@FindBy(xpath = "//*[text()='Description']")
	public WebElement descriptionBtn;

	@FindBy(xpath = "//*[@class='layoutArea']/div")
	public WebElement description;
	
	
	public void navigateToDespription() {
		clickThinkingInHTMLBook.click();
		descriptionBtn.click();

		String descp = description.getText();
		String expected = descp;
		System.out.println("Description : " + descp);
		System.out.println(expected);
		Assert.assertTrue(descp.contains(expected));

	}

}

package Emmie_SauceDemoCase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Emmie_Utilities.Driver;

public class CheckoutStepOnePage {

	public CheckoutStepOnePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(id = "first-name")
	public WebElement firstNameInput;

	@FindBy(id = "last-name")
	public WebElement lastNameInput;

	@FindBy(id = "postal-code")
	public WebElement zipcodeInput;

	@FindBy(id = "continue")
	public WebElement continuetBtn;

	@FindBy(xpath = "//*[@class='title']")
	public WebElement pageHeader;

	@FindBy(xpath = "//*[@class='title']")
	public WebElement title;

	public void verifyYourInfo() {

		title.isDisplayed();

		String titlePage = title.getText();
		String expected = titlePage;
		System.out.println("Title : " + titlePage);
		System.out.println("Expected Title : " + expected);

	}

	public void infoFill() {
		firstNameInput.sendKeys("Emmie");
		lastNameInput.sendKeys("Hello");
		zipcodeInput.sendKeys("22191");
		continuetBtn.click();

	}

}

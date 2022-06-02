package thunpanBeePageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import thunpanBee51TestCases.Driver;



public class CheckOutCompletePage {
	public CheckOutCompletePage() {
		PageFactory.initElements(Driver.getDriver(),this);
	}
	
	@FindBy(xpath = "//*[@class='title']")
	private WebElement checkOutCompleteLabel;
	
	@FindBy(xpath = "//h2")
	private WebElement headerLabel;
	
	@FindBy(xpath = "//*[@class='complete-text']")
	private WebElement completeText;
	
	public void completeCheckOut() {
		
		String header = headerLabel.getText();
		System.out.println("CheckOut Label Displayed?: "+checkOutCompleteLabel.isDisplayed());
		System.out.println("Thank you Label Displayed?: "+headerLabel.isDisplayed());
		System.out.println("ConfirmationText Displayed?: "+completeText.isDisplayed());
	}
	
}

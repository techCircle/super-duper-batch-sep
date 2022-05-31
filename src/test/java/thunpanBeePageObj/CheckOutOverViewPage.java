package thunpanBeePageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import thunpanBee51TestCases.Driver;



public class CheckOutOverViewPage {
	public CheckOutOverViewPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	@FindBy(xpath = "//*[@class='title']")
	public WebElement checkOutTitle;
	
	@FindBy(xpath = "//*[@class='summary_info']")
	public WebElement sumaryInfo;
	
	@FindBy(id="finish")
	public WebElement finishButton;
	
	
	
	public void verifyCheckOutTitle() {
		
		checkOutTitle.isDisplayed();
		String checkoutText = checkOutTitle.getText();
		System.out.println("Hearder verify: "+checkoutText);
	}
	
	public void verifySumaryInfo() {
		String info = sumaryInfo.getText();
		System.out.println("::Verify sumaryInfo::\n"+info);
		finishButton.click();
	}
	
}

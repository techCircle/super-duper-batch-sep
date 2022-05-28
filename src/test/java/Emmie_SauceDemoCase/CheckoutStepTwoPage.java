package Emmie_SauceDemoCase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Emmie_Utilities.Driver;

public class CheckoutStepTwoPage {

	public CheckoutStepTwoPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[@class='header_secondary_container']")
	public WebElement titleOverView;

	@FindBy(xpath = "//*[@class='summary_info']")
	public WebElement summaryInfo;

	@FindBy(id = "finish")
	public WebElement finishBtn;

	public void verifySummaryInfo() {

		String summary = summaryInfo.getText();
		String expected = summary;
		System.out.println(summary);
		System.out.println(expected);

	}

	public void fnclick() {

		finishBtn.click();
	}
}

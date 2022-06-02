package Emmie_SauceDemoCase;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Emmie_Utilities.Driver;

public class CheckoutCompletePage {
	

	public CheckoutCompletePage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[text()='THANK YOU FOR YOUR ORDER']")
	public WebElement titleOfPage;

	public void verifyComplete() {

		String title = titleOfPage.getText();
		String expected = title;
		System.out.println("Title : " + title);
		System.out.println(expected);

	}


}

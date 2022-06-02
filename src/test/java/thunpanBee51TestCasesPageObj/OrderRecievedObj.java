package thunpanBee51TestCasesPageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import thunpanBee51TestCases.Driver;

public class OrderRecievedObj {

	public OrderRecievedObj() {
		PageFactory.initElements(Driver.getDriver(), this);
	}

	@FindBy(xpath = "//*[@id='page-35']/div/div[1]/table[1]")
	private WebElement orderDetail;
	@FindBy(xpath = "//*[@id='page-35']/div/div[1]/table[2]")
	private WebElement customerDetail;
	@FindBy(xpath = "//*[@id='page-35']/div/div[1]/address")
	private WebElement billingDetail;

	public void verifyOrderConfirm() {

		System.out.println("OrderDetail isDisplayed : " + orderDetail.isDisplayed());
		System.out.println("CustomerDetail isDisplayed : " + customerDetail.isDisplayed());
		System.out.println("BillingDetail isDisplayed : " + billingDetail.isDisplayed());
	}

}

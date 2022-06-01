package maria.MyAccountObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import Utilities.Driver;

public class MyAccountsViewOrderPage {
	
	public MyAccountsViewOrderPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	
	
	//changes to push
	@FindBy(xpath="//*[text()=\"Order Details\"]")
	WebElement orderDetailsDisplayed;
	
	@FindBy(xpath="//table[@class='shop_table order_details']")
	WebElement productTotalDetails;
	
	@FindBy(xpath="//*[text()=\"Customer Details\"]")
	WebElement customersDetailHeader;
	
	@FindBy(xpath="//table[@class='shop_table customer_details']")
	WebElement customerDetails;
	
	@FindBy(xpath="//*[text()=\"Billing Address\"]")
	WebElement billingDetails;
	
	@FindBy(xpath="//address[1]")
	WebElement billingaddress;
	
	@FindBy(className="order-number")
	WebElement orderNumber;
	
	
	@FindBy(className="order-date")
	WebElement orderDate;
	
	
	
	@FindBy(className="order-status")
	WebElement orderStatus;
	
	
	public void viewOrderDetails () {
		
		//viewButton.click();
		Assert.assertTrue(orderDetailsDisplayed.isDisplayed());
		System.out.println(orderDetailsDisplayed.getText());

		Assert.assertTrue(productTotalDetails.isDisplayed());
		
		Assert.assertTrue(customersDetailHeader.isDisplayed());
		System.out.println(customersDetailHeader.getText());
		Assert.assertTrue(customerDetails.isDisplayed());

		Assert.assertTrue(billingDetails.isDisplayed());
		System.out.println(billingDetails.getText());

		Assert.assertTrue(billingaddress.isDisplayed());}
		

	public void orderStatusAndnumber() {
		Assert.assertTrue(orderNumber.isDisplayed());
		Assert.assertTrue(orderDate.isDisplayed());
		Assert.assertTrue(orderStatus.isDisplayed());
		System.out.println("orderNumber"+orderNumber.getText()+","  +"orderDate"+orderDate.getText()+ ","+"orderStatus"+orderStatus.getText());
	}
	
	
		
		
		
		
	}
	


package maria.MyAccountObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import mariaUtilities.Driver;



public class MyaccountsOrderPage3 {

	public MyaccountsOrderPage3() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	// changes to push
	
	@FindBy(className="order-number")
	WebElement orderNumber;
	
	
	@FindBy(className="order-date")
	WebElement orderDate;
	
	
	
	@FindBy(className="order-status")
	WebElement orderStatus;
	
	public void orderStatusAndnumber() {
		Assert.assertTrue(orderNumber.isDisplayed());
		Assert.assertTrue(orderDate.isDisplayed());
		Assert.assertTrue(orderStatus.isDisplayed());
		System.out.println("orderNumber"+orderNumber.getText()+","  +"orderDate"+orderDate.getText()+ ","+"orderStatus"+orderStatus.getText());
	}
	
	
	
	
}

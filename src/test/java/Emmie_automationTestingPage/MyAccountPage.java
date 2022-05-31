package Emmie_automationTestingPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Emmie_Utilities.Driver;

public class MyAccountPage {
	public MyAccountPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy(xpath = "//*[text()='Sign out']")
	public WebElement signOutBtn ;
	
	@FindBy(xpath = "//*[text()='Dashboard']")
	public WebElement dashboardBtn ;

	@FindBy(xpath = "//*[text()='Orders']")
	public WebElement ordersBtn; 
	
	
	@FindBy(xpath = "//*[text()='Addresses']")
	public WebElement addressBtn; 
	
	public void dashboardClick() {
		dashboardBtn.click();
	}
	public void orderClick() {
		ordersBtn.click();
	}
	public void addressClick() {
		addressBtn.click();
	}
	
	
	
//	public void verifyDashBoardLink() {
//		
//		String text = verifyAccountContend.getText();
//		String expectedText = text;
//		System.out.println("Dashboard link is appeared : --> " + text);
//		System.out.println(expectedText);
//		
//		Assert.assertEquals(text,expectedText);
//		
//		
//	}
}

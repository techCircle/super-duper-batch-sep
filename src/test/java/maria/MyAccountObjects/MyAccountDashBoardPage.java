package maria.MyAccountObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import mariaUtilities.Driver;




public class MyAccountDashBoardPage {
//changes to push

	public MyAccountDashBoardPage() {
		PageFactory.initElements(Driver.getDriver(), this);
	}
	@FindBy(xpath="//*[text()='Sign out']")
	WebElement homePage;
	
	@FindBy(id="page-36")
	public WebElement DashBoardContents;

	@FindBy(linkText="My Account")
	public WebElement MyAccountLink;
	
	@FindBy(linkText="Dashboard")
	public WebElement DashBoardButton;


	@FindBy(xpath="//*[text()='Orders']")
	public WebElement orderLinkBtn;

	@FindBy(linkText="Downloads")
	public WebElement downloadsButton;

	@FindBy(linkText="Addresses")
	public WebElement addressLinkBTN;

	@FindBy(linkText="Account Details")
	public WebElement AccountDetailsBTN;

	@FindBy(linkText="Logout")
	public WebElement LogoutButton;

	
	//Methods//
	
	public void dashBoardPageVerify() {
		Assert.assertTrue(DashBoardContents.isDisplayed());}

	public void dashBoardbtnClick() {
		DashBoardButton.click();}
	
	public void orderLinkBtnClick() {
		orderLinkBtn.click();}
	
	public void downloadsButtonClick() {
		downloadsButton.click();}
	
	public void MyAccountLinkClik() {
		MyAccountLink.click();}
	
	public void addressBtnClick() {
		addressLinkBTN.click();}

	
	public void AccountDetailsBTNClick() {
		AccountDetailsBTN.click();}
	
	
	public void LogoutButtonClick() {
		LogoutButton.click();}
	
	}

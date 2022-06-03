package kanokwanPageObject;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import kanokwanUtilities.KanokwanBaseClass;


public class myAccountPage {
	
	public myAccountPage() {
		
		PageFactory.initElements(KanokwanBaseClass.getDriver(), this);
	}
	
		//MY ACCOUNT
		//Click on My Account 
		@FindBy(id = "menu-item-50")
		public WebElement myAccount;
	
		//Enter user name
		@FindBy(id = "username")
		public WebElement userName;
		
		//Enter password
		@FindBy(id = "password")
		public WebElement password;
		
		//Click on login button
		@FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")
		public WebElement loginButton;
		
		@FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/div/p[2]")
		public WebElement verifyLoginCompletedText;
		
		//Click on Dash board
		@FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[1]/a")
		public WebElement dashBoardButton;
		
		//Verify Dash board
		@FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/div/p[2]")
		public WebElement verifyDashBoardText;
		
		//Click on Orders
		@FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[2]/a")
		public WebElement orderButton;
		
		//Verify Orders
		@FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/div/div")
		public WebElement verifyOrdersText;
		
		//Click on Address
		@FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[4]/a")
		public WebElement addressButton;
		
		//Verify Address
		@FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/div/div")
		public WebElement verifyAddressText;
		
		//Click on Edit ShippingAddress
		@FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/div/div/div[2]/header/a")
		public WebElement shippingAddressButton;
		
		//Verify ShippingAddress
		@FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]")
		public WebElement verifyShippingAddressText;
		
		//Click Account Details
		@FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[5]/a")
		public WebElement accountDetailsButton;
		
		//Verify Account Details
		@FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/div/form")
		public WebElement verifyAccountDetailsText;
		
		//Click log out
		@FindBy(xpath = "//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")
		public WebElement logOutButton;
		
		//Verify log out
		@FindBy(xpath = "//*[@id=\"customer_login\"]/div[1]/h2")
		public WebElement verifyLogOutText;
		
		public void myAccount() {
			myAccount.click();
		}
		
		public void valid_userName_login() {
			userName.sendKeys(KanokwanBaseClass.getProperty("validUserName"));
		}
		
		public void valid_password_login() {
			password.sendKeys(KanokwanBaseClass.getProperty("validPassword"));
		}
		
		public void loginButton() {
			loginButton.click();
		}
		
		public void dashBoardButton() {
			dashBoardButton.click();
		}
		
		public void orderButton() {
			orderButton.click();
		}
		
		public void addressButton() {
			addressButton.click();
		}
		
		public void shippingAddressButton() throws InterruptedException {
			shippingAddressButton.sendKeys(Keys.ENTER);
			Thread.sleep(3000);
		}
		
		public void accountDetailsButton() {
			accountDetailsButton.click();
		}
		
		public void logOutButton() {
			logOutButton.click();
		}
		
		public void verifyDashBoard() {
			 Assert.assertTrue(verifyDashBoardText.isDisplayed());
		}
		
		public void verifyOrdersText() {
			Assert.assertTrue(verifyOrdersText.isDisplayed());
		} 
		
		public void verifyAddressText() {
			Assert.assertTrue(verifyAddressText.isDisplayed());
		}
		
		public void verifyShippingAddressText() {
			Assert.assertTrue(verifyShippingAddressText.isDisplayed());
		}
		
		public void verifyAccountDetailsText() {
			Assert.assertTrue(verifyAccountDetailsText.isDisplayed());
		}
		
		public void verifyLogOutText() {
			Assert.assertTrue(verifyLogOutText.isDisplayed());
		}

	}


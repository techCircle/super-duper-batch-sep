package thunpanBee51TestCasesPageObj;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import thunpanBee51TestCases.ConfigurationProperties;
import thunpanBee51TestCases.Driver;

public class AccountPageObj {

	public AccountPageObj() {
		PageFactory.initElements(Driver.driver, this);
	}

	// registration //
	@FindBy(xpath = "//*[text()='My Account']")
	private WebElement accBtn;

	@FindBy(xpath = "//input[@id='reg_email']")
	private WebElement emailBox;

	@FindBy(xpath = "//input[@id='reg_password']")
	private WebElement passWordBox;

	@FindBy(xpath = "//*[@name='register']")
	private WebElement registerBtn;

	@FindBy(xpath = "//*[@id='page-36']/div/div[1]/ul/li")
	private WebElement Text;

	//////////////////////////////////////////////////////////////////////
	// login //

	@FindBy(xpath = "//*[@name='username']")
	private WebElement userBox;

	@FindBy(xpath = "//*[@id='password']")
	private WebElement passWordLoginBox;

	@FindBy(xpath = "//*[@id='customer_login']/div[1]")
	public WebElement loginForm;

	@FindBy(xpath = "//*[@name='login']")
	private WebElement loginBtn;

	@FindBy(xpath = "//h2[contains(text(),'Login')]")
	private WebElement loginLabel;

	@FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']")
	private WebElement loginText;

	@FindBy(xpath = "//*[text()='Sign out']")
	private WebElement signOutBtn;

	@FindBy(xpath = "//*[@id='content']")
	private WebElement dashBoardDisplay;

	@FindBy(xpath = "//*[@id='page-36']/div/div[1]/div")
	private WebElement orderSession;

	@FindBy(xpath = "//*[@id='page-36']/div/div[1]/div/table/tbody/tr/td[5]/a")
	private WebElement viewBtn;

	@FindBy(xpath = "//*[@id='page-36']/div/div[1]/div")
	public WebElement Detail;

	@FindBy(xpath = "//*[@id='page-36']/div/div[1]/div/p")
	public WebElement orderStatus;

	@FindBy(xpath = "//*[@id='page-36']/div/div[1]/nav/ul/li/a")
	private List<WebElement> menuList;

	@FindBy(xpath = "//*[@id='page-36']/div/div[1]/div/div/div[1]/header/a")
	private WebElement billingEditLink;

	@FindBy(xpath = "//*[@id='page-36']/div/div[1]/div/div/div[2]/header/a")
	private WebElement shippingEditLink;

	public void verifyDashBoard() {
		String dashBoard = dashBoardDisplay.getText();
		System.out.println("DashBoard Displayed: " + dashBoardDisplay.isDisplayed());
		System.out.println(dashBoard);
	}

	public void clickBillingEditLink() {
		billingEditLink.click();
	}

	public void clickShippingEditLink() {
		shippingEditLink.click();
	}

	public void clickLogOut() {
		Driver.clickOnProduct(menuList, ConfigurationProperties.getInputDataProperty("logOT"));
	}

	public void clickAccDetail() {
		Driver.clickOnProduct(menuList, ConfigurationProperties.getInputDataProperty("accD"));
	}

	public void clickAddressLink() {
		Driver.clickOnProduct(menuList, ConfigurationProperties.getInputDataProperty("address"));
	}

	public void clickviewBtn() {
		viewBtn.click();
	}

	public void clickOrderLink() {
		Driver.clickOnProduct(menuList, ConfigurationProperties.getInputDataProperty("order"));
	}

	public void clickOnSignOutBtn() {
		signOutBtn.click();
	}

	public void clickAccBtn() {
		accBtn.click();
	}

	public void verifyLabel() {
		loginLabel.isDisplayed();
	}

	public void verifyOrderSessionDisplay() {

		System.out.println("OrderDetail isDisplay: " + orderSession.isDisplayed());
	}

	public void loginVerify() {
		String actualText = loginText.getText();
		String expectedText = ConfigurationProperties.getInputDataProperty("loginVerifyText");
		Assert.assertTrue(actualText.contains(expectedText));
		System.out.println("ActualText : " + actualText);
		System.out.println("ExpectedText : " + expectedText);
	}

	public void varifyInvalidUsernameMessage() {
		String errorMsg = Text.getText();
		String expected = ConfigurationProperties.getInputDataProperty("errorUserName");
		Assert.assertTrue(errorMsg.contains(expected));
		System.out.println("Acutal Error: " + errorMsg);
		System.out.println("Expected Error contain : " + expected);
	}

	public void varifyEmptyPassword() {
		String errorMsg = Text.getText();
		String expected = ConfigurationProperties.getInputDataProperty("errorEmptyPassword");
		System.out.println("Acutal Error: " + errorMsg);
		System.out.println("Expected Error contain : " + expected);
		Assert.assertTrue(errorMsg.contains(expected));
	}

	public void verifyEmptyUsername() {
		String errorMsg = Text.getText();
		String expected = ConfigurationProperties.getInputDataProperty("errorEmptyUsername");
		System.out.println("Acutal Error: " + errorMsg);
		System.out.println("Expected Error contain : " + expected);
		Assert.assertTrue(errorMsg.contains(expected));
	}

	public void verifyPasswordBeMasked() {
		Assert.assertEquals(passWordLoginBox.getAttribute("type"), "password");
		String actualType = passWordLoginBox.getAttribute("type");
		String expectedType = "password";
		passWordLoginBox.isDisplayed();
		System.out.println("Actual Type : " + actualType);
		System.out.println("Expected Type : " + expectedType);
	}

	public void inputValidEmailAndPassword() {
		userBox.sendKeys(ConfigurationProperties.getInputDataProperty("validEmail"));
		passWordLoginBox.sendKeys(ConfigurationProperties.getInputDataProperty("validPassword"));
		loginBtn.click();

	}

	public void inputInvalidLogin() {

		userBox.sendKeys(ConfigurationProperties.getInputDataProperty("invalidEmail1"));
		passWordLoginBox.sendKeys(ConfigurationProperties.getInputDataProperty("invalidPassword1"));
		loginBtn.click();

	}

	public void inputEmptyPasswordLogin() {
		userBox.sendKeys(ConfigurationProperties.getInputDataProperty("validEmail"));
		loginBtn.click();
	}

	public void inputEmptyUsernamelogin() {
		passWordBox.sendKeys(ConfigurationProperties.getInputDataProperty("validPassword"));
		loginBtn.click();
	}

	public void inputEmpty() {
		loginBtn.click();
	}

	public void inputCharacterPassword() {
		passWordLoginBox.sendKeys(ConfigurationProperties.getInputDataProperty("validPassword"));
	}

	public void inputCaseSensitive() {
		userBox.sendKeys(ConfigurationProperties.getInputDataProperty("caseChgEmail"));
		passWordLoginBox.sendKeys(ConfigurationProperties.getInputDataProperty("caseChgPassword"));
		loginBtn.click();
	}

	//////////////////////////////////////////////////////////////////////
	// register //

	public void inputValidRegister() {
		emailBox.sendKeys(ConfigurationProperties.getInputDataProperty("validEmail"));
		passWordBox.sendKeys(ConfigurationProperties.getInputDataProperty("validPassword"));
		registerBtn.click();
	}

	public void inputInvalidRegisterEmail() {
		emailBox.sendKeys(ConfigurationProperties.getInputDataProperty("invalidEmail2"));
		passWordBox.sendKeys(ConfigurationProperties.getInputDataProperty("validPassword"));
		registerBtn.click();

	}

	public void inputEmptyRegisterEmail() {
		passWordBox.sendKeys(ConfigurationProperties.getInputDataProperty("validPassword"));
		registerBtn.click();
	}

	public void inputEmptyRegisterPassword() {
		emailBox.sendKeys(ConfigurationProperties.getInputDataProperty("inputEmail"));
		registerBtn.click();
	}

	public void inputEmptyRegister() {
		registerBtn.click();
	}

	public void verifyRegistration() {

		String actualText = Text.getText();
		String expected = ConfigurationProperties.getInputDataProperty("registerVarify");
		System.out.println("Actual Type : " + actualText);
		System.out.println("Expected Type : " + expected);
		Assert.assertTrue(actualText.contains(expected));
	}

	public void verifyInvalidRegistrationEmail() {

		String actualText = Text.getText();
		String expected = ConfigurationProperties.getInputDataProperty("verifyInvalidRegisterEmaiL");
		System.out.println("Actual Type : " + actualText);
		System.out.println("Expected Type : " + expected);
		Assert.assertTrue(actualText.contains(expected));
	}

	public void verifyEmptyRegisterPassword() {
		String actualText = Text.getText();
		String expected = ConfigurationProperties.getInputDataProperty("verifyEmptyPassword");
		System.out.println("Actual Type : " + actualText);
		System.out.println("Expected Type : " + expected);
		Assert.assertTrue(actualText.contains(expected));
	}

}

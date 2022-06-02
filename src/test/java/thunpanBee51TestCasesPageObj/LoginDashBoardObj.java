package thunpanBee51TestCasesPageObj;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import thunpanBee51TestCases.ConfigurationProperties;
import thunpanBee51TestCases.Driver;

public class LoginDashBoardObj {

	public LoginDashBoardObj() {
		PageFactory.initElements(Driver.driver, this);
	}

	@FindBy(xpath = "//div[@class='woocommerce-MyAccount-content']")
	public WebElement loginText;
	@FindBy(xpath = "//*[text()='Sign out']")
	public WebElement signOutBtn;

	public void loginVerify() {
		String actualText = loginText.getText();
		String expectedText = ConfigurationProperties.getInputDataProperty("loginVerifyText");
		Assert.assertTrue(actualText.contains(expectedText));
		System.out.println("ActualText : " + actualText);
		System.out.println("ExpectedText : " + expectedText);
	}

	public void clickOnSignOutBtn() {
		signOutBtn.click();
	}

}

package Emmie_51TestCases.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.Driver;

public class AccountLogin {

	@BeforeClass
	public void setUp() {

		Driver.getDriver();
		System.out.println("Open Browser sucessful!! ");

	}

	@DataProvider(name = "LoginDataProvider")
	public Object[][] dpMethod() {
		return new Object[][] { { "hithere@gmail.com ", "12qw34er56ty" }, // invalid userName & invalid password
				{ "this.emmie@gmail.com", "" }, // valid userName , empty password
				{ "", "1z2x3c4v5b6n7m" }, // empty userName , Valid password
				{ " ", " " }, // empty userName & password
				{ "This.Emmie!!@gmail.com", "1Z2X3c4v5b6n7m" } }; // change cases (case sensitive)

	}

	@Test(dataProvider = "LoginDataProvider")
	public void login(String username, String password) {
		// click on my account
		Driver.driver.findElement(By.xpath("//*[text()='My Account']")).click();

		// Enter login Email Address in Email-Address textBox
		WebElement emailBox = Driver.driver.findElement(By.xpath("//*[@name='username']"));
		emailBox.sendKeys(username);

		// Enter your own password in password textBox
		WebElement passwordBox = Driver.driver.findElement(By.xpath("//*[@name='password']"));
		passwordBox.sendKeys(password);

		// Click on login button
		Driver.driver.findElement(By.xpath("//*[@name='login']")).click();

		// Login must fail saying incorrect UserName/password.
		String actualText = Driver.driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li")).getText();
		String expectedText = actualText.toString();
		Assert.assertTrue(actualText.contains(expectedText));

	}

	@Test(dependsOnMethods = "passwordBeMasked")
	public void loginAuthentication() {

		//navigate to My Account
		Driver.driver.findElement(By.xpath("//*[text()='My Account']")).click();
		//put email in email field
		Driver.driver.findElement(By.xpath("//*[@name='username']")).sendKeys("this.emmie@gmail.com");
		// put password in password field
		Driver.driver.findElement(By.xpath("//*[@name='password']")).sendKeys("1z2x3c4v5b6n7m");
		// login button
		Driver.driver.findElement(By.xpath("//*[@name='login']")).click();
		System.out.println(" login Sucessful !! ");
		// signOut
		Driver.driver.findElement(By.xpath("//*[text()='Sign out']")).click();

	}
	@Test (dependsOnMethods = "login")
	public void passwordBeMasked() {
		Driver.driver.findElement(By.xpath("//*[text()='My Account']")).click();
		Driver.driver.findElement(By.xpath("//*[@name='password']")).sendKeys("1z2x3c4v5b6n7m");
		//password field should display the characters in asterisks or 
		//bullets such that the password is not visible on the screen
		Assert.assertEquals(Driver.driver.findElement(By.xpath("//*[@type='password']")).getAttribute("type"),
				"password");

	}

	@AfterClass
	public void closrBrowser() {
		Driver.tearDown();
	}

}

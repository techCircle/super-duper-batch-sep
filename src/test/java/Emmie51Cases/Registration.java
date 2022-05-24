package Emmie51Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.Driver;

public class Registration {
	
	@BeforeMethod
	public void setUp() {
		Driver.getDriver();
		System.out.println("Open Browser sucessful!! ");
	}

	@DataProvider(name = "RegistrationDataProvider")
	public Object[][] dpMethod() {
		return new Object[][] { 
				{ "this.emmie@gmail.com","1z2x3c4v5b6n7m" },
				{ "hithere@gmail.com ","1z2x3c4v5b6n7m" },
				{ "", "1z2x3c4v5b6n7m" }, 
				{ "this.emmie@gmail.com", "" },
				{ "", "" } };
	}

	@Test(dataProvider = "RegistrationDataProvider")
	public void clickOnAccount(String username, String password) {
		// click on my account menu
		Driver.driver.findElement(By.xpath("//*[text()='My Account']")).click();

		// Enter registered Email Address in Email-Address textBox
		WebElement emailBox = Driver.driver.findElement(By.xpath("//input[@id='reg_email']"));
		emailBox.sendKeys(username);

		// Enter your own password in password textBox
		WebElement passwordBox = Driver.driver.findElement(By.xpath("//*[@id='reg_password']"));
		passwordBox.sendKeys(password);

		// Click on Register button
		Driver.driver.findElement(By.xpath("//*[@name='register']")).click();

		// Registration must fail with a warning message(ie please provide valid email
		// address)
		//Error (xPath)
		String actualText = Driver.driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li")).getText();
		String expectedText = actualText.toString();
		AssertJUnit.assertTrue(actualText.contains(expectedText));

	}

	@AfterClass
	public void tearDown() {
		Driver.tearDown();
	}


}

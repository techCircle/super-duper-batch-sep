package anoma51TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import anomaUtilities.BaseClass;

public class Login8 {

	@BeforeMethod
	public void setUp() throws InterruptedException {
		BaseClass.getDriver();
	}

	@Test
	public void login() throws InterruptedException {

		BaseClass.driver.findElement(By.xpath("//*[@id='menu-item-50']")).click();
		BaseClass.driver.findElement(By.id("username")).sendKeys(BaseClass.getProperty("username"));
		BaseClass.driver.findElement(By.id("password")).sendKeys(BaseClass.getProperty("password"));
		BaseClass.driver.findElement(By.xpath("//input[@type='submit']")).click();
		System.out.println("log in successful");

		WebElement signoutButton = BaseClass.driver.findElement(By.xpath("//*[contains(text(),'Sign out')]"));
		signoutButton.click();
		System.out.println("sign out successful");

		// press back button
		BaseClass.driver.navigate().back();

		// verify that user shouldn’t be signed in to his account rather a general
		// webpage must be visible
		String actualURL = BaseClass.driver.getCurrentUrl().toString();
		System.out.println("genaral webpage: " + actualURL);
		String expectedURL = "http://practice.automationtesting.in/my-account/";
		Assert.assertEquals(actualURL, expectedURL);
		System.out.println(BaseClass.getProperty("text"));
	}

	@AfterMethod
	public void tearDown() {
		BaseClass.tearDown();
	}

}

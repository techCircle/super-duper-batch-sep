package anoma51TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import anomaUtilities.BaseClass;

public class Login1 {

	@BeforeMethod
	public void setUp() throws InterruptedException {	
		BaseClass.getDriver();
	}

	@Test
	public void login() {

		BaseClass.driver.findElement(By.xpath("//*[@id='menu-item-50']")).click();
		// valid username
		BaseClass.driver.findElement(By.id("username")).sendKeys(BaseClass.getProperty("username"));
		// valid password
		BaseClass.driver.findElement(By.id("password")).sendKeys(BaseClass.getProperty("password"));
		BaseClass.driver.findElement(By.xpath("//input[@type='submit']")).click();

		// verifying if it log in successfully and navigate to the next page
		String actualtitle = BaseClass.driver.getTitle().toString();
		System.out.println(actualtitle);
		String expectedTitle = "My Account – Automation Practice Site";
		Assert.assertEquals(expectedTitle,actualtitle);
		System.out.println(BaseClass.getProperty("text"));
	}

	@AfterMethod
	public void tearDown() {
		BaseClass.tearDown();
	}

}

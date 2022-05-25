package anoma51TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import anomaUtilities.BaseClass;

public class Login3 {

	@BeforeMethod
	public void setUp() throws InterruptedException {

		BaseClass.getDriver();
	}

	@Test
	public void login() {

		BaseClass.driver.findElement(By.xpath("//*[@id='menu-item-50']")).click();
		// valid username
		BaseClass.driver.findElement(By.id("username")).sendKeys(BaseClass.getProperty("username"));
		// empty password
		// driver.findElement(By.id("password")).sendKeys("");
		BaseClass.driver.findElement(By.xpath("//input[@type='submit']")).click();

		// verifying if error msg displayed and ready to enter login again

		String actualError = BaseClass.driver.findElement(By.xpath("//*[@class = 'woocommerce-error']/li")).getText();
		System.out.println(actualError);
		String expectedError = "Error: Password is required.";
		Assert.assertEquals(expectedError, actualError);
		System.out.println(BaseClass.getProperty("text"));	
	}

	@AfterMethod
	public void tearDown() {
		BaseClass.tearDown();
	}

}

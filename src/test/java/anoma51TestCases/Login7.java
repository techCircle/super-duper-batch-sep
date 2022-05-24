package anoma51TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import anomaUtilities.BaseClass;

public class Login7 {

	@BeforeMethod
	public void setUp() throws InterruptedException {

		BaseClass.getDriver();
	}

	@Test
	public void login() {

		BaseClass.driver.findElement(By.xpath("//*[@id='menu-item-50']")).click();
		//case changed username
		BaseClass.driver.findElement(By.id("username")).sendKeys("MS.AnomA@gmail.com");
		//case changed password
		BaseClass.driver.findElement(By.id("password")).sendKeys("tech9898$$");
		BaseClass.driver.findElement(By.xpath("//input[@type='submit']")).click();

		System.out.println("log in unsuccessful");
		
		// verifying if error msg displayed and ready to enter login again
		// i'm using asserttrue and .contains() iso assertequal 
		//bc i want it to be more dynamic (not showing my email in the actual error msg)
		String errorMsg = 
				BaseClass.driver.findElement(By.xpath("//*[@class = 'woocommerce-error']/li")).getText();
		System.out.println(errorMsg);
		Assert.assertTrue(errorMsg.contains("ERROR:"));
		System.out.println(BaseClass.getProperty("text"));
	}

	@AfterMethod
	public void tearDown() {
		BaseClass.tearDown();
	}

}

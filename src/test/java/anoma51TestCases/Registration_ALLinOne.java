package anoma51TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import anomaUtilities.BaseClass;



public class Registration_ALLinOne {

	@DataProvider(name = "RegistrationDataProvider")
	public Object[][] dpMethod() {
		return new Object[][] { { "ms.anoma@gmail.com", "Tech9898$$" }, 
								{ "abcdefghijklmnop@gmail.com", "Tech9898$$" },
								{ "", "Tech9898$$" }, 
								{ "ms.anoma@gmail.com", "" }, 
								{ "", "" } };
	}

	@BeforeMethod
	public void setUp() {
		BaseClass.getDriver();
	}

	@Test(dataProvider = "RegistrationDataProvider")
	public void registration(String username, String Password) throws InterruptedException {

		// Click on My Account Menu
		BaseClass.driver.findElement(By.xpath("//*[@id='menu-item-50']")).click();

		// input Email Address in Email-Address textbox
		BaseClass.driver.findElement(By.id("reg_email")).sendKeys(username);

		// input password in password textbox
		BaseClass.driver.findElement(By.id("reg_password")).sendKeys(Password);

		// Click on Register button
		Thread.sleep(3000);
		BaseClass.driver.findElement(By.xpath("//*[@name='register']")).click();
		
		//all of the tests give an error msg;
		//Error: An account is already registered with your email address. Please login.
		//Error: Please provide a valid email address.
		//I verified by using .contains "Error"
		String errorMsg = BaseClass.driver.findElement(By.xpath("//*[@class='woocommerce-error']")).getText();
		Assert.assertTrue(errorMsg.contains("Error:"));
		
		 System.out.println(BaseClass.getProperty("text"));
	}
	
	@AfterMethod
	public void tearDown() {
		BaseClass.tearDown();
	}
}

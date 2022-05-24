package anoma51TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import anomaUtilities.BaseClass;


public class Login6 {

	@BeforeMethod
	public void setUp() throws InterruptedException {

		BaseClass.getDriver();
	}

	@Test
	public void login() {
		
		//click menu
		BaseClass.driver.findElement(By.xpath("//*[@id='menu-item-50']")).click();
		//input password
		WebElement password = BaseClass.driver.findElement(By.id("password"));
		password.sendKeys(BaseClass.getProperty("password"));
		System.out.println(password);
		
		//The password field should display the characters in asterisks or bullets 
		//the password is not visible on the screen
		String expectedText = BaseClass.driver.findElement(By.xpath("//*[@id='password']")).getAttribute("type");
		System.out.println(expectedText);		
		Boolean type =  expectedText.equals("password");
		Assert.assertTrue(type);
		System.out.println(BaseClass.getProperty("text"));
	}

	@AfterMethod
	public void tearDown() {
    	BaseClass.tearDown();
	}

}

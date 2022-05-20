package SeleniumDay_10;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Utilities.Driver;

public class dependsOnTestCaseForRegistration {
	
	
	@DataProvider(name = "RegistrationDataProvider")
	public Object[][] dpMethod() {
		return new Object[][] { { "","!12345bee!12345bee!12345bee!12345bee" }, { "be_bee@gmail.com","!12345bee!12345bee!12345bee!12345bee" }, { "hello","InvalidPassword" } };
	}

  
  @BeforeMethod
  public void setUp(){
      Driver.getDriver();
  }

  @Test(dataProvider="RegistrationDataProvider")
  public void registrationWithEmptyEmailID(String username, String Password) throws InterruptedException {
	  
	  
      //3) Click on My Account Menu
      Driver.driver.findElement(By.xpath("//*[text()='My Account']")).click();

      //4) Enter empty Email Address in Email-Address textbox
      WebElement emailBox = Driver.driver.findElement(By.xpath("//input[@id='reg_email']"));
      emailBox.sendKeys(username);

      //5) Enter your own password in password textbox
      WebElement passwordBox = Driver.driver.findElement(By.xpath("//input[@id='reg_password']"));
      //passwordBox.click();
      passwordBox.sendKeys(Password);

      //6) Click on Register button
      Thread.sleep(3000);
      Driver.driver.findElement(By.xpath("//*[@name='register']")).click();


      //7) Registration must fail with a warning message(ie please provide valid email address)

      String actualText = Driver.driver.findElement(By.xpath("//*[text()=' Please provide a valid email address.']")).getText();

      String expectedText = "Please provide a valid email address.";

      Assert.assertTrue(actualText.contains(expectedText));
  }
  
  
  
  
  
  
}

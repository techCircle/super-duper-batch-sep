package anoma51TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import anomaUtilities.BaseClass;

public class Shop3 {

	@BeforeMethod
	public void setUp() throws InterruptedException {
		BaseClass.getDriver();
	}

	@Test
	public void shop() {

		// Click shop
		BaseClass.driver.findElement(By.xpath("//*[contains(text(),'Shop')]")).click();
		// default sorting
		Select select = new Select(BaseClass.driver.findElement(By.xpath("//*[@class='orderby']")));
		// select popularity from the dropdownbox
		select.selectByIndex(1);

		// verify if user be able to view the popular products 
		String popularityURL = BaseClass.driver.getCurrentUrl().toString();
		System.out.println("url: " + popularityURL);
		Assert.assertEquals("http://practice.automationtesting.in/shop/?orderby=popularity", popularityURL);
		System.out.println(BaseClass.getProperty("text"));
	}

	@AfterMethod
	public void tearDown() {
		BaseClass.tearDown();
	}
}

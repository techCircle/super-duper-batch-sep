package anoma51TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import anomaUtilities.BaseClass;


public class Shop6 {

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
		// select low to high from the dropdownbox
		select.selectByValue("price");

		// verify if user be able to view the popular products --> false
		String priceURL = BaseClass.driver.getCurrentUrl().toString();
		System.out.println("url: " + priceURL);
		String popularityURL = "http://practice.automationtesting.in/shop/?orderby=popularity";
		Assert.assertNotSame(popularityURL, priceURL);
		System.out.println(BaseClass.getProperty("text"));
	}

	@AfterMethod
	public void tearDown() {
		BaseClass.tearDown();
	}
}

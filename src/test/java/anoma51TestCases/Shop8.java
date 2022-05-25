package anoma51TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import anomaUtilities.BaseClass;

public class Shop8 {

	@BeforeMethod
	public void setUp() throws InterruptedException {
		BaseClass.getDriver();
	}

	@Test
	public void shop() {

		//Click shop
		BaseClass.driver.findElement(By.xpath("//*[contains(text(),'Shop')]")).click();
		//click read more button
		BaseClass.driver.findElement(By.xpath("//*[contains(text(),'Read more')]")).click();
		
		//Read More option indicates the Out Of Stock.
		//verify that user cannot add the product which has read more option as it was out of stock.
        String outOfStockCheck = BaseClass.driver.findElement(By.xpath("//*[@class='stock out-of-stock']")).getText();
        Assert.assertTrue(outOfStockCheck.contains("Out of stock"));
        System.out.println(BaseClass.getProperty("text"));
	}

	@AfterMethod
	public void tearDown() {
		BaseClass.tearDown();
	}
}

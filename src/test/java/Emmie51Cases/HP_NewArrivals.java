package Emmie51Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.Driver;

public class HP_NewArrivals {
	@Test
	public void newArrival() throws InterruptedException {

		WebElement shop = Driver.driver.findElement(By.xpath("//*[text()='Shop']"));
		shop.click();

		// navigate to Home
		WebElement home = Driver.driver.findElement(By.xpath("//*[text()='Home']"));
		home.click();

		// navigate to new arrivals // select book in the middle
		Driver.driver
				.findElement(By.xpath("//*[@class='row_inner_wrapper']"))
				.click();
		Thread.sleep(3000);
		// *** book is currently out of stock so i navigate to RELATED PRODUCTS
		System.out.println("Three Arrival has been appeared !");

		// navigate to Description of the book
		WebElement description = Driver.driver.findElement(By.xpath("//*[text()='Description']"));
		description.click();

		Thread.sleep(3000);
		System.out.println("Description clicked! ");

		String acutalText = Driver.driver.findElement(By.xpath("//*[@id='tab-description']")).getText();
		String expectText = acutalText.toString();
		Assert.assertTrue(acutalText.contains(expectText));
		Thread.sleep(3000);

		// review book
		WebElement review = Driver.driver.findElement(By.xpath("//*[text()='Reviews (0)']"));
		review.click();

	}

	@BeforeMethod
	public void setUp() {
		Driver.getDriver();
	}

	@AfterMethod
	public void afterMethod() {
		Driver.tearDown();
	}


}

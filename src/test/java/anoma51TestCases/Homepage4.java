package anoma51TestCases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import anomaUtilities.BaseClass;

public class Homepage4 {

	@BeforeMethod
	public void setUp() throws InterruptedException {
		BaseClass.getDriver();
	}

	@Test(priority = 1)
	public void newArrival() {

		BaseClass.driver.findElement(By.id("menu-item-40")).click();
		BaseClass.driver.findElement(By.xpath("//*[contains(text(),'Home')]")).click();

		List<WebElement> newArrivals = BaseClass.driver.findElements(
				By.xpath("//*[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div"));

		int items = newArrivals.size();
		System.out.println(items);

		assert (items == 3);

		System.out.println(BaseClass.getProperty("text"));
	}

	// Test whether it is navigating to next page where the user can add that book
	// into his basket.
	// Image should be clickable and should navigate to next page where user can add
	// that book to his basket

	@Test(priority = 2)
	public void ruby() {

		WebElement ruby = BaseClass.driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-2-0-0'] "));
		ruby.click();

		String actualTxt = BaseClass.driver
				.findElement(By.xpath("//*[contains(text(),'Selenium Ruby') and@class='product_title entry-title']"))
				.getText();
		System.out.println(actualTxt);
		String expectedTxt = "Selenium Ruby";

		Assert.assertEquals(expectedTxt, actualTxt);
		System.out.println("Selenium Ruby image is clickable and navigate to the next page");
		System.out.println("Unable to add that book into the basket, because it is 'OUT OF STOCK'.");

//		Click on Description tab for the book you clicked on.
		BaseClass.driver.findElement(By.xpath("//*[@class='description_tab active']")).click();
//		There should be a description regarding that book the user clicked on
		String actualDescription = BaseClass.driver.findElement(By.xpath("//*[contains(text(),'Product Description')]"))
				.getText();
		String expectedDescription = "Product Description";
		Assert.assertEquals(expectedDescription, actualDescription);
		
		System.out.println(BaseClass.getProperty("text"));
	}

	@Test(priority = 3)
	public void HTML() {

		WebElement HTML = BaseClass.driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-2-1-0']"));
		HTML.click();

		String actualTxt = BaseClass.driver
				.findElement(By.xpath("//*[contains(text(),'Thinking in HTML') and@class='product_title entry-title']"))
				.getText();
		System.out.println(actualTxt);
		String expectedTxt = "Thinking in HTML";

		Assert.assertEquals(expectedTxt, actualTxt);
		System.out.println("Thinking in HTML image is clickable and navigate to the next page");
		System.out.println("Unable to add that book into the basket, because it is 'OUT OF STOCK'.");

//		Click on Description tab for the book you clicked on.
		BaseClass.driver.findElement(By.xpath("//*[@class='description_tab active']")).click();
//		There should be a description regarding that book the user clicked on
		String actualDescription = BaseClass.driver.findElement(By.xpath("//*[contains(text(),'Product Description')]"))
				.getText();
		String expectedDescription = "Product Description";
		Assert.assertEquals(expectedDescription, actualDescription);
		
		System.out.println(BaseClass.getProperty("text"));
	}

	@Test(priority = 4)
	public void javaScript() {

		WebElement javaScript = BaseClass.driver.findElement(By.xpath("//*[@id='text-22-sub_row_1-0-2-2-0']"));
		javaScript.click();

		String actualTxt = BaseClass.driver
				.findElement(
						By.xpath("//*[contains(text(),'Mastering JavaScript') and@class='product_title entry-title']"))
				.getText();
		System.out.println(actualTxt);
		String expectedTxt = "Mastering JavaScript";

		Assert.assertEquals(expectedTxt, actualTxt);
		System.out.println("Mastering JavaScript image is clickable and navigate to the next page");
		System.out.println("Unable to add that book into the basket, because it is 'OUT OF STOCK'.");

//		Click on Description tab for the book you clicked on.
		BaseClass.driver.findElement(By.xpath("//*[@class='description_tab active']")).click();
//		There should be a description regarding that book the user clicked on
		String actualDescription = BaseClass.driver.findElement(By.xpath("//*[contains(text(),'Product Description')]"))
				.getText();
		String expectedDescription = "Product Description";
		Assert.assertEquals(expectedDescription, actualDescription);
		
		System.out.println(BaseClass.getProperty("text"));
	}

	@AfterMethod
	public void tearDown() {
		BaseClass.tearDown();
	}

}

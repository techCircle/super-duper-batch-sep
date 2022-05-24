package Emmie51Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.Driver;

public class Shop_Functionality {

	@Test
	public void priceFunctionality() {
		WebElement shop = Driver.driver.findElement(By.xpath("//*[text()='Shop']"));
		shop.click();

		// try to slide on price functional 
		WebElement filterByPrice = Driver.driver
				.findElement(By.xpath("//*[@id='woocommerce_price_filter-2']/form/div/div[1]/div"));
		
		Actions action = new Actions(Driver.driver);
		action.dragAndDropBy(filterByPrice, 0, 300).build().perform();
		
		
	}

	@BeforeMethod
	public void setUp() {
		Driver.getDriver();
	}

//	@AfterMethod
//	public void closeBrowser() {
//		Driver.tearDown();
//	}
}

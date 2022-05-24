package Emmie51Cases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.Driver;

public class HP_AddBasket {
Select select;
	
	@Test
	public void addToBasket() throws InterruptedException {
		
		WebElement shop = Driver.driver.findElement(By.xpath("//*[text()='Shop']"));
		shop.click();
		
		// navigate to Home
		WebElement home = Driver.driver.findElement(By.xpath("//*[text()='Home']"));
		home.click();
		
		
		// navigate to new arrivals // select book in the middle
		WebElement bookSelected = Driver.driver
				.findElement(By.xpath("//*[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']"));
		bookSelected.click();
				
		Thread.sleep(3000);
	
		// *** book is currently out of stock so i navigate to RELATED PRODUCTS
		WebElement addToBasket = Driver.driver.findElement(By.xpath("//*[@id='product-163']/div[5]/ul/li[1]/a[2]"));
		addToBasket.click();
		
		//view basket 
		WebElement viewBasket = Driver.driver.findElement(By.xpath("//*[text()='View Basket']"));
		viewBasket.click();
		
		// item in cart
		WebElement itemButton = Driver.driver.findElement(By.xpath("//*[@class='cartcontents']"));
		itemButton.click();
		 
		// add more quantity 
		
	}

	@BeforeMethod
	public void setUp() {
		Driver.getDriver();
	}

	@AfterMethod
	public void tearDown() {
		Driver.tearDown();

	}

}

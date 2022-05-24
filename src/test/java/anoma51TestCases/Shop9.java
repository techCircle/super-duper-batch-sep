package anoma51TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import anomaUtilities.BaseClass;

public class Shop9 {

	@BeforeMethod
	public void setUp() throws InterruptedException {
		BaseClass.getDriver();
	}

	@Test
	public void shop() {

		//Click shop
		BaseClass.driver.findElement(By.xpath("//*[contains(text(),'Shop')]")).click();
		//click sale button
		BaseClass.driver.findElement(By.xpath("//*[@id='content']/ul/li[1]/a[1]/span[1]")).click();
		
		//verify if user can view the actual price with old price striken for the sale written products		
        String originalPrice = BaseClass.driver.findElement(By.xpath("//*[@class='price']/del/span")).getText();
        System.out.println(originalPrice);
        Assert.assertTrue(originalPrice.contains("600.00"));        
        
        String salePrice = BaseClass.driver.findElement(By.xpath("//*[@class='price']/ins/span")).getText();
        System.out.println(salePrice);
        Assert.assertTrue(salePrice.contains("450.00"));
        
        System.out.println(BaseClass.getProperty("text"));
	}

	@AfterMethod
	public void tearDown() {
		BaseClass.tearDown();
	}
}

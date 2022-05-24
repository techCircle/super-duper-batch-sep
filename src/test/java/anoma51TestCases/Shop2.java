package anoma51TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import anomaUtilities.BaseClass;

public class Shop2 {
	
    @BeforeMethod
    public void setUp() throws InterruptedException {
    	BaseClass.getDriver();
    }
    
    @Test
    public void shop() {
    	//Click shop
    	BaseClass.driver.findElement(By.xpath("//*[contains(text(),'Shop')]")).click();
    	//Click any of the product links available in the product category
    	BaseClass.driver.findElement(By.xpath("//*[@id='woocommerce_product_categories-2']/ul/li[1]/a")).click();
    	
    	//verify if user can view only that particular product
        String productItem = BaseClass.driver.findElement(By.xpath("//*[@id='content']/ul/li/a/h3")).getText();
        System.out.println(productItem);        
        Assert.assertEquals("Android Quick Start Guide", productItem);
        System.out.println(BaseClass.getProperty("text"));
    }

    @AfterMethod
    public void tearDown() {
    	BaseClass.tearDown();
    }
    	

}

package anoma51TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import anomaUtilities.BaseClass;

public class Shop1 {
	
    @BeforeMethod
    public void setUp() throws InterruptedException {
    	BaseClass.getDriver();
    }
    
    @Test
    public void shop() {
    	//Click shop
    	BaseClass.driver.findElement(By.xpath("//*[contains(text(),'Shop')]")).click();
    	//slider xpath
    	WebElement slider = 
    			BaseClass.driver.findElement(By.xpath("//*[@id=\"woocommerce_price_filter-2\"]/form/div/div[1]/span[2]"));
    	
    	Actions act = new Actions(BaseClass.driver);
    	act.dragAndDropBy(slider,-28, 0).perform();
    	
    	WebElement filterButton = 
    			BaseClass.driver.findElement(By.xpath("//*[@class='button']"));
    	filterButton.click();
        
        String selectPrice = BaseClass.driver.getCurrentUrl().toString();
        System.out.println(selectPrice);    
        String expectedPrice = "http://practice.automationtesting.in/shop/?min_price=150&max_price=451";
        Assert.assertEquals(selectPrice, expectedPrice);
        System.out.println(BaseClass.getProperty("text"));
    }

    @AfterMethod
    public void tearDown() {
    	BaseClass.tearDown();
    }    	
}

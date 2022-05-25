package anoma51TestCases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import anomaUtilities.BaseClass;

public class Homepage2 {

    @BeforeMethod
    public void setUp() throws InterruptedException {
    	BaseClass.getDriver();
    }
    
    @Test
    public void newArrival() {
    	
    	BaseClass.driver.findElement(By.id("menu-item-40")).click();
    	BaseClass.driver.findElement(By.xpath("//*[contains(text(),'Home')]")).click();

            
    	List<WebElement> newArrivals = BaseClass.driver.findElements(By.xpath("//*[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div"));
    	
            int items = newArrivals.size();
            System.out.println(items);
    	
            assert(items==3);
            System.out.println(BaseClass.getProperty("text"));
        }
    
    @AfterMethod
    public void tearDown() {
    	BaseClass.tearDown();
    }
}


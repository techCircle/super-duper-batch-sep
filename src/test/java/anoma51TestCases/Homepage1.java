package anoma51TestCases;

import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import anomaUtilities.BaseClass;

public class Homepage1 {

    @BeforeMethod
    public void setUp() throws InterruptedException {
    	BaseClass.getDriver();	 
    }
    
    @Test
    public void slidders() {
    	BaseClass.driver.findElement(By.id("menu-item-40")).click();
    	BaseClass.driver.findElement(By.xpath("//*[contains(text(),'Home')]")).click();
    	
    	List<WebElement> threeSlides = BaseClass.driver.findElements(By.xpath("//*[@id='themify_builder_content-22']/div"));
    	
        int slides = threeSlides.size();
        System.out.println(slides+"slides");
	
        assert(slides==3);
        System.out.println(BaseClass.getProperty("text"));
    }

    @AfterMethod
    public void tearDown() {
    	BaseClass.tearDown();
    }


}

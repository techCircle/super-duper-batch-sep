package SeleniumDay7;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class iframesTest {
	
	WebDriver driver;
	Actions act;
	
	@BeforeMethod
	public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://jqueryui.com/droppable/");
        // driver.manage().window().maximize();

        // implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    
    @Test
    public void drop() {
        act = new Actions(driver);
        
        System.out.println(driver.findElements(By.tagName("iframe")).size());
        
        driver.switchTo().frame(0);
        
        WebElement box = driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement target = driver.findElement(By.xpath("//*[@id='droppable']"));    
        act.dragAndDrop(box, target).build().perform();
        
        driver.switchTo().defaultContent();
        
    }
	
	
	
	
	
	

}

package Victor51TestCases;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HomePage {
	Actions action;
	WebDriver driver;
	@Before
    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("http://practice.automationtesting.in/");
        driver.manage().window().maximize();
        // implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	
	 @Test
	    public void dragAndDropTest1 () {
	    	//click in shop
	    	WebElement Shop = driver.findElement(By.id("menu-item-40"));
	    	Shop.click();
	    	//go back home
	    	WebElement home = driver.findElement(By.xpath("//*[@id='content']/nav/a"));
	    	home.click();
	    	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    	assert(driver.findElements(By.xpath("//div[@class=\"n2-ss-slider-3\"]/div")).size() == 3);
	 }
	 
	 @After
	    public void tearDown() {
	    	driver.close();
	    }
}

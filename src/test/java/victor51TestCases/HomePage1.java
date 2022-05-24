package victor51TestCases;

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

public class HomePage1 {
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
	    	WebElement slider = driver.findElement(By.xpath("//*[@id=\"n2-ss-6\"]/div[1]/div/div/div[1]/div[1]/img"));
	    
	    	action.clickAndHold(slider);
	    	action.moveByOffset(0, -1000).build();
	    
	 }
	 
	 @After
	    public void tearDown() {
	    	driver.close();
	    }

	
}


package SeleniumDay5;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class autoSuggestionBox {
	
	
	
	WebDriver driver;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.makemytrip.com/");
		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
    public void Test1() throws InterruptedException {
        driver.findElement(By.xpath("//*[@id=\"SW\"]/div[1]/div[1]/ul/li[2]/div[2]")).click();
        // From
        driver.findElement(By.xpath("//*[@id='fromCity']")).click();
      
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/div[1]/div[1]/div[1]/div/div/div/input")).sendKeys("URC");
   
        Thread.sleep(3000);
        
        driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();
        
        Thread.sleep(1000);
        
        driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[3]/div/div/div[2]/div[1]/div[2]/div[1]/div/div/div/input")).sendKeys("BKK");

        Thread.sleep(3000);
        
        driver.findElement(By.id("react-autowhatever-1-section-0-item-0")).click();

//        react-autowhatever-1-section-0-item-0
      
	}
	
	
	
	
	
	
	

}

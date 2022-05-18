package HomeWorkReview;

import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkoutboxTesting3 {
	
	
//	homework
//	1. go to https://demoqa.com/checkbox
//	2. expand all the checkboxes
//	3. verify if all the checkboxes are unchecked by default
//	4. click on 'Home', Parent Checkbox
//	5. now verify if all the checkboxes are checked
	
	static WebDriver driver;
	static WebDriverWait wait;
	
	
	@BeforeClass
	public static void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/checkbox");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver,3); 
		
	}
	
	@Test
	public void expand() {
		
		driver.findElement(By.xpath("//*[@id=\"tree-node\"]/div/button[1]")).click();
//		driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button/svg")).click();
//		driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button/svg")).click();
//		driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button/svg")).click();
//		driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/button/svg")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void verify() {
		
		Boolean verify = driver.findElement(By.xpath("(//*[@class='rct-icon rct-icon-uncheck'])[1]")).isSelected();
//		System.out.println(verify);            false
		if (verify) {
			System.out.println("Test Fail");
			System.out.println("Check bixes are not all unchecked");
		}else {
			System.out.println("Check Boxes Unchecked");
		}
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}
	
	@Test
	public void checkHomeButton() {
		
		driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label/span[1]")).click();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		Boolean verify = driver.findElement(By.xpath("(//*[@class='rct-icon rct-icon-uncheck'])[1]")).isSelected();
		System.out.println(verify);
	}
	
	@Test
	public void verityCheck() {
		
		Boolean home = driver.findElement(By.xpath("//*[@id=\"result\"]/span[2]")).isDisplayed();
//		System.out.println(home);
		
		if(home) {
			System.out.println("All Boxes Checked");
		}else {
			System.out.println("Test Failed");
			System.out.println("Not all boxes are checked");
		}
		
	}

	

}

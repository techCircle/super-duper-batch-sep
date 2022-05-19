package SeleniumDay3;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class testGoogleSite {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
	}
	
	@Test
	public void searchItem() {
		WebElement searchInputBox=driver.findElement(By.name("q"));
//		FarukWay
//		searchInputBox.sendKeys("TechCircle School");
//		searchInputBox.submit();
		
		driver.findElement(By.name("q")).sendKeys("TechCircle School", Keys.ENTER);
		
	}
	
	
	

}

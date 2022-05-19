package SeleniumDay5;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class staticDropDown {
	
	WebDriver driver;
	Select select;
	
	@BeforeMethod
	public void setUp() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		driver.manage().window().maximize();

		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	@Test
	public void staticDropDown() throws InterruptedException {
		
		//loggin in
		driver.findElement(By.id("txtUsername")).sendKeys("Admin");
		driver.findElement(By.id("txtPassword")).sendKeys("admin123");
		driver.findElement(By.id("btnLogin")).click();
		
		
		//navigating to Admin page
		driver.findElement(By.id("menu_admin_viewAdminModule")).click();
		
		

		select = new Select(driver.findElement(By.id("searchSystemUser_userType")));
		
		select.selectByVisibleText("Admin");
		Thread.sleep(3000);
		select.selectByIndex(2);
		Thread.sleep(3000);
		select.selectByValue("0");
		Thread.sleep(3000);

		
		
		select = new Select(driver.findElement(By.id("searchSystemUser_status")));

		
		select.selectByVisibleText("Enabled");
		Thread.sleep(3000);
		select.selectByIndex(2);
		Thread.sleep(3000);
		select.selectByIndex(0);
		Thread.sleep(3000);
		
		
		
	}
	
	
	
	
	
	
	
	
	

}

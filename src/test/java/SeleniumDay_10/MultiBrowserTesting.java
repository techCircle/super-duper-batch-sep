package SeleniumDay_10;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MultiBrowserTesting {
	
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeClass
	public void BeforeClass(String browser) {
		

		  if(browser.equalsIgnoreCase("firefox")) {
			 
			  WebDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver();	  

		  }else if (browser.equalsIgnoreCase("chrome")) { 
			  WebDriverManager.chromedriver().setup();

			  driver = new ChromeDriver();

		  } 


		  driver.get("https://www.techcircleschool.com"); 

		  }
		
		
	
		@Test
		public void login() {
			System.out.println("Test1");
		}
	
	
	
	
		
	}
	

package PracticeAutomation51TestCases.HomePage18;

import java.util.List;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class _1HomePageWithThreeSlidersOnly {

		
		/*1. Home Page with three Sliders only
		 * 1) Open the browser
2) Enter the URL ��http://practice.automationtesting.in/��
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Sliders only
6) The Home page must contains only three sliders
		 */

	
	WebDriver driver;
	
	@BeforeClass
		
		
    public void setUp() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://practice.automationtesting.in/");
        
        // implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	
	@Test
	public void ThreeSliders() {
			
			WebElement shopMenu = driver.findElement(By.xpath("//*[@id='menu-item-40']/a"));
			
			shopMenu.click();
			
			WebElement siteLogoHomeMenu = driver.findElement(By.xpath("//*[@id='content']/nav/a"));
			siteLogoHomeMenu.click();
			
			//			5) Test whether the Home page has Three Sliders only
			List<WebElement> sliders = driver.findElements(By.xpath("//*[@class='n2-ss-slider-3']/div"));
			
//			6) The Home page must contains only three sliders

			// Check if the number of sliders is 3
			Assert.assertEquals(3, sliders.size());
			
	}

	@AfterClass
	public void tearDown() {
		driver.close();
			
	}

	}
					
			

		


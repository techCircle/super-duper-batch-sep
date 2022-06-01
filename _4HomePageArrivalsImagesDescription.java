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

public class _4HomePageArrivalsImagesDescription {

	/*
	 * 1) Open the browser
2) Enter the URL ��http://practice.automationtesting.in/��
3) Click on Shop Menu
4) Now click on Home menu button
5) Test whether the Home page has Three Arrivals only
6) The Home page must contains only three Arrivals
7) Now click the image in the Arrivals
8) Test whether it is navigating to next page where the user can add that book into his basket.
9) Image should be clickable and shoul navigate to next page where user can add that book to his basket

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
	public void ImagesDescription() {
			
			WebElement shopMenu = driver.findElement(By.xpath("//*[@id='menu-item-40']/a"));
			
			shopMenu.click();
			
			WebElement siteLogoHomeMenu = driver.findElement(By.xpath("//*[@id='content']/nav/a"));
			siteLogoHomeMenu.click();
				
//				5) Test whether the Home page has Three Arrivals only
				List<WebElement> arrivals = driver.findElements(By.xpath("//*[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div"));
				//*[@class='themify_builder_sub_row clearfix gutter-default   sub_row_1-0-2']/div
				
//				6) The Home page must contains only three Arrivals
				Assert.assertEquals(3, arrivals.size());

//				7) Now click the image in the Arrivals
				
				WebElement arrival3 = driver.findElement(By.xpath("//*[@id=\"themify_builder_content-22\"]/div[2]/div/div/div/div/div[2]/div[3]"));
				arrival3.click();
				//*[@id="themify_builder_content-22"]/div[2]/div/div/div/div/div[2]/div[1]
				//*[@id="themify_builder_content-22"]/div[2]/div/div/div/div/div[2]/div[3]

//				8) Test whether it is navigating to next page where the user can add that book into his basket.
				WebElement clickBook1 = driver.findElement(By.xpath("//*[@id=\"product-165\"]/div[5]/ul/li[1]/a[1]"));
				clickBook1.click();
				
				//*[@id="product-165"]/div[5]/ul/li[1]/a[1]
				//*[@id="product-170"]/div[5]/ul/li/a[1]
				
//				9) Image should be clickable and should navigate to next page where user can add that book to his basket
				WebElement addToBasket1 = driver.findElement(By.xpath("//*[@id=\"product-170\"]/div[2]/form/button"));
				addToBasket1.click();
				//*[@id="product-170"]/div[2]/form/button
				
//				WebElement viewBasket1 = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/a"));
//				viewBasket1.click();
				
//				10) Click on Description tab for the book you clicked on.
				WebElement description1 = driver.findElement(By.xpath("//*[@id=\"product-170\"]/div[3]/ul/li[1]"));
				description1.click();
				
				//*[@id="product-170"]/div[3]/ul/li[1]
				
//				11) There should be a description regarding that book the user clicked on
				
		        Boolean descriptionText = driver.findElement(By.id("tab-description")).isDisplayed();

		        Assert.assertTrue(descriptionText);
		        
				
//		        String actualDescriptionText = driver.findElement(By.id("tab-description")).getText();

//		        System.out.println(actualDescriptionText);
		        
//		        String expectedDescriptionText = "Product Description";
////
//		        Assert.assertEquals(expectedDescriptionText, actualDescriptionText);
				
		      //*[@id="tab-description"]
				//*[@id="tab-description"]
		      //*[@id="tab-description"]/h2
				

		}

		@AfterClass
		public void tearDown() {
			driver.close();
				
		}
}


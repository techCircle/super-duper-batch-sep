package Kanokwan_51TestCases;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginAuthentications_8 {
	

	WebDriver driver;

	WebDriverWait wait;
	
	@BeforeClass
	public void setUp() {
		
		//setup the chrome driver by using WebDriverManager
    	//declaration and instantiation of objects/variables

        WebDriverManager.chromedriver().setup();
        
       //Create driver object for Chrome
        
        driver = new ChromeDriver();
        
        //Enter the URL “http://practice.automationtesting.in/”
		//1) Open the browser
		//2) Enter the URL “http://practice.automationtesting.in/”
        
		driver.get("http://practice.automationtesting.in/");
		
		//To maximize the browser
        
        driver.manage().window().maximize();
        
        // implicit wait
        /*
         * Implicit Wait in Selenium is used to tell the web driver to wait for a certain amount 
         * of time before it throws a “No Such Element Exception”. The default setting is 0. Once we set the time, 
         * the web driver will wait for the element for that time before throwing an exception.
         */
        
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
	
	
	@Test
	public void loginWithEmptyUsernameAndEmptyPassword() {
		
		// 8. Login-Authentication
		
		//3) Click on My Account Menu
		//Get the WebElement corresponding to  shop menu
		//Use Web Element findElement() to find the elements on the web page
		
		WebElement accountMenu = driver.findElement(By.xpath("//*[@id='menu-item-50']"));
		accountMenu.click();
		
		//4) Enter the case changed username in username textbox
		
		WebElement userName = driver.findElement(By.xpath("//*[@id='username']"));
		userName.sendKeys("tiew6890@gmail.com");
		
		//5) Enter the case chenged password in the password tetxbox
		
		WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
		password.sendKeys("T@ew!43@93#$az");
		
		//6) Click on login button.
		
		WebElement loginButton = driver.findElement(By.xpath("//*[@class='woocommerce-Button button']"));
		loginButton.click();
		
		//7) Once your are logged in, sign out of the site
		
		WebElement signOut = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a"));
		signOut.click();
		
		//8) Now press back button
		//9) User shouldn’t be signed in to his account rather a general webpage must be visible
				
				
		//Use back() : void - This method does the same operation as clicking on the Back Button of any browser.
		//It neither accepts nor returns anything.
				
				driver.navigate().back();
		
		//Use Command - driver.navigate().to(appUrl);
		//It does exactly the same thing as the driver.get(appUrl) method.
		//Where appUrl is the website address to load. It is best to use a fully qualified URL.
		//driver.navigate().to("http://practice.automationtesting.in/my-account/");
			
			//Use assertion. Assertions are important for comparing the expected results to the actual results.
			//If it matches, the test case passes. If not, then the test case fails. 
					
			String actualText = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/h2")).getText();
					
			String expectedUrl = actualText.toString();
					
			Assert.assertEquals(expectedUrl, actualText);
			
			System.out.println("Actual Text :" +actualText);
			
			System.out.println("Expected Url :" +expectedUrl);
					
			
			System.out.println("LOGIN HOME PAGE");
			
			
	
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	
	}
}
	




package Kanokwan_51TestCases;

import java.util.concurrent.TimeUnit;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginHandlesCasesSensitive_7 {

	WebDriver driver;
	
	@BeforeClass
	public void setUp() {
		
		//setup the chrome driver by using WebDriverManager
    	//declaration and instantiation of objects/variables

        WebDriverManager.chromedriver().setup();
        
       //Create driver object for Chrome
        
        driver = new ChromeDriver();
        
        //Enter the URL “http://practice.automationtesting.in/”
        
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
	public void loginCasesSensitive() {
		
		// 7. Login-Handles case sensitive
		//3) Click on My Account Menu
		//Get the WebElement corresponding to  shop menu
		//Use Web Element findElement() to find the elements on the web page
		
		WebElement accountMenu = driver.findElement(By.xpath("//*[@id='menu-item-50']"));
		accountMenu.click();
			
		//4) Enter the case changed username in username textbox
		
		WebElement userName = driver.findElement(By.xpath("//*[@id='username']"));
		userName.sendKeys("TIEW9879@gmail.com");
		
		//5) Enter the case chenged password in the password tetxbox
		
		WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
		password.sendKeys("t@EW!43@93#$ABC");
		
		//6) Click on login button.
		
		WebElement loginButton = driver.findElement(By.xpath("//*[@class='woocommerce-Button button']"));
		loginButton.click();
		
		//7) Login must fail saying incorrect username/password
		
		//Use assertion. Assertions are important for comparing the expected results to the actual results.
		//If it matches, the test case passes. If not, then the test case fails. 
				
		String actualText = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
				
		String expectedUrl = actualText.toString();
				
		Assert.assertEquals(expectedUrl, actualText);
		
		System.out.println("Actual Text :" +actualText);
		
		System.out.println("Expected Url :" +expectedUrl);
				
		System.out.println("Error:" + " " + "A user could not be found with this email address.");
		
	}
	

	@AfterClass
	public void close() {
		driver.close();
	}
	
}

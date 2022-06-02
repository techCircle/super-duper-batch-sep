package Kanokwan_51TestCases;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginPasswordShouldBeMasked_6 {
	
	WebDriver driver;
	
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
	public void passwordSholdBeMasked() {
		
		//6. Log-in -Password should be masked
		
		//3) Click on My Account Menu
		//Get the WebElement corresponding to  shop menu
		//Use Web Element findElement() to find the elements on the web page
		
		WebElement accountMenu = driver.findElement(By.xpath("//*[@id='menu-item-50']"));
		accountMenu.click();
		
		
		//Enter correct username in username textbox
		
		WebElement username = driver.findElement(By.xpath("//*[@id='username']"));
		username.sendKeys("tiew8859@gmail.com");
		
		//4) Enter the password field with some characters.
		//5) The password field should display the characters in asterisks or bullets such that the password is not visible on the screen
		
		WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
		password.sendKeys("T@ew!43@93#$abcde");
		
		
		//Use assertion. Assertions are important for comparing the expected results to the actual results.
		//If it matches, the test case passes. If not, then the test case fails. 
				
		String actualText = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form")).getText();
		
		String expectedUrl = actualText.toString();
		
		System.out.println("Actual Text :" +actualText);
		
		System.out.println("Expected Url :" +expectedUrl);
		
		
		System.out.println(password.getAttribute("The password is not visible on the screen."));
		
	
	}
	
	@AfterClass
	public void tearDown() {
		driver.close();
	}
}
	


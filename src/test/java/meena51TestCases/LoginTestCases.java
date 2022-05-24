package meena51TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.Driver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTestCases {

	WebDriver driver;
	Actions act;
	
	@BeforeTest
	public void setUp() throws InterruptedException {

		Driver.getDriver();
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://practice.automationtesting.in");
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	
	
	@Test (priority=1)
	public void login() {
	/*
	1) Open the browser
	2) Enter the URL “http://practice.automationtesting.in/”
	3) Click on My Account Menu
	4) Enter registered username in username textbox
	5) Enter password in password textbox
	6) Click on login button
	7) User must successfully login to the web page
	*/
		
		
		// My Account button
			driver.findElement(By.xpath("//*[@id='menu-item-50']")).click();
		
		//Enter register username
			driver.findElement(By.xpath("//*[@id='username']")).sendKeys("meena@gmail.com");
		//Enter password
			driver.findElement(By.xpath("//*[@id='password']")).sendKeys("A12bc34de56@");
		
		//login
			driver.findElement(By.xpath("//*[@class='woocommerce-Button button']")).click();

		
		//7) User must successfully login to the web page
			String expectText = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[2]")).getText();
			Assert.assertTrue(expectText.contains("From your account dashboard you can view your"));

		System.out.println(" User successfully login to the web page!");
		
		System.out.println("------------------------------------------------------");
	}
		
	
	
	
	
	@Test (priority=2)
	public void invalidUserNamePassword() {
		/*1) Open the browser
		2) Enter the URL “http://practice.automationtesting.in/”
		3) Click on My Account Menu
		4) Enter incorrect username in username textbox
		5) Enter incorrect password in password textbox.
		6) Click on login button
		7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
*/
		
	// My Account button
		driver.findElement(By.xpath("//*[@id='menu-item-50']")).click();
	
//		WebDriverWait wait = new WebDriverWait(driver,30);
//		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id='username']")));
//		// click on the compose button as soon as the "compose" button is visible
		
	//Enter incorrect username
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("me@gmail.com");
	//Enter incorrect password
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("a12bc34de56@");
	//click login
		driver.findElement(By.xpath("//*[@class='woocommerce-Button button']")).click();
	
	
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	//7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
		String expectText = driver.findElement(By.xpath("//*[@class='woocommerce-error']/li")).getText();
		Assert.assertTrue(expectText.contains("ERROR: The password you entered for the username me@gmail.com is incorrect."));

	
	System.out.println("------------------------------------------------------");
}
	
	
	
	@Test (priority=3)
	public void validEmailEmptyPassword() {
	/*
	1) Open the browser
	2) Enter the URL “http://practice.automationtesting.in/”
	3) Click on My Account Menu
	4) Enter valid username in username textbox
	5) Now enter empty password in the password textbox
	6) Click on login button.
	7) Proper error must be displayed(ie Invalid password) and prompt to enter login again
	 */
		
	// My Account button
		driver.findElement(By.xpath("//*[@id='menu-item-50']")).click();
		
	//Enter username
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("me@gmail.com");
	//Enter emphy password
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("");
	//login
		driver.findElement(By.xpath("//*[@class='woocommerce-Button button']")).click();
		
	//Proper error must be displayed(ie Invalid password) and prompt to enter login again
		String expectText = driver.findElement(By.xpath("//*[@class='woocommerce-error']/li")).getText();
		Assert.assertTrue(expectText.contains("Error: Password is required."));

	System.out.println(" User unsuccessfully login to the web page!");
	System.out.println("------------------------------------------------------");
	}	
	
	
	@Test (priority=4)
	public void emptyUsernameValidPassword() {
	/*
	1) Open the browser
	2) Enter the URL “http://practice.automationtesting.in/”
	3) Click on My Account Menu
	4) Enter empty username in username textbox
	5) Now enter valid password in the password textbox
	6) Click on login button.
	7) Proper error must be displayed(ie Invalid username) and prompt to enter login again
	 */
		
	// My Account button
		driver.findElement(By.xpath("//*[@id='menu-item-50']")).click();
		
	//Enter username
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("");
	//Enter empty password
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("A12bc34de56@");
		
		
//		act = new Actions(driver);
		
//		// explicit wait - to wait for the compose button to be click-able
//			WebDriverWait wait = new WebDriverWait(driver,30);
//			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.name("login"))));

		driver.findElement(By.name("login")).click();
		//login
//		act.click(driver.findElement(By.name("login")));
		
		
	//7)Proper error must be displayed(ie Invalid password) and prompt to enter login again
		String expectText = driver.findElement(By.xpath("//*[@id='page-36']/div/div/ul/li")).getText();
		Assert.assertTrue(expectText.contains("Error: Username is required."));

	System.out.println(" User unsuccessfully login to the web page!");
	System.out.println("------------------------------------------------------");
	}	

	
	@Test (priority=5)
	public void emptyUsernameEmptyPassword() {
	/*
	1) Open the browser
	2) Enter the URL “http://practice.automationtesting.in/”
	3) Click on My Account Menu
	4) Enter empty username in username textbox
	5) Now enter valid password in the password textbox
	6) Click on login button.
	7) Proper error must be displayed(ie required username) and prompt to enter login again
	*/
		
	// My Account button
		driver.findElement(By.xpath("//*[@id='menu-item-50']")).click();
			
	//Enter empthy username
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("");

	//Enter password
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("");
	
	//login
		driver.findElement(By.xpath("//*[@class='woocommerce-Button button']")).click();
				
	//Proper error must be displayed(ie Invalid password) and prompt to enter login again
		String expectText = driver.findElement(By.xpath("//*[@class='woocommerce-error']/li")).getText();
		Assert.assertTrue(expectText.contains("Error: Username is required."));

	System.out.println(" User unsuccessfully login to the web page!");
	System.out.println("------------------------------------------------------");
		
	}	
	

	@Test (priority=6)
	public void passwordBOxDisplyBullets() {
	/*
	1) Open the browser
	2) Enter the URL “http://practice.automationtesting.in/”
	3) Click on My Account Menu
	4) Enter the password field with some characters.
	5) The password field should display the characters in asterisks or bullets such that the password is not visible on the screen	}	
	*/

	// My Account button
		driver.findElement(By.xpath("//*[@id='menu-item-50']")).click();
		
	//Enter password
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("dfghjkl");
				
	//The password field should display the characters in asterisks or bullets such that the password is not visible on the screen	}	
		//when type in passwordbox it shows bullet need to verify the type if it is password it will passed
		String expectText = driver.findElement(By.xpath("//*[@id='password']")).getAttribute("type");
		Boolean type =  expectText.equals("password");
		Assert.assertTrue(type);

		System.out.println(type);
	System.out.println("passwordbox it shows bullet");
	System.out.println("------------------------------------------------");

	}

	
	@Test (priority=7)
	public void caseChangedUsernameAndPassword() {
/* 	1) Open the browser
	2) Enter the URL “http://practice.automationtesting.in/”
	3) Click on My Account Menu
	4) Enter the case changed username in username textbox
	5) Enter the case chenged password in the password tetxbox
	6) Now click on login button
	7) Login must fail saying incorrect username/password.
*/
	// My Account button
		driver.findElement(By.xpath("//*[@id='menu-item-50']")).click();
		
	//4) Enter the case changed username in username textbox
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("MEENA@gMail.com");
	//5) Enter the case changed password in the password tetxbox
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("a12BC34DE56@");
	//6) Now click on login button
		driver.findElement(By.name("login")).click();
			
	//7) Login must fail saying incorrect username/password.
		String expectText = driver.findElement(By.xpath("//*[@class='woocommerce-error']/li")).getText();
		Assert.assertTrue(expectText.contains("ERROR: The password you entered for the username MEENA@gMail.com is incorrect."));

	System.out.println(" User unsuccessfully login to the web page!");
	System.out.println("------------------------------------------------------");
		
			
	}
	
	@Test (priority=8)
	public void loginAuthentication() {
/* 	1) Open the browser
	2) Enter the URL “http://practice.automationtesting.in/”
	3) Click on My Account Menu
	4) Enter the case changed username in username textbox
	5) Enter the case changed password in the password tetxbox
	6) Now click on login button
	7) Once your are logged in, sign out of the site
	8) Now press back button
	9) User shouldn’t be signed in to his account rather a general webpage must be visible
*/
	
	// My Account button
		driver.findElement(By.xpath("//*[@id='menu-item-50']")).click();
		
	//Enter username
		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("meena@gmail.com");
	//Enter empty password
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("A12bc34de56@");
		
	//login	
		driver.findElement(By.name("login")).click();
		
		
	//verify if login
		String expectText = driver.findElement(By.xpath("//*[@class='woocommerce-MyAccount-content']")).getText();
		Assert.assertTrue(expectText.contains("From your account dashboard you can view your"));

	//click sign out
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a"));
	
	
	//go back	
		driver.navigate().back();	
		
	//verify User shouldn’t be signed in to his account rather a general webpage must be visible
		String verifyText = driver.findElement(By.xpath("//*[@class='woocommerce-MyAccount-content']")).getText();
		Boolean signout = verifyText.equals("From your account dashboard you can view your");
		
		
		Assert.assertFalse(signout);
	
		
	
	System.out.println("------------------------------------------------------");
	}	
		

	
	@AfterTest
	public void tearDown() {
		driver.close();
	}
	
	
	
}

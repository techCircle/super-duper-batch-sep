package testCase51;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyAccountLogin {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeClass
	public static void before() {
		
	}

	
	@BeforeMethod
	public void setUp() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://practice.automationtesting.in/");		
		wait = new WebDriverWait(driver, 30);
	}
	
	@Test
	public void validUsernamePassword() {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("nui@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("nnljl:)");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
		String logOut = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")).getText();
		String signOut = "Sign out";
		//check if user logging in successfully
		Assert.assertTrue(logOut.equals(signOut));
	}
	
	@Test
	public void incorrectUsernameIncorrectPassword() {
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("nuiddd@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("coffee:)");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
		String errorMessage = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
		System.out.println(errorMessage);
		String expectedErrMsg = "Error: A user could not be found with this email address.";
		Assert.assertTrue(errorMessage.equals(expectedErrMsg));
	}
	
	@Test
	public void validUsernameEmptyPwd() {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("nui@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
		String errorMessage = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
		System.out.println(errorMessage);
		String expectedErrMsg = "Error: Password is required.";
		Assert.assertTrue(errorMessage.equals(expectedErrMsg));
		
	}
	
	@Test
	public void emptyUsernameValidPwd() {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("nnljl:)");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
		String errorMessage = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
		System.out.println(errorMessage);
		String expectedErrMsg = "Error: Username is required.";
		Assert.assertTrue(errorMessage.equals(expectedErrMsg));
		
	}
	
	@Test
	public void emptyUsernameEmptyPwd() {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
		String errorMessage = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul/li")).getText();
		System.out.println(errorMessage);
		String expectedErrMsg = "Error: Username is required.";
		Assert.assertTrue(errorMessage.equals(expectedErrMsg));
				
	}
	
	@Test
	public void pwdShouldBeMasked() {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("ghythvhy");
		
		WebElement password = driver.findElement(By.xpath("//*[@class='woocommerce-FormRow woocommerce-FormRow--wide form-row form-row-wide'][2]/input"));
		Assert.assertTrue(password.getAttribute("type").equals("password")); 
	}
	
	@Test
	public void handlesCaseSensitive() {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("NUI@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("NNLJL:)");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
		String errorMessage = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/ul")).getText();
		System.out.println(errorMessage);
		String expectedErrMsg = "ERROR: The password you entered for the username NUI@gmail.com is incorrect. Lost your password?";
		Assert.assertTrue(errorMessage.equals(expectedErrMsg));
		
	}
	
	@Test
	public void authentication() throws InterruptedException {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("nui@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("nnljl:)");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
		String logOut = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")).getText();
		String signOut = "Sign out";
		//check if user logging in successfully
		Assert.assertTrue(logOut.equals(signOut));
		
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")).click();
		driver.navigate().back();
		Thread.sleep(3000);
		
		//check if general webpage is visible
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"customer_login\"]")).isDisplayed());
		
	}
	
	
	@AfterMethod
	public void after() {
		System.out.println("closing");
		driver.quit();
	}


}

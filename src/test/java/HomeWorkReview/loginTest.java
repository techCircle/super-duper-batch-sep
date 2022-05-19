package HomeWorkReview;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class loginTest {

	WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before class method");
	}

	@BeforeMethod
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://practice.automationtesting.in");

	}

	@AfterClass
	public static void afterClass() {
		System.out.println("Afterclass method");
	}

	@AfterMethod
	public void tearDown() {
		 driver.close();
	}

	@Test
	public void homePageTesting() {
		//clicking on my Account
		driver.findElement(By.xpath("//li[@id='menu-item-50']")).click();
		//inputing username into username textbox
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("mmaria@gmail.com");
		//inputing password into password textbox
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("MariaTahir786*");
		
		//click login
		driver.findElement(By.name("login")).click();
		
		//verifying if logout button is displayed
		Boolean logoutButton = driver.findElement(By.xpath("//div[@id='page-36']/div/div/nav/ul/li[6]")).isDisplayed();
		
		if(logoutButton) {
			System.out.println("Logout button exist");
		}else {
			System.out.println("Login dumb dumb");
		}
		
		//logout by clicking Sign Out button
		driver.findElement(By.xpath("//div[@id='page-36']/div/div/div/p[1]/a")).click();
		
		//not part of the test case
		//navigating to testCases tab
		driver.findElement(By.xpath("//*[@id='menu-item-224']/a")).click();
		
		//clicking or sending keys to first testcase of the HomePage category
		driver.findElement(By.xpath("//*[@id='accordion-222-sub_row_1-0-1-0-0']/ul/li[1]/div[1]/a")).click();
		
		
		//clicking on shop button
		driver.findElement(By.xpath("//*[@id='menu-item-40']/a")).sendKeys(Keys.ENTER);

	}

}

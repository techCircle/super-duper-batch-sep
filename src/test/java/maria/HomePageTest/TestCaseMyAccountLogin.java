package maria.HomePageTest;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCaseMyAccountLogin {

//changes to push
	WebDriver driver;
	@Before
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://practice.automationtesting.in/");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );

	}
	@After
	public void tearDown() {
		driver.close();
	}
	//go to my account page

	@Test
	public void testCase1() {

		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("tahirmaria2020@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Rtmamt786*");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).submit();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		if(driver.findElement(By.xpath("//*[@id=\"content\"]")).isDisplayed()) {
			System.out.println("login successful");
		}}


	@Test	
	public void testCase2() {

		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("tahir2020@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Ramt786*");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).submit();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );

		boolean ErrorMessage=driver.findElement(By.xpath("//*[@id=\"content\"]")).isDisplayed();
		Assert.assertTrue(ErrorMessage);



	}

	@Test	
	//correct user name and empty password
	public void testCase3() {

		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("tahirmaria2020@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]"));
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).submit();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );


		boolean ErrorMessage=driver.findElement(By.xpath("//*[@id=\"content\"]")).isDisplayed();
		Assert.assertTrue(ErrorMessage);



	}

	@Test	
	//empty user name and correct password
	public void testCase4() {

		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]"));
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("Ramt786*");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).submit();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		boolean ErrorMessage=driver.findElement(By.xpath("//*[@id=\"content\"]")).isDisplayed();
		Assert.assertTrue(ErrorMessage);
	}

	@Test	
	//empty user name and empty password
	public void testCase5() {

		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]"));
		driver.findElement(By.xpath("//*[@id=\"password\"]"));
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).submit();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		boolean ErrorMessage=driver.findElement(By.xpath("//*[@id=\"content\"]")).isDisplayed();
		Assert.assertTrue(ErrorMessage);
	}

	@Test	
	//log in password should be masked
	public void testCase6() {

		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();

		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("hgjfhaklkjk");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).submit();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		boolean ErrorMessage=driver.findElement(By.xpath("//*[@id=\"content\"]")).isDisplayed();
		Assert.assertTrue(ErrorMessage);}

	@Test	
	//log in handles case sensitive
	public void testCase7() {

		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("TahirMaria2020@gmail.com");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("rTMAMmt786*");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).submit();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		boolean ErrorMessage=driver.findElement(By.xpath("//*[@id=\"content\"]")).isDisplayed();
		Assert.assertTrue(ErrorMessage);

	}

	@Test	
	//log in authentication
	public void testCase8() throws InterruptedException {	
		//Click on My Account Menu
		driver.findElement(By.xpath("//*[@id='menu-item-50']/a")).click();

		driver.findElement(By.xpath("//*[@id='username']")).sendKeys("tahimar@gmail.com");
		driver.findElement(By.xpath("//*[@id='password']")).sendKeys("MariaTahir786**");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();

		System.out.println("log in successful");
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS );
		

		driver.findElement(By.xpath("//*[text()='Logout']")).click(); 
		Thread.sleep(3000);
		//driver.navigate().back();
		boolean genPage=driver.findElement(By.id("customer_login")).isDisplayed();

		Assert.assertTrue(genPage);



	}}


































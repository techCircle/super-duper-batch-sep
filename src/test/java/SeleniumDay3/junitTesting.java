package SeleniumDay3;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class junitTesting {

	WebDriver driver;

	@BeforeClass
	public static void beforeClass() {
		System.out.println("Before Class");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("After Class");
	}
	
	@AfterMethod
	public void tearDown() {
		//driver.close();
		driver.quit();
		//System.out.println("Close Browser");

	}
	
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();

		driver.get("https://www.techcircleschool.com/");
		driver.manage().window().maximize();
		System.out.println("Open Browser");
	}
	

	@Test
	public void test1() {
		System.out.println("Test1");
		System.out.println("Test1");
		System.out.println("Test1");
		//hard Assertion --> its failing
		System.out.println("Test1");
	}

	@Test
	public void test2() {
		System.out.println("Test2");
		System.out.println("Test2");
		System.out.println("Test2");
		//softassertion --failed
		System.out.println("Test2");



	}
	
	

	@Test
	public void test3() {
		System.out.println("Test3");

	}
	
//	@Test(enabled = false)
//	@Test(expected=ArithmeticException.class)
//	public void test4() {
//		System.out.println("Test4");
//		int i = 45/0;
//		System.out.println(i);
//
//	}

//	@Test(enabled = false)
//	@Test(timeout=500)
//	public void test5() {
//		System.out.println("Test5");
//	
//	}
	

}

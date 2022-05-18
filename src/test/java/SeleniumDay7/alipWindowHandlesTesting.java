package SeleniumDay7;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class alipWindowHandlesTesting {

	static WebDriver driver;
	Actions act;

	@BeforeClass
	public static void setUp() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/browser-windows");
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Ignore
	@Test
	public void windowNewTab() throws InterruptedException {
		// clicks on NewTab blue button
		driver.findElement(By.xpath("//*[@id='tabButton']")).click();

		// verifies that i am still on homePage
		System.out.println("HomePage -- ToolsQA = " + driver.getTitle());

		Set<String> ids = driver.getWindowHandles();

		java.util.Iterator<String> id = ids.iterator();

		String parentPage = id.next();
		String childPage1 = id.next();

		driver.switchTo().window(childPage1);

		Thread.sleep(3000);
		System.out.println("NewTab -- https://demoqa.com/sample = " + driver.getCurrentUrl());

		Thread.sleep(3000);
	}

	@Ignore
	@Test
	public void childPage2() throws InterruptedException {

		Set<String> ids = driver.getWindowHandles();

		java.util.Iterator<String> id = ids.iterator();

		String parentPage = id.next();
		String childPage1 = id.next();

		driver.switchTo().window(parentPage);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"windowButton\"]")).click();
		Thread.sleep(3000);

		ids = driver.getWindowHandles();
		java.util.Iterator<String> newID = ids.iterator();
		parentPage = newID.next();
		childPage1 = newID.next();
		String childPage2 = newID.next();

		driver.switchTo().window(childPage2);
		Thread.sleep(3000);
		System.out.println("NewWindow -- https://demoqa.com/sample = " + driver.getCurrentUrl());

	}

	@Test
	public void childPage3() throws InterruptedException {

		Set<String> ids = driver.getWindowHandles();

		java.util.Iterator<String> id = ids.iterator();

		String parentPage = id.next();

		driver.switchTo().window(parentPage);
		Thread.sleep(3000);

		driver.findElement(By.xpath("//*[@id=\"messageWindowButton\"]")).click();
		Thread.sleep(3000);

		ids = driver.getWindowHandles();
		java.util.Iterator<String> newID = ids.iterator();
		parentPage = newID.next();
		String childPage1 = newID.next();
		String childPage2 = newID.next();
		String childPage3 = newID.next();

		driver.switchTo().window(childPage3);
		Thread.sleep(3000);
		System.out.println("NewWindowMessage -- https://demoqa.com/sample = " + driver.getCurrentUrl());

	}

}

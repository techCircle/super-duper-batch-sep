package SeleniumDay7;

import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class dragAndDropTesting {

	WebDriver driver;
	Actions act;

	@Before
	public void setUp() throws InterruptedException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/droppable/");
		driver.manage().window().maximize();
		// implicit wait
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	@Ignore
	@Test
	public void simpleDragAndDrop() {
		act = new Actions(driver);

		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));

		act.dragAndDrop(source, target).build().perform();

	}
	
	
	@Test
	public void AcceptDragAndDrop() throws InterruptedException {
		act = new Actions(driver);
		
		driver.findElement(By.id("droppableExample-tab-accept")).click();
		
		Thread.sleep(3000);
		
		WebElement acceptable = driver.findElement(By.id("acceptable"));
		WebElement notAcceptable = driver.findElement(By.id("notAcceptable"));
		WebElement target = driver.findElement(By.xpath("//*[@id='droppableContainer']/div/div[2]/div/div[2]"));

		act.dragAndDrop(acceptable, target).build().perform();
		
		act.dragAndDrop(notAcceptable, target).build().perform();
		
		
		
		
	}
	
	@Test
	public void preventPropoDragAndDrop() {
		act = new Actions(driver);
		
		
		
		
		
		
	}
//	
//	@Test
//	public void refertDraggableDragAndDrop() {
//		act = new Actions(driver);
//		
//		
//	}
	

}

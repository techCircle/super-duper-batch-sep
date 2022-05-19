package HomeWorkReview;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkboxesTesting2 {
	
	WebDriver driver;
	boolean Isboxselect[] = new boolean[10];
	
	
	@BeforeMethod
	public void setUp() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/checkbox");
		
		
	}
	
	
	@Test
	public void test() throws InterruptedException {
		
		
		WebElement firstArrow = driver.findElement(By.xpath("//*[name()='svg'][@class='rct-icon rct-icon-expand-close']"));
		firstArrow.click();
		
		  WebElement subArrow1 = driver.findElement(By.xpath("(//*[name()='svg'][@class='rct-icon rct-icon-expand-close'])[1]"));
		  WebElement subArrow2 = driver.findElement(By.xpath("(//*[name()='svg'][@class='rct-icon rct-icon-expand-close'])[2]"));
		  WebElement subArrow3 = driver.findElement(By.xpath("(//*[name()='svg'][@class='rct-icon rct-icon-expand-close'])[3]"));
		  
		
			/*
			 * for(int i=1;i<=3;i++) { driver.findElement(By.
			 * xpath("(//*[name()='svg'][@class='rct-icon rct-icon-expand-close'])[" + i
			 * +"]")).click(); Thread.sleep(2000);
			 * 
			 * }
			 */
		
		 subArrow1.click();
		 subArrow2.click();
		 subArrow3.click();
		 
		 //Update all unchecked box into array
		 UpdateBox("(//*[name()='svg'][@class='rct-icon rct-icon-uncheck'])");
		 
		 
	     int countBoxUncheck = checkSelectBox();	     
		 
		 if(countBoxUncheck == 10) {
			 System.out.println("All box is default unchecked");
			 driver.findElement(By.xpath("(//*[name()='svg'][@class='rct-icon rct-icon-uncheck'])[1]")).click();
		 }else {
			 System.out.println("box is default checked ");
		 }
		 
		 Thread.sleep(2000);
		 
		 
		 //Update all checkbox into array
		 UpdateBox("(//*[name()='svg'][@class='rct-icon rct-icon-check'])");
		 
		 
		 int  countCheckbox = checkSelectBox();
		 if(countCheckbox == 10) {
			 System.out.println(" all the checkboxes are checked! ");
		 }else {
			 System.out.println("some checkboxes are still unchecked ");
		 }
		 
		
	}
	
	public void UpdateBox(String xpathname){
		 int numbox = 1;
		 for(int i=0;i<=9;i++) {
			 Isboxselect[i] = driver.findElement(By.xpath(""+ xpathname +"["+numbox+"]")).isDisplayed();
			 System.out.println(Isboxselect[i]);
			 numbox++;
		 }
		
	}
	
	public int checkSelectBox() {
		
		  
		         int checkbox = 1;
		         int countbox = 0;
				 boolean checkdisplay= false;
				 for(int i=0;i<=9;i++) {
					 
					 if(Isboxselect[i] == true) {
						 System.out.println("box number"+ checkbox + " is displayed");
						 countbox++;
					 }else{
						 System.out.println("box number"+ checkbox + " is not displayed");
						 checkdisplay = false;
						 break;
					 }
					 checkbox++;			 
					 
				 }
				 
				 return countbox;
		
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
		
	}

}

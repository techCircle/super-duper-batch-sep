package HomeWorkReview;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class checkboxesTesting {

	WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// 1. go to https://demoqa.com/checkbox
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/checkbox");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		System.out.println("----------------------------1.----------------------------------");
	}

	@AfterMethod
	public void afterTest() {
		driver.close();
		System.out.println("Close Browser");
	}

	@Test
    public void checkBox(){


        //2. expand all the checkboxes
        WebElement expand1Home = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/button"));
        expand1Home.click();
        System.out.println("-------------Home----------------");

        WebElement expand2Desktop = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[1]/span/button"));
        expand2Desktop.click();
        System.out.println("-------------Desktop----------------");

        WebElement expand3Document = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/span/button"));
        expand3Document.click();
        System.out.println("-------------Document----------------");

        WebElement expand6Download = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[3]/span/button"));
        expand6Download.click();
        System.out.println("-------------Download----------------");

        WebElement expand5Office = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[2]/span/button"));
        expand5Office.click();
        System.out.println("-----------------Office---------------");

        WebElement expand4WorkSpace = driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/ol/li[2]/ol/li[1]/span/button"));
        expand4WorkSpace.click();
        System.out.println("-----------------Work---------------");

        System.out.println("----------------------------2.----------------------------------");


        
       String text= driver.findElement(By.xpath("//*[@id=\"tree-node\"]/ol/li/span/label/span[1]/svg")).getAttribute("class");
        
        System.out.println(text);
//        //3. verify if all the checkboxes are unchecked by default
//        WebElement homeCheckboxClick = driver.findElement(By.cssSelector("#tree-node > ol > li > span > label > span.rct-checkbox > svg"));
//        String homeClick = homeCheckboxClick.getAttribute("class");
//        System.out.println(homeClick );
//
//
//        System.out.println("----------------------------3.1----------------------------------");
//
//        if(homeClick.equals("rct-icon rct-icon-check")){
//            homeCheckboxClick.click(); // un-click all the boxes
//            System.out.println("Parent Home box un-click by default1");
//        }else if (homeClick.equals("rct-icon rct-icon-half-check") ){
//            homeCheckboxClick.click(); // click all the box to reset in case it's half clicked
//            homeCheckboxClick.click(); // un-click all the boxes to reset all
//            System.out.println("Parent Home box un-click by default2");
//        }else if (homeClick.equals("rct-icon rct-icon-uncheck") ){
//            System.out.println("Parent Home box un-click by default3");
//        }
//
//        System.out.println(homeClick);
//        System.out.println("----------------------------3.2----------------------------------");
//
//        //4. click on 'Home', Parent Checkbox
//        homeCheckboxClick.click();
//
//        WebElement homeCheckboxStatus = driver.findElement(By.cssSelector("#tree-node > ol > li > span > label > span.rct-checkbox > svg"));
//        String homeStatus = homeCheckboxStatus.getAttribute("class");
//        System.out.println(homeStatus);
//        System.out.println("----------------------------4.----------------------------------");
//
//        //5. now verify if all the checkboxes are checked
//        if(homeStatus.equals("rct-icon rct-icon-check")){
//            System.out.println("All the checkboxes are checked");
//        }else if (!homeStatus.equals("rct-icon rct-icon-check")) {
//            System.out.println("Incomplete");
//        }
//        System.out.println("----------------------------5.----------------------------------");
	}
}

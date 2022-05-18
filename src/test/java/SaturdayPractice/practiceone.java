package SaturdayPractice;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practiceone {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		// This method will maximize the browser before route to the url
		driver.manage().window().maximize();

		// get method will take you the URL you have given.
		driver.get("https://www.amazon.com");
		
		/*
		 * id
		 * class / className
		 * tag
		 * linktext
		 * parcialLinkText
		 * name
		 * 
		 *css 
		 * xpath
		 *  *Relative Xpath
		 *  	//y[by.id[element]
		 *  *Ablosute Xpath
		 *  	path routh
		 *  
		 *  Html/div/div/div[1]/id
		 *  
		 * 
		 */
		
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

		WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));

		WebElement bestSellerButton = driver.findElement(By.className("nav-a  "));
		
		
		
		searchBox.sendKeys("laptop");
		searchButton.click();
		
		Thread.sleep(2000);
		
		String title = driver.getTitle().toString();
		
		String expectedTitle = "Amazon.com : laptop";
		
	
		
//		if(title.equals(expectedTitle) && ) {
//			System.out.println("title is matching and it is: " + title);
//			driver.quit();
//		}else {
//			System.out.println("expected title: " + expectedTitle + " " + "actual title: "+ title);
//		}
//		
		
		bestSellerButton.click();
		
	}
}

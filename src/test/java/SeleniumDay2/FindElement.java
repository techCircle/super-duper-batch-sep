package SeleniumDay2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FindElement {

	public static void main(String[] args) throws InterruptedException {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();

		// This method will maximize the browser before route to the url
		driver.manage().window().maximize();

		// get method will take you the URL you have given.
		driver.get("https://www.amazon.com");

		/*
		 * right click and use inspect on the place you would like to find
		 * 
		 * If you would like to find the element you have to use below 8 locators
		 * 
		 * Id ClassName Name LinkText TagName PartialLinkText Xpath CSS
		 */
		driver.findElement(By.id("twotabsearchtextbox"));
//		driver.findElement(By.className(<string>));
//		driver.findElement(By.linkText(<string>));
//		driver.findElement(By.tagName(<string>));
//		

		/*
		 * method "sendKeys" will pass the string you are giving on the element if it
		 * accepts string
		 * 
		 */

//		
//	WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
//	WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
//	
//	
//	searchBox.sendKeys("laptop");
//	searchButton.click();
			
		
		/*
		 * If you would like to declare the locators. You can declare it to WebElement.
		 * 
		 * Example: below :)
		 */
		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));

		WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));

		
		/*
		 * If you would like to send some data / string to the field or Parameter you can use 
		 * 
		 * .sendKeys(<string>)
		 */
		searchBox.sendKeys("Sunglasses");
		
		/*
		 * If you would like to replicate the enter button action you can use 
		 * 
		 * .submit();
		 */
		searchBox.submit();
		
		/*
		 * if the element is clickable you can use 
		 * 
		 * .click();
		 */
		searchButton.click();

		driver.quit();
	}
}

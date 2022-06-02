package Emmie_51TestCases.java;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.Driver;

public class HP_ThreeSliders {

	@BeforeMethod
	public void beforeMethod() {
		Driver.getDriver();
	}

	@Test 
	public void navigateToThreeSlides() throws InterruptedException {
		// navigate to shop button
		WebElement shopButton = Driver.driver.findElement(By.xpath("//*[text()='Shop']"));
		shopButton.click();
		// navigate to Home
		WebElement homeButton = Driver.driver.findElement(By.xpath("//*[text()='Home']"));
		homeButton.click();
		// show three slide arrow
		Driver.driver.findElement(By.xpath("//*[@id='n2-ss-6-arrow-next']/img")).click();
		Thread.sleep(2000);
		System.out.println("Shown 3 Slides");

	}


	@AfterMethod
	public void tearDown() {
		Driver.tearDown();
	}

}

package Nui51TestCases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MyAccount {
	
	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeMethod
	public void setup() {
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.navigate().to("http://practice.automationtesting.in");
	}
	
	@Test
	public void dashboard() {
		
		//click on my account menu
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("nui@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("nnljl:)");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
		String logOut = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")).getText();
		String signOut = "Sign out";
		//check if user logging in successfully
		AssertJUnit.assertTrue(logOut.equals(signOut));
		
		//click on dashboard
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[1]/a")).click();
		
		//check if see dashboard
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[2]")).isDisplayed());
		
	}
	  
	@Test
	public void orderLink() throws InterruptedException {
	
	//click on my account menu
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("nui@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("nnljl:)");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
		String logOut = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")).getText();
		String signOut = "Sign out";
		//check if user logging in successfully
		AssertJUnit.assertTrue(logOut.equals(signOut));
		
		//click on order link
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[2]/a")).click();
		Thread.sleep(3000);
		
		//verify if see order detail on the page
		AssertJUnit.assertTrue(driver.getCurrentUrl().contains("orders"));
			
	}
	
	@Test  
	public void orderViewButton() throws InterruptedException {
		
		//click on my account menu
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("nui@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("nnljl:)");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
		String logOut = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")).getText();
		String signOut = "Sign out";
		//check if user logging in successfully
		AssertJUnit.assertTrue(logOut.equals(signOut));
		
		//go to shop to add something in the basket
		driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a[2]")).click();
		Thread.sleep(3000);
		
		//click on my account link
		driver.findElement(By.xpath("//*[@id='menu-item-50']/a")).click();
		
		//click on order link
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[2]/a")).click();
		
		//click view button
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/table/tbody/tr/td[5]/a")).click();
		
		//verify if user can see order details, customer details and billing details
		String orderDetailsMsg = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/h2")).getText();
		String expectedOrderMsg = "Order Details";
		AssertJUnit.assertTrue(orderDetailsMsg.equals(expectedOrderMsg));
		
		String customerDetailsMsg = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/header[1]/h2")).getText();
		String expectedCustomerMsg = "Customer Details";
		AssertJUnit.assertTrue(customerDetailsMsg.equals(expectedCustomerMsg));
		
		String billingDetailsMsg = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/header[2]/h3")).getText();
		String expectedBillingMsg = "Billing Address";
		AssertJUnit.assertTrue(billingDetailsMsg.equals(expectedBillingMsg));
		
		
		
	}
	
	@Test
	public void orderViewButtonV2() throws InterruptedException {
		
	    //click on my account menu
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("nui@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("nnljl:)");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
		String logOut = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")).getText();
		String signOut = "Sign out";
		//check if user logging in successfully
		AssertJUnit.assertTrue(logOut.equals(signOut));
		
		//go to shop to add something in the basket
		driver.findElement(By.xpath("//*[@id=\"menu-item-40\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a[2]")).click();
		Thread.sleep(3000);
		
		//click on my account link
		driver.findElement(By.xpath("//*[@id='menu-item-50']/a")).click();
		
		//click on order link
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[2]/a")).click();
		
		//click view button
		driver.findElement(By.xpath("//*[@class='button view']")).click();
		
		//Verify that user can see Order Number Ordered date and Status of the order
		String orderDetailsMsg = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p")).getText();
		System.out.println(orderDetailsMsg);
		orderDetailsMsg = orderDetailsMsg.substring(0,7)+ " "+ orderDetailsMsg.substring(27,39)+ " "+orderDetailsMsg.substring(orderDetailsMsg.length()-11, orderDetailsMsg.length()-1);
		System.out.println(orderDetailsMsg);
		String expectedText = "Order # May 18, 2022 Processing";
		AssertJUnit.assertTrue(orderDetailsMsg.equals(expectedText));
	}
	
	@Test
	public void addressFunctionality() {
		
		//click on my account menu
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("nui@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("nnljl:)");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
		String logOut = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")).getText();
		String signOut = "Sign out";
		//check if user logging in successfully
		AssertJUnit.assertTrue(logOut.equals(signOut));
		
//		//click on order link
//		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[2]/a")).click();
//		
//		//verify if see order detail on the page
//		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/div")).isDisplayed());
//		
		//click on address link
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[4]/a")).click();
		
		//verify if user can see Billing and Shipping address
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/div/div[1]/header/h3")).isDisplayed());
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/div/div[2]/header/h3")).isDisplayed());
		
		
	}
	
	@Test 
	public void addressFunctionalityV2() throws InterruptedException {
		
		//click on my account menu
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("nui@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("nnljl:)");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
		String logOut = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")).getText();
		String signOut = "Sign out";
		//check if user logging in successfully
		AssertJUnit.assertTrue(logOut.equals(signOut));
		
		//click on address link
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[4]/a")).click();
		
		//verify if user can see Billing and Shipping address
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/div/div[1]/header/h3")).isDisplayed());
		AssertJUnit.assertTrue(driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/div/div[2]/header/h3")).isDisplayed());
		
		//click edit shipping address
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/div/div[2]/header/a")).click();
		Thread.sleep(3000);
		
		//fill in the address form ... before fill in I need to delete the previous saved address in order to fill in new one
		WebElement nameBox = driver.findElement(By.xpath("//*[@id=\"shipping_first_name\"]"));
		nameBox.clear();
		nameBox.sendKeys("Pooh");
				
		WebElement lastNameBox = driver.findElement(By.xpath("//*[@id=\"shipping_last_name\"]"));
		lastNameBox.clear();
		lastNameBox.sendKeys("Bear");
		
		driver.findElement(By.xpath("//*[@id=\"s2id_shipping_country\"]/a/span[2]/b")).click();
		driver.findElement(By.xpath("//*[@id=\"s2id_autogen1_search\"]")).sendKeys("United States (US)");
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id=\"select2-result-label-402\"]/span")).click();
		
		WebElement addressBox = driver.findElement(By.xpath("//*[@id=\"shipping_address_1\"]"));
		addressBox.clear();
		addressBox.sendKeys("123 abc st.");
		
		WebElement cityBox = driver.findElement(By.xpath("//*[@id=\"shipping_city\"]"));
		cityBox.clear();
		cityBox.sendKeys("San Francisco");
		
		driver.findElement(By.xpath("//*[@id=\"s2id_shipping_state\"]/a/span[2]/b")).click();
		WebElement box = driver.findElement(By.xpath("//*[@id=\"s2id_autogen2_search\"]"));
		box.sendKeys("California");
		box.sendKeys(Keys.RETURN);
		
		WebElement zipcodeBox = driver.findElement(By.xpath("//*[@id=\"shipping_postcode\"]"));
		zipcodeBox.clear();
		zipcodeBox.sendKeys("12345");
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/form/p[10]/input[1]")).click();
		
		//verify if address has been changed successfully
		String str = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div[1]")).getText();
		String expectedStr = "Address changed successfully.";
		AssertJUnit.assertTrue(str.equals(expectedStr));
		
	}
	
	@Test
	public void accountDetails() {
		
		//click on my account menu
				driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
				driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("nui@gmail.com");
				
				driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("nnljl:)");
				driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
				String logOut = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")).getText();
				String signOut = "Sign out";
				//check if user logging in successfully
				AssertJUnit.assertTrue(logOut.equals(signOut));
				
				//click on account details
				driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[5]/a")).click();
				
				//verify if it show that we can change a new password
				String newpwdstr = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/form/fieldset/p[2]/label")).getText();
				System.out.println(newpwdstr);
				String expectedNewPwd = "New Password (leave blank to leave unchanged)";
				AssertJUnit.assertTrue(newpwdstr.equals(expectedNewPwd));
		
	}
	
	@Test
	public void logout() {
		
		driver.findElement(By.xpath("//*[@id=\"menu-item-50\"]/a")).click();
		driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("nui@gmail.com");
		
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("nnljl:)");
		driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/form/p[3]/input[3]")).click();
		String logOut = driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/div/p[1]/a")).getText();
		String signOut = "Sign out";
		//check if user logging in successfully
		AssertJUnit.assertTrue(logOut.equals(signOut));
		
		//click on logout button
		driver.findElement(By.xpath("//*[@id=\"page-36\"]/div/div[1]/nav/ul/li[6]/a")).click();
		
		//verify if user has already logged out. it will has log in box show up for user to log in again
		String loginMsg = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[1]/h2")).getText();
		System.out.println(loginMsg);
		String expectedLoginMsg = "Login";
		AssertJUnit.assertTrue(loginMsg.equals(expectedLoginMsg));
		
	}
	
	@AfterMethod
	public void after() {
		
		driver.quit();
	}

}

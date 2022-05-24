package pawitri51TestCases;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Register {

	 WebDriver driver;

	    @Before
	    public void setUp(){
	        //1) Open browser
	        WebDriverManager.chromedriver().setup();
	        driver = new ChromeDriver();

	        //2) Enter the URL “http://practice.automationtesting.in/”
	        driver.get("http://practice.automationtesting.in/");
	        driver.manage().window().maximize();
	        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);

	        // 3) Click on My Account Menu
	        WebElement myAccountMenu =driver.findElement(By.id("menu-item-50"));
	        myAccountMenu.click();
	    }


	    @Test
	    public void test1RegistrationSignIn() {

	        String email = "ohhhhh123456789_porkuraii@hotmail.com";
	        //4) Enter registered Email Address in Email-Address text box
	        WebElement elementRegisEmail = driver.findElement(By.xpath("//*[@id='reg_email']"));
	        elementRegisEmail.sendKeys(email);

	        //5) Enter your own password in password text box
	        WebElement elementRegisPass = driver.findElement(By.id("reg_password"));
	        elementRegisPass.sendKeys("AaBbEe12345670987654!");

	        /* * */
	      //  WebElement clickSomeWhere = driver.findElement(By.xpath("//*[@id=\"customer_login\"]/div[2]/h2"));
	       // clickSomeWhere.click();

	        //6) Click on Register button
	        WebElement elementRegisButton = driver.findElement(By.xpath("//*[@id='customer_login']/div[2]/form/p[3]/input[3]"));
	        //explicit wait
	        WebDriverWait wait2 =new WebDriverWait(driver,30);
	        wait2.until(ExpectedConditions.elementToBeClickable(elementRegisButton));
	        elementRegisButton.click();


	        //Check on Extra condition that  if we are already registered yet
	        try {
	            if (driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li")).isDisplayed()) {
	                // if error message is display = An account is already registered with your email address. Please login.
	                System.out.println("An account is already registered with your email address. Please login.");
	                Assert.assertTrue(false);

	            } else {
	                //User must successfully log in to the web page --> verify by text in this case
	                //Verify if we are in the account yet
	                WebElement expectedElement = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/div"));
	                String expectedText = expectedElement.getText();
	                //System.out.println(expectedText);
	                Assert.assertTrue(expectedText.contains("Sign out"));
	            }
	        } catch (Exception e){
	            e.printStackTrace();
	        }


	    }

	    @Test
	    public void test2RegistrationWithInvalidEmailId() throws InterruptedException {
	        //4) Enter invalid Email Address in Email-Address text box
	        WebElement elementRegisEmail = driver.findElement(By.xpath("//*[@id='reg_email']"));
	        elementRegisEmail.sendKeys("por_por@gmail");

	        //5) Enter your own password in password text box
	        WebElement elementRegisPass = driver.findElement(By.id("reg_password"));
	        elementRegisPass.sendKeys("AaBbEe12345670987654!");

	        try {
	            //6) Click on Register button
	            WebElement elementRegisButton = driver.findElement(By.xpath("//*[@id='customer_login']/div[2]/form/p[3]/input[3]"));

	            WebDriverWait wait1 = new WebDriverWait(driver, 30);
	            wait1.until(ExpectedConditions.elementToBeClickable(elementRegisButton));

	            elementRegisButton.click();
	        }catch (Exception e) {
	            e.printStackTrace();
	            elementRegisPass.sendKeys(Keys.ENTER);

	        }

	        //7) Registration must fail with a warning message(ie You must enter a valid email address)
	        WebElement expectedElement = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li"));
	        String expectedText = expectedElement.getText();
	        //System.out.println(expectedText);
	        Assert.assertTrue(expectedText.contains("Please provide a valid email address."));


	    }

	    @Test
	    public void test3RegistrationWithEmptyEmailId(){
	        //4) Enter empty Email Address in Email-Address text box
	        WebElement elementRegisEmail = driver.findElement(By.xpath("//*[@id='reg_email']"));
	        elementRegisEmail.sendKeys("");

	        //5) Enter your own password in password text box
	        WebElement elementRegisPass = driver.findElement(By.id("reg_password"));
	        elementRegisPass.sendKeys("AaBbEe12345670987654!");

	        //6) Click on Register button
	        WebElement elementRegisButton = driver.findElement(By.xpath("//*[@id='customer_login']/div[2]/form/p[3]/input[3]"));
	        elementRegisButton.click();

	        //7) Registration must fail with a warning message(ie please provide valid email address)
	        WebElement expectedElement = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li"));
	        String expectedText = expectedElement.getText();
	        //System.out.println(expectedText);
	        Assert.assertTrue(expectedText.contains("please provide valid email address"));
	    }

	    @Test
	    public void test4RegistrationWithEmptyPassword(){
	        //4) Enter valid Email Address in Email-Address text box
	        WebElement elementRegisEmail = driver.findElement(By.xpath("//*[@id='reg_email']"));
	        elementRegisEmail.sendKeys("por123_porkuraii@hotmail.com");

	        //5) Enter empty password in password text box
	        WebElement elementRegisPass = driver.findElement(By.id("reg_password"));
	        elementRegisPass.sendKeys("");

	        //6) Click on Register button
	        WebElement elementRegisButton = driver.findElement(By.xpath("//*[@id='customer_login']/div[2]/form/p[3]/input[3]"));
	        elementRegisButton.click();

	        //7) Registration must fail with a warning message(ie please enter an account password)
	        WebElement expectedElement = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul"));
	        String expectedText = expectedElement.getText();
	        //System.out.println(expectedText);
	        Assert.assertTrue(expectedText.contains(" Please enter an account password."));
	    }

	    @Test
	    public void test5RegistrationWithEmptyEmailIdAndPassword	() {
	        //4) Enter empty Email Address in Email-Address text box
	        WebElement elementRegisEmail = driver.findElement(By.xpath("//*[@id='reg_email']"));
	        elementRegisEmail.sendKeys("");

	        //5) Enter empty password in password text box
	        WebElement elementRegisPass = driver.findElement(By.id("reg_password"));
	        elementRegisPass.sendKeys("");

	        //6) Click on Register button
	        WebElement elementRegisButton = driver.findElement(By.xpath("//*[@id='customer_login']/div[2]/form/p[3]/input[3]"));
	        elementRegisButton.click();

	        //7) Registration must fail with a warning message(ie please provide valid email address)
	        WebElement expectedElement = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li"));
	        String expectedText = expectedElement.getText();
	        //System.out.println(expectedText);
	        Assert.assertTrue(expectedText.contains("please provide valid email address"));
	    }
	    
        @After
    public void destroy(){
        driver.close();
        }

}

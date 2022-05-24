package pawitri51TestCases;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogIn {
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
        WebElement shopMenu =driver.findElement(By.xpath("//*[@id='menu-item-40']/a"));
        shopMenu.click();
    }

    @Test
    public void test1ValidUsernameAndPassword(){

        //4) Enter registered username in username text box
        WebElement elementLoginEmail = driver.findElement(By.id("username"));
        elementLoginEmail.sendKeys("por_porkuraii@hotmail.com");

        //5) Enter password in password text box
        WebElement elementLoginPass = driver.findElement(By.id("password"));
        elementLoginPass.sendKeys("AaBbEe12345670987654!");

        //6) Click on login button
        WebElement elementLoginButton = driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/input[3]"));
        elementLoginButton.click();

        //7) User must successfully log in to the web page --> verify by text in this case
        //Verify if we are in the account yet
        WebElement expectedElement = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/div"));
        String expectedText = expectedElement.getText();
        //System.out.println(expectedText);
        Assert.assertTrue(expectedText.contains("Hello por_porkuraii (not por_porkuraii? Sign out)"));
    }

    @Test
    public void test2IncorrectUsernameAndIncorrectPassword(){
        //4) Enter incorrect username in username text box
        WebElement elementLoginEmail = driver.findElement(By.id("username"));
        elementLoginEmail.sendKeys("por123_porkuraii@hotmail.com");

        //5) Enter incorrect password in password text box.
        WebElement elementLoginPass = driver.findElement(By.id("password"));
        elementLoginPass.sendKeys("123AaBbEe12345670987654!");

        //6) Click on login button
        WebElement elementLoginButton = driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/input[3]"));
        elementLoginButton.click();

        //7) Proper error must be displayed(ie Invalid username) and ***prompt to enter login again
        //Verify if there is the error message
        WebElement expectedElement = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li"));
        String expectedText = expectedElement.getText();
        //System.out.println(expectedText);
        Assert.assertTrue(expectedText.contains(" A user could not be found with this email address."));

    }

    @Test
    public void test3CorrectUsernameAndEmptyPassword(){
       // 4) Enter valid username in username text box
        WebElement elementLoginEmail = driver.findElement(By.id("username"));
        elementLoginEmail.sendKeys("por_porkuraii@hotmail.com");

        // 5) Now enter empty password in the password text box
        WebElement elementLoginPass = driver.findElement(By.id("password"));
        elementLoginPass.sendKeys("");

        //6) Click on login button.
        WebElement elementLoginButton = driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/input[3]"));
        elementLoginButton.click();

        //7) Proper error must be displayed(ie Invalid password) and ***prompt to enter login again
        //Verify if there is the error message
        WebElement expectedElement = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li"));
        String expectedText = expectedElement.getText();
        //System.out.println(expectedText);
        Assert.assertTrue(expectedText.contains(" Password is required."));
    }

    @Test
    public void test4EmptyUsernameAndValidPassword(){
        //4) Enter empty username in username text box
        WebElement elementLoginEmail = driver.findElement(By.id("username"));
        elementLoginEmail.sendKeys("");

        //5) Now enter valid password in the password text box
        WebElement elementLoginPass = driver.findElement(By.id("password"));
        elementLoginPass.sendKeys("AaBbEe12345670987654!");

        //6) Click on login button.
        WebElement elementLoginButton = driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/input[3]"));
        elementLoginButton.click();

        //7) Proper error must be displayed(ie Invalid username) and ***prompt to enter login again
        //Verify if there is the error message
        WebElement expectedElement = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li"));
        String expectedText = expectedElement.getText();
        //System.out.println(expectedText);
        Assert.assertTrue(expectedText.contains(" Username is required."));
    }

    @Test
    public void test5EmptyUsernameAndEmptyPassword(){
        //4) Enter empty username in username text box
        WebElement elementLoginEmail = driver.findElement(By.id("username"));
        elementLoginEmail.sendKeys("");

        //5) Now enter ***password in the password text box ----> this should be Empty Password
        WebElement elementLoginPass = driver.findElement(By.id("password"));
        elementLoginPass.sendKeys("");

        //6) Click on login button.
        WebElement elementLoginButton = driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/input[3]"));
        elementLoginButton.click();

        //7) Proper error must be displayed(ie required username) and prompt to enter login again
        //Verify if there is the error message
        WebElement expectedElement = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li"));
        String expectedText = expectedElement.getText();
        //System.out.println(expectedText);
        Assert.assertTrue(expectedText.contains(" Username is required."));
    }

    @Test
    public void test6PasswordShouldBeMasked() throws IOException {
        //4) Enter the password field with some characters.
        WebElement elementLoginPass = driver.findElement(By.id("password"));
        elementLoginPass.sendKeys("AaBbEe12345670987654!");

        //5) The password field should display the characters in asterisks
            // or bullets such that the password is not visible on the screen

        // if the type is "password" it should be asterisks or bullets --> html, browser
        String passwordType = elementLoginPass.getAttribute("type");
        Assert.assertEquals("password", passwordType);

        // screenshot of the page
        WebElement LogInBox = driver.findElement(By.xpath("//*[@id='customer_login']/div[1]"));
        File screen = ((TakesScreenshot)this.driver).getScreenshotAs(OutputType.FILE);
        Point p = LogInBox.getLocation();
        int width = LogInBox.getSize().getWidth();
        int height = LogInBox.getSize().getHeight();
        BufferedImage img = ImageIO.read(screen);
        BufferedImage dest = img.getSubimage(p.getX(), p.getY(), width, height);
        ImageIO.write(dest, "png", screen);
        File f = new File("C:\\Users\\pawit\\Desktop\\PicForTestCase\\PasswordBullet1");
        FileUtils.copyFile(screen, f);


    }

    @Test
    public void test7HandlesCaseSensitive(){
        //4) Enter the case changed username in username text box
         WebElement elementLoginEmail = driver.findElement(By.id("username"));
                elementLoginEmail.sendKeys("POR_porkuraii@hotmail.com");

        //5) Enter the case changed password in the password text box
        WebElement elementLoginPass = driver.findElement(By.id("password"));
        elementLoginPass.sendKeys("AABBEE12345670987654!");

        //6) Now click on login button
        WebElement elementLoginButton = driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/input[3]"));
        elementLoginButton.click();

        //7) Login must fail saying incorrect username/password.
        //Verify if there is the error message
        WebElement expectedElement = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li"));
        String expectedText = expectedElement.getText();
        //System.out.println(expectedText);
        Assert.assertTrue(expectedText.contains(" is incorrect. "));

    }

    @Test
    public void test8Authentication(){
        //4) Enter the case changed username in username text box  ---> should be valid password
        //5) Enter the case changed password in the password text box ---> should be valid password
        //6) Now click on login button
            //also verify if it is logged in
        test1ValidUsernameAndPassword();

        //7) Once you are logged in, sign out of the site
        WebElement signOutButton = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/div/p[1]/a"));
        signOutButton.click();

        //8) Now press back button
        driver.navigate().back();

        //9) User should not be signed in to his account rather a general webpage must be visible
            //Verify if we get in the account ?
        WebElement expectedElement = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/div"));
        String expectedText = expectedElement.getText();
        //System.out.println(expectedText);
        Assert.assertFalse(expectedText.contains("Hello por_porkuraii (not por_porkuraii? Sign out)"));

    }

    @Test
    public void test9ExtraIncorrectUsernameWithValidPassword(){
        //4) Enter incorrect username in username text box
        WebElement elementLoginEmail = driver.findElement(By.id("username"));
        elementLoginEmail.sendKeys("por123_porkuraii@hotmail.com");

        //5) Enter correct password in password text box.
        WebElement elementLoginPass = driver.findElement(By.id("password"));
        elementLoginPass.sendKeys("AaBbEe12345670987654!");

        //6) Click on login button
        WebElement elementLoginButton = driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/input[3]"));
        elementLoginButton.click();

        //7) Proper error must be displayed(ie Invalid username) and ***prompt to enter login again
        //Verify if there is the error message
        WebElement expectedElement = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li"));
        String expectedText = expectedElement.getText();
        //System.out.println(expectedText);
        Assert.assertTrue(expectedText.contains(" A user could not be found with this email address."));
    }

    @Test
    public void test10ExtraValidUsernameWithIncorrectPassword(){
        //4) Enter correct username in username text box
        WebElement elementLoginEmail = driver.findElement(By.id("username"));
        elementLoginEmail.sendKeys("por_porkuraii@hotmail.com");

        //5) Enter incorrect password in password text box.
        WebElement elementLoginPass = driver.findElement(By.id("password"));
        elementLoginPass.sendKeys("123AaBbEe12345670987654!");

        //6) Click on login button
        WebElement elementLoginButton = driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/input[3]"));
        elementLoginButton.click();

        //7) Proper error must be displayed(ie Invalid username) and ***prompt to enter login again
        //Verify if there is the error message
        WebElement expectedElement = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li"));
        String expectedText = expectedElement.getText();
        //System.out.println(expectedText);
        Assert.assertTrue(expectedText.contains(" A user could not be found with this email address."));
    }

    @Test
    public void test11ExtraCasedChangedUsernameWithCorrectPassword(){
        //4) Enter the case changed username in username text box
        WebElement elementLoginEmail = driver.findElement(By.id("username"));
        elementLoginEmail.sendKeys("POR_porkuraii@hotmail.com");

        //5) Enter the case changed password in the password text box
        WebElement elementLoginPass = driver.findElement(By.id("password"));
        elementLoginPass.sendKeys("AaBbEe12345670987654!");

        //6) Now click on login button
        WebElement elementLoginButton = driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/input[3]"));
        elementLoginButton.click();

        //7) Login must fail saying incorrect username/password.
        //Verify if there is the error message
        WebElement expectedElement = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li"));
        String expectedText = expectedElement.getText();
        //System.out.println(expectedText);
        Assert.assertTrue(expectedText.contains(" is incorrect. "));
    }

    @Test
    public void test12ExtraCorrectUsernameWithCaseChangedPassword(){
        //4) Enter the correct username in username text box
        WebElement elementLoginEmail = driver.findElement(By.id("username"));
        elementLoginEmail.sendKeys("por_porkuraii@hotmail.com");

        //5) Enter the case changed password in the password text box
        WebElement elementLoginPass = driver.findElement(By.id("password"));
        elementLoginPass.sendKeys("AABBEE12345670987654!");

        //6) Now click on login button
        WebElement elementLoginButton = driver.findElement(By.xpath("//*[@id='customer_login']/div[1]/form/p[3]/input[3]"));
        elementLoginButton.click();

        //7) Login must fail saying incorrect username/password.
        //Verify if there is the error message
        WebElement expectedElement = driver.findElement(By.xpath("//*[@id='page-36']/div/div[1]/ul/li"));
        String expectedText = expectedElement.getText();
        //System.out.println(expectedText);
        Assert.assertTrue(expectedText.contains(" is incorrect. "));
    }

        @After
    public void destroy(){
        driver.close();
        }
}

package lalita51TestCases.src.test.java.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import lalita51TestCases.src.test.java.pageObject.MyAccountPage;
import lalita51TestCases.src.test.java.utilities.ConfigProp;
import lalita51TestCases.src.test.java.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class LoginTest {
    WebDriver driver;
    MyAccountPage myAccPage = new MyAccountPage();


    @BeforeSuite
    public void goToAutomationPracticeSite() {
        WebDriverManager.chromedriver().setup();
        driver = Driver.getDriver();
    }

    @BeforeTest
    public void goToMyAccountPage() {
        myAccPage.myAccountMenu.click();
    }

    @AfterTest
    public void teardown() {
        driver.quit();
    }

    @AfterSuite
    public void afterClass() {
        System.out.println("----------- MY ACCOUNT - LOGIN TEST DONE -----------");
    }

    @DataProvider
    public Object[][] newGeneratedEmailValidPassword() {
        return new Object[][]{
                new Object[]{myAccPage.generateEmailAddress(), ConfigProp.getProperty("validPassword")},
        };
    }



    @Test(dataProvider = "newGeneratedEmailValidPassword")
    public void TC01_loginValidUsernameAndPassword(String username, String password) {
        myAccPage.register(username, password);
        Assert.assertTrue(myAccPage.greetingContent.isDisplayed());
        myAccPage.signOutLink.click();
        myAccPage.login(username, password);
        myAccPage.verifyLoginSuccess();
        myAccPage.signOutLink.click();
    }

    @Test
    public void TC02_loginIncorrectUsernameIncorrectPassword() {
        myAccPage.login(ConfigProp.getProperty("invalidUsername"), ConfigProp.getProperty("invalidPassword"));
        myAccPage.verifyErrorLoginAndPromptToLogin();
    }

    @Test
    public void TC03_loginCorrectUsernameEmptyPassword() {
        myAccPage.login(ConfigProp.getProperty("validUsername"), " ");
        myAccPage.verifyErrorLoginAndPromptToLogin();
    }

    @Test
    public void TC04_loginEmptyUsernameValidPassword() {
        myAccPage.login(" ", ConfigProp.getProperty("validPassword"));
        myAccPage.verifyErrorLoginAndPromptToLogin();
    }

    @Test
    public void TC05_loginEmptyUsernameEmptyPassword() {
        myAccPage.login(" ", " ");
        myAccPage.verifyErrorLoginAndPromptToLogin();
    }

    @Test
    public void TC06_loginPasswordShouldBeMasked() {
        myAccPage.passwordLoginInput.sendKeys(ConfigProp.getProperty("validPassword"));
        myAccPage.checkIsMasked(myAccPage.passwordLoginInput);
    }

    @Test
    public void TC07_loginHandlesCaseSensitive() {
        myAccPage.login(ConfigProp.getProperty("caseChangedValidUsername"), ConfigProp.getProperty("caseChangedValidPassword"));
        myAccPage.verifyErrorLoginAndPromptToLogin();
    }

    @Test
    public void TC08_loginAuthentication() {
        myAccPage.login(ConfigProp.getProperty("validUsername"), ConfigProp.getProperty("validPassword"));
        myAccPage.signOutLink.click();
        driver.navigate().back();
        myAccPage.checkIsSignIn();
    }
}

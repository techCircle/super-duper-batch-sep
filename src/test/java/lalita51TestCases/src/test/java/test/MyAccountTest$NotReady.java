package lalita51TestCases.src.test.java.test;

import io.github.bonigarcia.wdm.WebDriverManager;
import lalita51TestCases.src.test.java.pageObject.MyAccountPage;
import lalita51TestCases.src.test.java.utilities.ConfigProp;
import lalita51TestCases.src.test.java.utilities.Driver;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


//"==================================== NOT DONE YET!! ==================================="
public class MyAccountTest$NotReady {
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
        myAccPage.login(ConfigProp.getProperty("validUsername"), ConfigProp.getProperty("validPassword"));
        myAccPage.checkLoginSuccess();
        myAccPage.myAccountMenu.click();
    }

//    @AfterMethod
//    public void clearBox() {
//        myAccPage.emailRegisterInput.clear();
//        myAccPage.passwordRegisterInput.clear();
//    }
//
//    @AfterTest
//    public void teardown() {
//        myAccPage.emailRegisterInput.clear();
//        myAccPage.passwordRegisterInput.clear();
//        driver.quit();
//    }

//    @AfterSuite
//    public void afterClass() {
//        System.out.println("----------- MY ACCOUNT TEST DONE -----------");
//    }




    @Test
    public void TC01_myAccountsDashboard() {

        myAccPage.verifyDashboardSiteIsPresent();
    }

    @Test
    public void TC02_myAccountsOrders1() {
        //user must place any order before do this test
        myAccPage.OrdersLink.click();
        myAccPage.verifyViewOrdersInOrdersLink();
    }

    @Test
    public void TC03_myAccountsOrders2() {
        myAccPage.OrdersLink.click();
        myAccPage.viewBtn.click();
        myAccPage.verifyOrderDetailInViewBtn();
        myAccPage.verifyCustomerDetailInViewBtn();
        myAccPage.verifyBillingDetailInViewBtn();
    }

    @Test
    public void TC04_myAccountsOrders3() {
        myAccPage.OrdersLink.click();
        myAccPage.viewBtn.click();
        myAccPage.verifyOrderSummaryInViewBtn();
    }

    @Test
    public void TC05_myAccountsAddressFunctionality1() {
        myAccPage.addressesLink.click();
        myAccPage.verifyBillingAddressInAddressLink();
        myAccPage.verifyShippingAddressInAddressLink();
    }

//    @Test
//    public void TC06_myAccountsAddressFunctionality2() {
//        myAccPage.addressesLink.click();
//        myAccPage.EditShippingAddressLink.click();
//        myAccPage.editShippingAddress();
//    }

//    @Test
//    public void TC07_myAccountsDetails() {
//
//    }

//    @Test
//    public void TC08_myAccountsLogOut() {
//    }
}

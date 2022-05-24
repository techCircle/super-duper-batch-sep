package thunpanBee51TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePage extends Driver{
	private ObjectFactory homepage;

    @BeforeClass
    public void setUp() {
        getDriver();
    }

    @BeforeMethod
    public void test1and2() {
        homepage = new ObjectFactory(driver);
        homepage.shopBtn.click();
        homepage.homeBtn.click();
        homepage.homePageSlideVerify(); //Home Page with three Sliders only
        homepage.newArrivalImageVerify(); //Home page with three Arrivals only
    }
    @Test(priority = 1)
    public void test3(){//Home page - Images in Arrivals should navigate
        homepage.masterJavaBookImg.click();
        homepage.programmingBook.click();
        homepage.getTitle();
        homepage.addCartBtnIsEnable();

    }
    @Test(priority = 2)
    public void test4(){ //Home page - Arrivals-Images-Description
        homepage.masterJavaBookImg.click();
        homepage.programmingBook.click();
        homepage.descriptionTab.click();
        homepage.descriptionVerify();
    }
    @Test(priority = 3)
    public void test5(){ //Home page - Arrivals-Images-Reviews
        homepage.masterJavaBookImg.click();
        homepage.programmingBook.click();
        homepage.reviewTab.click();
        homepage.reviewVerify();
    }
    @Test(priority = 4)
    public void test6(){ //Home page - Arrivals-Images-Add to Basket
        homepage.masterJavaBookImg.click();
        homepage.programmingBook.click();
        homepage.addCartBtn.click();
        homepage.verifyBasket();
    }

    @Test(priority = 5)
    public void test7(){ //Home page - Arrivals-Add to Basket with more books
        homepage.masterJavaBookImg.click();
        homepage.programmingBook.click();
        homepage.addCartBtn.click();
        homepage.verifyBasket();
        homepage.inputQuantity();

    }
    @Test(priority = 6)
    public void test8(){ //Home-Arrivals-Add to Basket-Items
        homepage.masterJavaBookImg.click();
        homepage.programmingBook.click();
        homepage.addCartBtn.click();
        homepage.verifyBasket();
        homepage.viewCart.click();
        homepage.isCheckoutBtnEnable();
    }
    @Test(priority = 7)
    public void test9(){ //Home-Arrivals-Add to Basket-Items-Coupon
        homepage.masterJavaBookImg.click();
        homepage.programmingBook.click();
        homepage.inputSend4();
        homepage.addCartBtn.click();
        homepage.verifyBasket();
        homepage.viewCart.click();
        homepage.isCheckoutBtnEnable();
        homepage.couponBoxInput();
        homepage.couponVerify();
    }
    @Test(priority = 8)
    public void test10(){//Home-Arrivals-Add to Basket-Items-Coupon value<450

        homepage.masterJavaBookImg.click();
        homepage.programmingBook.click();
        homepage.addCartBtn.click();
        homepage.verifyBasket();
        homepage.viewCart.click();
        homepage.isCheckoutBtnEnable();
        homepage.couponBoxInput();
        homepage.couponVerify();
    }
    @Test(priority = 9)
    public void test11(){ //Home-Arrivals-Add to Basket-Items-Remove book

        homepage.masterJavaBookImg.click();
        homepage.programmingBook.click();
        homepage.addCartBtn.click();
        homepage.verifyBasket();
        homepage.viewCart.click();
        homepage.isCheckoutBtnEnable();
        homepage.removeBtn.click();
        homepage.removeVerify();
    }
    @Test(priority = 10)
    public void test12(){ //Home-Arrivals-Add to Basket-Items-Add book

        homepage.masterJavaBookImg.click();
        homepage.programmingBook.click();
        homepage.addCartBtn.click();
        homepage.verifyBasket();
        homepage.viewCart.click();
        homepage.isCheckoutBtnEnable();
        homepage.qtyInput();
        homepage.isUpdateBasketBtnIsEnable();
        homepage.updateBasketBtn.click();
        homepage.basketTextVerify();
    }
    @Test(priority = 11)
    public void test13(){ //Home-Arrivals-Add to Basket-Items-Check-out-Book Final price
        homepage.masterJavaBookImg.click();
        homepage.programmingBook.click();
        homepage.addCartBtn.click();
        homepage.verifyBasket();
        homepage.viewCart.click();
        homepage.totalPriceVerify();

    }
    @Test(priority = 12)
    public void test14(){ //Home-Arrivals-Add to Basket-Items-Check-out-Update Basket
        homepage.masterJavaBookImg.click();
        homepage.programmingBook.click();
        homepage.addCartBtn.click();
        homepage.verifyBasket();
        homepage.viewCart.click();
        homepage.isCheckoutBtnEnable();
        homepage.qtyInput();
        homepage.isUpdateBasketBtnIsEnable();
        homepage.updateBasketBtn.click();
        homepage.basketTextVerify();
    }
    @Test(priority = 13)
    public void test15(){ //Home-Arrivals-Add to Basket-Items-Check-out-Total & Sub-total condition

        homepage.masterJavaBookImg.click();
        homepage.programmingBook.click();
        homepage.addCartBtn.click();
        homepage.verifyBasket();
        homepage.viewCart.click();
        homepage.totalAndSubtotal();
    }
    @Test(priority = 14)
    public void test16(){ //Home-Arrivals-Add to Basket-Items-Check-out functionality

        homepage.masterJavaBookImg.click();
        homepage.programmingBook.click();
        homepage.addCartBtn.click();
        homepage.verifyBasket();
        homepage.viewCart.click();
        homepage.totalAndSubtotal();
        homepage.checkOutBtn.click();
        homepage.getTitle();

    }
    @Test(priority = 15)
    public void test17(){ //Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway

        homepage.masterJavaBookImg.click();
        homepage.programmingBook.click();
        homepage.addCartBtn.click();
        homepage.verifyBasket();
        homepage.viewCart.click();
        homepage.totalAndSubtotal();
        homepage.checkOutBtn.click();
        homepage.billingLabelVerify();
        homepage.formVerify();

    }
    @Test(priority = 16)
    public void test18(){ //Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway-Place order
        homepage.masterJavaBookImg.click();
        homepage.programmingBook.click();
        homepage.addCartBtn.click();
        homepage.verifyBasket();
        homepage.viewCart.click();
        homepage.totalAndSubtotal();
        homepage.checkOutBtn.click();
        homepage.billingLabelVerify();
        homepage.formVerify();
        homepage.formFillIn();//have to change email every executed//
        homepage.placeOrderBtn.click();
        homepage.orderConfirm();
    }
    @AfterClass
    public void Destroy(){
        Driver.destroy();
    }

}

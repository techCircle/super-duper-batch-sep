package thunpanBee51TestCases;

import org.testng.annotations.BeforeClass;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import thunpanBee51TestCasesPageObj.BasketObj;
import thunpanBee51TestCasesPageObj.HomePageObj;
import thunpanBee51TestCasesPageObj.ProductPageObj;
import thunpanBee51TestCasesPageObj.ShopObjPage;

public class HomePageTesting {
	private HomePageObj homepage;
	private ShopObjPage shop;
	private ProductPageObj productPage = new ProductPageObj();
	private BasketObj basketPage = new BasketObj();

	@BeforeClass
	public void setUp() {
		Driver.getDriver();

	}

	@BeforeMethod
	public void test1and2() {
		shop = new ShopObjPage();
		homepage = new HomePageObj();
		homepage.clickShop();
		shop.clickOnHomeBtn();
	}

	@Test
	public void TC001_HomePageWithThreeSlidersOnly() {

		homepage.verifyHomePageSlide();
	}

	@Test
	public void TC002_HomePageWithThreeArrivalsOnly() {

		homepage.verifyNewArrivalSlide();
	}

	@Test
	public void TC003_HomePageImagesInArrivalsShouldNavigate() {

		homepage.verifyImagesInArrivalsShouldNavigate();
		homepage.clickRelatedProduct();
		productPage.verifyAddBasKetBtn();

	}

	@Test
	public void TC004_HomepageArrivalsImagesDescription() {

		homepage.clickRelatedProduct();
		productPage.clickDescription();
		productPage.verifyDescription();

	}

	@Test
	public void TC005_HomepageArrivalsImagesReviews() {

		homepage.clickRelatedProduct();
		productPage.clickreview();
		productPage.verifyReview();

	}
    @Test
    public void TC006_HomepageArrivalsImagesAddToBasket(){ 
    	
    	homepage.clickRelatedProduct();
    	productPage.clickOnAddBasket();
    	productPage.verifyViewCartIsDisplay();
    	   	
    }

//    @Test(priority = 5)
//    public void TC007_HomepageArrivalsAddToBasketWithMoreBooks(){ 
//        homepage.masterJavaBookImg.click();
//        homepage.programmingBook.click();
//        homepage.addCartBtn.click();
//        homepage.verifyBasket();
//        homepage.inputQuantity();
//
//    }
//    @Test(priority = 6)
//    public void TC008_HomeArrivalsAddToBasketItems(){ 
//        homepage.masterJavaBookImg.click();
//        homepage.programmingBook.click();
//        homepage.addCartBtn.click();
//        homepage.verifyBasket();
//        homepage.viewCart.click();
//        homepage.isCheckoutBtnEnable();
//    }
//    @Test(priority = 7)
//    public void TC009_HomeArrivalsAddToBasketItemsCoupon(){ 
//        homepage.masterJavaBookImg.click();
//        homepage.programmingBook.click();
//        homepage.inputSend4();
//        homepage.addCartBtn.click();
//        homepage.verifyBasket();
//        homepage.viewCart.click();
//        homepage.isCheckoutBtnEnable();
//        homepage.couponBoxInput();
//        homepage.couponVerify();
//    }
//    @Test(priority = 8)
//    public void TC010_HomeArrivalsAddToBasketItemsCouponValue450(){
//
//        homepage.masterJavaBookImg.click();
//        homepage.programmingBook.click();
//        homepage.addCartBtn.click();
//        homepage.verifyBasket();
//        homepage.viewCart.click();
//        homepage.isCheckoutBtnEnable();
//        homepage.couponBoxInput();
//        homepage.couponVerify();
//    }
//    @Test(priority = 9)
//    public void TC011_HomeArrivalsAddToBasketItemsRemoveBook(){ 
//
//        homepage.masterJavaBookImg.click();
//        homepage.programmingBook.click();
//        homepage.addCartBtn.click();
//        homepage.verifyBasket();
//        homepage.viewCart.click();
//        homepage.isCheckoutBtnEnable();
//        homepage.removeBtn.click();
//        homepage.removeVerify();
//    }

//  @Test
//	public void TC012_HomeArrivalsAddToBasketItemsAddBook() {
//		homepage.verifyImagesInArrivalsShouldNavigate();
//		homepage.clickRelatedProduct();
//		productPage.verifyAddBasKetBtn();
//		//productPage.clickOnAddBasket();
//		basketPage.inoputQTYBox();
//		basketPage.verifyUpadteInfo();
//
//	}
//    @Test(priority = 11)
//    public void TC013_HomeArrivalsAddToBasketItemsCheckoutBookFinalPrice(){ 
//        homepage.masterJavaBookImg.click();
//        homepage.programmingBook.click();
//        homepage.addCartBtn.click();
//        homepage.verifyBasket();
//        homepage.viewCart.click();
//        homepage.totalPriceVerify();
//
//    }

//    @Test(priority = 13)
//    public void TC014_HomeArrivalsAddToBasketItemsCheckoutUpdateBasket(){ 
//
//        homepage.masterJavaBookImg.click();
//        homepage.programmingBook.click();
//        homepage.addCartBtn.click();
//        homepage.verifyBasket();
//        homepage.viewCart.click();
//        homepage.totalAndSubtotal();
//    }
//    @Test(priority = 14)
//    public void TC015_HomeArrivalsAddToBasketItemsCheckoutTotalSubTotalCondition(){ 
//
//        homepage.masterJavaBookImg.click();
//        homepage.programmingBook.click();
//        homepage.addCartBtn.click();
//        homepage.verifyBasket();
//        homepage.viewCart.click();
//        homepage.totalAndSubtotal();
//        homepage.checkOutBtn.click();
//        homepage.getTitle();
//
//    }
//    @Test(priority = 15)
//    public void TC016_HomeArrivalsAddToBasketItemsCheckoutFunctionality(){ 
//
//        homepage.masterJavaBookImg.click();
//        homepage.programmingBook.click();
//        homepage.addCartBtn.click();
//        homepage.verifyBasket();
//        homepage.viewCart.click();
//        homepage.totalAndSubtotal();
//        homepage.checkOutBtn.click();
//        homepage.billingLabelVerify();
//        homepage.formVerify();
//
//    }
//    @Test(priority = 16)
//    public void TC017_HomeArrivalsAddToBasketItemsCheckoutPaymentGateway(){
//        homepage.masterJavaBookImg.click();
//        homepage.programmingBook.click();
//        homepage.addCartBtn.click();
//        homepage.verifyBasket();
//        homepage.viewCart.click();
//        homepage.totalAndSubtotal();
//        homepage.checkOutBtn.click();
//        homepage.billingLabelVerify();
//        homepage.formVerify();
//        homepage.formFillIn();//have to change email every executed//
//        homepage.placeOrderBtn.click();
//        homepage.orderConfirm();
//    }
//    	public void TC018_HomeArrivalsAddToBasketItemsCheckoutPaymentGatewayPlaceOrder() {

//    	}

//    @AfterClass
//    public void Destroy(){
//        Driver.destroy();
//    }
    
    
}

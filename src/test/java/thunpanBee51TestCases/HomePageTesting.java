package thunpanBee51TestCases;

import org.testng.annotations.AfterClass;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTesting extends PageInitialized {

	@BeforeClass
	public void setUp() {
		Driver.getDriver();

	}

	@BeforeMethod
	public void test1and2() {

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
	public void TC006_HomepageArrivalsImagesAddToBasket() {

		homepage.clickRelatedProduct();
		productPage.clickOnAddBasket();
		productPage.verifyViewCartIsDisplay();

	}

	@Test
	public void TC007_HomepageArrivalsAddToBasketWithMoreBooks() {

		homepage.clickRelatedProduct();
		productPage.clickOnAddBasket();
		productPage.verifyViewCartIsDisplay();
		productPage.inputQuantity();

	}

	@Test
	public void TC008_HomeArrivalsAddToBasketItems() {

		homepage.clickRelatedProduct();
		productPage.clickOnAddBasket();
		productPage.verifyViewCartIsDisplay();
		productPage.clickOnCartBtn();
		basketPage.verifyCheckoutBtn();

	}

	@Test
	public void TC009_HomeArrivalsAddToBasketItemsCoupon() throws InterruptedException {
		homepage.clickRelatedProduct();
		productPage.clickOnAddBasket();
		productPage.verifyViewCartIsDisplay();
		productPage.clickOnCartBtn();
		basketPage.verifyCheckoutBtn();
		basketPage.inputQTYBox();
		Thread.sleep(2000);
		basketPage.couponBoxInput();
		basketPage.couponVerify();
	}

	@Test
	public void TC010_HomeArrivalsAddToBasketItemsCouponValue450() {

		homepage.clickRelatedProduct();
		productPage.clickOnAddBasket();
		productPage.verifyViewCartIsDisplay();
		productPage.clickOnCartBtn();
		basketPage.verifyCheckoutBtn();
		basketPage.couponBoxInput();
		basketPage.couponVerify();
	}

	@Test
	public void TC011_HomeArrivalsAddToBasketItemsRemoveBook() throws InterruptedException {

		homepage.clickRelatedProduct();
		productPage.clickOnAddBasket();
		productPage.verifyViewCartIsDisplay();
		productPage.clickOnCartBtn();
		basketPage.verifyCheckoutBtn();
		basketPage.clickRvmBtn();
		Thread.sleep(2000);
		basketPage.verifyRemove();
	}

	@Test
	public void TC012_HomeArrivalsAddToBasketItemsAddBook() {

		homepage.clickRelatedProduct();
		productPage.verifyAddBasKetBtn();
		productPage.clickOnAddBasket();
		productPage.clickOnCartBtn();
		basketPage.inputQTYBox();
		basketPage.verifyUpadteInfo();

	}

	@Test
	public void TC013_HomeArrivalsAddToBasketItemsCheckoutBookFinalPrice() {

		homepage.clickRelatedProduct();
		productPage.verifyAddBasKetBtn();
		productPage.clickOnAddBasket();
		productPage.clickOnCartBtn();
		basketPage.verifyTotalPrice();

	}

	@Test
	public void TC014_HomeArrivalsAddToBasketItemsCheckoutUpdateBasket() {

		homepage.clickRelatedProduct();
		productPage.verifyAddBasKetBtn();
		productPage.clickOnAddBasket();
		productPage.clickOnCartBtn();
		basketPage.inputQTYBox();
		basketPage.verifyUpadteInfo();
	}

	@Test
	public void TC015_HomeArrivalsAddToBasketItemsCheckoutTotalSubTotalCondition() {

		homepage.clickRelatedProduct();
		productPage.verifyAddBasKetBtn();
		productPage.clickOnAddBasket();
		productPage.clickOnCartBtn();
		basketPage.totalAndSubtotal();

	}

	@Test
	public void TC016_HomeArrivalsAddToBasketItemsCheckoutFunctionality() {

		homepage.clickRelatedProduct();
		productPage.verifyAddBasKetBtn();
		productPage.clickOnAddBasket();
		productPage.clickOnCartBtn();
		basketPage.totalAndSubtotal();
		basketPage.clickCheckout();
		coPage.verifyBillinLabelAndForm();

	}

	@Test
	public void TC017_HomeArrivalsAddToBasketItemsCheckoutPaymentGateway() throws InterruptedException {
		homepage.clickRelatedProduct();
		productPage.verifyAddBasKetBtn();
		productPage.clickOnAddBasket();
		productPage.clickOnCartBtn();
		basketPage.totalAndSubtotal();
		basketPage.clickCheckout();
		coPage.verifyBillinLabelAndForm();
		coPage.formFillIn();

	}

	@Test
	public void TC018_HomeArrivalsAddToBasketItemsCheckoutPaymentGatewayPlaceOrder() throws InterruptedException {
		homepage.clickRelatedProduct();
		productPage.verifyAddBasKetBtn();
		productPage.clickOnAddBasket();
		productPage.clickOnCartBtn();
		basketPage.totalAndSubtotal();
		basketPage.clickCheckout();
		coPage.verifyBillinLabelAndForm();
		coPage.formFillIn();
		coPage.clickPlaceOrder();
		orderRecieved.verifyOrderConfirm();
	}

	@AfterClass
	public void Destroy() {
		Driver.destroy();
	}

}

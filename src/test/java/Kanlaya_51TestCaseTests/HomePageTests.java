package Kanlaya_51TestCaseTests;

import org.testng.annotations.Test;

import Kanlaya_51TestCasePages.HomePage;
import Kanlaya_51TestCasePages.ShopPage;
import Kanlaya_51TestCaseUtilities.Base;
import Kanlaya_51TestCaseUtilities.Constants;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class HomePageTests {

	HomePage homePage = new HomePage();
	ShopPage shopPage = new ShopPage();

	@BeforeClass 
	public void setUp() {
		Base.getDriver();
		
	}
	
	@BeforeMethod
	public void beforeMethod() {
		homePage.shopButton.click();
		shopPage.homeButton.click();
		
	}

	
	@Test(priority = 1)
	public void HomePageWithThreeSlidersOnly() {
		
		homePage.verifyHomePageHas3SlidesOnly(Constants.slidersCount);
		
	}
	
	
	@Test(priority = 2)
	public void HomePageWith3ArrivalsOnly() {
	
		homePage.verifyHomePageWith3ArrivalsOnly(Constants.arrivalsCount);
	}
	
	
	@Test(priority = 3)
	public void HomePageImagesInArrivalsShouldNavigate() {
		
		homePage.verifyHomePageWith3ArrivalsOnly(Constants.arrivalsCount);
		homePage.verifyImagesInArrivalsShouldNavigate();
	}
	
	
	@Test(priority = 4)
	public void HomePageArrivalsImagesDescription() {
		
		homePage.verifyHomePageWith3ArrivalsOnly(Constants.arrivalsCount);
		homePage.verifyArrivalsDescription();
	}
	
	@Test(priority = 5)
	public void HomePageArrivalsImagesReviews() {
		
		homePage.verifyHomePageWith3ArrivalsOnly(Constants.arrivalsCount);
		homePage.verifyArrivalsReviews();
	}
	
	@Test(priority = 6)
	public void  HomePageArrivalsImagesAddtoBasket() {
		
		homePage.verifyHomePageWith3ArrivalsOnly(Constants.arrivalsCount);
		homePage.shopButton.click();
		homePage.functionalProgrammingInJSBook.click();
		homePage.verifyBookPrice();
		homePage.addToBasketButton.click();
		homePage.verifyAddBook();
			
	}
	
	@Test(priority = 7)
	public void  HomePageArrivalsAddtoBasketWithMoreBooks() {
		
		homePage.verifyHomePageWith3ArrivalsOnly(Constants.arrivalsCount);
		homePage.addBooksMoreThanBooksAvaialble();
		
	}
	
	@Test(priority = 8)
	public void HomeArrivalsAddtoBasketItems() {
		
		homePage.verifyHomePageWith3ArrivalsOnly(Constants.arrivalsCount);
		homePage.shopButton.click();
		homePage.functionalProgrammingInJSBook.click();
		homePage.verifyBookPrice();
		homePage.addToBasketButton.click();
		homePage.verifyAddBook();
		homePage.viewBasketButton.click();
		homePage.checkoutButton.click();
		homePage.verifyCheckoutPage();
	}

	@Test(priority = 9)
	public void HomeArrivalsAddtoBasketItemsCoupon() {
		
		homePage.verifyHomePageWith3ArrivalsOnly(Constants.arrivalsCount);
		homePage.shopButton.click();
		homePage.functionalProgrammingInJSBook.click();
		homePage.verifyBookPrice();
		homePage.addToBasketButton.click();
		homePage.verifyAddBook();
		homePage.viewBasketButton.click();
		homePage.checkoutButton.click();
		homePage.verifyCheckoutPage();
		homePage.addCouponLink.click();
		homePage.couponField.sendKeys("krishnasakinala");
		homePage.applyCouponButton.click();
		homePage.verifyAddCoupon();
			
	}
	
	@Test(priority = 10)
	public void HomeArrivalsAddtoBasketItemsCouponvalueLessThan450(){
		
		homePage.verifyHomePageWith3ArrivalsOnly(Constants.arrivalsCount);
		homePage.shopButton.click();
		homePage.functionalProgrammingInJSBook.click();
		homePage.verifyBookPrice();
		homePage.addToBasketButton.click();
		homePage.verifyAddBook();
		homePage.viewBasketButton.click();
		homePage.checkoutButton.click();
		homePage.verifyCheckoutPage();
		homePage.addCouponLink.click();
		homePage.couponField.sendKeys("krishnasakinala");
		homePage.applyCouponButton.click();
		homePage.verifyAddCoupon();
	}
	
	@Test(priority = 11)
	public void HomeArrivalsAddtoBasketItemsRemoveBook() {
		
		homePage.verifyHomePageWith3ArrivalsOnly(Constants.arrivalsCount);
		homePage.shopButton.click();
		homePage.functionalProgrammingInJSBook.click();
		homePage.verifyBookPrice();
		homePage.addToBasketButton.click();
		homePage.verifyAddBook();
		homePage.viewBasketButton.click();
		homePage.removeIcon.click();
		homePage.verifyBookRemoved();
		
		
	}
	
	@Test(priority = 12)
	public void HomeArrivalsAddtoBasketItemsAddBook() {
	
		homePage.verifyHomePageWith3ArrivalsOnly(Constants.arrivalsCount);
		homePage.shopButton.click();
		homePage.functionalProgrammingInJSBook.click();
		homePage.verifyBookPrice();
		homePage.addToBasketButton.click();
		homePage.verifyAddBook();
		homePage.viewBasketButton.click();
		
	}
	
	

	@AfterClass
	public void tearDown() {
		Base.teardown();
	}

}
/*


12. Home-Arrivals-Add to Basket-Items-Add book
13. Home-Arrivals-Add to Basket-Items-Check-out-Book Final price
14. Home-Arrivals-Add to Basket-Items-Check-out-Update Basket
15. Home-Arrivals-Add to Basket-Items-Check-out-Total & Sub-total condition
16. Home-Arrivals-Add to Basket-Items-Check-out functionality
17. Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway
18. Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway-Place order
*/


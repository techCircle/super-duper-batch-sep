package EmmieTestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Emmie_Utilities.Emmie_Driver;
import Emmie_automationTestingPage.HomePage;
import Emmie_automationTestingPage.ProductPage;
import Emmie_automationTestingPage.ShopPage;

public class HomePageTest {
	HomePage hP = new HomePage();
	ShopPage sP = new ShopPage();
	ProductPage pD = new ProductPage();

	
	
	@BeforeClass
	public void beforeTest(){
		Emmie_Driver.getDriver();
	}
	
	
	@BeforeMethod
	public void setUp() {
		
		hP.shopBtnClick();
		sP.homeBtnClick();
	}

	@Test
	public void homePagewiththreeSlidersonly() {

		hP.checkSliderCount();

	}

	@Test
	public void homepagewiththreeArrivals() {

		hP.checkNewArrival();
	}

	@Test
	public void homepageImagInArrivalsShouldNavigate() {

		hP.threeArrivalShouldNavigate();
	}

	@Test
	public void ArrivalsImagesDescription() {
		pD.navigateToDespription();
	}

	/*
	 * Home page - Arrivals-Images-Description 5. Home page -
	 * Arrivals-Images-Reviews 6. Home page - Arrivals-Images-Add to Basket 7. Home
	 * page - Arrivals-Add to Basket with more books 8. Home-Arrivals-Add to
	 * Basket-Items 9. Home-Arrivals-Add to Basket-Items-Coupon 10.
	 * Home-Arrivals-Add to Basket-Items-Coupon value<450 11. Home-Arrivals-Add to
	 * Basket-Items-Remove book 12. Home-Arrivals-Add to Basket-Items-Add book 13.
	 * Home-Arrivals-Add to Basket-Items-Check-out-Book Final price 14.
	 * Home-Arrivals-Add to Basket-Items-Check-out-Update Basket 15.
	 * Home-Arrivals-Add to Basket-Items-Check-out-Total & Sub-total condition 16.
	 * Home-Arrivals-Add to Basket-Items-Check-out functionality 17.
	 * Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway 18.
	 * Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway-Place order
	 * 
	 */

	
	@AfterClass
	public void tearDown() {
		Emmie_Driver.tearDown();
	}
}

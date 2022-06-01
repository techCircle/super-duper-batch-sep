package victor_aut51CasesTest;

import org.junit.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import victor.utilities.Victor_BaseClass;
import victor.utilities.Victor_Constants;
import victor.automationTesting.pages.homePage;
import victor.automationTesting.pages.shopPage;

public class HomePageTest {
	homePage hP = new homePage (); 
	shopPage sP = new shopPage ();
	
	@BeforeMethod
    public void setUp() {
		Victor_BaseClass.getDriver();
		hP.shopbutton.click();
	    sP.homeButton.click();

    }
	
	
	
	@Test(priority= 1, enabled = false)
	public void HomePageWithThreeSlidersOnly() {
		
	    hP.checkSlidersCount(Victor_Constants.slidersCount);
	    
	 }
	
	@Test(priority= 2, enabled = false)
	
	public void HomePageWithThreeArrivalsOnly () {
	    
		hP.checkArrivalsCount(Victor_Constants.arrivalsCount);
	    	
	}
	
	@Test(priority= 3, enabled = false)
	public void HomePageImagesInArrivalsShouldNavigate () {
		
		hP.checkArrivalsCount(Victor_Constants.arrivalsCount);
		
		hP.VerifyImagesInArrivalsShouldNavigate();
			
		}
	
	@Test(priority= 4, enabled = false)
	public void HomPageArrivalsImagesDescription () {
		
		hP.checkArrivalsCount(Victor_Constants.arrivalsCount);
		
		hP.VerifyImagesInArrivalsShouldNavigateWithDescription();
		
		}
	@Test(priority= 5, enabled = false)
	public void HomPageArrivalsImagesReviews () {
		
		hP.checkArrivalsCount(Victor_Constants.arrivalsCount);
		
		hP.VerifyImagesInArrivalsShouldNavigateWithReviews();
		
		}
	
	@Test(priority= 6, enabled = true)
	public void HomePageArrivalsImagesAddToBasket () {
		
		hP.checkArrivalsCount(Victor_Constants.arrivalsCount);
		hP.VerifyAddToBasketButtonEnable();
			
		}
		
	 
	 @AfterClass
	    public void tearDown() {
	    	Victor_BaseClass.tearDown();
	    }

	
}

//6. Home page - Arrivals-Images-Add to Basket
//7. Home page - Arrivals-Add to Basket with more books
//8. Home-Arrivals-Add to Basket-Items
//9. Home-Arrivals-Add to Basket-Items-Coupon
//10. Home-Arrivals-Add to Basket-Items-Coupon value<450
//11. Home-Arrivals-Add to Basket-Items-Remove book
//12. Home-Arrivals-Add to Basket-Items-Add book
//13. Home-Arrivals-Add to Basket-Items-Check-out-Book Final price
//14. Home-Arrivals-Add to Basket-Items-Check-out-Update Basket
//15. Home-Arrivals-Add to Basket-Items-Check-out-Total & Sub-total condition
//16. Home-Arrivals-Add to Basket-Items-Check-out functionality
//17. Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway
//18. Home-Arrivals-Add to Basket-Items-Check-out-Payment Gateway-Place order
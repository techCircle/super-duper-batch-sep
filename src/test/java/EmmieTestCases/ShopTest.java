package EmmieTestCases;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Emmie_Utilities.Emmie_Driver;
import Emmie_automationTestingPage.HomePage;
import Emmie_automationTestingPage.ShopPage;

public class ShopTest {
	HomePage hP = new HomePage();
	ShopPage sP = new ShopPage();

	@BeforeClass
	public void setUp() {
		Emmie_Driver.getDriver();
	}

	@BeforeMethod
	public void before() {
		hP.shopBtnClick();

	}

	@Test
	public void AshopFilterByPriceFunctionality() {

		sP.moveSlider();
		sP.filterBtnClick();
		sP.verifyPrices();
		
	}

	@Test
	public void shopProductCategoriesFunctionality() {
		sP.productCatergory();
		sP.clickProductCategory();
	}

	@Test
	public void shopDefaultSortingPopularity() {
		sP.selectSortingPopularity();

	}
	@Test
	public void shopDefaultSortingAverage() {
		sP.selectSortingAveRating();

	}
	@Test
	public void shopDefaultSortingNewnees() {
		sP.selectSortingNewness();

	}
	@Test
	public void shopDefaultSortingLowToHigh() {
		sP.selectSortingLowToHigh();

	}
	@Test
	public void shopDefaultSortingHighToLow() {
		sP.selectSortingHighToLow();

	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@AfterClass
//	public void tearDown() {
//		Driver.tearDown();
//	}

}

/*
 * 4. Shop-Default Sorting Functionality 5. Shop-Default Sorting Functionality
 * 6. Shop-Default Sorting Functionality 7. Shop-Default Sorting Functionality
 * 8. Shop-Read More Functionality 9. Shop-Sale Functionality 10. Shop-Add to
 * Basket-View Basket Functionality 11.Shop-Add to Basket-View Basket through
 * Item link 12. Shop-Add to Basket-View Basket-Tax Functionality
 */


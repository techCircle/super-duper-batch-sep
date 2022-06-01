package anoma51TestCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import apPageObjects.ShopPage;
import apUtilities.BaseClass;

public class ShopTest {

	ShopPage sp = new ShopPage();

	@BeforeSuite
	public void setUp() throws InterruptedException {
		BaseClass.getDriver();
	}

	@BeforeMethod
	public void beforeTest() {
		sp.shopMenu.click();
	}

	@Test(groups="anoma",priority=1)
	public void filterByPrice() {
		sp.verifySlider();
	}

	@Test(groups="anoma",priority=2)
	public void productCategories() {
		sp.product.click();
		sp.verifyProduct();
	}

	@Test(groups="anoma",priority=3)
	public void sortByPopularity() {
		sp.verifySortByPopularity();
	}

	@Test(groups="anoma",priority=4)
	public void sortByAverageRating() {
		sp.verifySortByAverageRating();
	}

	@Test(groups="anoma",priority=5)
	public void sortByNewness() {
		sp.verifySortByNewness();
	}

	@Test(groups="anoma",priority=6)
	public void sortByLowToHigh() {
		sp.verifySortByLowToHigh();
	}

	@Test(groups="anoma",priority=7)
	public void sortByHighToLow() {
		sp.verifySortByHighToLow();
	}

	@Test(groups="anoma",priority=8)
	public void readMoreFunctionallity() {
		sp.VerifyReadMoreFunctionallity();
	}

	@Test(groups="anoma",priority=9)
	public void saleFunctionallity() {
		sp.verifySaleFunctionallity();
	}
	
	@Test(groups="anoma",priority=10)
	public void addToBasKetViewBasketFunctionallity() {
		sp.addToBasket.click();
		sp.viewBasket.click();
		sp.verifyCartItems();
		sp.totalDisplay();
		sp.subtotalDisplay();
		sp.totalGreaterThanSubtotal();
		sp.proceedToCheckout.click();
		sp.chkoutPageDisplay();
		sp.fillingchkoutForm();
		sp.VerifyOrderComplete();
	}
	@Test(groups="anoma",priority=11)
	public void addToBasKetViewBasketByItemLink() {
		sp.addToBasket.click();
		sp.itemLink.click();
		sp.verifyCartItems();
		sp.totalDisplay();
		sp.subtotalDisplay();
		sp.totalGreaterThanSubtotal();
		sp.proceedToCheckout.click();
		sp.chkoutPageDisplay();
		sp.fillingchkoutForm();
		sp.VerifyOrderComplete();
	}
	@AfterSuite
	public void afterMethod() {
		BaseClass.tearDown();
	}

}

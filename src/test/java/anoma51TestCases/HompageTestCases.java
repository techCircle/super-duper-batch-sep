package anoma51TestCases;

import org.testng.annotations.Test;
import apPageObjects.HomepagePage;
import apUtilities.BaseClass;
import apUtilities.Constants;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class HompageTestCases {

	HomepagePage hp = new HomepagePage();

	@BeforeSuite
	public void setUp() throws InterruptedException {
		BaseClass.getDriver();
	}

	@BeforeMethod
	public void beforeClass() {
		hp.shopMenu.click();
		hp.homeMenu.click();
	}

	@Test(groups = "anoma", priority = 1)
	public void ThreeSliders() {
		hp.checkSlidersCount(Constants.slidersCount);

	}

	@Test(groups = "anoma", priority = 2)
	public void ThreeNewArrivals() {
		hp.checkArrivalsCount(Constants.arrivalsCount);
	}

	@Test(groups = "anoma", priority = 3)
	public void ImagesArrivalsShouldNavigate() {
		hp.checkArrivalsCount(Constants.arrivalsCount);
		hp.ImagesArrivalsShouldNavigate_byUrl();
	}

	@Test(groups = "anoma", priority = 4)
	public void NewArrivalDescription() {
		hp.checkArrivalsCount(Constants.arrivalsCount);
		hp.verifyNewArrivalsDescription();
	}

	@Test(groups = "anoma", priority = 5)
	public void NewArrivalReviews() {
		hp.checkArrivalsCount(Constants.arrivalsCount);
		hp.verifyNewArrivalsReviews();
	}

	@Test(groups = "anoma", priority = 6)
	public void arrivalImgAddToBasket() {
		hp.checkArrivalsCount(Constants.arrivalsCount);
		hp.VerifyArrivalImgAddToBasket();
	}

	@Test(groups = "anoma", priority = 8)
	public void arrivalImgItemLink() {
		hp.checkArrivalsCount(Constants.arrivalsCount);
		hp.VerifyArrivalImgItemLink();
	}

	@AfterSuite
	public void afterMethod() {
		BaseClass.tearDown();
	}

}

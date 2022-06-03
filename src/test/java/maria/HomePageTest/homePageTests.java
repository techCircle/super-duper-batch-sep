package maria.HomePageTest;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


import maria.HomePage.HomePagePage;
import maria.HomePage.shopPage;
import mariaUtilities.Driver;
//changes to pushzzz
public class homePageTests {

	HomePagePage hP = new HomePagePage();
	shopPage sP = new shopPage();

	@BeforeMethod
	public void setUp() {

		Driver.getDriver();
		hP.shopButton.click();
		sP.homeButton.click();

	}

	@Test(priority=1)
	public void HomePageWithThreeSlidersOnly() throws InterruptedException {

		hP.checkSlidersCount();

	}

	@Test(priority=2)
	public void HomePageWithThreeArrivalsOnly() {

		hP.checkArrivalsCount();
	}

	@Test(priority=3)
	public void HomePageImagesArrivalsShouldNavigate() throws InterruptedException {

		hP.checkArrivalsCount();

		hP.verifyImagesInArrivalsShouldNavigate();


		}
	@Test(priority=4)         //test4
	public void HomePageImagesArrivalImageDescription() throws InterruptedException {
		this.HomePageImagesArrivalsShouldNavigate();
	hP.arrivalImage2click();
	hP.arrivalImage2description();
	
	
	}

	@Test(priority=5)         //test5
	public void HomePageImagesArrivalImageReview() throws InterruptedException {
		this.HomePageImagesArrivalsShouldNavigate();
		hP.arrivalImage2click();
		hP.arrivalImage2Review();
			
	}
	
	@Test(priority=6)         //test6
	public void ArrivalImageAddToBasket() throws InterruptedException {
		this.HomePageImagesArrivalsShouldNavigate();
		hP.arrivalImage2click();
		hP.arrivalImg2AddToBasket();
		hP.arrivalsubImg2CartPrice();
	}
	
	@Test(priority=7)     //test7
	public void ArrivalImageAddMoreToBasket() throws InterruptedException {
		this.ArrivalImageAddToBasket();
		hP.arrivalsubImg2CartPriceMax();
		
	}
	

	@AfterClass
	public void tearDown() {
		Driver.tearDown();
	}
}

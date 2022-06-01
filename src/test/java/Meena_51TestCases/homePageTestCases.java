package Meena_51TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MeenaObject.arrivalsPage;
import MeenaObject.homePage;
import MeenaObject.loginPage;
import MeenaObject.registrationPage;
import MeenaObject.shopPage;
import MeenaUtilities.MeenaConstants;
import MeenaUtilities.MeenaDriver;


public class homePageTestCases {

	
	
//	WebDriver driver;
	homePage home = new homePage();
	arrivalsPage arrival = new arrivalsPage();
	loginPage login = new loginPage();
	registrationPage registration = new registrationPage();
	shopPage shop = new shopPage();
	
	
  @BeforeMethod
  public void setup() {
	shop.shopBtn.click();  
	home.homeBtn.click();
  }


  @Test (priority= 1,groups= {"Meena"})
  public void HomePageWithThreeSlidersOnly() {

		home.checkSlidersCount(MeenaConstants.slidersCount);

	}
  
  @Test (priority= 2,groups= {"Meena"})
  public void HomePageWithThreeArrivalsOnly() {

		home.checkArrivalsCount(MeenaConstants.arrivalsCount);
	
  }
  
  @Test(priority= 3 ,groups= {"Meena"})
	public void HomePageImagesArrivalsShouldNavigate() {

		home.checkArrivalsCount(MeenaConstants.arrivalsCount);
		home.verifyImagesInArrivalsShouldNavigate();			
		home.verifyImagesInArrivalsShouldNavigate_URL();

		}
  
  @Test(priority= 4 ,groups= {"Meena"})
		public void ArrivalImagesDescription() {

		home.firstPic.click();
		home.verifyPicDescription();
		}
  
  @Test(priority= 5 ,groups= {"Meena"})
	public void ArrivalImagesReview() {

	  	home.firstPic.click();
	  	arrival.reviewTab.click();
	  	home.clickReviewTap();
  
  }
  
  @Test(priority= 6 ,groups= {"Meena"})
	public void ArrivalImagesAddToBasket() {

		shop.shopBtn.click();
		home.homeBtn.click();
		home.thirdPic.click();
		arrival.addToBasketBtn.click();
		arrival.addToBasket();
		
}
  
  
  
  @AfterClass
  public void afterClass() {
	  
		MeenaDriver.tearDown();
  }

	
	
	
	
}

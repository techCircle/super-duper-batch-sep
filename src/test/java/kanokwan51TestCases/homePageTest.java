package kanokwan51TestCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import kanokwanPageObject.homePage;
import kanokwanUtilities.Constants;
import kanokwanUtilities.KanokwanBaseClass;


public class homePageTest {
	
	homePage hp = new homePage();
	
	@BeforeSuite
		public void setUp() {
			
		 KanokwanBaseClass.getDriver();		
		}
		
	@BeforeMethod
		public void beforeMethod() {
			
			 hp.shopButton();
			 hp.homeButton();
		}
	  
	        
 	  @Test(priority = 1)
	  public void homePageWithThreeSlidersOnly() {
 		  
 		  hp.checkSlidersCount(Constants.slidersCount);
  }
 	  
 	 @Test(priority = 2)
	  public void homePageWithArrivalOnly() {
 		 
 		hp.checkArrivalsCount(Constants.slidersCount);	 
 	 }
 	 
 	@Test(priority = 3)
	  public void homePageImageinArrivalShoulNavigate() {
 		
 		hp.verifyImagesInArrivalsShouldNavigate();
 		hp.verifyImagesInArrivalsShouldNavigate_URL();
 	}
		 
 	@Test(priority = 4)
	  public void homePageArrivalsImageReview() {
 		hp.checkArrivalsCount(Constants.slidersCount);	 
 		hp.verifyNewArrivalsDescription();
 		
 	}
 	
 	@Test(priority = 5)
	  public void homePageArrivalsImageDescription() {
 		hp.checkArrivalsCount(Constants.slidersCount);	
 		hp.verifyNewArrivalsReviews();
 		
 	}

 	  @AfterSuite
 	  public void tearDown() {
 		  
 		  KanokwanBaseClass.tearDown();
 	  }
}

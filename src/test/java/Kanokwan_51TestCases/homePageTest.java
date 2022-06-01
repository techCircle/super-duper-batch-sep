package Kanokwan_51TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import KanokwanObject.homePage;
import KanokwanUtilities.KanokwanBaseClass;


public class homePageTest {
	
	homePage hp = new homePage();
	
		
		   @BeforeClass
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
 		  
 		  hp.checkSlidersCount(3);
  }
 	  
 	 @Test(priority = 2)
	  public void homePageWithArrivalOnly() {
 		 
 		hp.checkArrivalsCount(3);	 
 	 }
 	 
 	@Test(priority = 3)
	  public void homePageImageinArrivalShoulNavigate() {
 		
 		hp.verifyImagesInArrivalsShouldNavigate();
 		hp.verifyImagesInArrivalsShouldNavigate_URL();
 	}
		 
 	@Test(priority = 4)
	  public void homePageArrivalsImageDescription() {
 		
 		hp.picture1();
 		hp.descriptionPicture1Button();
 		KanokwanBaseClass.getDriver().navigate().back();
 		hp.picture2();
 		hp.descriptionPicture2Button();
 		KanokwanBaseClass.getDriver().navigate().back();
 		hp.picture3();
 		hp.descriptionPicture3Button();
 		KanokwanBaseClass.getDriver().navigate().back();
 		

 		
 	}	 
 	  @AfterClass
 	  public void tearDown() {
 		  
 		  KanokwanBaseClass.tearDown();
 	  }
  
}

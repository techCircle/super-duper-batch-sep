package Ratthanon51TestCases;

import org.testng.annotations.AfterClass;




import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import RatthanonPageObject.BasketPage;
import RatthanonPageObject.HomePage;
import RatthanonPageObject.ProductPage;
import RatthanonPageObject.ShopPage;
import RatthanonUtilities.Constants_ratthanon;
import RatthanonUtilities.BaseClass;

public class HomePageTestcase {
	
	HomePage hp = new HomePage();	
	ShopPage sp = new ShopPage();
	BasketPage bk = new BasketPage();
	ProductPage pd = new ProductPage();
	
	@BeforeMethod
	public void beforeClass() {
	
		BaseClass.getDriver();
		hp.ShopMenu.click();
		sp.HomeMenu.click();
	}
	

	
	@Test(priority = 1)
	public void CheckNumSlide(){
		 Assert.assertEquals(hp.slidePicture(), Constants_ratthanon.slidersCount);
	}
	
	
	 @Test(priority = 2)
	  public void ValidateArrival() {
		  Assert.assertEquals(hp.BookArrivals(), Constants_ratthanon.arrivalsCount);
	  }
	 
	  @Test(priority = 3)
	  public void clickableImage() {
		  Assert.assertEquals(hp.BookArrivals(), Constants_ratthanon.arrivalsCount);
		  hp.ClickAbleImage();
	  }
	  
	  
	  @Test(priority = 4)
	  public void ArrivalDescription() throws InterruptedException {
		  Assert.assertEquals(hp.BookArrivals(), Constants_ratthanon.arrivalsCount);
		  hp.VerifyDescription();
	  }
	  
	  @Test(priority = 5)
	  public void ImageReview() throws InterruptedException {
		  Assert.assertEquals(hp.BookArrivals(), Constants_ratthanon.arrivalsCount);
		  hp.ValidateReview();
	  }
	
	 @Test(priority = 6)
	  public void VerifyAddItemToBucket() throws InterruptedException{
		 Assert.assertEquals(hp.BookArrivals(), Constants_ratthanon.arrivalsCount);
		  hp.ValidateReview();
		  hp.verifyAddBusket();	
	  }
	
	 @Test(priority = 7)
	  public void VerifyAddMoreItemToBucket() throws InterruptedException{
		 Assert.assertEquals(hp.BookArrivals(), Constants_ratthanon.arrivalsCount);
		  hp.ValidateReview();
		  hp.verifyAddBusket();	
		  bk.NameProduct.click();
		  
		  pd.verifyAddexceedItems();

	  }
	
	 /*@Test(priority = 8)
	  public void HomeArrivalsAddtoBasketItems() throws InterruptedException{
		  AssertJUnit.assertEquals(hp.BookArrivals(), 3);
		  hp.ValidateReview();
		  hp.verifyAddBusket();	
		  hp.verifyClickItem();
	  }*/
	  
	  

	@AfterClass
	public void afterClass() {
		BaseClass.tearDown();
	}
}

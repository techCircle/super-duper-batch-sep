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
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import RatthanonPageObject.BasketPage;
import RatthanonPageObject.HomePage;
import RatthanonPageObject.ProductPage;
import RatthanonPageObject.ShopPage;
import RatthanonUtilities.Constants_ratthanon;
import RatthanonUtilities.BaseClassR;

public class HomePageTestcase {
	
	HomePage hp = new HomePage();	
	ShopPage sp = new ShopPage();
	BasketPage bk = new BasketPage();
	ProductPage pd = new ProductPage();
	
	@BeforeMethod
	public void beforeClass() {
	
		BaseClassR.getDriver();
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
	  public void clickableImage() throws InterruptedException {
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
	  public void VerifyAddMoreItemMoreBook() throws InterruptedException{
		 Assert.assertEquals(hp.BookArrivals(), Constants_ratthanon.arrivalsCount);
		  hp.ValidateReview();
		  hp.verifyAddBusket();	
		  hp.viewbusket.click();
		  Thread.sleep(1000);
		  bk.NameProduct.click();
		  pd.verifyAddexceedItems();

	  }
	 
	 @Test(priority = 8)
	  public void HomeArrivalsAddtoBasketItems() throws InterruptedException{
		  AssertJUnit.assertEquals(hp.BookArrivals(), 3);
		  //hp.ValidateReview();
		  hp.verifyAddBusket();	
		  hp.verifyClickItem();
	  }
	
	@Test(priority = 9)
	  public void HomeArrivalsAddtoBasketItemsCoupon() throws InterruptedException{
		  AssertJUnit.assertEquals(hp.BookArrivals(), 3);
		  //hp.ValidateReview();
		  hp.verifyAddBusket();	
		  hp.verifyClickItem();
		  
		  // Due to Coupon usage limit for krishnasakinala code then verify with error code
		  bk.ProductCode.sendKeys(Constants_ratthanon.productCode);
		  bk.applycouponButton.click();
		  Assert.assertTrue(bk.errorMaxCoupon.getText().contains(Constants_ratthanon.errorCoupon));		  
		  
	  }
	
	@Test(priority = 10)
	  public void HomeArrivalsAddtoBasketItemsCouponLess450() throws InterruptedException{
		  AssertJUnit.assertEquals(hp.BookArrivals(), 3);
		  //hp.ValidateReview();
		  hp.verifyAddBusket();	
		  hp.verifyClickItem();
		  
		  // Due to Coupon usage limit for krishnasakinala code then verify with error code
		  bk.ProductCode.sendKeys(Constants_ratthanon.productCode);
		  bk.applycouponButton.click();
		  
		  Assert.assertTrue(bk.errorMaxCoupon.getText().contains(Constants_ratthanon.errorCoupon));	
		  //Remove Item
		  bk.removeButton.click();
		  
	  }
	
	@Test(priority = 11)
	  public void HomeArrivalsAddtoBasketRomoveBook() throws InterruptedException{
		  AssertJUnit.assertEquals(hp.BookArrivals(), 3);
		  //hp.ValidateReview();
		  hp.verifyAddBusket();	
		  hp.verifyClickItem();
		  bk.removeButton.click();
		
		  Assert.assertTrue(bk.removeItemMessage.getText().contains(Constants_ratthanon.removeItemMessage));
		  //Assert.assertEquals(bk.removeItemMessage.getText(), Constants_ratthanon.removeItemMessage);
		  
	  }
	
	@Test(priority = 12)
	  public void HomeArrivalsAddtoBasketaddBook() throws InterruptedException{
		  AssertJUnit.assertEquals(hp.BookArrivals(), 3);
		  //hp.ValidateReview();
		  hp.verifyAddBusket();	
		  hp.verifyClickItem();
		  bk.QuantityInput.sendKeys(Keys.ARROW_UP);
		  Assert.assertTrue(bk.updateCartButton.isEnabled());
		  bk.updateCartButton.click();
		  Assert.assertEquals(bk.updateBasketMessage.getText(), Constants_ratthanon.UpdateBasketMessage);
		  
	  }
	/*
	@Test(priority = 13)
	  public void HomeArrivalsAddtoBasketaddBook() throws InterruptedException{
		  AssertJUnit.assertEquals(hp.BookArrivals(), 3);
		  //hp.ValidateReview();
		  hp.verifyAddBusket();	
		  hp.verifyClickItem();
		  
	  }
	  */
	
	
	  
	  

	@AfterClass
	public void afterClass() {
		BaseClassR.tearDown();
	}
}

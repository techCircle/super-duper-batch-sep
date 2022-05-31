package Ratthanon51TestCases;

import org.testng.annotations.AfterClass;


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

import RatthanonPageObject.HomePage;
import RatthanonPageObject.ProductCategory;
import RatthanonPageObject.ProductPage;
import RatthanonPageObject.ShopPage;
import RatthanonUtilities.Constants_ratthanon;
import RatthanonUtilities.BaseClass;

public class ShopTestCase {
	
	HomePage hp = new HomePage();
	ShopPage sp = new ShopPage();
	ProductCategory pc = new ProductCategory();
	ProductPage pp = new ProductPage();
	
	@BeforeMethod
	public void beforeClass() {
		BaseClass.getDriver();
	}

	@Test(priority = 1)
	public void VerifyPriceFunction() {
		hp.ShopMenu.click();
		sp.SlideTabPriceRight(Constants_ratthanon.slideNumber);
		AssertJUnit.assertTrue(sp.textPrice.getText().contains("₹150 — ₹450"));
		sp.filterButton.click();
		Assert.assertTrue(sp.verifyBookPrice() <= 450);

	}

	@Test(priority = 2)
	public void VerifyCatagoeyFunction(){
		hp.ShopMenu.click();

		String catagory = sp.linkproduct.getText();
		sp.linkproduct.click();
		Assert.assertTrue(pc.verifyProduct(catagory));

	}
	

	@Test(priority = 3)
	public void VerifyPopularity(){
		  hp.ShopMenu.click();
		  sp.SelectSorting(Constants_ratthanon.Popularity_item);
		  Assert.assertTrue(BaseClass.getDriver().getCurrentUrl().contains(Constants_ratthanon.Popularity_item));
		 				 
		  
	}
	
	@Test(priority = 4)
	public void VerifyRating(){
		  hp.ShopMenu.click();
		  sp.SelectSorting(Constants_ratthanon.Averageratings);
		  Assert.assertTrue(BaseClass.getDriver().getCurrentUrl().contains(Constants_ratthanon.Averageratings ));		 				 
		  
	}
	
	@Test(priority = 5)
	public void VerifyNewDate() {
		  hp.ShopMenu.click();
		  sp.SelectSorting(Constants_ratthanon.Newnessratings);
		  Assert.assertTrue(BaseClass.getDriver().getCurrentUrl().contains(Constants_ratthanon.Newnessratings));		 				 
		  
	}
	
	@Test(priority = 6)
	public void VerifyLoToHiPrice(){
		  hp.ShopMenu.click();
		  sp.SelectSorting(Constants_ratthanon.LowtoHigh);
		  Assert.assertTrue(BaseClass.getDriver().getCurrentUrl().contains(Constants_ratthanon.LowtoHigh));		 				 
		  
	}
	
	@Test(priority = 7)
	public void VerifyHiToLoPrice() {
		  hp.ShopMenu.click();
		  sp.SelectSorting(Constants_ratthanon.HightoLow);
		  Assert.assertTrue(BaseClass.getDriver().getCurrentUrl().contains(Constants_ratthanon.HightoLow));
	}
	
	@Test(priority = 8)
	public void VesrifyOutofStock() {
		  hp.ShopMenu.click();
		  sp.readmoreButton.click();
		  Assert.assertTrue(sp.itemprice.getText().contains("Out of stock"));
			
		  
	}
	
	@Test(priority = 9)
	public void SortFunctionalOnsale(){
		  hp.ShopMenu.click();
		  sp.itemsale.click();
		  Assert.assertTrue(pp.salelogo.isDisplayed() && pp.deleteprice.isDisplayed());			
		  
	}
	
	

	@AfterClass
	public void afterClass() {
		BaseClass.tearDown();
	}
}

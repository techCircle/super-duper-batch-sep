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

import RatthanonPageObject.AccoutDetail;
import RatthanonPageObject.BasketPage;
import RatthanonPageObject.CheckoutPage;
import RatthanonPageObject.HomePage;
import RatthanonPageObject.MyAccountPage;
import RatthanonPageObject.ProductCategory;
import RatthanonPageObject.ProductPage;
import RatthanonPageObject.ShopPage;
import RatthanonUtilities.Constants_ratthanon;
import RatthanonUtilities.BaseClassR;

public class ShopTestCase {
	
	HomePage hp = new HomePage();
	ShopPage sp = new ShopPage();
	ProductCategory pc = new ProductCategory();
	ProductPage pp = new ProductPage();
	CheckoutPage ch = new CheckoutPage();
	BasketPage bk = new BasketPage();
	AccoutDetail ac = new AccoutDetail();
	MyAccountPage ma = new MyAccountPage();
	
	
	@BeforeMethod
	public void beforeClass() {
		BaseClassR.getDriver();
		hp.ShopMenu.click();
	}
    
	@Test(priority = 1)
	public void VerifyPriceFunction() {
		sp.SlideTabPriceRight(Constants_ratthanon.slideNumber);
		AssertJUnit.assertTrue(sp.textPrice.getText().contains(Constants_ratthanon.booklowMaxPraice));
		sp.filterButton.click();
		Assert.assertTrue(sp.verifyBookPrice() <= Constants_ratthanon.bookPrice);

	}

	@Test(priority = 2)
	public void VerifyCatagoeyFunction(){
		String catagory = sp.linkproduct.getText();
		sp.linkproduct.click();
		Assert.assertTrue(pc.verifyProduct(catagory));

	}
	

	@Test(priority = 3)
	public void VerifyPopularity(){
		  sp.SelectSorting(Constants_ratthanon.Popularity_item);
		  Assert.assertTrue(BaseClassR.getDriver().getCurrentUrl().contains(Constants_ratthanon.Popularity_item));
		 				 
		  
	}
	
	@Test(priority = 4)
	public void VerifyRating(){
		  sp.SelectSorting(Constants_ratthanon.Averageratings);
		  Assert.assertTrue(BaseClassR.getDriver().getCurrentUrl().contains(Constants_ratthanon.Averageratings ));		 				 
		  
	}
	
	@Test(priority = 5)
	public void VerifyNewDate() {
		  sp.SelectSorting(Constants_ratthanon.Newnessratings);
		  Assert.assertTrue(BaseClassR.getDriver().getCurrentUrl().contains(Constants_ratthanon.Newnessratings));		 				 
		  
	}
	
	@Test(priority = 6)
	public void VerifyLoToHiPrice(){
		  sp.SelectSorting(Constants_ratthanon.LowtoHigh);
		  Assert.assertTrue(BaseClassR.getDriver().getCurrentUrl().contains(Constants_ratthanon.LowtoHigh));		 				 
		  
	}
	
	@Test(priority = 7)
	public void VerifyHiToLoPrice() {
		  sp.SelectSorting(Constants_ratthanon.HightoLow);
		  Assert.assertTrue(BaseClassR.getDriver().getCurrentUrl().contains(Constants_ratthanon.HightoLow));
	}
	
	@Test(priority = 8)
	public void VesrifyOutofStock() {
		  sp.readmoreButton.click();
		  Assert.assertTrue(sp.itemprice.getText().contains("Out of stock"));
			
		  
	}
	
	
	@Test(priority = 9)
	public void SortFunctionalOnsale(){
		  sp.itemsale.click();
		  Assert.assertTrue(pp.salelogo.isDisplayed() && pp.deleteprice.isDisplayed());			
		  
	}
	
	
	@Test(priority = 10)
	public void ShopAddBasketFunctionality() throws InterruptedException{	
		sp.addBasket();   
		sp.viewBasket.click();	
        Assert.assertTrue(bk.NameProduct.isDisplayed() && bk.PriceProduct.isDisplayed());
        bk.verifyTotalAndSubTotal();
        bk.ProceedCheckButton.click();
        Assert.assertTrue(BaseClassR.getDriver().getCurrentUrl().contains("checkout") && ch.checkOutText.getText().contains(Constants_ratthanon.checkOutPage));
        ch.VerifyBilling();
        ch.verifyMakeOrder();
				  
	}
	
	@Test(priority = 11)
	public void ShopAddBasketwithItemlink() throws InterruptedException{	
		sp.addBasket();   
		sp.ItemDisplayPrice.click();
        Assert.assertTrue(bk.NameProduct.isDisplayed() && bk.PriceProduct.isDisplayed());
        bk.verifyTotalAndSubTotal();
        bk.ProceedCheckButton.click();
        Assert.assertTrue(BaseClassR.getDriver().getCurrentUrl().contains("checkout") && ch.checkOutText.getText().contains(Constants_ratthanon.checkOutPage));
        ch.VerifyBilling();
        ch.verifyMakeOrder();
				  
	}
	
	@Test(priority = 12)
	public void ShopAddBasketandTax() throws InterruptedException{	
		sp.addBasket();   
		sp.ItemDisplayPrice.click();
        Assert.assertTrue(bk.NameProduct.isDisplayed() && bk.PriceProduct.isDisplayed());
        bk.verifyTotalAndSubTotal();
        bk.verifyTax();
        hp.MyAccountMenu.click();
        ma.LoginvalidUser();
        ac.ChangeAddress(Constants_ratthanon.indianame);
        ac.cartLink.click();
        bk.verifyTax();
        hp.MyAccountMenu.click();
        ac.ChangeAddress(Constants_ratthanon.usaname);
        
				  
	}

	

	@AfterClass
	public void afterClass() {
		BaseClassR.tearDown();
	}
}

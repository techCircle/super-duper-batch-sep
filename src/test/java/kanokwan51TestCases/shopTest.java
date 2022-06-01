package kanokwan51TestCases;


import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import kanokwanPageObject.shopPage;
import kanokwanUtilities.KanokwanBaseClass;

public class shopTest {
	
	   shopPage sp = new shopPage();
	
	   @BeforeSuite
	   public void setUp() {
		
	      KanokwanBaseClass.getDriver();		
	}
	
	   @BeforeMethod
	   public void beforeMethod() {
		
		  sp.shopMenuButton();
	}
	
	   @Test(priority = 1)
	   public void shop_FilterByPrice() {
		
		sp.sliderBar();
	}

	   @Test(priority = 2)
	   public void shop_ProductCategories() {
		
		sp.functionalProduct();
		sp.verifyFunctionalProductText();	
	}
	   
	   @Test(priority = 3)
	   public void shop_DefaultSorting_SortByPopularity() {
		   
		   sp.sortByPopularity();
	  }
	   
	   @Test(priority = 4)
	   public void shop_SortByAverageRatings() {
		   
		   sp.sortByAverageRatings();
	   }
	   
	   @Test(priority = 5)
	   public void shop_SortByNewness() {
		   
		   sp.verifySortByNewness();
	   }
	
	   @Test(priority = 6)
	   public void shop_SortByLowToHigh() {
		   
		   sp.verifySortByLowToHigh();
	   }

	   @Test(priority = 7)
	   public void shop_SortByHighToLow() {
		   
		   sp.verifySortByHighToLow();
	   }
	   
	   @Test(priority = 8)
	   public void shop_ReadMore() {
		   
		   sp.readMoreSeleniumRuby();	   
	   }
	   
	   @Test(priority = 9)
	   public void shop_Sale() {
		   
		   sp.saleProductButton();
		   sp.verifySaleProduct();		   
	   }
	
	   @Test(priority = 10)
	   public void shop_AddToBasket() throws InterruptedException {
		 
		   sp.addToBasketButton();
		   sp.viewBasketButton();
		   sp.verifyCartItemsProduct();
		   sp.verifyCartSubtotal();
		   sp.verifycartTotal();
		   sp.proceedToCheckoutButton();
		   sp.verifyDetailsCheckout();
		   sp.fillingDetailsCheckoutForm();
		   Thread.sleep(3000);
		   sp.verifyOrderCompleted();
	   }
	   
	   
	   @AfterSuite
	   public void tearDown() {

		KanokwanBaseClass.tearDown();
	}

}

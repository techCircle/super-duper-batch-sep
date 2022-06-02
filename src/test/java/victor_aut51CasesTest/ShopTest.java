package victor_aut51CasesTest;

import org.testng.annotations.Test;

import victor.automationTesting.pages.MyAccountPage;
import victor.automationTesting.pages.homePage;
import victor.automationTesting.pages.shopPage;
import victor.utilities.Victor_BaseClass;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class ShopTest {
	homePage hP = new homePage ();
	shopPage sP = new shopPage ();
	
	@BeforeMethod
	public void setUp() {
	Victor_BaseClass.getDriver();
	hP.shopbutton.click();

	
	}
	
	@Test(priority= 1, enabled = true)
	public void ShopFilterByPriceFunctionality () {
		hP.shopbutton.click();
		sP.Slider();
	}
	
	@Test(priority= 2, enabled = false)
	public void ShopProductCategoriesFunctionality () {
		
	}
	
	
	@AfterMethod
	 public void tearDown() {
	   
	 }
}
//1. Shop-Filter By Price Functionality
//2. Shop-Product Categories Functionality
//3. Shop-Default Sorting Functionality
//4. Shop-Default Sorting Functionality
//5. Shop-Default Sorting Functionality
//6. Shop-Default Sorting Functionality
//7. Shop-Default Sorting Functionality
//8. Shop-Read More Functionality
//9. Shop-Sale Functionality
//10. Shop-Add to Basket-View Basket Functionality
//11.Shop-Add to Basket-View Basket through Item link
//12. Shop-Add to Basket-View Basket-Tax Functionality

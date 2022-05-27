package SeleniumDay12_13;

import java.util.concurrent.TimeUnit;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Utilities.BaseClass;
import pages.CheckoutPage;
import pages.inventoryPage;
import pages.loginPage;

public class checkoutCartTest {
	
	loginPage lp = new loginPage();
	inventoryPage ip = new inventoryPage();
	CheckoutPage cp = new CheckoutPage();


	@BeforeMethod
	public void setUp() {
		
		BaseClass.getDriver();
		BaseClass.getDriver().get(BaseClass.getUserDataProperty("swaglabUrl"));
		BaseClass.getDriver().manage().window().maximize();
		BaseClass.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testOrderConfirmation() {

		//login
		lp.standard_user_login();
		
		//add 3 items 
		ip.tShirt.click();
		ip.bikeLight.click();
		ip.slbackpack.click();	
		ip.shoppingCart.click();
		
		
		cp.chkout();
		
		
		
		
		
		
		
		
		
		
	}

}

package Emmie_SauceDemoCase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Emmie_SauceDemoCase.CartPage;
import Emmie_SauceDemoCase.CheckoutCompletePage;
import Emmie_SauceDemoCase.CheckoutStepOnePage;
import Emmie_SauceDemoCase.CheckoutStepTwoPage;
import Emmie_SauceDemoCase.InventoryPage;
import Emmie_SauceDemoCase.LoginPage;
import Emmie_Utilities.Driver;

public class LoginTestCases {

	LoginPage lp = new LoginPage();
	InventoryPage inventory = new InventoryPage();
	CartPage cp = new CartPage();
	CheckoutStepOnePage checkout = new CheckoutStepOnePage();
	CheckoutStepTwoPage checkout2 = new CheckoutStepTwoPage();
	CheckoutCompletePage complete = new CheckoutCompletePage();

	@BeforeMethod
	public void setUp() {

		Driver.getDriver();
	}

	@Test
	public void TC001Login() {
		lp.login();

	}

	@Test
	public void TC002VerifyProducts() {

		inventory.verifyProductsList();

	}

	@Test
	public void TC003AddToCart() {
		inventory.addCart();
	}

	@Test
	public void TC004VerifyItems() {
		cp.verifyItems();
	}

	@Test
	public void TC005VerifyCheckoutTitle() {

		checkout.verifyYourInfo();

	}

	@Test
	public void TC006InputInfo() {

		checkout.infoFill();
	}

	@Test
	public void TC007VerifySummaryInfo() {

		checkout2.verifySummaryInfo();
	}

	@Test
	public void TC008ClickFinishBtn() {

		checkout2.fnclick();
	}

	@Test
	public void TC009VerifyTitle() {
		complete.verifyComplete();
	}

	@AfterClass
	public void tearDown() {
		Driver.tearDown();

	}

}

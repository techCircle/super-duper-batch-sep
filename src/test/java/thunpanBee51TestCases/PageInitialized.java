package thunpanBee51TestCases;

import thunpanBee51TestCasesPageObj.AccountPageObj;
import thunpanBee51TestCasesPageObj.BasketObj;
import thunpanBee51TestCasesPageObj.CheckoutPageObj;
import thunpanBee51TestCasesPageObj.HomePageObj;
import thunpanBee51TestCasesPageObj.OrderRecievedObj;
import thunpanBee51TestCasesPageObj.ProductPageObj;
import thunpanBee51TestCasesPageObj.ShopObjPage;

public class PageInitialized {

	protected static HomePageObj homepage;
	protected static ShopObjPage shop;
	protected static ProductPageObj productPage;
	protected static BasketObj basketPage;
	protected static CheckoutPageObj coPage;
	protected static OrderRecievedObj orderRecieved;
	protected static AccountPageObj accPage;
	

	public static void init() {
		homepage = new HomePageObj();
		shop = new ShopObjPage();
		productPage = new ProductPageObj();
		basketPage = new BasketObj();
		coPage = new CheckoutPageObj();
		orderRecieved = new OrderRecievedObj();
		accPage = new AccountPageObj();
		
	}
	
}

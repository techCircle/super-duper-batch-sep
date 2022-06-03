package maria.MyAccountTestRunner;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import maria.MyAccountObjects.MyAccountDashBoardPage;
import maria.MyAccountObjects.MyAccountPageObject;
import maria.MyAccountObjects.MyAccountViewAccount;
import maria.MyAccountObjects.MyAccountsEditAddressPage;
import maria.MyAccountObjects.MyAccountsEditAddressShippingPage;
import maria.MyAccountObjects.MyAccountsViewOrderPage;
import maria.MyAccountObjects.myAccountOrderPage;
import mariaUtilities.Driver;

public class MyAccountTests {

	MyAccountPageObject map=new MyAccountPageObject();
	MyAccountDashBoardPage mapdash=new MyAccountDashBoardPage();
	myAccountOrderPage myAOrder=new myAccountOrderPage();
	MyAccountsViewOrderPage mAviewOP=new MyAccountsViewOrderPage();
	MyAccountsEditAddressPage mAEditAddress=new MyAccountsEditAddressPage();
	MyAccountsEditAddressShippingPage mAEShipA=new MyAccountsEditAddressShippingPage();
	MyAccountViewAccount mAcVAc=new MyAccountViewAccount();


	@BeforeClass 
	public void beforeClass() {
		Driver.getDriver();
		System.out.println("Before class");
	}
	//changes to push
//	@BeforeMethod
//	public void setUp() {
//		Driver.getDriver();}


	@AfterMethod
	public void afterMethod() {
		Driver.tearDown();
	}


	@Test

	public void My1AccountDashBoard() throws InterruptedException {
		map.clickMyAccount();
		mapdash.dashBoardPageVerify();
	

		
		mapdash.orderLinkBtnClick();
		myAOrder.orderclick();//display assert

	

		myAOrder.viewBTNclick();
		mAviewOP.viewOrderDetails();

	
		mAviewOP.orderStatusAndnumber();

	}

	@Test

	public void My5AccountAddressFunc1() throws InterruptedException {
		map.clickMyAccount();
		mapdash.dashBoardPageVerify();
		mapdash.MyAccountLinkClik();
		Thread.sleep(2000);
		mapdash.addressBtnClick();
		mAEditAddress.verifyingbillingAndshipAddress();

	}


	@Test

	public void My6AccountAddressFunc2() throws InterruptedException {
		map.clickMyAccount();
		mapdash.dashBoardPageVerify();
		mapdash.MyAccountLinkClik();
		mapdash.addressBtnClick();
		mAEditAddress.editShipAddressClick();
		mAEShipA.editShippingaddress();



	}

	@Test


	public void My7accountDetails () throws InterruptedException {
		map.clickMyAccount();
		mapdash.dashBoardPageVerify();
		mapdash.MyAccountLinkClik();
		mapdash.AccountDetailsBTNClick();
		mAcVAc.editAccountDetails();
	}	

	@Test


	public void My8accountlogout () throws InterruptedException {
		map.clickMyAccount();
		mapdash.dashBoardPageVerify();
		mapdash.MyAccountLinkClik();
		mapdash.LogoutButtonClick();
		map.homePageDisplay();
	}




}

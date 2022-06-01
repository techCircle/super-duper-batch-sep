package maria.MyAccountTestRunner;

import org.testng.annotations.Test;

import Utilities.Driver;
import maria.MyAccountObjects.MyAccountDashBoardPage;
import maria.MyAccountObjects.MyAccountPageObject;
import maria.MyAccountObjects.MyAccountViewAccount;
import maria.MyAccountObjects.MyAccountsEditAddressPage;
import maria.MyAccountObjects.MyAccountsEditAddressShippingPage;
import maria.MyAccountObjects.MyAccountsViewOrderPage;
import maria.MyAccountObjects.myAccountOrderPage;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

public class MyAccountTests {

	MyAccountPageObject map=new MyAccountPageObject();
	MyAccountDashBoardPage mapdash=new MyAccountDashBoardPage();
	myAccountOrderPage myAOrder=new myAccountOrderPage();
	MyAccountsViewOrderPage mAviewOP=new MyAccountsViewOrderPage();
	MyAccountsEditAddressPage mAEditAddress=new MyAccountsEditAddressPage();
	MyAccountsEditAddressShippingPage mAEShipA=new MyAccountsEditAddressShippingPage();
	MyAccountViewAccount mAcVAc=new MyAccountViewAccount();


	@BeforeClass public void beforeClass() {
		System.out.println("Before class");
	}
	//changes to push
	@BeforeMethod
	public void setUp() {
		Driver.getDriver();}


	@AfterClass
	public void afterMethod() {
		Driver.tearDown();
	}


	@Test

	public void MyAccountDashBoard() {
		map.clickMyAccount();
		mapdash.dashBoardPageVerify();
	}

	@Test

	public void MyAccountOrders() {

		map.clickMyAccount();
		mapdash.dashBoardPageVerify();
		mapdash.orderLinkBtnClick();
		myAOrder.orderclick();

	}


	@Test

	public void MyAccountOrders2() {
		this.MyAccountOrders();

		myAOrder.viewBTNclick();
		mAviewOP.viewOrderDetails();

	}



	@Test

	public void MyAccountOrders3() {
		this.MyAccountOrders2();
		mAviewOP.orderStatusAndnumber();


	}

	@Test

	public void MyAccountAddressFunc1() {
		this.MyAccountDashBoard();
		mapdash.MyAccountLinkClik();
		mapdash.addressBtnClick();
		mAEditAddress.verifyingbillingAndshipAddress();

	}


	@Test

	public void MyAccountAddressFunc2() throws InterruptedException {
		this.MyAccountDashBoard();
		mapdash.MyAccountLinkClik();
		mapdash.addressBtnClick();
		mAEditAddress.editShipAddressClick();
		mAEShipA.editShippingaddress();



	}

	@Test


	public void accountDetails () {
		this.MyAccountDashBoard();
		mapdash.MyAccountLinkClik();
		mapdash.AccountDetailsBTNClick();
		mAcVAc.editAccountDetails();
	}	

	@Test


	public void accountlogout () {
		this.MyAccountDashBoard();
		mapdash.MyAccountLinkClik();
		mapdash.LogoutButtonClick();
		map.homePageDisplay();
	}




}

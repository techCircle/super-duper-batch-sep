package com.MyAccountTestRunner;

import org.testng.annotations.Test;

import com.MyAccountObjects.MyAccountDashBoardPage;
import com.MyAccountObjects.MyAccountPageObject;
import com.MyAccountObjects.MyAccountViewAccount;
import com.MyAccountObjects.MyAccountsEditAddressPage;
import com.MyAccountObjects.MyAccountsEditAddressShippingPage;
import com.MyAccountObjects.MyAccountsViewOrderPage;
import com.MyAccountObjects.myAccountOrderPage;

import Utilities.Driver;

import org.testng.annotations.BeforeMethod;
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


	@BeforeMethod

	public void setUp() {
		Driver.getDriver();
	}
	@AfterMethod
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

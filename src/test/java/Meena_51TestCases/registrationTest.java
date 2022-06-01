package Meena_51TestCases;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import MeenaObject.homePage;
import MeenaObject.shopPage;
import MeenaUtilities.MeenaDriver;

public class registrationTest {

	shopPage shop = new shopPage();
	homePage home = new homePage();
	
	
	
	@BeforeMethod
	public void setup() {
		shop.shopBtn.click();
	}
	
	@Test(priority=1 , groups= {"Meena"})
	public void filterByPrice(){
		
		shop.filterBtn.click();
		shop.moveFilter();
		shop.verifyValue();
	}

	@Test(priority=2 , groups= {"Meena"})
	public void productCategories(){
		
		shop.productCategories.click();
		shop.verifyChosenProductCategority();
		
	}
	
	@Test(priority=3 , groups= {"Meena"})
	public void defaultSortingPopularity() throws InterruptedException{
		
		shop.selectSortingPopularity();
		shop.verifyPopularity();

	}
	
	@Test(priority=4 , groups= {"Meena"})
	public void defaultSortingAverage() throws InterruptedException{
		
		shop.selectSortingAverage();
		shop.verifyAverage();
	
	}
		
	@Test(priority=5 , groups= {"Meena"})
	public void defaultSortingNewness() throws InterruptedException{
		
		shop.selectSortingNewness();
		shop.verifyNewness();
		
	}
	
	@Test(priority=6 , groups= {"Meena"})
	public void defaultSortingPriceHighToLow() throws InterruptedException{
		
		shop.selectSortingPriceHighToLow();
		shop.verifyPriceHighToLow();
	}
	
	@Test(priority=7 , groups= {"Meena"})
	public void defaultSortingPriceLowToHigh() throws InterruptedException{
		
		shop.selectSortingPriceLowToHigh();
		shop.verifyPriceLowToHigh();
		
	}
	
	@Test(priority=8 , groups= {"Meena"})
	public void verifyReadMore(){
		
		home.homeBtn.click();
		home.readMore.click();
		home.readMoreFunction();
		home.verifyItemCanNotBeAdd();
	}
	
	@Test(priority=9 , groups= {"Meena"})
	public void saleFunctionality(){
		
		shop.onSaleProduct.click();
		shop.verifyOnSalePrice();
		
	}
	
	
	
	
	
	
	@AfterClass
	public void teardown() {
		MeenaDriver.tearDown();
	}
	
	
}

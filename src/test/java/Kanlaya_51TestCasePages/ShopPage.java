package Kanlaya_51TestCasePages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Kanlaya_51TestCaseUtilities.Base;

public class ShopPage {
	
	
	public ShopPage() {
		PageFactory.initElements(Base.getDriver(), this);
		
	}

	
	// SHOP

	@FindBy(xpath = "//div[@id='content']/nav/a")
	public WebElement homeButton;


}
